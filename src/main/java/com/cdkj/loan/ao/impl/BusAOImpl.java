package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBusAO;
import com.cdkj.loan.bo.IBusBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bus;

//CHECK ��鲢��ע�� 
@Service
public class BusAOImpl implements IBusAO {

    @Autowired
    private IBusBO busBO;

    @Override
    public String addBus(Bus data) {
        return busBO.saveBus(data);
    }

    @Override
    public Paginable<Bus> queryBusPage(int start, int limit, Bus condition) {
        return busBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Bus> queryBusList(Bus condition) {
        return busBO.queryBusList(condition);
    }

    @Override
    public Bus getBus(String code) {
        return busBO.getBus(code);
    }
}
