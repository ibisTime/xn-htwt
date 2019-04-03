package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBizTaskDAO;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBizTaskStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;

@Component
public class BizTaskBOImpl extends PaginableBOImpl<BizTask> implements
        IBizTaskBO {

    @Autowired
    private IBizTaskDAO bizTaskDAO;

    @Override
    public String saveBizTask(String bizCode, EBizLogType bizLogType,
            String refOrder, ENode curNode) {
        BizTask data = new BizTask();

        String code = OrderNoGenerater.generate(EGeneratePrefix.BIZ_TASK
            .getCode());
        data.setCode(code);
        data.setBizCode(bizCode);
        data.setRefType(bizLogType.getCode());
        data.setRefOrder(refOrder);
        String content = "你有新的待" + curNode.getValue() + bizLogType.getValue()
                + "单";
        data.setContent(content);
        bizTaskDAO.insert(data);
        return code;
    }

    @Override
    public void operateBizTask(String code, SYSUser operator) {
        BizTask data = new BizTask();

        data.setCode(code);
        data.setStatus(EBizTaskStatus.DONE.getCode());
        data.setOperater(operator.getUserId());
        data.setOperateRole(operator.getRoleCode());
        data.setFinishDatetime(new Date());

        bizTaskDAO.updateOperate(data);
    }

    @Override
    public List<BizTask> queryBizTaskList(BizTask condition) {
        return bizTaskDAO.selectList(condition);
    }

    @Override
    public BizTask getBizTask(String code) {
        BizTask data = null;
        if (StringUtils.isNotBlank(code)) {
            BizTask condition = new BizTask();
            condition.setCode(code);
            data = bizTaskDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "待办事项不存在");
            }
        }
        return data;
    }

}
