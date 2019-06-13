package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBizTaskDAO;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.RoleNode;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBizTaskStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BizTaskBOImpl extends PaginableBOImpl<BizTask> implements
        IBizTaskBO {

    @Autowired
    private IBizTaskDAO bizTaskDAO;

    @Autowired
    private IRoleNodeBO roleNodeBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private INodeBO nodeBO;

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

        String content = "你有新的待" + curNode.getValue() + "(" + bizLogType.getValue() + ")";

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
    public String saveBizTaskNew(String bizCode, EBizLogType bizLogType,
            String refOrder, String curNode) {
        BizTask data = new BizTask();

        data.setBizCode(bizCode);
        data.setRefType(bizLogType.getCode());
        data.setRefOrder(refOrder);
        data.setRefNode(curNode);
        data.setStatus(EBizTaskStatus.TO_HANDLE.getCode());

        Node node = nodeBO.getNode(curNode);
        String content = "你有新的待" + node.getName() + "(" + bizLogType.getValue() + ")";

        data.setContent(content);
        data.setCreateDatetime(new Date());

        String code = OrderNoGenerater.generate(EGeneratePrefix.BIZ_TASK
                .getCode());
        data.setCode(code);
        bizTaskDAO.insert(data);
        return code;
    }

    @Override
    public void handlePreAndAdd(EBizLogType bizLogType, String refOrder,
            String bizCode, String preNode, String curNode, String userId) {
        handlePreBizTask(bizCode, bizLogType.getCode(), refOrder,
                preNode, userId);

        saveBizTaskNew(bizCode, bizLogType, refOrder, curNode);

    }

    @Override
    public void handlePreBizTask(String bizCode, String refType, String refOrder, String preNode,
            String userId) {
        List<BizTask> bizTasks = queryLastBizTask(bizCode, refType, refOrder, preNode);
        if (CollectionUtils.isNotEmpty(bizTasks)) {
            for (BizTask bizTask : bizTasks) {
                handleBizTask(bizTask.getCode(), userId);
            }
        }
    }

    @Override
    public void handleBizTask(String code, String userId) {
        BizTask data = new BizTask();

        data.setCode(code);
        data.setOperater(userId);
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
    public List<BizTask> queryLastBizTask(String bizCode, String refType, String refOrder,
            String curNode) {
        BizTask condition = new BizTask();
        condition.setBizCode(bizCode);
//        condition.setRefType(refType);
//        condition.setRefOrder(refOrder);
        condition.setRefNode(curNode);
        condition.setStatus(EBizTaskStatus.TO_HANDLE.getCode());
        condition.setOrder("create_datetime", "desc");

        List<BizTask> bizTasks = bizTaskDAO.selectList(condition);
        if (CollectionUtils.isEmpty(bizTasks)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "未找到" + curNode + "对应的待处理待办");
        }
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

    @Override
    public Paginable<BizTask> getPaginableByRole(int start, int pageSize, BizTask condition) {
        prepare(condition);

        long totalCount = bizTaskDAO.selectTotalCountByRole(condition);

        Paginable<BizTask> page = new Page<BizTask>(start, pageSize, totalCount);

        List<BizTask> dataList = bizTaskDAO.selectListByRole(condition, page.getStart(),
                page.getPageSize());

        page.setList(dataList);
        return page;
    }

}
