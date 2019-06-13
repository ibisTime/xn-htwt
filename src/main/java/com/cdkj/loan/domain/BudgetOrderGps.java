package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * GPS安装
 *
 * @author: CYL
 * @since: 2018-05-30 17:38:43
 * @history:
 */
@Data
public class BudgetOrderGps extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // gps设备号
    private String gpsDevNo;

    // gps类型
    private String gpsType;

    // 安装位置
    private String azLocation;

    // 安装时间
    private Date azDatetime;

    // 安装人员
    private String azUser;

    // 设备图片
    private String devPhotos;

    // 安装图片
    private String azPhotos;

    // 备注
    private String remark;

    // 预算单编号
    private String budgetOrder;

}
