package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Mission;

//CHECK ��鲢��ע�� 
public interface IMissionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addMission(String bizCode, String name, Long time,
            String creater, String getUser);

    public void finish(String code);

    public void valid(String code);

    public int dropMission(String code);

    public int editMission(Mission data);

    public Paginable<Mission> queryMissionPage(int start, int limit,
            Mission condition);

    public List<Mission> queryMissionList(Mission condition);

    public Mission getMission(String code);

}
