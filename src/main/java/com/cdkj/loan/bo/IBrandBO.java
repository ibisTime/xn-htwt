package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Brand;
import java.util.List;

public interface IBrandBO extends IPaginableBO<Brand> {

    public String saveBrand(Brand data);

    public Brand getBrand(String code);

    public int editBrand(Brand data);

    public void upBrand(Brand data);

    public void downBrand(Brand data);

    public List<Brand> queryBrand(Brand condition);

    public void removeBrand(Brand data);

    Brand getBrandByBrandId(String brandId);
}
