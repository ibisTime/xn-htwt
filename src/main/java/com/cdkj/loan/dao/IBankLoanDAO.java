package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BankLoan;

public interface IBankLoanDAO extends IBaseDAO<BankLoan> {
    String NAMESPACE = IBankLoanDAO.class.getName().concat(".");

    int updateCommitBank(BankLoan bankLoan);

    int updateEntryFkInfo(BankLoan bankLoan);

    int confirmSk(BankLoan bankLoan);

}
