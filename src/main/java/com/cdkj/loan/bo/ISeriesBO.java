package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Series;

public interface ISeriesBO extends IPaginableBO<Series> {

    public String saveSeries(Series data);

    public Series getSeries(String code);

    public int editSeries(Series data);

    public int upSeries(Series data);

    public int downSeries(Series data);

    public void refreshHighest(Series data, Long highest);

    public void refreshLowest(Series data, Long lowest);

    public List<Series> querySeries(Series condition);

    public List<Series> queryUpSeries();

    public void removeSeries(Series data);

}
