package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBankLoanBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankLoanDAO;
import com.cdkj.loan.domain.BankLoan;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BankLoanBOImpl extends PaginableBOImpl<BankLoan>
        implements IBankLoanBO {

    @Autowired
    private IBankLoanDAO bankLoanDAO;

    @Override
    public String saveBankLoan(BankLoan data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BANK_LOAN.getCode());
            data.setCode(code);
            bankLoanDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshBankLoan(BankLoan data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bankLoanDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BankLoan> queryBankLoanList(BankLoan condition) {
        return bankLoanDAO.selectList(condition);
    }

    @Override
    public BankLoan getBankLoan(String code) {
        BankLoan data = null;
        if (StringUtils.isNotBlank(code)) {
            BankLoan condition = new BankLoan();
            condition.setCode(code);
            data = bankLoanDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "银行放款不存在");
            }
        }
        return data;
    }
}
