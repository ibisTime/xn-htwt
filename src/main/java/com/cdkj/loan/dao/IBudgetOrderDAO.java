package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BudgetOrder;

//dao层 
public interface IBudgetOrderDAO extends IBaseDAO<BudgetOrder> {
    String NAMESPACE = IBudgetOrderDAO.class.getName().concat(".");

    void update(BudgetOrder data);

    void updaterAreaApprove(BudgetOrder data);

    void updaterIskApprove(BudgetOrder data);

    void updaterInterview(BudgetOrder data);

    void updaterInterviewInternal(BudgetOrder data);

    void updaterIskChargeApprove(BudgetOrder data);

    void updaterBizChargeApprove(BudgetOrder data);

    void updaterAdvancefund(BudgetOrder data);

    void updaterGpsManagerApprove(BudgetOrder data);

    void updaterInstallGps(BudgetOrder data);

    void updaterCarSettle(BudgetOrder data);

    int updateArchiveSuccess(BudgetOrder data);

    void updaterCommitBank(BudgetOrder data);

    void updaterEntryFk(BudgetOrder data);

    void updaterConfirmReceipt(BudgetOrder data);

    void updaterEntryMortgage(BudgetOrder data);

    void updaterMortgageCommitBank(BudgetOrder data);

    void updaterMortgageFinish(BudgetOrder data);

    void updaterLogicNode(BudgetOrder data);

    List<BudgetOrder> selectBudgetOrderByRoleCodeList(BudgetOrder condition,
            int start, int count);

    long selectTotalCountByRoleCode(BudgetOrder condition);

    void insertBackAdvanceFund(BudgetOrder data);

    void confirmBackAdvanceFund(BudgetOrder data);

    // 客户申请作废
    void applyCancel(BudgetOrder data);

    // 客户作废 业务总监审核
    void cancelBizAudit(BudgetOrder data);

    void cancelFinanceAudit(BudgetOrder data);

    // 资料补录
    void dataSupplement(BudgetOrder budgetOrder);

    long selectTotalCountByTeamCode(BudgetOrder condition);

    List<BudgetOrder> selectBudgetOrderListByTeamCode(BudgetOrder condition,
            int start, int pageSize);

    long selectTotalCountByDz(BudgetOrder condition);

    List<BudgetOrder> selectBudgetOrderByDzList(BudgetOrder condition);

    // 根据客户姓名查询预算单
    List<BudgetOrder> queryBudgetOrderByApplyUserName(BudgetOrder condition);

    // 物流传递中
    void updateIsLogistics(BudgetOrder budgetOrder);

    // 驻行抵押申请
    void residentMortgageApply(BudgetOrder budgetOrder);

    // 内勤确认
    void insidejobConfirm(BudgetOrder budgetOrder);

    // 根据信贷专员或内勤查预算单客户
    List<BudgetOrder> selectBudgetOrderListByUserId(BudgetOrder condition,
            int start, int pageSize);

    long selectTotalCountByUserId(BudgetOrder condition);

    void updateCurNodeCode(BudgetOrder budgetOrder);

}
