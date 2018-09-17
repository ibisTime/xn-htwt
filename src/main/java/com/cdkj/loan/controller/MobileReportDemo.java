package com.cdkj.loan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.bo.ISYSConfigBO;

@Controller
public class MobileReportDemo {
    // private static Logger logger = Logger.getLogger(MobileReportDemo.class);

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public void doClockIn(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        AbstractCredit credit = new AbstractCredit();
        String json = request.getParameter("json").toString();
        String str = URLDecoder.decode(json, "UTF-8");
        JSONObject object = JSONObject.parseObject(str);
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam
            .add(new BasicNameValuePair("method", configsMap.get("method")));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        String identityNo = object.getString("identityNo");
        reqParam.add(new BasicNameValuePair("identityNo", identityNo));
        String name = object.getString("name");
        reqParam.add(new BasicNameValuePair("name", name));
        reqParam.add(new BasicNameValuePair("sign", credit.getSign(reqParam)));// 请求参数签名

        PrintWriter writer;
        try {
            writer = response.getWriter();
            writer.append(credit.doProcess(reqParam));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
