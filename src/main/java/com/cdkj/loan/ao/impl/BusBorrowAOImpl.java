package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBusBorrowAO;
import com.cdkj.loan.bo.IBusBorrowBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BusBorrow;

@Service
public class BusBorrowAOImpl implements IBusBorrowAO {

    @Autowired
    private IBusBorrowBO busBorrowBO;

    @Override
    public String addBusBorrow(BusBorrow data) {
        return busBorrowBO.saveBusBorrow(data);
    }

    @Override
    public Paginable<BusBorrow> queryBusBorrowPage(int start, int limit,
            BusBorrow condition) {
        return busBorrowBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BusBorrow> queryBusBorrowList(BusBorrow condition) {
        return busBorrowBO.queryBusBorrowList(condition);
    }

    @Override
    public BusBorrow getBusBorrow(String code) {
        return busBorrowBO.getBusBorrow(code);
    }
}
