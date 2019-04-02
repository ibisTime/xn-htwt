package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarOrderAO;
import com.cdkj.loan.bo.IBrandBO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICarOrderBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISeriesBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.CarOrder;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN630430Req;
import com.cdkj.loan.enums.ECarOrderStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class CarOrderAOImpl implements ICarOrderAO {

    @Autowired
    private ICarOrderBO carOrderBO;

    @Autowired
    private ICarBO carBO;

    @Autowired
    private ISeriesBO seriesBO;

    @Autowired
    private IBrandBO brandBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addCarOrder(XN630430Req req) {
        Car car = carBO.getCar(req.getCarCode());
        Series series = seriesBO.getSeries(car.getSeriesCode());
        Brand brand = brandBO.getBrand(series.getBrandCode());
        CarOrder carOrder = new CarOrder();
        carOrder.setUserId(req.getUserId());
        carOrder.setUserMobile(req.getUserMobile());
        carOrder.setName(req.getName());
        carOrder.setBrandCode(brand.getCode());
        carOrder.setBrandName(brand.getName());
        carOrder.setSeriesCode(series.getCode());
        carOrder.setSeriesName(series.getName());
        carOrder.setCarCode(req.getCarCode());
        carOrder.setCarName(car.getName());
        carOrder.setPrice(car.getSalePrice());
        carOrder.setSfRate(AmountUtil.div(car.getSfAmount().doubleValue(),
            car.getSalePrice()));
        carOrder.setSfAmount(car.getSfAmount());
        carOrder.setCreateDatetime(new Date());
        carOrder.setStatus(ECarOrderStatus.DCL.getCode());
        return carOrderBO.saveCarOrder(carOrder);
    }

    @Override
    public void editCarOrder(String code, String result, String handler,
            String remark) {
        CarOrder carOrder = carOrderBO.getCarOrder(code);
        if (ECarOrderStatus.DCL.getCode().equals(carOrder.getStatus())) {
            if (result.equals("0")) {
                carOrder.setStatus(ECarOrderStatus.YCL.getCode());
            } else {
                carOrder.setStatus(ECarOrderStatus.YZF.getCode());
            }
            carOrder.setHandler(handler);
            carOrder.setHandleDatetime(new Date());
            carOrder.setRemark(remark);
            carOrderBO.editCarOrder(carOrder);
        } else {
            throw new BizException("mag", "该申请已被处理，请重新选择");
        }
        // TODO

    }

    @Override
    public Paginable<CarOrder> queryCarPage(int start, int limit,
            CarOrder condition) {
        Paginable<CarOrder> results = carOrderBO.getPaginable(start, limit,
            condition);
        List<CarOrder> list = results.getList();
        for (CarOrder carOrder : list) {
            initOrder(carOrder);
        }
        return results;
    }

    @Override
    public CarOrder getCarOrder(String code) {
        CarOrder carOrder = carOrderBO.getCarOrder(code);
        initOrder(carOrder);
        return carOrder;
    }

    @Override
    public List<CarOrder> queryCarOrderList(CarOrder condition) {
        List<CarOrder> carOrderList = carOrderBO.queryCarOrder(condition);
        for (CarOrder carOrder : carOrderList) {
            initOrder(carOrder);
        }
        return carOrderList;
    }

    private void initOrder(CarOrder carOrder) {
        Car car = carBO.getCar(carOrder.getCarCode());
        carOrder.setCar(car);
        User user = userBO.getUser(carOrder.getUserId());
        carOrder.setUser(user);
        SYSUser sysUser = sysUserBO.getUser(carOrder.getHandler());
        carOrder.setSysUser(sysUser);
    }

}
