package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBizOrderBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBizOrderDAO;
import com.cdkj.loan.domain.BizOrder;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class BizOrderBOImpl extends PaginableBOImpl<BizOrder> implements
        IBizOrderBO {

    @Autowired
    private IBizOrderDAO bizOrderDAO;

    @Override
    public boolean isBizOrderExist(String code) {
        BizOrder condition = new BizOrder();
        condition.setCode(code);
        if (bizOrderDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBizOrder(BizOrder data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.BIZ_ORDER
                .getCode());
            data.setCode(code);
            bizOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBizOrder(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BizOrder data = new BizOrder();
            data.setCode(code);
            count = bizOrderDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBizOrder(BizOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bizOrderDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BizOrder> queryBizOrderList(BizOrder condition) {
        return bizOrderDAO.selectList(condition);
    }

    @Override
    public BizOrder getBizOrder(String code) {
        BizOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            BizOrder condition = new BizOrder();
            condition.setCode(code);
            data = bizOrderDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
