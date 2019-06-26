package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 品牌logo
* @author: CYunlai 
* @since: 2019-06-26 10:26:57
* @history:
*/
public class BrandLogo extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 品牌名称
	private String brandName;

	// 品牌logo
	private String brandLogo;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandLogo(String brandLogo) {
		this.brandLogo = brandLogo;
	}

	public String getBrandLogo() {
		return brandLogo;
	}

}