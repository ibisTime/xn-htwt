package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ILimuCreditAO;
import com.cdkj.loan.bo.ILimuCreditBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.LimuCredit;

//CHECK ��鲢��ע�� 
@Service
public class LimuCreditAOImpl implements ILimuCreditAO {

    @Autowired
    private ILimuCreditBO limuCreditBO;

    @Override
    public void addLimuCredit(LimuCredit data) {
        limuCreditBO.saveLimuCredit(data);
    }

    @Override
    public int editLimuCredit(LimuCredit data) {
        return limuCreditBO.refreshLimuCredit(data);
    }

    @Override
    public Paginable<LimuCredit> queryLimuCreditPage(int start, int limit,
            LimuCredit condition) {
        return limuCreditBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<LimuCredit> queryLimuCreditList(LimuCredit condition) {
        return limuCreditBO.queryLimuCreditList(condition);
    }

    @Override
    public LimuCredit getLimuCredit(int id) {
        return limuCreditBO.getLimuCredit(id);
    }
}
