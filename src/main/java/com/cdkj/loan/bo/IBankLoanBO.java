package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BankLoan;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.req.XN632135Req;

public interface IBankLoanBO extends IPaginableBO<BankLoan> {

    public String saveBankLoan(BankLoan data);

    public void commitBank(String code, String nextNodeCode, String operator,
            String bankCommitDatetime, String bankCommitNote);

    public void entryFkInfo(String nextNodeCode, XN632135Req req);

    public void confirmSk(String nextNodeCode, XN632130Req req);

    public List<BankLoan> queryBankLoanList(BankLoan condition);

    public BankLoan getBankLoan(String code);

    public BankLoan getBankLoanByBiz(String bizCode);

}
