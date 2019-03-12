package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarconfigAO;
import com.cdkj.loan.bo.ICarconfigBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Carconfig;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class CarconfigAOImpl implements ICarconfigAO {

    @Autowired
    private ICarconfigBO carconfigBO;

    @Override
    public String addCarconfig(String name, String pic, String updater,
            String remark) {
        return carconfigBO.saveCarconfig(name, pic, updater, remark);
    }

    @Override
    public int editCarconfig(String code, String name, String pic,
            String updater, String remark) {
        Carconfig config = carconfigBO.getCarconfig(code);
        return carconfigBO.refreshCarconfig(config, name, pic, updater, remark);
    }

    @Override
    public int dropCarconfig(String code) {
        if (!carconfigBO.isCarconfigExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return carconfigBO.removeCarconfig(code);
    }

    @Override
    public Paginable<Carconfig> queryCarconfigPage(int start, int limit,
            Carconfig condition) {
        return carconfigBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Carconfig> queryCarconfigList(Carconfig condition) {
        return carconfigBO.queryCarconfigList(condition);
    }

    @Override
    public Carconfig getCarconfig(String code) {
        return carconfigBO.getCarconfig(code);
    }

    @Override
    public void setCarConfig(String carCode, List<String> configCodeList) {

    }
}
