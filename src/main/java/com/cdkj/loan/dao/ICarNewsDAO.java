package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarNews;

//dao层 
public interface ICarNewsDAO extends IBaseDAO<CarNews> {
    String NAMESPACE = ICarNewsDAO.class.getName().concat(".");

    public int updateCarNews(CarNews data);

    public int updateStatus(CarNews data);

    public int updateReadCounts(CarNews data);

}
