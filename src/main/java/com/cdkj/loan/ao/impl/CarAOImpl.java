package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBrandBO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISeriesBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.domain.Calculate;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.dto.req.XN630420Req;
import com.cdkj.loan.dto.req.XN630422Req;
import com.cdkj.loan.enums.EBrandStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class CarAOImpl implements ICarAO {

    @Autowired
    private ICarBO carBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISeriesBO seriesBO;

    @Autowired
    private IBrandBO brandBO;

    @Autowired
    private IBankBO bankBO;

    @Override
    public String addCar(XN630420Req req) {
        Car car = new Car();
        bankBO.getBank(req.getBankCode());
        Series series = seriesBO.getSeries(req.getSeriesCode());
        Long price = StringValidater.toLong(req.getSalePrice());
        // 车系价格区间更改
        if (null == series.getHighest() && null == series.getLowest()) {
            seriesBO.refreshHighest(series, price);
            seriesBO.refreshLowest(series, price);
        } else if (price < series.getLowest()) {
            seriesBO.refreshLowest(series, price);
        } else if (price > series.getHighest()) {
            seriesBO.refreshHighest(series, price);
        }

        Brand brand = brandBO.getBrand(series.getBrandCode());
        car.setName(req.getName());
        car.setSeriesCode(req.getSeriesCode());
        car.setSeriesName(series.getName());
        car.setBrandCode(brand.getCode());
        car.setBrandName(brand.getName());
        car.setBankCode(req.getBankCode());

        car.setLevel(req.getLevel());
        car.setVersion(req.getVersion());
        car.setStructure(req.getStructure());
        car.setDisplacment(StringValidater.toDouble(req.getDisplacement()));
        car.setFromPlace(req.getFromPlace());
        car.setProcedure(req.getProcedure());

        car.setOriginalPrice(StringValidater.toLong(req.getOriginalPrice()));
        car.setSalePrice(price);
        car.setSfAmount(StringValidater.toLong(req.getSfAmount()));
        car.setFwAmount(StringValidater.toLong(req.getFwAmount()));
        car.setJsqByhf(req.getJsqByhf());
        car.setJsqSybx(req.getJsqSybx());
        car.setSlogan(req.getSlogan());
        car.setAdvPic(req.getAdvPic());

        car.setPicNumber(StringValidater.toLong(req.getPicNumber()));
        car.setPic(req.getPic());
        car.setDescription(req.getDescription());
        car.setStatus(EBrandStatus.TO_UP.getCode());
        car.setUpdater(req.getUpdater());
        car.setUpdateDatetime(new Date());

        car.setRemark(req.getRemark());
        return carBO.saveCar(car);
    }

    @Override
    public void editCar(XN630422Req req) {
        Car car = carBO.getCar(req.getCode());
        Series series = seriesBO.getSeries(car.getSeriesCode());
        Long price = StringValidater.toLong(req.getSalePrice());
        if (EBrandStatus.UP.getCode().equals(car.getStatus())) {
            throw new BizException("xn0000", "品牌已上架，请在下架后修改");
        }
        // 车系价格区间更改
        if (price < series.getLowest()) {
            seriesBO.refreshLowest(series, price);
        } else if (price > series.getHighest()) {
            seriesBO.refreshHighest(series, price);
        }
        car.setName(req.getName());
        car.setLevel(req.getLevel());
        car.setVersion(req.getVersion());
        car.setStructure(req.getStructure());
        car.setDisplacment(StringValidater.toDouble(req.getDisplacement()));
        car.setFromPlace(req.getFromPlace());
        car.setProcedure(req.getProcedure());

        car.setOriginalPrice(StringValidater.toLong(req.getOriginalPrice()));
        car.setSalePrice(price);
        car.setSfAmount(StringValidater.toLong(req.getSfAmount()));
        car.setJsqByhf(req.getJsqByhf());
        car.setJsqSybx(req.getJsqSybx());
        car.setSlogan(req.getSlogan());
        car.setAdvPic(req.getAdvPic());

        car.setPicNumber(StringValidater.toLong(req.getPicNumber()));
        car.setPic(req.getPic());
        car.setDescription(req.getDescription());
        car.setStatus(EBrandStatus.TO_UP.getCode());
        car.setUpdater(req.getUpdater());
        car.setUpdateDatetime(new Date());

        car.setRemark(req.getRemark());
        carBO.editCar(car);
    }

    @Override
    public void upCar(String code, String location, String orderNo,
            String updater, String remark) {
        Car car = carBO.getCar(code);
        car.setStatus(EBrandStatus.UP.getCode());
        car.setLocation(StringValidater.toInteger(location));
        car.setOrderNo(StringValidater.toInteger(orderNo));
        car.setUpdater(updater);
        car.setUpdateDatetime(new Date());
        car.setRemark(remark);
        carBO.editCar(car);
    }

    @Override
    public void downCar(String code, String updater, String remark) {
        Car car = carBO.getCar(code);
        car.setStatus(EBrandStatus.DOWN.getCode());
        car.setUpdater(updater);
        car.setUpdateDatetime(new Date());
        car.setRemark(remark);
        carBO.editCar(car);
    }

    @Override
    public Paginable<Car> queryCarPage(int start, int limit, Car condition) {
        Paginable<Car> paginable = carBO.getPaginable(start, limit, condition);
        for (Car car : paginable.getList()) {
            initCar(car);
        }
        return paginable;
    }

    @Override
    public Car getCar(String code) {
        Car car = carBO.getCar(code);
        initCar(car);
        return car;
    }

    @Override
    public List<Series> queryCarList(Car condition) {

        List<Car> queryCar = carBO.queryCar(condition);
        List<Series> seriess = new ArrayList<Series>();

        outer: for (Car car : queryCar) {
            Series series = seriesBO.getSeries(car.getSeriesCode());
            for (Series data : seriess) {
                if (data.getCode().equals(series.getCode())) {
                    data.setCarNumber(data.getCarNumber() + 1);
                    List<Car> cars = data.getCars();
                    cars.add(car);
                    data.setCars(cars);
                    continue outer;
                }
            }
            if (series.getStatus().equals(EBrandStatus.UP.getCode())) {
                List<Car> cars = new ArrayList<Car>();
                cars.add(car);
                series.setCars(cars);
                series.setCarNumber(Long.valueOf(1));
                seriess.add(series);
            }
        }
        // for (Series series : seriesList) {
        // // 统计符合条件车型数
        // Long carNumber = Long.valueOf(0);
        // // 符合条件车型加入列表
        // List<Car> cars = new ArrayList<Car>();
        // for (Car car : queryCar) {
        // if (car.getSeriesCode().equals(series.getCode())) {
        // cars.add(car);
        // carNumber++;
        // }
        // }
        // series.setCarNumber(carNumber);
        // series.setCars(cars);
        // }
        // // 删除空车系
        // int flag = 0;// 车系列表是否还有空车型车系
        // while (flag == 0) {
        // for (int i = 0; i < seriesList.size(); i++) {
        // if (seriesList.get(i).getCarNumber() == 0) {
        // seriesList.remove(i);
        // break;
        // }
        // if (i == seriesList.size()) {
        // flag = 1;
        // }
        // }
        // }
        return seriess;
    }

    private void initCar(Car car) {
        if (StringUtils.isNotBlank(car.getUpdater())) {
            SYSUser user = sysUserBO.getUser(car.getUpdater());
            car.setUpdaterName(user.getRealName());
        }
    }

    @Override
    public Calculate calculate(String carCode, String period, String isTotal) {
        Car car = carBO.getCar(carCode);
        Bank bank = bankBO.getBank(car.getBankCode());
        Calculate calculate = null;
        if ("12".equals(period)) {
            calculate = new Calculate(bank.getRate12(), car, period, isTotal);
        } else if ("18".equals(period)) {
            calculate = new Calculate(bank.getRate18(), car, period, isTotal);
        } else if ("24".equals(period)) {
            calculate = new Calculate(bank.getRate24(), car, period, isTotal);
        } else if ("36".equals(period)) {
            calculate = new Calculate(bank.getRate36(), car, period, isTotal);
        }
        return calculate;
    }

}
