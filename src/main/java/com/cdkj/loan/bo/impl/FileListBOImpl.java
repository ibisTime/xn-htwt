package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IFileListBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IFileListDAO;
import com.cdkj.loan.domain.FileList;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class FileListBOImpl extends PaginableBOImpl<FileList>
        implements IFileListBO {

    @Autowired
    private IFileListDAO fileListDAO;

    public void saveFileList(FileList data) {
        fileListDAO.insert(data);
    }

    @Override
    public int removeFileList(int id) {
        int count = 0;
        if (id != 0) {
            FileList data = new FileList();
            data.setId(id);
            count = fileListDAO.delete(data);
        }
        return count;
    }

    @Override
    public void refreshFileList(FileList data) {
        fileListDAO.update(data);
    }

    @Override
    public List<FileList> queryFileListList(FileList condition) {
        return fileListDAO.selectList(condition);
    }

    @Override
    public FileList getFileList(int id) {
        FileList data = null;
        if (id != 0) {
            FileList condition = new FileList();
            condition.setId(id);
            data = fileListDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "材料清单不存在！");
            }
        }
        return data;
    }
}
