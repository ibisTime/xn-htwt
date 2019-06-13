package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 财务垫资
 *
 * @author: tao
 * @since: 2019-04-24 16:31:04
 * @history:
 */
@Data
public class Advance extends ABaseDO {

    private static final long serialVersionUID = 6981932577813061723L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 状态
    private String status;

    // 当前节点
    private String curNodeCode;

    // 1总公司业务 2分公司业务
    private String type;

    // 退客户垫资款状态
    private String backAdvanceStatus;

    // 收回垫资款类型（1客户作废2垫资款退回）
    private String backAdvanceFundType;

    // 垫资日期
    private Date advanceFundDatetime;

    // 垫资金额
    private Integer advanceFundAmount;

    // 垫资汇总单编号(分公司业务才有)
    private String totalAdvanceFundCode;

    // 水单
    private String billPdf;

    // 垫资说明
    private String advanceNote;

    // 退客户垫资款 退款金额
    private Integer backAdvanceAmount;

    // 退客户垫资款 收款账号
    private String backAdvanceAccount;

    // 退客户垫资款 开户行
    private String backAdvanceOpenBank;

    // 退客户垫资款 开户支行
    private String backAdvanceSubbranch;

    // 退客户垫资款 水单
    private String backAdvanceWaterBill;

    // 用款金额(应退按揭款)
    private Integer useAmount;

    // 金额来源(1财务部2预支款)
    private String fundSource;

    // 制单意见说明
    private String makeBillNote;

    // 撤销理由
    private String cancelReason;

    // 付款时间
    private Date payBackDatetime;

    // 付款银行
    private String payBackBankcardCode;

    // 付款凭证
    private String payBackBillPdf;

    // 垫资账号
    private String advanceCardCode;

}
