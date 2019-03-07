package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Product;
import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.domain.SpecsOrder;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:23:54 
 * @history:
 */
public interface ISpecsOrderBO extends IPaginableBO<SpecsOrder> {

    public String saveProductOrder(String orderCode, String bankcardCode,
            Product product, ProductSpecs productSpecs, String userId,
            Integer quantity);

    public List<SpecsOrder> queryProductOrderList(SpecsOrder data);

    public List<SpecsOrder> queryProductOrderList(String orderCode);

    public SpecsOrder getProductOrder(String code);

    public void refereshStatus(SpecsOrder specsOrder, String status);

    public void deliverLogistics(SpecsOrder specsOrder,
            String logisticsCompany, String logisticsCode, String deliverer,
            String deliveryDatetime, String pdf, String updater, String remark);

    public List<SpecsOrder> queryListByOrderCode(String orderCode);

}
