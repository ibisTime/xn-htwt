package com.cdkj.loan.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.message.BasicNameValuePair;

/**
 * @Description:运营商
 * @author kx
 * @version v1.2.0
 */
public class MobileDemo extends AbstractCredit {

    // 业务参数
    public static final String method = "api.mobile.get";// 请求接口

    public static final String bizType = "mobile";// 业务类型

    public static final String callBackUrl = "";// 回调地址

    public static final String username = "17611591955";// 账号---需客户指定

    public static final String password = "yl950821.";// 密码---需客户指定

    public static final String contentType = "all";// 内容类型---需客户指定

    public static void main(String[] args) throws Exception {

        // 启动信服务
        MobileDemo service = new MobileDemo();
        service.process();

    }

    public void process() throws Exception {

        System.out.println("开始获取运营商信息");

        try {

            // 提交受理请求对象
            List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();

            reqParam.add(new BasicNameValuePair("apiKey", apiKey));// API授权
            reqParam.add(new BasicNameValuePair("version", version));// 调用的接口版本
            reqParam.add(new BasicNameValuePair("callBackUrl", callBackUrl));// callBackUrl
            reqParam.add(new BasicNameValuePair("method", method));// 接口名称

            reqParam.add(new BasicNameValuePair("username", username));// 账号
            reqParam.add(new BasicNameValuePair("password",
                new String(Base64.encodeBase64(password.getBytes("UTF-8")))));// 密码
            reqParam.add(new BasicNameValuePair("contentType", contentType));// 内容类型
            reqParam.add(new BasicNameValuePair("otherInfo", ""));// 其他信息
            reqParam.add(new BasicNameValuePair("sign", getSign(reqParam)));// 请求参数签名

            doProcess(reqParam);
        } catch (Exception ex) {
            System.out.println("开始获取运营商信息异常：" + ex);
        }
    }

    /**
     * 获取业务类型
     */
    @Override
    public String getBizType() {
        return bizType;
    }
}
