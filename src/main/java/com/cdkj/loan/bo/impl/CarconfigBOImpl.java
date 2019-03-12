package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarconfigBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarconfigDAO;
import com.cdkj.loan.domain.Carconfig;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class CarconfigBOImpl extends PaginableBOImpl<Carconfig> implements
        ICarconfigBO {

    @Autowired
    private ICarconfigDAO carconfigDAO;

    @Override
    public boolean isCarconfigExist(String code) {
        Carconfig condition = new Carconfig();
        condition.setCode(code);
        if (carconfigDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCarconfig(String name, String pic, String updater,
            String remark) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.Carconfig
            .getCode());
        Carconfig data = new Carconfig();
        data.setCode(code);
        data.setName(name);
        data.setPic(pic);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        carconfigDAO.insert(data);
        return code;
    }

    @Override
    public int removeCarconfig(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Carconfig data = new Carconfig();
            data.setCode(code);
            count = carconfigDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCarconfig(Carconfig config, String name, String pic,
            String updater, String remark) {
        int count = 0;
        if (config != null) {
            config.setName(name);
            config.setPic(pic);
            config.setUpdater(updater);
            config.setUpdateDatetime(new Date());
            config.setRemark(remark);
            count = carconfigDAO.updateConfig(config);
        }
        return count;
    }

    @Override
    public List<Carconfig> queryCarconfigList(Carconfig condition) {
        return carconfigDAO.selectList(condition);
    }

    @Override
    public Carconfig getCarconfig(String code) {
        Carconfig data = null;
        if (StringUtils.isNotBlank(code)) {
            Carconfig condition = new Carconfig();
            condition.setCode(code);
            data = carconfigDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "配置不存在");
            }
        }
        return data;
    }
}
