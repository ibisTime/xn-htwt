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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.ao.IMobileReportDemoAO;
import com.cdkj.loan.bo.ILimuCreditBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.common.PropertiesUtil;
import com.cdkj.loan.controller.AbstractCredit;
import com.cdkj.loan.core.OrderNoGenerater;
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
import com.cdkj.loan.dto.req.XN632932Req;
import com.cdkj.loan.dto.req.XN632933Req;
import com.cdkj.loan.dto.req.XN632934Req;
import com.cdkj.loan.dto.req.XN632936Req;
import com.cdkj.loan.dto.req.XN632937Req;
import com.cdkj.loan.dto.req.XN632938Req;
import com.cdkj.loan.dto.req.XN632939Req;
import com.cdkj.loan.dto.req.XN632941Req;
import com.cdkj.loan.dto.req.XN632942Req;
import com.cdkj.loan.dto.req.XN632943Req;
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
        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONObject jsonObject = parseObject.getJSONObject("code");
        if (!"0000".equals(jsonObject)) {
            return doPost;
        }
        LimuCredit data = limuCreditBO
            .getLimuCreditByUserName(req.getIdentityNo(), "identity");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserName(req.getIdentityNo());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("identity");
            limuCreditBO.saveLimuCredit(limuCredit);
        }
        return doPost;
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
        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONObject jsonObject = parseObject.getJSONObject("code");
        if (!"0000".equals(jsonObject)) {
            return doPost;
        }
        LimuCredit data = limuCreditBO
            .getLimuCreditByUserName(req.getIdentityNo(), "involvedlistcheck");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserName(req.getIdentityNo());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("involvedlistcheck");
            limuCreditBO.saveLimuCredit(limuCredit);
        }
        return doPost;
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

        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONObject jsonObject = parseObject.getJSONObject("code");
        if (!"0000".equals(jsonObject)) {
            return doPost;
        }
        LimuCredit data = limuCreditBO.getLimuCreditByUserName(
            req.getIdentityNo(), "involveddetailscheck");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserName(req.getIdentityNo());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("involveddetailscheck");
            limuCreditBO.saveLimuCredit(limuCredit);
        }
        return doPost;
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

        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONObject jsonObject = parseObject.getJSONObject("code");
        if (!"0000".equals(jsonObject)) {
            return doPost;
        }
        LimuCredit data = limuCreditBO
            .getLimuCreditByUserName(req.getIdentityNo(), "bankcard4check");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserName(req.getBankCardNo());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("bankcard4check");
            limuCreditBO.saveLimuCredit(limuCredit);
        }
        return doPost;
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

        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONObject jsonObject = parseObject.getJSONObject("code");
        if (!"0000".equals(jsonObject)) {
            return parseObject.getJSONObject("data");
        }
        LimuCredit data = limuCreditBO
            .getLimuCreditByUserName(req.getIdentityNo(), "shixincheck");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserName(req.getIdentityNo());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("shixincheck");
            limuCreditBO.saveLimuCredit(limuCredit);
        }
        // 截取data
        JSONObject joData = parseObject.getJSONObject("data");
        return joData;
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
        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取data
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONArray jsonArray = parseObject.getJSONArray("data");
        return jsonArray;
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
        String userId = OrderNoGenerater.generate("U");
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
        reqParam.add(new BasicNameValuePair("uid", userId));
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
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("localhostUrl") + "/socialsecurity"));// 回调url
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

        String post = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取code,如果不成功，不用保存
        // JSONObject parseObject = JSONObject.parseObject(post);
        // JSONObject jsonObject = parseObject.getJSONObject("code");
        // if (!"0000".equals(jsonObject)) {
        // return post;
        // }
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
                LimuCredit limuCredit = limuCreditBO.getLimuCreditByUserName(
                    req.getUsername(), "socialsecurity");
                if (limuCredit == null) {
                    LimuCredit data = new LimuCredit();
                    data.setBizType("socialsecurity");
                    data.setUserName(req.getUsername());
                    data.setUserId(userId);
                    data.setToken(token);
                    data.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    data.setFoundDatetime(new Date());
                    limuCreditBO.saveLimuCredit(data);
                } else {
                    limuCredit.setUserId(userId);
                    limuCredit.setToken(token);
                    limuCredit.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    limuCredit.setFoundDatetime(new Date());
                    limuCreditBO.refreshLimuCredit(limuCredit);
                }
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
        String userId = OrderNoGenerater.generate("U");
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
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("localhostUrl") + "/socialsecurity"));// 回调url
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
                LimuCredit limuCredit = limuCreditBO
                    .getLimuCreditByUserName(req.getUsername(), "housefund");
                if (limuCredit == null) {
                    LimuCredit data = new LimuCredit();
                    data.setBizType("housefund");
                    data.setUserName(req.getUsername());
                    data.setUserId(userId);
                    data.setToken(token);
                    data.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    data.setFoundDatetime(new Date());
                    limuCreditBO.saveLimuCredit(data);
                } else {
                    limuCredit.setUserId(userId);
                    limuCredit.setToken(token);
                    limuCredit.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    limuCredit.setFoundDatetime(new Date());
                    limuCreditBO.refreshLimuCredit(limuCredit);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return post;
    }

    @Override
    public String jdFund(XN632931Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();

        String userId = OrderNoGenerater.generate("U");
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method", "api.jd.get"));
        reqParam.add(new BasicNameValuePair("uid", userId));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        try {
            reqParam.add(new BasicNameValuePair("password", new String(
                Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("localhostUrl") + "/socialsecurity"));// 回调url
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

                LimuCredit limuCredit = limuCreditBO
                    .getLimuCreditByUserName(req.getUsername(), "jd");
                if (limuCredit == null) {
                    LimuCredit data = new LimuCredit();
                    data.setBizType("jd");
                    data.setUserName(req.getUsername());
                    data.setUserId(userId);
                    data.setToken(token);
                    data.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    data.setFoundDatetime(new Date());
                    limuCreditBO.saveLimuCredit(data);
                } else {
                    limuCredit.setUserId(userId);
                    limuCredit.setToken(token);
                    limuCredit.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    limuCredit.setFoundDatetime(new Date());
                    limuCreditBO.refreshLimuCredit(limuCredit);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return post;
    }

    @Override
    public Object taobaoFund(XN632932Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();

        String userId = OrderNoGenerater.generate("U");
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method", "api.taobao.get"));
        reqParam.add(new BasicNameValuePair("uid", userId));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        try {
            reqParam.add(new BasicNameValuePair("password", new String(
                Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("localhostUrl") + "/socialsecurity"));// 回调url
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
                LimuCredit limuCredit = limuCreditBO
                    .getLimuCreditByUserName(req.getUsername(), "taobao");
                if (limuCredit == null) {
                    LimuCredit data = new LimuCredit();
                    data.setBizType("taobao");
                    data.setUserName(req.getUsername());
                    data.setUserId(userId);
                    data.setToken(token);
                    data.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    data.setFoundDatetime(new Date());
                    limuCreditBO.saveLimuCredit(data);
                } else {
                    limuCredit.setUserId(userId);
                    limuCredit.setToken(token);
                    limuCredit.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    limuCredit.setFoundDatetime(new Date());
                    limuCreditBO.refreshLimuCredit(limuCredit);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return post;
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
    public Object mobileLocation(XN632933Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("method", "api.mobile.area"));
        reqParam.add(new BasicNameValuePair("mobileNo", req.getMobileNo()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        // String doPost = httpClient.doPost(
        // configsMap.get("apiUrl") + "/mobile/v1/location", reqParam);
        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        return doPost;
    }

    @Override
    public Object mobileReportTask(XN632934Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(
            new BasicNameValuePair("identityCardNo", req.getIdentityCardNo()));
        reqParam
            .add(new BasicNameValuePair("identityName", req.getIdentityName()));
        reqParam.add(new BasicNameValuePair("bankcard", req.getBankcard()));
        reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        try {
            reqParam.add(new BasicNameValuePair("password", new String(
                Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task", reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONObject jsonObject = parseObject.getJSONObject("code");
        if (!"0010".equals(jsonObject)) {
            return doPost;
        }
        LimuCredit data = limuCreditBO
            .getLimuCreditByUserName(req.getUsername(), "mobileReportTask");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String token = rootNode.get("token").textValue();
        if (data != null) {
            data.setToken(token);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserName(req.getUsername());
            limuCredit.setToken(token);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("mobileReportTask");
            limuCreditBO.saveLimuCredit(limuCredit);
            limuCredit.setBizType("mobileReportTaskData");
            limuCreditBO.saveLimuCredit(limuCredit);
        }
        return doPost;
    }

    @Override
    public Object mobileReportTaskStatus(String token) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("token", token));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task/status",
            reqParam);
        LimuCredit data = limuCreditBO.getLimuCreditByToken(token,
            "mobileReportTask");
        if (data == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据token查询的运营商数据不存在！");
        }
        return doPost;
    }

    @Override
    public Object mobileReportTaskInput(XN632936Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("token", req.getToken()));
        reqParam.add(new BasicNameValuePair("input", req.getInput()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task/input",
            reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONObject jsonObject = parseObject.getJSONObject("code");
        if (!"0000".equals(jsonObject)) {
            return doPost;
        }
        String post = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task/report",
            reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject jsPost = JSONObject.parseObject(post);
        JSONObject jsCode = jsPost.getJSONObject("code");
        if (!"0000".equals(jsCode)) {
            return doPost;
        }
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getToken(),
            "mobileReportTask");
        if (data != null) {
            data.setResult(post);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "token不存在！");
        }
        return doPost;
    }

    @Override
    public Object mobileReportTaskReport(XN632937Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("token", req.getToken()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task/report",
            reqParam);
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getToken(),
            "mobileReportTask");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "token不存在！");
        }
        return doPost;
    }

    @Override
    public Object mobileReportTaskData(XN632938Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("token", req.getToken()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task/data", reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONObject jsonObject = parseObject.getJSONObject("code");
        if (!"0000".equals(jsonObject)) {
            return doPost;
        }
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getToken(),
            "mobileReportTaskData");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据token查询的运营商数据不存在！");
        }
        return doPost;
    }

    @Override
    public Object taobaoReportTask(XN632939Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(
            new BasicNameValuePair("identityCardNo", req.getIdentityCardNo()));
        reqParam
            .add(new BasicNameValuePair("identityName", req.getIdentityName()));
        reqParam.add(new BasicNameValuePair("loginType", req.getLoginType()));
        reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        try {
            reqParam.add(new BasicNameValuePair("password", new String(
                Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task", reqParam);
        // 截取code,如果不成功，不用保存
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONObject jsonObject = parseObject.getJSONObject("code");
        if (!"0010".equals(jsonObject)) {
            return doPost;
        }
        LimuCredit data = limuCreditBO
            .getLimuCreditByUserName(req.getUsername(), "taobaoReportTask");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String token = rootNode.get("token").textValue();
        if (data != null) {
            data.setToken(token);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserName(req.getUsername());
            limuCredit.setToken(token);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("taobaoReportTask");
            limuCreditBO.saveLimuCredit(limuCredit);
            limuCredit.setBizType("taobaoReportTaskData");
            limuCreditBO.saveLimuCredit(limuCredit);
        }
        return doPost;
    }

    @Override
    public Object taobaoReportTaskStatus(String token) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("token", token));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task/status",
            reqParam);
        LimuCredit data = limuCreditBO.getLimuCreditByToken(token,
            "taobaoReportTask");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据token查询的运营商数据不存在！");
        }
        return doPost;
    }

    @Override
    public Object taobaoReportTaskInput(XN632941Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("token", req.getToken()));
        reqParam.add(new BasicNameValuePair("input", req.getInput()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task/input",
            reqParam);
        String post = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task/report",
            reqParam);
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getToken(),
            "taobaoReportTask");
        if (data != null) {
            data.setResult(post);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "token不存在！");
        }
        return doPost;
    }

    @Override
    public Object taobaoReportTaskReport(XN632942Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("token", req.getToken()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task/report",
            reqParam);
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getToken(),
            "taobaoReportTaskData");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据token查询的运营商数据不存在！");
        }
        return doPost;
    }

    @Override
    public Object taobaoReportTaskData(XN632943Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("token", req.getToken()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task/data", reqParam);
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getToken(),
            "taobaoReportTaskData");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "根据token查询的运营商数据不存在！");
        }
        return doPost;
    }
}
