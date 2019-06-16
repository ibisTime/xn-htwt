package com.cdkj.loan.bo;

import com.alibaba.fastjson.JSON;
import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BodyGuardApiResponse;
import com.cdkj.loan.domain.CreditIcbank;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632110ReqCreditUser;
import com.cdkj.loan.dto.req.XN632111ReqCreditUser;
import com.cdkj.loan.dto.req.XN632500Req;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import java.util.List;

public interface ICreditUserBO extends IPaginableBO<CreditUser> {

    // 新增征信人员
    void saveCreditUser(XN632110ReqCreditUser child, String bizCode, int guaUserCount);

    // 删除征信人员
    void removeCreditUserByBizCode(String bizCode);

    // 修改贷款角色
    void refreshCreditUserLoanRole(CreditUser creditUser);

    // 查询征信人员
    CreditUser getCreditUser(String code);

    // 查询征信人员
    CreditUser getCreditUserUncheck(String code);

    // 录入银行征信结果
    void inputBankCreditResult(CreditUser creditUser,
            XN632111ReqCreditUser reqCreditUser);

    // 批量查询征信人员
    List<CreditUser> queryCreditUserList(CreditUser condition);

    // 查询对应的征信人员信息
    List<CreditUser> queryCreditUserList(String bizCode);

    // 查询征信单共还人，担保人，本人
    CreditUser getCreditUserByBizCode(String bizCode,
            ECreditUserLoanRole creditUserRelation);

    void refreshCreditUser(CreditUser data);

    void refreshCreditUsers(List<CreditUser> creditUsers, XN632500Req req);

    int refreshIcbankCredit(CreditUser data, CreditIcbank creditIcbank);

    CreditIcbank getCreditIcbank(String icbankCode);

    String getTongdunResult(CreditUser creditUser);

}
