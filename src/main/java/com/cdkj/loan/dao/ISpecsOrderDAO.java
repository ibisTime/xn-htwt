package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SpecsOrder;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 下午9:03:38 
 * @history:
 */
public interface ISpecsOrderDAO extends IBaseDAO<SpecsOrder> {
    String NAMESPACE = ISpecsOrderDAO.class.getName().concat(".");

    public int updateStatus(SpecsOrder data);

    public int deliver(SpecsOrder data);
}
