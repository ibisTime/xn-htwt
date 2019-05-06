package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IAdvanceBO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankLoanBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.IBudgetOrderGpsBO;
import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.ICarPledgeBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Advance;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BankLoan;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.domain.BudgetOrderGps;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632110ReqCreditUser;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632111ReqCreditUser;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.dto.req.XN632119Req;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632131Req;
import com.cdkj.loan.dto.res.CarInfoRes;
import com.cdkj.loan.dto.res.LoanInfoRes;
import com.cdkj.loan.enums.EAccountType;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ENewBizType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.enums.EUserKind;
import com.cdkj.loan.exception.BizException;

@Service
public class CdbizAOImpl implements ICdbizAO {

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private ICarInfoBO carInfoBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private ICreditJourBO creditJourBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IAdvanceBO advanceBO;

    @Autowired
    private IRepointBO repointBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IBankLoanBO bankLoanBO;

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Autowired
    private IBudgetOrderGpsBO budgetOrderGpsBO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ICarPledgeBO carPledgeBO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addCredit(XN632110Req req) {
        SYSUser sysUser = sysUserBO.getUser(req.getOperator());

        if (StringUtils.isBlank(sysUser.getPostCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "您还未设置职位，暂无法使用征信申请");
        }

        if (StringUtils.isBlank(sysUser.getTeamCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "您还未设置团队，暂无法申请!");
        }
        BizTeam bizTeam = bizTeamBO.getBizTeam(sysUser.getTeamCode());

        // 初始节点
        ENode currentNode = ENode.new_credit;

        // 生成业务编号
        Cdbiz cdbiz =
                cdbizBO.saveCdbiz(
                        req.getLoanBankCode(),
                        req.getBizType(),
                        StringValidater.toLong(req.getLoanAmount()),
                        sysUser,
                        bizTeam,
                        currentNode.getCode(),
                        req.getButtonCode(),
                        req.getNote());

        // 二手车材料处理
        secondHandOperate(cdbiz, req.getSecondCarReport(), req.getXszFront(), req.getXszReverse());

        // 新增征信人员
        modifyCreditUser(cdbiz.getBizCode(), req.getCreditUserList(), true);

        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            // 操作日志
            sysBizLogBO.recordCurOperate(
                    cdbiz.getBizCode(),
                    EBizLogType.CREDIT,
                    cdbiz.getBizCode(),
                    currentNode.getCode(),
                    req.getNote(),
                    sysUser.getUserId());

            if (!bizTeam.getCaptain().equals(req.getOperator())) {
                // 给团队长发起待办事项
                bizTaskBO.saveBizTask(
                        cdbiz.getBizCode(),
                        EBizLogType.CREDIT,
                        cdbiz.getBizCode(),
                        ENode.input_credit,
                        bizTeam.getCaptain());
            }

            // 录入征信的待办事项
            bizTaskBO.saveBizTask(
                    cdbiz.getBizCode(),
                    EBizLogType.CREDIT,
                    cdbiz.getBizCode(),
                    ENode.input_credit,
                    req.getOperator());

            // 面签开始的待办事项
            bizTaskBO.saveBizTask(
                    cdbiz.getBizCode(),
                    EBizLogType.INTERVIEW,
                    cdbiz.getBizCode(),
                    ENode.input_interview,
                    req.getOperator());
        }

