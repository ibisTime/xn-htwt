package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Car extends ABaseDO {

    private static final long serialVersionUID = 8968327303357507883L;

    private String code; // 编号

    private String isReferee;// 是否推荐

    // 车系标识
    private String seriesId;

    // 车型标识
    private String modelId;

    // 车型类型（1接口导入,2用户新增）
    private String type;

    private String name; // 名称

    private String seriesCode;// 车系编号

    private String seriesName;// 车系名称

    private String brandCode;// 品牌编号

    private String brandName;// 品牌名称

    private String bankCode;// 银行编号

    private String level;// 级别

    private String version;// 规格/版本

    private String structure;// 结构

    private Double displacement;// 排量

    private String fromPlace;// 车源地

    private String procedure;// 手续

    private Long originalPrice;// 原价

    private Long salePrice;// 参考价

    private String modelYear;// 年款

    private String minRegYear;// 最小上牌年份

    private String maxRegYear;// 最大上牌年份

    private String liter;// 排量

    private String gearType;// 变速箱

    private String dischargeStandard;// 排放标准

    private String seatNumber;// 座位数

    private Long sfAmount; // 首付金额

    private Long fwAmount;// 服务费

    private String jsqByhf;// 必要花费

    private String jsqSybx;// 商业保险

    private String location;// UI位置

    private Integer orderNo;// UI次序

    private String slogan;// 广告语

    private String advPic;// 广告图

    private Long picNumber;// 图片数量

    private String pic;// 缩略图

    private String description;// 图文描述

    private String outsideColor;// 外部颜色

    private String insideColor;// 内部颜色

    private String status;// 状态（待上架/已上架/已下架）

    private String updater;// 最新修改人

    private Date updateDatetime;// 最新修改时间

    private String remark;// 备注

    /*---------辅助字段----------*/

    // 最新修改人姓名
    private String updaterName;

    // 搜索名称
    private String queryName;

    // 排量起
    private Double displacementStart;

    // 排量止
    private Double displacementEnd;

    // 价格起
    private Long priceStart;

    // 价格止
    private Long priceEnd;

    // 级别列表
    private List<String> levelList;

    // 结构列表
    private List<String> structureList;

    // 规格版本列表
    private List<String> versionList;

    // 车型配置列表
    private List<CarCarconfig> caonfigList;

    // 收藏数
    private Long collectNumber;

    // 全部配置
    private List<Carconfig> configs;

    private String isMore;

    private String isCollect;// 是否收藏

}
