/**
 * @Title PageReq.java 
 * @Package com.ibis.account.dto.req 
 * @Description 
 * @author miyb  
 * @date 2015-5-7 上午10:23:31 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import java.io.Serializable;
import javax.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author: miyb 
 * @since: 2015-5-7 上午10:23:31 
 * @history:
 */
@Data
public abstract class APageReq implements Serializable {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 9192316630188356600L;

    // 创建起始时间(YYYY-MM-DD)
    private String createDatetimeStart;

    // 创建终止时间(YYYY-MM-DD)
    private String createDatetimeEnd;

    @NotBlank(message = "第几页start参数不能为空")
    @Min(0)
    private String start;

    @NotBlank(message = "每页记录数limit参数不能为空")
    @Min(0)
    private String limit;

    private String orderColumn;// 排序字段(数据库字段)

    private String orderDir;// 排序方向

}
