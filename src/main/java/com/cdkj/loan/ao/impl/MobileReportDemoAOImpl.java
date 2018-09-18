package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdkj.loan.ao.IMobileReportDemoAO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.creditCommon.HttpClient;
import com.cdkj.loan.dto.req.XN630094Req;

import demo.AbstractCredit;

public class MobileReportDemoAOImpl implements IMobileReportDemoAO {
    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Override
    public String authentication(XN630094Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam
            .add(new BasicNameValuePair("method", configsMap.get("method")));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }

}
