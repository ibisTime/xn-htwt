package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICreditDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Credit;

@Repository("creditDAOImpl")
public class CreditDAOImpl extends AMybatisTemplate implements ICreditDAO {

    @Override
    public int insert(Credit data) {

        return super.insert(NAMESPACE.concat("insert_credit"), data);
    }

    @Override
    public int delete(Credit data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Credit select(Credit condition) {

        return super.select(NAMESPACE.concat("select_credit"), condition,
            Credit.class);
    }

    @Override
    public long selectTotalCount(Credit condition) {

        return super.selectTotalCount(NAMESPACE.concat("select_credit_count"),
            condition);
    }

    @Override
    public List<Credit> selectList(Credit condition) {

        return super.selectList(NAMESPACE.concat("select_credit"), condition,
            Credit.class);
    }

    @Override
    public List<Credit> selectList(Credit condition, int start, int count) {

        return super.selectList(NAMESPACE.concat("select_credit"), start, count,
            condition, Credit.class);
    }

    @Override
    public int updateCredit(Credit credit) {

        return super.update(NAMESPACE.concat("update_credit"), credit);
    }

    @Override
    public int updateNode(Credit credit) {
        return super.update(NAMESPACE.concat("update_node"), credit);
    }

    @Override
    public long selectTotalCountByRoleCode(Credit condition) {

        return super.selectTotalCount(
            NAMESPACE.concat("select_credit_count_byRoleCode"), condition);
    }

    @Override
    public List<Credit> selectReqBudgetByRoleCodeList(Credit condition,
            int start, int pageSize) {

        return super.selectList(NAMESPACE.concat("select_credit_byRoleCode"),
            start, pageSize, condition, Credit.class);
    }

    @Override
    public long selectTotalCountByIsCancel(Credit condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_credit_count_byIsCancel"), condition);
    }

    @Override
    public List<Credit> selectReqBudgetByIsCancel(Credit condition, int start,
            int pageSize) {
        return super.selectList(NAMESPACE.concat("select_credit_byIsCancel"),
            start, pageSize, condition, Credit.class);
    }

    @Override
    public long selectTotalCountByNotCancel(Credit condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_credit_count_byNotCancel"), condition);
    }

    @Override
    public List<Credit> selectReqBudgetByNotCancel(Credit condition, int start,
            int pageSize) {
        return super.selectList(NAMESPACE.concat("select_credit_byNotCancel"),
            start, pageSize, condition, Credit.class);
    }

    @Override
    public int cancelCredit(Credit data) {
        return super.update(NAMESPACE.concat("update_cancel_credit"), data);
    }

    @Override
    public int setApplyUserInfo(Credit data) {

        return super.update(NAMESPACE.concat("update_set_apply_user_info"),
            data);
    }

    @Override
    public int refreshInputBankCreditResult(Credit data) {
        return super.update(NAMESPACE.concat("update_input_bank_credit_result"),
            data);

    }

    @Override
    public void distributeLeaflets(Credit data) {
        super.update(NAMESPACE.concat("update_distributeLeaflets"), data);
    }

    @Override
    public void updateSecondCarReport(Credit data) {
        super.update(NAMESPACE.concat("update_secondCarReport"), data);
    }

    @Override
    public void updateCreditUser(Credit data) {
        super.update(NAMESPACE.concat("update_creditUser"), data);
    }

}
