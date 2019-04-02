package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Cdbiz;

//CHECK ��鲢��ע�� 
@Service
public class CdbizAOImpl implements ICdbizAO {

    @Autowired
    private ICdbizBO cdbizBO;

    @Override
    public Paginable<Cdbiz> queryCdbizPage(int start, int limit, Cdbiz condition) {
        return cdbizBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Cdbiz> queryCdbizList(Cdbiz condition) {
        return cdbizBO.queryCdbizList(condition);
    }

    @Override
    public Cdbiz getCdbiz(String code) {
        return cdbizBO.getCdbiz(code);
    }
}
