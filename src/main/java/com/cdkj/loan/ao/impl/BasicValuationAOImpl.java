package com.cdkj.loan.ao.impl;

import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.ao.IBasicValuationAO;
import com.cdkj.loan.bo.IBasicValuationBO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICityListBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OkHttpUtils;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BasicValuation;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.CityList;
import com.cdkj.loan.domain.SYSConfig;
import com.cdkj.loan.dto.req.XN630479Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasicValuationAOImpl implements IBasicValuationAO {

    @Autowired
    private IBasicValuationBO basicValuationBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    private ICarBO carBO;

    @Autowired
    private ICityListBO cityListBO;

    @Override
    public void addBasicValuation(BasicValuation data) {
        basicValuationBO.saveBasicValuation(data);
    }

    @Override
    public Paginable<BasicValuation> queryBasicValuationPage(int start,
            int limit, BasicValuation condition) {
        return basicValuationBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BasicValuation> queryBasicValuationList(
            BasicValuation condition) {
        return basicValuationBO.queryBasicValuationList(condition);
    }

    @Override
    public BasicValuation getBasicValuation(int id) {
        return basicValuationBO.getBasicValuation(id);
    }

    @Override
    @Transactional
    public Object basicValuation(XN630479Req req) {
        SYSConfig url = sysConfigBO.getSYSConfig("car_refresh", "url");
        SYSConfig token = sysConfigBO.getSYSConfig("car_refresh", "token");
        CityList cityList = cityListBO
                .getCityList(StringValidater.toInteger(req.getZone()));
        if (cityList == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "城市标识不存在！");
        }
        String json = OkHttpUtils.doAccessHTTPGetJson(url.getCvalue()
                + "/getUsedCarPrice" + "?token=" + token.getCvalue() + "&modelId="
                + req.getModelId() + "&regDate=" + req.getRegDate() + "&mile="
                + req.getMile() + "&zone=" + cityList.getCityId());
        if (json == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "查询数据为空，请查看参数是否正确！");
        }
        Car car = carBO.getCarByModelId(req.getModelId());
        JSONObject jsono = JSONObject.parseObject(json);
        jsono.put("model_name", car.getName());
        String status = jsono.get("status").toString();
        if (status.equals("0")) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    jsono.get("error_msg").toString());
        }
        String evalPrice = jsono.get("eval_price").toString();
        String lowPrice = jsono.get("low_price").toString();
        String goodPrice = jsono.get("good_price").toString();
        String highPrice = jsono.get("high_price").toString();
        String dealerBuyPrice = jsono.get("dealer_buy_price").toString();
        String individualPrice = jsono.get("individual_price").toString();
        String dealerPrice = jsono.get("dealer_price").toString();
        String urls = jsono.get("url").toString();
        String price = jsono.get("price").toString();
        String dischargeStandard = jsono.get("discharge_standard").toString();
        String title = jsono.get("title").toString();
        String carLogoUrl = jsono.get("car_logo_url").toString();

        BasicValuation basicValuation = new BasicValuation();
        basicValuation.setModelId(req.getModelId());
        basicValuation.setRegDate(req.getRegDate());
        basicValuation.setMile(req.getMile());
        basicValuation.setZone(req.getZone());
        basicValuation.setEvalPrice(evalPrice);
        basicValuation.setLowPrice(lowPrice);
        basicValuation.setGoodPrice(goodPrice);
        basicValuation.setHighPrice(highPrice);
        basicValuation.setDealerBuyPrice(dealerBuyPrice);
        basicValuation.setIndividualPrice(individualPrice);
        basicValuation.setDealerPrice(dealerPrice);
        basicValuation.setUrl(urls);
        basicValuation.setPrice(price);
        basicValuation.setDischargeStandard(dischargeStandard);
        basicValuation.setTitle(title);
        basicValuation.setCarLogoUrl(carLogoUrl);
        basicValuation.setCreateDatetime(new Date());
        basicValuationBO.saveBasicValuation(basicValuation);
        return jsono;
    }

}
