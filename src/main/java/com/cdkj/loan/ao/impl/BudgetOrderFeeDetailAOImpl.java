package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBudgetOrderFeeDetailAO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.IBudgetOrderFeeDetailBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632160Req;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderFeeDetailStatus;
import com.cdkj.loan.enums.EDealType;

/**
 * 手续费明细
 * @author: jiafr 
 * @since: 2018年5月30日 下午9:07:49 
 * @history:
 */
@Service
public class BudgetOrderFeeDetailAOImpl implements IBudgetOrderFeeDetailAO {

    @Autowired
    private IBudgetOrderFeeDetailBO budgetOrderFeeDetailBO;

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    @Transactional
    public String addBudgetOrderFeeDetail(XN632160Req req) {

        BudgetOrderFeeDetail data = new BudgetOrderFeeDetail();
        data.setRemitType(req.getRemitType());
        data.setRemitProject(req.getRemitProject());
        data.setAmount(StringValidater.toLong(req.getAmount()));
        data.setPlatBankcard(req.getPlatBankcard());
        data.setRemitUser(req.getRemitUser());
        data.setReachDatetime(DateUtil.strToDate(req.getReachDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setRemark(req.getRemark());
        data.setFeeCode(req.getFeeCode());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setFeeCode(req.getFeeCode());

        // 保存
        if (EDealType.SAVE.getCode().equals(req.getDealType())) {

            BudgetOrderFeeDetail unSubmitBudgetOrderFeeDetail = budgetOrderFeeDetailBO
                .getBudgetOrderFeeDetailByStatus(req.getFeeCode(),
                    EBudgetOrderFeeDetailStatus.UNCOMMITTED.getCode());
            if (null != unSubmitBudgetOrderFeeDetail) {
                budgetOrderFeeDetailBO.removeBudgetOrderFeeDetail(
                    unSubmitBudgetOrderFeeDetail.getCode());
            }
            data.setStatus(EBudgetOrderFeeDetailStatus.UNCOMMITTED.getCode());

        }

        // 发送
        if (EDealType.SEND.getCode().equals(req.getDealType())) {
            data.setStatus(EBudgetOrderFeeDetailStatus.SUBMITTED.getCode());
            BudgetOrderFee budgetOrderFee = budgetOrderFeeBO
                .getBudgetOrderFee(req.getFeeCode());
            budgetOrderFee.setRealAmount(
                budgetOrderFee.getRealAmount() + data.getAmount());
            if (budgetOrderFee.getRealAmount().longValue() >= budgetOrderFee
                .getShouldAmount().longValue()) {
                budgetOrderFee.setIsSettled(EBoolean.YES.getCode());
            } else {
                budgetOrderFee.setIsSettled(EBoolean.NO.getCode());
            }
            budgetOrderFeeBO.refreshBudgetOrderFee(budgetOrderFee);
        }

        String orderFeeDetailCode = budgetOrderFeeDetailBO
            .saveBudgetOrderFeeDetail(data);

        return orderFeeDetailCode;
    }

    @Override
    public Paginable<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailPage(
            int start, int limit, BudgetOrderFeeDetail condition) {
        Paginable<BudgetOrderFeeDetail> paginable = budgetOrderFeeDetailBO
            .getPaginable(start, limit, condition);
        for (BudgetOrderFeeDetail budgetOrderFeeDetail : paginable.getList()) {
            initBudgetOrderFeeDetail(budgetOrderFeeDetail);
        }
        return paginable;
    }

    @Override
    public List<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailList(
            BudgetOrderFeeDetail condition) {
        return budgetOrderFeeDetailBO.queryBudgetOrderFeeDetailList(condition);
    }

    @Override
    public BudgetOrderFeeDetail getBudgetOrderFeeDetail(String code) {
        BudgetOrderFeeDetail budgetOrderFeeDetail = budgetOrderFeeDetailBO
            .getBudgetOrderFeeDetail(code);
        initBudgetOrderFeeDetail(budgetOrderFeeDetail);
        return budgetOrderFeeDetail;
    }

    private void initBudgetOrderFeeDetail(
            BudgetOrderFeeDetail budgetOrderFeeDetail) {
        if (StringUtils.isNotBlank(budgetOrderFeeDetail.getUpdater())) {
            SYSUser user = sysUserBO.getUser(budgetOrderFeeDetail.getUpdater());
            budgetOrderFeeDetail.setUpdaterRealName(user.getRealName());
        }

    }
}
