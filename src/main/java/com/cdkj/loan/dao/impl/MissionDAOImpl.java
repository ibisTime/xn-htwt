package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IMissionDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Mission;

//CHECK 。。。 
@Repository("missionDAOImpl")
public class MissionDAOImpl extends AMybatisTemplate implements IMissionDAO {

    @Override
    public int insert(Mission data) {
        return super.insert(NAMESPACE.concat("insert_mission"), data);
    }

    @Override
    public int delete(Mission data) {
        return super.delete(NAMESPACE.concat("delete_mission"), data);
    }

    @Override
    public Mission select(Mission condition) {
        return super.select(NAMESPACE.concat("select_mission"), condition,
            Mission.class);
    }

    @Override
    public long selectTotalCount(Mission condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_mission_count"),
            condition);
    }

    @Override
    public List<Mission> selectList(Mission condition) {
        return super.selectList(NAMESPACE.concat("select_mission"), condition,
            Mission.class);
    }

    @Override
    public List<Mission> selectList(Mission condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_mission"), start,
            count, condition, Mission.class);
    }

    @Override
    public int updateStatus(Mission data) {
        return super.update(NAMESPACE.concat("update_status"), data);

    }

    @Override
    public int updateFinish(Mission data) {
        return super.update(NAMESPACE.concat("update_finish"), data);
    }

}
