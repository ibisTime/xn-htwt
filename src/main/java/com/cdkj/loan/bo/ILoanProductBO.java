package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.LoanProduct;
import java.util.List;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:33:47 
 * @history:
 */
public interface ILoanProductBO extends IPaginableBO<LoanProduct> {

    void saveLoanProduct(LoanProduct data);

    void dropLoanProduct(String code);

    void editLoanProduct(LoanProduct data);

    void publishYesLoanProduct(String code, String updater);

    void publishNoLoanProduct(String code, String updater);

    LoanProduct getLoanProduct(String code);

    List<LoanProduct> queryLoanProductList(LoanProduct condition);
}
