package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;

public interface IBudgetOrderBO extends IPaginableBO<BudgetOrder> {

    public String saveBudgetOrder(Credit credit,
            List<CreditUser> creditUserList);

    public void refreshBudgetOrder(BudgetOrder data);

    // 准入单区域经理审核
    public void refreshAreaApprove(BudgetOrder data);

    public void refreshriskApprove(BudgetOrder budgetOrder);

    public void interview(BudgetOrder budgetOrder);

    public void refreshInterviewInternal(BudgetOrder budgetOrder);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    public BudgetOrder getBudgetOrderByRepayBizCode(String repayBizCode);

    public void refreshriskChargeApprove(BudgetOrder budgetOrder);

    public void refreshbizChargeApprove(BudgetOrder budgetOrder);

    public void advancefund(BudgetOrder budgetOrder);

    // 驻行抵押申请
    public void residentMortgageApply(BudgetOrder budgetOrder);

    // 内勤确认
    public void insidejobConfirm(BudgetOrder budgetOrder);

    public void refreshGpsManagerApprove(BudgetOrder budgetOrder);

    public void installGps(BudgetOrder budgetOrder);

    public void carSettle(BudgetOrder data);

    // 确认提交银行
    public void refreshCommitBank(BudgetOrder budgetOrder);

    // 录入放款信息
    public void refreshEntryFk(BudgetOrder budgetOrder);

    // 确认放款
    public void refreshConfirmReceipt(BudgetOrder budgetOrder);

    // 录入抵押信息(寄送材料)
    public void entryMortgage(BudgetOrder data);

    // 抵押确认提交银行
    public void refreshMortgageCommitBank(BudgetOrder budgetOrder);

    // 抵押完成
    public void refreshMortgageFinish(BudgetOrder budgetOrder);

    // 确认入档
    public int archiveSuccess(BudgetOrder budgetOrder, String repayBizCode,
            String userId);

    // 物流流转
    public String logicOrderLoan(String code, String operator);

    // 物流流转
    public String logicOrderMortgage(String code, String operator);

    public Paginable<BudgetOrder> getPaginableByRoleCode(int start,
            int pageSize, BudgetOrder condition);

    // 生成退客户垫资款数据
    public void saveBackAdvanceFund(BudgetOrder budgetOrder);

    // 财务确认退客户垫资款
    public void confirmBackAdvanceFund(BudgetOrder budgetOrder);

    // 客户申请作废
    public void applyCancel(BudgetOrder budgetOrder);

    // 客户作废 业务总监审核
    public void cancelBizAudit(BudgetOrder budgetOrder);

    // 客户作废 财务总监审核
    public void cancelFinanceAudit(BudgetOrder budgetOrder);

    // 资料补录
    public void dataSupplement(BudgetOrder budgetOrder);

    // 团队报表
    public Paginable<BudgetOrder> getPaginableByTeamCode(int start, int limit,
            BudgetOrder condition);

    public List<BudgetOrder> getPaginableByDz(BudgetOrder condition);

    // 根据客户姓名查询预算单
    public List<BudgetOrder> queryBudgetOrderByApplyUserName(
            BudgetOrder condition);

    // 物流传递中
    public void updateIsLogistics(BudgetOrder budgetOrder);

    // 根据信贷专员或内勤查预算单客户
    public Paginable<BudgetOrder> queryBudgetOrderPageByUserId(int start,
            int limit, BudgetOrder condition);

    // 改节点
    public void refreshBudgetOrderCurNode(BudgetOrder budgetOrder);

}
