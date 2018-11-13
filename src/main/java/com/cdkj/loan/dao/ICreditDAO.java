package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Credit;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:34:13 
 * @history:
 */
public interface ICreditDAO extends IBaseDAO<Credit> {

    String NAMESPACE = ICreditDAO.class.getName().concat(".");

    // 修改征信
    public int updateCredit(Credit credit);

    // 更新征信单节点
    public int updateNode(Credit credit);

    // 查询总数 按权限 角色编号
    public long selectTotalCountByRoleCode(Credit condition);

    // 分页查询 按权限 角色编号
    public List<Credit> selectReqBudgetByRoleCodeList(Credit condition,
            int start, int pageSize);

    // 按是作废查询
    public long selectTotalCountByIsCancel(Credit condition);

    public List<Credit> selectReqBudgetByIsCancel(Credit condition, int start,
            int pageSize);

    // 按否作废查询
    public long selectTotalCountByNotCancel(Credit condition);

    public List<Credit> selectReqBudgetByNotCancel(Credit condition, int start,
            int pageSize);

    // 征信撤回
    public int cancelCredit(Credit data);

    public int setApplyUserInfo(Credit data);

    public int refreshInputBankCreditResult(Credit data);

    // 派单
    public void distributeLeaflets(Credit credit);

    // 征信二手车评估报告
    public void updateSecondCarReport(Credit credit);

}
