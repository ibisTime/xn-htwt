package com.cdkj.loan.dao.impl;

import com.cdkj.loan.dao.IBrandLogoDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BrandLogo;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository("brandLogoDAOImpl")
public class BrandLogoDAOImpl extends AMybatisTemplate implements IBrandLogoDAO {


    @Override
    public int insert(BrandLogo data) {
        return super.insert(NAMESPACE.concat("insert_BrandLogo"), data);
    }

    @Override
    public void insertBrandLogoList(List<BrandLogo> list) {
        super.insertBatch(NAMESPACE.concat("insert_brandLogoList"), (List) list);
    }


    @Override
    public int delete(BrandLogo data) {
        return super.delete(NAMESPACE.concat("delete_BrandLogo"), data);
    }


    @Override
    public BrandLogo select(BrandLogo condition) {
        return super.select(NAMESPACE.concat("select_BrandLogo"), condition, BrandLogo.class);
    }


    @Override
    public long selectTotalCount(BrandLogo condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_BrandLogo_count"), condition);
    }


    @Override
    public List<BrandLogo> selectList(BrandLogo condition) {
        return super.selectList(NAMESPACE.concat("select_BrandLogo"), condition, BrandLogo.class);
    }


    @Override
    public List<BrandLogo> selectList(BrandLogo condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_BrandLogo"), start, count, condition,
                BrandLogo.class);
    }


    @Override
    public int update(BrandLogo data) {
        return super.update(NAMESPACE.concat("update_BrandLogo"), data);
    }
}