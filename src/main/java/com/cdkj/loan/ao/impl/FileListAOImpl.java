package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IFileListAO;
import com.cdkj.loan.bo.IFileListBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.FileList;
import com.cdkj.loan.domain.SYSUser;

//CHECK ��鲢��ע�� 
@Service
public class FileListAOImpl implements IFileListAO {

    @Autowired
    private IFileListBO fileListBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public void addFileList(String category, String kname, String vname,
            String attachType, Long number, String updater) {
        fileListBO.saveFileList(category, kname, vname, attachType, number,
            updater);
    }

    @Override
    public void editFileList(Long id, String category, String kname,
            String vname, String attachType, Long number, String updater) {
        fileListBO.refreshFileList(id, category, kname, vname, attachType,
            number, updater);
    }

    @Override
    public int dropFileList(int id) {
        return fileListBO.removeFileList(Long.valueOf(id));
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
        FileList fileList = fileListBO.getFileList(Long.valueOf(id));
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
