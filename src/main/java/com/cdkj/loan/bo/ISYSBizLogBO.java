package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.enums.EBizLogType;

public interface ISYSBizLogBO extends IPaginableBO<SYSBizLog> {

    // 流程第一步，执行当前方法(产生下一个的空壳)
    public void saveSYSBizLog(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode, String dealNote);

    // 不是流程第一步，执行当前方法
    public void saveNewAndPreEndSYSBizLog(String parentOrder,
            EBizLogType refType, String refOrder, String preDealNode,
            String nowDealNode, String nowDealNote, String operator);

    // 流程最后一步，执行当前方法
    public void refreshPreSYSBizLog(String refType, String refOrder,
            String dealNode, String operator);

    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition);

    public SYSBizLog getSYSBizLog(int id);

    public Paginable<SYSBizLog> getPaginableByRoleCode(int start, int limit,
            SYSBizLog condition);

    // 获取操作日志中最新操作记录
    public SYSBizLog getLatestOperateRecordByBizCode(String bizCode);

    public Paginable<SYSBizLog> getPaginableByBizOrderType(int start,
            int limit, SYSBizLog condition);
}
