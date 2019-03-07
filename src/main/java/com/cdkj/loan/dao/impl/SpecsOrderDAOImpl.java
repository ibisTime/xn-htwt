/**
 * @Title InvoiceModelDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午8:33:38 
 * @version V1.0   
 */
package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISpecsOrderDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SpecsOrder;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:33:38 
 * @history:
 */
@Repository("specsOrderDAOImpl")
public class SpecsOrderDAOImpl extends AMybatisTemplate implements
        ISpecsOrderDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(SpecsOrder data) {
        return super.insert(NAMESPACE.concat("insert_specsOrder"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(SpecsOrder data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public SpecsOrder select(SpecsOrder condition) {
        return super.select(NAMESPACE.concat("select_specsOrder"), condition,
            SpecsOrder.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public long selectTotalCount(SpecsOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_specsOrder_count"), condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<SpecsOrder> selectList(SpecsOrder condition) {
        return super.selectList(NAMESPACE.concat("select_specsOrder"),
            condition, SpecsOrder.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<SpecsOrder> selectList(SpecsOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_specsOrder"), start,
            count, condition, SpecsOrder.class);
    }

    @Override
    public int updateStatus(SpecsOrder data) {
        return super.update(NAMESPACE.concat("update_specsOrder_status"), data);
    }

    @Override
    public int deliver(SpecsOrder data) {
        return super
            .update(NAMESPACE.concat("update_specsOrder_deliver"), data);
    }
}
