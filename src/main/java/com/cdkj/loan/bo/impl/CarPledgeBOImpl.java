package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarPledgeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarPledgeDAO;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class CarPledgeBOImpl extends PaginableBOImpl<CarPledge>
        implements ICarPledgeBO {

    @Autowired
    private ICarPledgeDAO carPledgeDAO;

    @Override
    public String saveCarPledge(CarPledge data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.CAR_PLEDGE.getCode());
            data.setCode(code);
            carPledgeDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshCarPledge(CarPledge data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = carPledgeDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CarPledge> queryCarPledgeList(CarPledge condition) {
        return carPledgeDAO.selectList(condition);
    }

    @Override
    public CarPledge getCarPledge(String code) {
        CarPledge data = null;
        if (StringUtils.isNotBlank(code)) {
            CarPledge condition = new CarPledge();
            condition.setCode(code);
            data = carPledgeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "车辆抵押信息不存在");
            }
        }
        return data;
    }
}
