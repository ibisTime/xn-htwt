package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Advance;

public interface IAdvanceDAO extends IBaseDAO<Advance> {
    String NAMESPACE = IAdvanceDAO.class.getName().concat(".");

    // 确认用款单
    public void updateConfirmApply(Advance data);

    // 区域总经理审核
    public void updateAreaManageApprove(Advance data);

    // 省分公司总经理审核
    public void updateProvinceManageApprove(Advance data);

    // 确认制单
    public void updateConfirmMakeBill(Advance data);

}
