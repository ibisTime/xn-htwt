package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632532Req;
import com.cdkj.loan.dto.req.XN632533Req;
import com.cdkj.loan.dto.req.XN632534Req;
import com.cdkj.loan.dto.req.XN632535Req;
import com.cdkj.loan.dto.req.XN632536Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: jiafr
 * @since: 2018年5月25日 下午3:51:03
 * @history:
 */
@Service
public class CreditUserAOImpl implements ICreditUserAO {

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Override
    public CreditUser getCreditUserReport(String code) {

        return creditUserBO.getCreditUser(code);
    }

    @Override
    public Object changeLender(String selfCode, String wifeCode) {
        return null;
    }

    @Override
    public void saveSelfExtentInfo(XN632532Req req) {
        CreditUser creditUser =
                creditUserBO.getCreditUserByBizCode(req.getCode(), ELoanRole.APPLY_USER);
        if (creditUser != null) {
            BeanUtils.copyProperties(req, creditUser, "code");
            creditUserBO.refreshCreditUser(creditUser);
        }
    }

    @Override
    @Transactional
    public void saveSelfHomeInfo(XN632533Req req) {
        CreditUser creditUser =
                creditUserBO.getCreditUserByBizCode(req.getCode(), ELoanRole.APPLY_USER);
        if (creditUser != null) {
            BeanUtils.copyProperties(req, creditUser, "code");
            saveAttachment(req.getCode(), EAttachName.hkBookPdf, req.getHkBookPdf());
            saveAttachment(req.getCode(), EAttachName.marryPdf, req.getMarryPdf());
            saveAttachment(req.getCode(), EAttachName.liveProvePdf, req.getLiveProvePdf());
            saveAttachment(req.getCode(), EAttachName.buildProvePdf, req.getBuildProvePdf());
            saveAttachment(req.getCode(), EAttachName.houseContract, req.getHouseContract());
            saveAttachment(req.getCode(), EAttachName.houseInvoice, req.getHouseInvoice());
            saveAttachment(req.getCode(), EAttachName.housePictureApply,
                    req.getHousePictureApply());
        }
    }

    @Override
    @Transactional
    public void saveSelfWorkInfo(XN632534Req req) {
        CreditUser creditUser =
                creditUserBO.getCreditUserByBizCode(req.getCode(), ELoanRole.APPLY_USER);
        if (creditUser != null) {
            BeanUtils.copyProperties(req, creditUser, "code");
            creditUserBO.refreshCreditUser(creditUser);
            saveAttachment(req.getCode(), EAttachName.improvePdf, req.getImprovePdf());
            saveAttachment(req.getCode(), EAttachName.frontTablePic, req.getFrontTablePic());
            saveAttachment(req.getCode(), EAttachName.workPlacePic, req.getWorkPlacePic());
            saveAttachment(req.getCode(), EAttachName.salerAndcustomer, req.getSalerAndcustomer());
        }
    }

    @Override
    @Transactional
    public void saveCommonRepayInfo(XN632535Req req) {
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(req.getCode(), ELoanRole.GHR);
        if (creditUser != null) {
            BeanUtils.copyProperties(req, creditUser, "code");
            creditUserBO.refreshCreditUser(creditUser);
            saveAttachment(req.getCode(), EAttachName.mateAssetPdf, req.getMateAssetPdf());
        }
    }

    @Override
    @Transactional
    public void saveBondsmanInfo(XN632536Req req) {
        CreditUser creditUser = creditUserBO
                .getCreditUserByBizCode(req.getCode(), ELoanRole.GUARANTOR);
        if (creditUser != null) {
            BeanUtils.copyProperties(req, creditUser, "code");
            creditUserBO.refreshCreditUser(creditUser);
            saveAttachment(req.getCode(), EAttachName.guaAssetPdf, req.getGuaAssetPdf());
        }
    }

    public void saveAttachment(String bizCode, EAttachName attachName, String value) {
        attachmentBO.saveAttachment(bizCode, attachName.getCode(), attachName.getValue(), value);
    }
}
