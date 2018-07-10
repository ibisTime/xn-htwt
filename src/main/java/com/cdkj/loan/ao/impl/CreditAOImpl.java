package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632110ReqCreditUser;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632111ReqCreditUser;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632112ReqCreditUser;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECreditNode;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.ELoanRole;
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

    @Override
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

        // 新增征信单
        Credit credit = new Credit();
        credit.setLoanBankCode(req.getLoanBankCode());
        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        credit.setBizType(req.getBizType());
        credit.setSecondCarReport(req.getSecondCarReport());
        credit.setXszFront(req.getXszFront());

        credit.setXszReverse(req.getXszReverse());
        credit.setCompanyCode(sysUser.getCompanyCode());
        credit.setSaleUserId(sysUser.getUserId());
        credit.setTeamCode(sysUser.getTeamCode());
        credit.setApplyDatetime(new Date());

        credit.setNote(req.getNote());
        credit.setSaleUserName(sysUser.getRealName());
        ECreditNode currentNode = ECreditNode.FILLIN_CREDIT;
        credit.setCurNodeCode(currentNode.getCode());
        // 设置节点
        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            currentNode = ECreditNode.getMap().get(
                nodeFlowBO.getNodeFlowByCurrentNode(
                    ECreditNode.FILLIN_CREDIT.getCode()).getNextNode());
            credit.setCurNodeCode(currentNode.getCode());
        }

        String creditCode = creditBO.saveCredit(credit);

        // 新增征信人员
        List<XN632110ReqCreditUser> childList = req.getCreditUserList();
        int applyUserCount = 0;// 申请人角色条数
        if (CollectionUtils.isNotEmpty(childList)) {
            for (XN632110ReqCreditUser child : childList) {
                if (ELoanRole.APPLY_USER.getCode().equals(child.getLoanRole())) {
                    applyUserCount++;
                    credit.setUserName(child.getUserName());// 征信单设置客户姓名（征信人员的申请人）
                    credit.setMobile(child.getMobile());
                    credit.setIdNo(child.getIdNo());
                }
                if (applyUserCount > 1) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "征信申请人只能填写一条数据");
                }
                CreditUser creditUser = new CreditUser();
                creditUser.setCreditCode(creditCode);
                creditUser.setRelation(child.getRelation());
                creditUser.setUserName(child.getUserName());
                creditUser.setLoanRole(child.getLoanRole());
                creditUser.setMobile(child.getMobile());

                creditUser.setIdNo(child.getIdNo());
                creditUser.setIdNoFront(child.getIdNoFront());
                creditUser.setIdNoReverse(child.getIdNoReverse());
                creditUser.setAuthPdf(child.getAuthPdf());
                creditUser.setInterviewPic(child.getInterviewPic());
                creditUserBO.saveCreditUser(creditUser);
            }

            if (applyUserCount <= 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "请填写征信申请人贷款角色数据");
            }
        }

        creditBO.setApplyUserInfo(credit);

        // 日志记录
        sysBizLogBO.saveSYSBizLog(creditCode, EBizLogType.CREDIT, creditCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

        return creditCode;
    }

    @Override
    @Transactional
    public void editCredit(XN632112Req req) {
        Credit credit = creditBO.getCredit(req.getCreditCode());
        if (null == credit) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据征信单编号查询不到征信单");
        }

        if (ECreditNode.ACHIEVE.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前征信申请已审核通过，不能操作");
        }

        if (ECreditNode.INPUT_CREDIT_RESULT.getCode().equals(
            credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前征信节点处于征信结果录入，不能修改");
        }

        // 修改征信单
        credit.setLoanBankCode(req.getLoanBankCode());
        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        credit.setBizType(req.getBizType());
        credit.setSecondCarReport(req.getSecondCarReport());
        credit.setXszFront(req.getXszFront());

        credit.setXszReverse(req.getXszReverse());
        credit.setSaleUserId(req.getOperator());

        // 之前节点
        String precurNodeCode = credit.getCurNodeCode();
        // 更新当前节点
        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            credit.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                credit.getCurNodeCode()).getNextNode());
        }
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
                CreditUser creditUser = new CreditUser();
                creditUser.setCreditCode(credit.getCode());
                creditUser.setRelation(child.getRelation());
                creditUser.setUserName(child.getUserName());
                creditUser.setLoanRole(child.getLoanRole());
                creditUser.setMobile(child.getMobile());

                creditUser.setIdNo(child.getIdNo());
                creditUser.setIdNoFront(child.getIdNoFront());
                creditUser.setIdNoReverse(child.getIdNoReverse());
                creditUser.setAuthPdf(child.getAuthPdf());
                creditUser.setInterviewPic(child.getInterviewPic());
                creditUserBO.saveCreditUser(creditUser);
            }

            if (applyUserCount <= 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "请填写征信申请人贷款角色数据");
            }
        }

        // 日志记录
        ECreditNode currentNode = ECreditNode.getMap().get(
            credit.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), precurNodeCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    public Credit getCredit(String creditCode) {
        return creditBO.getCredit(creditCode);
    }

    @Override
    public Credit getCreditAndCreditUser(String code) {
        Credit credit = creditBO.getCredit(code);

        Department department = departmentBO.getDepartment(credit
            .getCompanyCode());
        credit.setCompanyName(department.getName());

        CreditUser condition = new CreditUser();
        condition.setCreditCode(credit.getCode());
        List<CreditUser> creditUserList = creditUserBO
            .queryCreditUserList(condition);

        credit.setCreditUserList(creditUserList);

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
            Credit condition) {
        if (ESysRole.getMap().get(condition.getRoleCode()) == null) {
            condition.setTeamCode(null);
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
        if (null == credit) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据征信单编号查询不到征信单");
        }
        if (!ECreditNode.AUDIT.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控专员审核节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = credit.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过，改变节点
            credit.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                credit.getCurNodeCode()).getNextNode());
            // 保存准入单
            String budgetCode = budgetOrderBO.saveBudgetOrder(credit);

            // 准入单编号回写征信单
            credit.setBudgetCode(budgetCode);

        } else {
            credit.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                credit.getCurNodeCode()).getBackNode());
        }

        creditBO.refreshCreditNode(credit);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), preCurrentNode,
            credit.getCurNodeCode(), req.getApproveNote(), req.getOperator());

    }

    @Override
    @Transactional
    public void inputBankCreditResult(XN632111Req req) {

        Credit credit = creditBO.getCredit(req.getCreditCode());
        if (null == credit) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据征信单编号查询不到征信单");
        }

        if (!ECreditNode.INPUT_CREDIT_RESULT.getCode().equals(
            credit.getCurNodeCode())
                && !ECreditNode.AUDIT_NO_PASS.getCode().equals(
                    credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入银行征信结果节点，不能操作");
        }

        String preCurNodeCode = credit.getCurNodeCode();
        if (EBoolean.YES.getCode().equals(req.getDealType())) {
            // 确认 录入征信结果
            credit.setCurNodeCode((nodeFlowBO
                .getNodeFlowByCurrentNode(preCurNodeCode)).getNextNode());
            credit.setOperator(req.getOperator());
            List<XN632111ReqCreditUser> creditResult = req.getCreditResult();
            for (XN632111ReqCreditUser xn632111ReqCreditUser : creditResult) {
                CreditUser creditUser = creditUserBO
                    .getCreditUser(xn632111ReqCreditUser.getCreditUserCode());
                creditUser.setCode(xn632111ReqCreditUser.getCreditUserCode());
                creditUser.setCreditCardOccupation(StringValidater
                    .toDouble(xn632111ReqCreditUser.getCreditCardOccupation()));
                creditUser.setBankCreditResultPdf(xn632111ReqCreditUser
                    .getBankCreditResultPdf());
                creditUser.setBankCreditResultRemark(xn632111ReqCreditUser
                    .getBankCreditResultRemark());
                creditUserBO.inputBankCreditResult(creditUser);
            }
        } else {
            // 退回
            credit.setCurNodeCode((nodeFlowBO
                .getNodeFlowByCurrentNode(preCurNodeCode)).getBackNode());
        }
        ECreditNode currentNode = ECreditNode.getMap().get(
            credit.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), preCurNodeCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
        creditBO.refreshInputBankCreditResult(credit);

    }

    @Override
    public void cancelCredit(String code, String operator) {

        Credit credit = creditBO.getCredit(code);

        if (ECreditNode.AUDIT.getCode().equals(credit.getCurNodeCode())
                || ECreditNode.ACHIEVE.getCode()
                    .equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "已录入征信结果，不能撤回!");
        }
        String preCurNodeCode = credit.getCurNodeCode();
        credit.setCurNodeCode(ECreditNode.CANCEL.getCode());
        creditBO.cancelCredit(credit);

        sysBizLogBO.saveNewAndPreEndSYSBizLog(code, EBizLogType.CREDIT, code,
            preCurNodeCode, ECreditNode.CANCEL.getCode(),
            ECreditNode.CANCEL.getValue(), operator);

    }

    @Override
    public void initCredit(Credit credit) {
        // 从征信人员表查申请人的客户姓名 手机号 身份证号
        credit.setCreditUser(creditUserBO.getCreditUserByCreditCode(
            credit.getCode(), ELoanRole.APPLY_USER));
        // 从用户表查业务员姓名
        SYSUser user = sysUserBO.getUser(credit.getSaleUserId());
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
        // 获取操作日志中最新操作记录
        if (StringUtils.isNotBlank(credit.getCode())) {
            SYSBizLog sysBizLog = sysBizLogBO
                .getLatestOperateRecordByBizCode(credit.getCode());
            credit.setUpdaterName(sysBizLog.getOperatorName());
            credit
                .setUpdateDatetime(DateUtil.dateToStr(
                    sysBizLog.getStartDatetime(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
        }
        // 获取银行信息
        if (StringUtils.isNotBlank(credit.getLoanBankCode())) {
            Bank bank = bankBO.getBank(credit.getLoanBankCode());
            credit.setLoanBankName(bank.getBankName());

        }
    }
}
