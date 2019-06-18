package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Series;
import java.util.List;

public interface ISeriesDAO extends IBaseDAO<Series> {

    String NAMESPACE = ISeriesDAO.class.getName().concat(".");

    void insertList(List<Series> seriesList);

    int deleteByCondition(Series data);

    int update(Series data);

    int updateUp(Series data);

    int updateDown(Series data);

    int updateHighest(Series data);

    int updateLowest(Series data);

    void updateHighestAndLowest(Series series);
}
