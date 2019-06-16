package com.cdkj.loan.bo.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.ICreditUserDAO;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.domain.BodyGuardApiResponse;
import com.cdkj.loan.domain.BodyGuardWZHYResponse;
import com.cdkj.loan.domain.CreditIcbank;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632110ReqCreditUser;
import com.cdkj.loan.dto.req.XN632111ReqCreditUser;
import com.cdkj.loan.dto.req.XN632114Req;
import com.cdkj.loan.dto.req.XN632500Req;
import com.cdkj.loan.dto.req.XN798600Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import com.cdkj.loan.enums.ECreditUserStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.http.BizConnecter;
import com.cdkj.loan.http.JsonUtils;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: jiafr
 * @since: 2018年5月25日 下午2:04:01
 * @history:
 */
@Component
public class CreditUserBOImpl extends PaginableBOImpl<CreditUser> implements
        ICreditUserBO {

    @Autowired
    private ICreditUserDAO creditUserDAO;

    @Autowired
    private IAttachmentBO attachmentBO;

    static Logger logger = Logger.getLogger(CreditUserBOImpl.class);

    @Override
    public void saveCreditUser(XN632110ReqCreditUser child, String bizCode, int guaUserCount) {
        String code = null;
        CreditUser creditUser = new CreditUser();
        code = OrderNoGenerater.generate(EGeneratePrefix.CREDITUSER.getCode());
        creditUser.setCode(code);
        creditUser.setBizCode(bizCode);
        creditUser.setRelation(child.getRelation());
        creditUser.setUserName(child.getUserName());
        creditUser.setLoanRole(child.getLoanRole());
        creditUser.setMobile(child.getMobile());
        creditUser.setIdFront(child.getIdFront());
        creditUser.setIdReverse(child.getIdReverse());
        creditUser.setAuthPdf(child.getAuthPdf());
        creditUser.setInterviewPic(child.getInterviewPic());
        creditUser.setIdNo(child.getIdNo());
        String nowYear = DateUtil.dateToStr(new Date(),
                DateUtil.FRONT_DATE_FORMAT_STRING).substring(0, 4);
        String birthYear = getBirthYearByIdNo(child.getIdNo());
        Integer age = StringValidater.toInteger(nowYear)
                - StringValidater.toInteger(birthYear);
        creditUser.setAge(age);
        String sex = getSexByIdNo(child.getIdNo());
        creditUser.setGender(sex);
        creditUser.setStatus(ECreditUserStatus.to_icCredit.getCode());
        if (child.getIdCardInfo() != null) {
            creditUser.setNation(child.getIdCardInfo().getNationality());
            creditUser.setAuthref(child.getIdCardInfo().getIssue());
            creditUser.setStatdate(child.getIdCardInfo().getEndDate());
            creditUser.setCustomerBirth(child.getIdCardInfo().getBirth());
            creditUser.setBirthAddress(child.getIdCardInfo().getResidenceAddress());
        }
        // 主贷人
        if (ECreditUserLoanRole.APPLY_USER.getCode()
                .equals(child.getLoanRole())) {
            // 身份证正面
            EAttachName attachName = EAttachName.getMap().get(
                    EAttachName.mainLoaner_id_front.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), child.getIdFront());
            // 身份证反面
            attachName = EAttachName.getMap().get(
                    EAttachName.mainLoaner_id_reverse.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), child.getIdReverse());
            // 征信查询授权
            attachName = EAttachName.getMap().get(
                    EAttachName.mainLoaner_auth_pdf.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), child.getAuthPdf());
            // 面签照片
            attachName = EAttachName.getMap().get(
                    EAttachName.mainloaner_interview_pic.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), child.getInterviewPic());
            // 共还人信息
        } else if (ECreditUserLoanRole.GHR.getCode()
                .equals(child.getLoanRole())) {
            // 身份证正面
            EAttachName attachName = EAttachName.getMap().get(
                    EAttachName.replier_id_front.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), child.getIdFront());
            // 身份证反面
            attachName = EAttachName.getMap().get(
                    EAttachName.replier_id_reverse.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), child.getIdReverse());
            // 征信查询授权
            attachName = EAttachName.getMap().get(
                    EAttachName.replier_auth_pdf.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), child.getAuthPdf());
            // 面签照片
            attachName = EAttachName.getMap().get(
                    EAttachName.replier_interview_pic.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                    attachName.getValue(), child.getInterviewPic());

            // 担保人
        } else if (ECreditUserLoanRole.GUARANTOR.getCode().equals(
                child.getLoanRole())) {
            if (guaUserCount > 0) {
                // 身份证正面
                EAttachName attachName = EAttachName.getMap().get(
                        EAttachName.assurance_id_front1.getCode());
                attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                        attachName.getValue(), child.getIdFront());
                // 身份证反面
                attachName = EAttachName.getMap().get(
                        EAttachName.assurance_id_reverse1.getCode());
                attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                        attachName.getValue(), child.getIdReverse());
                // 征信查询授权
                attachName = EAttachName.getMap().get(
                        EAttachName.assurance_auth_pdf1.getCode());
                attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                        attachName.getValue(), child.getAuthPdf());
                // 面签照片
                attachName = EAttachName.getMap().get(
                        EAttachName.assurance_interview_pic1.getCode());
                attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                        attachName.getValue(), child.getInterviewPic());
            } else {
                // 身份证正面
                EAttachName attachName = EAttachName.getMap().get(
                        EAttachName.assurance_id_front.getCode());
                attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                        attachName.getValue(), child.getIdFront());
                // 身份证反面
                attachName = EAttachName.getMap().get(
                        EAttachName.assurance_id_reverse.getCode());
                attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                        attachName.getValue(), child.getIdReverse());
                // 征信查询授权
                attachName = EAttachName.getMap().get(
                        EAttachName.assurance_auth_pdf.getCode());
                attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                        attachName.getValue(), child.getAuthPdf());
                // 面签照片
                attachName = EAttachName.getMap().get(
                        EAttachName.assurance_interview_pic.getCode());
                attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                        attachName.getValue(), child.getInterviewPic());

                creditUser.setIsFirstGua(EBoolean.YES.getCode());
            }
        }

        creditUserDAO.insert(creditUser);
    }

    @Override
    public void removeCreditUserByBizCode(String bizCode) {
        CreditUser creditUser = new CreditUser();
        creditUser.setBizCode(bizCode);
        List<CreditUser> list = creditUserDAO.selectList(creditUser);
        for (CreditUser data : list) {
            creditUserDAO.delete(data);
        }
    }

    @Override
    public void refreshCreditUserLoanRole(CreditUser creditUser) {
        creditUserDAO.updateCreditUser(creditUser);
    }

    @Override
    public CreditUser getCreditUser(String code) {

        CreditUser data = null;
        if (StringUtils.isNotBlank(code)) {
            CreditUser creditUser = new CreditUser();
            creditUser.setCode(code);
            data = creditUserDAO.select(creditUser);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "征信人员不存在!");
            }
        }
        return data;
    }

    @Override
    public CreditUser getCreditUserUncheck(String code) {

        CreditUser data = null;
        if (StringUtils.isNotBlank(code)) {
            CreditUser creditUser = new CreditUser();
            creditUser.setCode(code);
            data = creditUserDAO.select(creditUser);
        }
        return data;
    }

    @Override
    public void inputBankCreditResult(CreditUser creditUser,
            XN632111ReqCreditUser reqCreditUser) {
        if (StringUtils.isNotBlank(creditUser.getCode())) {
            creditUser.setCreditCardOccupation(StringValidater
                    .toDouble(reqCreditUser.getCreditCardOccupation()));
            creditUser.setBankCreditResult(reqCreditUser.getBankResult());
            creditUser.setBankCreditResultRemark(reqCreditUser.getCreditNote());
            creditUser.setCreditCardOccupation(StringValidater
                    .toDouble(reqCreditUser.getCreditCardOccupation()));

            creditUserDAO.inputBankCreditResult(creditUser);
        }
    }

    @Override
    public List<CreditUser> queryCreditUserList(CreditUser condition) {

        return creditUserDAO.selectList(condition);
    }

    @Override
    public List<CreditUser> queryCreditUserList(String bizCode) {
        CreditUser condition = new CreditUser();
        condition.setBizCode(bizCode);
        List<CreditUser> list = creditUserDAO.selectList(condition);

        for (CreditUser creditUser : list) {
            List<Attachment> attachments = attachmentBO
                    .queryBizAttachments(creditUser.getCode());
            creditUser.setAttachments(attachments);
        }
        return list;
    }

    @Override
    public CreditUser getCreditUserByBizCode(String bizCode,
            ECreditUserLoanRole creditUserLoanRole) {
        CreditUser creditUser = null;
        CreditUser condition = new CreditUser();
        condition.setBizCode(bizCode);
        condition.setLoanRole(creditUserLoanRole.getCode());

        List<CreditUser> list = creditUserDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            creditUser = list.get(0);
        }
        return creditUser;
    }

    @Override
    public void refreshCreditUser(CreditUser data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            creditUserDAO.updateCreditUser(data);
        }
    }

    @Override
    public void refreshCreditUsers(List<CreditUser> creditUsers, XN632500Req req) {
        for (CreditUser creditUser : creditUsers) {
            if (ECreditUserLoanRole.APPLY_USER.getCode().equals(
                    creditUser.getLoanRole())) {
                creditUser.setBirthAddress(req.getResidenceAddress());
                creditUser.setBirthPostCode(req.getPostCode2());
                creditUser.setCompanyName(req.getWorkCompanyName());
                creditUser.setCompanyAddress(req.getWorkCompanyAddress());
                creditUser.setCompanyContactNo(req.getWorkPhone());
            } else if (ECreditUserLoanRole.GHR.getCode().equals(
                    creditUser.getLoanRole())) {
                creditUser.setBirthAddressProvince(req
                        .getMateBirthAddressProvince());
                creditUser.setBirthAddressCity(req.getMateBirthAddressCity());
                creditUser.setBirthAddressArea(req.getMateBirthAddressArea());
                creditUser.setBirthAddress(req.getMateBirthAddress());
                creditUser.setBirthPostCode(req.getMatePostCode());
                creditUser.setEducation(req.getMateEducation());
                creditUser.setCompanyName(req.getMateCompanyName());
                creditUser.setCompanyAddress(req.getMateCompanyAddress());
                creditUser.setCompanyContactNo(req.getMateCompanyContactNo());
            } else {
                creditUser.setBirthAddressProvince(req
                        .getGuaBirthAddressProvince());
                creditUser.setBirthAddressCity(req.getGuaBirthAddressCity());
                creditUser.setBirthAddressArea(req.getGuaBirthAddressArea());
                creditUser.setBirthAddress(req.getGuaBirthAddress());
                creditUser.setBirthPostCode(req.getGuaPostCode());
                creditUser.setEducation(req.getGuaEducation());
                creditUser.setCompanyName(req.getGuaCompanyName());
                creditUser.setCompanyAddress(req.getGuaCompanyAddress());
                creditUser.setCompanyContactNo(req.getGuaCompanyContactNo());
            }
            creditUserDAO.updateCreditUser(creditUser);
        }
    }

    @Override
    public int refreshIcbankCredit(CreditUser data, CreditIcbank creditIcbank) {
        int count = 0;
        data.setStatus(ECreditUserStatus.done.getCode());
        data.setResult(creditIcbank.getResult());
        data.setLoanCrdt(creditIcbank.getLoanCrdt());
        data.setCardCrdt(creditIcbank.getCardCrdt());
        data.setLeftNum(StringValidater.toLong(creditIcbank.getLeftNum()));
        data.setLeftAmount(StringValidater.toLong(creditIcbank.getLeftAmount()));
        data.setNote(creditIcbank.getNote());
        count = creditUserDAO.updateIcbankCredit(data);
        return count;
    }

    @Override
    public CreditIcbank getCreditIcbank(String icbankCode) {
        CreditIcbank creditIcbank = null;
        XN632114Req req = new XN632114Req();
        req.setCode(icbankCode);
        try {
            creditIcbank = BizConnecter.getBizData("798701",
                    JsonUtils.object2Json(req), CreditIcbank.class);

        } catch (Exception e) {
            logger.info("工行征信结果查询服务异常");
        }
        return creditIcbank;
    }

    private String getSexByIdNo(String idNo) {
        /**
         * 根据身份编号获取性别
         * @param idCard 身份编号
         * @return 性别(M - 男 ， F - 女 ， N - 未知)
         */
        String sGender = null;

        String sCardNum = idNo.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "男";
        } else {
            sGender = "女";
        }
        return sGender;
    }

    private String getBirthYearByIdNo(String idNo) {
        /**
         * 根据身份编号获取生日
         * @param idCard 身份编号
         * @return 生日(yyyyMMdd)
         */
        String birth = idNo.substring(6, 10);
        return birth;
    }

    @Override
    public BodyGuardWZHYResponse getTongdunResult(CreditUser creditUser) {
        BodyGuardWZHYResponse result=null;
        XN798600Req req=new XN798600Req();
        req.setIdNumber(creditUser.getIdNo());
        req.setAccountMobile(creditUser.getMobile());
        req.setAccountName(creditUser.getUserName());
        req.setSystemCode("CD-TDUN00030");
        req.setCompanyCode("CD-TDUN00030");
        try {
            result= BizConnecter.getBizData("798600", JsonUtils.object2Json(req),BodyGuardWZHYResponse.class);

              //转json储存在数据库
              creditUser.setTongdunResult(JsonUtil.Object2Json(result));
              creditUserDAO.updateTongdun(creditUser);
        }catch (Exception e) {
            logger.info("同盾结果返回异常");
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),"同盾结果返回异常");

        }

        return  result;
    }
}
