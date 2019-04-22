package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IMissionAO;
import com.cdkj.loan.bo.IMissionBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Mission;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class MissionAOImpl implements IMissionAO {

    @Autowired
    private IMissionBO missionBO;

    @Override
    public String addMission(String bizCode, String name, Long time,
            String creater, String getUser) {
        return missionBO.saveMission(bizCode, name, time, creater, getUser);
    }

    @Override
    public int editMission(Mission data) {
        if (!missionBO.isMissionExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return missionBO.refreshMission(data);
    }

    @Override
    public int dropMission(String code) {
        if (!missionBO.isMissionExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return missionBO.removeMission(code);
    }

    @Override
    public Paginable<Mission> queryMissionPage(int start, int limit,
            Mission condition) {
        return missionBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Mission> queryMissionList(Mission condition) {
        return missionBO.queryMissionList(condition);
    }

    @Override
    public Mission getMission(String code) {
        return missionBO.getMission(code);
    }

    @Override
    public void finish(String code) {
        Mission mission = missionBO.getMission(code);
        missionBO.refreshStatus(mission);
    }

    @Override
    public void valid(String code) {
        Mission mission = missionBO.getMission(code);
        missionBO.refreshFinish(mission);
    }
}
