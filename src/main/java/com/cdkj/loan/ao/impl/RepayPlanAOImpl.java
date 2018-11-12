package com.cdkj.loan.ao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICostAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.ICostBO;
import com.cdkj.loan.bo.ICreditscoreBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRemindLogBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.Cost;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RemindLog;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.domain.SYSConfig;
import com.cdkj.loan.dto.req.XN630532Req;
import com.cdkj.loan.dto.req.XN630535Req;
import com.cdkj.loan.dto.req.XN630544Req;
import com.cdkj.loan.dto.req.XN630545Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.EDealResult;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.enums.EResultStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class RepayPlanAOImpl implements IRepayPlanAO {

    private static final Logger logger = LoggerFactory
        .getLogger(RepayPlanAOImpl.class);

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayBizAO repayBizAO;

    @Autowired
    private ICostAO costAO;

    @Autowired
    private ICostBO costBO;

    @Autowired
    ICreditscoreBO creditscoreBO;

    @Autowired
    IAccountBO accountBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Autowired
    IRemindLogBO remindLogBO;

    @Autowired
    IBankcardBO bankcardBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    public Paginable<RepayPlan> queryRepayPlanPage(int start, int limit,
            RepayPlan condition) {
        Paginable<RepayPlan> results = repayPlanBO.getPaginable(start, limit,
            condition);
        for (RepayPlan repayPlan : results.getList()) {
            repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
            repayPlan.setRepayBiz(
                repayBizAO.getRepayBiz(repayPlan.getRepayBizCode()));

        }

        return results;
    }

    @Override
    public List<RepayPlan> queryRepayPlanList(RepayPlan condition) {
        return repayPlanBO.queryRepayPlanList(condition);
    }

    @Override
    public RepayPlan getRepayPlan(String code) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
        repayPlan
            .setRepayBiz(repayBizBO.getRepayBiz(repayPlan.getRepayBizCode()));
        Cost cost = new Cost();
        cost.setRepayPlanCode(code);
        List<Cost> list = costBO.queryCostList(cost);
        repayPlan.setCostList(list);

        RemindLog remindLog = new RemindLog();
        remindLog.setRepayPlanCode(code);
        List<RemindLog> remindLogList = remindLogBO
            .queryRemindLogList(remindLog);
        repayPlan.setRemindLogList(remindLogList);

        String bankcardCode = repayBizBO
            .getRepayBiz(repayPlan.getRepayBizCode()).getBankcardCode();
        String bankcardNumber = bankcardBO.getBankcard(bankcardCode)
            .getBankcardNumber();
        repayPlan.setBankcardNumber(bankcardNumber);

        repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
        repayPlan
            .setRepayBiz(repayBizAO.getRepayBiz(repayPlan.getRepayBizCode()));

        return repayPlan;
    }

    private void addCreditScore(RepayPlan repayPlan) {
        // 加信用分
        Account account = accountBO.getAccountByUser(repayPlan.getUserId(),
            ECurrency.XYF.getCode());

        // 判断是汽车还是商品
        String refType = repayPlan.getRefType();
        BigDecimal changeScore = null;
        if (refType.equals(ERepayBizType.CAR.getCode())) {
            changeScore = sysConfigBO
                .getBigDecimalValue(SysConstants.CAR_NORMAL);
        } else {
            changeScore = sysConfigBO
                .getBigDecimalValue(SysConstants.PRODUCT_NORMAL);
        }
        creditscoreBO.changeCreditscore(account, changeScore,
            repayPlan.getCode(), "按月正常还款");
    }

    private Long baofuWithhold(Bankcard bankcard, Long amount) {
        Long successAmount = 0L;

        // TODO 宝付代扣逻辑
        successAmount = amount;

        return successAmount;
    }

    // 当月还款名单查询
    @Override
    public Object queryCurrentMonthRepayPage(int start, int limit,
            RepayPlan condition) {
        condition.setRepayStartDatetime(DateUtil.getFirstDay());
        condition.setRepayEndDatetime(DateUtil.getLastDay());
        Paginable<RepayPlan> results = repayPlanBO.getPaginable(start, limit,
            condition);
        for (RepayPlan repayPlan : results.getList()) {
            repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
            repayPlan.setRepayBiz(
                repayBizBO.getRepayBiz(repayPlan.getRepayBizCode()));
        }
        return results;
    }

    @Override
    @Transactional
    public void prepayPhoto(XN630544Req req) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(req.getCode());
        String preCurNodeCode = repayPlan.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode);
        if (!ERepayPlanNode.PRD_TO_REPAY.getCode()
            .equals(repayPlan.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该商品不处于划款中，不能操作！");
        }
        repayPlan.setCurNodeCode(nodeFlow.getNextNode());
        repayPlan.setPrepayPhoto(req.getPrepayPhoto());
        repayPlanBO.refreshPrepayPhoto(repayPlan);

    }

    @Override
    @Transactional
    public void prepayPhotoApprove(XN630545Req req) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(req.getCode());
        String preCurNodeCode = repayPlan.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode);
        if (!ERepayPlanNode.REPAY_APPROVE.getCode()
            .equals(repayPlan.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该商品不处于还款审核，不能操作！");
        }
        if (EBoolean.YES.getCode().equals(req.getApproveResult())) {
            repayPlan.setPayedAmount(repayPlan.getRepayAmount());
            repayPlan.setOverplusAmount(StringValidater.toLong("0"));
            repayPlan.setOverdueAmount(StringValidater.toLong("0"));
            repayPlan.setCurNodeCode(nodeFlow.getNextNode());
        } else {
            if (repayPlan.getRepayDatetime().before(new Date())) {
                repayPlan.setCurNodeCode(nodeFlow.getBackNode());
            } else {
                repayPlan.setPayedAmount(StringValidater.toLong("0"));
                repayPlan.setOverplusAmount(repayPlan.getRepayAmount());
                repayPlan.setOverdueAmount(repayPlan.getRepayAmount());
                repayPlan.setCurNodeCode(ERepayPlanNode.PRD_OVERDUE.getCode());
            }
        }
        repayPlanBO.prepayPhotoApprove(repayPlan);
    }

    public static void main(String[] args) {
        String x = "2018-06-14 00:00:00";
        Date xd = DateUtil.strToDate(x, DateUtil.DATA_TIME_PATTERN_1);
        if (xd.before(new Date())) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }

    // 逾期处理
    @Override
    @Transactional
    public void overdueHandle(XN630532Req req) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(req.getCode());
        if (!ERepayPlanNode.OVERDUE.getCode()
            .equals(repayPlan.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款计划不是逾期状态");
        }

        // 判断当前还款计划是否有多条红名单处理中，有则不能处理
        int count = repayPlanBO.getTotalCount(repayPlan.getRepayBizCode(),
            ERepayPlanNode.QKCSB_APPLY_TC);
        if (count >= 1) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "之前逾期还款计划还未处理完！");
        }

        RepayBiz repayBiz = repayBizBO.getRepayBiz(repayPlan.getRepayBizCode());
        if (!ERepayBizNode.TO_REPAY.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不是还款中，暂无法处理");
        }

        // 删除原来费用清单
        costAO.dropCost(req.getCode());
        // 添加费用清单
        costAO.addCost(req.getCode(), req.getCostList());
        long totalFee = 0;
        for (XN630535Req xn630535Req : req.getCostList()) {
            totalFee += StringValidater.toLong(xn630535Req.getAmount());
        }

        // 更新还款计划
        repayPlan
            .setOverdueDeposit(StringValidater.toLong(req.getOverdueDeposit()));
        repayPlan.setOverdueAmount(0L);
        repayPlan.setDepositWay(req.getOverdueDepositWay());
        repayPlan.setOverdueHandleNote(req.getRemark());
        repayPlan.setTotalFee(totalFee);
        if (EDealResult.GREEN.getCode().equals(req.getDealResult())) {
            repayPlan.setCurNodeCode(ERepayPlanNode.HANDLER_TO_GREEN.getCode());
        } else if (EDealResult.RED.getCode().equals(req.getDealResult())) {
            repayPlan.setCurNodeCode(ERepayPlanNode.HANDLER_TO_RED.getCode());
            // 更新还款业务未申请拖车节点
            repayBizBO.overdueRedMenuHandle(repayBiz,
                ERepayBizNode.QKCSB_APPLY_TC.getCode());
            // 日志
            sysBizLogBO.saveSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(),
                repayBiz.getCurNodeCode(), repayBiz.getTeamCode());
        } else if (EDealResult.YELLOW.getCode().equals(req.getDealResult())) {
            repayPlan
                .setCurNodeCode(ERepayPlanNode.HANDLER_TO_YELLOW.getCode());
        }
        repayPlanBO.refreshRepayPlanOverdueHandle(repayPlan);
    }

    @Override
    @Transactional
    public void payFee(String code, List<String> costList, String operator,
            String payType) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        // TODO 支付方式 扣款
        long totalFee = 0L;
        for (String costCode : costList) {
            Cost cost = costBO.getCost(costCode);
            if (EBoolean.YES.getCode().equals(cost.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "编号为：" + costCode + "的清收成本已缴纳！");
            }
            totalFee += cost.getAmount();
            costBO.refreshRepay(cost, payType);
        }
        repayPlan.setPayedFee(totalFee + repayPlan.getPayedFee());
        repayPlanBO.payFee(repayPlan);
    }

    @Override
    public void chargeRepayAmount(String code, String operator,
            String payType) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        repayPlan.setRealRepayAmount(repayPlan.getOverdueAmount());
        repayPlan.setIsRepay(EResultStatus.YES.getCode());
        // TODO 支付方式
        repayPlanBO.repayAmount(repayPlan);
    }

    @Override
    public void transferBlackByProduct(String code) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        repayPlan.setCurNodeCode(ERepayPlanNode.PRD_HANDLER_TO_BLACK.getCode());
        repayPlanBO.refreshToBlackProduct(repayPlan);
    }

    @Override
    public Long getUnsettledLoan() {
        RepayPlan condition = new RepayPlan();
        List<RepayPlan> results = repayPlanBO.queryRepayPlanList(condition);
        Long unsettledLoan = 0L;
        for (RepayPlan repayPlan : results) {
            if (repayPlan.getCurNodeCode()
                .equals(ERepayPlanNode.OVERDUE.getCode())
                    || repayPlan.getCurNodeCode()
                        .equals(ERepayPlanNode.HANDLER_TO_GREEN.getCode())) {
                Long amount = repayPlan.getTotalFee() - repayPlan.getPayedFee()
                        + repayPlan.getOverplusAmount();
                unsettledLoan = unsettledLoan + amount;
            }
        }
        return unsettledLoan;
    }

    @Override
    public Paginable<RepayPlan> queryRepayPlanPageByRoleCode(int start,
            int limit, RepayPlan condition) {
        Paginable<RepayPlan> paginable = repayPlanBO
            .getPaginableByRoleCode(start, limit, condition);
        for (RepayPlan repayPlan : paginable.getList()) {
            repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
            repayPlan.setRepayBiz(
                repayBizAO.getRepayBiz(repayPlan.getRepayBizCode()));

        }
        return paginable;
    }

    @Override
    public void doSettleDaily() {
        logger.info("***************开始扫结束还款计划***************");
        SYSConfig sysConfig = sysConfigBO
            .getSYSConfig(SysConstants.REPAYPLAN_STEP);
        int step = Integer.valueOf(sysConfig.getCvalue()); // 每次处理的条数
        while (true) {
            RepayPlan condition = new RepayPlan();
            // 10号还款，11号凌晨算正常还款
            condition.setRepayEndDatetime(
                DateUtil.getRelativeDateOfDays(DateUtil.getTodayStart(), -1));
            condition.setCurNodeCode(ERepayPlanNode.TO_REPAY.getCode());
            Paginable<RepayPlan> page = repayPlanBO.getPaginable(0, step,
                condition);
            if (null != page) {
                List<RepayPlan> list = page.getList();
                if (CollectionUtils.isNotEmpty(list)) {
                    doDailyRepayPlan(list);
                    if (list.size() < step) {// 最后一批
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        logger.info("***************结束扫结束还款计划***************");
    }

    @Override
    public void doSettleDailyProduct() {
        logger.info("***************开始扫结束还款计划***************");
        SYSConfig sysConfig = sysConfigBO
            .getSYSConfig(SysConstants.REPAYPLAN_STEP);
        int step = Integer.valueOf(sysConfig.getCvalue()); // 每次处理的条数
        while (true) {
            RepayPlan condition = new RepayPlan();
            // 10号还款，11号凌晨算正常还款
            condition.setRepayEndDatetime(
                DateUtil.getRelativeDateOfDays(DateUtil.getTodayStart(), -1));
            condition.setCurNodeCode(ERepayPlanNode.PRD_TO_REPAY.getCode());
            Paginable<RepayPlan> page = repayPlanBO.getPaginable(0, step,
                condition);
            if (null != page) {
                List<RepayPlan> list = page.getList();
                if (CollectionUtils.isNotEmpty(list)) {
                    doDailyRepayPlan(list);
                    if (list.size() < step) {// 最后一批
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        logger.info("***************结束扫结束还款计划***************");
    }

    // 逻辑:
    // 1、将本月还款计划更新为已还款
    // 2、如果最后一期还款计划已完成，将还款业务节点更改为提交结算单
    private void doDailyRepayPlan(List<RepayPlan> list) {
        for (RepayPlan repayPlan : list) {
            // 还款计划结算
            repayPlanBO.refreshSettleDaily(repayPlan,
                repayPlan.getRepayAmount());

            // 还款业务处理
            RepayBiz repayBiz = repayBizBO
                .getRepayBiz(repayPlan.getRepayBizCode());
            // 还款计划进行到最后一期，更新还款业务
            if (repayPlan.getPeriods() == repayPlan.getCurPeriods()) {
                repayBizBO.refreshRepayCarAll(repayBiz);
            } else {
                repayBizBO.refreshRestAmount(repayBiz,
                    repayPlan.getRepayAmount(), 1);
            }

            // 用户增加信用分
            addCreditScore(repayPlan);
        }
    }

}
