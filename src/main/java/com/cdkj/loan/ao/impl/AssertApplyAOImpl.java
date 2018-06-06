package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IAssertApplyAO;
import com.cdkj.loan.bo.IAssertApplyBO;
import com.cdkj.loan.bo.IAssertGoodsBO;
import com.cdkj.loan.bo.IAssertUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.AssertApply;
import com.cdkj.loan.domain.AssertGoods;
import com.cdkj.loan.domain.AssertUser;
import com.cdkj.loan.dto.req.XN632640Req;
import com.cdkj.loan.dto.req.XN632640ReqChild1;
import com.cdkj.loan.dto.req.XN632640ReqChild2;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:33:14 
 * @history:
 */
@Service
public class AssertApplyAOImpl implements IAssertApplyAO {

    @Autowired
    private IAssertApplyBO assertApplyBO;

    @Autowired
    private IAssertGoodsBO assertGoodsBO;

    @Autowired
    private IAssertUserBO assertUserBO;

    @Override
    public String addAssertApply(XN632640Req req) {
        AssertApply data = new AssertApply();
        data.setApplyNote(req.getApplyNote());
        data.setIsPrint(req.getIsPrint());
        data.setRemark(req.getRemark());
        data.setPdf(req.getPdf());
        data.setApplyUser(req.getApplyUser());
        data.setType(req.getType());
        data.setStatus("0");
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        String code = assertApplyBO.saveAssertApply(data);

        List<XN632640ReqChild1> list1 = req.getList1();
        for (XN632640ReqChild1 child1 : list1) {
            AssertGoods data1 = new AssertGoods();
            data1.setAssertCode(code);
            data1.setProductCode(child1.getProductCode());
            data1.setMode(child1.getMode());
            data1.setQuantity(child1.getQuantity());
            data1.setPrice(child1.getPrice());
            data1.setRemark(child1.getRemark());
            assertGoodsBO.saveAssertGoods(data1);
        }

        List<XN632640ReqChild2> list2 = req.getList2();
        for (XN632640ReqChild2 child2 : list2) {
            AssertUser data2 = new AssertUser();
            data2.setAssertCode(code);
            data2.setPrintQuantity(child2.getPrintQuantity());
            data2.setUserId(child2.getUserId());
            assertUserBO.saveAssertUser(data2);
        }

        return code;
    }

    @Override
    public int editAssertApply(AssertApply data) {
        if (!assertApplyBO.isAssertApplyExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return assertApplyBO.refreshAssertApply(data);
    }

    @Override
    public int dropAssertApply(String code) {
        if (!assertApplyBO.isAssertApplyExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return assertApplyBO.removeAssertApply(code);
    }

    @Override
    public Paginable<AssertApply> queryAssertApplyPage(int start, int limit,
            AssertApply condition) {
        return assertApplyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<AssertApply> queryAssertApplyList(AssertApply condition) {
        return assertApplyBO.queryAssertApplyList(condition);
    }

    @Override
    public AssertApply getAssertApply(String code) {
        return assertApplyBO.getAssertApply(code);
    }

}
