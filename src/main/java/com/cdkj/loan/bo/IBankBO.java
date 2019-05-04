package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Bank;
import java.util.List;

/**
 * 银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午4:34:57 
 * @history:
 */
public interface IBankBO extends IPaginableBO<Bank> {

    String saveBank(Bank data);

    int dropBank(String code);

    Bank getBank(String code);

    int editBank(Bank data);

    List<Bank> queryBankList(Bank condition);
}
