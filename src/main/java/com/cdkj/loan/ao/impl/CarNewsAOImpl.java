package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarNewsAO;
import com.cdkj.loan.bo.ICarNewsBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarNews;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.ECarNewsStatus;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class CarNewsAOImpl implements ICarNewsAO {

    @Autowired
    private ICarNewsBO carNewsBO;

    @Autowired
    private ISYSUserBO sysUserBO;

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
            String updater, String remark, String author) {
        CarNews carNews = carNewsBO.getCarNews(code);
        if (ECarNewsStatus.ON.getCode().equals(carNews.getStatus())) {
            throw new BizException("xn0000", "资讯已上架无法修改");
        }
        return carNewsBO.refreshCarNews(carNews, title, advPic, picNumber, pic,
            context, tag, updater, remark, author);
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
        Paginable<CarNews> page = carNewsBO.getPaginable(start, limit,
            condition);
        for (CarNews carNews : page.getList()) {
            initNews(carNews);
        }
        return page;
    }

    @Override
    public List<CarNews> queryCarNewsList(CarNews condition) {
        List<CarNews> carNewList = carNewsBO.queryCarNewsList(condition);
        for (CarNews carNews : carNewList) {
            initNews(carNews);
        }
        return carNewList;
    }

    @Override
    public CarNews getCarNews(String code) {
        CarNews carNews = carNewsBO.getCarNews(code);
        initNews(carNews);
        return carNews;
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

    private void initNews(CarNews carNews) {
        SYSUser sysUser = sysUserBO.getUser(carNews.getUpdater());
        carNews.setSysUser(sysUser);
    }
}
