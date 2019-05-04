package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ILoanProductDAO;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.enums.ELoanProductStatus;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:40:05 
 * @history:
 */
@Component
public class LoanProductBOImpl extends PaginableBOImpl<LoanProduct> implements
        ILoanProductBO {

    @Autowired
    private ILoanProductDAO loanProductDAO;

    @Override
    public void saveLoanProduct(LoanProduct data) {
        loanProductDAO.insert(data);
    }

    @Override
    public void dropLoanProduct(String code) {
        if (null == code) {
            throw new BizException("xn0000", "产品编号不能为空");
        }
        LoanProduct condition = new LoanProduct();
        condition.setCode(code);
        loanProductDAO.delete(condition);
    }

    @Override
    public void editLoanProduct(LoanProduct data) {
        loanProductDAO.updateLoanProduct(data);
    }

    @Override
    public void publishYesLoanProduct(String code, String updater) {
        LoanProduct data = getLoanProduct(code);
        data.setCode(code);
        data.setStatus(ELoanProductStatus.PUBLISH_YES.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());

        loanProductDAO.updateLoanProductPublish(data);
    }

    @Override
    public void publishNoLoanProduct(String code, String updater) {
        LoanProduct data = getLoanProduct(code);
        data.setCode(code);
        data.setStatus(ELoanProductStatus.PUBLISH_NO.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());

        loanProductDAO.updateLoanProductPublish(data);
    }

    @Override
    public LoanProduct getLoanProduct(String code) {
        LoanProduct data = null;
        if (StringUtils.isNotBlank(code)) {
            LoanProduct condition = new LoanProduct();
            condition.setCode(code);
            data = loanProductDAO.select(condition);
            if (null == data) {
                throw new BizException("xn0000", "贷款产品不存在");
            }
        }
        return data;
    }

    @Override
    public List<LoanProduct> queryLoanProductList(LoanProduct condition) {
        return loanProductDAO.selectList(condition);
    }
}
