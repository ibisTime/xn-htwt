package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Series;
import java.util.List;

public interface ISeriesBO extends IPaginableBO<Series> {

    String saveSeries(Series data);

    Series getSeries(String code);

    int editSeries(Series data);

    int upSeries(Series data);

    int downSeries(Series data);

    void refreshHighest(Series data, Long highest);

    void refreshLowest(Series data, Long lowest);

    List<Series> querySeries(Series condition);

    List<Series> queryUpSeries();

    void removeSeries(Series data);

    Series getSeriesBySeriesId(String seriesId);
}
