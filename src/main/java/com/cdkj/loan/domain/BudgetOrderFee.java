package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 准入单手续费
 *
 * @author: xieyj
 * @since: 2018-05-30 18:58:33
 * @history:
 */
@Data
public class BudgetOrderFee extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 公司编号
    private String companyCode;

    // 用户编号
    private String userId;

    // 客户姓名
    private String customerName;

    // 应收手续费总额
    private Long shouldAmount;

    // 实收手续费总额
    private Long realAmount;

    // 是否已结清(0 待结清 1 已结清)
    private String isSettled;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 准入单编号
    private String budgetOrder;

    /*-------辅助字段----------*/

    // 已提交手续费明细列表
    private List<BudgetOrderFeeDetail> BudgetOrderFeeDetailList;

    // 未提交手续费明细
    private BudgetOrderFeeDetail unSubmitBudgetOrderFeeDetail;

    // 业务公司名
    private String companyName;

    // 贷款银行
    private String loanBankName;

    // 贷款金额
    private Long loanAmount;

    private String updaterRealName;

    private String userName;

    // 预算单
    private Cdbiz budgetOrderObject;

    // 预算单节点
    private String curNodeCode;


}
