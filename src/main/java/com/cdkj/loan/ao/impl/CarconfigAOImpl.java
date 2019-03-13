package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarconfigAO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICarCarconfigBO;
import com.cdkj.loan.bo.ICarconfigBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarCarconfig;
import com.cdkj.loan.domain.Carconfig;
import com.cdkj.loan.exception.BizException;

@Service
public class CarconfigAOImpl implements ICarconfigAO {

    @Autowired
    private ICarconfigBO carconfigBO;

    @Autowired
    private ICarBO carBO;

    @Autowired
    private ICarCarconfigBO carCarconfigBO;

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
        // 车型编号检查
        carBO.getCar(carCode);
        // 删除该车型下原有配置
        List<CarCarconfig> carconfigs = carCarconfigBO.getCarconfigs(carCode);
        for (CarCarconfig carCarconfig : carconfigs) {
            carCarconfigBO.removeCarCarconfig(carCarconfig.getCode());
        }
        // 添加新配置
        for (String configCode : configCodeList) {
            carCarconfigBO.saveCarCarconfig(carCode, configCode);
        }
    }

    @Override
    public List<CarCarconfig> getCarCarconfigsByCar(String carCode) {
        List<CarCarconfig> carconfigs = carCarconfigBO.getCarconfigs(carCode);
        for (CarCarconfig carCarconfig : carconfigs) {
            Carconfig config = carconfigBO.getCarconfig(carCarconfig
                .getConfigCode());
            carCarconfig.setConfig(config);
        }
        return carconfigs;
    }
}
