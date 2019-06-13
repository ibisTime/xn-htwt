package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBrandAO;
import com.cdkj.loan.bo.IBrandBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630400Req;
import com.cdkj.loan.dto.req.XN630402Req;
import com.cdkj.loan.enums.EBrandStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class BrandAOImpl implements IBrandAO {

    @Autowired
    private IBrandBO brandBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addBrand(XN630400Req req) {
        Brand brand = new Brand();
        brand.setLetter(req.getLetter());
        brand.setLogo(req.getLogo());
        brand.setName(req.getName());
        brand.setDescription(req.getDescription());

        brand.setStatus(EBrandStatus.TO_UP.getCode());
        brand.setUpdater(req.getUpdater());
        brand.setUpdateDatetime(new Date());
        brand.setRemark(req.getRemark());
        return brandBO.saveBrand(brand);
    }

    @Override
    public void editBrand(XN630402Req req) {
        Brand brand = brandBO.getBrand(req.getCode());
        if (EBrandStatus.UP.getCode().equals(brand.getStatus())) {
            throw new BizException("xn0000", "品牌已上架，请在下架后修改");
        }
        brand.setLogo(req.getLogo());
        brand.setName(req.getName());
        brand.setLetter(req.getLetter());
        brand.setDescription(req.getDescription());
        brand.setUpdater(req.getUpdater());
        brand.setUpdateDatetime(new Date());
        brand.setRemark(req.getRemark());
        brandBO.editBrand(brand);
    }

    @Override
    public void upBrand(String code, String updater, String remark,
            String location, int orderNo) {
        Brand brand = brandBO.getBrand(code);
        if (EBrandStatus.UP.getCode().equals(brand.getStatus())) {
            throw new BizException("xn0000", "品牌已上架,请勿重复上架");
        }
        brand.setLocation(location);
        brand.setOrderNo(orderNo);
        brand.setStatus(EBrandStatus.UP.getCode());
        brand.setUpdater(updater);
        brand.setUpdateDatetime(new Date());
        brand.setRemark(remark);
        brandBO.upBrand(brand);
    }

    @Override
    public void downBrand(String code, String updater, String remark) {
        Brand brand = brandBO.getBrand(code);
        if (!EBrandStatus.UP.getCode().equals(brand.getStatus())) {
            throw new BizException("xn0000", "品牌未上架");
        }
        brand.setStatus(EBrandStatus.DOWN.getCode());
        brand.setUpdater(updater);
        brand.setUpdateDatetime(new Date());
        brand.setRemark(remark);
        brandBO.downBrand(brand);
    }

    @Override
    public Paginable<Brand> queryBrandPage(int start, int limit, Brand condition) {
        Paginable<Brand> page = brandBO.getPaginable(start, limit, condition);
        for (Brand brand : page.getList()) {
            initBrand(brand);
        }
        return page;
    }

    @Override
    public Brand getBrand(String code) {
        Brand brand = brandBO.getBrand(code);
        initBrand(brand);
        return brand;
    }

    @Override
    public List<Brand> queryBrandList(Brand condition) {
        List<Brand> brandList = brandBO.queryBrand(condition);
        for (Brand brand : brandList) {
            initBrand(brand);
        }
        return brandList;
    }

    private void initBrand(Brand brand) {
        if (null != brand.getUpdater()) {
            SYSUser sysUser = sysUserBO.getUser(brand.getUpdater());
            brand.setSysUser(sysUser);
        }
    }

    @Override
    public void dropBrand(String code) {
        Brand brand = brandBO.getBrand(code);
        brandBO.removeBrand(brand);
    }

}
