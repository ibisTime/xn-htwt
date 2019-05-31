package com.cdkj.loan.dto.req;

import com.cdkj.loan.dto.res.XN632536Res;
import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-担保人信息
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
@Data
public class XN632536Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /**
     * **********担保人信息start*************
     */

    private List<XN632536Res> guarantorList;

    /**
     * **********担保人信息end**************
     */
}
