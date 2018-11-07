package com.cdkj.loan.ao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.BudgetOrderGps;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632125Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632128Req;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.req.XN632131Req;
import com.cdkj.loan.dto.req.XN632133Req;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.dto.req.XN632141Req;
import com.cdkj.loan.dto.req.XN632143Req;
import com.cdkj.loan.dto.req.XN632144Req;
import com.cdkj.loan.dto.req.XN632149Req;
import com.cdkj.loan.dto.req.XN632180Req;
import com.cdkj.loan.dto.req.XN632190Req;
import com.cdkj.loan.dto.req.XN632191Req;
import com.cdkj.loan.dto.req.XN632192Req;
import com.cdkj.loan.dto.req.XN632913Req;
import com.cdkj.loan.dto.req.XN632914Req;

@Component
public interface IBudgetOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 填写准入申请单
    public void editBudgetOrder(XN632120Req req);

    // 区域经理审核
    public void areaApprove(String code, String approveResult,
            String approveNote, String operator);

    // 准入单内勤主管审核
    public void internalApprove(String code, String approveResult,
            String approveNote, String operator);

    // 风控一审
    public void riskOneApprove(String code, String approveResult,
            String approveNote, String operator);

    // 风控二审
    public void riskTwoApprove(String code, String carPriceCheckReport,
            String housePicture, String approveResult, String approveNote,
            String operator);

    // 风控主管审核
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote);

    // 业务总监审核
    void yBizChargeApprove(String code, String operator, String approveResult,
            String approveNote);

    // 面签
    public void interview(XN632123Req req);

    // 面签内勤主管审核
    public void interviewInternalApprove(String code, String operator,
            String approveResult, String approveNote);

    // 财务审核
    public void financeAudit(XN632143Req req);

    // 财务确认垫资
    public void advanceFund(XN632125Req req);

    // 驻行抵押申请
    public void residentMortgageApply(XN632144Req req);

    // 内勤确认
    public void insidejobConfirm(XN632124Req req);

    // 安装GPS
    public void installGps(String code, String operator,
            List<XN632126ReqGps> budgetOrderGpsList);

    // GPS管理员审核
    public void gpsManagerApprove(String code, String operator,
            String approveResult, String approveNote,
            List<BudgetOrderGps> list);

    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    // 车辆落户
    public void carSettle(XN632128Req req);

    // 确认提交银行
    public void commitBank(String code, String operator,
            String bankCommitDatetime, String bankCommitNote);

    // 确认收款
    public void confirmLoan(XN632130Req req);

    // 录入放款信息
    public void entryFk(XN632135Req req);

    // 确定入档
    public void archive(String code, String operator, String enterLocation);

    // 录入抵押信息
    public void entryMortgage(XN632131Req req);

    // 抵押确认提交银行
    public void mortgageCommitBank(String code, String operator,
            String pledgeBankCommitDatetime, String pledgeBankCommitNote);

    // 驻行人员审核抵押材料
    public void mortgageCommitbank(XN632149Req req);

    // 抵押完成
    public void mortgageFinish(XN632133Req req);

    public Paginable<BudgetOrder> queryBudgetOrderPageByRoleCode(int start,
            int limit, BudgetOrder condition, String operator);

    public BudgetOrder getMoreBudget(String code);

    // 财务确认退垫资款
    public void confirmBackAdvanceFund(XN632180Req req);

    // 客户申请作废
    public void applyCancel(XN632190Req req);

    // 客户作废 业务总监审核
    public void cancelBizAudit(XN632191Req req);

    // 客户作废 财务总监审核
    public void cancelFinanceAudit(XN632192Req req);

    // 垫资超过1天未放款客户
    public ArrayList<BudgetOrder> queryBudgetOrderPageByDz(
            BudgetOrder condition);

    public void doSmsInterviewInform(String budgetOrderCode, String roomId);

    // 资料补录
    public void dataSupplement(XN632141Req req);

    // 团队报表
    public Paginable<BudgetOrder> queryBudgetOrderPageByTeamCode(int start,
            int limit, BudgetOrder condition, String roleCode);

    // 业务报表
    public Object queryBudgetOrderPageForBizReport(int start, int limit,
            BudgetOrder condition);

    // 进度报表
    public Object queryBudgetOrderPageForProgress(XN632913Req req);

    // 贷后统计
    public Paginable<BudgetOrder> queryBudgetOrderPageForLoanLater(
            XN632914Req req);

    // 根据客户姓名查询预算单
    public List<BudgetOrder> queryBudgetOrderByApplyUserName(
            BudgetOrder condition);

}
