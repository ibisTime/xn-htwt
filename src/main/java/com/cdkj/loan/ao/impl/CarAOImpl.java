package com.cdkj.loan.ao.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.bo.IActionBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBrandBO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICarCarconfigBO;
import com.cdkj.loan.bo.ICarconfigBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISeriesBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.core.OkHttpUtils;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Action;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.domain.Calculate;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.CarCarconfig;
import com.cdkj.loan.domain.Carconfig;
import com.cdkj.loan.domain.SYSConfig;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.dto.req.XN630419Req;
import com.cdkj.loan.dto.req.XN630420Req;
import com.cdkj.loan.dto.req.XN630422Req;
import com.cdkj.loan.enums.EActionType;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBrandStatus;
import com.cdkj.loan.enums.ECarProduceType;
import com.cdkj.loan.exception.BizException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private IActionBO actionBO;

    @Autowired
    private ICarconfigBO carconfigBO;

    @Autowired
    private ICarCarconfigBO carCarconfigBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Transactional
    @Override
    public String addCar(XN630420Req req) {
        Car car = new Car();
        bankBO.getBank(req.getBankCode());
        Series series = seriesBO.getSeries(req.getSeriesCode());
        Long price = StringValidater.toLong(req.getSalePrice());
        // 车系价格区间更改
        if (0 == series.getHighest() && 0 == series.getLowest()) {
            seriesBO.refreshHighest(series, price);
            seriesBO.refreshLowest(series, price);
        } else if (price < series.getLowest()) {
            seriesBO.refreshLowest(series, price);
        } else if (price > series.getHighest()) {
            seriesBO.refreshHighest(series, price);
        }

        Brand brand = brandBO.getBrand(series.getBrandCode());
        car.setIsReferee(req.getIsReferee());
        car.setType(ECarProduceType.WRITE.getCode());
        car.setName(req.getName());
        car.setSeriesCode(req.getSeriesCode());
        car.setSeriesName(series.getName());
        car.setBrandCode(brand.getCode());
        car.setBrandName(brand.getName());
        car.setBankCode(req.getBankCode());

        car.setLevel(req.getLevel());
        car.setVersion(req.getVersion());
        car.setStructure(req.getStructure());
        car.setDisplacement(StringValidater.toDouble(req.getDisplacement()));
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
        car.setInsideColor(req.getInsideColor());
        car.setOutsideColor(req.getOutsideColor());
        car.setStatus(EBrandStatus.TO_UP.getCode());
        car.setUpdater(req.getUpdater());
        car.setUpdateDatetime(new Date());

        car.setRemark(req.getRemark());

        String code = carBO.saveCar(car);

        // 车型配置
        if (CollectionUtils.isNotEmpty(req.getConfigList())) {
            for (String configCode : req.getConfigList()) {
                carCarconfigBO.saveCarCarconfig(code, configCode);
            }
        }
        return code;
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
        car.setIsReferee(req.getIsReferee());

        car.setName(req.getName());
        car.setLevel(req.getLevel());
        car.setVersion(req.getVersion());
        car.setStructure(req.getStructure());
        car.setDisplacement(StringValidater.toDouble(req.getDisplacement()));
        car.setFromPlace(req.getFromPlace());
        car.setProcedure(req.getProcedure());
        car.setSeriesCode(req.getSeriesCode());
        car.setSeriesName(series.getName());

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
        car.setInsideColor(req.getInsideColor());
        car.setOutsideColor(req.getOutsideColor());
        car.setStatus(EBrandStatus.TO_UP.getCode());
        car.setUpdater(req.getUpdater());
        car.setUpdateDatetime(new Date());

        car.setRemark(req.getRemark());
        // 删除原配置
        List<CarCarconfig> carCarconfigs = carCarconfigBO.getCarconfigs(req
                .getCode());
        for (CarCarconfig carCarconfig : carCarconfigs) {
            carCarconfigBO.removeCarCarconfig(req.getCode(),
                    carCarconfig.getConfigCode());
        }

        // 增加新配置
        for (String configCode : req.getConfigList()) {
            carCarconfigBO.saveCarCarconfig(req.getCode(), configCode);
        }

        carBO.editCar(car);
    }

    @Override
    public void upCar(String code, String location, String orderNo,
            String updater, String remark) {
        Car car = carBO.getCar(code);
        car.setStatus(EBrandStatus.UP.getCode());
        car.setLocation(location);
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
    @Transactional(rollbackFor = Exception.class)
    public void refreshCar(XN630419Req req) {
        SYSConfig url = sysConfigBO.getSYSConfig("car_refresh", "url");
        SYSConfig token = sysConfigBO.getSYSConfig("car_refresh", "token");
        if (StringUtils.isBlank(req.getSeriesId())) {
            Series series = new Series();
            series.setType(ECarProduceType.IMPORT.getCode());
            List<Series> querySeries = seriesBO.querySeries(series);

            Car condition = new Car();
            condition.setType(ECarProduceType.IMPORT.getCode());
            carBO.removeByCondition(condition);

            for (Series domain : querySeries) {
                // i：UI次序，highest：最高价，lowest：最低价
                int i = 1;
                Long highest = 0L;
                Long lowest = 0L;
                refresh(domain.getCode(), url, token, domain.getSeriesId(), domain.getBrandCode(),
                        domain.getCode(), req.getUpdater(), i, highest, lowest);
            }
        } else {
            Series series = seriesBO.getSeriesBySeriesId(req.getSeriesId());
            if (series == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "车系标识不存在！");
            }
            Car condition = new Car();
            condition.setType(ECarProduceType.IMPORT.getCode());
            condition.setSeriesId(req.getSeriesId());
            carBO.removeByCondition(condition);
            int i = 1;
            Long highest = 0L;
            Long lowest = 0L;
            refresh(series.getCode(), url, token, req.getSeriesId(),
                    series.getBrandCode(), series.getCode(), req.getUpdater(), i, highest, lowest);
        }
    }

    private ArrayList<Car> refresh(String code, SYSConfig url, SYSConfig token, String seriesId,
            String brandCode, String seriesCode, String updater, int i, Long highest, Long lowest) {

        String json = OkHttpUtils.doAccessHTTPGetJson(url.getCvalue()
                + "/getCarModelList" + "?token=" + token.getCvalue() + "&seriesId=" + seriesId);
        JSONObject jsono = JSONObject.parseObject(json);
        String status = jsono.get("status").toString();
        if (status.equals("0")) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    jsono.get("error_msg").toString());
        }

        String list = jsono.get("model_list").toString();
        JSONArray parseArray = JSONArray.parseArray(list);
        ArrayList<Car> carList = new ArrayList<>();
        for (Object object : parseArray) {
            JSONObject jsonObject = (JSONObject) object;
            String modelId = jsonObject.getString("model_id");
            String modelName = jsonObject.getString("model_name");
            String modelPrice = jsonObject.getString("model_price");
            String modelYear = jsonObject.getString("model_year");
            String minRegYear = jsonObject.getString("min_reg_year");
            String maxRegYear = jsonObject.getString("max_reg_year");
            String liter = jsonObject.getString("liter");
            String gearType = jsonObject.getString("gear_type");
            String dischargeStandard = jsonObject
                    .getString("discharge_standard");
            String seatNumber = jsonObject.getString("seat_number");
            Date updateTime = jsonObject.getDate("update_time");

            Long salePrice = AmountUtil.mul(10000000L, StringValidater.toDouble(modelPrice));
            //如果是第一次进
            if (i == 1) {
                highest = salePrice;
                lowest = salePrice;
            } else {
                //比较最低价和最高价
                if (salePrice > highest) {
                    highest = salePrice;
                }
                if (salePrice < lowest) {
                    lowest = salePrice;
                }
            }
            Car car = new Car();
            car.setCode(modelId);
            car.setSeriesId(seriesId);
            car.setModelId(modelId);
            car.setType(ECarProduceType.IMPORT.getCode());
            car.setName(modelName);
            car.setBrandCode(brandCode);
            car.setSeriesCode(seriesCode);
            car.setSalePrice(salePrice);
            car.setModelYear(modelYear);
            car.setMinRegYear(minRegYear);
            car.setMaxRegYear(maxRegYear);
            car.setLiter(liter);
            car.setGearType(gearType);
            car.setDischargeStandard(dischargeStandard);
            car.setSeatNumber(seatNumber);
            car.setLocation(EBoolean.YES.getCode());
            car.setOrderNo(i);
            i++;
            car.setStatus(EBrandStatus.UP.getCode());
            car.setUpdater(updater);
            car.setUpdateDatetime(updateTime);
            carList.add(car);
        }
        seriesBO.refreshHighestAndLowest(code, highest, lowest);
        carBO.saveCarList(carList);
        return carList;
    }

    @Override
    public Paginable<Car> queryCarPage(int start, int limit, Car condition) {
        Paginable<Car> paginable = carBO.getPaginable(start, limit, condition);
//        for (Car car : paginable.getList()) {
//            initCar(car);
//        }
        return paginable;
    }

    @Override
    public Car getCar(String code, String userId) {
        Car car = carBO.getCar(code);
        initCar(car);
        if (StringUtils.isNotBlank(userId)) {
            Action condition = new Action();
            condition.setCreater(userId);
            condition.setToCode(code);
            condition.setType(EActionType.collect.getCode());
            Long count = actionBO.getTotalCount(condition);
            if (count > 0) {
                car.setIsCollect(EBoolean.YES.getCode());
            } else {
                car.setIsCollect(EBoolean.NO.getCode());
            }
        }
        return car;
    }

    @Override
    public List<Series> queryCarList(Car condition) {

        List<Car> queryCar = carBO.queryCar(condition);
        List<Series> seriess = new ArrayList<Series>();
        if (null == condition.getIsMore()) {
            outer:
            for (Car car : queryCar) {
                initCar(car);
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
                // 新增车系
                if (series.getStatus().equals(EBrandStatus.UP.getCode())) {
                    List<Car> cars = new ArrayList<Car>();
                    cars.add(car);
                    series.setCars(cars);
                    series.setCarNumber(Long.valueOf(1));
                    seriess.add(series);
                }
            }
        } else {

            seriess = seriesBO.queryUpSeries();
            for (Series series : seriess) {
                List<Car> cars = new ArrayList<Car>();
                series.setCars(cars);
                series.setCarNumber(Long.valueOf(1));
            }
            for (Car car : queryCar) {
                initCar(car);
                Series series = seriesBO.getSeries(car.getSeriesCode());
                for (Series data : seriess) {
                    if (data.getCode().equals(series.getCode())) {
                        data.setCarNumber(data.getCarNumber() + 1);
                        List<Car> cars = data.getCars();
                        cars.add(car);
                        data.setCars(cars);
                    }
                }
            }
        }
        return seriess;
    }

    private void initCar(Car car) {
        if (StringUtils.isNotBlank(car.getUpdater())) {
            SYSUser user = sysUserBO.getUser(car.getUpdater());
            car.setUpdaterName(user.getRealName());
        }
        Action condition = new Action();
        condition.setToCode(car.getCode());
        condition.setType(EActionType.collect.getCode());
        Long collectNumber = actionBO.getTotalCount(condition);
        car.setCollectNumber(collectNumber);
        // 车型下配置列表
        List<CarCarconfig> configList = carCarconfigBO.getCarconfigs(car
                .getCode());
        // 所有配置
        List<Carconfig> configs = carconfigBO.queryCarconfigList(null);
        for (CarCarconfig carCarconfig : configList) {
            for (Carconfig carconfig : configs) {
                if (carconfig.getCode().equals(carCarconfig.getConfigCode())) {
                    carconfig.setIsConfig(EBoolean.YES.getCode());
                } else if (null == carconfig.getIsConfig()) {
                    carconfig.setIsConfig(EBoolean.NO.getCode());
                }
            }
            carCarconfig.setConfig(carconfigBO.getCarconfig(carCarconfig
                    .getConfigCode()));
        }

        car.setCaonfigList(configList);
        car.setConfigs(configs);

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

    @Override
    public List<Car> queryList(Car condition) {
        return carBO.queryCar(condition);
    }

    @Override
    public void dropCar(String code) {
        carBO.removeCar(code);
    }

}
