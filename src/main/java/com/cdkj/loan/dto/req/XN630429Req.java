package com.cdkj.loan.dto.req;

import lombok.Data;

/**
 * @author : cyl
 * @since : 2019-05-04 23:48
 */
@Data
public class XN630429Req {

    /**
     * 名称
     */
    private String name;

    /**
     * 车系编号
     */
    private String seriesCode;

    /**
     * 车系名称
     */
    private String seriesName;

    /**
     * 品牌编号
     */
    private String brandCode;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 状态（待上架/已上架/已下架）
     */
    private String status;
}

    
    