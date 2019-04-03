package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.FilePool;

@Component
public interface IFilePoolAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<FilePool> queryFilePoolPage(int start, int limit,
            FilePool condition);

    public List<FilePool> queryFilePoolList(FilePool condition);

    public FilePool getFilePool(String code);

}
