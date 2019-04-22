package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 删除用户行为
 * @author: taojian 
 * @since: 2019年3月13日 下午5:12:59 
 * @history:
 */
public class XN630461Req {

    @NotEmpty
    private List<String> codeList;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

}
