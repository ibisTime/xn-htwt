/**
 * @Title OrderBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午8:15:46 
 * @version V1.0   
 */
package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISpecsOrderBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ISpecsOrderDAO;
import com.cdkj.loan.domain.Product;
import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.domain.SpecsOrder;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EOrderStatus;
import com.cdkj.loan.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:15:46 
 * @history:
 */
@Component
public class SpecsOrderBOImpl extends PaginableBOImpl<SpecsOrder> implements
        ISpecsOrderBO {

    @Autowired
    private ISpecsOrderDAO specsOrderDAO;

    @Override
    public String saveProductOrder(String orderCode, String bankcardCode,
            Product product, ProductSpecs productSpecs, String userId,
            Integer quantity) {
        SpecsOrder productOrder = new SpecsOrder();
        productOrder.setCode(OrderNoGenerater
            .generate(EGeneratePrefix.PRODUCT_ORDER.getCode()));
        productOrder.setOrderCode(orderCode);
        productOrder.setProductCode(product.getCode());
        productOrder.setProductName(product.getName());
        productOrder.setProductSpecsCode(productSpecs.getCode());
        productOrder.setProductSpecsName(productSpecs.getName());
        productOrder.setBankcardCode(bankcardCode);
        productOrder.setUserId(userId);
        productOrder.setQuantity(quantity);
        productOrder.setPrice(productSpecs.getPrice());
        productOrder.setSfRate(productSpecs.getSfRate());
        productOrder.setSfAmount(AmountUtil.mul(productSpecs.getPrice(),
            productSpecs.getSfRate()));
        productOrder.setLoanAmount(productOrder.getPrice()
                - productOrder.getSfAmount());
        productOrder.setBankRate(productSpecs.getBankRate());
        productOrder.setPeriods(productSpecs.getPeriods());
        productOrder.setStatus(EOrderStatus.TO_PAY.getCode());
        specsOrderDAO.insert(productOrder);
        return productOrder.getCode();
    }

    @Override
    public List<SpecsOrder> queryProductOrderList(SpecsOrder condition) {
        return specsOrderDAO.selectList(condition);
    }

    @Override
    public SpecsOrder getProductOrder(String code) {
        SpecsOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            SpecsOrder condition = new SpecsOrder();
            condition.setCode(code);
            data = specsOrderDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "产品关联订单不存在");
            }
        }
        return data;
    }

    @Override
    public List<SpecsOrder> queryProductOrderList(String orderCode) {
        SpecsOrder condition = new SpecsOrder();
        condition.setOrderCode(orderCode);
        return specsOrderDAO.selectList(condition);
    }

    @Override
    public void refereshStatus(SpecsOrder specsOrder, String status) {
        specsOrder.setStatus(status);
        specsOrderDAO.updateStatus(specsOrder);
    }

    @Override
    public void deliverLogistics(SpecsOrder specsOrder,
            String logisticsCompany, String logisticsCode, String deliverer,
            String deliveryDatetime, String pdf, String updater, String remark) {
        specsOrder.setLogisticsCode(logisticsCode);
        specsOrder.setLogisticsCompany(logisticsCompany);
        specsOrder.setDeliverer(deliverer);
        specsOrder.setDeliveryDatetime(DateUtil.strToDate(deliveryDatetime,
            DateUtil.DATA_TIME_PATTERN_1));
        specsOrder.setPdf(pdf);
        specsOrder.setStatus(EOrderStatus.SEND.getCode());
        specsOrderDAO.deliver(specsOrder);
    }

    @Override
    public List<SpecsOrder> queryListByOrderCode(String orderCode) {
        SpecsOrder condition = new SpecsOrder();
        condition.setOrderCode(orderCode);
        List<SpecsOrder> dataList = specsOrderDAO.selectList(condition);
        return dataList;
    }

}
