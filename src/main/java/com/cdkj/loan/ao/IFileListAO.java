package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.FileList;

@Component
public interface IFileListAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addFileList(String category, String kname, String vname,
            String attachType, Long number, String updater);

    public int dropFileList(int id);

    public void editFileList(Long id, String category, String kname,
            String vname, String attachType, Long number, String updater);

    public Paginable<FileList> queryFileListPage(int start, int limit,
            FileList condition);

    public List<FileList> queryFileListList(FileList condition);

    public FileList getFileList(int id);

}
