package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.domain.CreditIcbank;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632532Req;
import com.cdkj.loan.dto.req.XN632533Req;
import com.cdkj.loan.dto.req.XN632534Req;
import com.cdkj.loan.dto.req.XN632535Req;
import com.cdkj.loan.dto.req.XN632536Req;
import com.cdkj.loan.dto.res.XN632536Res;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import com.cdkj.loan.enums.ECreditUserStatus;
import org.apache.commons.collections.CollectionUtils;
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
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(
                req.getCode(), ECreditUserLoanRole.APPLY_USER);
        if (creditUser != null) {
            String code = creditUser.getCode();
            EntityUtils.copyData(req, creditUser);
            creditUser.setCode(code);
            creditUserBO.refreshCreditUser(creditUser);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSelfHomeInfo(XN632533Req req) {
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(
                req.getCode(), ECreditUserLoanRole.APPLY_USER);
        if (creditUser != null) {
            String code = creditUser.getCode();
            EntityUtils.copyData(req, creditUser);
            creditUser.setCode(code);
            creditUserBO.refreshCreditUser(creditUser);
            saveAttachment(req.getCode(), EAttachName.hkBookPdf,
                    req.getHkBookPdf());
            saveAttachment(req.getCode(), EAttachName.marryPdf,
                    req.getMarryPdf());
            saveAttachment(req.getCode(), EAttachName.liveProvePdf,
                    req.getLiveProvePdf());
            saveAttachment(req.getCode(), EAttachName.buildProvePdf,
                    req.getBuildProvePdf());
            saveAttachment(req.getCode(), EAttachName.houseContract,
                    req.getHouseContract());
            saveAttachment(req.getCode(), EAttachName.houseInvoice,
                    req.getHouseInvoice());
            saveAttachment(req.getCode(), EAttachName.housePictureApply,
                    req.getHousePictureApply());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSelfWorkInfo(XN632534Req req) {
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(
                req.getCode(), ECreditUserLoanRole.APPLY_USER);
        if (creditUser != null) {
            String code = creditUser.getCode();
            EntityUtils.copyData(req, creditUser);
            creditUser.setCode(code);
            creditUserBO.refreshCreditUser(creditUser);
            saveAttachment(req.getCode(), EAttachName.improvePdf,
                    req.getImprovePdf());
            saveAttachment(req.getCode(), EAttachName.frontTablePic,
                    req.getFrontTablePic());
            saveAttachment(req.getCode(), EAttachName.workPlacePic,
                    req.getWorkPlacePic());
            saveAttachment(req.getCode(), EAttachName.salerAndcustomer,
                    req.getSalerAndcustomer());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveGhrInfo(XN632535Req req) {
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(
                req.getCode(), ECreditUserLoanRole.GHR);
        if (creditUser != null) {
            String code = creditUser.getCode();
            EntityUtils.copyData(req, creditUser);
            creditUser.setCode(code);
            creditUserBO.refreshCreditUser(creditUser);
            saveAttachment(req.getCode(), EAttachName.mateAssetPdf,
                    req.getMateAssetPdf());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveGuarantorInfo(XN632536Req req) {
        if (CollectionUtils.isNotEmpty(req.getGuarantorList())) {
            int guarantorCount = 0;
            for (XN632536Res res : req.getGuarantorList()) {
                CreditUser creditUser = creditUserBO.getCreditUser(res.getCode());
                EntityUtils.copyData(res, creditUser);
                creditUserBO.refreshCreditUser(creditUser);
                if (guarantorCount == 0) {
                    saveAttachment(req.getCode(), EAttachName.guaAssetPdf,
                            res.getGuaAssetPdf());
                    guarantorCount += 1;
                } else {
                    saveAttachment(req.getCode(), EAttachName.guaAssetPdf1,
                            res.getGuaAssetPdf());
                }
            }
        }
    }

    public void saveAttachment(String bizCode, EAttachName attachName,
            String url) {
        attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), url);
    }

    @Override
    public Paginable<CreditUser> queryCreditUserPage(int start, int limit,
            CreditUser condition) {
        Paginable<CreditUser> page = creditUserBO.getPaginable(start, limit,
                condition);
        for (CreditUser creditUser : page.getList()) {
            if (ECreditUserStatus.to_callback.getCode().equals(
                    creditUser.getStatus())) {
                CreditIcbank creditIcbank = creditUserBO
                        .getCreditIcbank(creditUser.getIcbankCode());
                if (null != creditIcbank && null != creditIcbank.getResult()) {
                    creditUserBO.refreshIcbankCredit(creditUser, creditIcbank);
                }
            }
        }
        return page;
    }

}
