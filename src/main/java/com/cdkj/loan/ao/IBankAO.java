package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.dto.req.XN632030Req;
import com.cdkj.loan.dto.req.XN632032Req;
import java.util.List;

/**
 * 银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午4:43:42 
 * @history:
 */
public interface IBankAO {

    String DEFAULT_ORDER_COLUMN = "code";

    String addBank(XN632030Req req);

    void dropBank(String code);

    void editBank(XN632032Req req);

    Bank getBank(String code);

    Paginable<Bank> queryBankPage(int start, int limit, Bank condition);

    List<Bank> queryBankList(Bank condition);
}
