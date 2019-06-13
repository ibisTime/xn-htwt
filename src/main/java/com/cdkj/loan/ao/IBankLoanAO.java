package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BankLoan;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.req.XN632135Req;

@Component
public interface IBankLoanAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 风控提交银行
    public void commitBank(String bizCode, String operator,
            String bankCommitDatetime, String bankCommitNote);

    // 风控录入银行放款信息
    public void entryFkInfo(XN632135Req req);

    // 财务确认银行收款
    public void confirmSk(XN632130Req req);

    public Paginable<BankLoan> queryBankLoanPage(int start, int limit,
            BankLoan condition);

    public List<BankLoan> queryBankLoanList(BankLoan condition);

    public BankLoan getBankLoan(String code);

}
