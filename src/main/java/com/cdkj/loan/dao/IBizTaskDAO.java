package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BizTask;
import java.util.List;

public interface IBizTaskDAO extends IBaseDAO<BizTask> {

    String NAMESPACE = IBizTaskDAO.class.getName().concat(".");

    int updateOperate(BizTask bizTask);

    BizTask selectLastBizTask(BizTask bizTask);

    long selectTotalCountByRole(BizTask condition);

    List<BizTask> selectListByRole(BizTask condition, int start, int pageSize);
}
