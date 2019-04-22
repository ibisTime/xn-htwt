package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IFilePoolAO;
import com.cdkj.loan.bo.IFilePoolBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.FilePool;

@Service
public class FilePoolAOImpl implements IFilePoolAO {

    @Autowired
    private IFilePoolBO filePoolBO;

    @Override
    public Paginable<FilePool> queryFilePoolPage(int start, int limit,
            FilePool condition) {
        return filePoolBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<FilePool> queryFilePoolList(FilePool condition) {
        return filePoolBO.queryFilePoolList(condition);
    }

    @Override
    public FilePool getFilePool(String code) {
        return filePoolBO.getFilePool(code);
    }
}
