package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBizLogBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBizLogDAO;
import com.cdkj.loan.domain.BizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BizLogBOImpl extends PaginableBOImpl<BizLog> implements IBizLogBO {

    @Autowired
    private IBizLogDAO bizLogDAO;

    @Override
    public String saveBizLog(String bizCode, String refType, String refOrder,
            String dealNode, String dealNote, SYSUser operator) {
        BizLog data = new BizLog();

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.BIZ_LOG.getCode());
        data.setCode(code);
        data.setBizCode(bizCode);
        data.setRefType(refType);
        data.setRefOrder(refOrder);

        data.setDealNode(dealNode);
        data.setDealNote(dealNote);
        data.setOperateRole(operator.getRoleCode());
        data.setOperator(operator.getUserId());
        data.setOperatorName(operator.getLoginName());

        data.setOperatorMobile(operator.getMobile());
        data.setStartDatetime(new Date());
        bizLogDAO.insert(data);
        return code;
    }

    @Override
    public List<BizLog> queryBizLogList(BizLog condition) {
        return bizLogDAO.selectList(condition);
    }

    @Override
    public BizLog getBizLog(String code) {
        BizLog data = null;
        if (StringUtils.isNotBlank(code)) {
            BizLog condition = new BizLog();
            condition.setCode(code);
            data = bizLogDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "日志编号不存在");
            }
        }
        return data;
    }
}
