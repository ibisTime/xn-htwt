package com.cdkj.loan.dao.impl;

import com.cdkj.loan.dao.IEnterFileListDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.EnterFileList;
import java.util.List;
import org.springframework.stereotype.Repository;


//CHECK 。。。
@Repository("enterFileListDAOImpl")
public class EnterFileListDAOImpl extends AMybatisTemplate implements IEnterFileListDAO {


    @Override
    public int insert(EnterFileList data) {
        return super.insert(NAMESPACE.concat("insert_enterFileList"), data);
    }


    @Override
    public int delete(EnterFileList data) {
        return super.delete(NAMESPACE.concat("delete_enterFileList"), data);
    }

    @Override
    public int update(EnterFileList data) {
        return super.update(NAMESPACE.concat("update_enterFileList"), data);
    }

    @Override
    public EnterFileList select(EnterFileList condition) {
        return super
                .select(NAMESPACE.concat("select_enterFileList"), condition, EnterFileList.class);
    }


    @Override
    public long selectTotalCount(EnterFileList condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_enterFileList_count"), condition);
    }


    @Override
    public List<EnterFileList> selectList(EnterFileList condition) {
        return super.selectList(NAMESPACE.concat("select_enterFileList"), condition,
                EnterFileList.class);
    }


    @Override
    public List<EnterFileList> selectList(EnterFileList condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_enterFileList"), start, count, condition,
                EnterFileList.class);
    }
}