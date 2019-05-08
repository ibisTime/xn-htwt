/**
 * @Title XN632515Req.java 
 * @Package com.cdkj.loan.dto.req 
 * @Description 
 * @author taojian  
 * @date 2019年4月2日 下午7:34:42 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import lombok.Data;

/** 
 * 分页查工行征信业务
 * @author: taojian 
 * @since: 2019年4月2日 下午7:34:42 
 * @history:
 */
@Data
public class XN632518Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 用户编号
    private String userId;

    // 业务编号
    private String bizCode;
}
