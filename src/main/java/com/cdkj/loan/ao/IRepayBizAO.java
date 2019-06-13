package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.dto.req.XN630515Req;
import com.cdkj.loan.dto.req.XN630516Req;
import com.cdkj.loan.dto.req.XN630551Req;
import com.cdkj.loan.dto.req.XN630555Req;
import com.cdkj.loan.dto.req.XN630557Req;
import com.cdkj.loan.dto.req.XN630561Req;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.dto.req.XN630563Req;
import java.util.Date;
import java.util.List;

public interface IRepayBizAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public void editBankcardNew(XN630510Req req);

    public void editBankcardModify(XN630511Req req);

    // 提前还款，车贷和商品分期都有
    public void advanceRepay(String code, String updater, String remark);

    // 提前还款申请
    public void prepaymentApply(XN630515Req req);

    // 提前还款审核
    public void prepaymentApprove(XN630516Req req);

    // ********************************car********************************

    // 清欠催收部审核
    public void approveByQkcsDepartment(String code, Long cutLyDeposit,
            String updater, String remark);

    // 驻行人员审核
    public void approveByBankCheck(XN630551Req req);

    // 总经理审核
    public void approveByManager(String code, String approveResult,
            String updater, String remark);

    // 财务审核
    public void approveByFinance(String code, String approveResult,
            String updater, String remark);

    // 业务团队解除抵押
    public void releaseMortgage(String code, Date releaseDatetime,
            String updater);

    // 清欠催收部申请拖车
    public void applyTrailer(XN630555Req req);

    // 财务打款
    public void financialMoney(String code, String operator, String remitAmount,
            String remitPdf);

    // 清欠催收部拖车录入
    public void trailerEntry(XN630557Req req);

    // 拖车管理处理结果
    public void trailerManage(String code, String appoveResult,
            String operator);

    // 司法诉讼结果录入
    public void judicialLitigationEntry(String code, String buyOutAmount,
            String way, String operator);

    // 清欠催收部申请赎回
    public void qkcsbRedeemApply(XN630561Req req);

    // 财务主管审核
    public void financeApprove(XN630562Req req);

    // 风控主管审核
    public void riskManagerCheck(XN630563Req req);
    // ********************************car********************************

    // ********************************product********************************

    public void enterBlackListProduct(String code, String blackHandleNote,
            String updater, String remark);

    public void confirmSettledProduct(XN630513Req req);

    // ********************************product********************************

    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition);

    public List<RepayBiz> queryRepayBizList(RepayBiz condition);

    public RepayBiz getRepayBiz(String code);

    public Paginable<RepayBiz> queryRepayBizPageByRoleCode(int start, int limit,
            RepayBiz condition, String userId);

}
