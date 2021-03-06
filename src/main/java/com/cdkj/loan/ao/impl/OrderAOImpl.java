/**
 * @Title OrderAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午9:37:32 
 * @version V1.0   
 */
package com.cdkj.loan.ao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IExpressRuleBO;
import com.cdkj.loan.bo.IOrderBO;
import com.cdkj.loan.bo.IProductBO;
import com.cdkj.loan.bo.IProductSpecsBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.ISpecsOrderBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.common.ProvinceUtil;
import com.cdkj.loan.core.CalculationUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.domain.Product;
import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SpecsOrder;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN808050Req;
import com.cdkj.loan.dto.req.XN808054Req;
import com.cdkj.loan.dto.req.XN808058Req;
import com.cdkj.loan.dto.req.XN808070CReq;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.dto.res.XN003020Res;
import com.cdkj.loan.enums.EAccountStatus;
import com.cdkj.loan.enums.EAccountType;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizType;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EOrderStatus;
import com.cdkj.loan.enums.EPayType;
import com.cdkj.loan.enums.EProductStatus;
import com.cdkj.loan.enums.ESystemCode;
import com.cdkj.loan.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午9:37:32 
 * @history:
 */
@Service
public class OrderAOImpl implements IOrderAO {

    protected static final Logger logger = LoggerFactory
        .getLogger(OrderAOImpl.class);

    @Autowired
    private IOrderBO orderBO;

    @Autowired
    private ISpecsOrderBO specsOrderBO;

    @Autowired
    private IProductSpecsBO productSpecsBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IProductBO productBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Autowired
    private IExpressRuleBO expressRuleBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Override
    @Transactional
    public String commitOrder(XN808050Req req) {

        // 生成订单基本信息
        Order order = new Order();

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.ORDER.getCode());

        // 总信用分
        BigDecimal creditScore = BigDecimal.ZERO;

        // 订单金额
        Long amount = 0L;

        // 计算订单运费，暂时不考虑运费
        Long yunfei = 0L;

