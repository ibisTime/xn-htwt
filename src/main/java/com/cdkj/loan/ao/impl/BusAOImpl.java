package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBusAO;
import com.cdkj.loan.bo.IBusBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.Bus;
import com.cdkj.loan.dto.req.XN632780Req;
import com.cdkj.loan.dto.req.XN632782Req;
import com.cdkj.loan.enums.EBusStatus;

//CHECK ��鲢��ע�� 
@Service
public class BusAOImpl implements IBusAO {

    @Autowired
    private IBusBO busBO;

    @Override
    public String addBus(XN632780Req req) {
        Bus data = new Bus();
        data.setModel(req.getModel());
        data.setNumber(req.getNumber());
        data.setInsuranceEndDatetime(DateUtil.strToDate(
            req.getInsuranceEndDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setParkLocation(req.getParkLocation());
        data.setPic(req.getPic());
        data.setStatus(EBusStatus.NO_COLLAR.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return busBO.saveBus(data);
    }

    @Override
    public int dropBus(String code, String updater, String remark) {
        Bus bus = busBO.getBus(code);
        bus.setStatus(EBusStatus.CANCELLATION.getCode());
        bus.setUpdater(updater);
        bus.setUpdateDatetime(new Date());
        bus.setRemark(remark);
        return busBO.removeBus(bus);
    }

    @Override
    public void editBus(XN632782Req req) {
        Bus condition = busBO.getBus(req.getCode());
        condition.setModel(req.getModel());
        condition.setNumber(req.getNumber());
        condition.setInsuranceEndDatetime(DateUtil.strToDate(
            req.getInsuranceEndDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setParkLocation(req.getParkLocation());
        condition.setPic(req.getPic());
        condition.setUpdater(req.getUpdater());
        condition.setUpdateDatetime(new Date());
        condition.setRemark(req.getRemark());
        busBO.refreshBus(condition);
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
