package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SYSBizLog;

//dao层 
public interface ISYSBizLogDAO extends IBaseDAO<SYSBizLog> {
    String NAMESPACE = ISYSBizLogDAO.class.getName().concat(".");

    public int updateSpeedtime(SYSBizLog data);

    public SYSBizLog selectSysBizLogLatest(SYSBizLog condition);

    public long selectTotalCountByRoleCode(SYSBizLog condition);

    public List<SYSBizLog> selectListByRoleCode(SYSBizLog condition, int start,
            int pageSize);

    public SYSBizLog getLatestOperateRecordByBizCode(SYSBizLog condition);

    public long selectTotalCountByBizOrderType(SYSBizLog condition);

    public List<SYSBizLog> selectListByBizOrderType(SYSBizLog condition,
            int start, int pageSize);

    public void updateSysBizLog(SYSBizLog data);

    public List<SYSBizLog> selectListByRoleCode(SYSBizLog condition);

    public SYSBizLog getLatestOperateCreditByBizCode(SYSBizLog condition);

    public SYSBizLog getLastLog(SYSBizLog condition);
}
