package com.cdkj.loan.dao.impl;

import com.cdkj.loan.dao.ICdbizDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Cdbiz;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("cdbizDAOImpl")
public class CdbizDAOImpl extends AMybatisTemplate implements ICdbizDAO {

    @Override
    public int insert(Cdbiz data) {
        return super.insert(NAMESPACE.concat("insert_cdbiz"), data);
    }

    @Override
    public int delete(Cdbiz data) {
        return super.delete(NAMESPACE.concat("delete_cdbiz"), data);
    }

    @Override
    public Cdbiz select(Cdbiz condition) {
        return super.select(NAMESPACE.concat("select_cdbiz"), condition,
                Cdbiz.class);
    }

    @Override
    public long selectTotalCount(Cdbiz condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_cdbiz_count"),
                condition);
    }

    @Override
    public List<Cdbiz> selectList(Cdbiz condition) {
        return super.selectList(NAMESPACE.concat("select_cdbiz"), condition,
                Cdbiz.class);
    }

    @Override
    public List<Cdbiz> selectList(Cdbiz condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_cdbiz"), start, count,
                condition, Cdbiz.class);
    }

    @Override
    public List<Cdbiz> selectListByRoleCode(Cdbiz condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_cdbizByRoleCode"),
                start, count, condition, Cdbiz.class);
    }

    @Override
    public int updateStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_status"), data);
    }

    @Override
    public int updateMqStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_mqStatus"), data);
    }

    @Override
    public int updateFbhgpsStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_fbhgpsStatus"), data);
    }

    @Override
    public int updateFbhgpsNodeStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_fbhgpsNodeStatus"), data);
    }

    @Override
    public int updateEnterNodeStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_enterNodeStatus"), data);
    }

    @Override
    public int updateZfStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_zfStatus"), data);
    }

    @Override
    public int updateYwy(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_ywy"), data);
    }

    @Override
    public int updateMakeCardStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_makeCardStatus"), data);
    }

    @Override
    public int updateCurNodeCode(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_curNodeCode"), data);
    }

    @Override
    public int updateInsideJob(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_insideJob"), data);
    }

    @Override
    public long selectTotalCountByRoleCode(Cdbiz condition) {
        return super.selectTotalCount(
                NAMESPACE.concat("select_cdbiz_count_byRoleCode"), condition);
    }

    @Override
    public int updateIntevNodeStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_intevNodeStatus"), data);
    }

    @Override
    public int updateCurNodeStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_curNodeStatus"), data);
    }

    @Override
    public int updateCdbiz(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_cdbiz"), data);
    }

}
