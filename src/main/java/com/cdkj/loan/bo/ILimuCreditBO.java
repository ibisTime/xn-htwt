package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.LimuCredit;

public interface ILimuCreditBO extends IPaginableBO<LimuCredit> {

    public void saveLimuCredit(LimuCredit data);

    public int refreshLimuCredit(LimuCredit data);

    public List<LimuCredit> queryLimuCreditList(LimuCredit condition);

    public LimuCredit getLimuCredit(int id);

    public LimuCredit getLimuCreditByToken(String token);

}
