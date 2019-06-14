package com.cdkj.loan.dao.impl;

import com.cdkj.loan.dao.IAdvanceCollectCardDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.AdvanceCollectCard;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository("advanceCollectCardDAOImpl")
public class AdvanceCollectCardDAOImpl extends AMybatisTemplate implements IAdvanceCollectCardDAO {


    @Override
    public int insert(AdvanceCollectCard data) {
        return super.insert(NAMESPACE.concat("insert_AdvanceCollectCard"), data);
    }


    @Override
    public int delete(AdvanceCollectCard data) {
        return super.delete(NAMESPACE.concat("delete_AdvanceCollectCard"), data);
    }


    @Override
    public AdvanceCollectCard select(AdvanceCollectCard condition) {
        return super.select(NAMESPACE.concat("select_AdvanceCollectCard"), condition,
                AdvanceCollectCard.class);
    }


    @Override
    public long selectTotalCount(AdvanceCollectCard condition) {
        return super
                .selectTotalCount(NAMESPACE.concat("select_AdvanceCollectCard_count"), condition);
    }


    @Override
    public List<AdvanceCollectCard> selectList(AdvanceCollectCard condition) {
        return super.selectList(NAMESPACE.concat("select_AdvanceCollectCard"), condition,
                AdvanceCollectCard.class);
    }


    @Override
    public List<AdvanceCollectCard> selectList(AdvanceCollectCard condition, int start, int count) {
        return super
                .selectList(NAMESPACE.concat("select_AdvanceCollectCard"), start, count, condition,
                        AdvanceCollectCard.class);
    }


}