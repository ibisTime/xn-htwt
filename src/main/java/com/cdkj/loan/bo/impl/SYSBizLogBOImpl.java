package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ISYSBizLogDAO;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ESYSBizLogStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class SYSBizLogBOImpl extends PaginableBOImpl<SYSBizLog> implements
        ISYSBizLogBO {

    @Autowired
    private ISYSBizLogDAO sysBizLogDAO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public void recordCurOperate(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode, String dealNote, String operator,
            String teamCode) {
        SYSBizLog data = new SYSBizLog();
        data.setParentOrder(parentOrder);
        data.setRefType(refType.getCode());
        data.setRefOrder(refOrder);
        data.setDealNode(dealNode);
        data.setDealNote(dealNote);
        data.setStatus(ESYSBizLogStatus.ALREADY_HANDLE.getCode());
        SYSUser sysUser = sysUserBO.getUser(operator);
        data.setOperateRole(sysUser.getRoleCode());
        data.setOperator(sysUser.getUserId());
        data.setOperatorName(sysUser.getLoginName());
        data.setOperatorMobile(sysUser.getMobile());
        data.setStartDatetime(new Date());
        data.setEndDatetime(new Date());
        data.setSpeedTime("0");
        data.setTeamCode(teamCode);
        sysBizLogDAO.insert(data);
    }

    @Override
    public void saveSYSBizLog(String parentOrder, EBizLogType refType,
            String refOrder, String dealNode, String teamCode) {
        SYSBizLog data = new SYSBizLog();
        data.setParentOrder(parentOrder);
        data.setRefType(refType.getCode());
        data.setRefOrder(refOrder);
        data.setDealNode(dealNode);
        data.setStatus(ESYSBizLogStatus.WAIT_HANDLE.getCode());
        data.setStartDatetime(new Date());
        data.setTeamCode(teamCode);
        sysBizLogDAO.insert(data);
    }

    // 系统用户记录日志
    @Override
    public void saveNewAndPreEndSYSBizLog(String parentOrder,
            EBizLogType refType, String refOrder, String preDealNode,
            String nowDealNode, String preDealNote, String operator,
            String teamCode) {
        // 处理之前节点
        refreshPreSYSBizLog(refType.getCode(), refOrder, preDealNode,
            preDealNote, operator);
        // 保存新节点
        saveSYSBizLog(parentOrder, refType, refOrder, nowDealNode, teamCode);
    }

    @Override
    public void refreshPreSYSBizLog(String refType, String refOrder,
            String dealNode, String dealNote, String operator) {
        SYSBizLog data = getSYSBizLoglatest(refType, refOrder, dealNode);
        SYSUser sysUser = sysUserBO.getUser(operator);
        data.setStatus(ESYSBizLogStatus.ALREADY_HANDLE.getCode());
        data.setOperateRole(sysUser.getRoleCode());
        data.setOperator(sysUser.getUserId());
        data.setOperatorName(sysUser.getLoginName());
        data.setOperatorMobile(sysUser.getMobile());
        data.setDealNote(dealNote);

        if (data != null) {
            data.setEndDatetime(new Date());
            // 计算花费时间
            Long start = data.getStartDatetime().getTime();
            Long end = data.getEndDatetime().getTime();
            Long diff = end - start;
            Long day = diff / (24 * 60 * 60 * 1000);
            Long hour = (diff / (60 * 60 * 1000) - day * 24);
            Long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            Long sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            data.setSpeedTime(day + "天" + hour + "时" + min + "分" + sec + "秒");
            // sysBizLogDAO.updateSpeedtime(data);
            sysBizLogDAO.updateSysBizLog(data);
        }
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
            sysBizLog = sysBizLogDAO.getLatestOperateRecordByBizCode(condition);
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
}
