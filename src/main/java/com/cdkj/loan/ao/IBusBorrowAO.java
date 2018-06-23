package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BusBorrow;
import com.cdkj.loan.dto.req.XN632790Req;

@Component
public interface IBusBorrowAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBusBorrow(XN632790Req req);

    public Paginable<BusBorrow> queryBusBorrowPage(int start, int limit,
            BusBorrow condition);

    public List<BusBorrow> queryBusBorrowList(BusBorrow condition);

    public BusBorrow getBusBorrow(String code);

    // 申请审核
    public void auditBusBorrow(String code, String approveResult,
            String updater, String remark);

    // 归还
    public void returnBusBorrow(String code, String driveKil, String remark);

    // 归还审核
    public void auditBusBorrowReturn(String code, String approveResult,
            String updater, String remark);

}
