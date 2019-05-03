package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ICarDealerAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.dto.req.XN632060Req;
import com.cdkj.loan.dto.req.XN632061Req;
import com.cdkj.loan.dto.req.XN632062Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ECarDealerNode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarDealerAOImpl implements ICarDealerAO {

    @Autowired
    private ICarDealerBO carDealerBO;

    @Autowired
    ICollectBankcardBO collectBankcardBO;

    @Autowired
    ICarDealerProtocolBO carDealerProtocolBO;

    @Autowired
    ISYSBizLogBO sysBizLogBO;

    @Autowired
    INodeFlowBO nodeFlowBO;

    @Autowired
    IBankBO bankBO;

    @Override
    public String addCarDealer(XN632060Req req) {
        CarDealer data = new CarDealer();

        EntityUtils.copyData(req, data);
        String code = OrderNoGenerater
                .generate(EGeneratePrefix.CARDEALER.getCode());
        data.setCode(code);
        data.setAgreementValidDateStart(
            DateUtil.strToDate(req.getAgreementValidDateStart(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setAgreementValidDateEnd(DateUtil.strToDate(
            req.getAgreementValidDateEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setCurNodeCode(ECarDealerNode.NEW_ADD.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        carDealerBO.saveCarDealer(data);
        return code;
    }

    @Override
    public void dropCarDealer(XN632061Req req) {
        CarDealer data = carDealerBO.getCarDealer(req.getCode());
        if (!ECarDealerNode.NEW_ADD.getCode().equals(data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "经销商不能重复删除");
        }
        data.setCurNodeCode(ECarDealerNode.DROP.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        carDealerBO.refreshCarDealerNode(data);
    }

    @Override
    public void editCarDealer(XN632062Req req) {
        CarDealer data = carDealerBO.getCarDealer(req.getCode());
        EntityUtils.copyData(req, data);
        data.setAgreementValidDateStart(
                DateUtil.strToDate(req.getAgreementValidDateStart(),
                        DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setAgreementValidDateEnd(DateUtil.strToDate(
                req.getAgreementValidDateEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setCurNodeCode(ECarDealerNode.NEW_ADD.getCode());

        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        carDealerBO.refreshCarDealer(data);
    }

    @Override
    public Paginable<CarDealer> queryCarDealerPage(int start, int limit,
            CarDealer condition) {
        return carDealerBO.getPaginable(start, limit,
            condition);
    }

    @Override
    public List<CarDealer> queryCarDealerList(CarDealer condition) {
        return carDealerBO
            .queryCarDealerList(condition);
    }

    @Override
    public CarDealer getCarDealer(String code) {
        return carDealerBO.getCarDealer(code);
    }
}
