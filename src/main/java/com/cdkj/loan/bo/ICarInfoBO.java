package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632500Req;
import java.util.List;
import com.cdkj.loan.dto.req.XN632530Req;
import com.cdkj.loan.dto.req.XN632531Req;
import java.util.List;

public interface ICarInfoBO extends IPaginableBO<CarInfo> {

    boolean isCarInfoExist(String code);

    String saveCarInfo(String bizCode);

    int removeCarInfo(String code);

    int refreshCarInfo(CarInfo data);

    List<CarInfo> queryCarInfoList(CarInfo condition);

    CarInfo getCarInfo(String code);

    CarInfo getCarInfoByBizCode(String bizCode);

    void saveAttachment(XN632120Req req);

    void saveAttachment(XN632500Req req);

    void entryFbhInfoByBiz(String bizCode, String policyDatetime,
            String policyDueDate);

    void saveCarInfo(XN632530Req req);

    void saveCarInfo(XN632531Req req);

    int refreshCarInfo(CarInfo data, XN632530Req req);

    int refreshCarInfo(CarInfo data, XN632531Req req);
}
