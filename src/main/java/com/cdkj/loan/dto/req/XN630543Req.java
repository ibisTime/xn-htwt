package com.cdkj.loan.dto.req;

import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class XN630543Req extends APageReq {

    private static final long serialVersionUID = 5066181160930283667L;

    private String repayBizCode;// 还款业务编号

    private String userId;// 用户编号

    @NotBlank
    private String refType;// 类型，1=商品，0=车贷

    // 状态list
    private List<String> curNodeCodeList;
}
