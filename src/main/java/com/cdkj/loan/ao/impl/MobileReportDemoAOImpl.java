package com.cdkj.loan.ao.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.ao.IMobileReportDemoAO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.ILimuCreditBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.common.PropertiesUtil;
import com.cdkj.loan.controller.AbstractCredit;
import com.cdkj.loan.core.StringValidater;
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
import com.cdkj.loan.dto.req.XN632944Req;
import com.cdkj.loan.dto.req.XN632945Req;
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

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    public static final String LMZX_URL = PropertiesUtil.Config.LMZX_URL;

    @Override
    public Object authentication(XN632920Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        HashMap<String, String> map = new HashMap<String, String>();
        String id = "-1";
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
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        if (!"0000".equals(code)) {
            map.put("id", id);
            map.put("result", doPost);
            return map;
        }
        LimuCredit data = limuCreditBO.getLimuCreditByUid(req.getIdentityNo(),
            "identity");
        if (data != null) {
            data.setCustomerName(req.getName());
            data.setStatus(ELimuCreditStatus.ALREADY_CALLBACK.getCode());
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
            id = data.getId() + "";
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserId(req.getIdentityNo());
            limuCredit.setUserName(req.getIdentityNo());
            limuCredit.setCustomerName(req.getName());
            limuCredit.setStatus(ELimuCreditStatus.ALREADY_CALLBACK.getCode());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("identity");
            limuCreditBO.saveLimuCredit(limuCredit);
            LimuCredit lmCredit = limuCreditBO
                .getLimuCreditByUid(req.getIdentityNo(), "identity");
            id = lmCredit.getId() + "";
        }
        // 更新app端用户身份证
        if (StringUtils.isNotBlank(req.getUserId())) {
            userBO.refreshIdNo(req.getUserId(), req.getIdentityNo(),
                req.getName());
        }
        // map.put("\"id\":" + id, "\"result\":" + doPost);
        map.put("id", id);
        map.put("result", doPost);
        return map;
    }

    @Override
    public Object involvedList(XN632921Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        HashMap<String, String> map = new HashMap<String, String>();
        String id = "-1";
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
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        if (!"0000".equals(code)) {
            map.put("id", id);
            map.put("result", doPost);
            return map;
        }
        LimuCredit data = limuCreditBO
            .getLimuCreditByUserName(req.getIdentityNo(), "involvedlistcheck");
        if (data != null) {
            data.setCustomerName(req.getCustomerName());
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
            id = data.getId() + "";
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserId(req.getIdentityNo());
            limuCredit.setUserName(req.getIdentityNo());
            limuCredit.setCustomerName(req.getCustomerName());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("involvedlistcheck");
            limuCreditBO.saveLimuCredit(limuCredit);
            LimuCredit lmCredit = limuCreditBO
                .getLimuCreditByUid(req.getIdentityNo(), "involvedlistcheck");
            id = lmCredit.getId() + "";
        }
        map.put("id", id);
        map.put("result", doPost);
        return map;
    }

    @Override
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
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        if (!"0000".equals(code)) {
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
            limuCredit.setUserId(req.getIdentityNo());
            limuCredit.setUserName(req.getIdentityNo());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("involveddetailscheck");
            limuCreditBO.saveLimuCredit(limuCredit);
        }
        return doPost;
    }

    @Override
    public Object bankCardNo4Authentication(XN632923Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        HashMap<String, String> map = new HashMap<String, String>();
        String id = "-1";
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
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        if (!"0000".equals(code)) {
            map.put("id", id);
            map.put("result", doPost);
            return map;
        }
        LimuCredit data = limuCreditBO.getLimuCreditByUid(req.getIdentityNo(),
            "bankcard4check");
        if (data != null) {
            data.setCustomerName(req.getCustomerName());
            data.setStatus(ELimuCreditStatus.ALREADY_CALLBACK.getCode());
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
            id = data.getId() + "";
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserId(req.getIdentityNo());
            limuCredit.setUserName(req.getBankCardNo());
            limuCredit.setCustomerName(req.getCustomerName());
            limuCredit.setStatus(ELimuCreditStatus.ALREADY_CALLBACK.getCode());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("bankcard4check");
            limuCreditBO.saveLimuCredit(limuCredit);
            LimuCredit lmCredit = limuCreditBO
                .getLimuCreditByUid(req.getIdentityNo(), "bankcard4check");
            id = lmCredit.getId() + "";
        }
        map.put("id", id);
        map.put("result", doPost);
        return map;
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
        reqParam.add(new BasicNameValuePair("method", "api.shixin.get"));
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("localhostUrl") + "/socialsecurity"));// 回调url
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("name", req.getName()));
        reqParam.add(new BasicNameValuePair("uid", req.getIdentityNo()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取code,如果不成功，不用保存
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        if (!"0010".equals(code)) {
            return rootNode.get("data").textValue();
        }
        LimuCredit data = limuCreditBO.getLimuCreditByUid(req.getIdentityNo(),
            "shixin");
        if (data != null) {
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserId(req.getIdentityNo());
            limuCredit.setUserName(req.getIdentityNo());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("shixin");
            limuCreditBO.saveLimuCredit(limuCredit);
        }
        // 截取data
        // String joData = rootNode.get("data").textValue();
        return doPost;
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
        if (StringUtils.isBlank(req.getIdNo())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "请先进行身份证实名认证！");
        }
        reqParam.add(new BasicNameValuePair("uid", req.getIdNo()));
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
                    return post;
                }
                LimuCredit limuCredit = limuCreditBO
                    .getLimuCreditByUid(req.getIdNo(), "socialsecurity");
                if (limuCredit == null) {
                    LimuCredit data = new LimuCredit();
                    data.setBizType("socialsecurity");
                    data.setUserName(req.getUsername());
                    data.setCustomerName(req.getCustomerName());
                    data.setUserId(req.getIdNo());
                    data.setToken(token);
                    data.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    data.setFoundDatetime(new Date());
                    limuCreditBO.saveLimuCredit(data);
                } else {
                    limuCredit.setUserId(req.getIdNo());
                    limuCredit.setCustomerName(req.getCustomerName());
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
    public Object socialsecurity(String token, String bizType) {
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
        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取data
        JSONObject parseObject = JSONObject.parseObject(doPost);
        JSONArray jsonArray = parseObject.getJSONArray("data");
        return jsonArray;
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
        if (StringUtils.isBlank(req.getIdNo())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "请先进行身份证实名认证！");
        }
        reqParam.add(new BasicNameValuePair("uid", req.getIdNo()));
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
                    .getLimuCreditByUid(req.getIdNo(), "housefund");
                if (limuCredit == null) {
                    LimuCredit data = new LimuCredit();
                    data.setBizType("housefund");
                    data.setUserName(req.getUsername());
                    data.setUserId(req.getIdNo());
                    data.setCustomerName(req.getCustomerName());
                    data.setToken(token);
                    data.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    data.setFoundDatetime(new Date());
                    limuCreditBO.saveLimuCredit(data);
                } else {
                    limuCredit.setUserId(req.getIdNo());
                    limuCredit.setCustomerName(req.getCustomerName());
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
    public Object jdFund(XN632931Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        HashMap<String, String> map = new HashMap<String, String>();
        String id = "-1";

        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method", "api.jd.get"));
        if (StringUtils.isBlank(req.getIdNo())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "请先进行身份证实名认证！");
        }
        reqParam.add(new BasicNameValuePair("uid", req.getIdNo()));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("loginType", req.getLoginType()));
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
                    map.put("id", id);
                    map.put("result", post);
                    return map;
                }

                LimuCredit limuCredit = limuCreditBO
                    .getLimuCreditByUid(req.getIdNo(), "jd");
                if (limuCredit == null) {
                    LimuCredit data = new LimuCredit();
                    data.setBizType("jd");
                    data.setUserId(req.getIdNo());
                    data.setCustomerName(req.getCustomerName());
                    data.setToken(token);
                    data.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    data.setFoundDatetime(new Date());
                    limuCreditBO.saveLimuCredit(data);
                    LimuCredit lmCredit = limuCreditBO
                        .getLimuCreditByToken(token, "jd");
                    id = lmCredit.getId() + "";
                } else {
                    limuCredit.setCustomerName(req.getCustomerName());
                    limuCredit.setToken(token);
                    limuCredit.setStatus(
                        ELimuCreditStatus.PENDING_CALLBACK.getCode());
                    limuCredit.setFoundDatetime(new Date());
                    limuCreditBO.refreshLimuCredit(limuCredit);
                    id = limuCredit.getId() + "";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("id", id);
        map.put("result", post);
        return map;
    }

    @Override
    public Object taobaoFund(XN632932Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();

        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method", "api.taobao.get"));
        if (StringUtils.isBlank(req.getIdNo())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "请先进行身份证实名认证！");
        }
        reqParam.add(new BasicNameValuePair("uid", req.getIdNo()));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        // reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        // try {
        // reqParam.add(new BasicNameValuePair("password", new String(
        // Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
        // } catch (UnsupportedEncodingException e) {
        // e.printStackTrace();
        // }
        reqParam.add(new BasicNameValuePair("loginType", req.getLoginType()));
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("localhostUrl") + "/socialsecurity"));// 回调url
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名

        String post = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        String token = null;
        if (StringUtils.isBlank(post)) {
            return "查询结果为空！";
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode;
            try {
                rootNode = objectMapper.readValue(post, JsonNode.class);
                String code = rootNode.get("code").textValue();
                if ("0010".equals(code)) {// 受理成功
                    token = rootNode.get("token").textValue();
                    LimuCredit limuCredit = limuCreditBO
                        .getLimuCreditByUid(req.getIdNo(), "taobao");
                    if (limuCredit == null) {
                        LimuCredit data = new LimuCredit();
                        data.setBizType("taobao");
                        data.setUserId(req.getIdNo());
                        data.setCustomerName(req.getCustomerName());
                        data.setToken(token);
                        data.setStatus(
                            ELimuCreditStatus.PENDING_CALLBACK.getCode());
                        data.setFoundDatetime(new Date());
                        limuCreditBO.saveLimuCredit(data);
                    } else {
                        limuCredit.setCustomerName(req.getCustomerName());
                        limuCredit.setToken(token);
                        limuCredit.setStatus(
                            ELimuCreditStatus.PENDING_CALLBACK.getCode());
                        limuCredit.setFoundDatetime(new Date());
                        limuCreditBO.refreshLimuCredit(limuCredit);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return post;
    }

    @Override
    public Object taobaoFundStatus(XN632944Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();

        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method", "api.common.getStatus"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("localhostUrl") + "/socialsecurity"));// 回调url
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        reqParam.add(new BasicNameValuePair("token", req.getTokendb()));
        // reqParam.add(new BasicNameValuePair("bizType", "taobao"));
        reqParam.add(new BasicNameValuePair("bizType", req.getBizType()));

        String post = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        if (StringUtils.isBlank(post)) {
            return "查询结果为空！";
        }
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode;
        // String input = null;
        // try {
        // rootNode = objectMapper.readValue(post, JsonNode.class);
        // input = rootNode.get("input").textValue();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
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
        HashMap<String, String> map = new HashMap<String, String>();
        String id = "-1";
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(
            new BasicNameValuePair("identityCardNo", req.getIdentityCardNo()));
        reqParam
            .add(new BasicNameValuePair("identityName", req.getIdentityName()));
        reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        try {
            reqParam.add(new BasicNameValuePair("password", new String(
                Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (StringUtils.isNotBlank(req.getContactIdentityNo1st())) {
            reqParam.add(new BasicNameValuePair("contactIdentityNo1st",
                req.getContactIdentityNo1st()));
        }
        if (StringUtils.isNotBlank(req.getContactIdentityNo2nd())) {
            reqParam.add(new BasicNameValuePair("contactIdentityNo2nd",
                req.getContactIdentityNo2nd()));
        }
        if (StringUtils.isNotBlank(req.getContactIdentityNo3rd())) {
            reqParam.add(new BasicNameValuePair("contactIdentityNo3rd",
                req.getContactIdentityNo3rd()));
        }
        if (StringUtils.isNotBlank(req.getContactMobile1st())) {
            reqParam.add(new BasicNameValuePair("contactMobile1st",
                req.getContactMobile1st()));
        }
        if (StringUtils.isNotBlank(req.getContactMobile2nd())) {
            reqParam.add(new BasicNameValuePair("contactMobile2nd",
                req.getContactMobile2nd()));
        }
        if (StringUtils.isNotBlank(req.getContactMobile3rd())) {
            reqParam.add(new BasicNameValuePair("contactMobile3rd",
                req.getContactMobile3rd()));
        }
        if (StringUtils.isNotBlank(req.getContactName1st())) {
            reqParam.add(new BasicNameValuePair("contactName1st",
                req.getContactName1st()));
        }
        if (StringUtils.isNotBlank(req.getContactName2nd())) {
            reqParam.add(new BasicNameValuePair("contactName2nd",
                req.getContactName2nd()));
        }
        if (StringUtils.isNotBlank(req.getContactName3rd())) {
            reqParam.add(new BasicNameValuePair("contactName3rd",
                req.getContactName3rd()));
        }
        if (StringUtils.isNotBlank(req.getContactRelationship1st())) {
            reqParam.add(new BasicNameValuePair("contactRelationship1st",
                req.getContactRelationship1st()));
        }
        if (StringUtils.isNotBlank(req.getContactRelationship2nd())) {
            reqParam.add(new BasicNameValuePair("contactRelationship2nd",
                req.getContactRelationship2nd()));
        }
        if (StringUtils.isNotBlank(req.getContactRelationship3rd())) {
            reqParam.add(new BasicNameValuePair("contactRelationship3rd",
                req.getContactRelationship3rd()));
        }
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task", reqParam);
        LimuCredit data = limuCreditBO
            .getLimuCreditByUid(req.getIdentityCardNo(), "mobileReportTask");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        if (!"0010".equals(code)) {
            map.put("id", id);
            map.put("result", doPost);
            return map;
        }
        String token = rootNode.get("token").textValue();
        if (data != null) {
            data.setCustomerName(req.getIdentityName());
            data.setToken(token);
            data.setStatus(ELimuCreditStatus.PENDING_CALLBACK.getCode());
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
            id = data.getId() + "";
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserId(req.getIdentityCardNo());
            limuCredit.setUserName(req.getUsername());
            limuCredit.setCustomerName(req.getIdentityName());
            limuCredit.setToken(token);
            limuCredit.setStatus(ELimuCreditStatus.PENDING_CALLBACK.getCode());
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("mobileReportTask");
            limuCreditBO.saveLimuCredit(limuCredit);
            limuCredit.setBizType("mobileReportTaskData");
            limuCreditBO.saveLimuCredit(limuCredit);
            LimuCredit lmCredit = limuCreditBO.getLimuCreditByToken(token,
                "mobileReportTask");
            id = lmCredit.getId() + "";
        }
        map.put("id", id);
        map.put("result", doPost);
        return map;
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
        reqParam.add(new BasicNameValuePair("token", req.getTokendb()));
        reqParam.add(new BasicNameValuePair("input", req.getInput()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task/input",
            reqParam);
        // 截取code,如果不成功，不用保存
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        if (!"0000".equals(code)) {
            return doPost;
        }
        String post = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task/report",
            reqParam);
        // 截取code,如果不成功，不用保存
        try {
            rootNode = objectMapper.readValue(post, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsCode = rootNode.get("code").textValue();
        if (!"0000".equals(jsCode)) {
            return doPost;
        }
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getTokendb(),
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
        reqParam.add(new BasicNameValuePair("token", req.getTokendb()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/mobile_report/v1/task/report",
            reqParam);
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getTokendb(),
            "mobileReportTask");
        if (data != null) {
            data.setResult(doPost);
            data.setStatus(ELimuCreditStatus.ALREADY_CALLBACK.getCode());
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
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        if (!"0000".equals(code)) {
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
        HashMap<String, String> map = new HashMap<String, String>();
        String id = "-1";
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
        reqParam.add(new BasicNameValuePair("uid", req.getIdentityCardNo()));
        reqParam.add(new BasicNameValuePair("callBackUrl",
            configsMap.get("localhostUrl") + "/socialsecurity"));// 回调url
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task", reqParam);
        // 截取code,如果不成功，不用保存
        // JSONObject parseObject = JSONObject.parseObject(doPost);
        // JSONObject jsonObject = parseObject.getJSONObject("code");

        LimuCredit data = limuCreditBO
            .getLimuCreditByUid(req.getIdentityCardNo(), "taobao_report");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        if (!"0010".equals(code)) {
            map.put("id", id);
            map.put("result", doPost);
            return map;
        }
        String token = rootNode.get("token").textValue();
        if (data != null) {
            data.setCustomerName(req.getIdentityName());
            data.setToken(token);
            data.setStatus(ELimuCreditStatus.PENDING_CALLBACK.getCode());
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
            id = data.getId() + "";
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserName(req.getUsername());
            limuCredit.setCustomerName(req.getIdentityName());
            limuCredit.setToken(token);
            limuCredit.setStatus(ELimuCreditStatus.PENDING_CALLBACK.getCode());
            String uid = req.getIdentityCardNo();
            limuCredit.setUserId(uid);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("taobao_report");
            limuCreditBO.saveLimuCredit(limuCredit);
            limuCredit.setBizType("taobaoReportTaskData");
            limuCreditBO.saveLimuCredit(limuCredit);
            LimuCredit lmCredit = limuCreditBO.getLimuCreditByToken(token,
                "taobao_report");
            id = lmCredit.getId() + "";
        }
        map.put("id", id);
        map.put("result", doPost);
        return map;
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
            "taobao_report");
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
        reqParam.add(new BasicNameValuePair("token", req.getTokendb()));
        reqParam.add(new BasicNameValuePair("input", req.getInput()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task/input",
            reqParam);
        String post = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task/report",
            reqParam);
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getTokendb(),
            "taobao_report");
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
        reqParam.add(new BasicNameValuePair("token", req.getTokendb()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient.doPost(
            configsMap.get("apiUrl") + "/taobao_report/v1/task/report",
            reqParam);
        LimuCredit data = limuCreditBO.getLimuCreditByToken(req.getTokendb(),
            "taobao_report");
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

    @Override
    public Object carInsurance(XN632945Req req) {
        HttpClient httpClient = new HttpClient();
        AbstractCredit credit = new AbstractCredit();
        HashMap<String, String> map = new HashMap<String, String>();
        String id = "-1";
        Map<String, String> configsMap = sysConfigBO
            .getConfigsMap("id_no_authentication");
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam
            .add(new BasicNameValuePair("apiKey", configsMap.get("apiKey")));
        reqParam.add(new BasicNameValuePair("method", "api.autoinsurance.get"));
        reqParam
            .add(new BasicNameValuePair("version", configsMap.get("version")));
        if (StringUtils.isNotBlank(req.getUsername())) {
            reqParam.add(new BasicNameValuePair("username", req.getUsername()));
        }
        if (StringUtils.isNotBlank(req.getPassword())) {
            try {
                reqParam.add(new BasicNameValuePair("password", new String(
                    Base64.encodeBase64(req.getPassword().getBytes("UTF-8")))));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(req.getPolicyNo())) {
            reqParam.add(new BasicNameValuePair("policyNo", req.getPolicyNo()));
        }
        if (StringUtils.isNotBlank(req.getIdentityNo())) {
            reqParam
                .add(new BasicNameValuePair("identityNo", req.getIdentityNo()));
        }
        reqParam.add(new BasicNameValuePair("type", req.getType()));
        reqParam.add(new BasicNameValuePair("insuranceCompany",
            req.getInsuranceCompany()));
        reqParam.add(new BasicNameValuePair("sign",
            credit.getSign(reqParam, configsMap.get("apiSecret"))));// 请求参数签名
        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        // 截取code,如果不成功，不用保存
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readValue(doPost, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = rootNode.get("code").textValue();
        String token = rootNode.get("token").textValue();
        if (!"0010".equals(code)) {
            map.put("id", id);
            map.put("result", doPost);
            return map;
        }
        LimuCredit data = limuCreditBO.getLimuCreditByUid(req.getIdentityNo(),
            "autoinsurance");
        if (data != null) {
            data.setCustomerName(req.getCustomerName());
            data.setStatus(ELimuCreditStatus.PENDING_CALLBACK.getCode());
            data.setResult(doPost);
            data.setFoundDatetime(new Date());
            limuCreditBO.refreshLimuCredit(data);
            id = data.getId() + "";
        } else {
            LimuCredit limuCredit = new LimuCredit();
            limuCredit.setUserId(req.getIdentityNo());
            limuCredit.setUserName(req.getIdentityNo());
            limuCredit.setCustomerName(req.getCustomerName());
            limuCredit.setStatus(ELimuCreditStatus.PENDING_CALLBACK.getCode());
            limuCredit.setResult(doPost);
            limuCredit.setFoundDatetime(new Date());
            limuCredit.setBizType("autoinsurance");
            limuCreditBO.saveLimuCredit(limuCredit);
            LimuCredit lmCredit = limuCreditBO
                .getLimuCreditByUid(req.getIdentityNo(), "autoinsurance");
            id = lmCredit.getId() + "";
        }

        // 查询结果
        foundResult(reqParam, token, configsMap, id);

        // map.put("\"id\":" + id, "\"result\":" + doPost);
        map.put("id", id);
        map.put("result", doPost);
        return map;
    }

    private void foundResult(List<BasicNameValuePair> reqParam, String token,
            Map<String, String> configsMap, String id) {
        HttpClient httpClient = new HttpClient();
        reqParam.add(new BasicNameValuePair("method", "api.common.getResult"));
        reqParam.add(new BasicNameValuePair("type", token));
        String doPost = httpClient
            .doPost(configsMap.get("apiUrl") + "/api/gateway", reqParam);
        LimuCredit limuCredit = limuCreditBO
            .getLimuCredit(StringValidater.toInteger(id));
        limuCredit.setResult(doPost);
        limuCreditBO.refreshLimuCredit(limuCredit);
    }
}
