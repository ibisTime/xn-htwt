package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ISYSConfigAO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSConfig;

/**
 * @author: Gejin 
 * @since: 2016年4月17日 下午7:32:28 
 * @history:
 */
@Service
public class SYSConfigAOImpl implements ISYSConfigAO {
    @Autowired
    ISYSConfigBO sysConfigBO;

    @Override
    public void dropSYSConfig(Long id) {
        sysConfigBO.dropSYSConfig(id);
    }

    @Override
    public void editSYSConfig(String id, String ckey, String cvalue,
            String updater, String remark) {
        sysConfigBO.refreshSYSConfig(id, ckey, cvalue, updater, remark);
    }

    @Override
    public Paginable<SYSConfig> querySYSConfigPage(int start, int limit,
            SYSConfig condition) {
        return sysConfigBO.getPaginable(start, limit, condition);
    }

    @Override
    public SYSConfig getSYSConfig(Long id) {
        return sysConfigBO.getSYSConfig(id);
    }

    @Override
    public SYSConfig getSYSConfig(String key) {
        return sysConfigBO.getSYSConfig(key);
    }

    @Override
    public Map<String, String> getSYSConfigMap(String type) {
        return sysConfigBO.getConfigsMap(type);
    }

    @Override
    @Transactional
    public void addSYSConfig(String ckey, String cvalue, String updater,
            String remark) {
        SYSConfig sysConfig = new SYSConfig();
        sysConfig.setType("car_periods");
        sysConfig.setCkey(ckey);
        sysConfig.setCvalue(cvalue);
        sysConfig.setUpdater(updater);
        sysConfig.setUpdateDatetime(new Date());
        sysConfig.setRemark(remark);
        sysConfigBO.saveSYSConfig(sysConfig);
    }

}
