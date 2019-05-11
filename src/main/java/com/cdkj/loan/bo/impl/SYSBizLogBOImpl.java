package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ISYSBizLogDAO;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SYSBizLogBOImpl extends PaginableBOImpl<SYSBizLog> implements
        ISYSBizLogBO {

    @Autowired
    private ISYSBizLogDAO sysBizLogDAO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Override
    public void recordCurOperate(String bizCode, EBizLogType refType,
            String refOrder, String dealNode, String dealNote, String operator) {
        SYSBizLog data = new SYSBizLog();
        data.setBizCode(bizCode);
        data.setRefType(refType.getCode());
        data.setRefOrder(refOrder);
        data.setDealNode(dealNode);
        data.setDealNote(dealNote);
        SYSUser sysUser = sysUserBO.getUser(operator);
        data.setOperateRole(sysUser.getRoleCode());
        data.setOperator(sysUser.getUserId());
        data.setOperatorName(sysUser.getLoginName());
        data.setOperatorMobile(sysUser.getMobile());
        data.setStartDatetime(new Date());
        data.setEndDatetime(new Date());
        data.setSpeedTime("0");
        sysBizLogDAO.insert(data);

    }

    @Override
    public void saveFirstSYSBizLog(String bizCode, EBizLogType refType, String refOrder,
            String dealNode, String dealNote, String operator) {
        SYSBizLog data = new SYSBizLog();
        data.setBizCode(bizCode);
        data.setRefType(refType.getCode());
        data.setRefOrder(refOrder);
        data.setDealNode(dealNode);
        data.setDealNote(dealNote);
        data.setOperator(operator);
        data.setStartDatetime(new Date());
        data.setEndDatetime(new Date());
        data.setSpeedTime("0");
        sysBizLogDAO.insert(data);
    }

    @Override
    public void saveNewSYSBizLog(String bizCode, EBizLogType refType, String refOrder,
            String dealNode, String dealNote, String operator) {
        SYSBizLog data = new SYSBizLog();
        data.setBizCode(bizCode);
        data.setRefType(refType.getCode());
        data.setRefOrder(refOrder);
        data.setDealNode(dealNode);
        data.setDealNote(dealNote);
        data.setOperator(operator);

        //查找当前节点的最新待办
        BizTask bizTask = bizTaskBO
                .queryLastBizTask(bizCode, refType.getCode(), refOrder, dealNode);
        data.setStartDatetime(bizTask.getFinishDatetime());
        data.setEndDatetime(new Date());
        //计算花费时间
        String speedTime = getSpeedTime(bizTask.getFinishDatetime(), new Date());
        data.setSpeedTime(speedTime);
        sysBizLogDAO.insert(data);
    }

    @Override
    public void saveSYSBizLog(String bizCode, EBizLogType refType,
            String refOrder, String dealNode) {
        SYSBizLog data = new SYSBizLog();
        data.setBizCode(bizCode);
        data.setRefType(refType.getCode());
        data.setRefOrder(refOrder);
        data.setDealNode(dealNode);
        data.setStartDatetime(new Date());
        sysBizLogDAO.insert(data);
    }

    // 系统用户记录日志
    @Override
    public void saveNewAndPreEndSYSBizLog(String bizCode, EBizLogType refType,
            String refOrder, String preDealNode, String nowDealNode,
            String preDealNote, String operator) {
        // 处理之前节点
        refreshPreSYSBizLog(refType.getCode(), refOrder, preDealNode,
                preDealNote, operator);
        // 保存新节点
        saveSYSBizLog(bizCode, refType, refOrder, nowDealNode);
    }

    @Override
    public void refreshPreSYSBizLog(String refType, String refOrder,
            String dealNode, String dealNote, String operator) {
        SYSBizLog data = getSYSBizLoglatest(refType, refOrder, dealNode);
        if (null != data) {
            SYSUser sysUser = sysUserBO.getUser(operator);
            data.setOperateRole(sysUser.getRoleCode());
            data.setOperator(sysUser.getUserId());
            data.setOperatorName(sysUser.getLoginName());
            data.setOperatorMobile(sysUser.getMobile());
            data.setDealNote(dealNote);
            data.setEndDatetime(new Date());
            // 计算花费时间
            String speedTime = getSpeedTime(data.getStartDatetime(), data.getEndDatetime());
            data.setSpeedTime(speedTime);
            sysBizLogDAO.updateSysBizLog(data);
        }
    }

    /**
     * 计算花费时间
     */
    private String getSpeedTime(Date startDateTime, Date endDateTime) {
        Long diff = endDateTime.getTime() - startDateTime.getTime();
        Long day = diff / (24 * 60 * 60 * 1000);
        Long hour = (diff / (60 * 60 * 1000) - day * 24);
        Long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        Long sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String speedTime = (day + "天" + hour + "时" + min + "分" + sec + "秒");
        return speedTime;
    }


    private SYSBizLog getSYSBizLoglatest(String refType, String refOrder,
            String dealNode) {
        SYSBizLog condition = new SYSBizLog();
        condition.setRefOrder(refOrder);
        condition.setRefType(refType);
        condition.setDealNode(dealNode);
        return sysBizLogDAO.selectSysBizLogLatest(condition);
    }

    @Override
    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition) {
        return sysBizLogDAO.selectList(condition);
    }

    @Override
    public SYSBizLog getSYSBizLog(int id) {
        SYSBizLog data = null;
        if (id != 0) {
            SYSBizLog condition = new SYSBizLog();
            condition.setId(id);
            data = sysBizLogDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "日志不存在！");
            }
        }
        return data;
    }

    @Override
    public Paginable<SYSBizLog> getPaginableByRoleCode(int start, int limit,
            SYSBizLog condition) {
        prepare(condition);
        long totalCount = sysBizLogDAO.selectTotalCountByRoleCode(condition);
        Paginable<SYSBizLog> page = new Page<SYSBizLog>(start, limit,
                totalCount);
        List<SYSBizLog> dataList = sysBizLogDAO.selectListByRoleCode(condition,
                page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public SYSBizLog getLatestOperateRecordByBizCode(String bizCode) {
        SYSBizLog sysBizLog = null;
        if (StringUtils.isNotBlank(bizCode)) {
            SYSBizLog condition = new SYSBizLog();
            condition.setRefOrder(bizCode);
            // sysBizLog =
            // sysBizLogDAO.getLatestOperateRecordByBizCode(condition);
            // 找最新一条，线上数据有时间重复的，会报错
            List<SYSBizLog> selectList = sysBizLogDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(selectList)) {
                sysBizLog = selectList.get(selectList.size() - 1);
            }
        }
        return sysBizLog;
    }

    @Override
    public SYSBizLog getLatestOperateCreditByBizCode(String bizCode) {
        SYSBizLog sysBizLog = null;
        if (StringUtils.isNotBlank(bizCode)) {
            SYSBizLog condition = new SYSBizLog();
            condition.setRefOrder(bizCode);
            sysBizLog = sysBizLogDAO.getLatestOperateCreditByBizCode(condition);
        }
        return sysBizLog;
    }

    @Override
    public Paginable<SYSBizLog> getPaginableByBizOrderType(int start,
            int limit, SYSBizLog condition) {
        prepare(condition);
        long totalCount = sysBizLogDAO
                .selectTotalCountByBizOrderType(condition);
        Paginable<SYSBizLog> page = new Page<SYSBizLog>(start, limit,
                totalCount);
        List<SYSBizLog> dataList = sysBizLogDAO.selectListByBizOrderType(
                condition, page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public SYSBizLog getApplyBudgetOrderOperator(String code, String node) {
        SYSBizLog condition = new SYSBizLog();
        condition.setBizCode(code);
        condition.setDealNode(node);
        List<SYSBizLog> selectList = sysBizLogDAO.selectList(condition);
        if (CollectionUtils.isEmpty(selectList)) {
            return null;
        }
        return selectList.get(0);
    }

    @Override
    public List<SYSBizLog> querySYSBizLogListByRoleCode(SYSBizLog condition) {
        List<SYSBizLog> dataList = sysBizLogDAO.selectListByRoleCode(condition);
        return dataList;
    }

    @Override
    public void logAndTask(String bizCode, EBizLogType refType,
            String refOrder, String preDealNode, String nowDealNode,
            String nowDealNote, String operator) {

    }

    @Override
    public SYSBizLog getLogByNode(String node, String bizCode) {
        SYSBizLog condition = new SYSBizLog();
        condition.setDealNode(node);
        condition.setBizCode(bizCode);
        return sysBizLogDAO.select(condition);
    }

    @Override
    public List<SYSBizLog> queryBizLogByBizCode(String bizCode) {
        SYSBizLog condition = new SYSBizLog();
        condition.setBizCode(bizCode);
        List<SYSBizLog> bizLogs = sysBizLogDAO.selectList(condition);
        return bizLogs;
    }

}
