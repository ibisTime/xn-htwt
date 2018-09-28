package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IFileListAO;
import com.cdkj.loan.bo.IFileListBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.FileList;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632210Req;
import com.cdkj.loan.dto.req.XN632212Req;

//CHECK ��鲢��ע�� 
@Service
public class FileListAOImpl implements IFileListAO {

    @Autowired
    private IFileListBO fileListBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public void addFileList(XN632210Req req) {
        FileList data = new FileList();
        data.setNumber(req.getNumber());
        data.setName(req.getName());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        fileListBO.saveFileList(data);
    }

    @Override
    public void editFileList(XN632212Req req) {
        FileList data = getFileList(StringValidater.toInteger(req.getId()));
        data.setNumber(req.getNumber());
        data.setName(req.getName());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        fileListBO.refreshFileList(data);
    }

    @Override
    public int dropFileList(int id) {
        return fileListBO.removeFileList(id);
    }

    @Override
    public Paginable<FileList> queryFileListPage(int start, int limit,
            FileList condition) {
        Paginable<FileList> paginable = fileListBO.getPaginable(start, limit,
            condition);
        for (FileList fileList : paginable.getList()) {
            initFileList(fileList);
        }
        return paginable;
    }

    @Override
    public List<FileList> queryFileListList(FileList condition) {
        List<FileList> queryFileListList = fileListBO
            .queryFileListList(condition);
        for (FileList fileList : queryFileListList) {
            initFileList(fileList);
        }
        return queryFileListList;
    }

    @Override
    public FileList getFileList(int id) {
        FileList fileList = fileListBO.getFileList(id);
        initFileList(fileList);
        return fileList;
    }

    private void initFileList(FileList fileList) {
        if (StringUtils.isNotBlank(fileList.getUpdater())) {
            SYSUser user = sysUserBO.getUser(fileList.getUpdater());
            fileList.setUpdaterName(user.getRealName());
        }
    }
}
