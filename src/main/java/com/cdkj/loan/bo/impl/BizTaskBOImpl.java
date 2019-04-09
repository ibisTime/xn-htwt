package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBizTaskDAO;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.RoleNode;
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

    @Autowired
    private IRoleNodeBO roleNodeBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private INodeBO nodeBO;

    @Override
    public String saveBizTask(String bizCode, EBizLogType bizLogType,
            String refOrder, ENode curNode) {

        String code = null;
        cdbizBO.getCdbiz(bizCode);
        BizTask data = new BizTask();
        List<RoleNode> roleNodes = roleNodeBO
            .queryListByNode(curNode.getCode());
        for (RoleNode roleNode : roleNodes) {

            code = OrderNoGenerater
                .generate(EGeneratePrefix.BIZ_TASK.getCode());
            data.setCode(code);
            data.setBizCode(bizCode);
            data.setRefType(bizLogType.getCode());
            data.setRefOrder(refOrder);
            String content = "你有新的待" + curNode.getValue()
                    + bizLogType.getValue() + "单";
            data.setContent(content);
            data.setOperateRole(roleNode.getRoleCode());
            bizTaskDAO.insert(data);
        }
        return code;
    }

    @Override
    public void operateBizTask(String code, SYSUser operator) {
        BizTask data = new BizTask();

        data.setCode(code);
        data.setStatus(EBizTaskStatus.DONE.getCode());
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

    @Override
    public BizTask getLastBizTask(String lastNode, String bizCode) {
        Node node = nodeBO.getNode(lastNode);
        BizTask condition = new BizTask();
        condition.setRefType(node.getType());
        condition.setBizCode(bizCode);
        condition.setStatus(EBizTaskStatus.TO_HANDLE.getCode());
        return bizTaskDAO.select(condition);
    }
}
