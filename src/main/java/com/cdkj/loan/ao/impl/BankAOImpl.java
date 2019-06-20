package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.creditCommon.StringUtils;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632030Req;
import com.cdkj.loan.dto.req.XN632032Req;
import com.cdkj.loan.enums.EBankStatus;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 银行信息
 *
 * @author: silver
 * @since: 2018年5月27日 下午4:51:22
 * @history:
 */
@Service
public class BankAOImpl implements IBankAO {

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    @Transactional
    public String addBank(XN632030Req req) {
        Bank condition = new Bank();
        condition.setBankCode(req.getBankCode());
        condition.setSubbranch(req.getSubbranch());
        List<Bank> bankList = bankBO.queryBankList(condition);
        if (CollectionUtils.isNotEmpty(bankList)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该银行支行已存在，请勿重复添加!");
        }

        Bank data = new Bank();
        //Integer类型判定
        if (null != req.getClientValidDate() && req.getClientValidDate().length() == 0) {
            req.setClientValidDate(null);
        }
        EntityUtils.copyData(req, data);
        data.setStatus(EBankStatus.Shelf_YES.getCode());
        data.setUpdateDatetime(new Date());
        return bankBO.saveBank(data);
    }

    @Override
    public void dropBank(String code) {
        Bank bank = bankBO.getBank(code);
        if (EBankStatus.Shelf_NO.getCode().equals(bank.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "已删除，请不要提交");
        }

        bank.setStatus(EBankStatus.Shelf_NO.getCode());
        bankBO.editBank(bank);
    }

    @Override
    public void editBank(XN632032Req req) {
        // 编辑银行信息
        Bank data = bankBO.getBank(req.getCode());
        EntityUtils.copyData(req, data);

        data.setUpdateDatetime(new Date());
        bankBO.editBank(data);
    }

    @Override
    public Bank getBank(String code) {
        return bankBO.getBank(code);
    }

    @Override
    public Paginable<Bank> queryBankPage(int start, int limit, Bank condition) {
        Paginable<Bank> page = bankBO.getPaginable(start, limit, condition);
        for (Bank bank : page.getList()) {
            if (StringUtils.isNotBlank(bank.getUpdater())) {
                SYSUser user = sysUserBO.getUser(bank.getUpdater());
                bank.setUpdaterName(user.getRealName());
            }
        }

        return page;
    }

    @Override
    public List<Bank> queryBankList(Bank condition) {
        return bankBO.queryBankList(condition);
    }
}
