package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Cdbiz;
import java.util.List;

// dao层
public interface ICdbizDAO extends IBaseDAO<Cdbiz> {

    String NAMESPACE = ICdbizDAO.class.getName().concat(".");

    int updateStatus(Cdbiz data);

    int updateMakeCardStatus(Cdbiz data);

    int updateMqStatus(Cdbiz data);

    int updateFbhgpsStatus(Cdbiz data);

    int updateFbhgpsNodeStatus(Cdbiz data);

    int updateEnterNodeStatus(Cdbiz data);

    int updateZfStatus(Cdbiz data);

    int updateCurNodeCode(Cdbiz data);

    int updateYwy(Cdbiz data);

    int updateInsideJob(Cdbiz data);

    int updateCdbiz(Cdbiz data);

    List<Cdbiz> selectListByRoleCode(Cdbiz condition, int start, int count);

    long selectTotalCountByRoleCode(Cdbiz condition);

    int updateIntevNodeStatus(Cdbiz data);

    int updateCurNodeStatus(Cdbiz cdbiz);
}
