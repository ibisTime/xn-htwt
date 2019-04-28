package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.req.XN632113Req;
import com.cdkj.loan.dto.req.XN632119Req;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.req.XN632131Req;

//CHECK ��鲢��ע�� 
public interface ICdbizAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<Cdbiz> queryCdbizPage(int start, int limit,
            Cdbiz condition);

    public List<Cdbiz> queryCdbizList(Cdbiz condition);

    public Cdbiz getCdbiz(String code);

    // 新增征信 和 征信人员列表
    public String addCredit(XN632110Req req);

    // 修改征信信息 征信和征信人员
    public void editCredit(XN632112Req req);

    // 征信初审
    public void audit(XN632113Req req);

    // 录入银行征信结果
    public void inputBankCreditResult(XN632111Req req);

    // 征信撤回
    public void cancelCredit(String code, String operator);

    // 派单
    public void distributeLeaflets(XN632119Req req);

    // 面签
    public void interview(XN632123Req req);

    // 面签内勤主管审核
    public void interviewInternalApprove(String code, String operator,
            String approveResult, String approveNote);

    // 新录发保合
    public void entryFbh(XN632131Req req);

    // 第一/二次存档
    public void archive(String code, String type, String operator,
            String enterLocation);
}
