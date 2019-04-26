package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IAdvanceAO;
import com.cdkj.loan.bo.IAdvanceBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Advance;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.enums.ECdbizStatus;

@Service
public class AdvanceAOImpl implements IAdvanceAO {

    @Autowired
    private IAdvanceBO advanceBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    @Transactional
    public void confirmApply(String code, String operator) {
        Advance advance = advanceBO.getAdvance(code);

        String nextNodeCode = nodeFlowBO
            .getNodeFlowByCurrentNode(advance.getCurNodeCode()).getNextNode();

        advanceBO.confirmApply(code, nextNodeCode, ECdbizStatus.F0.getCode());

        // 更新业务状态
        Cdbiz cdbiz = cdbizBO.getCdbiz(advance.getBizCode());

        // 操作日志

        // 待办事项
    }

    @Override
    public void areaManageApprove(String code, String operator,
            String approveResult, String approveNote) {

        // advanceBO.areaManageApprove(code, curNodeCode, status, approveNote);
    }

    @Override
    public void provinceManageApprove(String code, String operator,
            String approveResult, String approveNote) {

        // advanceBO.provinceManageApprove(code, curNodeCode, status);
    }

    @Override
    public void confirmMakeBill(String code, String operator,
            String makeBillNote) {

        // advanceBO.confirmMakeBill(code, curNodeCode, status, makeBillNote);
    }

    @Override
    public Paginable<Advance> queryAdvancePage(int start, int limit,
            Advance condition) {
        return advanceBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Advance> queryAdvanceList(Advance condition) {
        return advanceBO.queryAdvanceList(condition);
    }

    @Override
    public Advance getAdvance(String code) {
        return advanceBO.getAdvance(code);
    }

}
