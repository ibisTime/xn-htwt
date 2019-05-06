package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Advance;

public interface IAdvanceDAO extends IBaseDAO<Advance> {

    String NAMESPACE = IAdvanceDAO.class.getName().concat(".");

    // 确认用款单
    void updateConfirmApply(Advance data);

    // 区域总经理审核
    void updateAreaManageApprove(Advance data);

    // 省分公司总经理审核
    void updateProvinceManageApprove(Advance data);

    // 确认制单
    void updateConfirmMakeBill(Advance data);

    /**
     * 垫资回录
     */
    void updateAdvanceBackUp(Advance advance);
}
