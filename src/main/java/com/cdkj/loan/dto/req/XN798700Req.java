package com.cdkj.loan.dto.req;

import lombok.Data;

/**
 * 工行征信
 * @author: taojian 
 * @since: 2019年5月7日 下午3:52:11 
 * @history:
 */
@Data
public class XN798700Req {

    private String orderno;

    private String zoneno;

    private String mastername;

    private String custname;

    private String idtype;

    private String idno;

    private String relation;

    private String idNoFront;

    private String idNoReverse;

    private String authPdf;

    private String interviewPic;

    private String systemCode;

    private String companyCode;
}
