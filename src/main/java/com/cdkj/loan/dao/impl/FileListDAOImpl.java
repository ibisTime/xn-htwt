package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IFileListDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.FileList;

//CHECK 。。。 
@Repository("fileListDAOImpl")
public class FileListDAOImpl extends AMybatisTemplate implements IFileListDAO {

    @Override
    public int insert(FileList data) {
        return super.insert(NAMESPACE.concat("insert_fileList"), data);
    }

    @Override
    public int delete(FileList data) {
        return super.delete(NAMESPACE.concat("delete_fileList"), data);
    }

    @Override
    public void update(FileList data) {
        super.update(NAMESPACE.concat("update_fileList"), data);
    }

    @Override
    public FileList select(FileList condition) {
        return super.select(NAMESPACE.concat("select_fileList"), condition,
            FileList.class);
    }

    @Override
    public long selectTotalCount(FileList condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_fileList_count"),
            condition);
    }

    @Override
    public List<FileList> selectList(FileList condition) {
        return super.selectList(NAMESPACE.concat("select_fileList"), condition,
            FileList.class);
    }

    @Override
    public List<FileList> selectList(FileList condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_fileList"), start,
            count, condition, FileList.class);
    }

}
