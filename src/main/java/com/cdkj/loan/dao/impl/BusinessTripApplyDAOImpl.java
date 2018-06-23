package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBusinessTripApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BusinessTripApply;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月23日 下午2:50:26 
 * @history:
 */
@Repository("businessTripApplyDAOImpl")
public class BusinessTripApplyDAOImpl extends AMybatisTemplate implements
        IBusinessTripApplyDAO {

    @Override
    public int insert(BusinessTripApply data) {
        return super.insert(NAMESPACE.concat("insert_businessTripApply"), data);
    }

    @Override
    public int delete(BusinessTripApply data) {
        return super.delete(NAMESPACE.concat("delete_businessTripApply"), data);
    }

    @Override
    public BusinessTripApply select(BusinessTripApply condition) {
        return super.select(NAMESPACE.concat("select_businessTripApply"),
            condition, BusinessTripApply.class);
    }

    @Override
    public long selectTotalCount(BusinessTripApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_businessTripApply_count"), condition);
    }

    @Override
    public List<BusinessTripApply> selectList(BusinessTripApply condition) {
        return super.selectList(NAMESPACE.concat("select_businessTripApply"),
            condition, BusinessTripApply.class);
    }

    @Override
    public List<BusinessTripApply> selectList(BusinessTripApply condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_businessTripApply"),
            start, count, condition, BusinessTripApply.class);
    }

    @Override
    public int update(BusinessTripApply data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void departmentAudit(BusinessTripApply data) {

        super.update(NAMESPACE.concat("update_department_audit"), data);

    }

    @Override
    public void financeAudit(BusinessTripApply data) {

        super.update(NAMESPACE.concat("update_finance_audit"), data);

    }

    @Override
    public void generalAudit(BusinessTripApply data) {

        super.update(NAMESPACE.concat("update_general_audit"), data);

    }

    @Override
    public long selectTotalCountByRoleCode(BusinessTripApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_businessTripApply_count_byRoleCode"),
            condition);
    }

    @Override
    public List<BusinessTripApply> selectBudgetOrderByRoleCodeList(
            BusinessTripApply condition, int start, int pageSize) {
        return super.selectList(
            NAMESPACE.concat("select_businessTripApply_byRoleCode"), start,
            pageSize, condition, BusinessTripApply.class);
    }

}
