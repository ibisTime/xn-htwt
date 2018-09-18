package com.cdkj.loan.ao;

import com.cdkj.loan.dto.req.XN632920Req;
import com.cdkj.loan.dto.req.XN632921Req;
import com.cdkj.loan.dto.req.XN632922Req;
import com.cdkj.loan.dto.req.XN632923Req;
import com.cdkj.loan.dto.req.XN632924Req;
import com.cdkj.loan.dto.req.XN632925Req;

public interface IMobileReportDemoAO {

    // 身份证实名认证
    String authentication(XN632920Req req);

    // 手机号实名核验
    Object mobileAuthentication(XN632921Req req);

    // 银行卡三要素核验
    Object bankCardNo3Authentication(XN632922Req req);

    // 银行卡四要素核验
    Object bankCardNo4Authentication(XN632923Req req);

    // 失信被执行人查询
    Object discreditInquiry(XN632924Req req);

    // 人脸识别核验
    Object faceRecognition(XN632925Req req);

}
