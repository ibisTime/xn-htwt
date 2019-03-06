/**
 * @Title ISmsBO.java 
 * @Package com.ogc.standard.bo 
 * @Description 
 * @author dl  
 * @date 2018年8月22日 下午2:04:01 
 * @version V1.0   
 */
package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Sms;

/** 
 * @author: dl 
 * @since: 2018年8月22日 下午2:04:01 
 * @history:
 */
public interface ISmsBO extends IPaginableBO<Sms> {

    public boolean isSmsExit(String code);

    public String saveSms(Sms data);

    public int refreshSms(Sms data);

    public int revokeSms(String code, String updater, String remark);

    public List<Sms> querySmsList(Sms data);

    public Sms getSms(String code);
}
