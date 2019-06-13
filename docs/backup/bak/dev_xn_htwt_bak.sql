/*
 Navicat MySQL Data Transfer

 Source Server         : 47.96.161.183
 Source Server Version : 50633
 Source Host           : 47.96.161.183
 Source Database       : dev_xn_htwt

 Target Server Version : 50633
 File Encoding         : utf-8

 Date: 06/06/2018 03:58:09 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_bank`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bank`;
CREATE TABLE `tb_bank` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '支行名称',
  `rate12` decimal(10,0) DEFAULT NULL COMMENT '12期',
  `rate18` decimal(10,0) DEFAULT NULL COMMENT '18期',
  `rate24` decimal(10,0) DEFAULT NULL COMMENT '24期',
  `rate36` decimal(10,0) DEFAULT NULL COMMENT '36期',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 已下架 1 已上架)',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台银行信息表';

-- ----------------------------
--  Table structure for `tb_collect_bankcard`
-- ----------------------------
DROP TABLE IF EXISTS `tb_collect_bankcard`;
CREATE TABLE `tb_collect_bankcard` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(1 普通账户 2 经销商的收款账号 3 经销商返点账号)',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '户名',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `bankcard_number` varchar(255) DEFAULT NULL COMMENT '账号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收款账号表';

-- ----------------------------
--  Table structure for `tb_gps`
-- ----------------------------
DROP TABLE IF EXISTS `tb_gps`;
CREATE TABLE `tb_gps` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `gps_dev_no` varchar(32) NOT NULL COMMENT 'gps编号',
  `gps_type` varchar(32) NOT NULL COMMENT 'gps类型( 1 有线 0 无线)',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申领人',
  `apply_status` varchar(32) DEFAULT NULL COMMENT '申领状态(0 待申领 1 已申领)',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申领日期',
  `apply_code` varchar(32) DEFAULT NULL COMMENT '申领编号',
  `use_status` varchar(32) DEFAULT NULL COMMENT '使用状态(0 待使用 1 已使用)',
  `use_datetime` datetime DEFAULT NULL COMMENT '使用日期',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='gps库存管理';

-- ----------------------------
--  Table structure for `tb_gps_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tb_gps_apply`;
CREATE TABLE `tb_gps_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) NOT NULL COMMENT '类型(1 公司 2 个人)',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请日期',
  `apply_reason` varchar(255) DEFAULT NULL COMMENT '申请原因',
  `apply_count` int(11) DEFAULT NULL COMMENT '申请个数',
  `send_datetime` datetime DEFAULT NULL COMMENT '发货日期',
  `receive_datetime` datetime DEFAULT NULL COMMENT '收货日期',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0 待审核 1 审核通过,待发货 2 审核不通过 3 已发货,待收货 4 已收货)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='gps申领管理';

-- ----------------------------
--  Table structure for `tbf_withhold`
-- ----------------------------
DROP TABLE IF EXISTS `tbf_withhold`;
CREATE TABLE `tbf_withhold` (
  `trans_id` varchar(32) NOT NULL COMMENT '商户订单号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编码',
  `bankcard_number` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `trans_amount` bigint(32) DEFAULT NULL COMMENT '代扣金额',
  `ref_no` varchar(32) DEFAULT NULL COMMENT '关联订单号',
  `resp_code` varchar(32) DEFAULT NULL COMMENT '应答码',
  `resp_msg` varchar(255) DEFAULT NULL COMMENT '应答信息',
  `member_id` varchar(32) DEFAULT NULL COMMENT '商户号',
  `terminal_id` varchar(32) DEFAULT NULL COMMENT '终端号',
  `txn_type` varchar(32) DEFAULT NULL COMMENT '交易类型',
  `txn_sub_type` varchar(32) DEFAULT NULL COMMENT '交易子类',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '接入类型',
  `trade_date` datetime DEFAULT NULL COMMENT '订单发送时间',
  `trans_no` varchar(32) DEFAULT NULL COMMENT '宝付交易号',
  `succ_amt` bigint(32) DEFAULT NULL COMMENT '成功金额',
  `trans_serial_no` varchar(32) DEFAULT NULL COMMENT '商户流水号',
  PRIMARY KEY (`trans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdh_overdue_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_overdue_menu`;
CREATE TABLE `tdh_overdue_menu` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `id_no` varchar(32) DEFAULT NULL COMMENT '证件号',
  `loan_bank_name` varchar(255) DEFAULT NULL COMMENT '贷款银行名称',
  `loan_amount` bigint(11) DEFAULT NULL COMMENT '贷款金额',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `remain_amount` bigint(11) DEFAULT NULL COMMENT '剩余金额',
  `fk_datetime` datetime DEFAULT NULL COMMENT '放款日期',
  `overdue_amount` bigint(11) DEFAULT NULL COMMENT '逾期金额',
  `overdue_datetime` datetime DEFAULT NULL COMMENT '逾期日期',
  `import_datetime` datetime DEFAULT NULL COMMENT '导入日期',
  `import_note` varchar(255) DEFAULT NULL COMMENT '导入说明',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 待处理 1 已处理)',
  `handle_datetime` datetime DEFAULT NULL COMMENT '处理日期',
  `handle_note` varchar(255) DEFAULT NULL COMMENT '处理说明',
  `budget_order_code` varchar(32) DEFAULT NULL COMMENT '准入单编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `repay_plan_code` varchar(32) DEFAULT NULL COMMENT '还款计划编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导入逾期名单';

DROP TABLE IF EXISTS `tdh_overdue_repay`;
CREATE TABLE `tdh_overdue_repay` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `overdue_code` varchar(32) DEFAULT NULL COMMENT '逾期名单编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='逾期名单关联表';

-- ----------------------------
--  Table structure for `tdq_budget_order`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_budget_order`;
CREATE TABLE `tdq_budget_order` (
    `code` VARCHAR(32) NOT NULL COMMENT '编号',
    `repay_biz_code` VARCHAR(32) DEFAULT NULL COMMENT '还款业务编号',
    `loan_product_code` VARCHAR(32) DEFAULT NULL COMMENT '贷款产品编号',
    `loan_product_name` tinytext DEFAULT NULL COMMENT '贷款产品名称',
    `loan_bank` tinytext DEFAULT NULL COMMENT '贷款银行',
    `gps_fee` BIGINT(20) DEFAULT NULL COMMENT 'GPS费用',
    `auth_fee` BIGINT(20) DEFAULT NULL COMMENT '公证费',
    `bank_fee` BIGINT(20) DEFAULT NULL COMMENT '银行服务费',
    `company_fee` BIGINT(20) DEFAULT NULL COMMENT '公司服务费',
    `credit_code` VARCHAR(32) DEFAULT NULL COMMENT '征信单编号',
    `biz_type` VARCHAR(32) DEFAULT NULL COMMENT '业务种类',
    `loan_period` VARCHAR(32) DEFAULT NULL COMMENT '贷款期限',
    `invoice_company` tinytext DEFAULT NULL COMMENT '开票单位',
    `car_brand` tinytext DEFAULT NULL COMMENT '品牌',
    `car_series` tinytext DEFAULT NULL COMMENT '车系',
    `car_model` tinytext DEFAULT NULL COMMENT '车型',
    `car_pic` text DEFAULT NULL COMMENT '车辆照片',
    `car_hgz_pic` tinytext DEFAULT NULL COMMENT '合格证',
    `car_hgz_no` tinytext DEFAULT NULL COMMENT '合格证号',
    `car_frame_no` tinytext DEFAULT NULL COMMENT '车架号',
    `car_engine_no` tinytext DEFAULT NULL COMMENT '发动机号',
    `original_price` BIGINT(20) DEFAULT NULL COMMENT '市场指导价',
    `invoice_price` BIGINT(20) DEFAULT NULL COMMENT '开票价',
    `car_color` tinytext DEFAULT NULL COMMENT '颜色',
    `month_deposit` BIGINT(20) DEFAULT NULL COMMENT '月供保证金',
    `first_amount` BIGINT(20) DEFAULT NULL COMMENT '首付金额',
    `first_rate` DECIMAL(18,8) DEFAULT NULL COMMENT '首付比例',
    `loan_amount` BIGINT(20) DEFAULT NULL COMMENT '贷款额',
    `settle_address` tinytext DEFAULT NULL COMMENT '落户地点',
    `apply_user_id` tinytext DEFAULT NULL COMMENT '申请人编号',
    `apply_user_name` tinytext DEFAULT NULL COMMENT '申请人姓名',
    `gender` tinytext DEFAULT NULL COMMENT '性别',
    `marry_state` tinytext DEFAULT NULL COMMENT '婚姻状况',
    `nation` tinytext DEFAULT NULL COMMENT '民族',
    `education` tinytext DEFAULT NULL COMMENT '学历',
    `id_kind` VARCHAR(32) DEFAULT NULL COMMENT '证件类型',
    `id_no` VARCHAR(255) DEFAULT NULL COMMENT '身份证号',
    `family_number` VARCHAR(255) DEFAULT NULL COMMENT '家庭人口',
    `mobile` VARCHAR(32) DEFAULT NULL COMMENT '手机号',
    `now_address` VARCHAR(255) DEFAULT NULL COMMENT '现居住地址',
    `post_code1` VARCHAR(255) DEFAULT NULL COMMENT '邮编1',
    `residence_address` VARCHAR(255) DEFAULT NULL COMMENT '户口所在地',
    `post_code2` tinytext DEFAULT NULL COMMENT '邮编2',
    `family_main_asset` text DEFAULT NULL COMMENT '家庭主要财产',
    `main_asset_include` text DEFAULT NULL COMMENT '主要财产包括',
    `main_income` tinytext DEFAULT NULL COMMENT '主要收入来源',
    `work_company_name` tinytext DEFAULT NULL COMMENT '工作单位名称',
    `work_company_address` tinytext DEFAULT NULL COMMENT '工作单位地址',
    `work_company_property` tinytext DEFAULT NULL COMMENT '单位性质',
    `work_belong_industry` tinytext DEFAULT NULL COMMENT '所属行业',
    `work_profession` tinytext DEFAULT NULL COMMENT '职业',
    `work_datetime` DATETIME DEFAULT NULL COMMENT '何时进入现单位工作',
    `self_company_area` tinytext DEFAULT NULL COMMENT '自营公司单位面积',
    `employee_quantity` VARCHAR(255) DEFAULT NULL COMMENT '员工数量',
    `enterprise_month_output` tinytext DEFAULT NULL COMMENT '企业月产值',
    `position` tinytext DEFAULT NULL COMMENT '职位',
    `post_title` tinytext DEFAULT NULL COMMENT '职称',
    `month_income` tinytext DEFAULT NULL COMMENT '月收入',
    `mate_name` tinytext DEFAULT NULL COMMENT '配偶姓名',
    `mate_mobile` tinytext DEFAULT NULL COMMENT '配偶手机号',
    `mate_id_no` tinytext DEFAULT NULL COMMENT '配偶身份证号',
    `mate_education` tinytext DEFAULT NULL COMMENT '配偶学历',
    `mate_company_name` tinytext DEFAULT NULL COMMENT '配偶工作单位名称',
    `mate_company_address` tinytext DEFAULT NULL COMMENT '配偶工作单位地址',
    `mate_company_contact_no` tinytext DEFAULT NULL COMMENT '配偶工作单位联系电话',
    `mate_zfb_jour_datetime_start` DATETIME DEFAULT NULL COMMENT '配偶支付宝流水时间起',
    `mate_zfb_jour_datetime_end` DATETIME DEFAULT NULL COMMENT '配偶支付宝流水时间止',
    `mate_zfb_jour_income` BIGINT(20) DEFAULT NULL COMMENT '配偶支付宝收入',
    `mate_zfb_jour_expend` BIGINT(20) DEFAULT NULL COMMENT '配偶支付宝支出',
    `mate_zfb_jour_balance` BIGINT(20) DEFAULT NULL COMMENT '配偶支付宝帐户余额',
    `mate_zfb_jour_month_income` BIGINT(20) DEFAULT NULL COMMENT '配偶支付宝月均收入',
    `mate_zfb_jour_month_expend` BIGINT(20) DEFAULT NULL COMMENT '配偶支付宝月均支出',
    `mate_zfb_jour_pic` TEXT COMMENT '配偶支付宝流水图片',
    `mate_zfb_jour_remark` tinytext DEFAULT NULL COMMENT '配偶支付宝流水备注',
    `mate_wx_jour_datetime_start` DATETIME DEFAULT NULL COMMENT '配偶微信流水时间起',
    `mate_wx_jour_datetime_end` DATETIME DEFAULT NULL COMMENT '配偶微信流水时间止',
    `mate_wx_jour_income` BIGINT(20) DEFAULT NULL COMMENT '配偶微信收入',
    `mate_wx_jour_expend` BIGINT(20) DEFAULT NULL COMMENT '配偶微信支出',
    `mate_wx_jour_balance` BIGINT(20) DEFAULT NULL COMMENT '配偶微信帐户余额',
    `mate_wx_jour_month_income` BIGINT(20) DEFAULT NULL COMMENT '配偶微信月均收入',
    `mate_wx_jour_month_expend` BIGINT(20) DEFAULT NULL COMMENT '配偶微信月均支出',
    `mate_wx_jour_pic` TEXT COMMENT '配偶微信流水图片',
    `mate_wx_jour_remark` tinytext DEFAULT NULL COMMENT '配偶微信流水备注',
    `mate_jour_datetime_start` DATETIME DEFAULT NULL COMMENT '配偶流水时间起',
    `mate_jour_datetime_end` DATETIME DEFAULT NULL COMMENT '配偶流水时间止',
    `mate_jour_income` BIGINT(20) DEFAULT NULL COMMENT '配偶收入',
    `mate_jour_expend` BIGINT(20) DEFAULT NULL COMMENT '配偶支出',
    `mate_jour_balance` BIGINT(20) DEFAULT NULL COMMENT '配偶帐户余额',
    `mate_jour_month_income` BIGINT(20) DEFAULT NULL COMMENT '配偶月均收入',
    `mate_jour_month_expend` BIGINT(20) DEFAULT NULL COMMENT '配偶月均支出',
    `mate_jour_pic` TEXT COMMENT '配偶流水图片',
    `mate_jour_remark` tinytext DEFAULT NULL COMMENT '配偶流水备注',
    `mate_asset_pdf` TEXT COMMENT '配偶资产资料pdf',
    `gua_name` tinytext DEFAULT NULL COMMENT '担保人姓名',
    `gua_mobile` tinytext DEFAULT NULL COMMENT '担保人手机号',
    `gua_id_no` tinytext DEFAULT NULL COMMENT '担保人身份证号',
    `gua_phone` tinytext DEFAULT NULL COMMENT '担保人固定电话',
    `gua_company_name` tinytext DEFAULT NULL COMMENT '担保人工作单位名称',
    `gua_company_address` tinytext DEFAULT NULL COMMENT '担保人工作单位地址',
    `gua_house_asset_address` tinytext DEFAULT NULL COMMENT '担保人房产地址',
    `gua_zfb_jour_datetime_start` DATETIME DEFAULT NULL COMMENT '担保人支付宝流水时间起',
    `gua_zfb_jour_datetime_end` DATETIME DEFAULT NULL COMMENT '担保人支付宝流水时间止',
    `gua_zfb_jour_income` BIGINT(20) DEFAULT NULL COMMENT '担保人支付宝收入',
    `gua_zfb_jour_expend` BIGINT(20) DEFAULT NULL COMMENT '担保人支付宝支出',
    `gua_zfb_jour_balance` BIGINT(20) DEFAULT NULL COMMENT '担保人支付宝帐户余额',
    `gua_zfb_jour_month_income` BIGINT(20) DEFAULT NULL COMMENT '担保人支付宝月均收入',
    `gua_zfb_jour_month_expend` BIGINT(20) DEFAULT NULL COMMENT '担保人支付宝月均支出',
    `gua_zfb_jour_pic` TEXT COMMENT '担保人支付宝流水图片',
    `gua_zfb_jour_remark` tinytext DEFAULT NULL COMMENT '担保人支付宝流水备注',
    `gua_wx_jour_datetime_start` DATETIME DEFAULT NULL COMMENT '担保人微信流水时间起',
    `gua_wx_jour_datetime_end` DATETIME DEFAULT NULL COMMENT '担保人微信流水时间止',
    `gua_wx_jour_income` BIGINT(20) DEFAULT NULL COMMENT '担保人微信收入',
    `gua_wx_jour_expend` BIGINT(20) DEFAULT NULL COMMENT '担保人微信支出',
    `gua_wx_jour_balance` BIGINT(20) DEFAULT NULL COMMENT '担保人微信帐户余额',
    `gua_wx_jour_month_income` BIGINT(20) DEFAULT NULL COMMENT '担保人微信月均收入',
    `gua_wx_jour_month_expend` BIGINT(20) DEFAULT NULL COMMENT '担保人微信月均支出',
    `gua_wx_jour_pic` TEXT COMMENT '担保人微信流水图片',
    `gua_wx_jour_remark` tinytext DEFAULT NULL COMMENT '担保人微信流水备注',
    `gua_jour_datetime_start` DATETIME DEFAULT NULL COMMENT '担保人流水时间起',
    `gua_jour_datetime_end` DATETIME DEFAULT NULL COMMENT '担保人流水时间止',
    `gua_jour_income` BIGINT(20) DEFAULT NULL COMMENT '担保人收入',
    `gua_jour_expend` BIGINT(20) DEFAULT NULL COMMENT '担保人支出',
    `gua_jour_balance` BIGINT(20) DEFAULT NULL COMMENT '担保人帐户余额',
    `gua_jour_month_income` BIGINT(20) DEFAULT NULL COMMENT '担保人月均收入',
    `gua_jour_month_expend` BIGINT(20) DEFAULT NULL COMMENT '担保人月均支出',
    `gua_jour_pic` TEXT COMMENT '担保人流水图片',
    `gua_jour_remark` tinytext DEFAULT NULL COMMENT '担保人流水备注',
    `gua_asset_pdf` TEXT COMMENT '担保人资产资料pdf',
    `emergency_name1` tinytext DEFAULT NULL COMMENT '家庭紧急联系人信息1 姓名',
    `emergency_relation1` tinytext DEFAULT NULL COMMENT '家庭紧急联系人信息1 与申请人关系',
    `emergency_mobile1` tinytext DEFAULT NULL COMMENT '家庭紧急联系人信息1 手机号码',
    `emergency_name2` tinytext DEFAULT NULL COMMENT '家庭紧急联系人信息2 姓名',
    `emergency_relation2` tinytext DEFAULT NULL COMMENT '家庭紧急联系人信息2 与申请人关系',
    `emergency_mobile2` tinytext DEFAULT NULL COMMENT '家庭紧急联系人信息2 手机号码',
    `zfb_jour_datetime_start` DATETIME DEFAULT NULL COMMENT '支付宝流水时间起',
    `zfb_jour_datetime_end` DATETIME DEFAULT NULL COMMENT '支付宝流水时间止',
    `zfb_jour_income` BIGINT(20) DEFAULT NULL COMMENT '支付宝收入',
    `zfb_jour_expend` BIGINT(20) DEFAULT NULL COMMENT '支付宝支出',
    `zfb_jour_balance` BIGINT(20) DEFAULT NULL COMMENT '支付宝帐户余额',
    `zfb_jour_month_income` BIGINT(20) DEFAULT NULL COMMENT '支付宝月均收入',
    `zfb_jour_month_expend` BIGINT(20) DEFAULT NULL COMMENT '支付宝月均支出',
    `zfb_jour_pic` TEXT COMMENT '支付宝流水图片',
    `zfb_jour_remark` tinytext DEFAULT NULL COMMENT '支付宝流水备注',
    `wx_jour_datetime_start` DATETIME DEFAULT NULL COMMENT '微信流水时间起',
    `wx_jour_datetime_end` DATETIME DEFAULT NULL COMMENT '微信流水时间止',
    `wx_jour_income` BIGINT(20) DEFAULT NULL COMMENT '微信收入',
    `wx_jour_expend` BIGINT(20) DEFAULT NULL COMMENT '微信支出',
    `wx_jour_balance` BIGINT(20) DEFAULT NULL COMMENT '微信帐户余额',
    `wx_jour_month_income` BIGINT(20) DEFAULT NULL COMMENT '微信月均收入',
    `wx_jour_month_expend` BIGINT(20) DEFAULT NULL COMMENT '微信月均支出',
    `wx_jour_pic` TEXT COMMENT '微信流水图片',
    `wx_jour_remark` tinytext DEFAULT NULL COMMENT '微信流水备注',
    `jour_datetime_start` DATETIME DEFAULT NULL COMMENT '流水时间起',
    `jour_datetime_end` DATETIME DEFAULT NULL COMMENT '流水时间止',
    `jour_income` BIGINT(20) DEFAULT NULL COMMENT '收入',
    `jour_expend` BIGINT(20) DEFAULT NULL COMMENT '支出',
    `jour_balance` BIGINT(20) DEFAULT NULL COMMENT '帐户余额',
    `jour_month_income` BIGINT(20) DEFAULT NULL COMMENT '月均收入',
    `jour_month_expend` BIGINT(20) DEFAULT NULL COMMENT '月均支出',
    `jour_pic` TEXT COMMENT '流水图片',
    `jour_remark` tinytext DEFAULT NULL COMMENT '流水备注',
    `asset_pdf` TEXT COMMENT '资产资料pdf',
    `house_contract` TEXT DEFAULT NULL COMMENT '购房合同',
    `house_picture` TEXT DEFAULT NULL COMMENT '房屋照片',
    `is_advance_fund` tinytext DEFAULT NULL COMMENT '是否垫资',
    `interview_video` tinytext DEFAULT NULL COMMENT '面签视频',
    `interview_contract` tinytext DEFAULT NULL COMMENT '面签合同',
    `advance_fund_datetime` DATETIME DEFAULT NULL COMMENT '垫资日期',
    `advance_fund_amount` BIGINT(20) DEFAULT NULL COMMENT '垫资金额',
    `bill_pdf` tinytext DEFAULT NULL COMMENT '水单',
    `car_settle_datetime` DATETIME DEFAULT NULL COMMENT '车辆落户日期',
    `car_number` tinytext DEFAULT NULL COMMENT '车牌号',
    `car_invoice` tinytext DEFAULT NULL COMMENT '车辆发票',
    `car_hgz` tinytext DEFAULT NULL COMMENT '合格证',
    `car_jqx` tinytext DEFAULT NULL COMMENT '交强险',
    `car_syx` tinytext DEFAULT NULL COMMENT '商业险',
    `car_regcerti` tinytext DEFAULT NULL COMMENT '登记证书',
    `car_pd` tinytext DEFAULT NULL COMMENT '车辆批单',
    `car_key` tinytext DEFAULT NULL COMMENT '车钥匙',
    `car_big_smj` tinytext DEFAULT NULL COMMENT '大本扫描件',
    `bank_commit_datetime` DATETIME DEFAULT NULL COMMENT '银行提交时间',
    `bank_commit_note` tinytext DEFAULT NULL COMMENT '银行提交说明',
    `bank_fk_datetime` DATETIME DEFAULT NULL COMMENT '银行放款时间',
    `repay_bank_code` VARCHAR(32) DEFAULT NULL COMMENT '还款卡银行编号',
    `repay_bank_name` tinytext DEFAULT NULL COMMENT '还款卡银行名称',
    `repay_subbranch` tinytext DEFAULT NULL COMMENT '还款卡开户支行',
    `repay_bankcard_number` tinytext DEFAULT NULL COMMENT '还款卡银行卡号',
    `repay_bill_date` INT(11) DEFAULT NULL COMMENT '银行账单日',
    `repay_bank_date` INT(11) DEFAULT NULL COMMENT '银行还款日',
    `repay_company_date` INT(11) DEFAULT NULL COMMENT '公司还款日',
    `repay_first_month_amount` BIGINT(20) DEFAULT NULL COMMENT '首期月供金额',
    `repay_first_month_datetime` DATETIME DEFAULT NULL COMMENT '首期还款日期',
    `repay_month_amount` BIGINT(20) DEFAULT NULL COMMENT '每期月供金额',
    `receipt_bank_code` tinytext DEFAULT NULL COMMENT '收款银行编号',
    `receipt_bank_name` tinytext DEFAULT NULL COMMENT '收款银行名称',
    `receipt_bankcard_number` tinytext DEFAULT NULL COMMENT '收款银行卡号',
    `receipt_pdf` tinytext DEFAULT NULL COMMENT '收款凭证',
    `receipt_remark` tinytext DEFAULT NULL COMMENT '收款备注',
    `pledge_datetime` DATETIME DEFAULT NULL COMMENT '抵押日期',
    `green_big_smj` tinytext DEFAULT NULL COMMENT '绿大本扫描件',
    `pledge_bank_commit_datetime` DATETIME DEFAULT NULL COMMENT '抵押提交银行时间',
    `pledge_bank_commit_note` tinytext DEFAULT NULL COMMENT '抵押提交说明',
    `enter_location` tinytext DEFAULT NULL COMMENT '入档位置',
    `sale_user_id` VARCHAR(32) DEFAULT NULL COMMENT '业务员编号',
    `company_code` VARCHAR(32) DEFAULT NULL COMMENT '业务公司编号',
    `apply_datetime` DATETIME DEFAULT NULL COMMENT '申请时间',
    `cur_node_code` VARCHAR(32) DEFAULT NULL COMMENT '当前节点编号',
    `remark` tinytext DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`code`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='准入单';

-- ----------------------------
--  Table structure for `tdq_budget_order_fee`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_budget_order_fee`;
CREATE TABLE `tdq_budget_order_fee` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `should_amount` bigint(20) DEFAULT NULL COMMENT '应收手续费总额',
  `real_amount` bigint(20) DEFAULT NULL COMMENT '实收手续费总额',
  `is_settled` varchar(32) DEFAULT NULL COMMENT '是否已结清(0 待结清 1 已结清)',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `budget_order` varchar(32) NOT NULL COMMENT '预算单编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdq_budget_order_fee_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_budget_order_fee_detail`;
CREATE TABLE `tdq_budget_order_fee_detail` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `remit_type` varchar(32) NOT NULL COMMENT '交款类型',
  `plat_bankcard` varchar(32) DEFAULT NULL COMMENT '平台账号',
  `remit_project` varchar(255) DEFAULT NULL COMMENT '交款项目',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `remit_user` varchar(255) DEFAULT NULL COMMENT '汇款人',
  `reach_datetime` datetime DEFAULT NULL COMMENT '到账时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(32) NOT NULL COMMENT '备注',
  `fee_code` varchar(32) NOT NULL COMMENT '手续费编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdq_budget_order_gps`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_budget_order_gps`;
CREATE TABLE `tdq_budget_order_gps` (
  `code` varchar(32) NOT NULL COMMENT 'gps编号',
  `gps_dev_no` varchar(32) DEFAULT NULL COMMENT 'gps设备号',
  `gps_type` varchar(32) DEFAULT NULL COMMENT 'gps类型',
  `az_location` varchar(32) DEFAULT NULL COMMENT '安装位置',
  `az_datetime` datetime DEFAULT NULL COMMENT '安装时间',
  `az_user` varchar(255) DEFAULT NULL COMMENT '安装人员',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `budget_order` varchar(32) NOT NULL COMMENT '预算单编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdq_credit`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_credit`;
CREATE TABLE `tdq_credit` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `loan_bank_code` varchar(32) DEFAULT NULL COMMENT '贷款银行编号',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `biz_type` varchar(4) DEFAULT NULL COMMENT '业务种类',
  `second_car_report` varchar(255) DEFAULT NULL COMMENT '二手车评估报告',
  `xsz_front` varchar(255) DEFAULT NULL COMMENT '行驶证正面',
  `xsz_reverse` varchar(255) DEFAULT NULL COMMENT '行驶证反面',
  `budget_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司',
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdq_credit_user`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_credit_user`;
CREATE TABLE `tdq_credit_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '征信业务编号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `relation` varchar(255) DEFAULT NULL COMMENT '与借款人关系',
  `loan_role` varchar(255) DEFAULT NULL COMMENT '贷款角色',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `id_no_front` varchar(255) DEFAULT NULL COMMENT '身份证正面',
  `id_no_reverse` varchar(255) DEFAULT NULL COMMENT '身份证反面',
  `auth_pdf` varchar(255) DEFAULT NULL COMMENT '征信查询授权书',
  `interview_pic` varchar(255) DEFAULT NULL COMMENT '面签照片',
  `bank_credit_result_pdf` varchar(255) DEFAULT NULL COMMENT '银行征信结果说明',
  `bank_credit_result_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdq_loan_product`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_loan_product`;
CREATE TABLE `tdq_loan_product` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `loan_bank` varchar(255) DEFAULT NULL COMMENT '贷款银行',
  `wan_factor` bigint(20) DEFAULT NULL COMMENT '万元系数',
  `year_rate` decimal(18,8) DEFAULT NULL COMMENT '年利率',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS费用',
  `auth_rate` decimal(18,8) DEFAULT NULL COMMENT '公证费比率',
  `back_rate` decimal(18,8) DEFAULT NULL COMMENT '返点利率',
  `pre_rate` decimal(18,8) DEFAULT NULL COMMENT '前置利率',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0 待上架 1已上架 2已下架)',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdq_logistics`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_logistics`;
CREATE TABLE `tdq_logistics` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1 贷前)',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `from_node_code` varchar(255) DEFAULT NULL COMMENT '来方节点',
  `to_node_code` varchar(255) DEFAULT NULL COMMENT '去方节点',
  `ref_file_list` varchar(255) DEFAULT NULL COMMENT '参考材料清单(逗号隔开)',
  `send_file_list` varchar(255) DEFAULT NULL COMMENT '寄送材料清单(逗号隔开)',
  `send_type` varchar(4) DEFAULT NULL COMMENT '寄送方式(1 线下 2 快递)',
  `logistics_company` varchar(32) DEFAULT NULL COMMENT '快递公司',
  `logistics_code` varchar(255) DEFAULT NULL COMMENT '快递单号',
  `send_datetime` datetime DEFAULT NULL COMMENT '发货时间',
  `send_note` varchar(255) DEFAULT NULL COMMENT '发货说明',
  `receipt_datetime` datetime DEFAULT NULL COMMENT '收件时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 待发件 1已发件待收件 2已收件审核 3已收件待补件)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tht_brand`
-- ----------------------------
DROP TABLE IF EXISTS `tht_brand`;
CREATE TABLE `tht_brand` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `letter` varchar(32) DEFAULT NULL COMMENT '字母序号',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `description` text COMMENT '品牌介绍',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最新修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最新修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '品牌'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tht_car`
-- ----------------------------
DROP TABLE IF EXISTS `tht_car`;
CREATE TABLE `tht_car` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `series_code` varchar(32) DEFAULT NULL COMMENT '车系编号',
  `series_name` varchar(255) DEFAULT NULL COMMENT '车系名称',
  `brand_code` varchar(32) DEFAULT NULL COMMENT '品牌编号',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `original_price` bigint(32) DEFAULT NULL COMMENT '原价',
  `sale_price` bigint(32) DEFAULT NULL COMMENT '参考价',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `location` int(11) DEFAULT NULL COMMENT 'UI位置',
  `order_no` int(11) DEFAULT NULL COMMENT 'UI次序',
  `slogan` text COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `pic` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `description` text COMMENT '图文描述',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最新修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最新修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '车型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tht_car_order`
-- ----------------------------
DROP TABLE IF EXISTS `tht_car_order`;
CREATE TABLE `tht_car_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `user_mobile` varchar(16) DEFAULT NULL COMMENT '申请人手机号',
  `brand_code` varchar(32) DEFAULT NULL COMMENT '品牌编号',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `series_code` varchar(32) DEFAULT NULL COMMENT '车系编号',
  `series_name` varchar(255) DEFAULT NULL COMMENT '车系名称',
  `car_code` varchar(32) DEFAULT NULL COMMENT '车型编号',
  `car_name` varchar(255) DEFAULT NULL COMMENT '车型名称',
  `price` bigint(20) DEFAULT NULL COMMENT '车辆总价',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `periods` int(11) DEFAULT NULL COMMENT '分期期数',
  `create_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `sale_desc` text COMMENT '计算器信息',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `handler` varchar(32) DEFAULT NULL COMMENT '处理人',
  `handle_datetime` datetime DEFAULT NULL COMMENT '处理时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '购车意向'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tht_series`
-- ----------------------------
DROP TABLE IF EXISTS `tht_series`;
CREATE TABLE `tht_series` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `brand_code` varchar(32) DEFAULT NULL COMMENT '品牌编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `slogan` text COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `price` bigint(20) DEFAULT NULL COMMENT '价格区间',
  `location` int(11) DEFAULT NULL COMMENT 'UI位置',
  `order_no` int(11) DEFAULT NULL COMMENT 'UI次序',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最新修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最新修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '车系'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_category`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_category`;
CREATE TABLE `tmall_category` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父节点',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`code`) COMMENT '分类'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tmall_order`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_order`;
CREATE TABLE `tmall_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `bankcard_code` varchar(32) DEFAULT NULL COMMENT '银行卡编号',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收件人姓名',
  `re_mobile` varchar(32) DEFAULT NULL COMMENT '收件人电话',
  `re_address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '下单人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '下单嘱咐',
  `apply_datetime` datetime DEFAULT NULL COMMENT '下单时间',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `yunfei` bigint(20) DEFAULT NULL COMMENT '运费',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `pay_type` varchar(32) DEFAULT NULL COMMENT '支付方式',
  `pay_group` varchar(32) DEFAULT NULL COMMENT '支付组号',
  `pay_code` varchar(32) DEFAULT NULL COMMENT '支付编号',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `pay_amount` bigint(20) DEFAULT NULL COMMENT '支付金额',
  `deliverer` varchar(32) DEFAULT NULL COMMENT '发货人',
  `delivery_datetime` datetime DEFAULT NULL COMMENT '发货时间',
  `logistics_company` varchar(32) DEFAULT NULL COMMENT '物流公司编号',
  `logistics_code` varchar(32) DEFAULT NULL COMMENT '物流单号',
  `pdf` varchar(255) DEFAULT NULL COMMENT '物流单',
  `signer` varchar(32) DEFAULT NULL COMMENT '签收人',
  `sign_datetime` datetime DEFAULT NULL COMMENT '签收时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '订单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tmall_product`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_product`;
CREATE TABLE `tmall_product` (
  `code` varchar(32) NOT NULL COMMENT '商品编号',
  `category` varchar(32) DEFAULT NULL COMMENT '大类',
  `type` varchar(32) DEFAULT NULL COMMENT '小类',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `slogan` varchar(255) DEFAULT NULL COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `sale_status` varchar(255) DEFAULT NULL COMMENT '销售状态',
  `pic` text COMMENT 'pic',
  `description` text COMMENT '图文描述',
  `original_price` bigint(20) DEFAULT NULL COMMENT '原价',
  `price` bigint(20) DEFAULT NULL COMMENT '价格（人民币）',
  `credit_score` bigint(20) DEFAULT NULL COMMENT '最低购买信用分',
  `location` varchar(32) DEFAULT NULL COMMENT '位置(0 普通 1 热门)',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  `status` varchar(4) DEFAULT NULL COMMENT '产品状态',
  `bought_count` int(11) DEFAULT NULL COMMENT '已购买数量',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '产品'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tmall_product_order`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_product_order`;
CREATE TABLE `tmall_product_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `order_code` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `product_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `product_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `product_specs_code` varchar(32) DEFAULT NULL COMMENT '商品参数编号',
  `product_specs_name` varchar(32) DEFAULT NULL COMMENT '商品参数名称',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` bigint(20) DEFAULT NULL COMMENT '价格',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tmall_product_specs`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_product_specs`;
CREATE TABLE `tmall_product_specs` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '规格名称',
  `pic` text COMMENT 'pic',
  `product_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `original_price` bigint(20) DEFAULT NULL COMMENT '原价',
  `price` bigint(20) DEFAULT NULL COMMENT '价格（人民币）',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `quantity` int(11) DEFAULT NULL COMMENT '库存',
  `province` varchar(255) DEFAULT NULL COMMENT '发货地,精确到省份',
  `weight` decimal(18,8) DEFAULT NULL COMMENT '重量',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tp_archive`
-- ----------------------------
DROP TABLE IF EXISTS `tp_archive`;
CREATE TABLE `tp_archive` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `id_no` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `job_no` varchar(32) DEFAULT NULL COMMENT '工号',
  `entry_datetime` datetime DEFAULT NULL COMMENT '入职时间',
  `department_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `post_code` varchar(32) DEFAULT NULL COMMENT '职务岗位编号',
  `job_classes` varchar(32) DEFAULT NULL COMMENT '上班班次',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `marry_status` varchar(32) DEFAULT NULL COMMENT '婚姻状况',
  `politics` varchar(32) DEFAULT NULL COMMENT '政治面貌',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `education` varchar(32) DEFAULT NULL COMMENT '学历',
  `work_status` varchar(32) DEFAULT NULL COMMENT '状态',
  `health` varchar(32) DEFAULT NULL COMMENT '健康状况',
  `salary_card` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `five_insurance_info` varchar(255) DEFAULT NULL COMMENT '五险一金信息',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍地址',
  `residence_property` varchar(32) DEFAULT NULL COMMENT '户籍性质',
  `social_security_reg_datetime` datetime DEFAULT NULL COMMENT '社保登记日期',
  `current_address` varchar(255) DEFAULT NULL COMMENT '现住址',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(11) DEFAULT NULL COMMENT '紧急联系号码',
  `contract_deadline` varchar(32) DEFAULT NULL COMMENT '合同期限',
  `contract_type` varchar(32) DEFAULT NULL COMMENT '合同类型',
  `probation_time` varchar(32) DEFAULT NULL COMMENT '试用期时间',
  `convert_datetime` datetime DEFAULT NULL COMMENT '转正日期',
  `leave_datetime` datetime DEFAULT NULL COMMENT '离职日期',
  `leave_reason` varchar(255) DEFAULT NULL COMMENT '离职缘由',
  `heir_people` varchar(255) DEFAULT NULL COMMENT '交接人',
  `entrance_no` varchar(32) DEFAULT NULL COMMENT '门禁号',
  `check_no` varchar(32) DEFAULT NULL COMMENT '考勤号',
  `car_no` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `id_no_pdf` varchar(255) DEFAULT NULL COMMENT '身份证复印件',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `wechat` varchar(32) DEFAULT NULL COMMENT '微信',
  `qq` varchar(32) DEFAULT NULL COMMENT 'QQ',
  `perform_salary_standard` varchar(255) DEFAULT NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` varchar(255) DEFAULT NULL COMMENT '季度奖考核标准',
  `commumication_fee_standard` varchar(255) DEFAULT NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '省会住宿报销标准',
  `no_provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '非省会住宿报销标准',
  `traffic_award` bigint(20) DEFAULT NULL COMMENT '市内交通现金补助',
  `mobile_award` bigint(20) DEFAULT NULL COMMENT '电话现金补贴',
  `taxi_ward` bigint(20) DEFAULT NULL COMMENT '出租车',
  `meal_award` bigint(20) DEFAULT NULL COMMENT '餐补',
  `working_years` varchar(32) DEFAULT NULL COMMENT '工龄',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除1正常',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人事档案';

-- ----------------------------
--  Table structure for `tp_archive_location`
-- ----------------------------
DROP TABLE IF EXISTS `tp_archive_location`;
CREATE TABLE `tp_archive_location` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '位置名称',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='档案存放位置';

-- ----------------------------
--  Table structure for `tp_check_project`
-- ----------------------------
DROP TABLE IF EXISTS `tp_check_project`;
CREATE TABLE `tp_check_project` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `check_result` varchar(255) DEFAULT NULL COMMENT '考核指标',
  `check_user` varchar(255) DEFAULT NULL COMMENT '考核人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `employ_apply_code` varchar(32) NOT NULL COMMENT '应聘岗位编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考核项目';

-- ----------------------------
--  Table structure for `tp_comp_category`
-- ----------------------------
DROP TABLE IF EXISTS `tp_comp_category`;
CREATE TABLE `tp_comp_category` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类别管理';

-- ----------------------------
--  Table structure for `tp_comp_product`
-- ----------------------------
DROP TABLE IF EXISTS `tp_comp_product`;
CREATE TABLE `tp_comp_product` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `name` varchar(255) DEFAULT NULL COMMENT '品名',
  `model` varchar(255) DEFAULT NULL COMMENT '规格型号',
  `unit` varchar(32) DEFAULT NULL COMMENT '单位',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品名管理';

-- ----------------------------
--  Table structure for `tp_comp_regime`
-- ----------------------------
DROP TABLE IF EXISTS `tp_comp_regime`;
CREATE TABLE `tp_comp_regime` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1行政事务类 2 人力资源管理类 3 财务管理类 4 营销管理类 5 生产管理类)',
  `regime_code` varchar(32) DEFAULT NULL COMMENT '制度编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `scope` varchar(32) NOT NULL COMMENT '授权查看范围',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司制度';

-- ----------------------------
--  Table structure for `tp_contract`
-- ----------------------------
DROP TABLE IF EXISTS `tp_contract`;
CREATE TABLE `tp_contract` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(255) DEFAULT NULL COMMENT '合同类型',
  `archive_code` varchar(32) DEFAULT NULL COMMENT '档案编号',
  `contract_no` varchar(255) DEFAULT NULL COMMENT '合同编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始日期',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束日期',
  `pdf` varchar(255) DEFAULT NULL COMMENT '合同附件',
  `remark` varchar(255) DEFAULT NULL COMMENT '说明',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除 1正常',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tp_convert_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_convert_apply`;
CREATE TABLE `tp_convert_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `entry_code` varchar(32) DEFAULT NULL COMMENT '入职编号',
  `apply_user` varchar(255) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `work_summary` varchar(255) DEFAULT NULL COMMENT '工作总结',
  `all_evaluation` varchar(255) DEFAULT NULL COMMENT '总体评价',
  `is_full_worker` varchar(4) DEFAULT NULL COMMENT '是否转正',
  `effect_datetime` datetime DEFAULT NULL COMMENT '生效日期',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='转正申请';

-- ----------------------------
--  Table structure for `tp_employ_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_employ_apply`;
CREATE TABLE `tp_employ_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `position` varchar(255) DEFAULT NULL COMMENT '应聘岗位',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `id_no` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  `contact_mobile` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍所在地',
  `speciality` varchar(255) DEFAULT NULL COMMENT '特长技能',
  `expect_salary` bigint(20) DEFAULT NULL COMMENT '期望薪资',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(255) DEFAULT NULL COMMENT '紧急联系号码',
  `postcode` varchar(255) DEFAULT NULL COMMENT '邮编',
  `award` varchar(255) DEFAULT NULL COMMENT '受过何种奖励或专业训练',
  `is_out` char(1) DEFAULT NULL COMMENT '能否出差',
  `is_adjust_work` char(1) DEFAULT NULL COMMENT '能否接受工作调动',
  `is_once_recruited` varchar(255) DEFAULT NULL COMMENT '是否曾在我公司应聘',
  `is_friend_work` varchar(255) DEFAULT NULL COMMENT '是否有亲属或朋友在我司工作',
  `composite` varchar(255) DEFAULT NULL COMMENT '综合',
  `quality` varchar(255) DEFAULT NULL COMMENT '素质',
  `interview_record` varchar(255) DEFAULT NULL COMMENT '面试记录',
  `employ_result` varchar(255) DEFAULT NULL COMMENT '录用结果',
  `probation` varchar(255) DEFAULT NULL COMMENT '试用期',
  `employ_salary` bigint(20) DEFAULT NULL COMMENT '薪资',
  `employ_department_code` varchar(255) DEFAULT NULL COMMENT '入职部门',
  `employ_position_code` varchar(255) DEFAULT NULL COMMENT '入职职务',
  `employ_approve_user` varchar(255) DEFAULT NULL COMMENT '审核人',
  `employ_approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `employ_approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=待面试 1=已面试通过 2已面试不通过)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应聘岗位';

-- ----------------------------
--  Table structure for `tp_entry_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_entry_apply`;
CREATE TABLE `tp_entry_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `position` varchar(255) DEFAULT NULL COMMENT '入职岗位',
  `entry_datetime` datetime DEFAULT NULL COMMENT '入职时间',
  `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(4) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `health` varchar(32) DEFAULT NULL COMMENT '健康状况',
  `marry_status` varchar(32) DEFAULT NULL COMMENT '婚姻状况',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(32) DEFAULT NULL COMMENT '紧急联系号码',
  `residence_property` varchar(255) DEFAULT NULL COMMENT '户籍性质',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍所在地',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `is_other_company_relation` varchar(32) DEFAULT NULL COMMENT '是否与其他单位存在劳动关系',
  `relative_name` varchar(255) DEFAULT NULL COMMENT '亲属从事本行姓名',
  `relative_relation` varchar(255) DEFAULT NULL COMMENT '亲属与本人关系',
  `relative_position` varchar(255) DEFAULT NULL COMMENT '亲属职务',
  `main_perform` varchar(255) DEFAULT NULL COMMENT '主要业绩及工作能力简述',
  `probation_start_datetime` datetime DEFAULT NULL COMMENT '试用期期限开始',
  `probation_end_datetime` datetime DEFAULT NULL COMMENT '试用期期限结束',
  `probation_salary` bigint(20) DEFAULT NULL COMMENT '试用期工资',
  `base_salary` bigint(20) DEFAULT NULL COMMENT '转正后基本工资',
  `perform_salary` bigint(20) DEFAULT NULL COMMENT '转正后绩效工资',
  `perform_salary_standard` varchar(255) DEFAULT NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` varchar(255) DEFAULT NULL COMMENT '季度奖考核标准',
  `communicate_pay_standard` varchar(255) DEFAULT NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '省会住宿报销标准',
  `non_provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '非省会住宿报销标准',
  `traffic_standard` bigint(20) DEFAULT NULL COMMENT '市内交通现金补助',
  `mobile_standard` bigint(20) DEFAULT NULL COMMENT '电话现金补贴',
  `taxi_standard` bigint(20) DEFAULT NULL COMMENT '出租车',
  `meal_standard` bigint(20) DEFAULT NULL COMMENT '餐补',
  `salary_card_no` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '开户行行号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入职申请';

-- ----------------------------
--  Table structure for `tp_leave_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_leave_apply`;
CREATE TABLE `tp_leave_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `type` varchar(4) DEFAULT NULL COMMENT '请假类别',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` int(11) DEFAULT NULL COMMENT '时长',
  `pdf` varchar(32) DEFAULT NULL COMMENT '附件',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假申请';

-- ----------------------------
--  Table structure for `tp_notice`
-- ----------------------------
DROP TABLE IF EXISTS `tp_notice`;
CREATE TABLE `tp_notice` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1 公司动态 2 公司文件 3 培训说明)',
  `title` varchar(255) NOT NULL COMMENT '公告标题',
  `urgent_status` varchar(4) NOT NULL COMMENT '紧急程度（1 普通 2 紧急）',
  `publish_department_code` varchar(32) NOT NULL COMMENT '发布部门',
  `scope` varchar(32) NOT NULL COMMENT '公告范围',
  `content` varchar(255) NOT NULL COMMENT '公告内容',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告管理';

-- ----------------------------
--  Table structure for `tp_overtime_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_overtime_apply`;
CREATE TABLE `tp_overtime_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '共计时长',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加班申请';

-- ----------------------------
--  Table structure for `tp_probation_assess`
-- ----------------------------
DROP TABLE IF EXISTS `tp_probation_assess`;
CREATE TABLE `tp_probation_assess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `convert_code` varchar(32) DEFAULT NULL COMMENT '转正申请编号',
  `eval_item` varchar(255) DEFAULT NULL COMMENT '评估项目',
  `grade` decimal(18,8) DEFAULT NULL COMMENT '评估分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试用期评估';

-- ----------------------------
--  Table structure for `tp_recruit_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_recruit_apply`;
CREATE TABLE `tp_recruit_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `department_code` varchar(32) DEFAULT NULL COMMENT '申请部门编号',
  `position` varchar(255) DEFAULT NULL COMMENT '招聘岗位',
  `establish_quantity` int(11) DEFAULT NULL COMMENT '编制人数',
  `now_quantity` int(11) DEFAULT NULL COMMENT '现有人数',
  `apply_quantity` int(11) DEFAULT NULL COMMENT '申请补充人数',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `require_datetime` datetime DEFAULT NULL COMMENT '需要到岗时间',
  `replace_position` varchar(255) DEFAULT NULL COMMENT '被替代职位',
  `replace_real_name` varchar(255) DEFAULT NULL COMMENT '被替代者姓名',
  `new_apply_reason` varchar(255) DEFAULT NULL COMMENT '新申请职位原因',
  `position_now_quantity` int(11) DEFAULT NULL COMMENT '该职位现有人数',
  `position_add_reason` varchar(255) DEFAULT NULL COMMENT '该职位增加原因',
  `temp_start_datetime` datetime DEFAULT NULL COMMENT '临时聘用开始时间',
  `temp_end_datetime` datetime DEFAULT NULL COMMENT '临时聘用结束时间',
  `other_note` varchar(255) DEFAULT NULL COMMENT '说明',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` varchar(255) DEFAULT NULL COMMENT '年龄',
  `marry_state` varchar(255) DEFAULT NULL COMMENT '婚育情况',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `major_require` varchar(255) DEFAULT NULL COMMENT '专业资格',
  `ability_require` varchar(255) DEFAULT NULL COMMENT '能力要求',
  `experience` varchar(255) DEFAULT NULL COMMENT '相关工作经验',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用人申请';

-- ----------------------------
--  Table structure for `tp_social_relation`
-- ----------------------------
DROP TABLE IF EXISTS `tp_social_relation`;
CREATE TABLE `tp_social_relation` (
  `code` varchar(32) NOT NULL,
  `archive_code` varchar(32) DEFAULT NULL COMMENT '人事档案编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '成员姓名',
  `relation` varchar(255) DEFAULT NULL COMMENT '与本人关系',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `post` varchar(255) DEFAULT NULL COMMENT '担任职务',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除1正常',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社会关系';

-- ----------------------------
--  Table structure for `tp_storage_in`
-- ----------------------------
DROP TABLE IF EXISTS `tp_storage_in`;
CREATE TABLE `tp_storage_in` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `product_code` varchar(255) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(18,8) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(18,8) DEFAULT NULL COMMENT '总价',
  `valid_date_start` datetime DEFAULT NULL COMMENT '有效期起',
  `valid_date_end` datetime DEFAULT NULL COMMENT '有效期止',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入库管理';

-- ----------------------------
--  Table structure for `tp_storage_out`
-- ----------------------------
DROP TABLE IF EXISTS `tp_storage_out`;
CREATE TABLE `tp_storage_out` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `product_code` varchar(255) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(18,8) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(18,8) DEFAULT NULL COMMENT '总价',
  `storage_in_code` varchar(32) DEFAULT NULL COMMENT '入库编号',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库管理';

-- ----------------------------
--  Table structure for `tp_supple_sign_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_supple_sign_apply`;
CREATE TABLE `tp_supple_sign_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补签申请';

-- ----------------------------
--  Table structure for `tp_supple_sign_apply_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tp_supple_sign_apply_detail`;
CREATE TABLE `tp_supple_sign_apply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `supply_sign_apply_code` varchar(32) DEFAULT NULL COMMENT '补签申请编号',
  `supple_datetime` datetime DEFAULT NULL COMMENT '漏签日期',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补签申请明细';

-- ----------------------------
--  Table structure for `tp_travel_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_travel_apply`;
CREATE TABLE `tp_travel_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型(1=出差,2=公出)',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '共计时长',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出差/公出申请';

-- ----------------------------
--  Table structure for `tp_travel_apply_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tp_travel_apply_detail`;
CREATE TABLE `tp_travel_apply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `travel_apply_code` varchar(32) DEFAULT NULL COMMENT '出差申请编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '时长',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='时间申请明细';

-- ----------------------------
--  Table structure for `tp_work_experience`
-- ----------------------------
DROP TABLE IF EXISTS `tp_work_experience`;
CREATE TABLE `tp_work_experience` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父级编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '起始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '截止时间',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `leave_reason` varchar(255) DEFAULT NULL COMMENT '离职原因',
  `prover` varchar(255) DEFAULT NULL COMMENT '证明人',
  `prover_mobile` varchar(255) DEFAULT NULL COMMENT '证明人联系电话',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作经历';

-- ----------------------------
--  Table structure for `tstd_account`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_account`;
CREATE TABLE `tstd_account` (
  `account_number` varchar(32) NOT NULL DEFAULT '' COMMENT '账号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '真实姓名',
  `type` varchar(4) DEFAULT NULL COMMENT '类别（B端账号，C端账号，平台账号）',
  `status` varchar(2) DEFAULT NULL COMMENT '状态（正常/程序冻结/人工冻结）',
  `currency` varchar(8) DEFAULT NULL COMMENT '币种',
  `amount` decimal(64,0) DEFAULT NULL COMMENT '余额',
  `frozen_amount` decimal(64,0) DEFAULT NULL COMMENT '冻结金额',
  `md5` varchar(32) DEFAULT NULL COMMENT 'MD5',
  `add_amount` decimal(64,0) DEFAULT '0' COMMENT '累计增加金额',
  `in_amount` decimal(64,0) DEFAULT '0' COMMENT '入金',
  `out_amount` decimal(64,0) DEFAULT '0' COMMENT '出金',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `last_order` varchar(32) DEFAULT NULL COMMENT '最近一次变动对应的流水编号',
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_address`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_address`;
CREATE TABLE `tstd_address` (
  `code` varchar(32) NOT NULL COMMENT '收件编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `addressee` varchar(64) DEFAULT NULL COMMENT '收件人姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `city` varchar(64) DEFAULT NULL COMMENT '城市',
  `area` varchar(64) DEFAULT NULL COMMENT '区',
  `detail` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `is_default` char(1) DEFAULT NULL COMMENT '是否默认地址',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tstd_bankcard`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_bankcard`;
CREATE TABLE `tstd_bankcard` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '户名',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `bankcard_number` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `bind_mobile` varchar(32) DEFAULT NULL COMMENT '银行卡绑定手机号',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_channel_bank`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_channel_bank`;
CREATE TABLE `tstd_channel_bank` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '编号（自增长）',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `bank_name` varchar(32) DEFAULT NULL COMMENT '银行名称',
  `channel_type` varchar(4) DEFAULT NULL COMMENT '渠道类型',
  `status` varchar(4) DEFAULT NULL COMMENT '状态（启用/不启用）',
  `channel_bank` varchar(32) DEFAULT NULL COMMENT '渠道给银行的代号',
  `max_order` bigint(32) DEFAULT NULL COMMENT '笔数限制',
  `order_amount` bigint(32) DEFAULT NULL COMMENT '单笔限额',
  `day_amount` bigint(32) DEFAULT NULL COMMENT '每日限额',
  `month_amount` bigint(32) DEFAULT NULL COMMENT '每月限额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_charge`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_charge`;
CREATE TABLE `tstd_charge` (
  `code` varchar(32) NOT NULL COMMENT '针对编号',
  `pay_group` varchar(32) DEFAULT NULL COMMENT '支付组号',
  `ref_no` varchar(255) DEFAULT NULL COMMENT '流水分组组号',
  `account_number` varchar(32) DEFAULT NULL COMMENT '针对账号',
  `amount` decimal(64,0) DEFAULT NULL COMMENT '充值金额',
  `account_name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '针对户名',
  `type` varchar(4) DEFAULT NULL COMMENT '账户类型',
  `currency` varchar(8) DEFAULT NULL COMMENT '币种',
  `biz_type` varchar(32) DEFAULT NULL,
  `biz_note` varchar(255) DEFAULT NULL,
  `pay_card_info` varchar(255) DEFAULT NULL COMMENT '支付渠道账号信息',
  `pay_card_no` varchar(255) DEFAULT NULL COMMENT '支付渠道账号',
  `status` varchar(4) NOT NULL COMMENT '状态',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `pay_user` varchar(32) DEFAULT NULL COMMENT '支付回录人',
  `pay_note` varchar(255) DEFAULT NULL COMMENT '支付渠道说明',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '支付渠道',
  PRIMARY KEY (`code`) COMMENT '充值订单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_cnavigate`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_cnavigate`;
CREATE TABLE `tstd_cnavigate` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `url` varchar(255) DEFAULT NULL COMMENT '访问Url',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 显示 0 不显示)',
  `location` varchar(32) DEFAULT NULL COMMENT '位置',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  `belong` varchar(32) DEFAULT NULL COMMENT '属于(1 全局 2 地方默认 3 地方默认编号)',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `content_type` varchar(32) DEFAULT NULL COMMENT '内容源类型',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_jour`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_jour`;
CREATE TABLE `tstd_jour` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `kind` varchar(32) DEFAULT NULL COMMENT '流水类型（余额流水、冻结流水）',
  `pay_group` varchar(255) DEFAULT NULL COMMENT '订单分组组号',
  `ref_no` varchar(255) DEFAULT NULL COMMENT '参考订单号',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '支付渠道类型',
  `channel_order` varchar(255) DEFAULT NULL COMMENT '支付渠道单号',
  `account_number` varchar(32) DEFAULT NULL COMMENT '账号',
  `trans_amount` decimal(64,0) DEFAULT NULL COMMENT '变动金额',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '真实姓名',
  `type` varchar(4) DEFAULT NULL COMMENT '账户类型',
  `currency` varchar(8) DEFAULT NULL COMMENT '币种',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务类型',
  `biz_note` varchar(255) DEFAULT NULL COMMENT '业务类型',
  `pre_amount` decimal(64,0) DEFAULT NULL COMMENT '变动前金额',
  `post_amount` decimal(64,0) DEFAULT NULL COMMENT '变动后金额',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `work_date` varchar(8) DEFAULT NULL COMMENT '拟对账时间',
  `check_user` varchar(32) DEFAULT NULL COMMENT '对账人',
  `check_note` varchar(255) DEFAULT NULL COMMENT '对账说明',
  `check_datetime` datetime DEFAULT NULL COMMENT '对账时间',
  `adjust_user` varchar(32) DEFAULT NULL COMMENT '调账人',
  `adjust_note` varchar(255) DEFAULT NULL COMMENT '调账说明',
  `adjust_datetime` datetime DEFAULT NULL COMMENT '调账时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_user`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_user`;
CREATE TABLE `tstd_user` (
  `user_id` varchar(32) NOT NULL COMMENT '编号',
  `kind` varchar(4) DEFAULT NULL COMMENT '用户类型',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `login_pwd` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` varchar(4) DEFAULT NULL COMMENT '登录密码强度',
  `trade_pwd` varchar(32) DEFAULT NULL COMMENT '支付密码',
  `trade_pwd_strength` varchar(4) DEFAULT NULL COMMENT '支付密码强度',
  `user_referee` varchar(32) DEFAULT NULL COMMENT '推荐人编号',
  `referee_mobile` varchar(16) DEFAULT NULL COMMENT '推荐人手机号',
  `id_kind` varchar(4) DEFAULT NULL COMMENT '证件类型',
  `id_no` bigint(20) DEFAULT NULL COMMENT '证件号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `create_datetime` datetime DEFAULT NULL COMMENT '注册时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) COMMENT '用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_withdraw`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_withdraw`;
CREATE TABLE `tstd_withdraw` (
  `code` varchar(32) NOT NULL COMMENT '针对编号',
  `account_number` varchar(32) DEFAULT NULL COMMENT '针对账号',
  `account_name` varchar(32) DEFAULT NULL COMMENT '针对户名',
  `type` varchar(4) DEFAULT NULL COMMENT '类别（B端账号，C端账号，平台账号）',
  `amount` decimal(64,0) DEFAULT NULL COMMENT '取现金额',
  `fee` decimal(64,0) DEFAULT NULL COMMENT '手续费',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '支付渠道',
  `channel_bank` varchar(32) DEFAULT NULL COMMENT '渠道银行代号',
  `channel_order` varchar(255) DEFAULT NULL COMMENT '支付渠道编号',
  `pay_card_info` varchar(255) DEFAULT NULL COMMENT '支付渠道账号信息',
  `pay_card_no` varchar(255) DEFAULT NULL COMMENT '支付渠道账号',
  `status` varchar(4) NOT NULL COMMENT '状态',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `approve_user` varchar(32) DEFAULT NULL COMMENT '审批人',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审批说明',
  `approve_datetime` varchar(32) DEFAULT NULL COMMENT '审批时间',
  `pay_user` varchar(255) DEFAULT NULL COMMENT '支付回录人',
  `pay_note` varchar(255) DEFAULT NULL COMMENT '支付回录说明',
  `pay_group` varchar(255) DEFAULT NULL COMMENT '支付组号',
  `pay_code` varchar(255) DEFAULT NULL COMMENT '支付渠道订单编号',
  `pay_fee` decimal(64,0) DEFAULT NULL COMMENT '支付渠道手续费（矿工费）',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付回录时间',
  PRIMARY KEY (`code`) COMMENT '取现订单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_biz_log`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_biz_log`;
CREATE TABLE `tsys_biz_log` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `parent_order` varchar(32) NOT NULL COMMENT '上级订单编号',
  `ref_type` varchar(32) NOT NULL COMMENT '关联订单类型',
  `ref_order` varchar(32) NOT NULL COMMENT '关联订单编号',
  `deal_node` varchar(32) NOT NULL COMMENT '处理节点',
  `deal_note` varchar(255) DEFAULT NULL COMMENT '处理说明',
  `status` varchar(32) NOT NULL COMMENT '状态(0 待处理 1 已完成)',
  `operate_role` varchar(32) NOT NULL COMMENT '操作角色',
  `operator` varchar(32) NOT NULL COMMENT '操作人',
  `operator_name` varchar(32) DEFAULT NULL COMMENT '操作人姓名',
  `operator_mobile` varchar(32) DEFAULT NULL COMMENT '操作人手机号',
  `start_datetime` datetime NOT NULL COMMENT '操作开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '操作结束时间',
  `speed_time` varchar(255) DEFAULT NULL COMMENT '花费时间(单位：秒)',
  PRIMARY KEY (`id`) COMMENT '业务日志跟踪表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_config`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_config`;
CREATE TABLE `tsys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(96) DEFAULT NULL,
  `ckey` varchar(765) DEFAULT NULL,
  `cvalue` text,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  `company_code` varchar(96) DEFAULT NULL,
  `system_code` varchar(96) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_department`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_department`;
CREATE TABLE `tsys_department` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `type` varchar(32) DEFAULT NULL COMMENT '类型(1=子公司，2=部门，3=岗位)',
  `lead_name` varchar(255) DEFAULT NULL COMMENT '负责人',
  `mobile` varchar(16) DEFAULT NULL COMMENT '负责人手机号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '上级部门编号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '部门表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_dict`;
CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` char(3) DEFAULT NULL,
  `parent_key` varchar(96) DEFAULT NULL,
  `dkey` varchar(96) DEFAULT NULL,
  `dvalue` varchar(765) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  `company_code` varchar(96) DEFAULT NULL,
  `system_code` varchar(96) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_menu`;
CREATE TABLE `tsys_menu` (
  `code` varchar(96) DEFAULT NULL,
  `name` varchar(96) DEFAULT NULL,
  `type` varchar(6) DEFAULT NULL,
  `url` varchar(192) DEFAULT NULL,
  `order_no` varchar(24) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  `parent_code` varchar(96) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_menu_role`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_menu_role`;
CREATE TABLE `tsys_menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(96) DEFAULT NULL,
  `menu_code` varchar(96) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_node`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_node`;
CREATE TABLE `tsys_node` (
  `code` varchar(32) NOT NULL COMMENT '节点编号',
  `name` varchar(255) DEFAULT NULL COMMENT '节点名称',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '流程'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_node_flow`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_node_flow`;
CREATE TABLE `tsys_node_flow` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `current_node` varchar(32) NOT NULL COMMENT '当前节点',
  `next_node` varchar(32) DEFAULT NULL COMMENT '下一个节点',
  `back_node` varchar(32) DEFAULT NULL COMMENT '返回节点',
  `file_list` text,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) COMMENT '节点流程配置'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_role`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_role`;
CREATE TABLE `tsys_role` (
  `code` varchar(96) DEFAULT NULL,
  `name` varchar(96) DEFAULT NULL,
  `level` varchar(6) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_role_node`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_role_node`;
CREATE TABLE `tsys_role_node` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `node_code` varchar(32) DEFAULT NULL COMMENT '节点编号',
  PRIMARY KEY (`id`) COMMENT '角色节点'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_user`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_user`;
CREATE TABLE `tsys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `real_name` varchar(255) DEFAULT NULL,
  `login_pwd` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` char(1) DEFAULT NULL COMMENT '登录密码强度',
  `create_datetme` datetime DEFAULT NULL COMMENT '注册时间',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `company_code` varchar(32) DEFAULT NULL,
  `department_code` varchar(32) DEFAULT NULL,
  `post_code` varchar(32) DEFAULT NULL,
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;