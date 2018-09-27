package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IFileListAO;
import com.cdkj.loan.bo.IFileListBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.FileList;
import com.cdkj.loan.dto.req.XN632210Req;
import com.cdkj.loan.dto.req.XN632212Req;

//CHECK ��鲢��ע�� 
@Service
public class FileListAOImpl implements IFileListAO {

    @Autowired
    private IFileListBO fileListBO;

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
        return fileListBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<FileList> queryFileListList(FileList condition) {
        return fileListBO.queryFileListList(condition);
    }

    @Override
    public FileList getFileList(int id) {
        return fileListBO.getFileList(id);
    }
}
