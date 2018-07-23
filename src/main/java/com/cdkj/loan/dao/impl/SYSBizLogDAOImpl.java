package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISYSBizLogDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SYSBizLog;

@Repository("sysBizLogDAOImpl")
public class SYSBizLogDAOImpl extends AMybatisTemplate implements ISYSBizLogDAO {

    @Override
    public int insert(SYSBizLog data) {
        return super.insert(NAMESPACE.concat("insert_sysBizLog"), data);
    }

    @Override
    public int delete(SYSBizLog data) {
        return super.delete(NAMESPACE.concat("delete_sysBizLog"), data);
    }

    @Override
    public SYSBizLog select(SYSBizLog condition) {
        return super.select(NAMESPACE.concat("select_sysBizLog"), condition,
            SYSBizLog.class);
    }

    @Override
    public long selectTotalCount(SYSBizLog condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_sysBizLog_count"), condition);
    }

    @Override
    public SYSBizLog selectSysBizLogLatest(SYSBizLog condition) {
        return super.select(NAMESPACE.concat("select_sysBizLog_latest"),
            condition, SYSBizLog.class);
    }

    @Override
    public List<SYSBizLog> selectList(SYSBizLog condition) {
        return super.selectList(NAMESPACE.concat("select_sysBizLog"),
            condition, SYSBizLog.class);
    }

    @Override
    public List<SYSBizLog> selectList(SYSBizLog condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_sysBizLog"), start,
            count, condition, SYSBizLog.class);
    }

    @Override
    public int updateSpeedtime(SYSBizLog condition) {
        return super.update(NAMESPACE.concat("update_datetime"), condition);
    }

    @Override
    public long selectTotalCountByRoleCode(SYSBizLog condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_sysBizLog_count_byRoleCode"), condition);
    }

    @Override
    public List<SYSBizLog> selectListByRoleCode(SYSBizLog condition, int start,
            int pageSize) {
        return super.selectList(
            NAMESPACE.concat("select_sysBizLog_byRoleCode"), start, pageSize,
            condition, SYSBizLog.class);
    }

    @Override
    public SYSBizLog getLatestOperateRecordByBizCode(SYSBizLog condition) {
        return super.select(
            NAMESPACE.concat("select_latest_operate_record_by_bizCode"),
            condition, SYSBizLog.class);
    }

    @Override
    public long selectTotalCountByBizOrderType(SYSBizLog condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_sysBizLog_count_byBizOrderType"),
            condition);
    }

    @Override
    public List<SYSBizLog> selectListByBizOrderType(SYSBizLog condition,
            int start, int pageSize) {
        return super.selectList(
            NAMESPACE.concat("select_sysBizLog_byBizOrderType"), start,
            pageSize, condition, SYSBizLog.class);
    }

    @Override
    public void updateSysBizLog(SYSBizLog data) {
        super.update(NAMESPACE.concat("update_sysBizLog"), data);
    }

}
