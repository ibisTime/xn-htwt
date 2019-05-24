package com.cdkj.loan.ao.impl;

import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EMissionStatus;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IMissionAO;
import com.cdkj.loan.bo.IMissionBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Mission;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class MissionAOImpl implements IMissionAO {

    @Autowired
    private IMissionBO missionBO;

    @Autowired
    private ISYSUserBO sysUserBO;

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
        Paginable<Mission> page = missionBO.getPaginable(start, limit,
            condition);
        for (Mission mission : page.getList()) {
            init(mission);
        }
        return page;
    }

    @Override
    public List<Mission> queryMissionList(Mission condition) {
        List<Mission> missions = missionBO.queryMissionList(condition);
        for (Mission mission : missions) {
            init(mission);
        }
        return missions;
    }

    @Override
    public Mission getMission(String code) {
        Mission mission = missionBO.getMission(code);
        init(mission);
        return mission;
    }

    @Override
    public void finish(String code) {
        Mission mission = missionBO.getMission(code);
        if(!EMissionStatus.to_handle.getCode().equals(mission.getStatus())){
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "该任务不是待完成状态无法完成");
        }
        missionBO.refreshStatus(mission);
    }

    @Override
    public void valid(String code) {
        Mission mission = missionBO.getMission(code);
        if(!EMissionStatus.to_handle.getCode().equals(mission.getStatus())){
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "该任务不是待完成状态无法作废");
        }
        missionBO.refreshFinish(mission);
    }

    private void init(Mission mission) {
        SYSUser creater = sysUserBO.getUser(mission.getCreater());
        SYSUser getUser = sysUserBO.getUser(mission.getGetUser());
        mission.setCreaterName(creater.getRealName());
        mission.setGetUserName(getUser.getRealName());
    }
}
