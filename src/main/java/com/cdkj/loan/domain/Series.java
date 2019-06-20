package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Series extends ABaseDO {

    private static final long serialVersionUID = -6146787706371232676L;

    private String code;// 编号

    // 品牌标识
    private String brandId;

    // 车系标识
    private String seriesId;

    // 车系类型（1接口导入,2用户新增）
    private String type;

    private String makerType;// 制造商类型

    private String brandCode; // 品牌编号

    private String name; // 名称

    private String seriesGroupName; // 系列组名

    private String slogan;// 广告语

    private String advPic;// 广告图

    private Long picNumber;// 图片数量

    private Long price;// 价格区间

    private Long highest;// 最高价

    private Long lowest;// 最低价

    private String level;// 级别

    private String isReferee;// 是否推荐

    private String location;// UI位置

    private Integer orderNo;// UI次序

    private String status;// 状态

    private String updater;// 最新修改人

    private Date updateDatetime;// 最新修改时间

    private String remark;// 备注

    /*----------辅助字段-----------*/

    // 最新修改人姓名
    private String updaterName;

    private List<Car> cars;

    private Long carNumber;

    //************车型搜索条件*********

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
