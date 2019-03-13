package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarNewsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarNewsDAO;
import com.cdkj.loan.domain.CarNews;
import com.cdkj.loan.enums.ECarNewsStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class CarNewsBOImpl extends PaginableBOImpl<CarNews> implements
        ICarNewsBO {

    @Autowired
    private ICarNewsDAO carNewsDAO;

    @Override
    public boolean isCarNewsExist(String code) {
        CarNews condition = new CarNews();
        condition.setCode(code);
        if (carNewsDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCarNews(String title, String author, String advPic,
            Long picNumber, String pic, String context, String tag,
            String updater, String remark) {
        CarNews data = new CarNews();
        String code = OrderNoGenerater.generate(EGeneratePrefix.CarNews
            .getCode());
        data.setCode(code);
        data.setTitle(title);
        data.setAuthor(author);
        data.setAdvPic(advPic);
        data.setPicNumber(picNumber);
        data.setPic(pic);
        data.setReadCount(Long.valueOf(0));
        data.setContext(context);
        data.setTag(tag);
        data.setStatus(ECarNewsStatus.TO_ON.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        carNewsDAO.insert(data);
        return code;
    }

    @Override
    public int removeCarNews(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CarNews data = new CarNews();
            data.setCode(code);
            count = carNewsDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCarNews(CarNews data, String title, String advPic,
            Long picNumber, String pic, String context, String tag,
            String updater, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setTitle(title);
            data.setAdvPic(advPic);
            data.setPicNumber(picNumber);
            data.setPic(pic);
            data.setReadCount(Long.valueOf(0));
            data.setContext(context);
            data.setTag(tag);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            count = carNewsDAO.updateCarNews(data);
        }
        return count;
    }

    @Override
    public List<CarNews> queryCarNewsList(CarNews condition) {
        return carNewsDAO.selectList(condition);
    }

    @Override
    public CarNews getCarNews(String code) {
        CarNews data = null;
        if (StringUtils.isNotBlank(code)) {
            CarNews condition = new CarNews();
            condition.setCode(code);
            data = carNewsDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该资讯不存在");
            }
        }
        return data;
    }

    @Override
    public void addReadCount(CarNews carNews) {
        carNews.setReadCount(carNews.getReadCount() + 1);
        carNewsDAO.updateReadCounts(carNews);
    }

    @Override
    public void refreshStatus(CarNews carNews, String status) {
        carNews.setStatus(status);
        carNewsDAO.updateStatus(carNews);
    }
}
