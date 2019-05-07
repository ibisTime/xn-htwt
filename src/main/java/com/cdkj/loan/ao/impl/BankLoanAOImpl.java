package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IBankLoanAO;
import com.cdkj.loan.bo.IBankLoanBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BankLoan;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankLoanAOImpl implements IBankLoanAO {

    @Autowired
    private IBankLoanBO bankLoanBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void commitBank(String bizCode, String operator,
            String bankCommitDatetime, String bankCommitNote) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(bizCode);

        if (EBoolean.YES.getCode().equals(cdbiz.getZfStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前预算单已作废，不能操作");
        }

        if (!ENode.gps_done.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "gps未安装完成，不能提交银行");
        }

        if (!ENode.fk_submit.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是确认提交银行节点，不能操作");
        }
        BankLoan bankLoan = bankLoanBO.getBankLoanByBiz(bizCode);

        String nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode()).getNextNode();

        // 更新银行放款状态
        bankLoanBO.commitBank(bankLoan.getCode(), nextNodeCode, operator,
                bankCommitDatetime, bankCommitNote);

        // 更新业务状态
        cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(bizCode, EBizLogType.bank_push,
                cdbiz.getCode(), ENode.matchCode(nextNodeCode), operator);

        // 操作日志
        sysBizLogBO.recordCurOperate(bizCode, EBizLogType.bank_push,
                cdbiz.getCode(), nextNodeCode, bankCommitNote, operator);
    }

    @Override
    public void entryFkInfo(XN632135Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());

        BankLoan bankLoan = bankLoanBO.getBankLoanByBiz(req.getCode());

        if (!ENode.fk_input.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是录入放款信息节点，不能操作");
        }

        Date repayFirstMonthDatetime = DateUtil.strToDate(
                req.getRepayFirstMonthDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING);
        Date tomorrowDate = DateUtil.getTomorrowStart(new Date());
        if (tomorrowDate.compareTo(repayFirstMonthDatetime) > 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "首次还款日期请从明天开始算起");
        }

        String nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode()).getNextNode();

        // 录入放款信息
        bankLoanBO.entryFkInfo(bankLoan.getCode(), nextNodeCode, req);

        // 更新业务状态
        cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.bank_push,
                cdbiz.getCode(), ENode.matchCode(nextNodeCode),
                req.getOperator());

        // 操作日志
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.bank_push,
                cdbiz.getCode(), nextNodeCode, null, req.getOperator());
    }

    @Override
    public void confirmSk(XN632130Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());

        BankLoan bankLoan = bankLoanBO.getBankLoanByBiz(req.getCode());

        if (!ENode.cw_confirm_receipt.getCode()
                .equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是确认收款节点，不能操作");
        }

        String nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode()).getNextNode();

        // 确认收款
        bankLoanBO.confirmSk(bankLoan.getCode(), nextNodeCode, req);

        // 更新业务状态
        cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.bank_push,
                cdbiz.getCode(), ENode.matchCode(nextNodeCode),
                req.getOperator());

        // 操作日志
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.bank_push,
                cdbiz.getCode(), nextNodeCode, null, req.getOperator());
    }

    @Override
    public Paginable<BankLoan> queryBankLoanPage(int start, int limit,
            BankLoan condition) {
        return bankLoanBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BankLoan> queryBankLoanList(BankLoan condition) {
        return bankLoanBO.queryBankLoanList(condition);
    }

    @Override
    public BankLoan getBankLoan(String code) {
        return bankLoanBO.getBankLoan(code);
    }

}
