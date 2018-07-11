package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IInvestigateReportAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IInvestigateReportBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.InvestigateReport;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632200Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EInvestigateReportNode;
import com.cdkj.loan.exception.BizException;

@Service
public class InvestigateReportAOImpl implements IInvestigateReportAO {

    @Autowired
    private IInvestigateReportBO investigateReportBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addInvestigateReport(InvestigateReport data) {
        return investigateReportBO.saveInvestigateReport(data);
    }

    @Override
    @Transactional
    public void approveInvestigateReport(XN632200Req req) {
        InvestigateReport data = investigateReportBO
            .getInvestigateReport(req.getCode());
        if (!EInvestigateReportNode.COMMIT_APPLY.getCode()
            .equals(data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是提交调查申请节点，不能操作！");
        }

        // 之前节点
        String curNodeCode = data.getCurNodeCode();

        data.setGuaMode(req.getGuaMode());
        data.setCustomerInformation(req.getCustomerInformation());
        data.setPriceApprovalPdf(req.getPriceApprovalPdf());
        data.setCar168Price(StringValidater.toLong(req.getCar168Price()));
        data.setApplyWorkAndJour(req.getApplyWorkAndJour());
        data.setHomeVisit(req.getHomeVisit());
        data.setBasicsInformation(req.getBasicsInformation());
        data.setXszPdf(req.getXszPdf());
        data.setXszCarPdf(req.getXszCarPdf());
        data.setFrameNo(req.getFrameNo());
        data.setNameplate(req.getNameplate());
        data.setForwardPdf(req.getForwardPdf());
        data.setQueenPdf(req.getQueenPdf());
        data.setLeftPdf(req.getLeftPdf());
        data.setRightPdf(req.getRightPdf());
        data.setLf45Pdf(req.getLf45Pdf());
        data.setLg45Pdf(req.getLg45Pdf());
        data.setRr45Pdf(req.getRr45Pdf());
        data.setEnginePdf(req.getEnginePdf());
        data.setSzmPdf(req.getSzmPdf());
        data.setGearsPdf(req.getGearsPdf());
        data.setFunctionalZonePdf(req.getFunctionalZonePdf());
        data.setOdometerPdf(req.getOdometerPdf());
        data.setFrontRowPdf(req.getFrontRowPdf());
        data.setRockRowPdf(req.getRockRowPdf());
        data.setTrunkPdf(req.getTrunkPdf());
        data.setLouverPdf(req.getLouverPdf());
        data.setBankRowPdf(req.getBankRowPdf());
        data.setCheckApprovePdf(req.getCheckApprovePdf());
        data.setCheckApproveLink(req.getCheckApproveLink());
        data.setThirdValuationPdf(req.getThirdValuationPdf());
        data.setCheckApproveSoftware(req.getCheckApproveSoftware());
        data.setUsedCarCurrentRate(req.getUsedCarCurrentRate());
        data.setInformationSource(req.getInformationSource());
        data.setValuation(StringValidater.toLong(req.getValuation()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            data.setCurNodeCode(
                nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getNextNode());
        }
        investigateReportBO.refreshInvestigateReport(data);

        // 日志记录
        EInvestigateReportNode currentNode = EInvestigateReportNode.getMap()
            .get(data.getCurNodeCode());
        sysBizLogBO.saveSYSBizLog(data.getCode(), EBizLogType.INVESTIGATEREPORT,
            data.getCode(), currentNode.getCode(), currentNode.getValue(),
            req.getUpdater());
    }

    @Override
    @Transactional
    public void riskApprove(String code, String approveResult,
            String approveNote, String updater) {
        InvestigateReport data = investigateReportBO.getInvestigateReport(code);
        if (!EInvestigateReportNode.RISK_APPROVE.getCode()
            .equals(data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控专员审核节点，不能操作！");
        }
        // 之前节点
        String curNodeCode = data.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            data.setCurNodeCode(
                nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getNextNode());
        } else {
            data.setCurNodeCode(
                nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getBackNode());
        }
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(approveNote);
        investigateReportBO.riskApprove(data);

        // 日志记录
        EInvestigateReportNode currentNode = EInvestigateReportNode.getMap()
            .get(data.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
            EBizLogType.INVESTIGATEREPORT, data.getCode(), curNodeCode,
            currentNode.getCode(), currentNode.getValue(), updater);
    }

    @Override
    @Transactional
    public void approveByBankCheck(String code, String approveResult,
            String approveNote, String updater) {
        InvestigateReport data = investigateReportBO.getInvestigateReport(code);
        if (!EInvestigateReportNode.MORTGAGE_APPROVE.getCode()
            .equals(data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是驻行人员审核节点，不能操作！");
        }

        // 之前节点
        String curNodeCode = data.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            data.setCurNodeCode(
                nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getNextNode());
        } else {
            data.setCurNodeCode(
                nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getBackNode());
        }
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(approveNote);
        investigateReportBO.riskApprove(data);

        // 日志记录
        EInvestigateReportNode currentNode = EInvestigateReportNode.getMap()
            .get(data.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
            EBizLogType.INVESTIGATEREPORT, data.getCode(), curNodeCode,
            currentNode.getCode(), currentNode.getValue(), updater);
    }

    @Override
    public Paginable<InvestigateReport> queryInvestigateReportPage(int start,
            int limit, InvestigateReport condition) {
        Paginable<InvestigateReport> paginable = investigateReportBO
            .getPaginable(start, limit, condition);
        for (InvestigateReport investigateReport : paginable.getList()) {
            initInvestigateReport(investigateReport);
        }
        return paginable;
    }

    @Override
    public List<InvestigateReport> queryInvestigateReportList(
            InvestigateReport condition) {
        return investigateReportBO.queryInvestigateReportList(condition);
    }

    @Override
    public InvestigateReport getInvestigateReport(String code) {
        InvestigateReport investigateReport = investigateReportBO
            .getInvestigateReport(code);
        initInvestigateReport(investigateReport);
        return investigateReport;
    }

    private void initInvestigateReport(InvestigateReport investigateReport) {
        // 公司
        if (StringUtils.isNotBlank(investigateReport.getCompanyCode())) {
            Department department = departmentBO
                .getDepartment(investigateReport.getCompanyCode());
            investigateReport.setCompanyName(department.getName());
        }
        // 贷款银行
        if (StringUtils.isNotBlank(investigateReport.getLoanBank())) {
            Bank loanBank = bankBO.getBank(investigateReport.getLoanBank());
            investigateReport.setLoanBankName(loanBank.getBankName());
        }
        // 业务团队
        if (StringUtils.isNotBlank(investigateReport.getTeamCode())) {
            BizTeam bizTeam = bizTeamBO
                .getBizTeam(investigateReport.getTeamCode());
            investigateReport.setTeamName(bizTeam.getName());
        }
        // 业务员姓名
        if (StringUtils.isNotBlank(investigateReport.getSaleUserId())) {
            SYSUser user = sysUserBO.getUser(investigateReport.getSaleUserId());
            investigateReport.setSaleUserName(user.getRealName());
        }
    }
}
