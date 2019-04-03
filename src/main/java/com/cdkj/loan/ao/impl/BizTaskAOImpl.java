package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBizTaskAO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632520Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizTaskStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class BizTaskAOImpl implements IBizTaskAO {

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addBizTask(XN632520Req req) {
        return bizTaskBO.saveBizTask(req.getBizCode(), req.getRefType(),
            req.getRefOrder(), req.getContent());
    }

    @Override
    public void handleBizTask(String code, String operator) {
        BizTask bizTask = bizTaskBO.getBizTask(code);

        if (!EBizTaskStatus.TO_HANDLE.getCode().equals(bizTask.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "待办事项未处于可处理状态");
        }

        SYSUser operatorInfo = sysUserBO.getUser(operator);
        bizTaskBO.operateBizTask(code, operatorInfo);
    }

    @Override
    public Paginable<BizTask> queryBizTaskPage(int start, int limit,
            BizTask condition) {
        return bizTaskBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BizTask> queryBizTaskList(BizTask condition) {
        return bizTaskBO.queryBizTaskList(condition);
    }

    @Override
    public BizTask getBizTask(String code) {
        return bizTaskBO.getBizTask(code);
    }

}
