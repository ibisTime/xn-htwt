package com.cdkj.loan.dto.req;

import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class XN630422Req {

    @NotBlank(message = "编号不能为空")
    private String code; // 编号

    @NotBlank
    private String isReferee;// 是否推荐

    @NotBlank(message = "名称不能为空")
    private String name; // 名称

    @NotBlank
    private String level;// 级别

    @NotBlank
    private String version;

    @NotBlank
    private String structure;

    private String displacement;

    private String liter;

    @NotBlank
    private String fromPlace;

    @NotBlank
    private String procedure;

    @NotBlank(message = "原价不能为空")
    private String originalPrice; // 原价

    @NotBlank(message = "参考价不能为空")
    private String salePrice; // 参考价

    @NotBlank(message = "首付金额不能为空")
    private String sfAmount; // 首付金额

    @NotBlank
    private String jsqByhf;

    @NotBlank
    private String jsqSybx;

    private String slogan; // 广告语

    @NotBlank(message = "广告图不能为空")
    private String advPic; // 广告图

    @NotBlank
    private String picNumber;

    @NotBlank(message = "缩略图不能为空")
    private String pic; // 缩略图

    @NotBlank(message = "图文描述不能为空")
    private String description; // 图文描述

    @NotBlank
    private String outsideColor;// 外部颜色

    @NotBlank
    private String insideColor;// 内部颜色

    @NotBlank(message = "最新修改人不能为空")
    private String updater; // 最新修改人

    private String remark; // 备注

    private String fwAmount;

    private String seriesCode;

    private List<String> configList;

}
