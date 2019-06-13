package com.cdkj.loan.dto.res;

import lombok.Data;

/**
 * 贷款信息res
 *
 * @author : cyl
 * @since : 2019-05-03 15:32
 */
@Data
public class LoanInfoRes {

    // 贷款期限
    private Integer periods;// repayBiz

    // 银行利率
    private Double bankRate;

    // 贷款金额
    private Long loanAmount;

    // 开票价
    private String invoicePrice;// carInfo

    // 贷款产品编号
    private String loanProductCode;// repayBiz

    // 贷款产品名称
    private String loanProductName;

    // GPS费用
    private Long gpsFee;// carinfo

    // 公证费用
    private Long authFee;// carinfo

    // 首付金额
    private Long sfAmount;// repayBiz

    // 首付比例
    private Double sfRate;// repayBiz

    // 是否垫资
    private String isAdvanceFund;// cdbiz

    // 是否融资
    private String isFinacing;// cdbiz

    // 是否安装gps
    private String isAzGps;// cdbiz

    // 是否我司续保
    private String isPlatInsure;// cdbiz

    // 月供保证金
    private Long monthDeposit;// carInfo

    // 团队服务费
    private Long teamFee;// carInfo

    // 公司服务费
    private Long companyFee;// carInfo

    // 其他费用
    private Long otherFee;// carInfo

    /********* DB *********/

    // 银行名称
    private String loanBankName;

}

    
    