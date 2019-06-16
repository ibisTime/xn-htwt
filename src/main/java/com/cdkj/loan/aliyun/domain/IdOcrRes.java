/**
 * @Title IdOcr.java
 * @Package com.cdkj.loan.aliyun.domain
 * @Description
 * @author xieyj
 * @date 2018年7月1日 下午2:26:02
 * @version V1.0
 */
package com.cdkj.loan.aliyun.domain;

import lombok.Data;

/**
 * @author: xieyj
 * @since: 2018年7月1日 下午2:26:02
 * @history:
 */
@Data
public class IdOcrRes {

    private String birthAddress;// 户籍地址

    private String customerBirth;// 出生日期

    // private String configStr;// 配置信息，同输入configure
    //
    // private FaceRect faceRect; //
    // #人脸位置，center表示人脸矩形中心坐标，size表示人脸矩形长宽，angle表示矩形顺时针旋转的度数

    private String userName; // 姓名

    private String nation; // 民族

    private String idNo;// 身份证号

    private String requestId;

    private String gender;// 性别

    private String startDate;// 有效期起始时间

    private String statdate;// 有效期结束时间

    private String authref;// 签发机关

    private String success;// #识别结果，true表示成功，false表示失败

    public IdOcrRes(IdOcr idOcr) {
        this.birthAddress = idOcr.getAddress();
        this.customerBirth = idOcr.getBirth();
        this.userName = idOcr.getName();
        this.nation = idOcr.getNationality();
        this.idNo = idOcr.getNum();
        this.gender = idOcr.getSex();
        this.startDate = idOcr.getStart_date();
        this.statdate = idOcr.getEnd_date();
        this.authref = idOcr.getIssue();
        this.success = idOcr.getSuccess();
    }

}
