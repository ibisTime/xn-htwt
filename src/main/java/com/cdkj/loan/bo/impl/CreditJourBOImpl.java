package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.NumberUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.ICreditJourDAO;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632490Req;
import com.cdkj.loan.dto.req.XN632492Req;
import com.cdkj.loan.enums.ECreditJourType;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditJourBOImpl extends PaginableBOImpl<CreditJour> implements
        ICreditJourBO {

    @Autowired
    private ICreditJourDAO creditJourDAO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Override
    public String saveCreditJour(XN632490Req req) {
        CreditJour data = new CreditJour();
        EntityUtils.copyData(req, data);

        String code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT_JOUR
                .getCode());
        data.setCode(code);

        data.setDatetimeStart(DateUtil.strToDate(req.getDatetimeStart(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDatetimeEnd(DateUtil.strToDate(req.getDatetimeEnd(),
                DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setInterest1(NumberUtil.parseInt(req.getInterest1()));
        data.setInterest2(NumberUtil.parseInt(req.getInterest2()));
        data.setIncome(NumberUtil.parseInt(req.getIncome()));
        data.setExpend(NumberUtil.parseInt(req.getExpend()));
        data.setBalance(NumberUtil.parseInt(req.getBalance()));

        data.setMonthIncome(NumberUtil.parseInt(req.getMonthIncome()));
        data.setMonthExpend(NumberUtil.parseInt(req.getMonthExpend()));
        data.setPic(req.getPic());
        data.setRemark(req.getRemark());

        creditJourDAO.insert(data);
        return code;
    }

    @Override
    public void removeCreditJour(String code) {
        if (StringUtils.isNotBlank(code)) {
            CreditJour data = new CreditJour();
            data.setCode(code);
            creditJourDAO.delete(data);
        }
    }

    @Override
    public void refreshCreditJour(XN632492Req req) {
        CreditJour data = new CreditJour();
        EntityUtils.copyData(req, data);

        data.setDatetimeStart(DateUtil.strToDate(req.getDatetimeStart(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDatetimeEnd(DateUtil.strToDate(req.getDatetimeEnd(),
                DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setInterest1(NumberUtil.parseInt(req.getInterest1()));
        data.setInterest2(NumberUtil.parseInt(req.getInterest2()));
        data.setIncome(NumberUtil.parseInt(req.getIncome()));
        data.setExpend(NumberUtil.parseInt(req.getExpend()));
        data.setBalance(NumberUtil.parseInt(req.getBalance()));

        data.setMonthIncome(NumberUtil.parseInt(req.getMonthIncome()));
        data.setMonthExpend(NumberUtil.parseInt(req.getMonthExpend()));
        data.setPic(req.getPic());
        data.setRemark(req.getRemark());

        creditJourDAO.update(data);
    }

    @Override
    public List<CreditJour> queryCreditJourList(CreditJour condition) {
        return creditJourDAO.selectList(condition);
    }

    @Override
    public CreditJour getCreditJour(String code) {
        CreditJour data = null;
        if (StringUtils.isNotBlank(code)) {
            CreditJour condition = new CreditJour();
            condition.setCode(code);
            data = creditJourDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "征信流水不存在");
            }
        }
        return data;
    }

    @Override
    public void saveCreditJour(XN632120Req req) {
        List<CreditUser> creditUsers = creditUserBO.queryCreditUserList(req
                .getCode());
        for (CreditUser creditUser : creditUsers) {
            // 主贷人
            if (ECreditUserLoanRole.APPLY_USER.getCode().equals(creditUser.getLoanRole())) {
                CreditJour creditJour = new CreditJour();
                String code = OrderNoGenerater
                        .generate(EGeneratePrefix.CREDIT_JOUR.getCode());
                // 微信流水
                creditJour.setCode(code);
                creditJour.setBizCode(req.getCode());
                creditJour.setCreditUserCode(creditUser.getCode());
                creditJour.setType(ECreditJourType.wx.getCode());
                creditJour.setDatetimeStart(DateUtil.strToDate(
                        req.getWxJourDatetimeStart(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour
                        .setDatetimeEnd(DateUtil.strToDate(
                                req.getWxJourDatetimeEnd(),
                                DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setJourInterest1(StringValidater.toInteger(req
                        .getWxJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toInteger(req
                        .getWxJourInterest2()));
                creditJour.setInterest1(StringValidater.toInteger(req
                        .getWxInterest1()));
                creditJour.setInterest2(StringValidater.toInteger(req
                        .getWxInterest2()));
                creditJour.setIncome(StringValidater.toInteger(req
                        .getWxJourIncome()));
                creditJour.setExpend(StringValidater.toInteger(req
                        .getWxJourExpend()));
                creditJour.setBalance(StringValidater.toInteger(req
                        .getWxJourBalance()));
                creditJour.setMonthIncome(StringValidater.toInteger(req
                        .getWxJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toInteger(req
                        .getWxJourMonthExpend()));
                creditJour.setPic(req.getWxJourPic());
                creditJour.setRemark(req.getWxJourRemark());
                creditJourDAO.insert(creditJour);
                // 支付宝流水
                code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT_JOUR
                        .getCode());
                creditJour.setCode(code);
                creditJour.setBizCode(req.getCode());
                creditJour.setCreditUserCode(creditUser.getCode());
                creditJour.setType(ECreditJourType.zfb.getCode());
                creditJour.setDatetimeStart(DateUtil.strToDate(
                        req.getZfbJourDatetimeStart(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour
                        .setDatetimeEnd(DateUtil.strToDate(
                                req.getZfbJourDatetimeEnd(),
                                DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setJourInterest1(StringValidater.toInteger(req
                        .getZfbJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toInteger(req
                        .getZfbJourInterest2()));
                creditJour.setInterest1(StringValidater.toInteger(req
                        .getZfbInterest1()));
                creditJour.setInterest2(StringValidater.toInteger(req
                        .getZfbInterest2()));
                creditJour.setIncome(StringValidater.toInteger(req
                        .getZfbJourIncome()));
                creditJour.setExpend(StringValidater.toInteger(req
                        .getZfbJourExpend()));
                creditJour.setBalance(StringValidater.toInteger(req
                        .getZfbJourBalance()));
                creditJour.setMonthIncome(StringValidater.toInteger(req
                        .getZfbJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toInteger(req
                        .getZfbJourMonthExpend()));
                creditJour.setPic(req.getZfbJourPic());
                creditJour.setRemark(req.getZfbJourRemark());
                creditJourDAO.insert(creditJour);
                // 银行流水
                code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT_JOUR
                        .getCode());
                creditJour.setCode(code);
                creditJour.setBizCode(req.getCode());
                creditJour.setCreditUserCode(creditUser.getCode());
                creditJour.setType(ECreditJourType.bank.getCode());
                creditJour
                        .setDatetimeStart(DateUtil.strToDate(
                                req.getJourDatetimeStart(),
                                DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setDatetimeEnd(DateUtil.strToDate(
                        req.getJourDatetimeEnd(), DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setJourInterest1(StringValidater.toInteger(req
                        .getJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toInteger(req
                        .getJourInterest2()));
                creditJour.setInterest1(StringValidater.toInteger(req
                        .getInterest1()));
                creditJour.setInterest2(StringValidater.toInteger(req
                        .getInterest2()));
                creditJour.setIncome(StringValidater.toInteger(req
                        .getJourIncome()));
                creditJour.setExpend(StringValidater.toInteger(req
                        .getJourExpend()));
                creditJour.setBalance(StringValidater.toInteger(req
                        .getJourBalance()));
                creditJour.setMonthIncome(StringValidater.toInteger(req
                        .getJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toInteger(req
                        .getJourMonthExpend()));
                creditJour.setPic(req.getJourPic());
                creditJour.setRemark(req.getJourRemark());
                creditJourDAO.insert(creditJour);
                // 共还人=配偶
            } else if (ECreditUserLoanRole.GHR.getCode().equals(creditUser.getLoanRole())) {
                CreditJour creditJour = new CreditJour();
                String code = OrderNoGenerater
                        .generate(EGeneratePrefix.CREDIT_JOUR.getCode());
                // 微信流水
                creditJour.setCode(code);
                creditJour.setBizCode(req.getCode());
                creditJour.setCreditUserCode(creditUser.getCode());
                creditJour.setType(ECreditJourType.wx.getCode());
                creditJour.setDatetimeStart(DateUtil.strToDate(
                        req.getMateWxJourDatetimeStart(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setDatetimeEnd(DateUtil.strToDate(
                        req.getMateWxJourDatetimeEnd(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setJourInterest1(StringValidater.toInteger(req
                        .getMateWxJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toInteger(req
                        .getMateWxJourInterest2()));
                creditJour.setInterest1(StringValidater.toInteger(req
                        .getMateWxInterest1()));
                creditJour.setInterest2(StringValidater.toInteger(req
                        .getMateWxInterest2()));
                creditJour.setIncome(StringValidater.toInteger(req
                        .getMateWxJourIncome()));
                creditJour.setExpend(StringValidater.toInteger(req
                        .getMateWxJourExpend()));
                creditJour.setBalance(StringValidater.toInteger(req
                        .getMateWxJourBalance()));
                creditJour.setMonthIncome(StringValidater.toInteger(req
                        .getMateWxJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toInteger(req
                        .getMateWxJourMonthExpend()));
                creditJour.setPic(req.getMateWxJourPic());
                creditJour.setRemark(req.getMateWxJourRemark());
                creditJourDAO.insert(creditJour);
                // 支付宝流水
                code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT_JOUR
                        .getCode());
                creditJour.setCode(code);
                creditJour.setBizCode(req.getCode());
                creditJour.setCreditUserCode(creditUser.getCode());
                creditJour.setType(ECreditJourType.zfb.getCode());
                creditJour.setDatetimeStart(DateUtil.strToDate(
                        req.getMateZfbJourDatetimeStart(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setDatetimeEnd(DateUtil.strToDate(
                        req.getMateZfbJourDatetimeEnd(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setJourInterest1(StringValidater.toInteger(req
                        .getMateZfbJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toInteger(req
                        .getMateZfbJourInterest2()));
                creditJour.setInterest1(StringValidater.toInteger(req
                        .getMateZfbInterest1()));
                creditJour.setInterest2(StringValidater.toInteger(req
                        .getMateZfbInterest2()));
                creditJour.setIncome(StringValidater.toInteger(req
                        .getMateZfbJourIncome()));
                creditJour.setExpend(StringValidater.toInteger(req
                        .getMateZfbJourExpend()));
                creditJour.setBalance(StringValidater.toInteger(req
                        .getMateZfbJourBalance()));
                creditJour.setMonthIncome(StringValidater.toInteger(req
                        .getMateZfbJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toInteger(req
                        .getMateZfbJourMonthExpend()));
                creditJour.setPic(req.getMateZfbJourPic());
                creditJour.setRemark(req.getMateZfbJourRemark());
                creditJourDAO.insert(creditJour);
                // 银行流水
                code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT_JOUR
                        .getCode());
                creditJour.setCode(code);
                creditJour.setBizCode(req.getCode());
                creditJour.setCreditUserCode(creditUser.getCode());
                creditJour.setType(ECreditJourType.bank.getCode());
                creditJour.setDatetimeStart(DateUtil.strToDate(
                        req.getMateJourDatetimeStart(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setDatetimeEnd(DateUtil.strToDate(
                        req.getMateJourDatetimeEnd(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setJourInterest1(StringValidater.toInteger(req
                        .getMateJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toInteger(req
                        .getMateJourInterest2()));
                creditJour.setInterest1(StringValidater.toInteger(req
                        .getMateInterest1()));
                creditJour.setInterest2(StringValidater.toInteger(req
                        .getMateInterest2()));
                creditJour.setIncome(StringValidater.toInteger(req
                        .getMateJourIncome()));
                creditJour.setExpend(StringValidater.toInteger(req
                        .getMateJourExpend()));
                creditJour.setBalance(StringValidater.toInteger(req
                        .getMateJourBalance()));
                creditJour.setMonthIncome(StringValidater.toInteger(req
                        .getMateJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toInteger(req
                        .getMateJourMonthExpend()));
                creditJour.setPic(req.getMateJourPic());
                creditJour.setRemark(req.getMateJourRemark());
                creditJourDAO.insert(creditJour);
                // 担保人
            } else {
                CreditJour creditJour = new CreditJour();
                String code = OrderNoGenerater
                        .generate(EGeneratePrefix.CREDIT_JOUR.getCode());
                // 微信流水
                creditJour.setCode(code);
                creditJour.setBizCode(req.getCode());
                creditJour.setCreditUserCode(creditUser.getCode());
                creditJour.setType(ECreditJourType.wx.getCode());
                creditJour.setDatetimeStart(DateUtil.strToDate(
                        req.getGuaWxJourDatetimeStart(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setDatetimeEnd(DateUtil.strToDate(
                        req.getGuaWxJourDatetimeEnd(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setJourInterest1(StringValidater.toInteger(req
                        .getGuaWxJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toInteger(req
                        .getGuaWxJourInterest2()));
                creditJour.setInterest1(StringValidater.toInteger(req
                        .getGuaWxInterest1()));
                creditJour.setInterest2(StringValidater.toInteger(req
                        .getGuaWxInterest2()));
                creditJour.setIncome(StringValidater.toInteger(req
                        .getGuaWxJourIncome()));
                creditJour.setExpend(StringValidater.toInteger(req
                        .getGuaWxJourExpend()));
                creditJour.setBalance(StringValidater.toInteger(req
                        .getGuaWxJourBalance()));
                creditJour.setMonthIncome(StringValidater.toInteger(req
                        .getGuaWxJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toInteger(req
                        .getGuaWxJourMonthExpend()));
                creditJour.setPic(req.getGuaWxJourPic());
                creditJour.setRemark(req.getGuaWxJourRemark());
                creditJourDAO.insert(creditJour);
                // 支付宝流水
                code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT_JOUR
                        .getCode());
                creditJour.setCode(code);
                creditJour.setBizCode(req.getCode());
                creditJour.setCreditUserCode(creditUser.getCode());
                creditJour.setType(ECreditJourType.zfb.getCode());
                creditJour.setDatetimeStart(DateUtil.strToDate(
                        req.getGuaZfbJourDatetimeStart(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setDatetimeEnd(DateUtil.strToDate(
                        req.getGuaZfbJourDatetimeEnd(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setJourInterest1(StringValidater.toInteger(req
                        .getGuaZfbJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toInteger(req
                        .getGuaZfbJourInterest2()));
                creditJour.setInterest1(StringValidater.toInteger(req
                        .getGuaZfbInterest1()));
                creditJour.setInterest2(StringValidater.toInteger(req
                        .getGuaZfbInterest2()));
                creditJour.setIncome(StringValidater.toInteger(req
                        .getGuaZfbJourIncome()));
                creditJour.setExpend(StringValidater.toInteger(req
                        .getGuaZfbJourExpend()));
                creditJour.setBalance(StringValidater.toInteger(req
                        .getGuaZfbJourBalance()));
                creditJour.setMonthIncome(StringValidater.toInteger(req
                        .getGuaZfbJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toInteger(req
                        .getGuaZfbJourMonthExpend()));
                creditJour.setPic(req.getGuaZfbJourPic());
                creditJour.setRemark(req.getGuaZfbJourRemark());
                creditJourDAO.insert(creditJour);
                // 银行流水
                code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT_JOUR
                        .getCode());
                creditJour.setCode(code);
                creditJour.setBizCode(req.getCode());
                creditJour.setCreditUserCode(creditUser.getCode());
                creditJour.setType(ECreditJourType.bank.getCode());
                creditJour.setDatetimeStart(DateUtil.strToDate(
                        req.getGuaJourDatetimeStart(),
                        DateUtil.DB_DATE_FORMAT_STRING));
                creditJour
                        .setDatetimeEnd(DateUtil.strToDate(
                                req.getGuaJourDatetimeEnd(),
                                DateUtil.DB_DATE_FORMAT_STRING));
                creditJour.setJourInterest1(StringValidater.toInteger(req
                        .getGuaJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toInteger(req
                        .getGuaJourInterest2()));
                creditJour.setInterest1(StringValidater.toInteger(req
                        .getGuaInterest1()));
                creditJour.setInterest2(StringValidater.toInteger(req
                        .getGuaInterest2()));
                creditJour.setIncome(StringValidater.toInteger(req
                        .getGuaJourIncome()));
                creditJour.setExpend(StringValidater.toInteger(req
                        .getGuaJourExpend()));
                creditJour.setBalance(StringValidater.toInteger(req
                        .getGuaJourBalance()));
                creditJour.setMonthIncome(StringValidater.toInteger(req
                        .getGuaJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toInteger(req
                        .getGuaJourMonthExpend()));
                creditJour.setPic(req.getGuaJourPic());
                creditJour.setRemark(req.getGuaJourRemark());
                creditJourDAO.insert(creditJour);
            }
        }

    }

    @Override
    public void removeBizJour(String bizCode) {
        CreditJour condition = new CreditJour();
        condition.setBizCode(bizCode);
        List<CreditJour> jours = queryCreditJourList(condition);
        if (!jours.isEmpty()) {
            for (CreditJour creditJour : jours) {
                creditJourDAO.delete(creditJour);
            }
        }
    }

    @Override
    public List<CreditJour> querCreditJoursByBizCode(String bizCode) {
        CreditJour condition = new CreditJour();
        condition.setBizCode(bizCode);
        List<CreditJour> jours = queryCreditJourList(condition);
        return jours;
    }

    @Override
    public CreditJour getCreditJourByCondition(String bizCode, String creditUserCode) {
        CreditJour condition = new CreditJour();
        condition.setBizCode(bizCode);
        condition.setCreditUserCode(creditUserCode);
        CreditJour jour = creditJourDAO.select(condition);
        return jour;
    }

    @Override
    public void saveCreditJourList(List<CreditJour> jourList) {
        creditJourDAO.insertList(jourList);
    }
}
