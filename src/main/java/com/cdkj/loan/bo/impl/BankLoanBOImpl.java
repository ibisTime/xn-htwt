package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IBankLoanBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankLoanDAO;
import com.cdkj.loan.domain.BankLoan;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public String saveBankLoan(String bizCode) {
        BankLoan bankLoan = new BankLoan();

        String code = OrderNoGenerater
                .generate(EGeneratePrefix.BANK_LOAN.getCode());
        bankLoan.setCode(code);
        bankLoan.setBizCode(bizCode);
        bankLoan.setCurNodeCode(ENode.fk_submit.getCode());
        bankLoanDAO.insert(bankLoan);
        return code;
    }

    @Override
    public void commitBank(String code, String nextNodeCode, String operator,
            String bankCommitDatetime, String bankCommitNote) {
        BankLoan bankLoan = new BankLoan();

        bankLoan.setCode(code);
        bankLoan.setCurNodeCode(nextNodeCode);
        bankLoan.setBankCommitDatetime(DateUtil.strToDate(bankCommitDatetime,
                DateUtil.DATA_TIME_PATTERN_1));
        bankLoan.setBankCommitNote(bankCommitNote);

        bankLoanDAO.updateCommitBank(bankLoan);
    }

    @Override
    public void entryFkInfo(String code, String nextNodeCode, XN632135Req req) {
        BankLoan bankLoan = EntityUtils.copyData(req, BankLoan.class);
        bankLoan.setCode(code);
        bankLoan.setCurNodeCode(nextNodeCode);

        bankLoanDAO.updateEntryFkInfo(bankLoan);
    }

    @Override
    public void confirmSk(String code, String nextNodeCode, XN632130Req req) {
        BankLoan bankLoan = EntityUtils.copyData(req, BankLoan.class);
        bankLoan.setCode(code);
        bankLoan.setCurNodeCode(nextNodeCode);

        bankLoanDAO.confirmSk(bankLoan);
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

    @Override
    public BankLoan getBankLoanByBiz(String bizCode) {
        BankLoan data = null;
        if (StringUtils.isNotBlank(bizCode)) {
            BankLoan condition = new BankLoan();
            condition.setBizCode(bizCode);
            data = bankLoanDAO.select(condition);
        }
        return data;
    }

}
