package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 导入逾期名单
 *
 * @author: CYunlai
 * @since: 2018-06-02 17:37:07
 * @history:
 */
@Data
public class OverdueMenu extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 客户姓名
    private String realName;

    // 证件号
    private String idNo;

    // 贷款银行
    private String loanBankCode;

    // 贷款金额
    private Long loanAmount;

    // 总期数
    private int periods;

    // 剩余金额
    private Long remainAmount;

    // 放款日期
    private Date fkDatetime;

    // 逾期金额
    private Long overdueAmount;

    // 逾期日期
    private Date overdueDatetime;

    // 导入日期
    private Date importDatetime;

    // 导入说明
    private String importNote;

    // 状态(0 待处理 1 已处理)
    private String status;

    // 处理时间
    private Date handleDatetime;

    // 处理说明
    private String handleNote;

    // 准入单编号
    private String budgetOrderCode;

    // 还款业务
    private String repayBizCode;

    // 还款计划
    private String repayPlanCode;

    // 创建时间（银行）
    private Date createDatetime;

    /*--------辅助字段----------*/

    private Date advanceFundDatetimeStart;// 垫资日期始

    private Date advanceFundDatetimeEnd;// 垫资日期止

    private String loanBankName;// 贷款银行名称

    // 银行放款日期
    private Date bankFkDatetimeStart;

    // 银行放款日期
    private Date bankFkDatetimeEnd;

    // 业务类型
    private RepayBiz repayBiz;

}
