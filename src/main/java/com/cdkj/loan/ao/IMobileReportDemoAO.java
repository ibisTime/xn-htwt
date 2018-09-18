package com.cdkj.loan.ao;

import com.cdkj.loan.dto.req.XN630094Req;

public interface IMobileReportDemoAO {

    // 身份证实名认证
    String authentication(XN630094Req req);

}
