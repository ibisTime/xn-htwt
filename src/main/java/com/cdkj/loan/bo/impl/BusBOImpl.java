package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBusBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBusDAO;
import com.cdkj.loan.domain.Bus;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BusBOImpl extends PaginableBOImpl<Bus> implements IBusBO {

    @Autowired
    private IBusDAO busDAO;

    public String saveBus(Bus data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.BUS.getCode());
            data.setCode(code);
            busDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBus(Bus bus) {
        return busDAO.delete(bus);
    }

    @Override
    public void refreshBus(Bus condition) {
        busDAO.update(condition);
    }

    @Override
    public List<Bus> queryBusList(Bus condition) {
        return busDAO.selectList(condition);
    }

    @Override
    public Bus getBus(String code) {
        Bus data = null;
        if (StringUtils.isNotBlank(code)) {
            Bus condition = new Bus();
            condition.setCode(code);
            data = busDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "公车不存在！");
            }
        }
        return data;
    }

}
