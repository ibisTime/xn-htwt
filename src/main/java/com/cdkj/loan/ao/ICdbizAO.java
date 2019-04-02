package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Cdbiz;

//CHECK ��鲢��ע�� 
public interface ICdbizAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<Cdbiz> queryCdbizPage(int start, int limit, Cdbiz condition);

    public List<Cdbiz> queryCdbizList(Cdbiz condition);

    public Cdbiz getCdbiz(String code);

}
