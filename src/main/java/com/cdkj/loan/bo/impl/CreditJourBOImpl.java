package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.EntityUtils;
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

        data.setInterest1(StringValidater.toLong(req.getInterest1()));
        data.setInterest2(StringValidater.toLong(req.getInterest2()));
        data.setIncome(StringValidater.toLong(req.getIncome()));
        data.setExpend(StringValidater.toLong(req.getExpend()));
        data.setBalance(StringValidater.toLong(req.getBalance()));

        data.setMonthIncome(StringValidater.toLong(req.getMonthIncome()));
        data.setMonthExpend(StringValidater.toLong(req.getMonthExpend()));
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
        CreditJour data = getCreditJour(req.getCode());
        EntityUtils.copyData(req, data);

        data.setDatetimeStart(DateUtil.strToDate(req.getDatetimeStart(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDatetimeEnd(DateUtil.strToDate(req.getDatetimeEnd(),
                DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setInterest1(StringValidater.toLong(req.getInterest1()));
        data.setInterest2(StringValidater.toLong(req.getInterest2()));
        data.setIncome(StringValidater.toLong(req.getIncome()));
        data.setExpend(StringValidater.toLong(req.getExpend()));
        data.setBalance(StringValidater.toLong(req.getBalance()));

        data.setMonthIncome(StringValidater.toLong(req.getMonthIncome()));
        data.setMonthExpend(StringValidater.toLong(req.getMonthExpend()));
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
            if (ECreditUserLoanRole.APPLY_USER.getCode().equals(
                    creditUser.getLoanRole())) {
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
                creditJour.setJourInterest1(StringValidater.toLong(req
                        .getWxJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toLong(req
                        .getWxJourInterest2()));
                creditJour.setInterest1(StringValidater.toLong(req
                        .getWxInterest1()));
                creditJour.setInterest2(StringValidater.toLong(req
                        .getWxInterest2()));
                creditJour.setIncome(StringValidater.toLong(req
                        .getWxJourIncome()));
                creditJour.setExpend(StringValidater.toLong(req
                        .getWxJourExpend()));
                creditJour.setBalance(StringValidater.toLong(req
                        .getWxJourBalance()));
                creditJour.setMonthIncome(StringValidater.toLong(req
                        .getWxJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toLong(req
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
                creditJour.setJourInterest1(StringValidater.toLong(req
                        .getZfbJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toLong(req
                        .getZfbJourInterest2()));
                creditJour.setInterest1(StringValidater.toLong(req
                        .getZfbInterest1()));
                creditJour.setInterest2(StringValidater.toLong(req
                        .getZfbInterest2()));
                creditJour.setIncome(StringValidater.toLong(req
                        .getZfbJourIncome()));
                creditJour.setExpend(StringValidater.toLong(req
                        .getZfbJourExpend()));
                creditJour.setBalance(StringValidater.toLong(req
                        .getZfbJourBalance()));
                creditJour.setMonthIncome(StringValidater.toLong(req
                        .getZfbJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toLong(req
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
                creditJour.setJourInterest1(StringValidater.toLong(req
                        .getJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toLong(req
                        .getJourInterest2()));
                creditJour.setInterest1(StringValidater.toLong(req
                        .getInterest1()));
                creditJour.setInterest2(StringValidater.toLong(req
                        .getInterest2()));
                creditJour.setIncome(StringValidater.toLong(req
                        .getJourIncome()));
                creditJour.setExpend(StringValidater.toLong(req
                        .getJourExpend()));
                creditJour.setBalance(StringValidater.toLong(req
                        .getJourBalance()));
                creditJour.setMonthIncome(StringValidater.toLong(req
                        .getJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toLong(req
                        .getJourMonthExpend()));
                creditJour.setPic(req.getJourPic());
                creditJour.setRemark(req.getJourRemark());
                creditJourDAO.insert(creditJour);
                // 共还人=配偶
            } else if (ECreditUserLoanRole.GHR.getCode().equals(
                    creditUser.getLoanRole())) {
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
                creditJour.setJourInterest1(StringValidater.toLong(req
                        .getMateWxJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toLong(req
                        .getMateWxJourInterest2()));
                creditJour.setInterest1(StringValidater.toLong(req
                        .getMateWxInterest1()));
                creditJour.setInterest2(StringValidater.toLong(req
                        .getMateWxInterest2()));
                creditJour.setIncome(StringValidater.toLong(req
                        .getMateWxJourIncome()));
                creditJour.setExpend(StringValidater.toLong(req
                        .getMateWxJourExpend()));
                creditJour.setBalance(StringValidater.toLong(req
                        .getMateWxJourBalance()));
                creditJour.setMonthIncome(StringValidater.toLong(req
                        .getMateWxJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toLong(req
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
                creditJour.setJourInterest1(StringValidater.toLong(req
                        .getMateZfbJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toLong(req
                        .getMateZfbJourInterest2()));
                creditJour.setInterest1(StringValidater.toLong(req
                        .getMateZfbInterest1()));
                creditJour.setInterest2(StringValidater.toLong(req
                        .getMateZfbInterest2()));
                creditJour.setIncome(StringValidater.toLong(req
                        .getMateZfbJourIncome()));
                creditJour.setExpend(StringValidater.toLong(req
                        .getMateZfbJourExpend()));
                creditJour.setBalance(StringValidater.toLong(req
                        .getMateZfbJourBalance()));
                creditJour.setMonthIncome(StringValidater.toLong(req
                        .getMateZfbJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toLong(req
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
                creditJour.setJourInterest1(StringValidater.toLong(req
                        .getMateJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toLong(req
                        .getMateJourInterest2()));
                creditJour.setInterest1(StringValidater.toLong(req
                        .getMateInterest1()));
                creditJour.setInterest2(StringValidater.toLong(req
                        .getMateInterest2()));
                creditJour.setIncome(StringValidater.toLong(req
                        .getMateJourIncome()));
                creditJour.setExpend(StringValidater.toLong(req
                        .getMateJourExpend()));
                creditJour.setBalance(StringValidater.toLong(req
                        .getMateJourBalance()));
                creditJour.setMonthIncome(StringValidater.toLong(req
                        .getMateJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toLong(req
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
                creditJour.setJourInterest1(StringValidater.toLong(req
                        .getGuaWxJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toLong(req
                        .getGuaWxJourInterest2()));
                creditJour.setInterest1(StringValidater.toLong(req
                        .getGuaWxInterest1()));
                creditJour.setInterest2(StringValidater.toLong(req
                        .getGuaWxInterest2()));
                creditJour.setIncome(StringValidater.toLong(req
                        .getGuaWxJourIncome()));
                creditJour.setExpend(StringValidater.toLong(req
                        .getGuaWxJourExpend()));
                creditJour.setBalance(StringValidater.toLong(req
                        .getGuaWxJourBalance()));
                creditJour.setMonthIncome(StringValidater.toLong(req
                        .getGuaWxJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toLong(req
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
                creditJour.setJourInterest1(StringValidater.toLong(req
                        .getGuaZfbJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toLong(req
                        .getGuaZfbJourInterest2()));
                creditJour.setInterest1(StringValidater.toLong(req
                        .getGuaZfbInterest1()));
                creditJour.setInterest2(StringValidater.toLong(req
                        .getGuaZfbInterest2()));
                creditJour.setIncome(StringValidater.toLong(req
                        .getGuaZfbJourIncome()));
                creditJour.setExpend(StringValidater.toLong(req
                        .getGuaZfbJourExpend()));
                creditJour.setBalance(StringValidater.toLong(req
                        .getGuaZfbJourBalance()));
                creditJour.setMonthIncome(StringValidater.toLong(req
                        .getGuaZfbJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toLong(req
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
                creditJour.setJourInterest1(StringValidater.toLong(req
                        .getGuaJourInterest1()));
                creditJour.setJourInterest2(StringValidater.toLong(req
                        .getGuaJourInterest2()));
                creditJour.setInterest1(StringValidater.toLong(req
                        .getGuaInterest1()));
                creditJour.setInterest2(StringValidater.toLong(req
                        .getGuaInterest2()));
                creditJour.setIncome(StringValidater.toLong(req
                        .getGuaJourIncome()));
                creditJour.setExpend(StringValidater.toLong(req
                        .getGuaJourExpend()));
                creditJour.setBalance(StringValidater.toLong(req
                        .getGuaJourBalance()));
                creditJour.setMonthIncome(StringValidater.toLong(req
                        .getGuaJourMonthIncome()));
                creditJour.setMonthExpend(StringValidater.toLong(req
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
    public List<CreditJour> getCreditJourByCondition(String bizCode,
            String creditUserCode) {
        CreditJour condition = new CreditJour();
        condition.setBizCode(bizCode);
        condition.setCreditUserCode(creditUserCode);
        List<CreditJour> jours = creditJourDAO.selectList(condition);
        return jours;
    }

    @Override
    public void saveCreditJourList(List<CreditJour> jourList) {
        creditJourDAO.insertList(jourList);
    }
}
