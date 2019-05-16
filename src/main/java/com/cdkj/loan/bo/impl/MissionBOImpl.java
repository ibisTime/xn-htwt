package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IMissionBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IMissionDAO;
import com.cdkj.loan.domain.Mission;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EMissionStatus;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class MissionBOImpl extends PaginableBOImpl<Mission> implements
        IMissionBO {

    @Autowired
    private IMissionDAO missionDAO;

    @Override
    public boolean isMissionExist(String code) {
        Mission condition = new Mission();
        condition.setCode(code);
        if (missionDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveMission(String bizCode, String name, Long time,
            String creater, String getUser) {
        Mission data = new Mission();
        String code = OrderNoGenerater.generate(EGeneratePrefix.mission
            .getCode());
        data.setCode(code);
        data.setBizCode(bizCode);
        data.setName(name);
        data.setTime(time);
        data.setCreater(creater);
        data.setGetUser(getUser);
        data.setStatus(EMissionStatus.to_handle.getCode());
        Date date = new Date();
        data.setCreateDatetime(date);
        date = DateUtil.getRelativeDateOfMinute(date, time.intValue() * 60);
        data.setDeadline(date);
        missionDAO.insert(data);
        return code;
    }

    @Override
    public int removeMission(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Mission data = new Mission();
            data.setCode(code);
            count = missionDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshMission(Mission data) {
        int count = 0;
        return count;
    }

    @Override
    public List<Mission> queryMissionList(Mission condition) {
        return missionDAO.selectList(condition);
    }

    @Override
    public Mission getMission(String code) {
        Mission data = null;
        if (StringUtils.isNotBlank(code)) {
            Mission condition = new Mission();
            condition.setCode(code);
            data = missionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public void refreshStatus(Mission mission) {
        mission.setStatus(EMissionStatus.handle.getCode());
        mission.setFinishDatetime(new Date());
        missionDAO.updateFinish(mission);
    }

    @Override
    public void refreshFinish(Mission mission) {
        mission.setStatus(EMissionStatus.valid.getCode());
        missionDAO.updateFinish(mission);
    }
}
