package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 城市列表
 *
 * @author: CYunlai
 * @since: 2018-11-15 18:48:34
 * @history:
 */
@Data
public class CityList extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // id
    private int id;

    // 城市ID
    private String cityId;

    // 城市名称
    private String cityName;

    // 所属省份ID
    private String provId;

    // 所属省份名称
    private String provName;

    // 更新时间
    private Date createDatetime;

}
