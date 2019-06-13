package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankDAO;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankBOImpl extends PaginableBOImpl<Bank> implements IBankBO {
    @Autowired
    private IBankDAO bankDAO;

    @Override
    public String saveBank(Bank data) {
        String code = null;
        if (data != null && data.getCode() == null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.BANK.getCode());
            data.setCode(code);
            bankDAO.insert(data);
        }
        return code;
    }

    @Override
    public int dropBank(String code) {
        if (StringUtils.isBlank(code)) {
            throw new BizException("xn0000", "贷款银行不能为空");
        }
        Bank condition = new Bank();
        condition.setCode(code);
        return bankDAO.delete(condition);
    }

    @Override
    public Bank getBank(String code) {
        Bank data = null;
        if (StringUtils.isNotBlank(code)) {
            Bank condition = new Bank();
            condition.setCode(code);
            data = bankDAO.select(condition);
            if (null == data) {
                throw new BizException("xn0000", "贷款银行为空！");
            }
        }
        return data;
    }

    @Override
    public int editBank(Bank data) {
        return bankDAO.updateBank(data);
    }

    @Override
    public List<Bank> queryBankList(Bank condition) {
        return bankDAO.selectList(condition);
    }
}