        // 判断是否有真实姓名
        User user = userBO.getUser(req.getApplyUser());
        if (StringUtils.isBlank(user.getRealName())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "你还没有填写真实姓名，请实名认证后下单！");
        }
        for (XN808058Req req2 : req.getSpecsList()) {

            ProductSpecs productSpecs = productSpecsBO.getProductSpecs(req2
                .getSpecsCode());
            // 检查产品状态
            Product product = productBO.getProduct(productSpecs
                .getProductCode());
            if (!EProductStatus.PUBLISH_YES.getCode().equals(
                product.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该产品未上架，不能下单");
            }

            // 判断库存是否充足（暂时不考虑库存）
            // Integer quantity = StringValidater.toInteger(req.getQuantity());
            // if (productSpecs.getQuantity() - quantity < 0) {
            // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
            // "库存不够，不能下单");
            // }
            // 计算重量
            Double weight = AmountUtil.mulAB(productSpecs.getWeight(),
                StringValidater.toInteger(req2.getQuantity()));
            // 计算总价格
            if (null != productSpecs.getPrice()) {
                amount = amount
                        + (StringValidater.toInteger(req2.getQuantity()) * productSpecs
                            .getPrice());
            }

            // if (!EBoolean.NO.getCode().equals(req.getIsNeedYunfei())) {
            // // 运费设置
            // String addRessProvince = ProvinceUtil
            // .getProvince(req.getReAddress());
            // XN003020Res expressRule = expressRuleBO.getPrice("浙江省",
            // addRessProvince, weight, ESystemCode.HTWT.getCode(),
            // ESystemCode.HTWT.getCode());// 运费人民币
            // yunfei = expressRule.getExpressFee();
            // }
            // 计算信用分
            creditScore = creditScore.add(new BigDecimal(product
                .getCreditScore()));

            // 落地订单产品关联信息
            specsOrderBO.saveProductOrder(code, req.getBankcardCode(), product,
                productSpecs, req.getApplyUser(),
                StringValidater.toInteger(req2.getQuantity()));
        }

        // 判断信用分是否足够
        Account account = new Account();
        account.setUserId(req.getApplyUser());
        account.setType(EAccountType.Customer.getCode());
        account.setStatus(EAccountStatus.NORMAL.getCode());
        account.setCurrency(ECurrency.XYF.getCode());
        Account domain = accountBO.queryAccountListByCurrency(account);
        int compareTo = creditScore.compareTo(domain.getAmount());
        if (compareTo == 1) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "信用分低于商品的最低信用分，不能下单！");
        }

        order.setCode(code);
        order.setReceiver(req.getReceiver());
        order.setReMobile(req.getReMobile());
        order.setReAddress(req.getReAddress());
        order.setApplyUser(req.getApplyUser());

        order.setApplyNote(req.getApplyNote());
        order.setApplyDatetime(new Date());
        order.setAmount(amount);
        order.setYunfei(yunfei);

        order.setStatus(EOrderStatus.TO_PAY.getCode());

        order.setPayAmount(0L);
        order.setUpdater(req.getApplyUser());
        order.setUpdateDatetime(new Date());
        order.setRemark("订单新提交，待支付");

        // 落地订单
        orderBO.saveOrder(order);
        return code;

    }

    @Override
    public void modifyYunfei(String code, Long yunfei) {
        Order order = orderBO.getOrder(code);
        if (!EOrderStatus.TO_PAY.getCode().equals(order.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "订单不处于待支付状态,不能修改运费");
        }
        orderBO.refreshYunfei(order, yunfei);
        User user = userBO.getUser(order.getApplyUser());
        // 发短信
        smsOutBO.sendSmsOut(
            user.getMobile(),
            "尊敬的用户，您的待支付订单[" + order.getCode() + "]运费已成功修改为"
                    + CalculationUtil.diviDown(yunfei) + "元，请及时支付订单");
    }

    @Override
    @Transactional
    public Object toPayOrder(String code, String payType, String tradePwd) {

        String isDk = "0";

        Order order = orderBO.getOrder(code);
        if (!EOrderStatus.TO_PAY.getCode().equals(order.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "订单不处于待支付状态");
        }

        // 判断支付密码
        userBO.checkTradePwd(order.getApplyUser(), tradePwd);

        // 验证产品是否有未上架的
        doCheckProductOnline(order);

        List<SpecsOrder> specsOrders = specsOrderBO.queryListByOrderCode(order
            .getCode());
        for (SpecsOrder specsOrder : specsOrders) {
            RepayBiz repayBiz = repayBizBO
                .generateProductLoanRepayBiz(specsOrder);
            repayPlanBO.genereateNewRepayPlan(repayBiz);
        }

        List<SpecsOrder> orderList = specsOrderBO.queryListByOrderCode(code);
        for (SpecsOrder specsOrder : orderList) {

            specsOrderBO.refereshStatus(specsOrder,
                EOrderStatus.PAY_YES.getCode());
        }

        return toPayOrder(order, payType, isDk);
    }

    private Object toPayOrder(Order order, String payType, String isDk) {
        User user = userBO.getUser(order.getApplyUser());
        if (EPayType.YE.getCode().equals(payType)) {
            return toPayOrderYE(order, user, isDk);
            // } else if (EPayType.WITHHOLD.getCode().equals(payType)) {
            // return toPayOrderWithhold(order, user, isDk);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "支付类型不支持");
        }
    }

    private Object toPayOrderYE(Order order, User user, String isDk) {
        // String buyUser = user.getUserId();
        // EBizType bizType = EBizType.AJ_GW;
        // XN808071Res dkAmountRes = getOrderDkAmount(order, isDk);
        // Long orderAmount = order.getAmount1() + order.getYunfei()
        // - dkAmountRes.getCnyAmount();// 人民币金额
        // Account rmbAccount = accountBO.getRemoteAccount(buyUser,
        // ECurrency.CNY);
        // Account hyXjkAccount = accountBO.getRemoteAccount(buyUser,
        // ECurrency.HW_XJK);
        // if (orderAmount > (rmbAccount.getAmount() +
        // hyXjkAccount.getAmount())) {
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(), "账户余额不足");
        // }
        // Long jfAmount = order.getAmount2() + dkAmountRes.getJfAmount();//
        // 积分金额
        // Account jfAccount = accountBO.getRemoteAccount(buyUser,
        // ECurrency.JF);
        // if (jfAmount > jfAccount.getAmount()) {
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(), "积分不足");
        // }
        // Long cnyAmount = 0L;
        // Long xjkAmount = 0L;
        // // 先扣除小金库余额,再扣除账户余额
        // if (orderAmount > hyXjkAccount.getAmount()) {
        // xjkAmount = hyXjkAccount.getAmount();
        // accountBO.doTransferAmountRemote(buyUser,
        // ESysUser.SYS_USER_HW.getCode(), ECurrency.HW_XJK, xjkAmount,
        // bizType, bizType.getValue(), bizType.getValue(),
        // order.getCode());
        // cnyAmount = orderAmount - xjkAmount;
        // accountBO.doTransferAmountRemote(buyUser,
        // ESysUser.SYS_USER_HW.getCode(), ECurrency.CNY, cnyAmount,
        // bizType, bizType.getValue(), bizType.getValue(),
        // order.getCode());
        // } else {
        // xjkAmount = orderAmount;
        // accountBO.doTransferAmountRemote(buyUser,
        // ESysUser.SYS_USER_HW.getCode(), ECurrency.HW_XJK, orderAmount,
        // bizType, bizType.getValue(), bizType.getValue(),
        // order.getCode());
        // }
        // // 再扣除积分金额
        // accountBO.doTransferAmountRemote(buyUser,
        // ESysUser.SYS_USER_HW.getCode(), ECurrency.JF, jfAmount, bizType,
        // bizType.getValue(), bizType.getValue(), order.getCode());
        //
        // // 更新订单支付金额
        // orderBO.refreshPayYESuccess(order, cnyAmount, jfAmount, xjkAmount,
        // EPayType.YE.getCode(), dkAmountRes.getCnyAmount(),
        // dkAmountRes.getJfAmount());
        // 这个方法只修改状态，上面的方法取消注释后删除
        orderBO.refreshStatus(order);
        // List<ProductOrder> productOrders = productOrderBO
        // .queryProductOrderList(order.getCode());
        // for (ProductOrder productOrder : productOrders) {
        // // 更新库存
        // productSpecsBO.refreshQuantity(productOrder.getProductSpecsCode(),
        // productOrder.getQuantity());
        // }
        return new BooleanRes(true);
    }

    private Object toPayOrderWithhold(Order order, User user, String isDk) {
        // XN808071Res dkAmountRes = getOrderDkAmount(order, isDk);
        // Long jfAmount = order.getAmount2() + dkAmountRes.getJfAmount();//
        // 积分金额
        // Account jfAccount = accountBO.getRemoteAccount(user.getUserId(),
        // ECurrency.JF);
        // if (jfAmount > jfAccount.getAmount()) {
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(), "积分不足");
        // }
        // String payGroup = orderBO.addPayGroup(order.getCode(),
        // EPayType.WECHAT_H5, dkAmountRes.getCnyAmount(),
        // dkAmountRes.getJfAmount());
        // Long orderAmount = order.getAmount1() + order.getYunfei()
        // - dkAmountRes.getCnyAmount();// 人民币金额
        // return accountBO.doWeiXinH5PayRemote(user.getUserId(),
        // user.getOpenId(),
        // ESysUser.SYS_USER_HW.getCode(), payGroup, order.getCode(),
        // EBizType.AJ_GW, EBizType.AJ_GW.getValue(), orderAmount);
        return new BooleanRes(true);
    }

    /** 
     * @param order 
     * @create: 2017年5月2日 下午5:19:38 xieyj
     * @history: 
     */
    private void doCheckProductOnline(Order order) {
        List<SpecsOrder> prodList = specsOrderBO.queryProductOrderList(order
            .getCode());
        if (CollectionUtils.isNotEmpty(prodList)) {
            for (SpecsOrder productOrder : prodList) {
                Product product = productBO.getProduct(productOrder
                    .getProductCode());
                if (!EProductStatus.PUBLISH_YES.getCode().equals(
                    product.getStatus())) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "订单中有未上架产品，不能支付");
                }
            }
        }
    }

    @Override
    public void userCancel(String code, String userId, String remark) {
        Order data = orderBO.getOrder(code);
        if (!EOrderStatus.TO_PAY.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "订单状态不是待支付状态，不能进行取消操作");
        }
        orderBO.userCancel(code, userId, remark);

        List<SpecsOrder> orderList = specsOrderBO.queryListByOrderCode(code);
        for (SpecsOrder specsOrder : orderList) {

            specsOrderBO
                .refereshStatus(specsOrder, EOrderStatus.YHYC.getCode());
        }
    }

    @Override
    @Transactional
    public void platCancel(List<String> codeList, String updater, String remark) {
        for (String code : codeList) {
            platCancelSingle(code, updater, remark);
        }
    }

    private void platCancelSingle(String code, String updater, String remark) {
        Order order = orderBO.getOrder(code);
        if (!EOrderStatus.PAY_YES.getCode().equals(order.getStatus())
                && !EOrderStatus.SEND.getCode().equals(order.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该订单不是支付成功或已发货状态，无法操作");
        }
        String status = null;
        if (EOrderStatus.PAY_YES.getCode().equals(order.getStatus())) {
            status = EOrderStatus.SHYC.getCode();
        } else if (EOrderStatus.SEND.getCode().equals(order.getStatus())) {
            status = EOrderStatus.KDYC.getCode();
        }

        // 退款
        EBizType eBizType = EBizType.AJ_GWTK;

        // accountBO.transAmountCZB(ESysUser.SYS_USER_HTWT.getCode(),
        // order.getApplyUser(), ECurrency.CNY.getCode(), order.getPayAmount(),
        // eBizType, eBizType.getValue(), eBizType.getValue(),
        // order.getCode());

        List<SpecsOrder> productOrders = specsOrderBO
            .queryProductOrderList(order.getCode());
        for (SpecsOrder productOrder : productOrders) {
            // 更新库存
            Integer quantity = -productOrder.getQuantity();
            productSpecsBO.refreshQuantity(productOrder.getProductSpecsCode(),
                quantity);
        }

        // 更新订单信息
        orderBO.platCancel(code, updater, remark, status);

        User user = userBO.getUser(order.getApplyUser());
        // 发送短信
        if (StringUtils.isNotBlank(remark)) {
            remark = ",取消原因是：" + remark;
        } else {
            remark = "";
        }
        smsOutBO.sendSmsOut(user.getMobile(), "尊敬的用户，您的订单[" + order.getCode()
                + "]已取消" + remark + ",请及时查看退款。");
    }

    @Override
    public Paginable<Order> queryOrderPage(int start, int limit, Order condition) {
        Paginable<Order> page = orderBO.getPaginable(start, limit, condition);
        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (Order order : page.getList()) {
                order.setUser(userBO.getUser(order.getApplyUser()));
                SpecsOrder imCondition = new SpecsOrder();
                imCondition.setOrderCode(order.getCode());
                List<SpecsOrder> productOrderList = specsOrderBO
                    .queryProductOrderList(imCondition);
                order.setProductOrderList(productOrderList);
            }
        }
        return page;
    }

    @Override
    public Paginable<Order> queryMyOrderPage(int start, int limit,
            Order condition) {

        Paginable<Order> page = orderBO.getPaginable(start, limit, condition);
        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (Order order : page.getList()) {
                SpecsOrder imCondition = new SpecsOrder();
                imCondition.setOrderCode(order.getCode());
                List<SpecsOrder> productOrderList = specsOrderBO
                    .queryProductOrderList(imCondition);
                order.setProductOrderList(productOrderList);
            }
        }
        return page;
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#queryOrderList(com.xnjr.mall.domain.Order)
     */
    @Override
    public List<Order> queryOrderList(Order condition) {
        List<Order> list = orderBO.queryOrderList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Order order : list) {
                SpecsOrder imCondition = new SpecsOrder();
                imCondition.setOrderCode(order.getCode());
                List<SpecsOrder> productOrderList = specsOrderBO
                    .queryProductOrderList(imCondition);
                order.setProductOrderList(productOrderList);
                order.setUser(userBO.getUser(order.getApplyUser()));
            }
        }
        return list;
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#getOrder(java.lang.String)
     */
    @Override
    public Order getOrder(String code) {
        Order order = orderBO.getOrder(code);
        order.setUser(userBO.getUser(order.getApplyUser()));
        SpecsOrder imCondition = new SpecsOrder();
        imCondition.setOrderCode(order.getCode());
        List<SpecsOrder> productOrderList = specsOrderBO
            .queryProductOrderList(imCondition);
        order.setProductOrderList(productOrderList);
        order.setUser(userBO.getUser(order.getApplyUser()));
        return order;
    }

    @Override
    @Transactional
    public void deliverLogistics(XN808054Req req) {
        SpecsOrder specsOrder = specsOrderBO.getProductOrder(req.getCode());
        if (!EOrderStatus.PAY_YES.getCode().equalsIgnoreCase(
            specsOrder.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "订单不是已支付状态，无法操作");
        }
        specsOrderBO.deliverLogistics(specsOrder, req.getLogisticsCompany(),
            req.getLogisticsCode(), req.getDeliverer(),
            req.getDeliveryDatetime(), req.getPdf(), req.getUpdater(),
            req.getRemark());

        Order order = orderBO.getOrder(specsOrder.getOrderCode());

        // 发送短信
        User user = userBO.getUser(order.getApplyUser());
        String notice = "";
        notice = "尊敬的用户，您的订单[" + order.getCode() + "]中的商品["
                + specsOrder.getProductName() + "]已发货，请注意查收。";
        smsOutBO.sendSmsOut(user.getMobile(), notice);

    }

    @Override
    @Transactional
    public void confirm(String code, String updater, String remark) {
        SpecsOrder specsOrder = specsOrderBO.getProductOrder(code);
        if (!EOrderStatus.SEND.getCode().equalsIgnoreCase(
            specsOrder.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "订单不是已发货状态，无法操作");
        }
        doConfirm(specsOrder, updater, remark);
    }

    private void doConfirm(SpecsOrder specsOrder, String updater, String remark) {

        specsOrderBO.refereshStatus(specsOrder, EOrderStatus.RECEIVE.getCode());
        // 更新产品的已购买人数
        productBO.updateBoughtCount(specsOrder.getProductCode(),
            specsOrder.getQuantity());

    }

    @Override
    @Transactional
    public void paySuccessHW(String payGroup, String payCode, Long amount) {
        // List<Order> orderList = orderBO.queryOrderListByPayGroup(payGroup);
        // if (CollectionUtils.isEmpty(orderList)) {
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
        // "找不到对应的订单记录");
        // }
        // Order order = orderList.get(0);
        // if (EOrderStatus.TO_PAY.getCode().equals(order.getStatus())) {
        // Long orderAmount = order.getAmount1().longValue()
        // + order.getYunfei() - order.getDkAmount();
        // Long jfAmount = order.getAmount2() + order.getDkJfAmount();// 积分金额
        // // 更新订单支付金额
        // orderBO.refreshPaySuccess(order, orderAmount, jfAmount, 0L,
        // payCode);
        // List<ProductOrder> productOrders = productOrderBO
        // .queryProductOrderList(order.getCode());
        // for (ProductOrder productOrder : productOrders) {
        // // 更新库存
        // productSpecsBO.refreshQuantity(
        // productOrder.getProductSpecsCode(),
        // productOrder.getQuantity());
        // }
        // // 扣除积分
        // accountBO.doTransferAmountRemote(order.getApplyUser(),
        // ESysUser.SYS_USER_HW.getCode(), ECurrency.JF, jfAmount,
        // EBizType.AJ_GW, EBizType.AJ_GW.getValue(),
        // EBizType.AJ_GW.getValue(), order.getCode());
        // } else {
        // logger.info("订单号：" + order.getCode() + "已支付，重复回调");
        // }
    }

    @Override
    public void doChangeOrderStatusDaily() {
        doChangeNoPayOrder();
        doChangeToTakeOrder();// 系统确认收货
    }

    private void doChangeNoPayOrder() {
        logger.info("***************开始扫描未支付订单***************");
        // SYSConfig sysConfig = sysConfigBO.getSYSConfig(
        // SysConstants.CANCEL_ORDER_DAYS, ESystemCode.HW.getCode());
        // Integer cancelOrderDays = Integer.valueOf(sysConfig.getCvalue());
        // Order condition = new Order();
        // condition.setStatus(EOrderStatus.TO_PAY.getCode());
        // // 两天内还未支付的订单
        // condition.setApplyDatetimeEnd(
        // DateUtil.getRelativeDate(DateUtil.getTodayStart(),
        // -(60 * 60 * 24 * (cancelOrderDays - 1) + 1)));
        // List<Order> orderList = orderBO.queryOrderList(condition);
        // if (CollectionUtils.isNotEmpty(orderList)) {
        // for (Order order : orderList) {
        // orderBO.userCancel(order.getCode(), "system", "超时未支付，系统自动取消");
        // }
        // }
        logger.info("***************结束扫描未支付订单***************");
    }

    private void doChangeToTakeOrder() {
        // SYSConfig sysConfig = sysConfigBO.getSYSConfig(
        // SysConstants.CONFIRM_ORDER_DAYS, ESystemCode.HW.getCode());
        // Integer confirmOrderDays = Integer.valueOf(sysConfig.getCvalue());
        // logger.info("***************开始扫描" + confirmOrderDays
        // + "天未收货确认收货订单***************");
        // Order condition = new Order();
        // condition.setStatus(EOrderStatus.SEND.getCode());
        // condition.setDeliveryDatetimeEnd(
        // DateUtil.getRelativeDate(DateUtil.getTodayStart(),
        // -(60 * 60 * 24 * (confirmOrderDays - 1) + 1)));
        // List<Order> orderList = orderBO.queryOrderList(condition);
        // if (CollectionUtils.isNotEmpty(orderList)) {
        // for (Order order : orderList) {
        // try {
        // confirm(order.getCode(), "system",
        // confirmOrderDays + "天未收货，系统自动确认收货");
        // } catch (Exception e) {
        // logger.error(confirmOrderDays + "天未收货订单号：" + order.getCode()
        // + ",异常如下：" + e.getMessage());
        // }
        // }
        // }
        // logger.info("***************结束扫描" + confirmOrderDays
        // + "天未收货确认收货订单***************");
    }

    @Override
    public XN003020Res getExpressFee(List<XN808070CReq> list, String address) {
        double weight = 0.0;
        String companyCode = ESystemCode.HTWT.getCode();
        String systemCode = ESystemCode.HTWT.getCode();
        // 统计重量地址
        for (XN808070CReq cReq : list) {
            ProductSpecs ps = productSpecsBO.getProductSpecs(cReq
                .getProductSpecsCode());
            weight = weight
                    + AmountUtil.mulAB(Long.valueOf(cReq.getQuantity()),
                        ps.getWeight());
        }

        // 运费设置
        String addRessProvince = ProvinceUtil.getProvince(address);
        return expressRuleBO.getPrice("浙江省", addRessProvince, weight,
            companyCode, systemCode);// 运费人民币
    }

    @Override
    public void dropOrderCancelByUser(String code) {
        Order order = orderBO.getOrder(code);
        if (!EOrderStatus.YHYC.getCode().equals(order.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "订单不是已取消状态，不能删除");
        }
        orderBO.removeOrder(code);
    }

    @Override
    public List<SpecsOrder> querySpecsOrders(SpecsOrder condition) {

        return specsOrderBO.queryProductOrderList(condition);
    }

    @Override
    public Paginable<SpecsOrder> querySpecsOrderPage(int start, int limit,
            SpecsOrder condition) {
        return specsOrderBO.getPaginable(start, limit, condition);
    }

    @Override
    public SpecsOrder getSpecsOrder(String code) {
        return specsOrderBO.getProductOrder(code);
    }

}
