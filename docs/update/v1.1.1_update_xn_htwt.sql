ALTER TABLE `tsys_department` 
DROP COLUMN `mobile`,
CHANGE COLUMN `type` `type` VARCHAR(32) NULL DEFAULT NULL COMMENT '类型(1=子公司，2=部门，3=岗位)' AFTER `code`,
CHANGE COLUMN `lead_name` `lead_user_id` VARCHAR(32) NULL DEFAULT NULL COMMENT '负责人编号' ,
ADD COLUMN `order_no` INT(11) NULL COMMENT '序号' AFTER `parent_code`;

ALTER TABLE `tsys_user` 
ADD COLUMN `archive_code` VARCHAR(32) NULL COMMENT '人事档案编号' AFTER `team_code`;

update tsys_user tu,tp_archive tp set tu.archive_code =tp.code where tu.user_id= tp.user_id;

DROP TABLE IF EXISTS `tdq_budget_order`;
CREATE TABLE `tdq_budget_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `loan_product_code` varchar(32) DEFAULT NULL COMMENT '贷款产品编号',
  `loan_product_name` tinytext COMMENT '贷款产品名称',
  `region` tinytext COMMENT '所属区域',
  `loan_bank` tinytext COMMENT '贷款银行',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS费用',
  `auth_fee` bigint(20) DEFAULT NULL COMMENT '公证费',
  `bank_fee` bigint(20) DEFAULT NULL COMMENT '银行服务费',
  `company_fee` bigint(20) DEFAULT NULL COMMENT '公司服务费',
  `team_fee` bigint(20) DEFAULT NULL COMMENT '团队服务费',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '征信单编号',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务种类',
  `loan_period` varchar(32) DEFAULT NULL COMMENT '贷款期限',
  `invoice_company` tinytext COMMENT '开票单位',
  `car_brand` tinytext COMMENT '品牌',
  `car_series` tinytext COMMENT '车系',
  `car_model` tinytext COMMENT '车型',
  `car_type` tinytext COMMENT '车辆类型',
  `car_pic` text COMMENT '车辆照片',
  `car_hgz_pic` tinytext COMMENT '合格证',
  `car_frame_no` tinytext COMMENT '车架号',
  `car_engine_no` tinytext COMMENT '发动机号',
  `original_price` bigint(20) DEFAULT NULL COMMENT '市场指导价',
  `invoice_price` bigint(20) DEFAULT NULL COMMENT '开票价',
  `car_color` tinytext COMMENT '颜色',
  `month_deposit` bigint(20) DEFAULT NULL COMMENT '月供保证金',
  `first_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `first_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款额',
  `settle_address` tinytext COMMENT '落户地点',
  `apply_user_id` tinytext COMMENT '申请人编号',
  `apply_user_name` tinytext COMMENT '申请人姓名',
  `gender` tinytext COMMENT '性别',
  `marry_state` tinytext COMMENT '婚姻状况',
  `political` tinytext COMMENT '政治面貌',
  `nation` tinytext COMMENT '民族',
  `education` tinytext COMMENT '学历',
  `id_kind` varchar(32) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `family_number` varchar(255) DEFAULT NULL COMMENT '家庭人口',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `is_card_mail_address` varchar(255) DEFAULT NULL COMMENT '是否卡邮寄地址',
  `post_code1` varchar(255) DEFAULT NULL COMMENT '邮编1',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户口所在地',
  `post_code2` tinytext COMMENT '邮编2',
  `family_main_asset` text COMMENT '家庭主要财产',
  `main_asset_include` text COMMENT '主要财产包括',
  `main_income` tinytext COMMENT '主要收入来源',
  `work_company_name` tinytext COMMENT '工作单位名称',
  `work_company_address` tinytext COMMENT '工作单位地址',
  `work_is_card_mail_address` tinytext COMMENT '工作单位地址',
  `work_company_property` tinytext COMMENT '单位性质',
  `work_belong_industry` tinytext COMMENT '所属行业',
  `work_profession` tinytext COMMENT '职业',
  `work_datetime` datetime DEFAULT NULL COMMENT '何时进入现单位工作',
  `self_company_area` tinytext COMMENT '自营公司单位面积',
  `employee_quantity` varchar(255) DEFAULT NULL COMMENT '员工数量',
  `enterprise_month_output` tinytext COMMENT '企业月产值',
  `position` tinytext COMMENT '职位',
  `post_title` tinytext COMMENT '职称',
  `month_income` tinytext COMMENT '月收入',
  `mate_name` tinytext COMMENT '配偶姓名',
  `mate_mobile` tinytext COMMENT '配偶手机号',
  `mate_id_no` tinytext COMMENT '配偶身份证号',
  `mate_education` tinytext COMMENT '配偶学历',
  `mate_company_name` tinytext COMMENT '配偶工作单位名称',
  `mate_company_address` tinytext COMMENT '配偶工作单位地址',
  `mate_company_contact_no` tinytext COMMENT '配偶工作单位联系电话',
  `mate_zfb_jour_datetime_start` datetime DEFAULT NULL COMMENT '配偶支付宝流水时间起',
  `mate_zfb_jour_datetime_end` datetime DEFAULT NULL COMMENT '配偶支付宝流水时间止',
  `mate_zfb_jour_interest` tinytext DEFAULT NULL COMMENT '配偶支付宝流水结息',
  `mate_zfb_jour_income` bigint(20) DEFAULT NULL COMMENT '配偶支付宝收入',
  `mate_zfb_jour_expend` bigint(20) DEFAULT NULL COMMENT '配偶支付宝支出',
  `mate_zfb_jour_balance` bigint(20) DEFAULT NULL COMMENT '配偶支付宝帐户余额',
  `mate_zfb_jour_month_income` bigint(20) DEFAULT NULL COMMENT '配偶支付宝月均收入',
  `mate_zfb_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '配偶支付宝月均支出',
  `mate_zfb_jour_pic` text COMMENT '配偶支付宝流水图片',
  `mate_zfb_jour_remark` tinytext COMMENT '配偶支付宝流水备注',
  `mate_wx_jour_datetime_start` datetime DEFAULT NULL COMMENT '配偶微信流水时间起',
  `mate_wx_jour_datetime_end` datetime DEFAULT NULL COMMENT '配偶微信流水时间止',
  `mate_wx_jour_interest` tinytext DEFAULT NULL COMMENT '配偶微信流水结息',
  `mate_wx_jour_income` bigint(20) DEFAULT NULL COMMENT '配偶微信收入',
  `mate_wx_jour_expend` bigint(20) DEFAULT NULL COMMENT '配偶微信支出',
  `mate_wx_jour_balance` bigint(20) DEFAULT NULL COMMENT '配偶微信帐户余额',
  `mate_wx_jour_month_income` bigint(20) DEFAULT NULL COMMENT '配偶微信月均收入',
  `mate_wx_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '配偶微信月均支出',
  `mate_wx_jour_pic` text COMMENT '配偶微信流水图片',
  `mate_wx_jour_remark` tinytext COMMENT '配偶微信流水备注',
  `mate_jour_datetime_start` datetime DEFAULT NULL COMMENT '配偶流水时间起',
  `mate_jour_datetime_end` datetime DEFAULT NULL COMMENT '配偶流水时间止',
  `mate_jour_interest` tinytext DEFAULT NULL COMMENT '配偶流水结息',
  `mate_jour_income` bigint(20) DEFAULT NULL COMMENT '配偶收入',
  `mate_jour_expend` bigint(20) DEFAULT NULL COMMENT '配偶支出',
  `mate_jour_balance` bigint(20) DEFAULT NULL COMMENT '配偶帐户余额',
  `mate_jour_month_income` bigint(20) DEFAULT NULL COMMENT '配偶月均收入',
  `mate_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '配偶月均支出',
  `mate_jour_pic` text COMMENT '配偶流水图片',
  `mate_jour_remark` tinytext COMMENT '配偶流水备注',
  `mate_asset_pdf` text COMMENT '配偶资产资料pdf',
  `gua_name` tinytext COMMENT '担保人姓名',
  `gua_mobile` tinytext COMMENT '担保人手机号',
  `gua_id_no` tinytext COMMENT '担保人身份证号',
  `gua_phone` tinytext COMMENT '担保人固定电话',
  `gua_company_name` tinytext COMMENT '担保人工作单位名称',
  `gua_company_address` tinytext COMMENT '担保人工作单位地址',
  `gua_house_asset_address` tinytext COMMENT '担保人房产地址',
  `gua_zfb_jour_datetime_start` datetime DEFAULT NULL COMMENT '担保人支付宝流水时间起',
  `gua_zfb_jour_datetime_end` datetime DEFAULT NULL COMMENT '担保人支付宝流水时间止',
  `gua_zfb_jour_interest` tinytext DEFAULT NULL COMMENT '担保人支付宝流水结息',
  `gua_zfb_jour_income` bigint(20) DEFAULT NULL COMMENT '担保人支付宝收入',
  `gua_zfb_jour_expend` bigint(20) DEFAULT NULL COMMENT '担保人支付宝支出',
  `gua_zfb_jour_balance` bigint(20) DEFAULT NULL COMMENT '担保人支付宝帐户余额',
  `gua_zfb_jour_month_income` bigint(20) DEFAULT NULL COMMENT '担保人支付宝月均收入',
  `gua_zfb_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '担保人支付宝月均支出',
  `gua_zfb_jour_pic` text COMMENT '担保人支付宝流水图片',
  `gua_zfb_jour_remark` tinytext COMMENT '担保人支付宝流水备注',
  `gua_wx_jour_datetime_start` datetime DEFAULT NULL COMMENT '担保人微信流水时间起',
  `gua_wx_jour_datetime_end` datetime DEFAULT NULL COMMENT '担保人微信流水时间止',
  `gua_wx_jour_interest` tinytext DEFAULT NULL COMMENT '担保人微信流水结息',
  `gua_wx_jour_income` bigint(20) DEFAULT NULL COMMENT '担保人微信收入',
  `gua_wx_jour_expend` bigint(20) DEFAULT NULL COMMENT '担保人微信支出',
  `gua_wx_jour_balance` bigint(20) DEFAULT NULL COMMENT '担保人微信帐户余额',
  `gua_wx_jour_month_income` bigint(20) DEFAULT NULL COMMENT '担保人微信月均收入',
  `gua_wx_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '担保人微信月均支出',
  `gua_wx_jour_pic` text COMMENT '担保人微信流水图片',
  `gua_wx_jour_remark` tinytext COMMENT '担保人微信流水备注',
  `gua_jour_datetime_start` datetime DEFAULT NULL COMMENT '担保人流水时间起',
  `gua_jour_datetime_end` datetime DEFAULT NULL COMMENT '担保人流水时间止',
  `gua_jour_interest` tinytext DEFAULT NULL COMMENT '担保人流水结息',
  `gua_jour_income` bigint(20) DEFAULT NULL COMMENT '担保人收入',
  `gua_jour_expend` bigint(20) DEFAULT NULL COMMENT '担保人支出',
  `gua_jour_balance` bigint(20) DEFAULT NULL COMMENT '担保人帐户余额',
  `gua_jour_month_income` bigint(20) DEFAULT NULL COMMENT '担保人月均收入',
  `gua_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '担保人月均支出',
  `gua_jour_pic` text COMMENT '担保人流水图片',
  `gua_jour_remark` tinytext COMMENT '担保人流水备注',
  `gua_asset_pdf` text COMMENT '担保人资产资料pdf',
  `emergency_name1` tinytext COMMENT '家庭紧急联系人信息1 姓名',
  `emergency_relation1` tinytext COMMENT '家庭紧急联系人信息1 与申请人关系',
  `emergency_mobile1` tinytext COMMENT '家庭紧急联系人信息1 手机号码',
  `emergency_name2` tinytext COMMENT '家庭紧急联系人信息2 姓名',
  `emergency_relation2` tinytext COMMENT '家庭紧急联系人信息2 与申请人关系',
  `emergency_mobile2` tinytext COMMENT '家庭紧急联系人信息2 手机号码',
  `zfb_jour_datetime_start` datetime DEFAULT NULL COMMENT '支付宝流水时间起',
  `zfb_jour_datetime_end` datetime DEFAULT NULL COMMENT '支付宝流水结息',
  `zfb_jour_interest` tinytext DEFAULT NULL COMMENT '支付宝流水时间止',
  `zfb_jour_income` bigint(20) DEFAULT NULL COMMENT '支付宝收入',
  `zfb_jour_expend` bigint(20) DEFAULT NULL COMMENT '支付宝支出',
  `zfb_jour_balance` bigint(20) DEFAULT NULL COMMENT '支付宝帐户余额',
  `zfb_jour_month_income` bigint(20) DEFAULT NULL COMMENT '支付宝月均收入',
  `zfb_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '支付宝月均支出',
  `zfb_jour_pic` text COMMENT '支付宝流水图片',
  `zfb_jour_remark` tinytext COMMENT '支付宝流水备注',
  `wx_jour_datetime_start` datetime DEFAULT NULL COMMENT '微信流水时间起',
  `wx_jour_datetime_end` datetime DEFAULT NULL COMMENT '微信流水时间止',
  `wx_jour_interest` tinytext DEFAULT NULL COMMENT '微信流水结息',
  `wx_jour_income` bigint(20) DEFAULT NULL COMMENT '微信收入',
  `wx_jour_expend` bigint(20) DEFAULT NULL COMMENT '微信支出',
  `wx_jour_balance` bigint(20) DEFAULT NULL COMMENT '微信帐户余额',
  `wx_jour_month_income` bigint(20) DEFAULT NULL COMMENT '微信月均收入',
  `wx_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '微信月均支出',
  `wx_jour_pic` text COMMENT '微信流水图片',
  `wx_jour_remark` tinytext COMMENT '微信流水备注',
  `jour_datetime_start` datetime DEFAULT NULL COMMENT '流水时间起',
  `jour_datetime_end` datetime DEFAULT NULL COMMENT '流水时间止',
  `jour_interest` tinytext DEFAULT NULL COMMENT '流水结息',
  `jour_income` bigint(20) DEFAULT NULL COMMENT '收入',
  `jour_expend` bigint(20) DEFAULT NULL COMMENT '支出',
  `jour_balance` bigint(20) DEFAULT NULL COMMENT '帐户余额',
  `jour_month_income` bigint(20) DEFAULT NULL COMMENT '月均收入',
  `jour_month_expend` bigint(20) DEFAULT NULL COMMENT '月均支出',
  `jour_pic` text COMMENT '流水图片',
  `jour_remark` tinytext COMMENT '流水备注',
  `asset_pdf` text COMMENT '资产资料pdf',
  `house_contract` text COMMENT '购房合同',
  `house_picture` text COMMENT '房屋照片',
  `hk_book_pdf` tinytext COMMENT '户口本资料',
  `id_card_pdf` tinytext COMMENT '身份证资料',
  `marry_pdf` tinytext COMMENT '结婚证资料',
  `other_pdf` tinytext COMMENT '其他资料',
  `is_advance_fund` tinytext COMMENT '是否垫资',
  `bank_video` tinytext COMMENT '银行视频',
  `company_video` tinytext COMMENT '公司视频',
  `interview_contract` tinytext COMMENT '面签合同',
  `advance_fund_datetime` datetime DEFAULT NULL COMMENT '垫资日期',
  `advance_fund_amount` bigint(20) DEFAULT NULL COMMENT '垫资金额',
  `bill_pdf` tinytext COMMENT '水单',
  `advance_fund_amount_pdf` tinytext COMMENT '资金划转授权书',
  `advance_fund_other_pdf` tinytext COMMENT '垫资其他资料',
  `car_settle_datetime` datetime DEFAULT NULL COMMENT '车辆落户日期',
  `car_number` tinytext COMMENT '车牌号',
  `car_invoice` tinytext COMMENT '车辆发票',
  `car_hgz` tinytext COMMENT '合格证',
  `car_jqx` tinytext COMMENT '交强险',
  `car_syx` tinytext COMMENT '商业险',
  `car_settle_other_pdf` tinytext COMMENT '其他资料',
  `car_regcerti` tinytext COMMENT '登记证书',
  `car_pd` tinytext COMMENT '车辆批单',
  `car_key` tinytext COMMENT '车钥匙',
  `car_big_smj` tinytext COMMENT '大本扫描件',
  `bank_commit_datetime` datetime DEFAULT NULL COMMENT '银行提交时间',
  `bank_commit_note` tinytext COMMENT '银行提交说明',
  `bank_fk_datetime` datetime DEFAULT NULL COMMENT '银行放款时间',
  `repay_bank_code` varchar(32) DEFAULT NULL COMMENT '还款卡银行编号',
  `repay_bank_name` tinytext COMMENT '还款卡银行名称',
  `repay_subbranch` tinytext COMMENT '还款卡开户支行',
  `repay_bankcard_number` tinytext COMMENT '还款卡银行卡号',
  `repay_bill_date` int(11) DEFAULT NULL COMMENT '银行账单日',
  `repay_bank_date` int(11) DEFAULT NULL COMMENT '银行还款日',
  `repay_company_date` int(11) DEFAULT NULL COMMENT '公司还款日',
  `repay_first_month_amount` bigint(20) DEFAULT NULL COMMENT '首期月供金额',
  `repay_first_month_datetime` datetime DEFAULT NULL COMMENT '首期还款日期',
  `repay_month_amount` bigint(20) DEFAULT NULL COMMENT '每期月供金额',
  `receipt_bank_code` tinytext COMMENT '收款银行编号',
  `receipt_bank_name` tinytext COMMENT '收款银行名称',
  `receipt_bankcard_number` tinytext COMMENT '收款银行卡号',
  `receipt_pdf` tinytext COMMENT '收款凭证',
  `receipt_remark` tinytext COMMENT '收款备注',
  `pledge_datetime` datetime DEFAULT NULL COMMENT '抵押日期',
  `green_big_smj` tinytext COMMENT '绿大本扫描件',
  `pledge_bank_commit_datetime` datetime DEFAULT NULL COMMENT '抵押提交银行时间',
  `pledge_bank_commit_note` tinytext COMMENT '抵押提交说明',
  `enter_location` tinytext COMMENT '入档位置',
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `back_advance_status` char(1) DEFAULT NULL COMMENT '退客户垫资款状态（0无需退款 1银行已放款待财务退款 2财务已退垫资款）',
  `back_advance_amount` bigint(20) DEFAULT NULL COMMENT '退客户垫资款 退款金额',
  `back_advance_account` varchar(32) DEFAULT NULL COMMENT '退客户垫资款 收款账号',
  `back_advance_open_bank` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 开户行',
  `back_advance_subbranch` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 开户支行',
  `back_advance_water_bill` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 水单',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
  `cancel_node_code` varchar(32) DEFAULT NULL COMMENT '客户申请作废时的节点编号',
  `frozen_status` char(1) DEFAULT NULL COMMENT '冻结状态 （0冻结 1正常）',
  `remark` tinytext COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='准入单';
