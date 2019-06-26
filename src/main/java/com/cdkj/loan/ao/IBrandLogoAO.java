package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BrandLogo;
import com.cdkj.loan.dto.req.XN630480Req;
import com.cdkj.loan.dto.req.XN630482Req;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public interface IBrandLogoAO {

    static final String DEFAULT_ORDER_COLUMN = "code";


    String addBrandLogo(XN630480Req req);

    int dropBrandLogo(String code);

    int editBrandLogo(XN630482Req req);

    Paginable<BrandLogo> queryBrandLogoPage(int start, int limit, BrandLogo condition);

    List<BrandLogo> queryBrandLogoList(BrandLogo condition);

    public BrandLogo getBrandLogo(String code);

}