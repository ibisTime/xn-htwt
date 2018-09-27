package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.FileList;

public interface IFileListBO extends IPaginableBO<FileList> {

    public void saveFileList(FileList data);

    public int removeFileList(int id);

    public void refreshFileList(FileList data);

    public List<FileList> queryFileListList(FileList condition);

    public FileList getFileList(int id);

}
