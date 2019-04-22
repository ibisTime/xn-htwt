DROP TABLE IF EXISTS `tdq_credit_jour`;
CREATE TABLE `tdq_credit_jour` (
	`code` varchar(32) NOT NULL COMMENT '编号',
  	`biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
	`credit_user_code` varchar(32) DEFAULT NULL COMMENT '征信人编号',
	`type` varchar(32) DEFAULT NULL COMMENT '类型（微信/支付宝/银行）',
  	`datetime_start` datetime DEFAULT NULL COMMENT '流水时间起',
  	`datetime_end` datetime DEFAULT NULL COMMENT '流水时间止',
  	`jour_interest1` mediumtext COMMENT '流水结息1',
  	`jour_interest2` mediumtext COMMENT '流水结息2',
  	`interest1` bigint(20) DEFAULT NULL COMMENT '结息1',
  	`interest2` bigint(20) DEFAULT NULL COMMENT '结息2',
  	`income` bigint(20) DEFAULT NULL COMMENT '收入',
  	`expend` bigint(20) DEFAULT NULL COMMENT '支出',
  	`balance` bigint(20) DEFAULT NULL COMMENT '帐户余额',
  	`month_income` bigint(20) DEFAULT NULL COMMENT '月均收入',
  	`month_expend` bigint(20) DEFAULT NULL COMMENT '月均支出',
  	`pic` mediumtext COMMENT '流水图片',
  	`remark` mediumtext COMMENT '流水备注',
  	PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征信流水';

DROP TABLE IF EXISTS `tdq_credit_user_ext`;
CREATE TABLE `tdq_credit_user_ext` (
	`code` varchar(32) NOT NULL COMMENT '编号',
	`credit_user_code` varchar(32) DEFAULT NULL COMMENT '征信人编号',
	`gender` varchar(4) DEFAULT NULL COMMENT '性别',
	`age` INT DEFAULT 0 COMMENT '年龄',
	`marry_state` varchar(4) DEFAULT NULL COMMENT '婚姻状况',
	`political` varchar(4) DEFAULT NULL COMMENT '政治面貌',
	
	`nation` varchar(4) DEFAULT NULL COMMENT '民族',
	`customer_type` varchar(4) DEFAULT NULL COMMENT '客户类型',
	`customer_birth` varchar(32) DEFAULT NULL COMMENT '客户生日',
	`now_house_type` varchar(4) DEFAULT NULL COMMENT '现住房屋类型',
	`now_address_province` varchar(32) DEFAULT NULL COMMENT '现住地址省',
	
	`now_address_city` varchar(32) DEFAULT NULL COMMENT '现住地址市',
	`now_address_area` varchar(32) DEFAULT NULL COMMENT '现住地址区',
	`now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
	`post_code` varchar(32) DEFAULT NULL COMMENT '现居住地址邮编',
	`is_card_mail_address` varchar(255) DEFAULT NULL COMMENT '是否卡邮寄地址',
	
	`family_number` INT DEFAULT 0 COMMENT '家庭人口',
	`family_phone` varchar(32) DEFAULT NULL COMMENT '家庭电话',
	`family_main_asset` varchar(255) DEFAULT NULL COMMENT '家庭主要财产',
	`main_asset_include` varchar(255) DEFAULT NULL COMMENT '主要财产包括',
	`main_income` varchar(255) DEFAULT NULL COMMENT '主要收入来源',
	
	`other_income_note` varchar(255) DEFAULT NULL COMMENT '其他收入说明',
	`house_contract` tinytext DEFAULT NULL COMMENT '购房合同',
	`is_house_property` varchar(4) DEFAULT NULL COMMENT '房产证情况',
	`house_property` tinytext DEFAULT NULL COMMENT '房产证',
	`month_income` BIGINT(20) DEFAULT NULL COMMENT '月收入',
	
	`work_company_property` varchar(32) DEFAULT NULL COMMENT '单位性质',
	`work_belong_industry` varchar(32) DEFAULT NULL COMMENT '所属行业',
	`work_profession` varchar(32) DEFAULT NULL COMMENT '职业',
	`position` varchar(32) DEFAULT NULL COMMENT '职位',
	`post_title` varchar(32) DEFAULT NULL COMMENT '职称',
	
	`work_datetime` varchar(32) DEFAULT NULL COMMENT '何时进入现单位工作',
	`self_company_area` varchar(32) DEFAULT NULL COMMENT '自营公司单位面积',
	`employee_quantity` varchar(32) DEFAULT NULL COMMENT '员工数量',
	`enterprise_month_output` varchar(32) DEFAULT NULL COMMENT '企业月产值',
	`is_license` varchar(4) DEFAULT NULL COMMENT '营业执照情况',
	
	`license` tinytext DEFAULT NULL COMMENT '营业执照',
	`organization_code_card` varchar(255) DEFAULT NULL COMMENT '组织机构代码证',
	`code_card_address` varchar(255) DEFAULT NULL COMMENT '代码证上的地址',
	`is_site_prove` varchar(4) DEFAULT NULL COMMENT '提供场地证明',
	`site_prove` tinytext DEFAULT NULL COMMENT '场地证明',
	
	`site_area` varchar(32) DEFAULT NULL COMMENT '经营场地面积',
	`emergency_name1` varchar(32) DEFAULT NULL COMMENT '联系人1姓名',
	`emergency_relation1` varchar(4) DEFAULT NULL COMMENT '联系人1与申请人关系',
	`emergency_mobile1` varchar(32) DEFAULT NULL COMMENT '联系人1手机号码',
	`emergency_name2` varchar(32) DEFAULT NULL COMMENT '联系人2姓名',
	
	`emergency_relation2` varchar(4) DEFAULT NULL COMMENT '联系人2与申请人关系',
	`emergency_mobile2` varchar(32) DEFAULT NULL COMMENT '联系人2手机号码',
	`car_type` varchar(4) DEFAULT NULL COMMENT '现有车辆类型',
	`is_drice_license` varchar(4) DEFAULT NULL COMMENT '有无驾照',
	`drice_license` tinytext DEFAULT NULL COMMENT '驾照',
	
	`marry_pdf` tinytext DEFAULT NULL COMMENT '结婚证资料',
	`other_pdf` tinytext DEFAULT NULL COMMENT '其他资料',
	`work_asset_pdf` tinytext DEFAULT NULL COMMENT '工作资料',
	`single_prove_pdf` tinytext DEFAULT NULL COMMENT '单身证明',
	`income_prove_pdf` tinytext DEFAULT NULL COMMENT '收入证明',
	
	`live_prove_pdf` tinytext DEFAULT NULL COMMENT '居住证明',
	`build_prove_pdf` tinytext DEFAULT NULL COMMENT '自建房证明',
  	PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征信人辅助资料';

ALTER TABLE `tdq_credit_user` 
ADD COLUMN `biz_code` VARCHAR(32) NULL COMMENT '业务编号' AFTER `code`,
ADD COLUMN `id_kind` VARCHAR(4) NULL COMMENT '证件类型' AFTER `mobile`,
ADD COLUMN `house_picture` VARCHAR(32) NULL COMMENT '家访照片' AFTER `interview_pic`,
ADD COLUMN `education` VARCHAR(32) NULL COMMENT '学历' AFTER `id_no_reverse`,
ADD COLUMN `company_name` VARCHAR(255) NULL COMMENT '工作单位名称' AFTER `education`,
ADD COLUMN `company_address` VARCHAR(255) NULL COMMENT '工作单位地址' AFTER `company_name`,
ADD COLUMN `company_contact_no` VARCHAR(32) NULL COMMENT '工作单位联系电话' AFTER `company_address`,
ADD COLUMN `asset_pdf` tinytext NULL COMMENT '资产资料pdf' AFTER `company_contact_no`,
ADD COLUMN `house_asset_address` VARCHAR(255) NULL COMMENT '房产地址' AFTER `asset_pdf`,
ADD COLUMN `hkb` tinytext NULL COMMENT '户口本' AFTER `house_asset_address`,
ADD COLUMN `birth_address_province` VARCHAR(32) NULL COMMENT '户籍地省' AFTER `hkb`,
ADD COLUMN `birth_address_city` VARCHAR(32) NULL COMMENT '户籍地市' AFTER `birth_address_province`,
ADD COLUMN `birth_address_area` VARCHAR(32) NULL COMMENT '户籍地区' AFTER `birth_address_city`,
ADD COLUMN `birth_address` VARCHAR(255) NULL COMMENT '户籍地详细地址' AFTER `birth_address_area`,
ADD COLUMN `post_code` VARCHAR(32) NULL COMMENT '户口所在地邮编' AFTER `birth_address`;
