package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IMobileReportDemoAO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.common.PropertiesUtil;
import com.cdkj.loan.creditCommon.HttpClient;
import com.cdkj.loan.creditCommon.StringUtils;
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

import demo.AbstractCredit;

@Service
public class MobileReportDemoAOImpl implements IMobileReportDemoAO {
    @Autowired
    private ISYSConfigBO sysConfigBO;

    public static final String LMZX_URL = PropertiesUtil.Config.LMZX_URL;

    @Override
    @Transactional
    public String authentication(XN632920Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method", "api.identity.idcheck"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    @Transactional
    public Object involvedList(XN632921Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(
            new BasicNameValuePair("method", "api.identity.involvedlistcheck"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    @Transactional
    public Object involvedDetails(XN632922Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method",
            "api.identity.involveddetailscheck"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("recordId", req.getRecordId()));
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    @Transactional
    public Object bankCardNo4Authentication(XN632923Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(
            new BasicNameValuePair("method", "api.identity.bankcard4check"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("mobileNo", req.getMobileNo()));
        reqParam.add(new BasicNameValuePair("bankCardNo", req.getBankCardNo()));
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    public Object discreditInquiry(XN632924Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam
            .add(new BasicNameValuePair("method", "api.identity.shixincheck"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    public Object socialsecurityArea(XN632925Req req) {
        HttpClient httpClient = new HttpClient();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(
            new BasicNameValuePair("method", "api.socialsecurity.getareas"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    public Object socialsecurityLand(XN632926Req req) {
        HttpClient httpClient = new HttpClient();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method",
            "api.socialsecurity.getloginelements"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("areaCode", req.getAreaCode()));
        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    public Object socialSecurity(XN632927Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam
            .add(new BasicNameValuePair("method", "api.socialsecurity.get"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        reqParam.add(new BasicNameValuePair("password", "CiEyMzR3dWxx"));
        reqParam.add(new BasicNameValuePair("area", req.getArea()));
        if (StringUtils.isNotBlank(req.getRealName())) {
            reqParam.add(new BasicNameValuePair("realName", req.getRealName()));
        }
        if (StringUtils.isNotBlank(req.getOtherInfo())) {
            reqParam
                .add(new BasicNameValuePair("otherInfo", req.getOtherInfo()));
        }
        // reqParam.add(new BasicNameValuePair("uid", req.getUid()));
        // reqParam.add(new BasicNameValuePair("identityCardNo",
        // req.getIdentityCardNo()));
        // reqParam.add(new BasicNameValuePair("identityName",
        // req.getIdentityName()));
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("apiUrl") + "/socialsecurity"));// 回调url
        // reqParam.add(new BasicNameValuePair("accessType", ""));// 接入方式
        // 不填写默认api
        // reqParam.add(new BasicNameValuePair("ts", ""));// 时间戳
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    public Object housefundArea(XN632928Req req) {
        HttpClient httpClient = new HttpClient();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam
            .add(new BasicNameValuePair("method", "api.housefund.getareas"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    public Object housefundLand(XN632929Req req) {
        HttpClient httpClient = new HttpClient();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(
            new BasicNameValuePair("method", "api.housefund.getloginelements"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("areaCode", req.getAreaCode()));
        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    public Object housefund(XN632930Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method", "api.housefund.get"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        reqParam.add(new BasicNameValuePair("password", "CiEyMzR3dWxx"));
        reqParam.add(new BasicNameValuePair("area", req.getArea()));
        if (StringUtils.isNotBlank(req.getRealName())) {
            reqParam.add(new BasicNameValuePair("realName", req.getRealName()));
        }
        if (StringUtils.isNotBlank(req.getOtherInfo())) {
            reqParam
                .add(new BasicNameValuePair("otherInfo", req.getOtherInfo()));
        }
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("apiUrl") + ""));// 回调url
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

}
