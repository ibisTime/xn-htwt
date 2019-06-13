package com.cdkj.loan.dao.impl;

import com.cdkj.loan.dao.IBizTaskDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BizTask;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("bizTaskDAOImpl")
public class BizTaskDAOImpl extends AMybatisTemplate implements IBizTaskDAO {

    @Override
    public int insert(BizTask data) {
        return super.insert(NAMESPACE.concat("insert_bizTask"), data);
    }

    @Override
    public int delete(BizTask data) {
        return super.delete(NAMESPACE.concat("delete_bizTask"), data);
    }

    @Override
    public BizTask select(BizTask condition) {
        return super.select(NAMESPACE.concat("select_bizTask"), condition,
                BizTask.class);
    }

    @Override
    public BizTask selectLastBizTask(BizTask bizTask) {
        return super.select(NAMESPACE.concat("select_lastBizTask"), bizTask,
                BizTask.class);
    }

    @Override
    public long selectTotalCountByRole(BizTask condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_count_byRole"),
                condition);
    }

    @Override
    public List<BizTask> selectListByRole(BizTask condition, int start, int pageSize) {
        return super.selectList(NAMESPACE.concat("select_list_byRole"), start,
                pageSize, condition, BizTask.class);
    }

    @Override
    public long selectTotalCount(BizTask condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_bizTask_count"),
                condition);
    }

    @Override
    public List<BizTask> selectList(BizTask condition) {
        return super.selectList(NAMESPACE.concat("select_bizTask"), condition,
                BizTask.class);
    }

    @Override
    public List<BizTask> selectList(BizTask condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bizTask"), start,
                count, condition, BizTask.class);
    }

    @Override
    public int updateOperate(BizTask bizTask) {
        return super.update(NAMESPACE.concat("update_operateBizTask"), bizTask);
    }

}
