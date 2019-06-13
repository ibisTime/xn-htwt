package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IRepointAccountAO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.IRepointAccountBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.RepointAccount;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : cyl
 * @since : 2019-05-27 15:37
 */
@Service
public class RepointAccountAOImpl implements IRepointAccountAO {

    @Autowired
    private IRepointAccountBO repointAccountBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Override
    public String addRepointAccount(RepointAccount data) {
        return repointAccountBO.saveRepointAccount(data);
    }

    @Override
    public int editRepointAccount(RepointAccount data) {
        return repointAccountBO.refreshRepointAccount(data);
    }

    @Override
    public int dropRepointAccount(String code) {
        return repointAccountBO.removeRepointAccount(code);
    }

    @Override
    public Paginable<RepointAccount> queryRepointAccountPage(int start, int limit,
            RepointAccount condition) {
        return repointAccountBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<RepointAccount> queryRepointAccountList(RepointAccount condition) {
        List<RepointAccount> repointAccountList = repointAccountBO
                .queryRepointAccountList(condition);
        if (CollectionUtils.isNotEmpty(repointAccountList)) {
            for (RepointAccount repointAccount : repointAccountList) {
                CollectBankcard collectBankcard = collectBankcardBO
                        .getCollectBankcard(repointAccount.getRepointCardCode());
                repointAccount.setCollectBankcard(collectBankcard);
            }
        }
        return repointAccountList;
    }

    @Override
    public RepointAccount getRepointAccount(String code) {
        return repointAccountBO.getRepointAccount(code);
    }
}