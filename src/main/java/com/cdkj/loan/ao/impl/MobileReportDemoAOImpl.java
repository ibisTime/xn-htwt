package com.cdkj.loan.ao.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IMobileReportDemoAO;
import com.cdkj.loan.bo.ILimuCreditBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.common.PropertiesUtil;
import com.cdkj.loan.controller.AbstractCredit;
import com.cdkj.loan.creditCommon.HttpClient;
import com.cdkj.loan.creditCommon.StringUtils;
import com.cdkj.loan.domain.LimuCredit;
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
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ELimuCreditStatus;
import com.cdkj.loan.exception.BizException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MobileReportDemoAOImpl implements IMobileReportDemoAO {
    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    private ILimuCreditBO limuCreditBO;

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
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

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
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

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
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

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
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

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
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

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
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam
            .add(new BasicNameValuePair("method", "api.socialsecurity.get"));
        reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        try {
            reqParam.add(new BasicNameValuePair("password",
                new String(Base64.encodeBase64("!234wulq".getBytes("UTF-8")))));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        // try {
        // reqParam.add(new BasicNameValuePair("password", new String(
        // Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
        // } catch (UnsupportedEncodingException e1) {
        // e1.printStackTrace();
        // }
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
            configsMap.get("localhostUrl") + "/socialsecurity"));// 回调url
        // reqParam.add(new BasicNameValuePair("accessType", ""));// 接入方式
        // 不填写默认api
        // reqParam.add(new BasicNameValuePair("ts", ""));// 时间戳
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String post = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        String token = null;
        if (StringUtils.isBlank(post)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "查询失败");
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode;
            try {
                rootNode = objectMapper.readValue(post, JsonNode.class);
                String code = rootNode.get("code").textValue();
                if ("0010".equals(code)) {// 受理成功
                    token = rootNode.get("token").textValue();
                } else {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "查询失败");
                }
                // socialsecurity = socialsecurity(token, "socialsecurity");
                LimuCredit limuCredit = new LimuCredit();
                limuCredit.setBizType("socialsecurity");
                limuCredit.setUserName(req.getUsername());
                limuCredit.setToken(token);
                limuCredit
                    .setStatus(ELimuCreditStatus.PENDING_CALLBACK.getCode());
                limuCredit.setFoundDatetime(new Date());
                limuCreditBO.saveLimuCredit(limuCredit);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return post;
    }

    private String socialsecurity(String token, String bizType) {
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
        try {
            reqParam.add(new BasicNameValuePair("password", new String(
                Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        reqParam.add(new BasicNameValuePair("area", req.getArea()));
        if (StringUtils.isNotBlank(req.getRealName())) {
            reqParam.add(new BasicNameValuePair("realName", req.getRealName()));
        }
        if (StringUtils.isNotBlank(req.getOtherInfo())) {
            reqParam
                .add(new BasicNameValuePair("otherInfo", req.getOtherInfo()));
        }
        // reqParam.add(new BasicNameValuePair("callBackUrl",
        // configsMap.get("apiUrl") + ""));// 回调url
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

        String post = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        String token = null;
        String socialsecurity = null;
        if (StringUtils.isBlank(post)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "查询失败");
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode;
            try {
                rootNode = objectMapper.readValue(post, JsonNode.class);
                String code = rootNode.get("code").textValue();
                if ("0010".equals(code)) {// 受理成功
                    token = rootNode.get("token").textValue();
                } else {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "查询失败");
                }
                socialsecurity = socialsecurity(token, "housefund");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return socialsecurity;
    }

    @Override
    public Object callBackUrl() {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam.add(new BasicNameValuePair("bizType", "socialsecurity"));
        reqParam.add(new BasicNameValuePair("code", "0010"));
        reqParam.add(new BasicNameValuePair("msg", "受理成功"));
        reqParam.add(new BasicNameValuePair("token",
            "6995cc80c2044daeae1864ecd61c8704"));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

        String post = httpClient.doPost("https://t.limuzhengxin.cn/callBackUrl",
            reqParam);
        return post;
    }

    @Override
    public void jdFund(XN632931Req req) {
        // HttpClient httpClient = new HttpClient();
        // AbstractCredit credit = new AbstractCredit();
        // Map<String, String> configsMap = sysConfigBO
        // .getConfigsMap("id_no_authentication");
        // List<BasicNameValuePair> reqParam = new
        // ArrayList<BasicNameValuePair>();
        // reqParam
        // .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        // reqParam.add(new BasicNameValuePair("method", "api.jd.get"));
        // reqParam
        // .add(new BasicNameValuePair("version", configsMap.get("version")));
        // reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        // try {
        // reqParam.add(new BasicNameValuePair("password", new String(
        // Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
        // } catch (UnsupportedEncodingException e) {
        // e.printStackTrace();
        // }
        // reqParam.add(new BasicNameValuePair("sign",
        // credit.getSign(reqParam)));// 请求参数签名
        //
        // String post = httpClient
        // .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // String token = null;
        // String socialsecurity = null;
        // if (StringUtils.isBlank(post)) {
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(), "查询失败");
        // } else {
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode;
        // try {
        // rootNode = objectMapper.readValue(post, JsonNode.class);
        // String code = rootNode.get("code").textValue();
        // if ("0010".equals(code)) {// 受理成功
        // token = rootNode.get("token").textValue();
        // } else {
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
        // "查询失败");
        // }
        // socialsecurity = socialsecurity(token, "jd");
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // }
        // return socialsecurity;

        System.out.println("开始获取京东信息");

        try {

            // 提交受理请求对象
            Map<String, String> configsMap = sysConfigBO
                .getConfigsMap("id_no_authentication");
            List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
            reqParam.add(
                new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
            reqParam.add(new BasicNameValuePair("method", "api.jd.get"));
            reqParam.add(
                new BasicNameValuePair("version", configsMap.get("version")));

            reqParam.add(new BasicNameValuePair("username", req.getUsername()));// 账号
            reqParam.add(new BasicNameValuePair("password", new String(
                Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));// 密码
            // reqParam.add(new BasicNameValuePair("sign",
            // getSign(reqParam)));// 请求参数签名

            // 提交受理请求
            // doProcess(reqParam);

        } catch (Exception ex) {
            System.out.println("开始获取京东信息异常：" + ex);
        }
    }

}
