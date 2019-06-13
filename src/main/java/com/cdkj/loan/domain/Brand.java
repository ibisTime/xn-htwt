package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

@Data
public class Brand extends ABaseDO {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = -7597820867744548232L;

    // 编号
    private String code;

    // 品牌标识
    private String brandId;

    // 品牌类型（1接口导入,2用户新增）
    private String type;

    // 字母序号
    private String letter;

    // logo
    private String logo;

    // 名称
    private String name;

    // 品牌介绍
    private String description;

    // UI位置
    private String location;

    // UI次序
    private Integer orderNo;

    // 状态
    private String status;

    // 最新修改人
    private String updater;

    // 最新修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // *****************************

    private SYSUser sysUser;

}
