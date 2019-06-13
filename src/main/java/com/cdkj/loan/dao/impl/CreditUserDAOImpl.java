package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICreditUserDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CreditUser;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:54:13 
 * @history:
 */
@Repository("creditUserDAOImpl")
public class CreditUserDAOImpl extends AMybatisTemplate implements
        ICreditUserDAO {

    @Override
    public int insert(CreditUser data) {

        return super.insert(NAMESPACE.concat("insert_creditUser"), data);
    }

    @Override
    public int delete(CreditUser data) {
        return super.delete(NAMESPACE.concat("delete_creditUser"), data);
    }

    @Override
    public CreditUser select(CreditUser condition) {

        return super.select(NAMESPACE.concat("select_creditUser"), condition,
            CreditUser.class);
    }

    @Override
    public long selectTotalCount(CreditUser condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_creditUser_count"), condition);
    }

    @Override
    public List<CreditUser> selectList(CreditUser condition) {
        return super.selectList(NAMESPACE.concat("select_creditUser"),
            condition, CreditUser.class);
    }

    @Override
    public List<CreditUser> selectList(CreditUser condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_creditUser"), start,
            count, condition, CreditUser.class);
    }

    @Override
    public void inputBankCreditResult(CreditUser creditUser) {
        super.update(NAMESPACE.concat("update_bankCreditResult"), creditUser);

    }

    @Override
    public void updateCreditUser(CreditUser creditUser) {
        super.update(NAMESPACE.concat("update_creditUser"), creditUser);
    }

    @Override
    public int updateIcbankCredit(CreditUser creditUser) {
        return super
            .update(NAMESPACE.concat("update_icbankCredit"), creditUser);

    }

    @Override
    public void updateIcbankCode(CreditUser creditUser) {
        super.update(NAMESPACE.concat("update_icbankCredit"), creditUser);
    }
}
