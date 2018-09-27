package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.FileList;
import com.cdkj.loan.dto.req.XN632210Req;
import com.cdkj.loan.dto.req.XN632212Req;

@Component
public interface IFileListAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addFileList(XN632210Req req);

    public int dropFileList(int id);

    public void editFileList(XN632212Req req);

    public Paginable<FileList> queryFileListPage(int start, int limit,
            FileList condition);

    public List<FileList> queryFileListList(FileList condition);

    public FileList getFileList(int id);

}
