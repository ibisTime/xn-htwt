package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IMissionBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632110ReqCreditUser;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632111ReqCreditUser;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.dto.req.XN632119Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.ELoanRole;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class CdbizAOImpl implements ICdbizAO {

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private ICreditAO creditAO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IMissionBO missionBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private INodeBO nodeBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IBankBO bankBO;

    @Override
    public Paginable<Cdbiz> queryCdbizPage(int start, int limit, Cdbiz condition) {
        Paginable<Cdbiz> page = cdbizBO.getPaginable(start, limit, condition);
        if (StringUtils.isNotBlank(condition.getUserId())) {
            SYSUser sysUser = sysUserBO.getUser(condition.getUserId());
            condition.setRoleCode(sysUser.getRoleCode());
            condition.setTeamCode(sysUser.getTeamCode());
            page = cdbizBO.getPaginableByRoleCode(condition, start, limit);
        }

        for (Cdbiz cdbiz : page.getList()) {
            init(cdbiz);
        }
        return page;
    }

    @Override
    public List<Cdbiz> queryCdbizList(Cdbiz condition) {
        List<Cdbiz> list = cdbizBO.queryCdbizList(condition);
        for (Cdbiz cdbiz : list) {
            init(cdbiz);
        }
        return list;
    }

    @Override
    public Cdbiz getCdbiz(String code) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        init(cdbiz);
        return cdbiz;
    }

    private void init(Cdbiz cdbiz) {
        // 贷款银行
        Bank bank = bankBO.getBank(cdbiz.getLoanBank());
        cdbiz.setLoanBankName(bank.getBankName());
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(
            cdbiz.getCode(), ELoanRole.APPLY_USER);
        cdbiz.setCreditUser(creditUser);
        List<BizTask> bizTasks = bizTaskBO.queryBizTaskByBizCode(cdbiz
            .getCode());
        cdbiz.setBizTasks(bizTasks);
        List<SYSBizLog> bizLogs = sysBizLogBO.queryBizLogByBizCode(cdbiz
            .getCode());
        cdbiz.setBizLogs(bizLogs);
        List<Attachment> attachments = attachmentBO.queryBizAttachments(cdbiz
            .getCode());
        cdbiz.setAttachments(attachments);
    }

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

        // 初始节点
        ENode currentNode = ENode.new_credit;
        // 生成业务编号
        String bizCode = cdbizBO.saveCdbiz(req.getLoanBankCode(),
            req.getBizType(), StringValidater.toLong(req.getLoanAmount()),
            sysUser, currentNode.getCode());
        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            Cdbiz cdbiz = cdbizBO.getCdbiz(bizCode);
            currentNode = ENode.getMap().get(
                nodeFlowBO.getNodeFlowByCurrentNode(ENode.new_credit.getCode())
                    .getNextNode());
            // 面签节点
            cdbizBO.refreshIntevCurNodeCode(cdbiz,
                ENode.input_interview.getCode());
            // 修改业务主状态
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A1.getCode());
            // 操作日志
            sysBizLogBO.recordCurOperate(bizCode, EBizLogType.CREDIT, bizCode,
                currentNode.getCode(), req.getNote(), sysUser.getUserId());
        }
        // 新增征信人员
        List<XN632110ReqCreditUser> childList = req.getCreditUserList();
        int applyUserCount = 0;// 申请人角色条数
        if (CollectionUtils.isNotEmpty(childList)) {
            for (XN632110ReqCreditUser child : childList) {
                if (ELoanRole.APPLY_USER.getCode().equals(child.getLoanRole())) {
                    applyUserCount++;
                    // 征信单设置客户姓名（征信人员的申请人）

                }
                if (applyUserCount > 1) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "征信申请人只能填写一条数据");
                }

                creditUserBO.saveCreditUser(child, bizCode);
            }

            if (applyUserCount <= 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "请填写征信申请人贷款角色数据");
            }

        }
        // 待办事项
        bizTaskBO.saveBizTask(bizCode, EBizLogType.CREDIT, bizCode,
            currentNode, req.getOperator());
        return bizCode;
    }

    @Override
    public void editCredit(XN632112Req req) {

    }

    @Override
    public void audit(XN632113Req req) {
        // TODO Auto-generated method stub

    }

    @Override
    public void inputBankCreditResult(XN632111Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getBizCode());
        if (!ECdbizStatus.A1.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入银行征信结果节点，不能操作");
        }
        String preCurNodeCode = cdbiz.getCurNodeCode();// 当前节点
        ENode node = ENode.getMap().get(preCurNodeCode);
        String curNode = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode)
            .getNextNode();
        cdbizBO.refershCurNodeCode(cdbiz, curNode);

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
            attachmentBO.saveAttachment(req.getBizCode(), attachName.getCode(),
                attachName.getValue(), reqCreditUser.getBankCreditReport());
            // 大数据征信报告
            attachName = EAttachName.getMap().get(
                EAttachName.data_credit_report.getCode());
            attachmentBO.saveAttachment(req.getBizCode(), attachName.getCode(),
                attachName.getValue(), reqCreditUser.getDataCreditReport());
        }

    }

    @Override
    public void cancelCredit(String code, String operator) {
        // TODO Auto-generated method stub

    }

    @Override
    public void initCredit(Credit credit) {
        // TODO Auto-generated method stub

    }

    @Override
    public void distributeLeaflets(XN632119Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getBizCode());
        if (!ECdbizStatus.A1.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A1x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前征信单不能派单！");
        }
        // 修改内勤
        cdbizBO.refreshInsideJob(cdbiz, req.getInsideJob());
        // 删除前待办事项
        bizTaskBO.removeUnhandleBizTask(cdbiz.getCode(),
            ENode.input_credit.getCode());
        // 新增该内勤的待办事项
        bizTaskBO.saveBizTask(cdbiz.getCode(), EBizLogType.CREDIT,
            cdbiz.getCode(), ENode.input_credit, req.getInsideJob());
    }
}
