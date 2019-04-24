package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarInfoDAO;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class CarInfoBOImpl extends PaginableBOImpl<CarInfo> implements
        ICarInfoBO {

    @Autowired
    private ICarInfoDAO carInfoDAO;

    @Override
    public boolean isCarInfoExist(String code) {
        CarInfo condition = new CarInfo();
        condition.setCode(code);
        if (carInfoDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCarInfo(String bizCode) {
        String code = null;
        CarInfo data = new CarInfo();
        code = OrderNoGenerater.generate(EGeneratePrefix.car_info.getCode());
        data.setCode(code);
        data.setBizCode(bizCode);
        carInfoDAO.insert(data);
        return code;
    }

    @Override
    public int removeCarInfo(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CarInfo data = new CarInfo();
            data.setCode(code);
            count = carInfoDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCarInfo(CarInfo data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = carInfoDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CarInfo> queryCarInfoList(CarInfo condition) {
        return carInfoDAO.selectList(condition);
    }

    @Override
    public CarInfo getCarInfo(String code) {
        CarInfo data = null;
        if (StringUtils.isNotBlank(code)) {
            CarInfo condition = new CarInfo();
            condition.setCode(code);
            data = carInfoDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
