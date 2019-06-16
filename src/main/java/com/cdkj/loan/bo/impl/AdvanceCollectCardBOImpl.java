package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IAdvanceCollectCardBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAdvanceCollectCardDAO;
import com.cdkj.loan.domain.AdvanceCollectCard;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AdvanceCollectCardBOImpl extends PaginableBOImpl<AdvanceCollectCard> implements
        IAdvanceCollectCardBO {

    @Autowired
    private IAdvanceCollectCardDAO AdvanceCollectCardDAO;

    @Override
    public String saveAdvanceCollectCard(AdvanceCollectCard data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.ADVANCECOLLECTCARD.getCode());
            data.setCode(code);
            AdvanceCollectCardDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeAdvanceCollectCard(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            AdvanceCollectCard data = new AdvanceCollectCard();
            data.setCode(code);
            count = AdvanceCollectCardDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshAdvanceCollectCard(AdvanceCollectCard data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
//            count = AdvanceCollectCardDAO.update(data);
        }
        return count;
    }

    @Override
    public List<AdvanceCollectCard> queryAdvanceCollectCardList(AdvanceCollectCard condition) {
        return AdvanceCollectCardDAO.selectList(condition);
    }

    @Override
    public AdvanceCollectCard getAdvanceCollectCard(String code) {
        AdvanceCollectCard data = null;
        if (StringUtils.isNotBlank(code)) {
            AdvanceCollectCard condition = new AdvanceCollectCard();
            condition.setCode(code);
            data = AdvanceCollectCardDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }
}