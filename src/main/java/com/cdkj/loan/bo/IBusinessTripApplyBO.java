package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BusinessTripApply;

//CHECK ��鲢��ע�� 
public interface IBusinessTripApplyBO extends IPaginableBO<BusinessTripApply> {

    public boolean isBusinessTripApplyExist(String code);

    public String saveBusinessTripApply(BusinessTripApply data);

    public int removeBusinessTripApply(String code);

    public int refreshBusinessTripApply(BusinessTripApply data);

    public List<BusinessTripApply> queryBusinessTripApplyList(
            BusinessTripApply condition);

    public BusinessTripApply getBusinessTripApply(String code);

    public void departmentAudit(BusinessTripApply data);

    public void financeAudit(BusinessTripApply data);

    public void generalAudit(BusinessTripApply data);

    public Paginable<BusinessTripApply> getPaginableByRoleCode(int start,
            int limit, BusinessTripApply condition);

}
