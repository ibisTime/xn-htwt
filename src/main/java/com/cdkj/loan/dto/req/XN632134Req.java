package com.cdkj.loan.dto.req;

import com.cdkj.loan.domain.EnterFileList;
import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-入档
 *
 * @author: xieyj
 * @since: 2018年5月29日 下午10:31:16
 * @history:
 */
@Data
public class XN632134Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    // 入档编号
    private String enterCode;

    @NotBlank
    private String enterLocation;// 入档位置

    //材料清单
    private List<EnterFileList> fileList;


}
