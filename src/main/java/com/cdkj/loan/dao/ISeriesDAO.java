package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Series;

public interface ISeriesDAO extends IBaseDAO<Series> {

    String NAMESPACE = ISeriesDAO.class.getName().concat(".");

    int update(Series data);

    int updateUp(Series data);

    int updateDown(Series data);

    int updateHighest(Series data);

    int updateLowest(Series data);

    void updateHighestAndLowest(Series series);
}
