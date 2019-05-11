package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 档案存放清单
 *
 * @author: CYunlai
 * @since: 2019-05-11 13:44:44
 * @history:
 */
@Data
public class EnterFileList extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 内容
    private String content;

    // 份数
    private Integer fileCount;

    // 存放时间
    private Date depositDateTime;

    // 存放人
    private String operator;

    // 备注
    private String remark;

    /***********辅助字段************/

    // 存放人名称
    private String operatorName;

}