package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.LoanOrder;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.domain.RepayBiz;

public interface IRepayBizBO extends IPaginableBO<RepayBiz> {

    public void refreshBankcardNew(String code, String bankcardCode,
            String updater, String remark);

    public void refreshBankcardModify(String code, String bankcardCode,
            String updater, String remark);

    public List<RepayBiz> queryRepayBizList(RepayBiz condition);

    public RepayBiz getRepayBiz(String code);

    public RepayBiz genereateNewCarLoanRepayBiz(LoanOrder data, String userId,
            String bankcardCode);

    public void repayCompleteNormal(String repayBizCode);

    public RepayBiz genereateNewProductLoanRepayBiz(Order order);

    public int refreshStatusEarlyRepayment(RepayBiz repayBiz);

}