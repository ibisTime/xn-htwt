package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 主贷人和配偶一键互换
 * @author: CYL 
 * @since: 2018年12月10日 下午8:11:29 
 * @history:
 */
public class XN632099Req {

    // 征信人列表
    @NotEmpty
    private List<String> creditUserList;

    public List<String> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<String> creditUserList) {
        this.creditUserList = creditUserList;
    }

}
