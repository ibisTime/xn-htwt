package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarPledge;

public interface ICarPledgeDAO extends IBaseDAO<CarPledge> {

    String NAMESPACE = ICarPledgeDAO.class.getName().concat(".");

    int updateSaleManConfirm(CarPledge carPledge);

    int updateEntryPledgeInfo(CarPledge carPledge);

    int updateCommitBank(CarPledge carPledge);

    int updateConfirmDone(CarPledge carPledge);

    void updateSupplementNote(CarPledge condition);
}
