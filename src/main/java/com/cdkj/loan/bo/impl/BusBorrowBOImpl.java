package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBusBorrowBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBusBorrowDAO;
import com.cdkj.loan.domain.BusBorrow;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BusBorrowBOImpl extends PaginableBOImpl<BusBorrow>
        implements IBusBorrowBO {

    @Autowired
    private IBusBorrowDAO busBorrowDAO;

    public String saveBusBorrow(BusBorrow data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BUSBORROW.getCode());
            data.setCode(code);
            busBorrowDAO.insert(data);
        }
        return code;
    }

    @Override
    public void auditBusBorrow(BusBorrow condition) {
        busBorrowDAO.updateStatus(condition);
    }

    @Override
    public void returnBusBorrow(BusBorrow condition) {
        busBorrowDAO.returnBusBorrow(condition);
    }

    @Override
    public void auditBusBorrowReturn(BusBorrow condition) {
        busBorrowDAO.auditBusBorrowReturn(condition);
    }

    @Override
    public List<BusBorrow> queryBusBorrowList(BusBorrow condition) {
        return busBorrowDAO.selectList(condition);
    }

    @Override
    public BusBorrow getBusBorrow(String code) {
        BusBorrow data = null;
        if (StringUtils.isNotBlank(code)) {
            BusBorrow condition = new BusBorrow();
            condition.setCode(code);
            data = busBorrowDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

}
