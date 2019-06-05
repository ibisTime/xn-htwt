package com.cdkj.loan.ao.impl;

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
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
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
import com.cdkj.loan.domain.CreditIcbank;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.EnterFileList;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
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
import com.cdkj.loan.dto.req.XN632134Req;
import com.cdkj.loan.dto.req.XN632190Req;
import com.cdkj.loan.dto.req.XN632191Req;
import com.cdkj.loan.dto.req.XN632192Req;
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
import com.cdkj.loan.enums.ECreditUserStatus;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ENewBizType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ESysRole;
import com.cdkj.loan.enums.EUserKind;
import com.cdkj.loan.exception.BizException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Override
    @Transactional(rollbackFor = Exception.class)
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
        BizTeam bizTeam = bizTeamBO.getBizTeam(sysUser.getTeamCode());

        // 初始节点
        String currentNode = ENode.new_credit.getCode();

        // 生成业务编号
        Cdbiz cdbiz = cdbizBO.saveCdbiz(req.getLoanBankCode(),
                req.getBizType(), StringValidater.toLong(req.getCreditLoanAmount()),
                sysUser, bizTeam, currentNode, req.getButtonCode(), req.getNote());

        if (ENewBizType.second_hand.getCode().equals(req.getBizType())) {
            // 二手车材料处理
            secondHandOperate(cdbiz, req.getSecondCarReport(),
                    req.getXszFront(), req.getXszReverse());
        }

        // 新增征信人员
        modifyCreditUser(cdbiz.getCode(), req.getCreditUserList(), true);

        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            creditSend(cdbiz, currentNode, req.getOperator());
        }

        return cdbiz.getCode();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editCredit(XN632112Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getBizCode());
        if (!ENode.new_credit.getCode().equals(cdbiz.getCurNodeCode())
                && !ENode.renew_credit.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该业务不处于征信新录或重录状态，无法修改征信");
        }

        String bizCode = req.getBizCode();

        // 之前节点
        String preCurNodeCode = cdbiz.getCurNodeCode();

        EntityUtils.copyData(req, cdbiz);
        if (ENewBizType.second_hand.getCode().equals(req.getBizType())) {
            // 删除附件
            // attachmentBO.removeBizAttachments(bizCode);
            // 二手车材料处理
            secondHandOperate(cdbiz, req.getSecondCarReport(),
                    req.getXszFront(), req.getXszReverse());
        }
        // 修改业务
        cdbiz.setLoanAmount(StringValidater.toLong(req.getCreditLoanAmount()));
        if (StringUtils.isNotBlank(req.getLoanBankCode())) {
            cdbiz.setLoanBank(req.getLoanBankCode());
        }
        cdbizBO.refreshCdbiz(cdbiz);

        // 修改征信人员
        modifyCreditUser(bizCode, req.getCreditUserList(), false);

        // 更新当前节点
        if (EDealType.SEND.getCode().equals(req.getButtonCode())) {
            creditSend(cdbiz, preCurNodeCode, req.getOperator());
        }
    }

    /**
     * 征信发送
     */
    private void creditSend(Cdbiz cdbiz, String currentNode, String operator) {
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(currentNode);

        // 操作日志:操作第一步记录本次操作
        sysBizLogBO.saveFirstSYSBizLog(cdbiz.getCode(), EBizLogType.CREDIT,
                cdbiz.getCode(), currentNode, null, operator);

        // 如果是重录，处理重录的待办
        if (ENode.renew_credit.getCode().equals(currentNode)) {
            bizTaskBO.handlePreBizTask(cdbiz.getCode(), EBizLogType.CREDIT.getCode(),
                    cdbiz.getCode(), currentNode, operator);
        }

        // 第一步录入征信的待办事项
        bizTaskBO.saveBizTaskNew(cdbiz.getCode(), EBizLogType.CREDIT,
                cdbiz.getCode(), ENode.input_credit.getCode());

        if (ENode.new_credit.getCode().equals(currentNode)) {
            // 面签开始的待办事项
            bizTaskBO.saveBizTaskNew(cdbiz.getCode(), EBizLogType.INTERVIEW,
                    cdbiz.getCode(), ENode.input_interview.getCode());

            // 更新提交节点信息
            cdbizBO.refreshIntevNodeStatus(cdbiz, ENode.input_interview.getCode(),
                    ECdbizStatus.B00.getCode());
        }

        // 修改业务主节点状态
        cdbiz.setCurNodeCode(nodeFlow.getNextNode());
        cdbiz.setStatus(ECdbizStatus.A1.getCode());
        cdbizBO.refreshCurNodeStatus(cdbiz);
    }

    /**
     * 征信人
     */
    private void modifyCreditUser(String bizCode,
            List<XN632110ReqCreditUser> childList, boolean isAdd) {
        if (!isAdd) {
            // 删除
            creditUserBO.removeCreditUserByBizCode(bizCode);
        }

        // 申请人条数验证
        int applyUserCount = 0;
        if (CollectionUtils.isNotEmpty(childList)) {
            int guaUserCount = 0;
            for (XN632110ReqCreditUser child : childList) {
                if (ECreditUserLoanRole.APPLY_USER.getCode().equals(
                        child.getLoanRole())) {
                    applyUserCount++;
                    // 征信单设置客户姓名（征信人员的申请人）
                }
                if (applyUserCount > 1) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                            "征信申请人只能填写一条数据");
                }

                creditUserBO.saveCreditUser(child, bizCode, guaUserCount);

                if (ECreditUserLoanRole.GUARANTOR.getCode().equals(
                        child.getLoanRole())) {
                    guaUserCount += 1;
                }
                if (guaUserCount > 2) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(), "共还人不能超过两个");
                }
            }

            if (applyUserCount <= 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "请填写征信申请人数据");
            }
        }
    }

    /**
     * 二手车资料
     */
    private void secondHandOperate(Cdbiz cdbiz, String secondCarReport,
            String xszFront, String xszReverse) {
        if (ENewBizType.second_hand.getCode().equals(cdbiz.getBizType())) {
            // 二手车报告
            EAttachName attachName = EAttachName.getMap().get(
                    EAttachName.second_car_report.getCode());
            attachmentBO.saveAttachment(cdbiz.getBizCode(),
                    attachName.getCode(), attachName.getValue(), secondCarReport);
            // 行驶证正面
            attachName = EAttachName.getMap().get(
                    EAttachName.xsz_front.getCode());
            attachmentBO.saveAttachment(cdbiz.getBizCode(),
                    attachName.getCode(), attachName.getValue(), xszFront);
            // 行驶证反面
            attachName = EAttachName.getMap().get(
                    EAttachName.xsz_reverse.getCode());
            attachmentBO.saveAttachment(cdbiz.getBizCode(),
                    attachName.getCode(), attachName.getValue(), xszReverse);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendOrder(XN632119Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getBizCode());
        if (!ECdbizStatus.A1.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前征信单不能派单！");
        }
        // 修改内勤
        cdbizBO.refreshInsideJob(cdbiz, req.getInsideJob());

        //记录本次操作日志
        sysBizLogBO.saveFirstSYSBizLog(req.getBizCode(), EBizLogType.CREDIT, req.getBizCode(),
                ENode.assign.getCode(), null, req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void inputBankCreditResult(XN632111Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getBizCode());
        if (!ENode.input_credit.getCode().equals(cdbiz.getCurNodeCode())
                && !ENode.renew_credit.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是录入银行征信结果节点，不能操作");
        }
        for (XN632111ReqCreditUser reqCreditUser : req.getCreditList()) {
            if (StringUtils.isBlank(reqCreditUser.getBankCreditReport())) {
                CreditUser creditUser = creditUserBO
                        .getCreditUser(reqCreditUser.getCreditUserCode());
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        creditUser.getUserName() + "的征信结果未录入，不能操作");
            }
        }

        // 当前节点
        String preCurNodeCode = cdbiz.getCurNodeCode();
        String nextNode = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode)
                .getNextNode();

        cdbiz.setStatus(ECdbizStatus.A2.getCode());
        cdbiz.setCurNodeCode(nextNode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(req.getBizCode(), EBizLogType.CREDIT,
                req.getBizCode(), preCurNodeCode, null, req.getOperator());

        // 待办事项处理
        bizTaskBO.handlePreAndAdd(EBizLogType.CREDIT, cdbiz.getCode(),
                cdbiz.getCode(), preCurNodeCode, nextNode, req.getOperator());

        List<XN632111ReqCreditUser> creditResult = req.getCreditList();
        int guaUserCount = 0;
        for (XN632111ReqCreditUser reqCreditUser : creditResult) {
            // 录入结果与说明
            CreditUser creditUser = creditUserBO.getCreditUser(reqCreditUser
                    .getCreditUserCode());
            creditUserBO.inputBankCreditResult(creditUser, reqCreditUser);

            EAttachName attachNameBank = null;
            EAttachName attachNameData = null;
            // 报告
            if (ECreditUserLoanRole.APPLY_USER.getCode().equals(
                    creditUser.getLoanRole())) {
                attachNameBank = EAttachName.getMap().get(
                        EAttachName.mainLoaner_bank.getCode());
                attachNameData = EAttachName.getMap().get(
                        EAttachName.mainLoaner_data.getCode());

            } else if (ECreditUserLoanRole.GHR.getCode().equals(
                    creditUser.getLoanRole())) {
                attachNameBank = EAttachName.getMap().get(
                        EAttachName.replier_bank.getCode());
                attachNameData = EAttachName.getMap().get(
                        EAttachName.replier_data.getCode());

            } else if (ECreditUserLoanRole.GUARANTOR.getCode().equals(
                    creditUser.getLoanRole())) {
                if (guaUserCount > 0) {
                    attachNameBank = EAttachName.getMap().get(
                            EAttachName.assurance_bank1.getCode());
                    attachNameData = EAttachName.getMap().get(
                            EAttachName.assurance_data1.getCode());
                } else {
                    attachNameBank = EAttachName.getMap().get(
                            EAttachName.assurance_bank.getCode());
                    attachNameData = EAttachName.getMap().get(
                            EAttachName.assurance_data.getCode());
                    guaUserCount += 1;
                }
            }

            attachmentBO.saveAttachment(cdbiz.getCode(),
                    attachNameBank.getCode(), attachNameBank.getValue(),
                    reqCreditUser.getBankCreditReport());
            attachmentBO.saveAttachment(cdbiz.getCode(),
                    attachNameData.getCode(), attachNameData.getValue(),
                    reqCreditUser.getDataCreditReport());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void audit(XN632113Req req) {
        sysUserBO.getUser(req.getOperator());

        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ECdbizStatus.A2.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该业务不处于待审核征信状态");
        }

        // 当前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);

        // 审核通过
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            for (CreditUser creditUser : req.getCreditUserList()) {
                CreditUser user = creditUserBO.getCreditUser(creditUser
                        .getCode());
                user.setRelation(creditUser.getRelation());
                user.setLoanRole(creditUser.getLoanRole());
                creditUserBO.refreshCreditUserLoanRole(user);
            }
            // 审核通过，改变节点
            cdbiz.setStatus(ECdbizStatus.A3.getCode());
            cdbiz.setCurNodeCode(ENode.input_budget.getCode());
            cdbizBO.refreshCurNodeStatus(cdbiz);

            // 制卡节点
            cdbizBO.refreshMakeCardNode(cdbiz, ENode.make_card_apply.getCode());

            // 制卡状态
            cdbizBO.refreshMakeCardStatus(cdbiz, ECdbizStatus.H1.getCode());

            // 制卡待办事项
            bizTaskBO.saveBizTaskNew(req.getCode(), EBizLogType.makeCard,
                    req.getCode(), ENode.make_card_apply.getCode());

            // 准入单开始的待办事项
            bizTaskBO.saveBizTaskNew(cdbiz.getCode(), EBizLogType.BUDGET_ORDER,
                    req.getCode(), ENode.input_budget.getCode());

            // 生成用户
            CreditUser applyUser = creditUserBO.getCreditUserByBizCode(
                    req.getCode(), ECreditUserLoanRole.APPLY_USER);

            User user = userBO.getUser(applyUser.getMobile(),
                    EUserKind.Customer.getCode());
            String userId;
            if (user == null) {
                // 用户代注册并实名认证
                userId = userBO.doRegisterAndIdentify(EBoolean.YES.getCode(),
                        applyUser.getMobile(), applyUser.getIdKind(),
                        applyUser.getUserName(), applyUser.getIdNo());
                distributeAccount(userId, applyUser.getMobile(),
                        EUserKind.Customer.getCode());

                smsOutBO.sendSmsOut(applyUser.getMobile(),
                        "您的手机号已注册【微车生活】APP，密码为'888888'，请妥善保管");
            } else {
                userId = user.getUserId();
            }

            RepayBiz repayBiz = new RepayBiz();
            repayBiz.setUserId(userId);
            repayBiz.setRealName(applyUser.getUserName());
            repayBiz.setIdKind(applyUser.getIdKind());
            repayBiz.setIdNo(applyUser.getIdNo());
            repayBiz.setBizCode(req.getCode());
            repayBiz.setRefType(ERepayBizType.CAR.getCode());
            repayBiz.setRefCode(req.getCode());
            repayBizBO.saveRepayBiz(repayBiz);

        } else {
            cdbiz.setCurNodeCode(nodeFlow.getBackNode());
            cdbiz.setStatus(ECdbizStatus.A1x.getCode());
            cdbizBO.refreshCurNodeStatus(cdbiz);
            // 重录征信单待办事项
            bizTaskBO.saveBizTaskNew(req.getCode(), EBizLogType.CREDIT,
                    req.getCode(), ENode.renew_credit.getCode());
        }

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(req.getCode(), EBizLogType.CREDIT,
                req.getCode(), preCurrentNode, req.getApproveNote(),
                req.getOperator());

        // 处理待审核待办事项
        bizTaskBO.handlePreBizTask(cdbiz.getCode(),
                EBizLogType.CREDIT.getCode(), req.getCode(), preCurrentNode,
                req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void accesssApplySubmit(String code, String operator) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ENode.input_budget.getCode().equals(cdbiz.getCurNodeCode())
                && !ENode.renew_budget.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是录入准入单资料节点，不能操作");
        }
        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(code);
        CreditUser applyUser = creditUserBO
                .getCreditUserByBizCode(code, ECreditUserLoanRole.APPLY_USER);
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(code);
        if (repayBiz.getPeriods() == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "贷款信息未填写完整，请补充完整再提交");
        }
        if (StringUtils.isBlank(carInfo.getVehicleCompanyName())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "车辆信息未填写完整，请补充完整再提交");
        }
        if (StringUtils.isBlank(applyUser.getEnglishName())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "客户信息未填写完整，请补充完整再提交");
        }
        if (StringUtils.isBlank(applyUser.getMarryState())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "家庭信息未填写完整，请补充完整再提交");
        }
        if (StringUtils.isBlank(applyUser.getCompanyName())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "工作信息未填写完整，请补充完整再提交");
        }
        String preNodeCode = cdbiz.getCurNodeCode(); // 当前节点

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.BUDGET_ORDER, code,
                preNodeCode, null, operator);
        // 下一个节点
        String nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
                .getNextNode();

        // 业务状态节点变化
        cdbiz.setCurNodeCode(nextNodeCode);
        cdbiz.setStatus(ECdbizStatus.A4.getCode());
        cdbizBO.refreshCurNodeStatus(cdbiz);
        // 处理待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER, code, code,
                preNodeCode, nextNodeCode, operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void interview(XN632123Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        String preCurrentNode = cdbiz.getIntevCurNodeCode();
        if (!ENode.input_interview.getCode().equals(preCurrentNode)
                && !ENode.reinput_interview.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是新录/重录面签节点，不能操作");
        }

        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);

        cdbizBO.interview(cdbiz, req);

        if (EBoolean.YES.getCode().equals(req.getIsSend())) {
            // 操作日志
            sysBizLogBO.saveNewSYSBizLog(req.getCode(), EBizLogType.INTERVIEW,
                    req.getCode(), preCurrentNode, null, req.getOperator());

            cdbizBO.refreshIntevNodeStatus(cdbiz, nodeFlow.getNextNode(),
                    ECdbizStatus.B01.getCode());

            // 处理待办事项
            bizTaskBO.handlePreAndAdd(EBizLogType.INTERVIEW, req.getCode(),
                    req.getCode(), preCurrentNode, nodeFlow.getNextNode(),
                    req.getOperator());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void interviewInternalApprove(String code, String operator,
            String approveResult, String approveNote) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ENode.approve_interview.getCode().equals(
                cdbiz.getIntevCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是内勤主管审核节点，不能操作");
        }

        String preCurrentNode = cdbiz.getIntevCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        String intevCurNodeCode;
        String mqStatus = "";
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            intevCurNodeCode = nodeFlow.getNextNode();
            // 面签业务状态记录
            mqStatus = ECdbizStatus.B03.getCode();

            // 生成资料传递
            String logisticsCode = logisticsBO.saveLogistics(
                    ELogisticsType.BUDGET.getCode(),
                    ELogisticsCurNodeType.SALE_SEND_BANK_LOAN.getCode(),
                    cdbiz.getCode(), cdbiz.getSaleUserId(),
                    ENode.submit_1.getCode(), ENode.receive_approve_1.getCode(),
                    null);

            // 资料传递日志:银行放款第一步，用记录日志的开始方法
            sysBizLogBO.saveFirstSYSBizLog(code, EBizLogType.LOGISTICS,
                    logisticsCode, ENode.submit_1.getCode(),
                    ENode.receive_approve_1.getCode(), operator);
            // 资料传递待办
            bizTaskBO.saveBizTaskNew(code, EBizLogType.LOGISTICS,
                    logisticsCode, ENode.submit_1.getCode());

            // 面签最后一步操作日志
            sysBizLogBO.saveNewSYSBizLog(cdbiz.getBizCode(),
                    EBizLogType.INTERVIEW, cdbiz.getCode(), preCurrentNode,
                    approveNote, operator);

            // 面签最后一步，处理前待办事项
            bizTaskBO.handlePreBizTask(code, EBizLogType.INTERVIEW.getCode(),
                    code, preCurrentNode, operator);
        } else {
            intevCurNodeCode = nodeFlow.getBackNode();
            mqStatus = ECdbizStatus.B02.getCode();

            // 操作日志
            sysBizLogBO.saveNewSYSBizLog(cdbiz.getBizCode(),
                    EBizLogType.INTERVIEW, cdbiz.getCode(), preCurrentNode,
                    approveNote, operator);

            // 添加待办事项
            bizTaskBO.handlePreAndAdd(EBizLogType.INTERVIEW, cdbiz.getCode(), cdbiz.getCode(),
                    preCurrentNode, ENode.reinput_interview.getCode(), operator);
        }
        cdbiz.setRemark(approveNote);

        // 更新面签节点和状态
        cdbizBO.refreshIntevNodeStatus(cdbiz, intevCurNodeCode, mqStatus);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void archive(XN632134Req req) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        String preEnterNodeCode = cdbiz.getEnterNodeCode();
        if (!ENode.first_receive_archive.getCode().equals(preEnterNodeCode)
                && !ENode.second_received_archive.getCode().equals(
                preEnterNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前状态不是入档状态，不能入档");
        }

        // 第一次存档
        if (ENode.first_receive_archive.getCode().equals(
                cdbiz.getEnterNodeCode())) {
            // 更新业务状态
            cdbizBO.refreshEnterNodeStatus(cdbiz, ECdbizStatus.D3.getCode(),
                    ENode.first_archive.getCode());
        }
        // 第二次存档
        if (ENode.second_received_archive.getCode().equals(
                cdbiz.getEnterNodeCode())) {
            // 更新业务状态
            cdbizBO.refreshEnterNodeStatus(cdbiz, ECdbizStatus.E3.getCode(),
                    ENode.second_archive.getCode());

            bizTaskBO.saveBizTaskNew(cdbiz.getCode(), EBizLogType.enter,
                    cdbiz.getCode(), ENode.confirm_archive.getCode());
        }
        cdbiz.setEnterLocation(req.getEnterLocation());
        cdbizBO.refreshLocation(cdbiz);

        // TODO 保存材料清单
        List<EnterFileList> fileList = req.getFileList();

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(cdbiz.getCode(), EBizLogType.enter,
                cdbiz.getCode(), preEnterNodeCode, null, req.getOperator());

        // 处理未处理的待办
        bizTaskBO.handlePreBizTask(cdbiz.getCode(),
                EBizLogType.enter.getCode(), cdbiz.getCode(), preEnterNodeCode,
                req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmArchive(String code, String operator,
            String enterLocation) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ENode.second_archive.getCode().equals(cdbiz.getEnterNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前状态不是已入档状态，不能确认入档");
        }

        // 绑定用户银行卡
        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(cdbiz.getCode());
        repayBiz.setLoanBank(cdbiz.getLoanBank());
        repayBiz.setBankcardCode(cdbiz.getRepayCardNumber());
        repayBiz.setRestPeriods(repayBiz.getPeriods());
        repayBiz.setRestAmount(repayBiz.getLoanAmount());
        repayBiz.setRestTotalCost(0L);
        repayBiz.setOverdueAmount(0L);
        repayBiz.setTotalOverdueCount(0);
        repayBiz.setCurOverdueCount(0);
        Date loanDate = DateUtil.getTodayStart();
        repayBiz.setLoanStartDatetime(loanDate);
        Date addMonths = DateUtils.addMonths(loanDate, repayBiz.getPeriods());
        repayBiz.setLoanEndDatetime(addMonths);
        repayBiz.setFxDeposit(0L);
        repayBiz.setCurNodeCode(ERepayBizNode.TO_REPAY.getCode());

        if (repayBiz.getFirstRepayDatetime() == null) {
            Date date = DateUtil.getTomorrowStart(DateUtil.getTodayStart());
            repayBiz.setFirstRepayDatetime(date);
        }

        SYSUser user = sysUserBO.getUser(cdbiz.getSaleUserId());
        repayBiz.setTeamCode(user.getTeamCode());
        repayBizBO.refreshRepayBiz(repayBiz);

        // 自动生成还款业务
        // RepayBiz repayBiz = repayBizBO.generateCarLoanRepayBiz(
        // budgetOrder, userId, bankcardCode, operator);

        // 自动生成还款计划
        repayPlanBO.genereateNewRepayPlan(repayBiz);

        // 更新业务状态
        cdbizBO.refreshEnterNodeStatus(cdbiz, ECdbizStatus.E4.getCode(),
                ENode.confirm_archive.getCode());

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.BUDGET_ORDER,
                cdbiz.getCode(), ENode.confirm_archive.getCode(), null, operator);

        bizTaskBO.handlePreBizTask(code, EBizLogType.enter.getCode(), code,
                ENode.confirm_archive.getCode(), operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void entryFbh(XN632131Req req) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        String preFbhgpsNode = cdbiz.getFbhgpsNode();
        if (!ENode.input_fbh.getCode().equals(cdbiz.getFbhgpsNode())
                && !ENode.reinput_fbh.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是录入发保合节点，不能操作");
        }

        cdbiz.setFbhgpsNode(ENode.approve_fbh.getCode());
        cdbiz.setStatus(ECdbizStatus.C02.getCode());
        cdbizBO.refreshFbhgpsNodeStatus(cdbiz);

        // 更新车辆信息
        carInfoBO.entryFbhInfoByBiz(req.getCode(), req.getPolicyDatetime(),
                req.getPolicyDueDate());

        // 添加附件
        attachmentBO
                .saveAttachment(req.getCode(), "car_invoice", "car_procedure", req.getCarInvoice());
        attachmentBO
                .saveAttachment(req.getCode(), "car_jqx", "car_procedure", req.getCarJqx());
        attachmentBO
                .saveAttachment(req.getCode(), "car_syx", "car_procedure", req.getCarSyx());
        attachmentBO
                .saveAttachment(req.getCode(), "green_big_smj", "car_procedure",
                        req.getGreenBigSmj());

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(req.getCode(), EBizLogType.fbh,
                req.getCode(), preFbhgpsNode, null, req.getOperator());

        // 待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.fbh, req.getCode(),
                req.getCode(), preFbhgpsNode, ENode.approve_fbh.getCode(),
                req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void approveFbh(String code, String approveResult,
            String approveNote, String operator) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        String preFbhgpsNode = cdbiz.getFbhgpsNode();
        if (!ENode.approve_fbh.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是审核发保合节点，不能操作");
        }

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.fbh, code,
                preFbhgpsNode, approveNote, operator);

        String nextStatus;
        String nextNodeCode;
        if (EBoolean.NO.getCode().equals(approveResult)) {
            nextStatus = ECdbizStatus.C01x.getCode();
            nextNodeCode = ENode.reinput_fbh.getCode();
            // 待办事项
            bizTaskBO.handlePreAndAdd(EBizLogType.fbh, code, code,
                    preFbhgpsNode, nextNodeCode, operator);
        } else {

            if (EBoolean.YES.getCode().equals(cdbiz.getIsGpsAz())) {
                nextStatus = ECdbizStatus.C03.getCode();
                nextNodeCode = ENode.set_gps.getCode();
                // gps安装待办事项
                bizTaskBO.handlePreAndAdd(EBizLogType.gps, code, code,
                        preFbhgpsNode, nextNodeCode, operator);
            } else {
                nextStatus = ECdbizStatus.C07.getCode();
                nextNodeCode = ENode.fbh_finish.getCode();
                bizTaskBO.handlePreBizTask(code, EBizLogType.fbh.getCode(),
                        code, preFbhgpsNode, operator);
            }
        }

        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbizBO.refreshFbhgpsStatus(cdbiz, nextStatus);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void installGps(String code, String operator,
            List<XN632126ReqGps> gpsAzList) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        String preFbhgpsNode = cdbiz.getFbhgpsNode();
        if (!ENode.set_gps.getCode().equals(cdbiz.getFbhgpsNode())
                && !ENode.approve_fail_gps.getCode().equals(
                cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是安装gps节点，不能操作");
        }

        // 删除
        budgetOrderGpsBO.removeBudgetOrderGpsList(code);

        // 添加
        budgetOrderGpsBO.saveBudgetOrderGpsList(code, gpsAzList);

        String nextNodeCode = ENode.approve_gps.getCode();
        String nextStatus = ECdbizStatus.C04.getCode();

        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbiz.setFbhgpsStatus(nextStatus);
        cdbizBO.refreshFbhgpsNodeStatus(cdbiz);

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.gps, code,
                preFbhgpsNode, null, operator);

        // 待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.gps, code, code, preFbhgpsNode,
                nextNodeCode, operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void gpsManagerApprove(String code, String operator,
            String approveResult, String approveNote) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        String preFbhgpsNode = cdbiz.getFbhgpsNode();
        if (!ENode.approve_gps.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是GPS管理员审核节点，不能操作");
        }

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.gps, code,
                preFbhgpsNode, approveNote, operator);

        String nextNodeCode = ENode.gps_done.getCode();
        String nextStatus = ECdbizStatus.C06.getCode();

        if (EApproveResult.NOT_PASS.getCode().equals(approveResult)) {

            nextNodeCode = ENode.approve_fail_gps.getCode();
            nextStatus = ECdbizStatus.C05.getCode();

            // gps使用状态改为未使用
            List<BudgetOrderGps> list = budgetOrderGpsBO
                    .queryBudgetOrderGpsList(code);
            for (BudgetOrderGps budgetOrderGps : list) {
                gpsBO
                        .refreshUseGps(budgetOrderGps.getCode(), null, EBoolean.NO);
            }
            budgetOrderGpsBO.removeBudgetOrderGpsList(code);

            // 生成重新安装的待办事项
            bizTaskBO.handlePreAndAdd(EBizLogType.gps, code, code,
                    preFbhgpsNode, nextNodeCode, operator);
        } else {
            // gps安装结束待办事项
            bizTaskBO.handlePreBizTask(code, EBizLogType.gps.getCode(), code,
                    preFbhgpsNode, operator);
        }

        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbiz.setFbhgpsStatus(nextStatus);
        cdbizBO.refreshFbhgpsNodeStatus(cdbiz);

    }

    // 分配账号
    private void distributeAccount(String userId, String mobile, String kind) {
        List<String> currencyList = new ArrayList<String>();
        currencyList.add(ECurrency.CNY.getCode());
        currencyList.add(ECurrency.JF.getCode());
        currencyList.add(ECurrency.XYF.getCode());

        for (String currency : currencyList) {
            accountBO.distributeAccount(userId, mobile,
                    EAccountType.getAccountType(kind), currency);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void makeCardApply(String code, String operator,
            String cardPostAddress, String cardPostProvince, String cardPostCity,
            String cardPostArea, String cardPostCode, String redCardPic, String specialQuatoPic,
            String redCardPicWithIdPic) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        Bank bank = bankBO.getBank(cdbiz.getLoanBank());
        if (!ECdbizStatus.H1.getCode().equals(cdbiz.getMakeCardStatus()) && !ECdbizStatus.H1
                .getCode().equals(cdbiz.getMakeCardStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是制卡状态，录入制卡信息");
        }
        // 录入卡邮寄地址
        cdbizBO.refreshCardAddress(cdbiz, cardPostAddress, cardPostProvince, cardPostCity,
                cardPostArea, cardPostCode);
        // 附件
        if (StringUtils.isNotBlank(redCardPic)) {
            attachmentBO.saveAttachment(code, "red_card_pic", null, redCardPic);
        }
        if (StringUtils.isNotBlank(specialQuatoPic)) {
            attachmentBO.saveAttachment(code, "special_quato_pic", null, specialQuatoPic);
        }
        if (StringUtils.isNotBlank(redCardPicWithIdPic)) {
            attachmentBO
                    .saveAttachment(code, "red_card_pic_with_id_pic", null, redCardPicWithIdPic);
        }
        // 制卡节点
        cdbizBO.refreshMakeCardNode(cdbiz, ENode.input_card_number.getCode());
        // 制卡状态
        cdbizBO.refreshMakeCardStatus(cdbiz, ECdbizStatus.H2.getCode());
        // 处理前待办事项并产生下一条
        bizTaskBO.handlePreAndAdd(EBizLogType.makeCard, code, code,
                ENode.make_card_apply.getCode(), ENode.input_card_number.getCode(),
                operator);
        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.makeCard, code,
                ENode.make_card_apply.getCode(), ENode.make_card_apply.getValue(),
                operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void makeIcbankCard(String code) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ECdbizStatus.H2.getCode().equals(cdbiz.getMakeCardStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是回录卡号状态，无法工行制卡");
        }
        if (ENode.input_budget.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "请先录入准入单再进行工行制卡");
        }
        cdbizBO.icbankMakeCard(code);

        cdbizBO.refreshMakeCardStatus(cdbiz, ECdbizStatus.H4.getCode());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void inputCardNumber(String code, String cardNumber, String operator) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ECdbizStatus.H2.getCode().equals(cdbiz.getMakeCardStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是回录卡号状态，无法录入");
        }
        // 录入卡号
        cdbiz.setRepayCardNumber(cardNumber);
        // 制卡节点
        cdbiz.setMakeCardNode(ENode.make_card_finish.getCode());
        // 制卡状态
        cdbiz.setMakeCardStatus(ECdbizStatus.H3.getCode());
        cdbizBO.refreshCdbiz(cdbiz);

        // 制卡最后一步处理前待办事项
        bizTaskBO.handlePreBizTask(code, EBizLogType.makeCard.getCode(), code,
                ENode.input_card_number.getCode(), operator);
        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.makeCard, code,
                ENode.input_card_number.getCode(),
                ENode.input_card_number.getValue(), operator);
    }

    @Override
    public Paginable<Cdbiz> queryCdbizPage(int start, int limit, Cdbiz condition) {
        Paginable<Cdbiz> page = null;
        SYSUser sysUser = sysUserBO.getUser(condition.getUserId());
        //不传isMy是在业务中查询
        if (StringUtils.isBlank(condition.getIsMy())) {

            // 如果传业务员，说明是查看业务员自己的
            if (StringUtils.isBlank(condition.getSaleUserId())) {

                if (null != sysUser) {
                    if (ESysRole.SALE.getCode().equals(sysUser.getRoleCode())) {
                        condition.setSaleUserId(condition.getUserId());
                    }
                    if (ESysRole.YWNQ.getCode().equals(sysUser.getRoleCode())) {
                        condition.setInsideJob(condition.getUserId());
                    }

                    condition.setRoleCode(sysUser.getRoleCode());
                }

            }
            page = cdbizBO.getPaginableByRoleCode(condition, start, limit);
            //传isMy是在报表中心查询
        } else {
            BizTeam bizTeam = bizTeamBO.getBizTeam(sysUser.getTeamCode());
            //判断是否是团队长
            if (null != bizTeam) {
                if (sysUser.getUserId().equals(bizTeam.getCaptain())) {
                    condition.setTeamCode(sysUser.getTeamCode());
                }
            }
            page = cdbizBO.getPaginable(start, limit, condition);
        }

        for (Cdbiz cdbiz : page.getList()) {
            pageInit(cdbiz);
        }
        return page;
    }

    @Override
    public Paginable<Cdbiz> queryCdbizPageAll(int start, int limit, Cdbiz condition) {
        Paginable<Cdbiz> page = cdbizBO.getPaginable(start, limit, condition);
        if (page != null) {
            for (Cdbiz cdbiz : page.getList()) {
                pageInit(cdbiz);
            }
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
    public Paginable<Cdbiz> queryIntevVideo(int start, int limit, Cdbiz condition) {
        Paginable<Cdbiz> page = null;
        SYSUser sysUser = sysUserBO.getUser(condition.getUserId());

        // 如果传业务员，说明是查看业务员自己的
        if (StringUtils.isBlank(condition.getSaleUserId())) {
            if (ESysRole.SALE.getCode().equals(sysUser.getRoleCode())) {
                condition.setSaleUserId(condition.getUserId());
            }
            if (ESysRole.YWNQ.getCode().equals(sysUser.getRoleCode())) {
                condition.setInsideJob(condition.getUserId());
            }
            condition.setRoleCode(sysUser.getRoleCode());
        }
        page = cdbizBO.getPaginableByRoleCode(condition, start, limit);

        if (page != null) {
            for (Cdbiz cdbiz : page.getList()) {
                // 附件
                List<Attachment> attachmentList = attachmentBO
                        .queryBizAttachments(cdbiz.getCode());
                cdbiz.setAttachments(attachmentList);

                // 主贷人信息
                CreditUser mainCreditUser = creditUserBO
                        .getCreditUserByBizCode(cdbiz.getCode(), ECreditUserLoanRole.APPLY_USER);
                cdbiz.setCreditUser(mainCreditUser);

                //车辆信息
                CarInfo carInfo = carInfoBO.getCarInfoByBizCode(cdbiz.getCode());
                CarInfoRes carInfoRes = new CarInfoRes();
                if (null != carInfo) {
                    BeanUtils.copyProperties(carInfo, carInfoRes);
                }
                cdbiz.setCarInfoRes(carInfoRes);
                //面签时间
                SYSBizLog intevBizLog = sysBizLogBO
                        .getLogByNode(ENode.input_interview.getCode(), cdbiz.getCode());
                if (intevBizLog != null) {
                    cdbiz.setIntevDateTime(intevBizLog.getEndDatetime());
                }
            }
        }
        return page;
    }

    @Override
    public Cdbiz getCdbiz(String code) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        init(cdbiz);
        return cdbiz;
    }

    private void init(Cdbiz cdbiz) {

        // 征信人列表
        List<CreditUser> creditUserList = creditUserBO
                .queryCreditUserList(cdbiz.getCode());
        cdbiz.setCreditUserList(creditUserList);

        // 主贷人信息
        CreditUser mainCreditUser = null;
        for (CreditUser creditUser : creditUserList) {
            if (ECreditUserLoanRole.APPLY_USER.getCode().equals(
                    creditUser.getLoanRole())) {
                mainCreditUser = creditUser;
                break;
            }
        }
        if (null == mainCreditUser) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "主贷人不能为空");

        }
        cdbiz.setCreditUser(mainCreditUser);

        // 车辆信息
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(cdbiz.getCode());
        LoanInfoRes loanInfoRes = new LoanInfoRes();
        CarInfoRes carInfoRes = new CarInfoRes();
        if (carInfo != null) {
            BeanUtils.copyProperties(carInfo, loanInfoRes);
            BeanUtils.copyProperties(carInfo, carInfoRes);
            carInfoRes.setCarSettleDatetime(carInfo.getCarSettleDatetime());
            carInfoRes.setPolicyDueDate(carInfo.getPolicyDueDate());
            carInfoRes.setCarSettleDatetime(carInfo.getCarSettleDatetime());
        }

        // 还款信息
        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(cdbiz.getCode());
        if (repayBiz != null) {
            BeanUtils.copyProperties(repayBiz, loanInfoRes);
            BeanUtils.copyProperties(repayBiz, carInfoRes);

            //还款计划
            if (StringUtils.isNotBlank(repayBiz.getCode())) {
                List<RepayPlan> repayPlanList = repayPlanBO
                        .queryRepayPlanListByRepayBizCode(repayBiz.getCode());
                cdbiz.setRepayPlanList(repayPlanList);
            }
            cdbiz.setRestAmount(repayBiz.getRestAmount());
        }

        BeanUtils.copyProperties(cdbiz, loanInfoRes);
        BeanUtils.copyProperties(cdbiz, carInfoRes);

        // 车辆信息
        cdbiz.setCarInfoRes(carInfoRes);
        // 贷款信息
        cdbiz.setLoanInfo(loanInfoRes);

        // 车辆抵押
        CarPledge carPledge = carPledgeBO
                .getCarPledgeByBizCode(cdbiz.getCode());
        cdbiz.setCarPledge(carPledge);

        // 财务垫资
        Advance advance = advanceBO.getAdvanceByBizCode(cdbiz.getCode());
        cdbiz.setAdvance(advance);

        BankLoan bankLoan = bankLoanBO.getBankLoanByBiz(cdbiz.getCode());
        cdbiz.setBankLoan(bankLoan);

        // 返点列表
        List<Repoint> repointList = repointBO.queryRepointList(cdbiz.getCode());
        cdbiz.setRepointList(repointList);

        // 手续费
        BudgetOrderFee budgetOrderFee = budgetOrderFeeBO
                .getBudgetOrderFeeByBudget(cdbiz.getCode());
        cdbiz.setBudgetOrderFee(budgetOrderFee);

        // 征信人流水列表
        List<CreditJour> creditJourList = creditJourBO
                .querCreditJoursByBizCode(cdbiz.getCode());
        cdbiz.setCreditJours(creditJourList);

        // 待办事项
        List<BizTask> bizTaskList = bizTaskBO.queryBizTaskByBizCode(cdbiz
                .getCode());
        cdbiz.setBizTasks(bizTaskList);

        // 操作日志
        List<SYSBizLog> bizLogList = sysBizLogBO.queryBizLogByBizCode(cdbiz
                .getCode());
        cdbiz.setBizLogs(bizLogList);

        //面签生成时间
        if (CollectionUtils.isNotEmpty(bizLogList)) {
            for (SYSBizLog bizLog : bizLogList) {
                if (bizLog.getDealNode().equals(ENode.input_interview.getCode())) {
                    cdbiz.setIntevDateTime(bizLog.getEndDatetime());
                }
            }
        }

        // GPS安装列表
        List<BudgetOrderGps> budgetOrderGpsList = budgetOrderGpsBO
                .queryBudgetOrderGpsList(cdbiz.getCode());
        cdbiz.setBudgetOrderGps(budgetOrderGpsList);

        // 附件
        List<Attachment> attachmentList = attachmentBO
                .queryBizAttachments(cdbiz.getCode());
        cdbiz.setAttachments(attachmentList);

        //作废原因
        SYSBizLog condition = new SYSBizLog();
        condition.setBizCode(cdbiz.getCode());
        condition.setDealNode(ENode.cancel_apply.getCode());
        List<SYSBizLog> sysBizLogList = sysBizLogBO.querySYSBizLogList(condition);
        if (CollectionUtils.isNotEmpty(sysBizLogList)) {
            SYSBizLog sysBizLog = sysBizLogList.get(sysBizLogList.size() - 1);
            cdbiz.setCancelReason(sysBizLog.getDealNote());
        }

    }

    private void pageInit(Cdbiz cdbiz) {
        // 主贷人信息
        CreditUser mainCreditUser = creditUserBO
                .getCreditUserByBizCode(cdbiz.getCode(), ECreditUserLoanRole.APPLY_USER);
        cdbiz.setCreditUser(mainCreditUser);

        LoanInfoRes loanInfoRes = new LoanInfoRes();
        loanInfoRes.setPeriods(cdbiz.getPeriods());
        cdbiz.setLoanInfo(loanInfoRes);

        //面签时间
        SYSBizLog intevBizLog = sysBizLogBO
                .getLogByNode(ENode.input_interview.getCode(), cdbiz.getCode());
        if (intevBizLog != null) {
            cdbiz.setIntevDateTime(intevBizLog.getEndDatetime());
        }

        //作废原因
        SYSBizLog cancelBizLog = sysBizLogBO
                .getLogByNode(ENode.cancel_apply.getCode(), cdbiz.getCode());
        if (cancelBizLog != null) {
            cdbiz.setCancelReason(cancelBizLog.getDealNote());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void creditBank(String code) {

        CreditUser creditUser = creditUserBO.getCreditUser(code);
        if (!ECreditUserStatus.to_icCredit.getCode().equals(
                creditUser.getStatus()) && !"099".equals(creditUser.getResult())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该征信用户已发起工行征信，无需重复征信");
        }
        cdbizBO.creditIcBank(creditUser);
    }

    @Override
    public Paginable<Cdbiz> queryIcbankCdbiz(int start, int limit, String userId) {
        Cdbiz condition = new Cdbiz();
        SYSUser sysUser = sysUserBO.getUser(userId);
        condition.setRoleCode(sysUser.getRoleCode());
        condition.setTeamCode(sysUser.getTeamCode());
        condition.setCurNodeCode(ENode.input_credit.getCode());
        Paginable<Cdbiz> page = cdbizBO.getPaginableByRoleCode(condition,
                start, limit);
        for (Cdbiz cdbiz : page.getList()) {
            List<CreditUser> creditUserList = creditUserBO
                    .queryCreditUserList(cdbiz.getCode());
            for (CreditUser creditUser : creditUserList) {
                if (ECreditUserStatus.to_callback.getCode().equals(
                        creditUser.getStatus())) {
                    CreditIcbank creditIcbank = creditUserBO
                            .getCreditIcbank(creditUser.getIcbankCode());
                    creditUserBO.refreshIcbankCredit(creditUser, creditIcbank);
                }
            }
            init(cdbiz);
        }
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void applyCancel(XN632190Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ECdbizStatus.G0.getCode().equals(cdbiz.getCancelStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该业务状态已无法作废");
        }
        if (!req.getOperator().equals(cdbiz.getSaleUserId())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "不是该业务业务员无法作废该业务");
        }
        // 更新作废节点状态
        cdbizBO.refreshZfStatus(cdbiz, ECdbizStatus.G2.getCode(),
                ENode.biz_approve.getCode());
        ENode node = ENode.cancel_apply;
        // 操作日志
        sysBizLogBO.saveFirstSYSBizLog(req.getCode(), EBizLogType.cancel,
                req.getCode(), node.getCode(), req.getRemark(), req.getOperator());

        node = ENode.biz_approve;
        // 待办事项
        bizTaskBO.saveBizTaskNew(req.getCode(), EBizLogType.cancel,
                req.getCode(), node.getCode());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelBizAudit(XN632191Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ENode.biz_approve.getCode().equals(cdbiz.getCancelNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前状态不是业务总监审核，不能操作");
        }
        String cancelNode = cdbiz.getCancelNodeCode();
        String cancelStatus = cdbiz.getCancelStatus();

        // 处理待办事项
        bizTaskBO.handlePreBizTask(req.getCode(), EBizLogType.cancel.getCode(),
                req.getCode(), cancelNode, req.getOperator());
        ENode node = null;
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            Advance advance = advanceBO.getAdvanceByBizCode(req.getCode());

            // 判断是否已垫资 如果已经垫资 下一个节点是财务审核节点 未垫资 下一个节点是废流程结束节点
            if (null != advance && null != advance.getAdvanceFundAmount()
                    && null != advance.getAdvanceFundDatetime()) {
                node = ENode.money_approve;
                cancelStatus = ECdbizStatus.G3.getCode();

                // 待办事项
                bizTaskBO.saveBizTaskNew(req.getCode(), EBizLogType.cancel,
                        req.getCode(), node.getCode());
            } else {// 没垫资情况
                node = ENode.cancel_end;
                cancelStatus = ECdbizStatus.G4.getCode();
            }

        } else {
            node = null;
            cancelStatus = ECdbizStatus.G0.getCode();
        }
        cdbizBO.refreshZfStatus(cdbiz, cancelStatus,
                null == node ? null : node.getCode());

        // 操作日志
        sysBizLogBO.saveFirstSYSBizLog(req.getCode(), EBizLogType.cancel,
                req.getCode(), cancelNode, req.getApproveNote(), req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelFinanceAudit(XN632192Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ENode.money_approve.getCode().equals(cdbiz.getCancelNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是作废流程财务总监审核节点，不能操作");
        }

        String cancelNode = cdbiz.getCancelNodeCode();
        String cancelStatus = cdbiz.getCancelStatus();
        // 处理待办事项
        bizTaskBO.handlePreBizTask(req.getCode(), EBizLogType.cancel.getCode(),
                req.getCode(), cancelNode, req.getOperator());
        ENode node = ENode.biz_approve;
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            node = ENode.cancel_end;
            cancelStatus = ECdbizStatus.G4.getCode();

        } else {
            cancelNode = null;
            cancelStatus = ECdbizStatus.G0.getCode();
        }
        cdbizBO.refreshZfStatus(cdbiz, cancelStatus,
                null == node ? null : node.getCode());
        // 操作日志
        sysBizLogBO.saveFirstSYSBizLog(req.getCode(), EBizLogType.cancel,
                req.getCode(), cancelNode, req.getApproveNote(), req.getOperator());
    }

    @Override
    public void editRemark(String code, String remark) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        cdbiz.setMakeCardStatus(ECdbizStatus.H4.getCode());
        cdbiz.setRemark(remark);
        cdbizBO.refreshCdbiz(cdbiz);
    }

}
