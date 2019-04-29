package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632500Req;

//CHECK ��鲢��ע�� 
public interface ICarInfoBO extends IPaginableBO<CarInfo> {

    public boolean isCarInfoExist(String code);

    public String saveCarInfo(String bizCode);

    public int removeCarInfo(String code);

    public int refreshCarInfo(CarInfo data);

    public List<CarInfo> queryCarInfoList(CarInfo condition);

    public CarInfo getCarInfo(String code);

    public CarInfo getCarInfoByBizCode(String bizCode);

    public void saveAttachment(XN632120Req req);

    public void saveAttachment(XN632500Req req);

    public void entryFbhInfoByBiz(String bizCode, String policyDatetime,
            String policyDueDate);

}
