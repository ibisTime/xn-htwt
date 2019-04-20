package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.NumberUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditJourDAO;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.dto.req.XN632490Req;
import com.cdkj.loan.dto.req.XN632492Req;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class CreditJourBOImpl extends PaginableBOImpl<CreditJour>
        implements ICreditJourBO {

    @Autowired
    private ICreditJourDAO creditJourDAO;

    @Override
    public String saveCreditJour(XN632490Req req) {
        CreditJour data = new CreditJour();
        BeanUtils.copyProperties(req, data);

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.CREDIT_JOUR.getCode());
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
        BeanUtils.copyProperties(req, data);

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
}
