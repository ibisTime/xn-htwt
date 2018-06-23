package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BusBorrow;

@Component
public interface IBusBorrowAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBusBorrow(BusBorrow data);

    public Paginable<BusBorrow> queryBusBorrowPage(int start, int limit,
            BusBorrow condition);

    public List<BusBorrow> queryBusBorrowList(BusBorrow condition);

    public BusBorrow getBusBorrow(String code);

}
