package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.ISeriesBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ISeriesDAO;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.enums.EBrandStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeriesBOImpl extends PaginableBOImpl<Series> implements ISeriesBO {

    @Autowired
    private ISeriesDAO seriesDAO;

    @Override
    public long getTotalCount(Series condition) {
        return seriesDAO.selectTotalCount(condition);
    }

    @Override
    public String saveSeries(Series data) {
        String code = null;
        if (data != null) {
            if (data.getCode() == null) {
                code = OrderNoGenerater.generate(EGeneratePrefix.Series
                        .getCode());
                data.setCode(code);
            }
            seriesDAO.insert(data);
        }
        return code;
    }

    @Override
    public void saveSeriesList(ArrayList<Series> seriesList) {
        seriesDAO.insertList(seriesList);
    }

    @Override
    public void removeByCondition(Series condition) {
        seriesDAO.deleteByCondition(condition);
    }

    @Override
    public Series getSeries(String code) {
        Series data = null;
        if (StringUtils.isNotBlank(code)) {
            Series condition = new Series();
            condition.setCode(code);
            data = seriesDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "车系不存在");
            }
        }
        return data;
    }

    @Override
    public int editSeries(Series data) {
        return seriesDAO.update(data);
    }

    @Override
    public List<Series> querySeries(Series condition) {
        return seriesDAO.selectList(condition);
    }

    @Override
    public int upSeries(Series data) {
        return seriesDAO.updateUp(data);
    }

    @Override
    public int downSeries(Series data) {
        return seriesDAO.updateDown(data);
    }

    @Override
    public void refreshHighest(Series data, Long highest) {
        data.setHighest(highest);
        seriesDAO.updateHighest(data);
    }

    @Override
    public void refreshLowest(Series data, Long lowest) {
        data.setLowest(lowest);
        seriesDAO.updateLowest(data);
    }

    @Override
    public List<Series> queryUpSeries() {
        Series condition = new Series();
        condition.setStatus(EBrandStatus.UP.getCode());
        List<Series> dataList = seriesDAO.selectList(condition);
        for (Series series : dataList) {
            series.setCarNumber(Long.valueOf(0));
        }
        return dataList;
    }

    @Override
    public void removeSeries(Series data) {
        seriesDAO.delete(data);
    }

    @Override
    public Series getSeriesBySeriesId(String seriesId) {
        Series series = new Series();
        series.setSeriesId(seriesId);
        return seriesDAO.select(series);
    }

    @Override
    public void refreshHighestAndLowest(String code, Long highest, Long lowest) {
        Series series = new Series();
        series.setCode(code);
        series.setHighest(highest);
        series.setLowest(lowest);
        seriesDAO.updateHighestAndLowest(series);
    }

    @Override
    public Paginable<Series> getSeriesPageByCarCondition(Series condition, int start, int limit) {
        Long count=seriesDAO.selectTotalCountByCarCondition(condition);
        Paginable<Series> page = new Page<Series>(start, limit, count);
        List<Series> dataList = seriesDAO.selectListByCarCondition(condition,
                page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }
}
