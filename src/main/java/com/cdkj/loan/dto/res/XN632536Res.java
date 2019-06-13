package com.cdkj.loan.dto.res;

import lombok.Data;

/**
 * @author : cyl
 * @since : 2019-05-31 16:10
 */
@Data
public class XN632536Res {

    /**
     * 征信人编号
     */
    private String code;

    /**
     * 户籍地省
     */
    private String birthAddressProvince;

    /**
     * 户籍地市
     */
    private String birthAddressCity;

    /**
     * 户籍地区
     */
    private String birthAddressArea;

    /**
     * 户籍地详细地址
     */
    private String birthAddress;

    /**
     * 户口所在地邮编
     */
    private String birthPostCode;

    // 学历
    private String education;

    // 工作单位名称
    private String companyName;

    // 工作单位地址
    private String companyAddress;

    // 工作单位电话
    private String companyContactNo;

    private String guaAssetPdf;

}

    
    