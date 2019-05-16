package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.ICarPledgeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarPledgeDAO;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632133Req;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarPledgeBOImpl extends PaginableBOImpl<CarPledge> implements
        ICarPledgeBO {

    @Autowired
    private ICarPledgeDAO carPledgeDAO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Override
    public String saveCarPledge(String bizCode, String supplementNoteg,
            String pledgeUser, String pledgeUserIdCard, String pledgeAddress) {
        CarPledge carPledge = new CarPledge();

        String code = OrderNoGenerater.generate(EGeneratePrefix.CAR_PLEDGE
                .getCode());
        carPledge.setCode(code);
        carPledge.setBizCode(bizCode);
        carPledge.setPledgeUser(pledgeUser);
        carPledge.setPledgeUserIdCard(pledgeUserIdCard);
        carPledge.setPledgeAddress(pledgeAddress);
        carPledge.setCurNodeCode(ENode.confirm_pledge_apply.getCode());
        carPledge.setPledgeSupplementNote(supplementNoteg);

        carPledgeDAO.insert(carPledge);
        return code;
    }

    @Override
    public String saveCarPledge(String bizCode, String pledgeUser,
            String pledgeUserIdCard, String pledgeAddress) {

        CarPledge carPledge = new CarPledge();

        String code = OrderNoGenerater.generate(EGeneratePrefix.CAR_PLEDGE
                .getCode());
        carPledge.setCode(code);
        carPledge.setBizCode(bizCode);
        carPledge.setPledgeUser(pledgeUser);
        carPledge.setPledgeUserIdCard(pledgeUserIdCard);
        carPledge.setPledgeAddress(pledgeAddress);
        carPledgeDAO.insert(carPledge);
        return code;

    }

    @Override
    public void saleManConfirm(CarPledge carPledge, XN632124Req req) {
        String code = carPledge.getCode();
        EntityUtils.copyData(req, carPledge);
        carPledge.setCode(code);
        carPledgeDAO.updateSaleManConfirm(carPledge);
    }

    @Override
    public void entryPledgeInfo(String code, String nextNodeCode,
            XN632133Req req) {
        CarPledge carPledge = EntityUtils.copyData(req, CarPledge.class);
        carPledge.setCode(code);
        carPledge.setCurNodeCode(nextNodeCode);

        carPledgeDAO.updateEntryPledgeInfo(carPledge);
    }

    @Override
    public void pledgeCommitBank(String code, String nextNodeCode,
            String operator, String pledgeBankCommitDatetime,
            String pledgeBankCommitNote) {
        CarPledge carPledge = new CarPledge();

        carPledge.setCode(code);
        carPledge.setCurNodeCode(nextNodeCode);
        carPledge.setPledgeBankCommitDatetime(DateUtil.strToDate(
                pledgeBankCommitDatetime, DateUtil.DATA_TIME_PATTERN_1));
        carPledge.setPledgeBankCommitNote(pledgeBankCommitNote);

        carPledgeDAO.updateCommitBank(carPledge);
    }

    @Override
    public void confirmDone(String code, String nextNodeCode, String operator) {
        CarPledge carPledge = new CarPledge();

        carPledge.setCode(code);
        carPledge.setCurNodeCode(nextNodeCode);

        carPledgeDAO.updateConfirmDone(carPledge);
    }

    @Override
    public List<CarPledge> queryCarPledgeList(CarPledge condition) {
        return carPledgeDAO.selectList(condition);
    }

    @Override
    public CarPledge getCarPledge(String code) {
        CarPledge data = null;
        if (StringUtils.isNotBlank(code)) {
            CarPledge condition = new CarPledge();
            condition.setCode(code);
            data = carPledgeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "车辆抵押信息不存在");
            }
        }
        return data;
    }

    @Override
    public CarPledge getCarPledgeByBizCode(String bizCode) {
        CarPledge data = null;
        if (StringUtils.isNotBlank(bizCode)) {
            CarPledge condition = new CarPledge();
            condition.setBizCode(bizCode);
            data = carPledgeDAO.select(condition);
        }
        return data;
    }

    @Override
    public void removeCarpledge(String bizCode) {
        CarPledge condition = new CarPledge();
        condition.setBizCode(bizCode);
        List<CarPledge> carPledges = carPledgeDAO.selectList(condition);
        for (CarPledge carPledge : carPledges) {
            carPledgeDAO.delete(carPledge);
        }
    }

    @Override
    public void refreshSupplementNote(CarPledge condition) {
        carPledgeDAO.updateSupplementNote(condition);
    }

    @Override
    public void refreshCarPledge(CarPledge carPledge) {
        carPledgeDAO.updateCarPledge(carPledge);
    }

}
