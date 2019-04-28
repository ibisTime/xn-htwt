package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IAdvanceAO;
import com.cdkj.loan.bo.IAdvanceBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.IMissionBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Advance;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ENode;

@Service
public class AdvanceAOImpl implements IAdvanceAO {

    @Autowired
    private IAdvanceBO advanceBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private IMissionBO missionBO;

    @Override
    @Transactional
    public void confirmApply(String code, String operator) {
        Advance advance = advanceBO.getAdvance(code);

        String nextNodeCode = nodeFlowBO
            .getNodeFlowByCurrentNode(advance.getCurNodeCode()).getNextNode();
        ENode nextNode = ENode.matchCode(nextNodeCode);

        advanceBO.confirmApply(code, nextNodeCode, ECdbizStatus.F1.getCode());

        // 更新业务状态
        Cdbiz cdbiz = cdbizBO.getCdbiz(advance.getBizCode());
        cdbizBO.refreshFbhgpsStatus(cdbiz, ECdbizStatus.F1.getCode());

        // 操作日志
        sysBizLogBO.recordCurOperate(code, EBizLogType.fund, code,
            advance.getCurNodeCode(), null, operator);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.fund, code, nextNode, operator);
    }

    @Override
    public void areaManageApprove(String code, String operator,
            String approveNote) {

        Advance advance = advanceBO.getAdvance(code);

        String nextNodeCode = nodeFlowBO
            .getNodeFlowByCurrentNode(advance.getCurNodeCode()).getNextNode();
        String nextStatus = ECdbizStatus.F2.getCode();
        ENode nextNode = ENode.matchCode(nextNodeCode);

        advanceBO.areaManageApprove(code, nextNodeCode, nextStatus,
            approveNote);

        // 更新业务状态
        Cdbiz cdbiz = cdbizBO.getCdbiz(advance.getBizCode());
        cdbizBO.refreshFbhgpsStatus(cdbiz, nextStatus);

        // 操作日志
        sysBizLogBO.recordCurOperate(code, EBizLogType.fund, code,
            advance.getCurNodeCode(), approveNote, operator);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.fund, code, nextNode, operator);
    }

    @Override
    public void provinceManageApprove(String code, String operator,
            String approveResult, String approveNote) {

        Advance advance = advanceBO.getAdvance(code);

        String nextNodeCode = null;
        String nextStatus = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(advance.getCurNodeCode())
                .getNextNode();
            nextStatus = ECdbizStatus.F3.getCode();
        } else {
            nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(advance.getCurNodeCode())
                .getBackNode();
            nextStatus = ECdbizStatus.F2.getCode();
        }
        ENode nextNode = ENode.matchCode(nextNodeCode);

        advanceBO.provinceManageApprove(code, nextNodeCode, nextStatus);

        // TODO 生成任务单
        missionBO.saveMission(advance.getBizCode(), null, null, operator, null);

        // 更新业务状态
        Cdbiz cdbiz = cdbizBO.getCdbiz(advance.getBizCode());
        cdbizBO.refreshFbhgpsStatus(cdbiz, nextStatus);

        // 操作日志
        sysBizLogBO.recordCurOperate(code, EBizLogType.fund, code,
            advance.getCurNodeCode(), approveNote, operator);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.fund, code, nextNode, operator);
    }

    @Override
    public void confirmMakeBill(String code, String operator,
            String makeBillNote) {

        Advance advance = advanceBO.getAdvance(code);

        String nextNodeCode = nodeFlowBO
            .getNodeFlowByCurrentNode(advance.getCurNodeCode()).getNextNode();
        ENode nextNode = ENode.matchCode(nextNodeCode);

        advanceBO.confirmMakeBill(code, nextNodeCode, ECdbizStatus.F4.getCode(),
            makeBillNote);

        // 更新业务状态
        Cdbiz cdbiz = cdbizBO.getCdbiz(advance.getBizCode());
        cdbizBO.refreshFbhgpsStatus(cdbiz, ECdbizStatus.F4.getCode());

        // 操作日志
        sysBizLogBO.recordCurOperate(code, EBizLogType.fund, code,
            advance.getCurNodeCode(), makeBillNote, operator);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.fund, code, nextNode, operator);
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
