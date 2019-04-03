package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IFilePoolDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.FilePool;

@Repository("filePoolDAOImpl")
public class FilePoolDAOImpl extends AMybatisTemplate implements IFilePoolDAO {

    @Override
    public int insert(FilePool data) {
        return super.insert(NAMESPACE.concat("insert_filePool"), data);
    }

    @Override
    public int delete(FilePool data) {
        return 0;
    }

    @Override
    public FilePool select(FilePool condition) {
        return super.select(NAMESPACE.concat("select_filePool"), condition,
            FilePool.class);
    }

    @Override
    public long selectTotalCount(FilePool condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_filePool_count"),
            condition);
    }

    @Override
    public List<FilePool> selectList(FilePool condition) {
        return super.selectList(NAMESPACE.concat("select_filePool"), condition,
            FilePool.class);
    }

    @Override
    public List<FilePool> selectList(FilePool condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_filePool"), start,
            count, condition, FilePool.class);
    }

}
