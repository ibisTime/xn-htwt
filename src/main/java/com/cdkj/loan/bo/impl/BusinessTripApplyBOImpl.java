package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBusinessTripApplyBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBusinessTripApplyDAO;
import com.cdkj.loan.domain.BusinessTripApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月23日 下午2:50:45 
 * @history:
 */
@Component
public class BusinessTripApplyBOImpl extends PaginableBOImpl<BusinessTripApply>
        implements IBusinessTripApplyBO {

    @Autowired
    private IBusinessTripApplyDAO businessTripApplyDAO;

    @Override
    public boolean isBusinessTripApplyExist(String code) {
        BusinessTripApply condition = new BusinessTripApply();
        condition.setCode(code);
        if (businessTripApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBusinessTripApply(BusinessTripApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BUSINESS_TRIP_APPLY.getCode());
            data.setCode(code);
            businessTripApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBusinessTripApply(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BusinessTripApply data = new BusinessTripApply();
            data.setCode(code);
            count = businessTripApplyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBusinessTripApply(BusinessTripApply data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = businessTripApplyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BusinessTripApply> queryBusinessTripApplyList(
            BusinessTripApply condition) {
        return businessTripApplyDAO.selectList(condition);
    }

    @Override
    public BusinessTripApply getBusinessTripApply(String code) {
        BusinessTripApply data = null;
        if (StringUtils.isNotBlank(code)) {
            BusinessTripApply condition = new BusinessTripApply();
            condition.setCode(code);
            data = businessTripApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "出差申请编号不存在");
            }
        }
        return data;
    }

    @Override
    public void departmentAudit(BusinessTripApply data) {

        if (null != data) {
            businessTripApplyDAO.departmentAudit(data);
        }

    }

    @Override
    public void financeAudit(BusinessTripApply data) {

        if (null != data) {
            businessTripApplyDAO.financeAudit(data);
        }

    }

    @Override
    public void generalAudit(BusinessTripApply data) {

        if (null != data) {
            businessTripApplyDAO.generalAudit(data);
        }

    }

    @Override
    public Paginable<BusinessTripApply> getPaginableByRoleCode(int start,
            int limit, BusinessTripApply condition) {
        prepare(condition);
        long totalCount = businessTripApplyDAO
            .selectTotalCountByRoleCode(condition);
        Paginable<BusinessTripApply> page = new Page<BusinessTripApply>(start,
            limit, totalCount);
        List<BusinessTripApply> dataList = businessTripApplyDAO
            .selectBudgetOrderByRoleCodeList(condition, page.getStart(),
                page.getPageSize());
        page.setList(dataList);
        return page;
    }
}
