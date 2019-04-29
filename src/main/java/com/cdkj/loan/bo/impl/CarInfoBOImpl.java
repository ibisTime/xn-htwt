package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarInfoDAO;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class CarInfoBOImpl extends PaginableBOImpl<CarInfo> implements
        ICarInfoBO {

    @Autowired
    private ICarInfoDAO carInfoDAO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Override
    public boolean isCarInfoExist(String code) {
        CarInfo condition = new CarInfo();
        condition.setCode(code);
        if (carInfoDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCarInfo(String bizCode) {
        String code = null;
        CarInfo data = new CarInfo();
        code = OrderNoGenerater.generate(EGeneratePrefix.car_info.getCode());
        data.setCode(code);
        data.setBizCode(bizCode);
        carInfoDAO.insert(data);
        return code;
    }

    @Override
    public int removeCarInfo(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CarInfo data = new CarInfo();
            data.setCode(code);
            count = carInfoDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCarInfo(CarInfo data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = carInfoDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CarInfo> queryCarInfoList(CarInfo condition) {
        return carInfoDAO.selectList(condition);
    }

    @Override
    public CarInfo getCarInfo(String code) {
        CarInfo data = null;
        if (StringUtils.isNotBlank(code)) {
            CarInfo condition = new CarInfo();
            condition.setCode(code);
            data = carInfoDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public CarInfo getCarInfoByBizCode(String bizCode) {
        CarInfo condition = new CarInfo();
        condition.setBizCode(bizCode);

        return carInfoDAO.select(condition);
    }

    @Override
    public void saveAttachment(XN632120Req req) {
        String bizCode = req.getCode();
        EAttachName attachName = null;
        // 合格证
        if (StringUtils.isNotBlank(req.getCarHgzPic())) {
            attachName = EAttachName.carHgzPic;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getCarHgzPic());
        }

        // 行驶证正面
        if (StringUtils.isNotBlank(req.getDriveLicenseFront())) {

            attachName = EAttachName.driveLicenseFront;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getDriveLicenseFront());
        }

        // 行驶证反面
        if (StringUtils.isNotBlank(req.getDriveLicenseReverse())) {

            attachName = EAttachName.driveLicenseReverse;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getDriveLicenseReverse());
        }
        // 工作资料上传
        if (StringUtils.isNotBlank(req.getWorkAssetPdf())) {

            attachName = EAttachName.workAssetPdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getWorkAssetPdf());
        }
        // 申请人资产资料pdf
        if (StringUtils.isNotBlank(req.getAssetPdf())) {

            attachName = EAttachName.assetPdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getAssetPdf());
        }
        // 配偶资产资料pdf
        if (StringUtils.isNotBlank(req.getMateAssetPdf())) {

            attachName = EAttachName.mateAssetPdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getMateAssetPdf());
        }
        // 担保人资料pdf
        if (StringUtils.isNotBlank(req.getGuaAssetPdf())) {

            attachName = EAttachName.guaAssetPdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getGuaAssetPdf());
        }
        // 购房合同
        if (StringUtils.isNotBlank(req.getHouseContract())) {

            attachName = EAttachName.houseContract;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getHouseContract());
        }
        // 结婚证资料
        if (StringUtils.isNotBlank(req.getMarryPdf())) {

            attachName = EAttachName.marryPdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getMarryPdf());
        }
        // 房屋照片
        if (StringUtils.isNotBlank(req.getHousePicture())) {

            attachName = EAttachName.house_pic;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getHousePicture());
        }
    }

    @Override
    public void entryFbhInfoByBiz(String bizCode, String policyDatetime,
            String policyDueDate) {
        CarInfo carInfo = new CarInfo();

        carInfo.setBizCode(bizCode);
        carInfo.setPolicyDatetime(policyDatetime);
        carInfo.setPolicyDueDate(policyDueDate);

        carInfoDAO.updateEntryFbhInfo(carInfo);
    }
}
