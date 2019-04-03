package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICdbizDAO;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class CdbizBOImpl extends PaginableBOImpl<Cdbiz> implements ICdbizBO {

    @Autowired
    private ICdbizDAO cdbizDAO;

    @Override
    public boolean isCdbizExist(String code) {
        Cdbiz condition = new Cdbiz();
        condition.setCode(code);
        if (cdbizDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int removeCdbiz(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Cdbiz data = new Cdbiz();
            data.setCode(code);
            count = cdbizDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<Cdbiz> queryCdbizList(Cdbiz condition) {
        return cdbizDAO.selectList(condition);
    }

    @Override
    public Cdbiz getCdbiz(String code) {
        Cdbiz data = null;
        if (StringUtils.isNotBlank(code)) {
            Cdbiz condition = new Cdbiz();
            condition.setCode(code);
            data = cdbizDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public String saveCdbiz(String bankCode, String bizType, Long dkAmount,
            String ywyUser, String teamCode) {
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.Cdbiz.getCode());
        Cdbiz cdbiz = new Cdbiz();
        cdbiz.setCode(code);
        cdbiz.setBankCode(bankCode);
        cdbiz.setBizType(bizType);
        cdbiz.setDkAmount(dkAmount);
        cdbiz.setStatus(ECdbizStatus.A1.getCode());
        cdbiz.setZfStatus("0");
        cdbiz.setYwyUser(ywyUser);
        cdbiz.setTeamCode(teamCode);
        cdbizDAO.insert(cdbiz);
        return code;
    }

    @Override
    public int refreshCdbiz(Cdbiz data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void refreshStatus(Cdbiz cdbiz, String status) {
        cdbiz.setStatus(status);
        cdbizDAO.updateStatus(cdbiz);
    }
}