        return cdbiz.getCode();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editCredit(XN632112Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getBizCode());
        if (!ECdbizStatus.A0.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "该业务不处于征信审核不通过或新录状态，无法修改征信");
        }

        String bizCode = req.getBizCode();

        // 之前节点
        String preCurNodeCode = cdbiz.getCurNodeCode();
        ENode node = ENode.getMap().get(preCurNodeCode);

        // 删除附件
        attachmentBO.removeBizAttachments(bizCode);
        // 二手车材料处理
        secondHandOperate(cdbiz, req.getSecondCarReport(), req.getXszFront(), req.getXszReverse());

        // 修改业务
        EntityUtils.copyData(req, cdbiz);
        cdbizBO.refreshCdbiz(cdbiz);

        // 修改征信人员
        modifyCreditUser(bizCode, req.getCreditUserList(), false);

        // 更新当前节点
        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            // 操作日志
            sysBizLogBO.recordCurOperate(
                    bizCode, EBizLogType.CREDIT, bizCode, node.getCode(), node.getValue(),
                    req.getOperator());

            // 处理之前的待办事项
            bizTaskBO.handlePreBizTask(EBizLogType.CREDIT.getCode(), bizCode, node);

            // 发起征信的待办事项
            bizTaskBO.saveBizTask(
                    cdbiz.getBizCode(),
                    EBizLogType.CREDIT,
                    cdbiz.getBizCode(),
                    ENode.input_credit,
                    req.getOperator());

            // 给团队长发起待办事项
            bizTaskBO.saveBizTask(
                    cdbiz.getBizCode(),
                    EBizLogType.CREDIT,
                    cdbiz.getBizCode(),
                    ENode.input_credit,
                    cdbiz.getCaptainCode());

            // 面签开始的待办事项
            bizTaskBO.saveBizTask(
                    cdbiz.getBizCode(),
                    EBizLogType.INTERVIEW,
                    cdbiz.getBizCode(),
                    ENode.input_interview,
                    req.getOperator());

            // 更新节点
            NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode);

            // 更新提交节点信息
            cdbizBO.refreshIntevNodeStart(cdbiz, nodeFlow.getNextNode(),
                    ENode.input_interview.getCode(),
                    ECdbizStatus.B00.getCode());

            // 修改业务主状态
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A1.getCode(), ECdbizStatus.A1.getValue());
        }
    }

    private void modifyCreditUser(
            String bizCode, List<XN632110ReqCreditUser> childList, boolean isAdd) {
        if (!isAdd) {
            // 删除
            creditUserBO.removeCreditUserByBizCode(bizCode);
        }

        // 申请人条数验证
        int applyUserCount = 0;
        if (CollectionUtils.isNotEmpty(childList)) {
            for (XN632110ReqCreditUser child : childList) {
                if (ECreditUserLoanRole.APPLY_USER.getCode().equals(child.getLoanRole())) {
                    applyUserCount++;
                    // 征信单设置客户姓名（征信人员的申请人）
                }
                if (applyUserCount > 1) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(), "征信申请人只能填写一条数据");
                }

                creditUserBO.saveCreditUser(child, bizCode);
            }

            if (applyUserCount <= 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请填写征信申请人数据");
            }
        }
    }

    private void secondHandOperate(
            Cdbiz cdbiz, String secondCarReport, String xszFront, String xszReverse) {
        if (ENewBizType.second_hand.getCode().equals(cdbiz.getBizType())) {
            // 二手车报告
            EAttachName attachName = EAttachName.getMap()
                    .get(EAttachName.second_car_report.getCode());
            attachmentBO.saveAttachment(
                    cdbiz.getBizCode(), attachName.getCode(), attachName.getValue(),
                    secondCarReport);
            // 行驶证正面
            attachName = EAttachName.getMap().get(EAttachName.xsz_front.getCode());
            attachmentBO.saveAttachment(
                    cdbiz.getBizCode(), attachName.getCode(), attachName.getValue(), xszFront);
            // 行驶证反面
            attachName = EAttachName.getMap().get(EAttachName.xsz_reverse.getCode());
            attachmentBO.saveAttachment(
                    cdbiz.getBizCode(), attachName.getCode(), attachName.getValue(), xszReverse);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendOrder(XN632119Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getBizCode());
        if (!ECdbizStatus.A1.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前征信单不能派单！");
        }
        // 修改内勤
        cdbizBO.refreshInsideJob(cdbiz, req.getInsideJob());
        // 删除当前用户的之前待办事项
        bizTaskBO.removeUnhandleBizTask(
                cdbiz.getCode(), ENode.input_credit.getCode(), req.getOperator());
        // 新增该内勤的待办事项
        bizTaskBO.saveBizTask(
                cdbiz.getCode(),
                EBizLogType.CREDIT,
                cdbiz.getCode(),
                ENode.input_credit,
                req.getInsideJob());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void inputBankCreditResult(XN632111Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getBizCode());
        if (!ECdbizStatus.A1.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A1x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是录入银行征信结果节点，不能操作");
        }
        // 当前节点
        String preCurNodeCode = cdbiz.getCurNodeCode();
        String curNode = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode).getNextNode();
        cdbizBO.refreshCurNodeCode(cdbiz, curNode);
        cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A2.getCode(), ECdbizStatus.A2.getValue());

        // 待办事项处理
        bizTaskBO.handlePreAndAdd(
                EBizLogType.CREDIT,
                cdbiz.getCode(),
                cdbiz.getCode(),
                preCurNodeCode,
                curNode,
                req.getOperator());

        List<XN632111ReqCreditUser> creditResult = req.getCreditList();
        for (XN632111ReqCreditUser reqCreditUser : creditResult) {
            // 录入结果与说明
            CreditUser creditUser = creditUserBO.getCreditUser(reqCreditUser.getCreditUserCode());
            creditUserBO.inputBankCreditResult(creditUser, reqCreditUser);

            EAttachName attachNameBank = null;
            EAttachName attachNameData = null;
            // 报告
            if (ECreditUserLoanRole.APPLY_USER.getCode().equals(creditUser.getLoanRole())) {
                attachNameBank = EAttachName.getMap().get(EAttachName.mainLoaner_bank.getCode());
                attachNameData = EAttachName.getMap().get(EAttachName.mainLoaner_data.getCode());

            } else if (ECreditUserLoanRole.GHR.getCode().equals(creditUser.getLoanRole())) {
                attachNameBank = EAttachName.getMap().get(EAttachName.replier_bank.getCode());
                attachNameData = EAttachName.getMap().get(EAttachName.replier_data.getCode());

            } else if (ECreditUserLoanRole.GUARANTOR.getCode().equals(creditUser.getLoanRole())) {
                attachNameBank = EAttachName.getMap().get(EAttachName.assurance_bank.getCode());
                attachNameData = EAttachName.getMap().get(EAttachName.assurance_data.getCode());
            }

            attachmentBO.saveAttachment(
                    creditUser.getCode(),
                    attachNameBank.getCode(),
                    attachNameBank.getValue(),
                    reqCreditUser.getBankCreditReport());
            attachmentBO.saveAttachment(
                    creditUser.getCode(),
                    attachNameData.getCode(),
                    attachNameData.getValue(),
                    reqCreditUser.getDataCreditReport());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void audit(XN632113Req req) {
        sysUserBO.getUser(req.getOperator());

        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ECdbizStatus.A2.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "该业务不处于待审核征信状态");
        }

        // 当前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);

        // 审核通过
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            for (CreditUser creditUser : req.getCreditUserList()) {
                CreditUser user = creditUserBO.getCreditUser(creditUser.getCode());
                user.setRelation(creditUser.getRelation());
                user.setLoanRole(creditUser.getLoanRole());
                creditUserBO.refreshCreditUserLoanRole(user);
            }
            // 审核通过，改变节点
            cdbizBO.refreshCurNodeCode(cdbiz, ENode.input_budget.getCode());
            // 修改业务状态
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A3.getCode(), req.getApproveNote());

            // 制卡节点
            cdbizBO.refreshMakeCardNode(cdbiz, ENode.make_card_apply.getCode());

            // 制卡状态
            cdbizBO.refreshMakeCardStatus(cdbiz, ECdbizStatus.H1.getCode());

            // 制卡待办事项
            bizTaskBO.saveBizTask(
                    req.getCode(),
                    EBizLogType.makeCard,
                    req.getCode(),
                    ENode.make_card_apply,
                    req.getOperator());

            // 准入单开始的待办事项
            bizTaskBO.saveBizTask(
                    cdbiz.getCode(),
                    EBizLogType.BUDGET_ORDER,
                    req.getCode(),
                    ENode.input_budget,
                    req.getOperator());

        } else {
            cdbizBO.refreshCurNodeCode(cdbiz, nodeFlow.getBackNode());
            // 重录征信单待办事项
            bizTaskBO.saveBizTask(
                    req.getCode(),
                    EBizLogType.CREDIT,
                    req.getCode(),
                    ENode.renew_credit,
                    cdbiz.getSaleUserId());

            // 业务状态修改
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A1x.getCode());
        }

        // 日志记录
        sysBizLogBO.recordCurOperate(
                req.getCode(),
                EBizLogType.CREDIT,
                req.getCode(),
                preCurrentNode,
                req.getApproveNote(),
                req.getOperator());

        // 处理待审核待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.CREDIT.getCode(), req.getCode(), ENode.input_credit);
    }

    @Override
    public void accesssApplySubmit(String code, String operator) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        String preNodeCode = cdbiz.getCurNodeCode(); // 当前节点

        // 日志记录
        sysBizLogBO.recordCurOperate(code, EBizLogType.BUDGET_ORDER, code, preNodeCode, null,
                operator);
        // 下一个节点
        preNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode).getNextNode();

        cdbizBO.refreshCurNodeCode(cdbiz, preNodeCode);
        // 业务状态变化
        cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A4.getCode());
        // 处理待办事项
        bizTaskBO.handlePreBizTask(
                EBizLogType.BUDGET_ORDER.getCode(), code, ENode.getMap().get(preNodeCode));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void interview(XN632123Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        String preCurrentNode = cdbiz.getIntevCurNodeCode();
        if (!ENode.input_interview.getCode().equals(preCurrentNode)
                && !ENode.reinput_interview.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前不是新录/重录面签节点，不能操作");
        }

        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);

        cdbizBO.interview(cdbiz, req);

        // 操作日志
        ENode node = ENode.getMap().get(preCurrentNode);
        sysBizLogBO.recordCurOperate(
                req.getCode(),
                EBizLogType.INTERVIEW,
                req.getCode(),
                node.getCode(),
                node.getValue(),
                req.getOperator());

        if (EBoolean.YES.getCode().equals(req.getIsSend())) {
            cdbizBO.refreshIntevCurNodeCode(cdbiz, nodeFlow.getNextNode());
            cdbizBO.refreshMqStatus(cdbiz, ECdbizStatus.B01.getCode());

            // 处理待办事项
            bizTaskBO.handlePreAndAdd(
                    EBizLogType.INTERVIEW,
                    req.getCode(),
                    req.getCode(),
                    preCurrentNode,
                    ENode.approve_interview.getCode(),
                    req.getOperator());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void interviewInternalApprove(
            String code, String operator, String approveResult, String approveNote) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ENode.approve_interview.getCode().equals(cdbiz.getIntevCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是内勤主管审核节点，不能操作");
        }

        String preCurrentNode = cdbiz.getIntevCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        String intevCurNodeCode = null;
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            intevCurNodeCode = nodeFlow.getNextNode();

            // 生成资料传递
            String logisticsCode =
                    logisticsBO.saveLogistics(
                            ELogisticsType.BUDGET.getCode(),
                            ELogisticsCurNodeType.SALE_SEND_BANK_LOAN.getCode(),
                            cdbiz.getCode(),
                            cdbiz.getSaleUserId(),
                            ENode.submit_1.getCode(),
                            ENode.receive_approve_1.getCode(),
                            null);

            // 资料传递日志
            sysBizLogBO.saveSYSBizLog(
                    code, EBizLogType.LOGISTICS, logisticsCode, cdbiz.getIntevCurNodeCode());

            // 更新面签业务状态
            cdbizBO.refreshMqStatus(cdbiz, ECdbizStatus.B03.getCode());
        } else {
            intevCurNodeCode = nodeFlow.getBackNode();
            cdbizBO.refreshMqStatus(cdbiz, ECdbizStatus.B02.getCode());

            // 添加待办事项
            bizTaskBO.saveBizTask(
                    cdbiz.getCode(),
                    EBizLogType.INTERVIEW,
                    cdbiz.getCode(),
                    ENode.reinput_interview,
                    operator);
        }
        cdbiz.setRemark(approveNote);
        cdbizBO.refreshIntevCurNodeCode(cdbiz, intevCurNodeCode);

        // 操作日志
        ENode node = ENode.getMap().get(preCurrentNode);
        sysBizLogBO.recordCurOperate(
                cdbiz.getBizCode(),
                EBizLogType.INTERVIEW,
                cdbiz.getCode(),
                node.getCode(),
                approveNote,
                operator);

        // 处理前待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.INTERVIEW.getCode(), cdbiz.getCode(), node);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void archive(String code, String operator, String enterLocation) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        // 第一次存档
        if (ECdbizStatus.D2.getCode().equals(cdbiz.getFircundangStatus())) {
            // 更新业务状态
            cdbizBO.refreshFircundangStatus(cdbiz, ECdbizStatus.D3.getCode());
        }
        // 第二次存档
        if (ECdbizStatus.E2.getCode().equals(cdbiz.getSeccundangStatus())) {

            CreditUser applyUser =
                    creditUserBO.getCreditUserByBizCode(code, ECreditUserLoanRole.APPLY_USER);

            User user = userBO.getUser(applyUser.getMobile(), EUserKind.Customer.getCode());
            String userId = null;
            if (user == null) {
                // 用户代注册并实名认证
                userId =
                        userBO.doRegisterAndIdentify(
                                EBoolean.YES.getCode(),
                                applyUser.getMobile(),
                                applyUser.getIdKind(),
                                applyUser.getUserName(),
                                applyUser.getIdNo());
                distributeAccount(userId, applyUser.getMobile(), EUserKind.Customer.getCode());
            } else {
                userId = user.getUserId();
            }

            BankLoan bankLoan = bankLoanBO.getBankLoanByBiz(code);
            Bank bank = bankBO.getBank(bankLoan.getRepayBankCode());

            // 绑定用户银行卡
            String bankcardCode =
                    bankcardBO.bind(
                            userId,
                            applyUser.getUserName(),
                            bankLoan.getRepayBankcardNumber(),
                            bank.getBankCode(),
                            bankLoan.getRepayBankName(),
                            bankLoan.getRepaySubbranch());

            // 自动生成还款业务
            // RepayBiz repayBiz = repayBizBO.generateCarLoanRepayBiz(
            // budgetOrder, userId, bankcardCode, operator);

            // 自动生成还款计划
            // repayPlanBO.genereateNewRepayPlan(repayBiz);

            // 更新业务状态
            cdbizBO.refreshSeccundangStatus(cdbiz, ECdbizStatus.E3.getCode());
        }

        // 日志记录
        sysBizLogBO.refreshPreSYSBizLog(
                EBizLogType.BUDGET_ORDER.getCode(),
                cdbiz.getCode(),
                cdbiz.getCurNodeCode(),
                null,
                operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void entryFbh(XN632131Req req) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ENode.input_fbh.getCode().equals(cdbiz.getFbhgpsNode())
                && !ENode.reinput_fbh.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是录入发保合节点，不能操作");
        }

        cdbiz.setFbhgpsNode(ENode.approve_fbh.getCode());
        cdbizBO.refreshFbhgpsStatus(cdbiz, ECdbizStatus.C02.getCode());

        // 更新车辆信息
        carInfoBO.entryFbhInfoByBiz(req.getCode(), req.getPolicyDatetime(), req.getPolicyDueDate());

        // 删除附件
        attachmentBO.removeByCategory(req.getCode(), "car_procedure");
        // 添加附件
        attachmentBO.saveAttachment(req.getCode(), req);

        // 待办事项
        bizTaskBO.saveBizTask(
                req.getCode(), EBizLogType.fbh, req.getCode(), ENode.approve_fbh,
                req.getOperator());

        // 操作日志
        sysBizLogBO.recordCurOperate(
                req.getCode(),
                EBizLogType.fbh,
                req.getCode(),
                ENode.approve_fbh.getCode(),
                null,
                req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void approveFbh(String code, String approveResult,
            String approveNote, String operator) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ENode.approve_fbh.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是审核发保合节点，不能操作");
        }

        String nextStatus = ECdbizStatus.C03.getCode();
        String nextNodeCode = ENode.set_gps.getCode();
        if (EBoolean.NO.getCode().equals(approveResult)) {
            nextStatus = ECdbizStatus.C01x.getCode();
            nextNodeCode = ENode.reinput_fbh.getCode();
        }

        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbizBO.refreshFbhgpsStatus(cdbiz, nextStatus);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.fbh, code, ENode.matchCode(nextNodeCode), operator);

        // 操作日志
        sysBizLogBO
                .recordCurOperate(code, EBizLogType.fbh, code, nextNodeCode, approveNote, operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void installGps(String code, String operator, List<XN632126ReqGps> gpsAzList) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ENode.set_gps.getCode().equals(cdbiz.getFbhgpsNode())
                && !ENode.approve_fail_gps.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是安装gps节点，不能操作");
        }

        // 删除
        budgetOrderGpsBO.removeBudgetOrderGpsList(code);

        // 添加
        budgetOrderGpsBO.saveBudgetOrderGpsList(code, gpsAzList);

        String nextNodeCode = ENode.approve_gps.getCode();
        String nextStatus = ECdbizStatus.C04.getCode();

        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbizBO.refreshFbhgpsStatus(cdbiz, nextStatus);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.gps, code, ENode.matchCode(nextNodeCode), operator);

        // 操作日志
        sysBizLogBO.recordCurOperate(code, EBizLogType.gps, code, nextNodeCode, null, operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void gpsManagerApprove(
            String code, String operator, String approveResult, String approveNote) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ENode.approve_gps.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是GPS管理员审核节点，不能操作");
        }

        String nextNodeCode = ENode.gps_done.getCode();
        String nextStatus = ECdbizStatus.C06.getCode();

        if (EApproveResult.NOT_PASS.getCode().equals(approveResult)) {

            nextNodeCode = ENode.approve_fail_gps.getCode();
            nextStatus = ECdbizStatus.C05.getCode();

            // gps使用状态改为未使用
            List<BudgetOrderGps> list = budgetOrderGpsBO.queryBudgetOrderGpsList(code);
            for (BudgetOrderGps budgetOrderGps : list) {
                gpsBO.refreshUseGps(budgetOrderGps.getCode(), null, EBoolean.NO);
            }
            budgetOrderGpsBO.removeBudgetOrderGpsList(code);
        }

        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbizBO.refreshFbhgpsStatus(cdbiz, nextStatus);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.gps, code, ENode.matchCode(nextNodeCode), operator);

        // 操作日志
        sysBizLogBO.recordCurOperate(code, EBizLogType.gps, code, nextNodeCode, null, operator);
    }

    // 分配账号
    private void distributeAccount(String userId, String mobile, String kind) {
        List<String> currencyList = new ArrayList<String>();
        currencyList.add(ECurrency.CNY.getCode());
        currencyList.add(ECurrency.JF.getCode());
        currencyList.add(ECurrency.XYF.getCode());

        for (String currency : currencyList) {
            accountBO
                    .distributeAccount(userId, mobile, EAccountType.getAccountType(kind), currency);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void makeCardApply(String code, String operator, String cardPostAddress) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ECdbizStatus.H1.getCode().equals(cdbiz.getMakeCardStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前不是待制卡申请状态，无法申请");
        }
        // 录入卡邮寄地址
        cdbizBO.refreshCardAddress(cdbiz, cardPostAddress);
        // 制卡节点
        cdbizBO.refreshMakeCardNode(cdbiz, ENode.input_card_number.getCode());
        // 制卡状态
        cdbizBO.refreshMakeCardStatus(cdbiz, ECdbizStatus.H2.getCode());
        // 处理前待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.makeCard.getCode(), code, ENode.make_card_apply);
        // 操作日志
        sysBizLogBO.recordCurOperate(
                code,
                EBizLogType.makeCard,
                code,
                ENode.make_card_apply.getCode(),
                ENode.make_card_apply.getValue(),
                operator);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.makeCard, code, ENode.input_card_number, operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void inputCardNumber(String code, String cardNumber, String operator) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ECdbizStatus.H2.getCode().equals(cdbiz.getMakeCardStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前不是回录卡号状态，无法录入");
        }
        // 录入卡号
        cdbiz.setRepayCardNumber(cardNumber);
        // 制卡节点
        cdbiz.setMakeCardNode(ENode.make_card_finish.getCode());
        // 制卡状态
        cdbiz.setMakeCardStatus(ECdbizStatus.H3.getCode());
        cdbizBO.refreshCdbiz(cdbiz);

        // 处理前待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.makeCard.getCode(), code, ENode.input_card_number);
        // 操作日志
        sysBizLogBO.recordCurOperate(
                code,
                EBizLogType.makeCard,
                code,
                ENode.input_card_number.getCode(),
                ENode.input_card_number.getValue(),
                operator);
    }

    @Override
    public Paginable<Cdbiz> queryCdbizPage(int start, int limit, Cdbiz condition) {
        Paginable<Cdbiz> page = null;
        if (StringUtils.isNotBlank(condition.getUserId())) {
            SYSUser sysUser = sysUserBO.getUser(condition.getUserId());
            condition.setRoleCode(sysUser.getRoleCode());
            condition.setTeamCode(sysUser.getTeamCode());
            page = cdbizBO.getPaginableByRoleCode(condition, start, limit);
        } else {
            page = cdbizBO.getPaginable(start, limit, condition);
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
        setInfo(cdbiz);
        return cdbiz;
    }

    @Override
    public Cdbiz getCdbizAll(String code) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        init(cdbiz);
        return cdbiz;
    }

    private void setInfo(Cdbiz cdbiz) {
        // 征信人列表
        List<CreditUser> creditUserList = creditUserBO.queryCreditUserList(cdbiz.getCode());
        cdbiz.setCreditUserList(creditUserList);

        // 主贷人信息
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(
            cdbiz.getCode(), ECreditUserLoanRole.APPLY_USER);
        cdbiz.setCreditUser(creditUser);

        // 车辆信息
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(cdbiz.getCode());
        // 还款信息
        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(cdbiz.getCode());

        LoanInfoRes loanInfoRes = new LoanInfoRes();
        CarInfoRes carInfoRes = new CarInfoRes();
        if (carInfo != null) {
            BeanUtils.copyProperties(carInfo, loanInfoRes);
            BeanUtils.copyProperties(carInfo, carInfoRes);
        }
        if (repayBiz != null) {
            BeanUtils.copyProperties(repayBiz, loanInfoRes);
            BeanUtils.copyProperties(repayBiz, carInfoRes);
        }
        // 贷款信息
        cdbiz.setLoanInfo(loanInfoRes);
        // 车辆信息
        cdbiz.setCarInfoRes(carInfoRes);
        // 征信人流水
        List<CreditJour> creditJours = creditJourBO.querCreditJoursByBizCode(cdbiz.getCode());
        cdbiz.setCreditJours(creditJours);

        // 业务员名称
        if (StringUtils.isNotBlank(cdbiz.getSaleUserId())) {

            SYSUser saleUser = sysUserBO.getUser(cdbiz.getSaleUserId());
            cdbiz.setSaleUserName(saleUser.getRealName());
            cdbiz.setSaleUserCompanyName(saleUser.getCompanyName());
            cdbiz.setSaleUserDepartMentName(saleUser.getDepartmentName());
            cdbiz.setSaleUserPostName(saleUser.getPostName());
        }

        // 内勤名称
        if (StringUtils.isNotBlank(cdbiz.getInsideJob())) {

            SYSUser insideJob = sysUserBO.getUser(cdbiz.getInsideJob());
            cdbiz.setInsideJobName(insideJob.getRealName());
            cdbiz.setInsideJobCompanyName(insideJob.getCompanyName());
            cdbiz.setInsideJobDepartMentName(insideJob.getDepartmentName());
            cdbiz.setInsideJobPostName(insideJob.getPostName());
        }

        // gps安装列表
        List<BudgetOrderGps> budgetOrderGpsList = budgetOrderGpsBO
                .queryBudgetOrderGpsList(cdbiz.getCode());
        cdbiz.setBudgetOrderGps(budgetOrderGpsList);

        // 附件
        List<Attachment> attachments = attachmentBO
                .queryBizAttachments(cdbiz.getCode());
        cdbiz.setAttachments(attachments);
    }

    private void init(Cdbiz cdbiz) {
        // 主贷人信息
        CreditUser creditUser =
                creditUserBO
                        .getCreditUserByBizCode(cdbiz.getCode(), ECreditUserLoanRole.APPLY_USER);
        cdbiz.setCreditUser(creditUser);

        // 公司名称
        if (StringUtils.isNotBlank(cdbiz.getCompanyCode())) {
            Department company = departmentBO.getDepartment(cdbiz.getCompanyCode());
            cdbiz.setCompanyName(company.getName());
        }

        // 业务员名称
        if (StringUtils.isNotBlank(cdbiz.getSaleUserId())) {

            SYSUser saleUser = sysUserBO.getUser(cdbiz.getSaleUserId());
            cdbiz.setSaleUserName(saleUser.getRealName());
            cdbiz.setSaleUserCompanyName(saleUser.getCompanyName());
            cdbiz.setSaleUserDepartMentName(saleUser.getDepartmentName());
            cdbiz.setSaleUserPostName(saleUser.getPostName());
        }

        // 内勤名称
        if (StringUtils.isNotBlank(cdbiz.getInsideJob())) {

            SYSUser insideJob = sysUserBO.getUser(cdbiz.getInsideJob());
            cdbiz.setInsideJobName(insideJob.getRealName());
            cdbiz.setInsideJobCompanyName(insideJob.getCompanyName());
            cdbiz.setInsideJobDepartMentName(insideJob.getDepartmentName());
            cdbiz.setInsideJobPostName(insideJob.getPostName());
        }

        // 征信人列表
        List<CreditUser> creditUserList = creditUserBO.queryCreditUserList(cdbiz.getCode());
        cdbiz.setCreditUserList(creditUserList);

        // 车辆信息
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(cdbiz.getCode());
        cdbiz.setCarInfo(carInfo);

        // 还款信息
        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(cdbiz.getCode());
        cdbiz.setRepayBiz(repayBiz);

        // 车辆抵押
        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(cdbiz.getCode());
        cdbiz.setCarPledge(carPledge);

        //财务垫资
        Advance advance = advanceBO.getAdvanceByBizCode(cdbiz.getCode());
        cdbiz.setAdvance(advance);

        //返点列表
        Repoint repoint = new Repoint();
        repoint.setBizCode(cdbiz.getCode());
        List<Repoint> repointList = repointBO.queryRepointList(repoint);
        cdbiz.setRepointList(repointList);

        //手续费
        BudgetOrderFee fee = budgetOrderFeeBO.getBudgetOrderFeeByBudget(cdbiz.getCode());
        cdbiz.setBudgetOrderFee(fee);

        // 征信人流水
        List<CreditJour> creditJours = creditJourBO.querCreditJoursByBizCode(cdbiz.getCode());
        cdbiz.setCreditJours(creditJours);

        List<BizTask> bizTasks = bizTaskBO.queryBizTaskByBizCode(cdbiz.getCode());
        cdbiz.setBizTasks(bizTasks);
        List<SYSBizLog> bizLogs = sysBizLogBO.queryBizLogByBizCode(cdbiz.getCode());
        cdbiz.setBizLogs(bizLogs);
        List<Attachment> attachments = attachmentBO.queryBizAttachments(cdbiz.getCode());
        cdbiz.setAttachments(attachments);
    }
}
