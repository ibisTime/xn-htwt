package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ICollectBankcardAO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.IChannelBankBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.ChannelBank;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.dto.req.XN632000Req;
import com.cdkj.loan.dto.req.XN632002Req;
import com.cdkj.loan.enums.ECollectBankcardType;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectBankcardAOImpl implements ICollectBankcardAO {

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private IChannelBankBO channelBankBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ICarDealerBO carDealerBO;

    @Override
    public String addCollectBankcard(XN632000Req req) {
        CollectBankcard data = new CollectBankcard();
        BeanUtils.copyProperties(req, data);
        // 获取银行名称
        ChannelBank bank = channelBankBO.getChannelBank(req.getBankCode());
        data.setBankName(bank.getBankName());
        data.setPointRate(StringValidater.toDouble(req.getPointRate()));

        return collectBankcardBO.saveCollectBankcard(data);
    }

    @Override
    public int editCollectBankcard(XN632002Req req) {
        CollectBankcard data = collectBankcardBO
                .getCollectBankcard(req.getCode());
        BeanUtils.copyProperties(req, data);

        // 获取银行名称
        ChannelBank bank = channelBankBO.getChannelBank(req.getBankCode());
        data.setBankName(bank.getBankName());
        data.setPointRate(StringValidater.toDouble(req.getPointRate()));

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
        if (paginable != null) {
            for (CollectBankcard collectBankcard : paginable.getList()) {
                if (ECollectBankcardType.PLATFORM.getCode()
                        .equals(collectBankcard.getType())
                        || ECollectBankcardType.ADVANCD_COLLECT.getCode()
                        .equals(collectBankcard.getType())) {
                    Department department = departmentBO
                            .getDepartment(collectBankcard.getCompanyCode());
                    collectBankcard.setCompanyName(department.getName());
                } else {
                    CarDealer carDealer = carDealerBO
                            .getCarDealer(collectBankcard.getCompanyCode());
                    collectBankcard.setCompanyName(carDealer.getFullName());
                }
            }
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
        CollectBankcard collectBankcard = collectBankcardBO.getCollectBankcard(code);
        return collectBankcard;
    }
}
