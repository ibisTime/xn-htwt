package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BusBorrow;

public interface IBusBorrowBO extends IPaginableBO<BusBorrow> {

    public String saveBusBorrow(BusBorrow data);

    public List<BusBorrow> queryBusBorrowList(BusBorrow condition);

    public BusBorrow getBusBorrow(String code);

    public void auditBusBorrow(BusBorrow data);

    public void returnBusBorrow(BusBorrow data);

    public void auditBusBorrowReturn(BusBorrow condition);

}
