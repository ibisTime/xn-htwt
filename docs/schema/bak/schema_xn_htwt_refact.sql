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

DROP TABLE IF EXISTS `tqj_attachment`;
CREATE TABLE `tqj_attachment` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `category` varchar(32) DEFAULT NULL COMMENT '附件分类',
  `kname` varchar(45) DEFAULT NULL COMMENT '附件key',
  `vname` varchar(45) DEFAULT NULL COMMENT '附件value',
  `attach_type` varchar(64) DEFAULT NULL COMMENT '附件类型（图片/视频/网页）',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件 ';

DROP TABLE IF EXISTS `tdq_bank_loan`;
CREATE TABLE `tdq_bank_loan` (
	`code` varchar(32) NOT NULL COMMENT '编号',
  	`biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  	`status` varchar(32) DEFAULT NULL COMMENT '状态',
  	`cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
	`repay_bank_code` varchar(32) DEFAULT NULL COMMENT '还款卡银行编号',
  	`repay_bank_name` varchar(255) DEFAULT NULL COMMENT '还款卡银行名称',
  	`repay_subbranch` varchar(255) DEFAULT NULL COMMENT '还款卡开户支行',
  
  	`repay_bankcard_number` varchar(255) DEFAULT NULL COMMENT '还款卡银行卡号',
   	`receipt_bank_code` varchar(255) DEFAULT NULL COMMENT '收款银行编号',
  	`receipt_bank_name` varchar(255) DEFAULT NULL COMMENT '收款银行名称',
  	`receipt_subbranch` varchar(255) DEFAULT NULL COMMENT '收款银行支行',
	`receipt_bankcard_number` varchar(255) DEFAULT NULL COMMENT '收款银行卡号',
	
	`bank_commit_datetime` datetime DEFAULT NULL COMMENT '银行提交时间',
  	`bank_commit_note` varchar(255) DEFAULT NULL COMMENT '银行提交说明',
  	`bank_fk_datetime` datetime DEFAULT NULL COMMENT '银行放款时间',
	`repay_bill_date` int(11) DEFAULT NULL COMMENT '银行账单日',
  	`repay_bank_date` int(11) DEFAULT NULL COMMENT '银行还款日',
  	
  	`repay_company_date` int(11) DEFAULT NULL COMMENT '公司还款日',
  	`receipt_pdf` varchar(255) DEFAULT NULL COMMENT '收款凭证',
  	`receipt_remark` varchar(255) DEFAULT NULL COMMENT '收款备注',
  	`bank_fk_send_datetime` datetime DEFAULT NULL COMMENT '银行放款进件时间',
  	`has_loan_list_pic` varchar(255) DEFAULT NULL COMMENT '已放款名单',
  	
  	`bank_fk_amount` bigint(20) DEFAULT NULL COMMENT '银行放款金额',
  	`month_amount` bigint(20) DEFAULT NULL COMMENT '月还款额',
  	PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行放款';

DROP TABLE IF EXISTS `tdq_car_pledge`;
CREATE TABLE `tdq_car_pledge` (
	`code` varchar(32) NOT NULL COMMENT '编号',
  	`biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  	`status` varchar(32) DEFAULT NULL COMMENT '状态',
  	`cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
	`pledge_user` varchar(32) DEFAULT NULL COMMENT '代理人',
	
  	`pledge_user_id_card_copy` tinytext DEFAULT NULL COMMENT '代理人身份证复印件',
  	`pledge_address` varchar(255) DEFAULT NULL COMMENT '抵押地点',
  	`pledge_datetime` datetime DEFAULT NULL COMMENT '抵押日期',
   	`pledge_bank_commit_datetime` datetime DEFAULT NULL COMMENT '抵押提交银行时间',
  	`pledge_bank_commit_note` varchar(255) DEFAULT NULL COMMENT '抵押提交说明',
  	
  	`pledge_supplement_note` varchar(255) DEFAULT NULL COMMENT '车辆抵押补充说明',
	`pledge_contract_code` varchar(255) DEFAULT NULL COMMENT '抵押合同编号',
	`pledge_print_template_id` varchar(255) DEFAULT NULL COMMENT '抵押套打模板',
  	`pledge_print_user` varchar(255) DEFAULT NULL COMMENT '抵押打印人',
  	`pledge_print_datetime` datetime DEFAULT NULL COMMENT '抵押打印日期',
  	PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆抵押';

DROP TABLE IF EXISTS `tdq_advance`;
CREATE TABLE `tdq_advance` (
	`code` varchar(32) NOT NULL COMMENT '编号',
  	`biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  	`status` varchar(32) DEFAULT NULL COMMENT '状态',
  	`cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
  	`type` varchar(4) DEFAULT NULL COMMENT '1总公司业务 2分公司业务',
  	
  	`back_advance_status` varchar(32) DEFAULT NULL COMMENT '退客户垫资款状态',
  	`back_advance_fund_type` varchar(32) DEFAULT NULL COMMENT '收回垫资款类型（1客户作废2垫资款退回）',
	`advance_fund_datetime` DATETIME DEFAULT NULL COMMENT '垫资日期',
    `advance_fund_amount` BIGINT(20) DEFAULT NULL COMMENT '垫资金额',
    
    `total_advance_fund_code` varchar(32) DEFAULT NULL COMMENT '垫资汇总单编号(分公司业务才有)',
    `bill_pdf` tinytext DEFAULT NULL COMMENT '水单',
  	`advance_note` varchar(255) DEFAULT NULL COMMENT '垫资说明',
  	`back_advance_amount` bigint(20) DEFAULT NULL COMMENT '退客户垫资款 退款金额',
  	`back_advance_account` varchar(32) DEFAULT NULL COMMENT '退客户垫资款 收款账号',
  	`back_advance_open_bank` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 开户行',
  	
  	`back_advance_subbranch` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 开户支行',
  	`back_advance_water_bill` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 水单',
  	`use_amount` bigint(20) DEFAULT NULL COMMENT '用款金额(应退按揭款)',
  	`fund_source` varchar(4) DEFAULT NULL COMMENT '金额来源(1财务部2预支款)',
  	`make_bill_note` varchar(255) DEFAULT NULL COMMENT '制单意见说明',
  	
  	`cancel_reason` varchar(255) DEFAULT NULL COMMENT '撤销理由',
  	`pay_back_datetime` DATETIME DEFAULT NULL COMMENT '付款时间',
  	`pay_back_bankcard_code` varchar(255) DEFAULT NULL COMMENT '付款银行',
  	`pay_back_bill_pdf` varchar(255) DEFAULT NULL COMMENT '付款凭证',
  	PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='财务垫资';

ALTER TABLE `tb_collect_bankcard` 
ADD COLUMN `belong_bank` VARCHAR(32) NULL COMMENT '三种银行' AFTER `company_code`;

ALTER TABLE `tb_collect_bankcard` 
ADD COLUMN `point_rate` DECIMAL(18,8) NULL COMMENT '返点比例' AFTER `bankcard_number`;

CREATE TABLE `tb_car_dealer_protocol` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `car_dealer_code` varchar(32) DEFAULT NULL COMMENT '经销商编号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `plat_ct_rate12` decimal(18,8) DEFAULT NULL COMMENT '我司12期基准利率传统',
  `plat_ct_rate24` decimal(18,8) DEFAULT NULL COMMENT '我司24期基准利率传统',
  `plat_ct_rate36` decimal(18,8) DEFAULT NULL COMMENT '我司36期基准利率传统',
  `plat_zk_rate12` decimal(18,8) DEFAULT NULL COMMENT '我司12期基准利率直客',
  `plat_zk_rate24` decimal(18,8) DEFAULT NULL COMMENT '我司24期基准利率直客',
  `plat_zk_rate36` decimal(18,8) DEFAULT NULL COMMENT '我司36期基准利率直客',
  `assure_type` varchar(32) DEFAULT NULL COMMENT '担保费类型(1单笔/2贷款额百分比)',
  `assure_fee` bigint(20) DEFAULT NULL COMMENT '单笔担保费',
  `assure_rate` decimal(18,8) DEFAULT NULL COMMENT '担保费贷款额百分比',
  `dz_type` varchar(32) DEFAULT NULL COMMENT '垫资费类型(1单笔/2贷款额百分比)',
  `dz_fee` bigint(20) DEFAULT NULL COMMENT '单笔垫资费',
  `dz_rate` decimal(18,8) DEFAULT NULL COMMENT '垫资费贷款额百分比',
  `ly_amount_type` varchar(32) DEFAULT NULL COMMENT '履约保证金类型(1单笔/2贷款额百分比)',
  `ly_amount_fee` bigint(20) DEFAULT NULL COMMENT '单笔履约保证金',
  `ly_amount_rate` decimal(18,8) DEFAULT NULL COMMENT '履约保证金贷款额百分比',
  `gps_type` varchar(32) DEFAULT NULL COMMENT 'GPS类型(1单笔/2贷款额百分比)',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT '单笔GPS费',
  `gps_rate` decimal(18,8) DEFAULT NULL COMMENT 'GPS垫资费贷款额百分比',
  `other_type` varchar(32) DEFAULT NULL COMMENT '杂费类型(1单笔/2贷款额百分比)',
  `other_fee` bigint(20) DEFAULT NULL COMMENT '单笔杂费',
  `other_rate` decimal(18,8) DEFAULT NULL COMMENT '杂费贷款额百分比',
  `introduce_type` varchar(32) DEFAULT NULL COMMENT '介绍费类型(1单笔/2贷款额百分比)',
  `introduce_fee` bigint(20) DEFAULT NULL COMMENT '单笔介绍费',
  `introduce_rate` decimal(18,8) DEFAULT NULL COMMENT '介绍费贷款额百分比',
  `return_point_type` varchar(32) DEFAULT NULL COMMENT '返点类型(1单笔/2贷款额百分比)',
  `return_point_fee` bigint(20) DEFAULT NULL COMMENT '单笔返点',
  `return_point_rate` decimal(18,8) DEFAULT NULL COMMENT '返点贷款额百分比',
  `is_dz` varchar(32) DEFAULT NULL COMMENT '是否垫资(1 是 0 否)',
  `insu_agency_year1_type` varchar(32) DEFAULT NULL COMMENT '1年保险代理费类型(1平台/2车行)',
  `insu_agency_year1_fee` bigint(20) DEFAULT NULL COMMENT '1年保险代理费',
  `insu_agency_year2_type` varchar(32) DEFAULT NULL COMMENT '2年保险代理费类型(1平台/2车行)',
  `insu_agency_year2_fee` bigint(20) DEFAULT NULL COMMENT '2年保险代理费',
  `insu_agency_year3_type` varchar(32) DEFAULT NULL COMMENT '3年保险代理费类型(1平台/2车行)',
  `insu_agency_year3_fee` bigint(20) DEFAULT NULL COMMENT '3年保险代理费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='经销商协议表';

CREATE TABLE `tqj_cdbiz` (
  `code` varchar(32) NOT NULL,
  `biz_code` varchar(32) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  `biz_type` varchar(4) DEFAULT NULL,
  `repay_biz_code` varchar(32) DEFAULT NULL,
  `company_code` varchar(32) DEFAULT NULL,
  `team_code` varchar(32) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `make_card_status` varchar(4) DEFAULT NULL COMMENT '制卡状态',
  `mq_status` varchar(4) DEFAULT NULL,
  `fbhgps_status` varchar(4) DEFAULT NULL,
  `fircundang_status` varchar(4) DEFAULT NULL,
  `seccundang_status` varchar(4) DEFAULT NULL,
  `zf_status` varchar(4) DEFAULT NULL,
  `cur_node_code` varchar(5) DEFAULT NULL COMMENT '当前节点',
  `intev_cur_node_code` varchar(5) DEFAULT NULL COMMENT '面签节点',
  `make_card_node` varchar(5) DEFAULT NULL COMMENT '制卡节点',
  `fbhgps_node` varchar(5) DEFAULT NULL COMMENT '发保合gps节点',
  `cancel_node_code` varchar(5) DEFAULT NULL COMMENT '客户作废节点',
  `is_gps_az` varchar(4) DEFAULT NULL COMMENT '是否安装gps',
  `is_finacing` varchar(4) DEFAULT NULL COMMENT '是否融资',
  `is_advance_fund` varchar(4) DEFAULT NULL COMMENT '是否垫资',
  `is_plat_insure` varchar(4) DEFAULT NULL COMMENT '是否我司续保',
  `should_fee_amount` bigint(20) DEFAULT NULL COMMENT '应收手续费总额',
  `real_fee_amount` bigint(20) DEFAULT NULL COMMENT '实收手续费总额',
  `gua_mode` varchar(4) DEFAULT NULL COMMENT '担保方式',
  `credit_note` varchar(255) DEFAULT NULL COMMENT '征信说明',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `captain_code` varchar(32) DEFAULT NULL,
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `inside_job` varchar(32) DEFAULT NULL COMMENT '内勤',
  `loan_bank` varchar(32) DEFAULT NULL COMMENT '经办银行',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `enter_location` varchar(32) DEFAULT NULL COMMENT '入档位置',
  `enter_datetime` datetime DEFAULT NULL COMMENT '入档时间',
  `enter_filelist` varchar(32) DEFAULT NULL COMMENT '档案目录',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_bank_subbranch`;
CREATE TABLE `tb_bank_subbranch` (
  `code` varchar(32) NOT NULL COMMENT '序号',
  `bank_code` varchar(255) DEFAULT NULL COMMENT '银行编号',
  `bank_type` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `abbr_name` varchar(255) DEFAULT NULL COMMENT '简称',
  `full_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `open_bank` varchar(255) DEFAULT NULL COMMENT '开户行',
  `address` varchar(255) DEFAULT NULL COMMENT '银行地址',
  `phone_number` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `post_code` varchar(32) DEFAULT NULL COMMENT '邮编',
  `bank_client` varchar(255) DEFAULT NULL COMMENT '银行委托人',
  `client_valid_date` int(11) DEFAULT NULL COMMENT '委托有效期',
  `auther_name` varchar(255) DEFAULT NULL COMMENT '授权人姓名',
  `auther_phone_number` varchar(32) DEFAULT NULL COMMENT '授权人电话',
  `auther_id_no` varchar(255) DEFAULT NULL COMMENT '授权人身份证',
  `auther_address` varchar(255) DEFAULT NULL COMMENT '授权人地址',
  `credit_card_type` varchar(4) DEFAULT NULL COMMENT '信用卡类型',
  `credit_card_name` varchar(255) DEFAULT NULL COMMENT '信用卡名称',
  `belong_area` varchar(255) DEFAULT NULL COMMENT '所属地区',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行支行信息表';

DROP TABLE IF EXISTS `tdq_file_list`;
CREATE TABLE `tdq_file_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category` varchar(32) DEFAULT NULL COMMENT '序号',
  `kname` varchar(32) DEFAULT NULL COMMENT '名称',
  `vname` varchar(32) DEFAULT NULL,
  `attach_type` varchar(32) DEFAULT NULL,
  `number` int(11) DEFAULT NULL COMMENT '份数',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_car_dealer`;
CREATE TABLE `tb_car_dealer` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `full_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `abbr_name` varchar(255) DEFAULT NULL COMMENT '简称',
  `is_self_develop` varchar(1) DEFAULT NULL COMMENT '是否自主开发',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `car_dealer_type` varchar(4) DEFAULT NULL COMMENT '车行经营性质',
  `main_contact` varchar(255) DEFAULT NULL COMMENT '主要联系人',
  `contact_phone` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `main_brand` varchar(255) DEFAULT NULL COMMENT '主营品牌',
  `parent_group` varchar(255) DEFAULT NULL COMMENT '所属集团',
  `agreement_valid_date_start` datetime DEFAULT NULL COMMENT '合作协议有效期起',
  `agreement_valid_date_end` datetime DEFAULT NULL COMMENT '合作协议有效期止',
  `agreement_status` varchar(4) DEFAULT NULL COMMENT '协议状态',
  `agreement_pic` varchar(255) DEFAULT NULL COMMENT '车商合作协议',
  `settle_way` varchar(255) DEFAULT NULL COMMENT '结算方式(1现结2月结3季结)',
  `business_area` varchar(255) DEFAULT NULL COMMENT '业务区域',
  `belong_branch_company` varchar(255) DEFAULT NULL COMMENT '归属分公司',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `policy_note` varchar(255) DEFAULT NULL COMMENT '政策说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经销商信息表';

DROP TABLE IF EXISTS `tb_car_dealer_protocol`;
CREATE TABLE `tb_car_dealer_protocol` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `car_dealer_code` varchar(32) DEFAULT NULL COMMENT '经销商编号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `plat_ct_rate12` decimal(18,8) DEFAULT NULL COMMENT '我司12期基准利率传统',
  `plat_ct_rate24` decimal(18,8) DEFAULT NULL COMMENT '我司24期基准利率传统',
  `plat_ct_rate36` decimal(18,8) DEFAULT NULL COMMENT '我司36期基准利率传统',
  `plat_zk_rate12` decimal(18,8) DEFAULT NULL COMMENT '我司12期基准利率直客',
  `plat_zk_rate24` decimal(18,8) DEFAULT NULL COMMENT '我司24期基准利率直客',
  `plat_zk_rate36` decimal(18,8) DEFAULT NULL COMMENT '我司36期基准利率直客',
  `assure_type` varchar(32) DEFAULT NULL COMMENT '担保费类型(1单笔/2贷款额百分比)',
  `assure_fee` bigint(20) DEFAULT NULL COMMENT '单笔担保费',
  `assure_rate` decimal(18,8) DEFAULT NULL COMMENT '担保费贷款额百分比',
  `dz_type` varchar(32) DEFAULT NULL COMMENT '垫资费类型(1单笔/2贷款额百分比)',
  `dz_fee` bigint(20) DEFAULT NULL COMMENT '单笔垫资费',
  `dz_rate` decimal(18,8) DEFAULT NULL COMMENT '垫资费贷款额百分比',
  `ly_amount_type` varchar(32) DEFAULT NULL COMMENT '履约保证金类型(1单笔/2贷款额百分比)',
  `ly_amount_fee` bigint(20) DEFAULT NULL COMMENT '单笔履约保证金',
  `ly_amount_rate` decimal(18,8) DEFAULT NULL COMMENT '履约保证金贷款额百分比',
  `gps_type` varchar(32) DEFAULT NULL COMMENT 'GPS类型(1单笔/2贷款额百分比)',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT '单笔GPS费',
  `gps_rate` decimal(18,8) DEFAULT NULL COMMENT 'GPS垫资费贷款额百分比',
  `other_type` varchar(32) DEFAULT NULL COMMENT '杂费类型(1单笔/2贷款额百分比)',
  `other_fee` bigint(20) DEFAULT NULL COMMENT '单笔杂费',
  `other_rate` decimal(18,8) DEFAULT NULL COMMENT '杂费贷款额百分比',
  `introduce_type` varchar(32) DEFAULT NULL COMMENT '介绍费类型(1单笔/2贷款额百分比)',
  `introduce_fee` bigint(20) DEFAULT NULL COMMENT '单笔介绍费',
  `introduce_rate` decimal(18,8) DEFAULT NULL COMMENT '介绍费贷款额百分比',
  `return_point_type` varchar(32) DEFAULT NULL COMMENT '返点类型(1单笔/2贷款额百分比)',
  `return_point_fee` bigint(20) DEFAULT NULL COMMENT '单笔返点',
  `return_point_rate` decimal(18,8) DEFAULT NULL COMMENT '返点贷款额百分比',
  `is_dz` varchar(32) DEFAULT NULL COMMENT '是否垫资(1 是 0 否)',
  `insu_agency_year1_type` varchar(32) DEFAULT NULL COMMENT '1年保险代理费类型(1平台/2车行)',
  `insu_agency_year1_fee` bigint(20) DEFAULT NULL COMMENT '1年保险代理费',
  `insu_agency_year2_type` varchar(32) DEFAULT NULL COMMENT '2年保险代理费类型(1平台/2车行)',
  `insu_agency_year2_fee` bigint(20) DEFAULT NULL COMMENT '2年保险代理费',
  `insu_agency_year3_type` varchar(32) DEFAULT NULL COMMENT '3年保险代理费类型(1平台/2车行)',
  `insu_agency_year3_fee` bigint(20) DEFAULT NULL COMMENT '3年保险代理费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='经销商协议表';

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `biz_code` VARCHAR(32) NULL COMMENT '业务编号' AFTER `code`;

CREATE TABLE `tqj_mission` (
  `code` VARCHAR(32) NOT NULL,
  `biz_code` VARCHAR(32) NULL,
  `name` VARCHAR(255) NULL,
  `time` INT NULL,
  `creater` VARCHAR(32) NULL,
  `get_user` VARCHAR(32) NULL,
  `status` VARCHAR(4) NULL,
  `create_datetime` DATETIME NULL,
  `deadline` DATETIME NULL,
  `finish_datetime` DATETIME NULL,
  PRIMARY KEY (`code`));
