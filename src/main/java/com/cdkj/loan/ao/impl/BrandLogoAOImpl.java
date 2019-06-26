package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IBrandLogoAO;
import com.cdkj.loan.bo.IBrandLogoBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BrandLogo;
import com.cdkj.loan.dto.req.XN630480Req;
import com.cdkj.loan.dto.req.XN630482Req;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BrandLogoAOImpl implements IBrandLogoAO {

    @Autowired
    private IBrandLogoBO brandLogoBO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addBrandLogo(XN630480Req req) {
        BrandLogo data = new BrandLogo();
        data.setBrandName(req.getBrandName());
        data.setBrandLogo(req.getBrandLogo());
        return brandLogoBO.saveBrandLogo(data);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int editBrandLogo(XN630482Req req) {
        BrandLogo data = getBrandLogo(req.getCode());
        data.setBrandName(req.getBrandName());
        data.setBrandLogo(req.getBrandLogo());
        return brandLogoBO.refreshBrandLogo(data);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int dropBrandLogo(String code) {
        return brandLogoBO.removeBrandLogo(code);
    }

    @Override
    public Paginable<BrandLogo> queryBrandLogoPage(int start, int limit,
            BrandLogo condition) {
        return brandLogoBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BrandLogo> queryBrandLogoList(BrandLogo condition) {
        return brandLogoBO.queryBrandLogoList(condition);
    }

    @Override
    public BrandLogo getBrandLogo(String code) {
        return brandLogoBO.getBrandLogo(code);
    }
}