package com.cdkj.loan.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

        Map<Object, Object> map = request.getParameterMap();

        String[] token = (String[]) map.get("token");
        String[] bizType = (String[]) map.get("bizType");
        String[] uid = (String[]) map.get("uid");

        System.out.println("token:" + token[0]);

        // System.out.println(
        // "token:" + token[0] + ",bizType:" + bizType[0] + ",uid:" + uid[0]);

        LimuCredit limuCredit = limuCreditBO.getLimuCreditByToken(token[0]);
        if (limuCredit == null) {
            System.out.println("查询结果为空！");
        }
        System.out.println("limuCredit:" + limuCredit);
        String domain = creditFound(token[0], bizType[0]);
        System.out.println("domain:" + domain);
        if (domain == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "回调结果为空！");
        }
        limuCredit.setStatus(ELimuCreditStatus.ALREADY_CALLBACK.getCode());
        limuCredit.setResult(domain);
        limuCredit.setCallbackDatetime(new Date());
        limuCredit.setUserId(uid[0]);
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

    public String creditFound(String token, String bizType) {
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
