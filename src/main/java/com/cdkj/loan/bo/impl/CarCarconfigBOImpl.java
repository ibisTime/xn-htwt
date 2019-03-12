package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarCarconfigBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarCarconfigDAO;
import com.cdkj.loan.domain.CarCarconfig;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class CarCarconfigBOImpl extends PaginableBOImpl<CarCarconfig> implements
        ICarCarconfigBO {

    @Autowired
    private ICarCarconfigDAO carCarconfigDAO;

    @Override
    public boolean isCarCarconfigExist(String code) {
        CarCarconfig condition = new CarCarconfig();
        condition.setCode(code);
        if (carCarconfigDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCarCarconfig(String carCode, String configCode) {
        CarCarconfig data = new CarCarconfig();
        String code = OrderNoGenerater.generate(EGeneratePrefix.CarCarconfig
            .getCode());
        data.setCode(code);
        data.setCarCode(carCode);
        data.setConfigCode(configCode);
        carCarconfigDAO.insert(data);
        return code;
    }

    @Override
    public int removeCarCarconfig(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CarCarconfig data = new CarCarconfig();
            data.setCode(code);
            count = carCarconfigDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<CarCarconfig> queryCarCarconfigList(CarCarconfig condition) {
        return carCarconfigDAO.selectList(condition);
    }

    @Override
    public CarCarconfig getCarCarconfig(String code) {
        CarCarconfig data = null;
        if (StringUtils.isNotBlank(code)) {
            CarCarconfig condition = new CarCarconfig();
            condition.setCode(code);
            data = carCarconfigDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "不存在该车型配置");
            }
        }
        return data;
    }
}
