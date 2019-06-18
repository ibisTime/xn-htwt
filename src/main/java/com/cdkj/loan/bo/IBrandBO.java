package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Brand;
import java.util.ArrayList;
import java.util.List;

public interface IBrandBO extends IPaginableBO<Brand> {

    String saveBrand(Brand data);

    Brand getBrand(String code);

    int editBrand(Brand data);

    void upBrand(Brand data);

    void downBrand(Brand data);

    List<Brand> queryBrand(Brand condition);

    void removeBrand(Brand data);

    Brand getBrandByBrandId(String brandId);

    void insertBrandList(ArrayList<Brand> brandList);

    void deleteByCondition(Brand condition);
}
