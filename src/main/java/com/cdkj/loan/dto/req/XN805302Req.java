/**
 * @Title XN805302Req.java 
 * @Package com.ogc.standard.dto.req 
 * @Description 
 * @author dl  
 * @date 2018年8月22日 下午2:59:50 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/** 
 * 回撤消息
 * @author: dl 
 * @since: 2018年8月22日 下午2:59:50 
 * @history:
 */
public class XN805302Req {
    // 消息编号
    @NotEmpty
    private List<String> codeList;

    // 更新人
    @NotBlank
    private String updater;

    // 备注
    private String remark;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
