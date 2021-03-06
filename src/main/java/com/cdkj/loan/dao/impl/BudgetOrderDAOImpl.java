package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBudgetOrderDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BudgetOrder;

@Repository("budgetOrderDAOImpl")
public class BudgetOrderDAOImpl extends AMybatisTemplate
        implements IBudgetOrderDAO {

    @Override
    public int insert(BudgetOrder data) {
        return super.insert(NAMESPACE.concat("insert_budgetOrder"), data);
    }

    @Override
    public int delete(BudgetOrder data) {
        return super.delete(NAMESPACE.concat("delete_budgetOrder"), data);
    }

    @Override
    public void update(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_budgetOrder"), data);
    }

    @Override
    public void updaterAreaApprove(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_area_approve"), data);
    }

    @Override
    public void updaterIskApprove(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_riskApprove"), data);
    }

    @Override
    public void updaterIskChargeApprove(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_charge_riskApprove"), data);
    }

    @Override
    public void updaterInterview(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_interview"), data);
    }

    @Override
    public void updaterInterviewInternal(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_interviewInternal"), data);
    }

    @Override
    public void updaterBizChargeApprove(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_biz_charge_approve"), data);
    }

    @Override
    public void updaterAdvancefund(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_advancefund"), data);
    }

    @Override
    public void updaterGpsManagerApprove(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_gps_manager_approve"), data);
    }

    @Override
    public void updaterInstallGps(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_install_gps"), data);
    }

    @Override
    public void updaterCarSettle(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_car_settle"), data);
    }

    @Override
    public void updaterCommitBank(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_commit_bank"), data);
    }

    @Override
    public void updaterEntryFk(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_entry_fk"), data);
    }

    @Override
    public void updaterConfirmReceipt(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_confirm_receipt"), data);
    }

    @Override
    public void updaterEntryMortgage(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_entry_mortgage"), data);
    }

    @Override
    public void updaterMortgageCommitBank(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_mortgage_commit_bank"), data);
    }

    @Override
    public void updaterMortgageFinish(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_mortgage_finish"), data);
    }

    @Override
    public void updateIsLogistics(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_isLogistics"), data);
    }

    @Override
    public BudgetOrder select(BudgetOrder condition) {
        return super.select(NAMESPACE.concat("select_budgetOrder"), condition,
            BudgetOrder.class);
    }

    @Override
    public long selectTotalCount(BudgetOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrder_count"), condition);
    }

    @Override
    public List<BudgetOrder> selectList(BudgetOrder condition) {
        return super.selectList(NAMESPACE.concat("select_budgetOrder"),
            condition, BudgetOrder.class);
    }

    @Override
    public List<BudgetOrder> selectList(BudgetOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_budgetOrder"), start,
            count, condition, BudgetOrder.class);
    }

    @Override
    public long selectTotalCountByDz(BudgetOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrder_count_byDz"), condition);
    }

    @Override
    public List<BudgetOrder> selectBudgetOrderByDzList(BudgetOrder condition) {
        return super.selectList(NAMESPACE.concat("select_budgetOrder_dz"),
            condition, BudgetOrder.class);
    }

    @Override
    public int updateArchiveSuccess(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_archiveSuccess"), data);
    }

    @Override
    public void updaterLogicNode(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_logic_node"), data);
    }

    @Override
    public void residentMortgageApply(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_residentMortgageApply"), data);
    }

    @Override
    public void insidejobConfirm(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_insidejobConfirm"), data);
    }

    @Override
    public List<BudgetOrder> selectBudgetOrderByRoleCodeList(
            BudgetOrder condition, int start, int count) {
        return super.selectList(
            NAMESPACE.concat("select_budgetOrder_byRoleCode"), start, count,
            condition, BudgetOrder.class);
    }

    @Override
    public long selectTotalCountByRoleCode(BudgetOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrder_count_byRoleCode"), condition);
    }

    @Override
    public void insertBackAdvanceFund(BudgetOrder data) {

        super.update(NAMESPACE.concat("insert_back_advance_fund"), data);

    }

    @Override
    public void confirmBackAdvanceFund(BudgetOrder data) {
        super.update(NAMESPACE.concat("confirm_back_advance_fund"), data);
    }

    @Override
    public void applyCancel(BudgetOrder data) {

        super.update(NAMESPACE.concat("apply_cancel"), data);

    }

    @Override
    public void cancelBizAudit(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_cancel_biz_audit"), data);

    }

    @Override
    public void cancelFinanceAudit(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_cancel_finance_audit"), data);

    }

    @Override
    public void dataSupplement(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_dataSupplement"), data);
    }

    @Override
    public long selectTotalCountByTeamCode(BudgetOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrder_count_byTeamCode"), condition);
    }

    @Override
    public List<BudgetOrder> selectBudgetOrderListByTeamCode(
            BudgetOrder condition, int start, int pageSize) {
        return super.selectList(
            NAMESPACE.concat("select_budgetOrder_byTeamCode"), start, pageSize,
            condition, BudgetOrder.class);
    }

    @Override
    public List<BudgetOrder> queryBudgetOrderByApplyUserName(
            BudgetOrder condition) {
        return super.selectList(
            NAMESPACE.concat("select_budgetOrder_byApplyUserName"), condition,
            BudgetOrder.class);
    }

    @Override
    public List<BudgetOrder> selectBudgetOrderListByUserId(
            BudgetOrder condition, int start, int pageSize) {
        return super.selectList(NAMESPACE.concat("select_budgetOrder_byUserId"),
            start, pageSize, condition, BudgetOrder.class);
    }

    @Override
    public long selectTotalCountByUserId(BudgetOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrder_count_byUserId"), condition);
    }

    @Override
    public void updateCurNodeCode(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_curNodeCode"), data);
    }

}
