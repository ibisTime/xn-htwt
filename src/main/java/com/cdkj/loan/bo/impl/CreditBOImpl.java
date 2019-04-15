package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.ICreditDAO;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ENewBizType;
import com.cdkj.loan.exception.BizException;

/**
 * 征信单
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:40:05 
 * @history:
 */
@Component
public class CreditBOImpl extends PaginableBOImpl<Credit> implements ICreditBO {

    @Autowired
    private ICreditDAO creditDAO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Override
    public String saveCredit(XN632110Req req, SYSUser sysUser, String bizCode,
            String nodeCode) {
        String code = null;
        Credit credit = new Credit();
        code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT.getCode());
        credit.setCode(code);
        credit.setLoanBankCode(req.getLoanBankCode());
        credit.setBizCode(bizCode);
        credit.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        credit.setBizType(req.getBizType());
        if (ENewBizType.second_hand.getCode().equals(req.getBizType())) {
            // 二手车报告
            EAttachName attachName = EAttachName.getMap().get(
                EAttachName.second_car_report.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getSecondCarReport());
            // 行驶证正面
            attachName = EAttachName.getMap().get(
                EAttachName.xsz_front.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getXszFront());
            // 行驶证反面
            attachName = EAttachName.getMap().get(
                EAttachName.xsz_reverse.getCode());
            attachmentBO.saveAttachment(bizCode, attachName.getCode(),
                attachName.getValue(), req.getXszReverse());
        }
        credit.setCompanyCode(sysUser.getCompanyCode());
        credit.setSaleUserId(sysUser.getUserId());
        credit.setTeamCode(sysUser.getTeamCode());
        credit.setApplyDatetime(new Date());

        credit.setNote(req.getNote());
        credit.setSaleUserName(sysUser.getRealName());
        credit.setCurNodeCode(nodeCode);
        creditDAO.insert(credit);

        return code;
    }

    @Override
    public Credit getCredit(String code) {
        Credit data = null;
        if (StringUtils.isNotBlank(code)) {
            Credit condition = new Credit();
            condition.setCode(code);
            data = creditDAO.select(condition);
            if (null == data) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "征信单不存在！");
            }
        }
        return data;
    }

    @Override
    public Credit getMoreCredit(String code) {
        Credit condition = new Credit();
        condition.setCode(code);
        Credit credit = creditDAO.select(condition);
        List<CreditUser> creditUserList = creditUserBO
            .queryCreditUserList(code);
        credit.setCreditUserList(creditUserList);
        return credit;
    }

    @Override
    public void refreshCredit(Credit data) {
        creditDAO.updateCredit(data);
    }

    @Override
    public void distributeLeaflets(Credit credit, String insideJob) {
        credit.setInsideJob(insideJob);
        creditDAO.distributeLeaflets(credit);
    }

    @Override
    public Paginable<Credit> getPaginableByRoleCode(int start, int limit,
            Credit condition) {
        prepare(condition);

        long totalCount = creditDAO.selectTotalCountByRoleCode(condition);

        Paginable<Credit> page = new Page<Credit>(start, limit, totalCount);

        List<Credit> dataList = creditDAO.selectReqBudgetByRoleCodeList(
            condition, page.getStart(), page.getPageSize());

        page.setList(dataList);
        return page;
    }

    @Override
    public Paginable<Credit> getPaginableByIsCancel(int start, int limit,
            Credit condition) {
        prepare(condition);

        long totalCount = creditDAO.selectTotalCountByIsCancel(condition);

        Paginable<Credit> page = new Page<Credit>(start, limit, totalCount);

        List<Credit> dataList = creditDAO.selectReqBudgetByIsCancel(condition,
            page.getStart(), page.getPageSize());

        page.setList(dataList);
        return page;
    }

    @Override
    public Paginable<Credit> getPaginableByNotCancel(int start, int limit,
            Credit condition) {
        prepare(condition);

        long totalCount = creditDAO.selectTotalCountByNotCancel(condition);

        Paginable<Credit> page = new Page<Credit>(start, limit, totalCount);

        List<Credit> dataList = creditDAO.selectReqBudgetByNotCancel(condition,
            page.getStart(), page.getPageSize());

        page.setList(dataList);
        return page;
    }

    @Override
    public void refreshCreditNode(Credit credit) {
        if (StringUtils.isNotBlank(credit.getCurNodeCode())) {
            creditDAO.updateNode(credit);
        }
    }

    @Override
    public void cancelCredit(Credit credit) {
        if (null != credit) {
            creditDAO.cancelCredit(credit);
        }
    }

    @Override
    public void setApplyUserInfo(String code, String userName, String mobile,
            String idNo) {
        Credit credit = new Credit();
        credit.setCode(code);
        credit.setUserName(userName);
        credit.setMobile(mobile);
        credit.setIdNo(idNo);
        creditDAO.setApplyUserInfo(credit);
    }

    @Override
    public void refreshInputBankCreditResult(Credit credit) {
        if (null != credit) {
            creditDAO.refreshInputBankCreditResult(credit);
        }
    }

    @Override
    public Credit getCreditBybudgetorder(String code) {
        Credit credit = new Credit();
        credit.setBudgetCode(code);
        return creditDAO.select(credit);
    }

    @Override
    public void refreshSecondCarReport(Credit credit) {
        creditDAO.updateSecondCarReport(credit);
    }

    @Override
    public void refreshCreditUser(Credit credit) {
        creditDAO.updateCreditUser(credit);
    }

    @Override
    public Credit getCreditByBizCode(String bizCode) {
        Credit condition = new Credit();
        condition.setBizCode(bizCode);

        return creditDAO.select(condition);
    }

}
