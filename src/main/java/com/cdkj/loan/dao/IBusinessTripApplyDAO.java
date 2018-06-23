package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BusinessTripApply;

//dao层 
public interface IBusinessTripApplyDAO extends IBaseDAO<BusinessTripApply> {
    String NAMESPACE = IBusinessTripApplyDAO.class.getName().concat(".");

    int update(BusinessTripApply data);

    void departmentAudit(BusinessTripApply data);

    void financeAudit(BusinessTripApply data);

    void generalAudit(BusinessTripApply data);

    long selectTotalCountByRoleCode(BusinessTripApply condition);

    List<BusinessTripApply> selectBudgetOrderByRoleCodeList(
            BusinessTripApply condition, int start, int pageSize);

}
