package com.cdkj.loan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
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
import com.cdkj.loan.bo.ILimuCreditBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.creditCommon.HttpClient;
import com.cdkj.loan.domain.LimuCredit;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ELimuCreditStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 社保
 * @author: CYL 
 * @since: 2018年9月19日 下午4:30:08 
 * @history:
 */
@Controller
public class SocialsecurityController {

    @Autowired
    private ILimuCreditBO limuCreditBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @RequestMapping(value = "/socialsecurity", method = RequestMethod.POST)
    public void doClockIn(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("lalalla");
        String json = request.getParameter("json").toString();
        String str = URLDecoder.decode(json, "UTF-8");
        JSONObject object = JSONObject.parseObject(str);
        String token = object.getString("token");
        LimuCredit limuCredit = limuCreditBO.getLimuCreditByToken(token);
        String domain = creditFound(token, "socialsecurity");
        if (domain == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "回调结果为空！");
        }
        limuCredit.setStatus(ELimuCreditStatus.ALREADY_CALLBACK.getCode());
        limuCredit.setResult(domain);
        limuCredit.setCallbackDatetime(new Date());
        limuCredit.setUserId(object.getString("userId"));
        limuCreditBO.refreshLimuCredit(limuCredit);

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.append("success");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String creditFound(String token, String bizType) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method", "api.common.getResult"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("token", token));
        reqParam.add(new BasicNameValuePair("bizType", bizType));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        return httpClient.doPost(configsMap.get("apiUrl") + "/api/gateway",
            reqParam);
    }
}
