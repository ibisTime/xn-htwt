package com.cdkj.loan.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.ICreditUserExtBO;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class CarInfoAOImpl implements ICarInfoAO {

    @Autowired
    private ICarInfoBO carInfoBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private ICreditJourBO creditJourBO;

    @Autowired
    private ICreditUserExtBO creditUserExtBO;

    @Override
    public int editCarInfo(XN632120Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ECdbizStatus.A3.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A3x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该业务不处于录入准入单状态，无法录入");
        }
        // 车辆信息录入
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(req.getCode());
        String carInfoCode = carInfo.getCode();
        EntityUtils.copyData(req, carInfo);
        carInfo.setCode(carInfoCode);
        carInfoBO.refreshCarInfo(carInfo);
        // 征信人信息录入
        CreditUserExt creditUserExt = EntityUtils.copyData(req,
            CreditUserExt.class);

        creditUserExtBO.saveCreditUserExt(creditUserExt, cdbiz.getCode());
        // 流水录入

        return 0;
    }

}
