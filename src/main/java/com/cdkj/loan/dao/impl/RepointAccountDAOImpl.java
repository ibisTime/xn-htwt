package com.cdkj.loan.dao.impl;

import com.cdkj.loan.dao.IRepointAccountDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.RepointAccount;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("repointAccountDAOImpl")
public class RepointAccountDAOImpl extends AMybatisTemplate implements IRepointAccountDAO {


    @Override
    public int insert(RepointAccount data) {
        return super.insert(NAMESPACE.concat("insert_RepointAccount"), data);
    }


    @Override
    public int delete(RepointAccount data) {
        return super.delete(NAMESPACE.concat("delete_RepointAccount"), data);
    }


    @Override
    public RepointAccount select(RepointAccount condition) {
        return super
                .select(NAMESPACE.concat("select_RepointAccount"), condition, RepointAccount.class);
    }


    @Override
    public long selectTotalCount(RepointAccount condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_RepointAccount_count"), condition);
    }


    @Override
    public List<RepointAccount> selectList(RepointAccount condition) {
        return super.selectList(NAMESPACE.concat("select_RepointAccount"), condition,
                RepointAccount.class);
    }


    @Override
    public List<RepointAccount> selectList(RepointAccount condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_RepointAccount"), start, count, condition,
                RepointAccount.class);
    }


    @Override
    public void deleteListByRepointCode(RepointAccount data) {
        super.delete(NAMESPACE.concat("delete_RepointAccountList"), data);
    }
}