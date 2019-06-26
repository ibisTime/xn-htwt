package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BrandLogo;
import java.util.List;


public interface IBrandLogoBO extends IPaginableBO<BrandLogo> {


    String saveBrandLogo(BrandLogo data);


    int removeBrandLogo(String code);


    int refreshBrandLogo(BrandLogo data);


    List<BrandLogo> queryBrandLogoList(BrandLogo condition);


    BrandLogo getBrandLogo(String code);


    void insertBrandLogoList(List<BrandLogo> brandLogoList);
}