package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.ISYSConfigDAO;
import com.cdkj.loan.domain.SYSConfig;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Gejin
 * @since: 2016年4月17日 下午7:56:03
 * @history:
 */

@Component
public class SYSConfigBOImpl extends PaginableBOImpl<SYSConfig>
        implements ISYSConfigBO {

    static Logger logger = Logger.getLogger(SYSConfigBOImpl.class);

    @Autowired
    private ISYSConfigDAO sysConfigDAO;

    @Override
    public int refreshSYSConfig(String id, String ckey, String cvalue,
            String updater, String remark) {
        SYSConfig data = getSYSConfig(StringValidater.toLong(id));
        data.setCkey(ckey);
        data.setCvalue(cvalue);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        return sysConfigDAO.updateValue(data);
    }

    @Override
    public SYSConfig getSYSConfig(Long id) {
        SYSConfig sysConfig = null;
        if (id > 0) {
            SYSConfig condition = new SYSConfig();
            condition.setId(id);
            sysConfig = sysConfigDAO.select(condition);
        }
        if (sysConfig == null) {
            throw new BizException("xn000000", "id记录不存在");
        }
        return sysConfig;
    }

    @Override
    public SYSConfig getSYSConfig(String type, String key) {
        SYSConfig condition = new SYSConfig();
        condition.setType(type);
        condition.setCkey(key);
        return sysConfigDAO.select(condition);
    }

    @Override
    public Map<String, String> getConfigsMap() {
        Map<String, String> map = new HashMap<String, String>();
        SYSConfig condition = new SYSConfig();
        List<SYSConfig> list = sysConfigDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (SYSConfig sysConfig : list) {
                map.put(sysConfig.getCkey(), sysConfig.getCvalue());
            }
        }
        return map;

    }

    @Override
    public SYSConfig getSYSConfig(String key) {
        SYSConfig sysConfig = null;
        if (StringUtils.isNotBlank(key)) {
            SYSConfig condition = new SYSConfig();
            condition.setCkey(key);
            List<SYSConfig> sysConfigList = sysConfigDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(sysConfigList)) {
                sysConfig = sysConfigList.get(0);
            } else {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "系统参数" + key + "不存在");
            }
        }
        return sysConfig;
    }

    @Override
    public Double getDoubleValue(String key) {
        Double result = 0.0;
        SYSConfig config = getSYSConfig(key);
        try {
            result = Double.valueOf(config.getCvalue());
        } catch (Exception e) {
            logger.error(
                    "参数名为" + key + "的配置转换成Double类型发生错误, 原因：" + e.getMessage());
        }
        return result;
    }

    @Override
    public Integer getIntegerValue(String key) {
        Integer result = 0;
        SYSConfig config = getSYSConfig(key);
        try {
            result = Integer.valueOf(config.getCvalue());
        } catch (Exception e) {
            logger.error(
                    "参数名为" + key + "的配置转换成Integer类型发生错误, 原因：" + e.getMessage());
        }
        return result;
    }

    @Override
    public String getStringValue(String key) {
        SYSConfig config = getSYSConfig(key);
        return config.getCvalue();
    }

    @Override
    public Long getLongValue(String key) {
        Long result = 0L;
        SYSConfig config = getSYSConfig(key);
        try {
            result = Long.valueOf(config.getCvalue());
        } catch (Exception e) {
            logger
                    .error("参数名为" + key + "的配置转换成Long类型发生错误, 原因：" + e.getMessage());
        }
        return result;
    }

    @Override
    public BigDecimal getBigDecimalValue(String key) {
        BigDecimal result = BigDecimal.ZERO;
        SYSConfig config = getSYSConfig(key);
        try {
            result = new BigDecimal(config.getCvalue());
        } catch (Exception e) {
            logger.error(
                    "参数名为" + key + "的配置转换成BigDecimal类型发生错误, 原因：" + e.getMessage());
        }
        return result;
    }

    @Override
    public Map<String, String> getConfigsMap(String type) {

        Map<String, String> map = new HashMap<String, String>();
        SYSConfig condition = new SYSConfig();
        condition.setType(type);
        List<SYSConfig> list = sysConfigDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (SYSConfig sysConfig : list) {
                map.put(sysConfig.getCkey(), sysConfig.getCvalue());
            }
        }
        return map;

    }

    @Override
    public void saveSYSConfig(SYSConfig sysConfig) {
        sysConfigDAO.insert(sysConfig);
    }

    @Override
    public void dropSYSConfig(Long id) {
        int i = 0;
        if (id > 0) {
            SYSConfig condition = new SYSConfig();
            condition.setId(id);
            i = sysConfigDAO.delete(condition);
        }
        if (i == 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "id记录不存在");
        }
    }

}
