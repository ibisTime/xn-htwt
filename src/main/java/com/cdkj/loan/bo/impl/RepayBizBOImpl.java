package com.cdkj.loan.bo.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.IOrderBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.IRepayBizDAO;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.domain.SpecsOrder;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632500Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.exception.BizException;

@Component
public class RepayBizBOImpl extends PaginableBOImpl<RepayBiz> implements
        IRepayBizBO {

    @Autowired
    private IRepayBizDAO repayBizDAO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IBankcardAO bankcardAO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IOrderBO orderBO;

    @Autowired
    private ILoanProductBO loanProductBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Override
    public String saveRepayBiz(String bizCode) {
        RepayBiz repayBiz = new RepayBiz();
        String code = OrderNoGenerater.generate(EGeneratePrefix.REPAY_BIZ
            .getCode());
        repayBiz.setCode(code);
        repayBiz.setBizCode(bizCode);
        repayBiz.setRefType(ERepayBizType.CAR.getCode());
        repayBiz.setRefCode(bizCode);
        repayBizDAO.insert(repayBiz);
        return code;
    }

    @Override
    public String saveRepayBiz(XN632120Req req) {
        RepayBiz repayBiz = new RepayBiz();
        String code = OrderNoGenerater.generate(EGeneratePrefix.REPAY_BIZ
            .getCode());
        repayBiz.setCode(code);
        repayBiz.setBizCode(req.getCode());
        repayBiz.setLoanProductCode(req.getLoanProductCode());
        LoanProduct product = loanProductBO.getLoanProduct(req
            .getLoanProductCode());
        repayBiz.setLoanProductName(product.getName());
        repayBiz.setSfAmount(StringValidater.toLong(req.getFirstAmount()));
        repayBiz.setSfRate(StringValidater.toDouble(req.getFirstRate()));
        repayBiz.setPeriods(StringValidater.toInteger(req.getLoanPeriod()));
        repayBiz.setRefType(ERepayBizType.CAR.getCode());
        repayBiz.setRefCode(req.getCode());
        repayBizDAO.insert(repayBiz);
        return code;
    }

    @Override
    public String saveRepayBiz(XN632500Req req) {
        RepayBiz repayBiz = new RepayBiz();
        String code = OrderNoGenerater.generate(EGeneratePrefix.REPAY_BIZ
            .getCode());
        repayBiz.setCode(code);
        repayBiz.setBizCode(req.getCode());
        repayBiz.setLoanProductCode(req.getLoanProductCode());
        LoanProduct product = loanProductBO.getLoanProduct(req
            .getLoanProductCode());
        repayBiz.setLoanProductName(product.getName());
        repayBiz.setSfAmount(StringValidater.toLong(req.getFirstAmount()));
        repayBiz.setSfRate(StringValidater.toDouble(req.getFirstRate()));
        repayBiz.setPeriods(StringValidater.toInteger(req.getLoanPeriod()));
        repayBiz.setRefType(ERepayBizType.CAR.getCode());
        repayBiz.setRefCode(req.getCode());
        repayBizDAO.insert(repayBiz);
        return code;
    }

    @Override
    public void refreshBankcardNew(String code, String bankcardCode,
            String updater, String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setBankcardCode(bankcardCode);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizDAO.updateBankcard(repayBiz);
    }

    @Override
    public void refreshBankcardModify(String code, String bankcardCode,
            String updater, String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        String bankcardCodelist = repayBiz.getBankcardCode();
        if (!bankcardCode.equals(bankcardCodelist)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "还款卡编号"
                    + bankcardCode + "不存在，请重新添加！！！");
        }
        repayBiz.setBankcardCode(bankcardCode);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizDAO.updateBankcard(repayBiz);
    }

    @Override
    public RepayBiz generateCarLoanRepayBiz(BudgetOrder budgetOrder,
            String userId, String bankcardCode, String operator) {
        RepayBiz repayBiz = new RepayBiz();
        String code = OrderNoGenerater.generate(EGeneratePrefix.REPAY_BIZ
            .getCode());
        repayBiz.setCode(code);
        repayBiz.setRefType(ERepayBizType.CAR.getCode());
        repayBiz.setRefCode(budgetOrder.getCode());
        repayBiz.setUserId(userId);
        repayBiz.setRealName(budgetOrder.getApplyUserName());
        repayBiz.setIdKind(budgetOrder.getIdKind());
        repayBiz.setIdNo(budgetOrder.getIdNo());

        repayBiz.setBankcardCode(bankcardCode);
        repayBiz.setBizPrice(budgetOrder.getInvoicePrice());
        repayBiz.setSfRate(budgetOrder.getFirstRate());
        repayBiz.setSfAmount(budgetOrder.getFirstAmount());
        Bank bank = bankBO.getBank(budgetOrder.getLoanBank());
        repayBiz.setLoanBank(bank.getBankCode());// 存ICBC样式
        repayBiz.setLoanAmount(budgetOrder.getLoanAmount());

        repayBiz.setFxDeposit(0L);
        repayBiz.setPeriods(StringValidater.toInteger(budgetOrder
            .getLoanPeriod()));
        repayBiz.setRestPeriods(repayBiz.getPeriods());
        repayBiz.setBankRate(0.0);// 作废

        repayBiz.setBankFkDatetime(budgetOrder.getBankFkDatetime());
        Date loanDate = DateUtil.getTodayStart();
        repayBiz.setLoanStartDatetime(loanDate);
        Date addMonths = DateUtils.addMonths(loanDate, repayBiz.getPeriods());
        repayBiz.setLoanEndDatetime(addMonths);
        repayBiz.setFxDeposit(0L);

        repayBiz
            .setFirstRepayDatetime(budgetOrder.getRepayFirstMonthDatetime());
        repayBiz.setFirstRepayAmount(budgetOrder.getRepayFirstMonthAmount());

        // int i = 0;
        // String string = budgetOrder.getRepayBankDate().toString();
        // String[] split = string.split("-");
        // String s = split[split.length - 1];
        // i = StringValidater.toInteger(s);
        repayBiz.setMonthDatetime(budgetOrder.getRepayBankDate());
        repayBiz.setMonthAmount(budgetOrder.getRepayMonthAmount());
        repayBiz.setLyDeposit(budgetOrder.getMonthDeposit());
        repayBiz.setCutLyDeposit(0L);
        repayBiz.setCurNodeCode(ERepayBizNode.TO_REPAY.getCode());

        // 剩余欠款：首期月供+每期月供*（期数-1）
        Long restAmount = budgetOrder.getRepayFirstMonthAmount()
                + budgetOrder.getRepayMonthAmount()
                * (StringValidater.toLong(budgetOrder.getLoanPeriod()) - 1);
        repayBiz.setRestAmount(restAmount);
        repayBiz.setRestTotalCost(0L);
        repayBiz.setTotalInDeposit(0L);
        repayBiz.setOverdueAmount(0L);
        repayBiz.setTotalOverdueCount(0);

        repayBiz.setCurOverdueCount(0);
        repayBiz.setBlackHandleNote("暂无");
        repayBiz.setIsAdvanceSettled(EBoolean.NO.getCode());
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(budgetOrder.getRemark());

        repayBiz.setTeamCode(budgetOrder.getTeamCode());
        repayBizDAO.insert(repayBiz);
        return repayBiz;
    }

    @Override
    public void refreshRepayCarAll(RepayBiz repayBiz) {
        repayBiz.setRestAmount(0L);
        repayBiz.setCurNodeCode(ERepayBizNode.QKCS_DEPART_CHECK.getCode());// 到清欠催收部审核节点
        repayBiz.setRestPeriods(0);
        repayBiz.setRemark("清欠催收部待审核");
        repayBiz.setUpdateDatetime(new Date());
        repayBizDAO.updateRepayAll(repayBiz);
        // 日志
        sysBizLogBO.saveSYSBizLog(repayBiz.getRefCode(), EBizLogType.REPAY_BIZ,
            repayBiz.getCode(), repayBiz.getCurNodeCode());
    }

    @Override
    public void overdueRedMenuHandle(RepayBiz data, String curNodeCode) {
        data.setCurNodeCode(curNodeCode);
        repayBizDAO.overdueRedHandle(data);
    }

    @Override
    public void confirmSettledProduct(RepayBiz data) {
        repayBizDAO.updateConfirmSettledProduct(data);
    }

    @Override
    public void refreshAdvanceRepayCarLoan(RepayBiz repayBiz,
            Long realWithholdAmount) {
        repayBiz.setCurNodeCode(ERepayBizNode.QKCS_DEPART_CHECK.getCode());
        repayBiz.setIsAdvanceSettled(EBoolean.YES.getCode());
        repayBiz.setRestPeriods(0);
        repayBiz.setRestAmount(0L);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark("已结清，待清欠催收部审核");
        repayBizDAO.updateRepayAllAdvance(repayBiz);
        // 日志
        sysBizLogBO.saveSYSBizLog(repayBiz.getRefCode(), EBizLogType.REPAY_BIZ,
            repayBiz.getCode(), repayBiz.getCurNodeCode());
    }

    @Override
    public RepayBiz generateProductLoanRepayBiz(SpecsOrder specsOrder) {
        Order order = orderBO.getOrder(specsOrder.getOrderCode());
        RepayBiz repayBiz = new RepayBiz();
        String code = OrderNoGenerater.generate(EGeneratePrefix.REPAY_BIZ
            .getCode());

        repayBiz.setCode(code);
        repayBiz.setRefType(ERepayBizType.PRODUCT.getCode());
        User applyUser = userBO.getUser(order.getApplyUser());
        repayBiz.setUserId(applyUser.getUserId());
        repayBiz.setRealName(applyUser.getRealName());
        repayBiz.setIdKind(applyUser.getIdKind());
        repayBiz.setIdNo(applyUser.getIdNo());

        repayBiz.setBankcardCode(specsOrder.getBankcardCode());
        repayBiz.setRefType(ERepayBizType.PRODUCT.getCode());
        repayBiz.setRefCode(order.getCode());

        repayBiz.setBizPrice(order.getAmount());
        repayBiz.setSfRate(specsOrder.getSfRate());
        repayBiz.setSfAmount(specsOrder.getSfAmount());
        String bankCode = bankcardAO.getBankcard(specsOrder.getBankcardCode())
            .getBankCode();
        repayBiz.setLoanBank(bankCode);// 存ICBC样式
        repayBiz.setLoanAmount(specsOrder.getLoanAmount());

        repayBiz.setPeriods(specsOrder.getPeriods());
        repayBiz.setRestPeriods(specsOrder.getPeriods());
        repayBiz.setBankRate(specsOrder.getBankRate());
        Date now = new Date();
        repayBiz.setLoanStartDatetime(now);
        Date addMonths = DateUtils.addMonths(now, specsOrder.getPeriods());
        repayBiz.setLoanEndDatetime(addMonths);

        // repayBiz.setBankFkDatetime(now);
        repayBiz.setFxDeposit(0L);
        Date date = DateUtils.addMonths(order.getApplyDatetime(), 1);
        repayBiz.setFirstRepayDatetime(date);

        // 贷款总额 = 贷款额+服务费(0)
        // 手续费总额 = 贷款总额*银行利率
        BigDecimal loanmount = new BigDecimal(specsOrder.getLoanAmount());
        BigDecimal sxfAmount = loanmount.multiply(new BigDecimal(specsOrder
            .getBankRate()));
        // 月供=（贷款总额+手续费）/期数 （像下取整）
        BigDecimal periods = new BigDecimal(specsOrder.getPeriods());
        BigDecimal monthAmount = (loanmount.add(sxfAmount)).divide(periods, 0,
            1);
        // 首期月供 = -(月供*(期数-1)-贷款总额-手续费)
        BigDecimal firstMonthAmount = loanmount.add(sxfAmount).subtract(
            monthAmount.multiply(periods.subtract(new BigDecimal(1))));

        // Long monthlyAmount = new BigDecimal(order.getLoanAmount())
        // .divide(new BigDecimal(order.getPeriods()), 0, RoundingMode.DOWN)
        // .longValue();
        // long long3 = (long) (long2 * order.getBankRate());
        repayBiz.setFirstRepayAmount(firstMonthAmount.longValue());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getApplyDatetime());
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        repayBiz.setMonthDatetime(i);
        repayBiz.setMonthAmount(monthAmount.longValue());

        repayBiz.setLyDeposit(0L);
        repayBiz.setCutLyDeposit(0L);
        repayBiz.setCurNodeCode(ERepayBizNode.PRO_TO_REPAY.getCode());
        repayBiz.setRestAmount(specsOrder.getLoanAmount());
        repayBiz.setRestTotalCost(0L);

        repayBiz.setTotalInDeposit(0L);
        repayBiz.setOverdueAmount(0L);
        repayBiz.setTotalOverdueCount(0);
        repayBiz.setCurOverdueCount(0);
        repayBiz.setBlackHandleNote("暂无");

        repayBiz.setUpdater(order.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(order.getRemark());
        repayBizDAO.insert(repayBiz);
        return repayBiz;
    }

    @Override
    public void refreshRestAmount(RepayBiz repayBiz, Long realWithholdAmount,
            int restPeriods) {
        if (repayBiz != null && realWithholdAmount != null) {
            repayBiz.setRestAmount(repayBiz.getRestAmount()
                    - realWithholdAmount);
            repayBiz.setRestPeriods(repayBiz.getRestPeriods() - restPeriods);
            repayBizDAO.updateRepayBizRestAmount(repayBiz);
        }
    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#refreshAdvanceRepayProduct(com.cdkj.loan.domain.RepayBiz, java.lang.Long)
     */
    @Override
    public void refreshAdvanceRepayProduct(RepayBiz repayBiz,
            Long realWithholdAmount) {
        // TODO Auto-generated method stub

    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#refreshEnterBlackList(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void refreshEnterBlackList(RepayBiz data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void prepaymentApply(RepayBiz repayBiz) {
        repayBizDAO.prepaymentApply(repayBiz);
    }

    @Override
    public void prepaymentApprove(RepayBiz repayBiz) {
        repayBizDAO.prepaymentApprove(repayBiz);
    }

    @Override
    public void approveByQkcsDepartment(RepayBiz repayBiz, String curNodeCode,
            Long cutLyDeposit, String updater, String remark) {
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setCutLyDeposit(cutLyDeposit);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);

        repayBizDAO.approveByQkcsDepartment(repayBiz);
    }

    @Override
    public void approveByBankCheck(String code, String curNodeCode,
            Date settleDatetime, String settleAttach, String updater,
            String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setSettleDatetime(settleDatetime);
        repayBiz.setSettleAttach(settleAttach);

        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizDAO.approveByBankCheck(repayBiz);
    }

    @Override
    public void approveByManager(String code, String curNodeCode,
            String updater, String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);

        repayBizDAO.approveByManager(repayBiz);
    }

    @Override
    public void approveByFinance(String code, String curNodeCode,
            String updater, String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);

        repayBizDAO.approveByFinance(repayBiz);
    }

    @Override
    public void releaseMortgage(String code, String curNodeCode,
            Date releaseDatetime, String updater) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setReleaseDatetime(releaseDatetime);
        repayBiz.setRestAmount(0L);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());

        // 更新还款计划
        List<RepayPlan> planList = repayPlanBO
            .queryRepayPlanListByRepayBizCode(code);
        if (CollectionUtils.isNotEmpty(planList)) {
            for (RepayPlan repayPlan : planList) {
                repayPlan.setCurNodeCode(ERepayPlanNode.REPAY_YES.getCode());
                repayPlan.setRealRepayAmount(repayPlan.getRepayAmount());
                repayPlan.setOverplusAmount(0L);
                repayPlanBO.refreshRepayPlanOverdue(repayPlan);
            }
        }

        repayBizDAO.releaseMortgage(repayBiz);
    }

    @Override
    public void applyTrailer(RepayBiz repayBiz) {
        repayBizDAO.applyTrailer(repayBiz);
    }

    @Override
    public void financialMoney(RepayBiz repayBiz) {
        repayBizDAO.financialMoney(repayBiz);
    }

    @Override
    public void trailerEntry(RepayBiz repayBiz) {
        repayBizDAO.trailerEntry(repayBiz);
    }

    @Override
    public void judicialLitigationEntry(RepayBiz repayBiz) {
        repayBizDAO.judicialLitigationEntry(repayBiz);
    }

    @Override
    public void trailerManage(RepayBiz repayBiz) {
        repayBizDAO.trailerManage(repayBiz);
    }

    @Override
    public void qkcsbRedeemApply(RepayBiz repayBiz) {
        repayBizDAO.qkcsbRedeemApply(repayBiz);
    }

    @Override
    public void riskManagerCheck(RepayBiz repayBiz) {
        repayBizDAO.riskManagerCheck(repayBiz);
    }

    @Override
    public void financeApprove(RepayBiz repayBiz) {
        repayBizDAO.financeApprove(repayBiz);
    }

    @Override
    public void repayOverdue(RepayBiz repayBiz) {
        repayBizDAO.repayOverDue(repayBiz);
    }

    @Override
    public List<RepayBiz> queryRepayBizList(RepayBiz condition) {
        return repayBizDAO.selectList(condition);
    }

    @Override
    public RepayBiz getRepayBiz(String code) {
        RepayBiz data = null;
        if (StringUtils.isNotBlank(code)) {
            RepayBiz condition = new RepayBiz();
            condition.setCode(code);
            data = repayBizDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "还款业务编号" + code + "不存在");
            }
        }
        return data;
    }

    @Override
    public Paginable<RepayBiz> getPaginableByRoleCode(int start, int limit,
            RepayBiz condition) {
        prepare(condition);
        long totalCount = repayBizDAO.selectTotalCountByRoleCode(condition);
        Page<RepayBiz> page = new Page<RepayBiz>(start, limit, totalCount);
        List<RepayBiz> dataList = repayBizDAO.selectRepayBizByRoleCode(
            condition, page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public void refreshRepayAllProduct(String repayBizCode, Long realPayAmount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void refreshBizByPayFee(RepayBiz repayBiz) {
        repayBizDAO.updateBizByPayFee(repayBiz);
    }

    @Override
    public void refreshRestPeriods(RepayBiz repayBiz) {
        repayBizDAO.updateRestPeriods(repayBiz);
    }

    @Override
    public RepayBiz getRepayBizByBizCode(String bizCode) {
        RepayBiz condition = new RepayBiz();
        condition.setBizCode(bizCode);
        RepayBiz repayBiz = repayBizDAO.select(condition);
        return repayBiz;
    }

    @Override
    public String removeByBizCode(String bizCode) {
        RepayBiz repayBiz = getRepayBizByBizCode(bizCode);
        if (null != repayBiz) {
            repayBizDAO.delete(repayBiz);
        }
        return null;
    }

}
