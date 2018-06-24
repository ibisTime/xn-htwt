package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICollectBankcardAO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.dto.req.XN632000Req;
import com.cdkj.loan.dto.req.XN632002Req;

@Service
public class CollectBankcardAOImpl implements ICollectBankcardAO {

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addCollectBankcard(XN632000Req req) {
        CollectBankcard data = new CollectBankcard();
        data.setType(req.getType());
        data.setCompanyCode(req.getCompanyCode());
        data.setRealName(req.getRealName());
        data.setBankCode(req.getBankCode());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setRemark(req.getRemark());
        return collectBankcardBO.saveCollectBankcard(data);
    }

    @Override
    public int editCollectBankcard(XN632002Req req) {
        CollectBankcard data = collectBankcardBO
            .getCollectBankcard(req.getCode());
        data.setType(req.getType());
        data.setCompanyCode(req.getCompanyCode());
        data.setRealName(req.getRealName());
        data.setBankCode(req.getBankCode());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setRemark(req.getRemark());
        return collectBankcardBO.refreshCollectBankcard(data);
    }

    @Override
    public int dropCollectBankcard(String code) {
        return collectBankcardBO.removeCollectBankcard(code);
    }

    @Override
    public Paginable<CollectBankcard> queryCollectBankcardPage(int start,
            int limit, CollectBankcard condition) {
        Paginable<CollectBankcard> paginable = collectBankcardBO
            .getPaginable(start, limit, condition);
        for (CollectBankcard collectBankcard : paginable.getList()) {
            initCollectBankcard(collectBankcard);
        }
        return paginable;
    }

    @Override
    public List<CollectBankcard> queryCollectBankcardList(
            CollectBankcard condition) {
        return collectBankcardBO.queryCollectBankcardList(condition);
    }

    @Override
    public CollectBankcard getCollectBankcard(String code) {
        CollectBankcard collectBankcard = collectBankcardBO
            .getCollectBankcard(code);
        initCollectBankcard(collectBankcard);
        return collectBankcard;
    }

    private void initCollectBankcard(CollectBankcard collectBankcard) {
        if (StringUtils.isNotBlank(collectBankcard.getCompanyCode())) {
            Department department = departmentBO
                .getDepartment(collectBankcard.getCompanyCode());
            collectBankcard.setCompanyName(department.getName());
        }
    }
}
