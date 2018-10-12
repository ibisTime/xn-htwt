package com.cdkj.loan.ao;

import com.cdkj.loan.dto.req.XN632920Req;
import com.cdkj.loan.dto.req.XN632921Req;
import com.cdkj.loan.dto.req.XN632922Req;
import com.cdkj.loan.dto.req.XN632923Req;
import com.cdkj.loan.dto.req.XN632924Req;
import com.cdkj.loan.dto.req.XN632925Req;
import com.cdkj.loan.dto.req.XN632926Req;
import com.cdkj.loan.dto.req.XN632927Req;
import com.cdkj.loan.dto.req.XN632928Req;
import com.cdkj.loan.dto.req.XN632929Req;
import com.cdkj.loan.dto.req.XN632930Req;
import com.cdkj.loan.dto.req.XN632931Req;
import com.cdkj.loan.dto.req.XN632932Req;
import com.cdkj.loan.dto.req.XN632933Req;
import com.cdkj.loan.dto.req.XN632934Req;

public interface IMobileReportDemoAO {

    // 身份证实名认证
    String authentication(XN632920Req req);

    // 涉案列表(记录)
    Object involvedList(XN632921Req req);

    // 涉案详情
    Object involvedDetails(XN632922Req req);

    // 银行卡四要素核验
    Object bankCardNo4Authentication(XN632923Req req);

    // 失信被执行人查询
    Object discreditInquiry(XN632924Req req);

    // 社保地区列表查询
    Object socialsecurityArea(XN632925Req req);

    // 社保地区登陆元素查询
    Object socialsecurityLand(XN632926Req req);

    // 社保查询
    Object socialSecurity(XN632927Req req);

    // 公积金地区列表查询
    Object housefundArea(XN632928Req req);

    // 公积金地区登陆元素查询
    Object housefundLand(XN632929Req req);

    // 公积金查询
    Object housefund(XN632930Req req);

    // 京东查询
    String jdFund(XN632931Req req);

    // 淘宝查询
    Object taobaoFund(XN632932Req req);

    Object callBackUrl();

    // 运营商归属地查询
    Object mobileLocation(XN632933Req req);

    // 运营商报告采集任务提交
    Object mobileReportTask(XN632934Req req);

    // 运营商报告采集状态查询
    Object mobileReportTaskStatus(String token);
}
