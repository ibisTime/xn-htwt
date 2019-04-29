package com.cdkj.loan.bo.impl;

import java.util.Date;
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

    public void saveFileList(String category, String kname, String vname,
            String attachType, Long number, String updater) {
        FileList data = new FileList();
        data.setCategory(category);
        data.setKname(kname);
        data.setVname(vname);
        data.setAttachType(attachType);
        data.setNumber(number);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        fileListDAO.insert(data);
    }

    @Override
    public int removeFileList(Long id) {
        int count = 0;
        if (id != 0) {
            FileList data = new FileList();
            data.setId(Long.valueOf(id));
            count = fileListDAO.delete(data);
        }
        return count;
    }

    @Override
    public void refreshFileList(Long id, String category, String kname,
            String vname, String attachType, Long number, String updater) {
        FileList data = getFileList(id);
        data.setCategory(category);
        data.setKname(kname);
        data.setVname(vname);
        data.setAttachType(attachType);
        data.setNumber(number);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        fileListDAO.update(data);
    }

    @Override
    public List<FileList> queryFileListList(FileList condition) {
        return fileListDAO.selectList(condition);
    }

    @Override
    public FileList getFileList(Long id) {
        FileList data = null;
        if (id != 0) {
            FileList condition = new FileList();
            condition.setId(Long.valueOf(id));
            data = fileListDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "材料清单不存在！");
            }
        }
        return data;
    }

    @Override
    public FileList getFileListByKname(String kname) {
        FileList condition = new FileList();
        condition.setKname(kname);
        FileList filelist = fileListDAO.select(condition);
        return filelist;
    }
}
