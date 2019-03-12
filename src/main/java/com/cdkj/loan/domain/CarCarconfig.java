package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 车型配置
* @author: jiafr 
* @since: 2019-03-12 17:33:21
* @history:
*/
public class CarCarconfig extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 车型编号
	private String carCode;

	// 配置编号
	private String configCode;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}

	public String getConfigCode() {
		return configCode;
	}

}