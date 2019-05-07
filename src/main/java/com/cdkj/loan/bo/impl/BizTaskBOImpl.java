package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBizTaskDAO;
import com.cdkj.loan.domain.BizTask;
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
    private ISYSUserBO sysUserBO;

    @Override
    public String saveBizTask(String bizCode, EBizLogType bizLogType,
            String refOrder, ENode curNode, String userId) {
        String code = null;
        BizTask data = new BizTask();

        data.setBizCode(bizCode);
        data.setRefType(bizLogType.getCode());
        data.setRefOrder(refOrder);
        data.setRefNode(curNode.getCode());
        data.setStatus(EBizTaskStatus.TO_HANDLE.getCode());

        String content = "你有新的待" + curNode.getValue() + bizLogType.getValue();

        data.setContent(content);
        data.setCreateDatetime(new Date());
        if (StringUtils.isNotBlank(userId)) {
            SYSUser sysUser = sysUserBO.getUser(userId);
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BIZ_TASK.getCode());
            data.setCode(code);
            data.setOperater(userId);
            data.setOperateRole(sysUser.getRoleCode());
            bizTaskDAO.insert(data);
        } else {
            List<RoleNode> roleNodes = roleNodeBO.queryListByNode(curNode
                .getCode());
            for (RoleNode roleNode : roleNodes) {
                code = OrderNoGenerater.generate(EGeneratePrefix.BIZ_TASK
                    .getCode());
                data.setCode(code);
                data.setOperateRole(roleNode.getRoleCode());
                bizTaskDAO.insert(data);
            }
        }

        return code;
    }

    @Override
    public void handlePreAndAdd(EBizLogType bizLogType, String refOrder,
            String bizCode, String preNode, String curNode, String userId) {
        handlePreBizTask(bizLogType.getCode(), refOrder,
            ENode.matchCode(preNode));
        saveBizTask(bizCode, bizLogType, refOrder, ENode.matchCode(curNode),
            userId);

    }

    @Override
    public void handlePreBizTask(String refType, String refOrder, ENode preNode) {
        List<BizTask> bizTasks = queryLastBizTask(refType, refOrder, preNode);
        for (BizTask bizTask : bizTasks) {
            handleBizTask(bizTask.getCode());
        }

    }

    @Override
    public void handleBizTask(String code) {
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
    public List<BizTask> queryLastBizTask(String refType, String refOrder,
            ENode curNode) {
        BizTask bizTask = new BizTask();

        bizTask.setRefType(refType);
        bizTask.setRefOrder(refOrder);
        bizTask.setRefNode(curNode.getCode());
        bizTask.setStatus(EBizTaskStatus.TO_HANDLE.getCode());

        List<BizTask> bizTasks = bizTaskDAO.selectList(bizTask);

        return bizTasks;
    }

    @Override
    public void removeUnhandleBizTask(String bizCode, String node,
            String operater) {
        BizTask condition = new BizTask();
        condition.setBizCode(bizCode);
        condition.setRefNode(node);
        condition.setStatus(EBizTaskStatus.TO_HANDLE.getCode());
        condition.setOperater(operater);
        BizTask bizTask = bizTaskDAO.selectList(condition).get(0);
        bizTaskDAO.delete(bizTask);
    }

    @Override
    public List<BizTask> queryBizTaskByBizCode(String bizCode) {
        BizTask condition = new BizTask();
        condition.setBizCode(bizCode);
        List<BizTask> bizTasks = bizTaskDAO.selectList(condition);
        return bizTasks;
    }

}
