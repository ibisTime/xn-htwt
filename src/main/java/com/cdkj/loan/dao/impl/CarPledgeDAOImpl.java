package com.cdkj.loan.dao.impl;

import com.cdkj.loan.dao.ICarPledgeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CarPledge;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("carPledgeDAOImpl")
public class CarPledgeDAOImpl extends AMybatisTemplate
        implements ICarPledgeDAO {

    @Override
    public int insert(CarPledge data) {
        return super.insert(NAMESPACE.concat("insert_carPledge"), data);
    }

    @Override
    public int delete(CarPledge data) {
        return super.delete(NAMESPACE.concat("delete_carPledge"), data);
    }

    @Override
    public CarPledge select(CarPledge condition) {
        return super.select(NAMESPACE.concat("select_carPledge"), condition,
                CarPledge.class);
    }

    @Override
    public long selectTotalCount(CarPledge condition) {
        return super.selectTotalCount(
                NAMESPACE.concat("select_carPledge_count"), condition);
    }

    @Override
    public List<CarPledge> selectList(CarPledge condition) {
        return super.selectList(NAMESPACE.concat("select_carPledge"), condition,
                CarPledge.class);
    }

    @Override
    public List<CarPledge> selectList(CarPledge condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_carPledge"), start,
                count, condition, CarPledge.class);
    }

    @Override
    public int updateSaleManConfirm(CarPledge carPledge) {
        return super.update(NAMESPACE.concat("update_saleManConfirm"),
                carPledge);
    }

    @Override
    public int updateEntryPledgeInfo(CarPledge carPledge) {
        return super.update(NAMESPACE.concat("update_entryPledgeInfo"),
                carPledge);
    }

    @Override
    public int updateCommitBank(CarPledge carPledge) {
        return super.update(NAMESPACE.concat("update_commitBank"), carPledge);
    }

    @Override
    public int updateConfirmDone(CarPledge carPledge) {
        return super.update(NAMESPACE.concat("update_confirmDone"), carPledge);
    }

    @Override
    public void updateSupplementNote(CarPledge carPledge) {
        super.update(NAMESPACE.concat("update_supplementNote"), carPledge);
    }

    @Override
    public void updateCarPledge(CarPledge carPledge) {
        super.update(NAMESPACE.concat("update_carPledge"), carPledge);
    }
}
