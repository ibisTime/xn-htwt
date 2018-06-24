package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;

public interface IBudgetOrderBO extends IPaginableBO<BudgetOrder> {

    public String saveBudgetOrder(Credit credit);

    public String saveBudgetOrder(BudgetOrder data);

    public void refreshBudgetOrder(BudgetOrder data);

    public void refreshriskApprove(BudgetOrder budgetOrder);

    public void interview(BudgetOrder budgetOrder);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    public BudgetOrder getBudgetOrderByRepayBizCode(String repayBizCode);

    public void refreshriskChargeApprove(BudgetOrder budgetOrder);

    public void refreshbizChargeApprove(BudgetOrder budgetOrder);

    public void advancefund(BudgetOrder budgetOrder);

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
    public String logicOrder(String code, String operator);

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

}
