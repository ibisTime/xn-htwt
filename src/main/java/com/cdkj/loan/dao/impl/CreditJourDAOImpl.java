package com.cdkj.loan.dao.impl;

import com.cdkj.loan.dao.ICreditJourDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CreditJour;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("creditJourDAOImpl")
public class CreditJourDAOImpl extends AMybatisTemplate
        implements ICreditJourDAO {

    @Override
    public int insert(CreditJour data) {
        return super.insert(NAMESPACE.concat("insert_creditJour"), data);
    }

    @Override
    public int delete(CreditJour data) {
        return super.delete(NAMESPACE.concat("delete_creditJour"), data);
    }

    @Override
    public CreditJour select(CreditJour condition) {
        return super.select(NAMESPACE.concat("select_creditJour"), condition,
                CreditJour.class);
    }

    @Override
    public long selectTotalCount(CreditJour condition) {
        return super.selectTotalCount(
                NAMESPACE.concat("select_creditJour_count"), condition);
    }

    @Override
    public List<CreditJour> selectList(CreditJour condition) {
        return super.selectList(NAMESPACE.concat("select_creditJour"),
                condition, CreditJour.class);
    }

    @Override
    public List<CreditJour> selectList(CreditJour condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_creditJour"), start,
                count, condition, CreditJour.class);
    }

    @Override
    public int update(CreditJour creditJour) {
        return super.update(NAMESPACE.concat("update_creditJour"), creditJour);
    }

    @Override
    public void insertList(List<CreditJour> jourList) {
        super.insertBatch(NAMESPACE.concat("insert_jourList"),
                (List) jourList);
    }
}
