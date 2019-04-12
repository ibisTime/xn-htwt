package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarconfigAO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICarCarconfigBO;
import com.cdkj.loan.bo.ICarconfigBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarCarconfig;
import com.cdkj.loan.domain.Carconfig;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.exception.BizException;

@Service
public class CarconfigAOImpl implements ICarconfigAO {

    @Autowired
    private ICarconfigBO carconfigBO;

    @Autowired
    private ICarBO carBO;

    @Autowired
    private ICarCarconfigBO carCarconfigBO;

    @Autowired
    private ISYSUserBO sysUserBO;

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
        Paginable<Carconfig> page = carconfigBO.getPaginable(start, limit,
            condition);
        for (Carconfig carconfig : page.getList()) {
            init(carconfig);
        }
        return page;
    }

    @Override
    public List<Carconfig> queryCarconfigList(Carconfig condition) {
        List<Carconfig> dataList = carconfigBO.queryCarconfigList(condition);
        for (Carconfig carconfig : dataList) {
            init(carconfig);
        }
        return dataList;
    }

    @Override
    public Carconfig getCarconfig(String code) {
        Carconfig carconfig = carconfigBO.getCarconfig(code);
        init(carconfig);
        return carconfig;
    }

    @Override
    public void setCarConfig(String carCode, List<String> configCodeList) {
        // 车型编号检查
        carBO.getCar(carCode);
        // 删除该车型已有的重复配置
        List<CarCarconfig> carconfigs = carCarconfigBO.getCarconfigs(carCode);
        for (CarCarconfig carCarconfig : carconfigs) {
            for (String configCode : configCodeList) {
                if (configCode.equals(carCarconfig.getConfigCode())) {
                    carCarconfigBO.removeCarCarconfig(carCode, configCode);
                }
            }
        }
        // 添加新配置
        for (String configCode : configCodeList) {
            carCarconfigBO.saveCarCarconfig(carCode, configCode);
        }
    }

    @Override
    public List<CarCarconfig> getCarCarconfigsByCar(String carCode, String isPic) {
        List<CarCarconfig> carconfigs = carCarconfigBO.getCarconfigs(carCode);
        if (StringUtils.isBlank(isPic)) {
            for (CarCarconfig carCarconfig : carconfigs) {
                Carconfig config = carconfigBO.getCarconfig(carCarconfig
                    .getConfigCode());
                carCarconfig.setConfig(config);

            }
            return carconfigs;
        } else if (EBoolean.NO.getCode().equals(isPic)) {
            List<CarCarconfig> noPicCarconfigs = new ArrayList<CarCarconfig>();
            for (CarCarconfig carCarconfig : carconfigs) {
                Carconfig config = carconfigBO.getCarconfig(carCarconfig
                    .getConfigCode());
                carCarconfig.setConfig(config);
                if (StringUtils.isBlank(config.getPic())) {
                    noPicCarconfigs.add(carCarconfig);
                }
            }
            return noPicCarconfigs;
        } else {
            List<CarCarconfig> picCarconfigs = new ArrayList<CarCarconfig>();
            for (CarCarconfig carCarconfig : carconfigs) {
                Carconfig config = carconfigBO.getCarconfig(carCarconfig
                    .getConfigCode());
                carCarconfig.setConfig(config);
                if (StringUtils.isNotBlank(config.getPic())) {
                    picCarconfigs.add(carCarconfig);
                }
            }
            return picCarconfigs;
        }
    }

    @Override
    public void dropCarCarconfig(String carCode, List<String> configCodeList) {
        for (String configCode : configCodeList) {
            carCarconfigBO.removeCarCarconfig(carCode, configCode);
        }
    }

    private void init(Carconfig carconfig) {
        SYSUser sysUser = sysUserBO.getUser(carconfig.getUpdater());
        carconfig.setSysUser(sysUser);
    }
}
