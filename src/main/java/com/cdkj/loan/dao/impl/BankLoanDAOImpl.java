package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBankLoanDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BankLoan;

@Repository("bankLoanDAOImpl")
public class BankLoanDAOImpl extends AMybatisTemplate implements IBankLoanDAO {

    @Override
    public int insert(BankLoan data) {
        return super.insert(NAMESPACE.concat("insert_bankLoan"), data);
    }

    @Override
    public int delete(BankLoan data) {
        return super.delete(NAMESPACE.concat("delete_bankLoan"), data);
    }

    @Override
    public BankLoan select(BankLoan condition) {
        return super.select(NAMESPACE.concat("select_bankLoan"), condition,
            BankLoan.class);
    }

    @Override
    public long selectTotalCount(BankLoan condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_bankLoan_count"),
            condition);
    }

    @Override
    public List<BankLoan> selectList(BankLoan condition) {
        return super.selectList(NAMESPACE.concat("select_bankLoan"), condition,
            BankLoan.class);
    }

    @Override
    public List<BankLoan> selectList(BankLoan condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bankLoan"), start,
            count, condition, BankLoan.class);
    }

    @Override
    public int updateCommitBank(BankLoan bankLoan) {
        return super.update(NAMESPACE.concat("update_commitBankLoan"),
            bankLoan);
    }

    @Override
    public int updateEntryFkInfo(BankLoan bankLoan) {
        return super.update(NAMESPACE.concat("update_entryFkInfo"), bankLoan);
    }

    @Override
    public int confirmSk(BankLoan bankLoan) {
        return super.update(NAMESPACE.concat("update_confirmSk"), bankLoan);
    }

}
