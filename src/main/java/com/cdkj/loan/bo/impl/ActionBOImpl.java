package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IActionBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IActionDAO;
import com.cdkj.loan.domain.Action;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class ActionBOImpl extends PaginableBOImpl<Action> implements IActionBO {

    @Autowired
    private IActionDAO actionDAO;

    @Override
    public boolean isActionExist(String code) {
        Action condition = new Action();
        condition.setCode(code);
        if (actionDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveAction(String type, String toType, String toCode,
            String creater, String remark) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.Action
            .getCode());
        Action data = new Action();
        data.setCode(code);
        data.setType(toType);
        data.setToType(toType);
        data.setToCode(toCode);
        data.setCreater(creater);
        data.setCreateDatetime(new Date());
        data.setRemark(remark);
        actionDAO.insert(data);
        return code;
    }

    @Override
    public int removeAction(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Action data = new Action();
            data.setCode(code);
            count = actionDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshAction(Action data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
        }
        return count;
    }

    @Override
    public List<Action> queryActionList(Action condition) {
        return actionDAO.selectList(condition);
    }

    @Override
    public Action getAction(String code) {
        Action data = null;
        if (StringUtils.isNotBlank(code)) {
            Action condition = new Action();
            condition.setCode(code);
            data = actionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "行为不存在");
            }
        }
        return data;
    }
}
