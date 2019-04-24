package com.cdkj.loan.ao;

import org.springframework.stereotype.Component;

import com.cdkj.loan.dto.req.XN632120Req;

//CHECK ��鲢��ע�� 
@Component
public interface ICarInfoAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public int editCarInfo(XN632120Req req);

}
