package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 车辆抵押
 *
 * @author: tao
 * @since: 2019-04-22 16:47:56
 * @history:
 */
@Data
public class CarPledge extends ABaseDO {

    private static final long serialVersionUID = 7359106558695265787L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 状态
    private String status;

    // 当前节点
    private String curNodeCode;

    // 代理人
    private String pledgeUser;

    // 代理人身份证号
    private String pledgeUserIdCard;

    // 抵押地点
    private String pledgeAddress;

    // 抵押日期
    private Date pledgeDatetime;

    // 抵押提交银行时间
    private Date pledgeBankCommitDatetime;

    // 抵押提交说明
    private String pledgeBankCommitNote;

    // 车辆抵押补充说明
    private String pledgeSupplementNote;

    // 抵押合同编号
    private String pledgeContractCode;

    // 抵押套打模板
    private String pledgePrintTemplateId;

    // 抵押打印人
    private String pledgePrintUser;

    // 抵押打印日期
    private Date pledgePrintDatetime;

}
