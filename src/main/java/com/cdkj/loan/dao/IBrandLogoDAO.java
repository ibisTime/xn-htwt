package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BrandLogo;
import java.util.List;

//dao层 
public interface IBrandLogoDAO extends IBaseDAO<BrandLogo> {

    String NAMESPACE = IBrandLogoDAO.class.getName().concat(".");

    void insertBrandLogoList(List<BrandLogo> list);

    int update(BrandLogo data);
}