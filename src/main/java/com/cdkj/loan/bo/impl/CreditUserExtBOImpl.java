package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.ICreditUserExtBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditUserExtDAO;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.dto.req.XN632480Req;
import com.cdkj.loan.dto.req.XN632482Req;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ELoanRole;
import com.cdkj.loan.exception.BizException;

@Component
public class CreditUserExtBOImpl extends PaginableBOImpl<CreditUserExt>
        implements ICreditUserExtBO {

    @Autowired
    private ICreditUserExtDAO creditUserExtDAO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Override
    public String saveCreditUserExt(XN632480Req req) {

        CreditUserExt data = EntityUtils.copyData(req, CreditUserExt.class);

        String code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT_USER_EXT
            .getCode());
        data.setCode(code);
        creditUserExtDAO.insert(data);

        return code;

    }

    @Override
    public void removeCreditUserExt(String code) {
        if (StringUtils.isNotBlank(code)) {
            CreditUserExt data = new CreditUserExt();
            data.setCode(code);
            creditUserExtDAO.delete(data);
        }
    }

    @Override
    public void refreshCreditUserExt(XN632482Req req) {
        CreditUserExt data = EntityUtils.copyData(req, CreditUserExt.class);

        creditUserExtDAO.update(data);
    }

    @Override
    public List<CreditUserExt> queryCreditUserExtList(CreditUserExt condition) {
        return creditUserExtDAO.selectList(condition);
    }

    @Override
    public CreditUserExt getCreditUserExt(String code) {
        CreditUserExt data = null;
        if (StringUtils.isNotBlank(code)) {
            CreditUserExt condition = new CreditUserExt();
            condition.setCode(code);
            data = creditUserExtDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "征信人辅助资料不存在");
            }
        }
        return data;
    }

    @Override
    public String saveCreditUserExt(CreditUserExt data, String bizCode) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT_USER_EXT
            .getCode());
        data.setCode(code);
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(bizCode,
            ELoanRole.APPLY_USER);
        data.setCreditUserCode(creditUser.getCode());
        creditUserExtDAO.insert(data);
        return code;
    }

    @Override
    public void removeBizUserExt(String bizCode) {
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(bizCode,
            ELoanRole.APPLY_USER);
        CreditUserExt condition = new CreditUserExt();
        condition.setCreditUserCode(creditUser.getCode());
        CreditUserExt creditUserExt = creditUserExtDAO.select(condition);
        if (null != creditUserExt) {
            creditUserExtDAO.delete(creditUserExt);
        }
    }

    @Override
    public CreditUserExt getCreditUserExtByBizCode(String bizCode) {
        CreditUser creditUser = creditUserBO.getCreditUserByBizCode(bizCode,
            ELoanRole.APPLY_USER);
        if (null != creditUser) {
            CreditUserExt condition = new CreditUserExt();
            condition.setCreditUserCode(creditUser.getCode());
            CreditUserExt creditUserExt = creditUserExtDAO.select(condition);
            return creditUserExt;
        } else {
            return null;
        }
    }
}
