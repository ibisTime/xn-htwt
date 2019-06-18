package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Brand;
import java.util.List;

public interface IBrandDAO extends IBaseDAO<Brand> {

    String NAMESPACE = IBrandDAO.class.getName().concat(".");

    void insertList(List<Brand> brandList);

    int update(Brand data);

    int updateUp(Brand data);

    int updateDown(Brand data);

    int deleteByCondition(Brand data);

}
