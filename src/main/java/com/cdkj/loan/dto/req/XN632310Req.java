package com.cdkj.loan.dto.req;

import com.cdkj.loan.dto.res.XN632310ReqRes;
import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 确认返点支付
 *
 * @author: jiafr
 * @since: 2018年6月9日 下午2:10:21
 * @history:
 */
@Data
public class XN632310Req {

    @NotBlank
    private String code;

    @NotEmpty(message = "返点账号列表不能为空")
    private List<XN632310ReqRes> repointAccountList;

    @NotBlank
    private String updater;

}
