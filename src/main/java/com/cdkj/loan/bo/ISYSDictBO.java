/**
 * @Title ISYSDictBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午2:40:19 
 * @version V1.0   
 */
package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SYSDict;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午2:40:19 
 * @history:
 */
public interface ISYSDictBO extends IPaginableBO<SYSDict> {

    public Long saveSecondDict(SYSDict sysDict);

    public void removeSYSDict(Long id);

    public void checkKeys(String parentKey, String key);

    public void refreshSYSDict(Long id, String value, String updater,
            String remark);

    public List<SYSDict> querySYSDictList(SYSDict condition);

    public SYSDict getSYSDict(Long id);

    // 通过父key和key获取value
    public SYSDict getSYSDictByParentKeyAndDkey(String string,
            String logisticsCompany);

}
