package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.dto.req.XN630400Req;
import com.cdkj.loan.dto.req.XN630402Req;
import com.cdkj.loan.dto.req.XN630408Req;
import java.util.List;

public interface IBrandAO {

    String DEFAULT_ORDER_COLUMN = "order_no";

    // 新增品牌
    String addBrand(XN630400Req req);

    // 修改品牌
    void editBrand(XN630402Req req);

    // 上架品牌
    void upBrand(String code, String updater, String remark,
            String location, int orderNo);

    // 下架品牌
    void downBrand(String code, String updater, String remark);

    // 分页查询
    Paginable<Brand> queryBrandPage(int start, int limit, Brand condition);

    // 详情查询
    Brand getBrand(String code);

    // 列表查询
    List<Brand> queryBrandList(Brand condition);

    void dropBrand(String code);

    // 品牌刷新
    void refreshBrand(XN630408Req req);

}
