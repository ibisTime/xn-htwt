package com.cdkj.loan.dto.req;

import com.cdkj.loan.dto.res.XN632537Res;
import java.util.List;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-流水
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
public class XN632537Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /**************流水*****************/

    private List<XN632537Res> jourList;

    /*******************************/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<XN632537Res> getJourList() {
        return jourList;
    }

    public void setJourList(List<XN632537Res> jourList) {
        this.jourList = jourList;
    }
}
