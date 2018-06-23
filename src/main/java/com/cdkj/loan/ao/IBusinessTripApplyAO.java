package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BusinessTripApply;
import com.cdkj.loan.dto.req.XN632690Req;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月23日 下午2:50:13 
 * @history:
 */
@Component
public interface IBusinessTripApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBusinessTripApply(XN632690Req req);

    public int dropBusinessTripApply(String code);

    public int editBusinessTripApply(BusinessTripApply data);

    public Paginable<BusinessTripApply> queryBusinessTripApplyPage(int start,
            int limit, BusinessTripApply condition);

    public List<BusinessTripApply> queryBusinessTripApplyList(
            BusinessTripApply condition);

    public BusinessTripApply getBusinessTripApply(String code);

    // 部门主管审核
    public void departmentAudit(String code, String operator,
            String approveResult, String approveNote);

    // 财务主管审核
    public void financeAudit(String code, String operator,
            String approveResult, String approveNote);

    // 总经理审核
    public void generalAudit(String code, String operator,
            String approveResult, String approveNote);

    public Paginable<BusinessTripApply> queryBusinessTripApplyPageByRoleCode(
            int start, int limit, BusinessTripApply condition);

}
