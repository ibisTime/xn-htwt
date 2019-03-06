package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Credit;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:40:13 
 * @history:
 */
public interface ICreditBO extends IPaginableBO<Credit> {

    // 新增征信单
    public String saveCredit(Credit data);

    // 修改征信单
    public void refreshCredit(Credit data);

    // 查询征信单
    public Credit getCredit(String code);

    // 查询更多征信单
    public Credit getMoreCredit(String code);

    // 更新征信单节点
    public void refreshCreditNode(Credit credit);

    // 征信分页查询 按角色权限
    public Paginable<Credit> getPaginableByRoleCode(int start, int limit,
            Credit condition);

    // 按是作废分页查
    public Paginable<Credit> getPaginableByIsCancel(int start, int limit,
            Credit condition);

    // 按否作废分页查
    public Paginable<Credit> getPaginableByNotCancel(int start, int limit,
            Credit condition);

    // 征信撤回
    public void cancelCredit(Credit credit);

    public void setApplyUserInfo(Credit credit);

    public void refreshInputBankCreditResult(Credit credit);

    // 派单
    public void distributeLeaflets(Credit credit);

    public Credit getCreditBybudgetorder(String code);

    // 征信二手车评估报告
    public void refreshSecondCarReport(Credit credit);

    // 修改主贷人
    public void refreshCreditUser(Credit credit);

}
