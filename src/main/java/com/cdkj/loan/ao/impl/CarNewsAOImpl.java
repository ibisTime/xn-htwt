package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarNewsAO;
import com.cdkj.loan.bo.ICarNewsBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarNews;
import com.cdkj.loan.enums.ECarNewsStatus;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class CarNewsAOImpl implements ICarNewsAO {

    @Autowired
    private ICarNewsBO carNewsBO;

    @Override
    public String addCarNews(String title, String author, String advPic,
            Long picNumber, String pic, String context, String tag,
            String updater, String remark) {
        return carNewsBO.saveCarNews(title, author, advPic, picNumber, pic,
            context, tag, updater, remark);
    }

    @Override
    public int editCarNews(String code, String title, String advPic,
            Long picNumber, String pic, String context, String tag,
            String updater, String remark) {
        CarNews carNews = carNewsBO.getCarNews(code);
        if (ECarNewsStatus.ON.getCode().equals(carNews.getStatus())) {
            throw new BizException("xn0000", "资讯已上架无法修改");
        }
        return carNewsBO.refreshCarNews(carNews, title, advPic, picNumber, pic,
            context, tag, updater, remark);
    }

    @Override
    public int dropCarNews(String code) {
        if (!carNewsBO.isCarNewsExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return carNewsBO.removeCarNews(code);
    }

    @Override
    public Paginable<CarNews> queryCarNewsPage(int start, int limit,
            CarNews condition) {
        return carNewsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CarNews> queryCarNewsList(CarNews condition) {
        return carNewsBO.queryCarNewsList(condition);
    }

    @Override
    public CarNews getCarNews(String code) {
        return carNewsBO.getCarNews(code);
    }

    @Override
    public void putOn(String code, String updater, String remark) {
        CarNews carNews = carNewsBO.getCarNews(code);
        carNewsBO.refreshStatus(carNews, ECarNewsStatus.ON.getCode());
    }

    @Override
    public void putOff(String code, String updater) {
        CarNews carNews = carNewsBO.getCarNews(code);
        carNewsBO.refreshStatus(carNews, ECarNewsStatus.OFF.getCode());
    }
}
