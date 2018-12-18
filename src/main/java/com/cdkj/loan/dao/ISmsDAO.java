/**
 * @Title ISmsDAO.java 
 * @Package com.ogc.standard.dao 
 * @Description 
 * @author dl  
 * @date 2018年8月22日 下午1:28:36 
 * @version V1.0   
 */
package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Sms;

/** 
 * @author: dl 
 * @since: 2018年8月22日 下午1:28:36 
 * @history:
 */
public interface ISmsDAO extends IBaseDAO<Sms> {
    String NAMESPACE = ISmsDAO.class.getName().concat(".");

    // 修改状态
    public int updateStatus(Sms data);

    // 修改信息
    public int updateSms(Sms data);
}
