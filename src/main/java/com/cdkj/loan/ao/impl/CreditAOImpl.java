package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632099Req;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632110ReqCreditUser;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632111ReqCreditUser;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632112ReqCreditUser;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.dto.req.XN632119Req;
import com.cdkj.loan.dto.res.XN632917Res;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.ELoanRole;
import com.cdkj.loan.enums.ENewBizType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.enums.ESysRole;
import com.cdkj.loan.exception.BizException;

/**
 * 征信
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:09:48 
 * @history:
 */
@Service
public class CreditAOImpl implements ICreditAO {

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Override
    @Transactional
    public String addCredit(XN632110Req req) {
        SYSUser sysUser = sysUserBO.getUser(req.getOperator());
        if (StringUtils.isBlank(sysUser.getPostCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "您还未设置职位，暂无法使用征信申请");
        }

        if (StringUtils.isBlank(sysUser.getTeamCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "您还未设置团队，暂无法申请!");
        }

        // 新建业务单
        String bizCode = cdbizBO.saveCdbiz(req.getLoanBankCode(),
            req.getBizType(), StringValidater.toLong(req.getLoanAmount()),
            req.getOperator(), sysUser.getTeamCode());

        ENode currentNode = ENode.new_credit;
        // 设置节点
        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            currentNode = ENode.getMap().get(
                nodeFlowBO.getNodeFlowByCurrentNode(ENode.new_credit.getCode())
                    .getNextNode());
            // 修改业务主状态
            cdbizBO.refreshStatus(cdbizBO.getCdbiz(bizCode),
                ECdbizStatus.A1.getCode());
        }
        // 新增征信单
        String creditCode = creditBO.saveCredit(req, sysUser, bizCode,
            currentNode.getCode());
        // 新增征信人员
        List<XN632110ReqCreditUser> childList = req.getCreditUserList();
        int applyUserCount = 0;// 申请人角色条数
        if (CollectionUtils.isNotEmpty(childList)) {
            for (XN632110ReqCreditUser child : childList) {
                if (ELoanRole.APPLY_USER.getCode().equals(child.getLoanRole())) {
                    applyUserCount++;

                    creditBO.setApplyUserInfo(creditCode, child.getUserName(),
                        child.getMobile(), child.getIdNo());// 征信单设置客户姓名（征信人员的申请人）
                }
                if (applyUserCount > 1) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "征信申请人只能填写一条数据");
                }

