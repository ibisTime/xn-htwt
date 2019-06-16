package com.cdkj.loan.ao.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.ao.IBrandAO;
import com.cdkj.loan.bo.IBrandBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OkHttpUtils;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.domain.SYSConfig;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630400Req;
import com.cdkj.loan.dto.req.XN630402Req;
import com.cdkj.loan.dto.req.XN630408Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBrandStatus;
import com.cdkj.loan.enums.ECarProduceType;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandAOImpl implements IBrandAO {

    @Autowired
    private IBrandBO brandBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

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
    @Transactional(rollbackFor = Exception.class)
    public void refreshBrand(XN630408Req req) {
        SYSConfig url = sysConfigBO.getSYSConfig("car_refresh", "url");
        SYSConfig token = sysConfigBO.getSYSConfig("car_refresh", "token");
        String json = OkHttpUtils.doAccessHTTPGetJson(url.getCvalue()
                + "/getCarBrandList" + "?token=" + token.getCvalue());
        if (json == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "查询结果为空，请检查地址和token是否正确！");
        }
        Brand condition = new Brand();
        condition.setType(ECarProduceType.IMPORT.getCode());
        List<Brand> queryBrand = brandBO.queryBrand(condition);
        if (CollectionUtils.isNotEmpty(queryBrand)) {
            for (Brand brand : queryBrand) {
                brandBO.removeBrand(brand);
            }
        }

        JSONObject jsono = JSONObject.parseObject(json);
        String s = jsono.get("brand_list").toString();
        JSONArray parseArray = JSONArray.parseArray(s);
        int i = 0;
        for (Object object : parseArray) {
            JSONObject jsonObject = (JSONObject) object;
            String brandId = jsonObject.getString("brand_id");
            String brandName = jsonObject.getString("brand_name");
            String initial = jsonObject.getString("initial");
            Date updateTime = jsonObject.getDate("update_time");

            Brand brand = new Brand();
            brand.setBrandId(brandId);
            brand.setType(ECarProduceType.IMPORT.getCode());
            brand.setName(brandName);
            brand.setLocation(EBoolean.YES.getCode());
            i++;
            brand.setOrderNo(i);
            brand.setLetter(initial);
            brand.setStatus(EBrandStatus.UP.getCode());
            brand.setUpdater(req.getUpdater());
            brand.setUpdateDatetime(updateTime);
            brandBO.saveBrand(brand);
        }
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
//        for (Brand brand : brandList) {
//            initBrand(brand);
//        }
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
