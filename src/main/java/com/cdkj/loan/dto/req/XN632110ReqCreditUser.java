package com.cdkj.loan.dto.req;

import com.cdkj.loan.dto.res.IdCardInfoRes;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 征信新增 （征信人员）
 *
 * @author: jiafr
 * @since: 2018年5月25日 下午10:23:09
 * @history:
 */
@Data
public class XN632110ReqCreditUser {

    // 姓名
    @NotBlank
    private String userName;

    // 与借款人关系
    @NotBlank
    private String relation;

    // 贷款角色
    @NotBlank
    private String loanRole;

    // 手机号
    @NotBlank
    private String mobile;

    // 身份证号
    @NotBlank
    private String idNo;

    // 身份证正面
    @NotBlank
    private String idFront;

    // 身份证反面
    @NotBlank
    private String idReverse;

    // 征信查询授权书
    @NotBlank
    private String authPdf;

    // 手持授权书照片
    @NotBlank
    private String interviewPic;

    // 身份证信息
    private IdCardInfoRes idCardInfo;

}
