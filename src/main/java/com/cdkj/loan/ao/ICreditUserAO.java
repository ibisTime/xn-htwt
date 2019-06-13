package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632532Req;
import com.cdkj.loan.dto.req.XN632533Req;
import com.cdkj.loan.dto.req.XN632534Req;
import com.cdkj.loan.dto.req.XN632535Req;
import com.cdkj.loan.dto.req.XN632536Req;

public interface ICreditUserAO {

    String DEFAULT_ORDER_COLUMN = "code";

    // 查看征信报告详情
    CreditUser getCreditUserReport(String code);

    // 主贷人和配偶一键互换
    Object changeLender(String selfCode, String wifeCode);

    /**
     * 客户信息
     *
     * @param req 客户信息入参
     */
    void saveSelfExtentInfo(XN632532Req req);

    /**
     * 家庭情况
     *
     * @param req 家庭情况入参
     */
    void saveSelfHomeInfo(XN632533Req req);

    /**
     * 工作情况
     *
     * @param req 工作情况入参
     */
    void saveSelfWorkInfo(XN632534Req req);

    /**
     * 共还人信息
     *
     * @param req 共还人信息入参
     */
    void saveGhrInfo(XN632535Req req);

    /**
     * 担保人信息
     *
     * @param req 担保人信息入参
     */
    void saveGuarantorInfo(XN632536Req req);

    Paginable<CreditUser> queryCreditUserPage(int start, int limit,
            CreditUser condition);

}
