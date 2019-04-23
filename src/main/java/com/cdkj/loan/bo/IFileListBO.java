package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.FileList;

public interface IFileListBO extends IPaginableBO<FileList> {

    public void saveFileList(String category, String kname, String vname,
            String attachType, Long number, String updater);

    public int removeFileList(Long id);

    public void refreshFileList(Long id, String category, String kname,
            String vname, String attachType, Long number, String updater);

    public List<FileList> queryFileListList(FileList condition);

    public FileList getFileList(Long id);

    public FileList getFileListByKname(String kname);

}
