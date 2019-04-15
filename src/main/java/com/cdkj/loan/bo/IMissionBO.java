package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Mission;

//CHECK ��鲢��ע�� 
public interface IMissionBO extends IPaginableBO<Mission> {

    public boolean isMissionExist(String code);

    public String saveMission(String bizCode, String name, Long time,
            String creater, String getUser);

    public int removeMission(String code);

    public int refreshMission(Mission data);

    public void refreshStatus(Mission mission);

    public void refreshFinish(Mission mission);

    public List<Mission> queryMissionList(Mission condition);

    public Mission getMission(String code);

}
