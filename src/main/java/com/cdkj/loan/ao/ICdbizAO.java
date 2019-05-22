package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.dto.req.XN632119Req;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632131Req;
import com.cdkj.loan.dto.req.XN632134Req;
import com.cdkj.loan.dto.req.XN632190Req;
import com.cdkj.loan.dto.req.XN632191Req;
import com.cdkj.loan.dto.req.XN632192Req;
import java.util.List;

public interface ICdbizAO {

    String DEFAULT_ORDER_COLUMN = "code";

    // 新增征信 和 征信人员列表
    String addCredit(XN632110Req req);

    // 修改征信信息 征信和征信人员
    void editCredit(XN632112Req req);

    // 派单
    void sendOrder(XN632119Req req);

    // 录入银行征信结果
    void inputBankCreditResult(XN632111Req req);

    // 征信初审
    void audit(XN632113Req req);

    // 准入申请提交
    void accesssApplySubmit(String code, String operator);

    // 面签
    void interview(XN632123Req req);

    // 面签内勤主管审核
    void interviewInternalApprove(String code, String operator,
            String approveResult, String approveNote);

    // 新录发保合
    void entryFbh(XN632131Req req);

    // 审核发包合
    void approveFbh(String code, String approveResult, String approveNote,
            String operator);

    // 安装gps
    void installGps(String code, String operator, List<XN632126ReqGps> gpsAzList);

    // 审核gps
    void gpsManagerApprove(String code, String operator, String approveResult,
            String approveNote);

    // 第一/二次存档
    void archive(XN632134Req req);

    // 制卡申请
    void makeCardApply(String code, String operator, String cardPostAddress,
            String redCardPic,String specialQuatoPic,String redCardPicWithIdPic);

    //工行制卡
    void makeIcbankCard(String code);

    // 卡号回录
    void inputCardNumber(String code, String cardNumber, String operator);

    Paginable<Cdbiz> queryCdbizPage(int start, int limit, Cdbiz condition);

    List<Cdbiz> queryCdbizList(Cdbiz condition);

    Cdbiz getCdbiz(String code);

    void creditBank(String code);

    Paginable<Cdbiz> queryIcbankCdbiz(int start, int limit, String userId);

    /**
     * 确认入档
     */
    void confirmArchive(String code, String operator, String enterLocation);

    // 申请作废
    void applyCancel(XN632190Req req);

    // 业务总监审核作废申请
    public void cancelBizAudit(XN632191Req req);

    // 财务总监审核作废申请
    public void cancelFinanceAudit(XN632192Req req);

    public void editRemark(String code,String remark);

}
