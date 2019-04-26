package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IAdvanceDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Advance;

@Repository("advanceDAOImpl")
public class AdvanceDAOImpl extends AMybatisTemplate implements IAdvanceDAO {

    @Override
    public int insert(Advance data) {
        return super.insert(NAMESPACE.concat("insert_advance"), data);
    }

    @Override
    public int delete(Advance data) {
        return super.delete(NAMESPACE.concat("delete_advance"), data);
    }

    @Override
    public Advance select(Advance condition) {
        return super.select(NAMESPACE.concat("select_advance"), condition,
            Advance.class);
    }

    @Override
    public long selectTotalCount(Advance condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_advance_count"),
            condition);
    }

    @Override
    public List<Advance> selectList(Advance condition) {
        return super.selectList(NAMESPACE.concat("select_advance"), condition,
            Advance.class);
    }

    @Override
    public List<Advance> selectList(Advance condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_advance"), start,
            count, condition, Advance.class);
    }

    @Override
    public void updateConfirmApply(Advance data) {
        super.update(NAMESPACE.concat("update_confirmApply"), data);
    }

    @Override
    public void updateAreaManageApprove(Advance data) {
        super.update(NAMESPACE.concat("update_areaManageApprove"), data);
    }

    @Override
    public void updateProvinceManageApprove(Advance data) {
        super.update(NAMESPACE.concat("update_provinceManageApprove"), data);
    }

    @Override
    public void updateConfirmMakeBill(Advance data) {
        super.update(NAMESPACE.concat("update_confirmMakeBill"), data);
    }

}
