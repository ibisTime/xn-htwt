/**
 * @Title XN630440Req.java
 * @Package com.cdkj.loan.dto.req
 * @Description
 * @author taojian
 * @date 2019年3月12日 下午5:10:03
 * @version V1.0
 */
package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改配置
 *
 * @author: taojian
 * @since: 2019年3月12日 下午5:10:03
 * @history:
 */
@Data
public class XN630442Req {

    @NotBlank(message = "编号不能为空")
    private String code;

    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 图片
     */
    private String pic;

    @NotBlank(message = "更新人不能为空")
    private String updater;

    /**
     * 备注
     */
    private String remark;

}
