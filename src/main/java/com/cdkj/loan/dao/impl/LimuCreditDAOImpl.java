package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ILimuCreditDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.LimuCredit;

@Repository("limuCreditDAOImpl")
public class LimuCreditDAOImpl extends AMybatisTemplate
        implements ILimuCreditDAO {

    @Override
    public int insert(LimuCredit data) {
        return super.insert(NAMESPACE.concat("insert_limuCredit"), data);
    }

    @Override
    public int delete(LimuCredit data) {
        return 0;
    }

    @Override
    public LimuCredit select(LimuCredit condition) {
        return super.select(NAMESPACE.concat("select_limuCredit"), condition,
            LimuCredit.class);
    }

    @Override
    public long selectTotalCount(LimuCredit condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_limuCredit_count"), condition);
    }

    @Override
    public List<LimuCredit> selectList(LimuCredit condition) {
        return super.selectList(NAMESPACE.concat("select_limuCredit"),
            condition, LimuCredit.class);
    }

    @Override
    public List<LimuCredit> selectList(LimuCredit condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_limuCredit"), start,
            count, condition, LimuCredit.class);
    }

    @Override
    public int update(LimuCredit data) {
        return super.update(NAMESPACE.concat("update_limuCredit"), data);
    }

}
