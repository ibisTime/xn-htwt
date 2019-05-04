package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarInfoDAO;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632500Req;
import com.cdkj.loan.dto.req.XN632530Req;
import com.cdkj.loan.dto.req.XN632531Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//CHECK
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
                throw new BizException("xn0000", "车辆信息编号不存在");
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

    @Override
    public void saveCarInfo(XN632530Req req, Long companyFee) {
        CarInfo carInfo = new CarInfo();
        String code = OrderNoGenerater.generate(EGeneratePrefix.car_info.getCode());
        carInfo.setBizCode(req.getCode());
        EntityUtils.copyData(req, carInfo);
        carInfo.setCompanyFee(companyFee);
        carInfo.setCode(code);
        carInfoDAO.insert(carInfo);
    }

    @Override
    public void saveCarInfo(XN632531Req req) {
        CarInfo carInfo = new CarInfo();
        EntityUtils.copyData(req, carInfo);
        //重置code
        String code = OrderNoGenerater.generate(EGeneratePrefix.car_info.getCode());
        carInfo.setCode(code);
        carInfoDAO.insert(carInfo);
    }

    @Override
    public int refreshCarInfo(CarInfo carInfo, XN632530Req req) {
        String code = carInfo.getCode();
        EntityUtils.copyData(req, carInfo);
        //重置code
        carInfo.setCode(code);
        return carInfoDAO.update(carInfo);
    }

    @Override
    public int refreshCarInfo(CarInfo carInfo, XN632531Req req) {
        String code = carInfo.getCode();
        EntityUtils.copyData(req, carInfo);
        //重置code
        carInfo.setCode(code);
        return carInfoDAO.update(carInfo);
    }

    @Override
    public void saveAttachment(XN632500Req req) {
        String bizCode = req.getCode();
        EAttachName attachName = null;
        // 车辆照片
        if (StringUtils.isNotBlank(req.getCarPic())) {
            attachName = EAttachName.carPic;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getCarPic());
        }
        // 合格证
        if (StringUtils.isNotBlank(req.getCarHgzPic())) {
            attachName = EAttachName.carHgzPic;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getCarHgzPic());
        }

        // 户口本资料
        if (StringUtils.isNotBlank(req.getHkBookPdf())) {
            attachName = EAttachName.hkBookPdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getHkBookPdf());
        }
        // 结婚证资料
        if (StringUtils.isNotBlank(req.getMarryPdf())) {

            attachName = EAttachName.marryPdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getMarryPdf());
        }

        // 购房合同
        if (StringUtils.isNotBlank(req.getHouseContract())) {

            attachName = EAttachName.houseContract;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getHouseContract());
        }

        // 购房发票
        if (StringUtils.isNotBlank(req.getHouseInvoice())) {

            attachName = EAttachName.houseInvoice;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getHouseInvoice());
        }

        // 居住证明
        if (StringUtils.isNotBlank(req.getLiveProvePdf())) {

            attachName = EAttachName.liveProvePdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getLiveProvePdf());
        }

        // 自建房证明
        if (StringUtils.isNotBlank(req.getBuildProvePdf())) {

            attachName = EAttachName.buildProvePdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getBuildProvePdf());
        }

        // 家访照片
        if (StringUtils.isNotBlank(req.getHousePictureApply())) {

            attachName = EAttachName.housePictureApply;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getHousePictureApply());
        }

        // 收入证明
        if (StringUtils.isNotBlank(req.getImprovePdf())) {

            attachName = EAttachName.improvePdf;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getImprovePdf());
        }

        // 单位前台照片
        if (StringUtils.isNotBlank(req.getFrontTablePic())) {

            attachName = EAttachName.frontTablePic;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getFrontTablePic());
        }

        // 单位场地照片
        if (StringUtils.isNotBlank(req.getWorkPlacePic())) {

            attachName = EAttachName.workPlacePic;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getWorkPlacePic());
        }

        // 业务员与客户合影
        if (StringUtils.isNotBlank(req.getSalerAndcustomer())) {

            attachName = EAttachName.salerAndcustomer;
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), req.getSalerAndcustomer());
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

    }
}
