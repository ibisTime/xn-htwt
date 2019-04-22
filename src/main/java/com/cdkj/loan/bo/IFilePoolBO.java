package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.FilePool;

public interface IFilePoolBO extends IPaginableBO<FilePool> {

    public String saveFilePool(String bizCode, String fileName, String fileType,
            String number, String url);

    public List<FilePool> queryFilePoolList(FilePool condition);

    public FilePool getFilePool(String code);

}
