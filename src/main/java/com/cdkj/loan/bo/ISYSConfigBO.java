/**
 * @Title ISYSConfigBO.java
 * @Package com.xnjr.moom.bo
 * @Description
 * @author haiqingzheng
 * @date 2016年4月17日 下午2:40:52
 * @version V1.0
 */
package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SYSConfig;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author: haiqingzheng
 * @since: 2016年4月17日 下午2:40:52
 * @history:
 */
public interface ISYSConfigBO extends IPaginableBO<SYSConfig> {

    int refreshSYSConfig(String id, String ckey, String cvalue,
            String updater, String remark);

    SYSConfig getSYSConfig(Long id);

    SYSConfig getSYSConfig(String type, String key);

    Map<String, String> getConfigsMap();

    SYSConfig getSYSConfig(String key);

    Map<String, String> getConfigsMap(String type);

    String getStringValue(String key);

    Double getDoubleValue(String key);

    Integer getIntegerValue(String key);

    Long getLongValue(String key);

    BigDecimal getBigDecimalValue(String key);

    // 新增车贷期数管理
    void saveSYSConfig(SYSConfig sysConfig);

    void dropSYSConfig(Long id);

}
