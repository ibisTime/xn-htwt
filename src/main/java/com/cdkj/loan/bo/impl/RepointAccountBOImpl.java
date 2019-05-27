package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IRepointAccountBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepointAccountDAO;
import com.cdkj.loan.domain.RepointAccount;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RepointAccountBOImpl extends PaginableBOImpl<RepointAccount> implements
        IRepointAccountBO {

    @Autowired
    private IRepointAccountDAO repointAccountDAO;

    @Override
    public String saveRepointAccount(RepointAccount data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.REPOINT_ACCOUNT.getCode());
            data.setCode(code);
            repointAccountDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRepointAccount(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            RepointAccount data = new RepointAccount();
            data.setCode(code);
            count = repointAccountDAO.delete(data);
        }
        return count;
    }

    @Override
    public void removeListByRepointCode(String repointCode) {
        RepointAccount condition = new RepointAccount();
        condition.setRepointCode(repointCode);
        repointAccountDAO.deleteListByRepointCode(condition);
    }

    @Override
    public int refreshRepointAccount(RepointAccount data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
//            count = repointAccountDAO.update(data);
        }
        return count;
    }

    @Override
    public List<RepointAccount> queryRepointAccountList(RepointAccount condition) {
        return repointAccountDAO.selectList(condition);
    }

    @Override
    public RepointAccount getRepointAccount(String code) {
        RepointAccount data = null;
        if (StringUtils.isNotBlank(code)) {
            RepointAccount condition = new RepointAccount();
            condition.setCode(code);
            data = repointAccountDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }
}