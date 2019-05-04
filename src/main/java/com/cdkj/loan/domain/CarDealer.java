package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

@Data
public class CarDealer extends ABaseDO {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String code;// 编号

    private String fullName;// 全称

    private String abbrName;// 简称

    private String isSelfDevelop;// 是否自主开发

    private String address;// 地址

    private String carDealerType;// 车行经营性质

    private String mainContact;// 主要联系人

    private String contactPhone;// 联系人电话

    private String mainBrand;// 主营品牌

    private String parentGroup;// 所属集团

    private Date agreementValidDateStart;// 合作协议有效期起

    private Date agreementValidDateEnd;// 合作协议有效期止

    private String agreementStatus;// 协议状态(0下架1上架)

    private String agreementPic;// 车商合作协议

    private String settleWay;// 结算方式(1现结2月结3季结)

    private String businessArea;// 业务区域

    private String belongBranchCompany;// 归属分公司

    private String curNodeCode;// 当前节点编号

    private String policyNote;// 政策说明

    private String updater;//更新人

    private Date updateDatetime;//更新时间

    private String remark;// 备注

    /*--------辅助字段----------*/

    private String abbrNameQuery;// 简称模糊查
}