                creditUserBO.saveCreditUser(child, creditCode, bizCode);
            }

            if (applyUserCount <= 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "请填写征信申请人贷款角色数据");
            }
        }

        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            // 操作日志
            sysBizLogBO.recordCurOperate(bizCode, EBizLogType.CREDIT,
                creditCode, currentNode.getCode(), req.getNote(),
                sysUser.getUserId());
        }
        // 待办事项
        bizTaskBO.saveBizTask(bizCode, EBizLogType.CREDIT, creditCode,
            currentNode, req.getOperator());

        return creditCode;
    }

    @Override
    @Transactional
    public void distributeLeaflets(XN632119Req req) {

        Credit credit = creditBO.getCredit(req.getCreditCode());
        Cdbiz cdbiz = cdbizBO.getCdbiz(credit.getBizCode());
        if (!ECdbizStatus.A1.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A1x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前征信单不能派单！");
        }
        // 修改内勤
        creditBO.distributeLeaflets(credit, req.getInsideJob());
        // 删除前待办事项
        bizTaskBO.removeUnhandleBizTask(cdbiz.getCode(),
            ENode.input_credit.getCode());
        // 新增该内勤的待办事项
        bizTaskBO.saveBizTask(cdbiz.getCode(), EBizLogType.CREDIT,
            credit.getCode(), ENode.input_credit, req.getInsideJob());

    }

    @Override
    @Transactional
    public void editCredit(XN632112Req req) {
        Credit credit = creditBO.getCredit(req.getCreditCode());
        if (null == credit) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据征信单编号查询不到征信单");
        }
        Cdbiz cdbiz = cdbizBO.getCdbiz(credit.getBizCode());
        if (!ECdbizStatus.A1x.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A0.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该业务不处于征信审核不通过或新录状态状态，无法修改征信");
        }

        String bizCode = credit.getBizCode();
        // 删除之前的附件
        attachmentBO.removeBizAttachments(bizCode);

        if (ENewBizType.second_hand.getCode().equals(req.getBizType())) {

            // 二手车报告
            EAttachName attachName = EAttachName.getMap().get(
                EAttachName.second_car_report.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getSecondCarReport());
            // 行驶证正面
            attachName = EAttachName.getMap().get(
                EAttachName.xsz_front.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getXszFront());
            // 行驶证反面
            attachName = EAttachName.getMap().get(
                EAttachName.xsz_reverse.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getXszReverse());
        }
        // 之前节点
        String preCurNodeCode = credit.getCurNodeCode();
        ENode node = ENode.getMap().get(preCurNodeCode);
        // 更新当前节点
        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            // 操作日志
            sysBizLogBO.recordCurOperate(credit.getBizCode(),
                EBizLogType.CREDIT, credit.getCode(), node.getCode(),
                node.getValue(), req.getOperator());
            // 处理之前的待办事项
            bizTaskBO.handlePreBizTask(EBizLogType.CREDIT.getCode(),
                credit.getCode(), node);
            NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(credit
                .getCurNodeCode());

            preCurNodeCode = nodeFlow.getNextNode();
            credit.setCurNodeCode(preCurNodeCode);
            // 修改业务主状态
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A1.getCode());
            // 确认节点
            node = ENode.getMap().get(preCurNodeCode);

        }
        // 修改征信单
        credit.setLoanBankCode(req.getLoanBankCode());
        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        credit.setSecondCarReport(req.getSecondCarReport());
        credit.setXszFront(req.getXszFront());
        credit.setXszReverse(req.getXszReverse());
        credit.setBizType(req.getBizType());
        credit.setSaleUserId(req.getOperator());
        creditBO.refreshCredit(credit);

        // 删除
        creditUserBO.removeCreditUserByCreditCode(credit.getCode());

        List<XN632112ReqCreditUser> childList = req.getCreditUserList();
        int applyUserCount = 0;
        if (CollectionUtils.isNotEmpty(childList)) {
            for (XN632112ReqCreditUser child : childList) {
                if (ELoanRole.APPLY_USER.getCode().equals(child.getLoanRole())) {
                    applyUserCount++;
                }
                if (applyUserCount > 1) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "征信申请人只能填写一条数据");
                }

                creditUserBO.saveCreditUser(child, credit.getCode(),
                    credit.getBizCode());
            }

            if (applyUserCount <= 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "请填写征信申请人贷款角色数据");
            }
        }

        // 待办事项
        bizTaskBO.saveBizTask(credit.getBizCode(), EBizLogType.CREDIT,
            credit.getCode(), node, req.getOperator());

    }

    @Override
    public Credit getCredit(String creditCode) {
        Credit credit = creditBO.getCredit(creditCode);
        initCredit(credit);
        return credit;
    }

    @Override
    public Credit getCreditAndCreditUser(String code) {
        Credit credit = creditBO.getCredit(code);

        initCredit(credit);

        return credit;
    }

    @Override
    public Paginable<Credit> queryCreditPage(int start, int limit,
            Credit condition) {
        Paginable<Credit> paginable = creditBO.getPaginable(start, limit,
            condition);
        List<Credit> list = paginable.getList();
        for (Credit credit : list) {
            initCredit(credit);
        }
        return paginable;
    }

    @Override
    public Paginable<Credit> queryCreditPageByRoleCode(int start, int limit,
            Credit condition, String userId) {
        if (ESysRole.LEADER.getCode().equals(condition.getRoleCode())) {
            SYSUser user = sysUserBO.getUser(userId);
            if (user.getTeamCode() != null) {
                condition.setTeamCode(user.getTeamCode());
            }
        }
        if (ESysRole.SALE.getCode().equals(condition.getRoleCode())) {
            condition.setSaleUserId(userId);
        }
        if (ESysRole.YWNQ.getCode().equals(condition.getRoleCode())) {
            condition.setInsideJob(userId);
        }

        Paginable<Credit> result = creditBO.getPaginableByRoleCode(start,
            limit, condition);
        List<Credit> list = result.getList();
        for (Credit credit : list) {
            initCredit(credit);
        }
        return result;
    }

    @Override
    @Transactional
    public void audit(XN632113Req req) {
        Credit credit = creditBO.getMoreCredit(req.getCode());

        Cdbiz cdbiz = cdbizBO.getCdbiz(credit.getBizCode());
        sysUserBO.getUser(req.getOperator());
        // 业务状态判断
        if (!ECdbizStatus.A2.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该业务不处于待审核征信状态");
        }

        // 当前节点
        String preCurrentNode = credit.getCurNodeCode();

        // 审核通过
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            for (CreditUser creditUser : req.getCreditUserList()) {
                CreditUser user = creditUserBO.getCreditUser(creditUser
                    .getCode());
                user.setRelation(creditUser.getRelation());
                user.setLoanRole(creditUser.getLoanRole());
                creditUserBO.refreshCreditUserLoanRole(user);
                if (ELoanRole.APPLY_USER.getCode().equals(
                    creditUser.getLoanRole())) {
                    // 主贷人=业务人
                    creditBO.setApplyUserInfo(req.getCode(),
                        creditUser.getUserName(), creditUser.getMobile(),
                        creditUser.getIdNo());
                }
            }

            // 审核通过，改变节点
            credit.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                credit.getCurNodeCode()).getNextNode());
            // 修改业务状态
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A3.getCode());
            // 业务出现面签状态
            cdbizBO.refreshMqStatus(cdbiz, ECdbizStatus.B00.getCode());
            // 保存准入单
            String budgetCode = budgetOrderBO.saveBudgetOrder(credit,
                req.getCreditUserList());

            // 准入单开始的待办事项
            bizTaskBO.saveBizTask(credit.getBizCode(),
                EBizLogType.BUDGET_ORDER, budgetCode, ENode.input_budget,
                req.getOperator());

            // 面签开始的待办事项
            bizTaskBO.saveBizTask(credit.getBizCode(), EBizLogType.INTERVIEW,
                budgetCode, ENode.input_interview, req.getOperator());

        } else {
            credit.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                credit.getCurNodeCode()).getBackNode());

            // 重录征信单待办事项
            bizTaskBO.saveBizTask(credit.getBizCode(), EBizLogType.CREDIT,
                credit.getCode(), ENode.renew_credit, cdbiz.getYwyUser());

            // 业务状态修改
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A1x.getCode());

        }
        creditBO.refreshCreditNode(credit);

        // 日志记录
        sysBizLogBO.recordCurOperate(credit.getBizCode(), EBizLogType.CREDIT,
            credit.getCode(), preCurrentNode, req.getApproveNote(),
            req.getOperator());

        // 处理待审核待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.CREDIT.getCode(), req.getCode(),
            ENode.approve_credit);

    }

    @Override
    @Transactional
    public void inputBankCreditResult(XN632111Req req) {

        Credit credit = creditBO.getCredit(req.getCreditCode());
        if (null == credit) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据征信单编号查询不到征信单");
        }
        Cdbiz cdbiz = cdbizBO.getCdbiz(credit.getBizCode());
        if (!ECdbizStatus.A1.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入银行征信结果节点，不能操作");
        }

        String preCurNodeCode = credit.getCurNodeCode();// 当前节点
        ENode node = ENode.getMap().get(preCurNodeCode);
        String curNode = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode)
            .getNextNode();
        // 确认 录入征信结果
        node = ENode.getMap().get(curNode);
        credit.setCurNodeCode(curNode);
        credit.setOperator(req.getOperator());
        creditBO.refreshInputBankCreditResult(credit);

        List<XN632111ReqCreditUser> creditResult = req.getCreditList();
        for (XN632111ReqCreditUser reqCreditUser : creditResult) {
            // 录入结果与说明
            CreditUser creditUser = creditUserBO.getCreditUser(reqCreditUser
                .getCreditUserCode());
            creditUserBO.inputBankCreditResult(creditUser,
                reqCreditUser.getBankCreditReport(),
                reqCreditUser.getDataCreditReport(),
                reqCreditUser.getBankResult(), reqCreditUser.getCreditNote());
            // 银行征信报告
            EAttachName attachName = EAttachName.getMap().get(
                EAttachName.bank_credit_report.getCode());
            attachmentBO.saveAttachment(credit.getBizCode(),
                attachName.getCode(), attachName.getValue(),
                reqCreditUser.getBankCreditReport());
            // 大数据征信报告
            attachName = EAttachName.getMap().get(
                EAttachName.data_credit_report.getCode());
            attachmentBO.saveAttachment(credit.getBizCode(),
                attachName.getCode(), attachName.getValue(),
                reqCreditUser.getDataCreditReport());
        }
        cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A2.getCode());
        // 操作日志
        sysBizLogBO.recordCurOperate(credit.getBizCode(), EBizLogType.CREDIT,
            credit.getCode(), node.getCode(), node.getValue(),
            req.getOperator());
        // 待办事项
        bizTaskBO.saveBizTask(credit.getBizCode(), EBizLogType.CREDIT,
            credit.getCode(), node, null);

        // 处理待录入征信结果待办事项
        sysUserBO.getUser(req.getOperator());
        bizTaskBO.handlePreBizTask(EBizLogType.CREDIT.getCode(),
            req.getCreditCode(), ENode.input_credit);

    }

    @Override
    public void cancelCredit(String code, String operator) {

        Credit credit = creditBO.getCredit(code);

        if (ENode.AUDIT.getCode().equals(credit.getCurNodeCode())
                || ENode.ACHIEVE.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "已录入征信结果，不能撤回!");
        }
        String preCurNodeCode = credit.getCurNodeCode();
        credit.setCurNodeCode(ENode.CANCEL.getCode());
        creditBO.cancelCredit(credit);

        sysBizLogBO.recordCurOperate(credit.getCode(), EBizLogType.CREDIT,
            credit.getCode(), preCurNodeCode, null, operator);
        sysBizLogBO.saveSYSBizLog(credit.getCode(), EBizLogType.CREDIT,
            credit.getCode(), credit.getCurNodeCode());
    }

    @Override
    public void initCredit(Credit credit) {

        // 业务
        Cdbiz cdbiz = cdbizBO.getCdbiz(credit.getBizCode());
        credit.setCdbiz(cdbiz);

        // 征信人员
        List<CreditUser> creditUserList = creditUserBO
            .queryCreditUserList(credit.getCode());
        credit.setCreditUserList(creditUserList);
        // 从征信人员表查申请人的客户姓名 手机号 身份证号
        credit.setCreditUser(creditUserBO.getCreditUserByBizCode(
            credit.getCode(), ELoanRole.APPLY_USER));
        // 从用户表查业务员姓名
        SYSUser user = sysUserBO.getUser(cdbiz.getYwyUser());
        credit.setSaleUserName(user.getRealName());
        // 从部门表查业务公司名
        Department department = departmentBO.getDepartment(credit
            .getCompanyCode());
        if (null != department) {
            credit.setCompanyName(department.getName());
        }
        // 录入银行征信结果的驻行人员
        if (StringUtils.isNotBlank(credit.getOperator())) {
            SYSUser operator = sysUserBO.getUser(credit.getOperator());
            credit.setOperatorName(operator.getRealName());
        }
        // 业务团队名称
        if (StringUtils.isNotBlank(credit.getTeamCode())) {
            BizTeam team = bizTeamBO.getBizTeam(credit.getTeamCode());
            credit.setTeamName(team.getName());
        }

        // 内勤
        if (StringUtils.isNotBlank(credit.getInsideJob())) {
            SYSUser insideJob = sysUserBO.getUser(credit.getInsideJob());
            credit.setInsideJobName(insideJob.getRealName());
        }
        // 获取操作日志中最新操作记录
        if (StringUtils.isNotBlank(credit.getCode())) {
            SYSBizLog sysBizLog = sysBizLogBO
                .getLatestOperateRecordByBizCode(credit.getCode());
            if (null != sysBizLog) {
                credit.setUpdaterName(sysBizLog.getOperatorName());
                credit
                    .setUpdateDatetime(DateUtil.dateToStr(
                        sysBizLog.getStartDatetime(),
                        DateUtil.DATA_TIME_PATTERN_1));
            }
        }
        // 获取银行信息
        if (StringUtils.isNotBlank(credit.getLoanBankCode())) {
            Bank bank = bankBO.getBank(credit.getLoanBankCode());
            credit.setLoanBankName(bank.getBankName());
        }
        // 是否作废
        if (StringUtils.isNotBlank(credit.getBudgetCode())) {
            BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(credit
                .getBudgetCode());
            if (EBudgetOrderNode.CANCEL_END.getCode().equals(
                budgetOrder.getCurNodeCode())) {
                credit.setIsCancel(EBoolean.YES.getCode());
            }
            credit.setIsCancel(EBoolean.NO.getCode());
        }
        // 附件表
        List<Attachment> attachments = attachmentBO.queryBizAttachments(credit
            .getBizCode());
        credit.setAttachments(attachments);

        // // 征信的内勤取录入征信结果的操作人
        // SYSBizLog bizLog = sysBizLogBO
        // .getLatestOperateCreditByBizCode(credit.getCode());
        // if (null != bizLog && StringUtils.isNotBlank(bizLog.getOperator())) {
        // SYSUser operator = sysUserBO.getUser(bizLog.getOperator());
        // credit.setInsideJob(operator.getRealName());// 内勤（使用这个业务单在日志表的最新操作人）
        // }
    }

    @Override
    public void exchangeCreditUser(XN632099Req req) {
        if (req.getCreditUserList().size() != 2) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "请选择两条记录再进行操作！");
        }
        for (String code : req.getCreditUserList()) {
            CreditUser creditUser = creditUserBO.getCreditUser(code);
            if (ELoanRole.APPLY_USER.getCode().equals(creditUser.getLoanRole())) {
                creditUser.setLoanRole(ELoanRole.GHR.getCode());
                creditUserBO.refreshCreditUserLoanRole(creditUser);
            } else if (ELoanRole.GHR.getCode().equals(creditUser.getLoanRole())) {
                creditUser.setLoanRole(ELoanRole.APPLY_USER.getCode());
                creditUserBO.refreshCreditUserLoanRole(creditUser);
                creditBO.setApplyUserInfo(creditUser.getCreditCode(),
                    creditUser.getUserName(), creditUser.getMobile(),
                    creditUser.getIdNo());
            } else {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "担保人不能置换！");
            }
        }
    }

    @Override
    public Object queryCreditListByJob(Credit condition) {
        ArrayList<Object> list = new ArrayList<>();

        SYSUser sysUser = new SYSUser();
        sysUser.setRoleCode("SR20180000000000000NQZY");
        List<SYSUser> userList = sysUserBO.queryUserList(sysUser);
        for (SYSUser sUser : userList) {
            XN632917Res res = new XN632917Res();
            Credit credit = new Credit();
            credit.setInsideJob(sUser.getUserId());
            long count = creditBO.getTotalCount(credit);
            res.setUderId(sUser.getUserId());
            res.setName(sUser.getRealName());
            res.setNumber(count + "");
            list.add(res);
        }
        return list;
    }

}
