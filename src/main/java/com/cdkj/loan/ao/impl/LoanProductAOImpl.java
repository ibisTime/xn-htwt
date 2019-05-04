package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ILoanProductAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.dto.req.XN632170Req;
import com.cdkj.loan.dto.req.XN632172Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ELoanProductStatus;
import com.cdkj.loan.enums.EProductStatus;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:59:00 
 * @history:
 */
@Service
public class LoanProductAOImpl implements ILoanProductAO {
    @Autowired
    private ILoanProductBO loanProductBO;

    @Autowired
    private IBankBO bankBO;

    @Override
    public String saveLoanProduct(XN632170Req req) {
        //@TODO 验证产品是否重复

        LoanProduct data = new LoanProduct();
        BeanUtils.copyProperties(req, data);
        String code = OrderNoGenerater.generate(EGeneratePrefix.LOAN_PRODUCT
            .getCode());
        data.setCode(code);
        data.setWanFactor(StringValidater.toLong(req.getWanFactor()));

        data.setYearRate(StringValidater.toDouble(req.getYearRate()));
        data.setAuthRate(StringValidater.toDouble(req.getAuthRate()));
        data.setPreRate(StringValidater.toDouble(req.getPreRate()));

        data.setAssureFee(StringValidater.toLong(req.getAssureFee()));

        data.setAssureRate(StringValidater.toDouble(req.getAssureRate()));
        data.setLyAmountFee(StringValidater.toLong(req.getLyAmountFee()));
        data.setLyAmountRate(StringValidater.toDouble(req.getLyAmountRate()));

        data.setGpsFee(StringValidater.toLong(req.getGpsFee()));
        data.setGpsRate(StringValidater.toDouble(req.getGpsRate()));
        data.setOtherFee(StringValidater.toLong(req.getOtherFee()));
        data.setOtherRate(StringValidater.toDouble(req.getOtherRate()));

        data.setIntroduceFee(StringValidater.toLong(req.getIntroduceFee()));
        data.setIntroduceRate(StringValidater.toDouble(req.getIntroduceRate()));
        data.setReturnPointFee(StringValidater.toLong(req.getReturnPointFee()));
        data.setReturnPointRate(StringValidater.toDouble(req
                .getReturnPointRate()));

        data.setInsuAgencyYear1Fee(StringValidater.toLong(req
                .getInsuAgencyYear1Fee()));
        data.setInsuAgencyYear2Fee(StringValidater.toLong(req
                .getInsuAgencyYear2Fee()));
        data.setInsuAgencyYear3Fee(StringValidater.toLong(req
                .getInsuAgencyYear3Fee()));

        data.setStatus(EProductStatus.TO_PUBLISH.getCode());
        data.setUpdateDatetime(new Date());
        loanProductBO.saveLoanProduct(data);

        return code;
    }

    @Override
    public void dropLoanProduct(String code) {
        loanProductBO.dropLoanProduct(code);
    }

    @Override
    public void editLoanProduct(XN632172Req req) {
        // 验证状态
        LoanProduct data = loanProductBO.getLoanProduct(req.getCode());
        if (!ELoanProductStatus.TO_PUBLISH.getCode().equals(data.getStatus())
                && !ELoanProductStatus.PUBLISH_NO.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请下架后修改");
        }

        BeanUtils.copyProperties(req, data);
        data.setWanFactor(StringValidater.toLong(req.getWanFactor()));

        data.setYearRate(StringValidater.toDouble(req.getYearRate()));
        data.setAuthRate(StringValidater.toDouble(req.getAuthRate()));
        data.setPreRate(StringValidater.toDouble(req.getPreRate()));

        data.setAssureFee(StringValidater.toLong(req.getAssureFee()));

        data.setAssureRate(StringValidater.toDouble(req.getAssureRate()));
        data.setLyAmountFee(StringValidater.toLong(req.getLyAmountFee()));
        data.setLyAmountRate(StringValidater.toDouble(req.getLyAmountRate()));

        data.setGpsFee(StringValidater.toLong(req.getGpsFee()));
        data.setGpsRate(StringValidater.toDouble(req.getGpsRate()));
        data.setOtherFee(StringValidater.toLong(req.getOtherFee()));
        data.setOtherRate(StringValidater.toDouble(req.getOtherRate()));

        data.setIntroduceFee(StringValidater.toLong(req.getIntroduceFee()));
        data.setIntroduceRate(StringValidater.toDouble(req.getIntroduceRate()));
        data.setReturnPointFee(StringValidater.toLong(req.getReturnPointFee()));
        data.setReturnPointRate(StringValidater.toDouble(req
                .getReturnPointRate()));

        data.setInsuAgencyYear1Fee(StringValidater.toLong(req
                .getInsuAgencyYear1Fee()));
        data.setInsuAgencyYear2Fee(StringValidater.toLong(req
                .getInsuAgencyYear2Fee()));
        data.setInsuAgencyYear3Fee(StringValidater.toLong(req
                .getInsuAgencyYear3Fee()));

        data.setUpdateDatetime(new Date());
        loanProductBO.editLoanProduct(data);
    }

    @Override
    public void publishYesLoanProduct(String code, String updater) {
        loanProductBO.publishYesLoanProduct(code, updater);
    }

    @Override
    public void publishNoLoanProduct(String code, String updater) {
        loanProductBO.publishNoLoanProduct(code, updater);
    }

    @Override
    public Paginable<LoanProduct> queryLoanProductPage(int start, int limit,
            LoanProduct condition) {
        Paginable<LoanProduct> page = loanProductBO.getPaginable(start, limit,
            condition);
        List<LoanProduct> loanProductList = page.getList();
        for (LoanProduct loanProduct : loanProductList) {
            Bank bank = bankBO.getBank(loanProduct.getLoanBank());
            loanProduct.setLoanBankName(bank.getBankName());
        }

        return page;
    }

    @Override
    public List<LoanProduct> queryLoanProductList(LoanProduct condition) {
        List<LoanProduct> loanProductList = loanProductBO
            .queryLoanProductList(condition);
        for (LoanProduct loanProduct : loanProductList) {
            Bank bank = bankBO.getBank(loanProduct.getLoanBank());
            loanProduct.setLoanBankName(bank.getBankName());
        }

        return loanProductList;
    }

    @Override
    public LoanProduct getLoanProduct(String code) {
        LoanProduct loanProduct = loanProductBO.getLoanProduct(code);
        Bank bank = bankBO.getBank(loanProduct.getLoanBank());
        loanProduct.setLoanBankName(bank.getBankName());
        return loanProduct;
    }
}
