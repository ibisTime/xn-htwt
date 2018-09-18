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
import com.cdkj.loan.creditCommon.HttpClient;
import com.cdkj.loan.dto.req.XN632920Req;
import com.cdkj.loan.dto.req.XN632921Req;
import com.cdkj.loan.dto.req.XN632922Req;
import com.cdkj.loan.dto.req.XN632923Req;
import com.cdkj.loan.dto.req.XN632924Req;
import com.cdkj.loan.dto.req.XN632925Req;

import demo.AbstractCredit;

@Service
public class MobileReportDemoAOImpl implements IMobileReportDemoAO {
    @Autowired
    private ISYSConfigBO sysConfigBO;

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
    public Object mobileAuthentication(XN632921Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam
            .add(new BasicNameValuePair("method", "api.identity.mobilecheck"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("mobileNo", req.getMobileNo()));
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

    @Override
    @Transactional
    public Object bankCardNo3Authentication(XN632922Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(
            new BasicNameValuePair("method", "api.identity.bankcard3check"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("bankCardNo", req.getBankCardNo()));
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
    public Object faceRecognition(XN632925Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam
            .add(new BasicNameValuePair("method", "api.identity.idfacecheck"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("idCard", req.getIdCard()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("photo", req.getPhoto()));
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

}
