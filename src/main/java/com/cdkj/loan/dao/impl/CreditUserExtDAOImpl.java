package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICreditUserExtDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CreditUserExt;

@Repository("creditUserExtDAOImpl")
public class CreditUserExtDAOImpl extends AMybatisTemplate
        implements ICreditUserExtDAO {

    @Override
    public int insert(CreditUserExt data) {
        return super.insert(NAMESPACE.concat("insert_creditUserExt"), data);
    }

    @Override
    public int delete(CreditUserExt data) {
        return super.delete(NAMESPACE.concat("delete_creditUserExt"), data);
    }

    @Override
    public CreditUserExt select(CreditUserExt condition) {
        return super.select(NAMESPACE.concat("select_creditUserExt"), condition,
            CreditUserExt.class);
    }

    @Override
    public long selectTotalCount(CreditUserExt condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_creditUserExt_count"), condition);
    }

    @Override
    public List<CreditUserExt> selectList(CreditUserExt condition) {
        return super.selectList(NAMESPACE.concat("select_creditUserExt"),
            condition, CreditUserExt.class);
    }

    @Override
    public List<CreditUserExt> selectList(CreditUserExt condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_creditUserExt"), start,
            count, condition, CreditUserExt.class);
    }

    @Override
    public int update(CreditUserExt creditUserExt) {
        return super.update(NAMESPACE.concat("update_creditUserExt"),
            creditUserExt);
    }

}
