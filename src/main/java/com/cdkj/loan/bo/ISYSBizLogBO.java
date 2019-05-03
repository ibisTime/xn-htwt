package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.enums.EBizLogType;
import java.util.List;

public interface ISYSBizLogBO extends IPaginableBO<SYSBizLog> {

    // 记录本次操作的日志
    void recordCurOperate(String bizCode, EBizLogType refType,
            String refOrder, String dealNode, String dealNote, String operator);

    // 产生下一步操作的待补全的日志
    void saveSYSBizLog(String bizCode, EBizLogType refType,
            String refOrder, String dealNode);

    // 不是流程第一步，执行当前方法
    void saveNewAndPreEndSYSBizLog(String bizCode, EBizLogType refType,
            String refOrder, String preDealNode, String nowDealNode,
            String nowDealNote, String operator);

    // 流程最后一步，执行当前方法
    void refreshPreSYSBizLog(String refType, String refOrder,
            String dealNode, String dealNote, String operator);

    List<SYSBizLog> querySYSBizLogList(SYSBizLog condition);

    SYSBizLog getSYSBizLog(int id);

    Paginable<SYSBizLog> getPaginableByRoleCode(int start, int limit,
            SYSBizLog condition);

    // 获取操作日志中最新操作记录
    SYSBizLog getLatestOperateRecordByBizCode(String bizCode);

    // 获取操作日志中节点是发起征信的节点并且最新操作记录
    SYSBizLog getLatestOperateCreditByBizCode(String bizCode);

    Paginable<SYSBizLog> getPaginableByBizOrderType(int start,
            int limit, SYSBizLog condition);

    // 通过预算单申请操作人获取内勤
    SYSBizLog getApplyBudgetOrderOperator(String code, String code2);

    List<SYSBizLog> querySYSBizLogListByRoleCode(SYSBizLog condition);

    // 记录日志并产生待办事项
    void logAndTask(String bizCode, EBizLogType refType,
            String refOrder, String preDealNode, String nowDealNode,
            String nowDealNote, String operator);

    SYSBizLog getLogByNode(String node, String bizCode);

    List<SYSBizLog> queryBizLogByBizCode(String bizCode);
}
