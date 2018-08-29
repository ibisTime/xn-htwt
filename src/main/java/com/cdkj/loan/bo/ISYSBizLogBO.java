package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.enums.EBizLogType;

public interface ISYSBizLogBO extends IPaginableBO<SYSBizLog> {

    // 记录本次操作的日志
    public void recordCurOperate(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode, String dealNote, String operator,
            String teamCode);

    // 产生下一步操作的待补全的日志
    public void saveSYSBizLog(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode, String teamCode);

    // 不是流程第一步，执行当前方法
    public void saveNewAndPreEndSYSBizLog(String parentOrder,
            EBizLogType refType, String refOrder, String preDealNode,
            String nowDealNode, String nowDealNote, String operator,
            String teamCode);

    // 流程最后一步，执行当前方法
    public void refreshPreSYSBizLog(String refType, String refOrder,
            String dealNode, String dealNote, String operator);

    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition);

    public SYSBizLog getSYSBizLog(int id);

    public Paginable<SYSBizLog> getPaginableByRoleCode(int start, int limit,
            SYSBizLog condition);

    // 获取操作日志中最新操作记录
    public SYSBizLog getLatestOperateRecordByBizCode(String bizCode);

    public Paginable<SYSBizLog> getPaginableByBizOrderType(int start,
            int limit, SYSBizLog condition);

    // 通过预算单申请操作人获取内勤
    public SYSBizLog getApplyBudgetOrderOperator(String code, String code2);

    public List<SYSBizLog> querySYSBizLogListByRoleCode(SYSBizLog condition);
}
