package com.cdkj.loan.domain;

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

public class BodyGuardApiResponse implements Serializable {
    private static final long serialVersionUID = 4152462611121573434L;

    private Boolean success = false;

    private String id;

    private String reason_desc;

    private String reason_code;

    private String nextService;

    private String result_desc;

    private String data;

    private Integer offset;

    private Integer size;

    private Integer total;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getNextService() {
        return nextService;
    }

    public void setNextService(String nextService) {
        this.nextService = nextService;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason_desc() {
        return reason_desc;
    }

    public void setReason_desc(String reason_desc) {
        this.reason_desc = reason_desc;
    }

    public String getReason_code() {
        return reason_code;
    }

    public void setReason_code(String reason_code) {
        this.reason_code = reason_code;
    }

    public String getResult_desc() {
        return result_desc;
    }

    public void setResult_desc(String result_desc) {
        this.result_desc = result_desc;
    }

    @Override
    public String toString() {
        if (success && StringUtils.isBlank(reason_code)) {
            return "BodyGuardApiResponse [success=" + success + ", id=" + id
                    + ", result_desc=" + result_desc + "]";
        } else {
            return "BodyGuardApiResponse [success=" + success
                    + ", reason_code=" + reason_code + ", reason_desc=" + reason_desc + "]";
        }
    }

}
