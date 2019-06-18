package com.cdkj.loan.dto.req;

import lombok.Data;

@Data
public class XN630406Req extends APageReq {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 67761930202644722L;

    // 名称（选填）
    private String name;

    // 字母序号（选填）
    private String letter;

    // 状态（选填）
    private String status;

    // 是否推荐（选填）
    private String location;

    // 品牌类型（1接口导入,2用户新增）（选填）
    private String type;

}
