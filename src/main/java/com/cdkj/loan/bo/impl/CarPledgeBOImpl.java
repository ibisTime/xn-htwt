package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarPledgeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarPledgeDAO;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;

@Component
public class CarPledgeBOImpl extends PaginableBOImpl<CarPledge>
        implements ICarPledgeBO {

    @Autowired
    private ICarPledgeDAO carPledgeDAO;

    @Override
    public String saveCarPledge(String bizCode, String supplementNoteg) {
        CarPledge carPledge = new CarPledge();

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.CAR_PLEDGE.getCode());
        carPledge.setCode(code);
        carPledge.setBizCode(bizCode);
        carPledge.setCurNodeCode(ENode.confirm_pledge_apply.getCode());
        carPledge.setPledgeSupplementNote(supplementNoteg);

        carPledgeDAO.insert(carPledge);
        return code;
    }

    @Override
    public void saleManConfirm(String nextNodeCode, XN632124Req req) {
        CarPledge carPledge = EntityUtils.copyData(req, CarPledge.class);
        carPledge.setCurNodeCode(nextNodeCode);

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

    @Override
    public CarPledge getCarPledgeByBizCode(String bizCode) {
        CarPledge data = null;
        if (StringUtils.isNotBlank(bizCode)) {
            CarPledge condition = new CarPledge();
            condition.setBizCode(bizCode);
            data = carPledgeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "车辆抵押信息不存在");
            }
        }
        return data;
    }

}
