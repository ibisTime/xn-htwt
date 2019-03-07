package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class XN805041Req {

    @NotBlank
    private String mobile; // 手机号

    @Length(min = 2, max = 10, message = "昵称长度必须在2-10之间")
    private String nickname; // 昵称

    @NotBlank
    private String loginPwd; // 登录密码

    @NotBlank
    private String smsCaptcha; // 手机验证码

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getSmsCaptcha() {
        return smsCaptcha;
    }

    public void setSmsCaptcha(String smsCaptcha) {
        this.smsCaptcha = smsCaptcha;
    }

}
