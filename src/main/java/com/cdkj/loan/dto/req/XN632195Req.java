package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 分页查询客户作废
 * @author: jiafr 
 * @since: 2018年6月10日 下午9:08:41 
 * @history:
 */
public class XN632195Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String applyUserName;

    private String code;

    private String advanceFundDatetimeStart;

    private String advanceFundDatetimeEnd;

    private String curNodeCode;// 当前节点编号

    private List<String> curNodeCodeList;// 当前节点编号

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAdvanceFundDatetimeStart() {
        return advanceFundDatetimeStart;
    }

    public void setAdvanceFundDatetimeStart(String advanceFundDatetimeStart) {
        this.advanceFundDatetimeStart = advanceFundDatetimeStart;
    }

    public String getAdvanceFundDatetimeEnd() {
        return advanceFundDatetimeEnd;
    }

    public void setAdvanceFundDatetimeEnd(String advanceFundDatetimeEnd) {
        this.advanceFundDatetimeEnd = advanceFundDatetimeEnd;
    }

}
