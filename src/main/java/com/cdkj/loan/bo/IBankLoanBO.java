package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BankLoan;

public interface IBankLoanBO extends IPaginableBO<BankLoan> {

    public String saveBankLoan(BankLoan data);

    public int refreshBankLoan(BankLoan data);

    public List<BankLoan> queryBankLoanList(BankLoan condition);

    public BankLoan getBankLoan(String code);

}
