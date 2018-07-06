ALTER TABLE `tdq_budget_order` 
ADD COLUMN `bank_photo` tinytext DEFAULT NULL COMMENT '银行面签照片' AFTER `bank_video`,
DROP COLUMN `interview_contract`,
ADD COLUMN `company_contract` tinytext DEFAULT NULL COMMENT '公司合同' AFTER `bank_photo`,
ADD COLUMN `bank_contract` tinytext DEFAULT NULL COMMENT '银行合同' AFTER `company_contract`,
ADD COLUMN `other_video` tinytext DEFAULT NULL COMMENT '其他视频' AFTER `bank_contract`,
ADD COLUMN `interview_other_pdf` tinytext DEFAULT NULL COMMENT '面签其他资料' AFTER `other_video`,
DROP COLUMN `advance_fund_other_pdf`,
CHANGE COLUMN `work_datetime` `work_datetime` tinytext NULL DEFAULT NULL COMMENT '何时进入现单位工作' ,
CHANGE COLUMN `team_fee` `fee` bigint(20) NULL DEFAULT NULL COMMENT '服务费' ,
ADD COLUMN `mate_zfb_interest1` bigint(20) DEFAULT NULL COMMENT '配偶支付宝结息1' AFTER `mate_zfb_jour_interest`,
ADD COLUMN `mate_zfb_interest2` bigint(20) DEFAULT NULL COMMENT '配偶支付宝结息2' AFTER `mate_zfb_interest1`,
ADD COLUMN `mate_wx_interest1` bigint(20) DEFAULT NULL COMMENT '配偶微信结息1' AFTER `mate_wx_jour_interest`,
ADD COLUMN `mate_wx_interest2` bigint(20) DEFAULT NULL COMMENT '配偶微信结息2' AFTER `mate_wx_interest1`,
ADD COLUMN `mate_interest1` bigint(20) DEFAULT NULL COMMENT '配偶结息1' AFTER `mate_jour_interest`,
ADD COLUMN `mate_interest2` bigint(20) DEFAULT NULL COMMENT '配偶结息2' AFTER `mate_interest1`,
ADD COLUMN `gua_zfb_interest1` bigint(20) DEFAULT NULL COMMENT '担保人支付宝结息1' AFTER `gua_zfb_jour_interest`,
ADD COLUMN `gua_zfb_interest2` bigint(20) DEFAULT NULL COMMENT '担保人支付宝结息2' AFTER `gua_zfb_interest1`,
ADD COLUMN `gua_wx_interest1` bigint(20) DEFAULT NULL COMMENT '担保人微信结息1' AFTER `gua_wx_jour_interest`,
ADD COLUMN `gua_wx_interest2` bigint(20) DEFAULT NULL COMMENT '担保人微信结息2' AFTER `gua_wx_interest1`,
ADD COLUMN `gua_interest1` bigint(20) DEFAULT NULL COMMENT '担保人结息1' AFTER `gua_jour_interest`,
ADD COLUMN `gua_interest2` bigint(20) DEFAULT NULL COMMENT '担保人结息2' AFTER `gua_interest1`,
ADD COLUMN `zfb_interest1` bigint(20) DEFAULT NULL COMMENT '支付宝结息1' AFTER `zfb_jour_interest`,
ADD COLUMN `zfb_interest2` bigint(20) DEFAULT NULL COMMENT '支付宝结息2' AFTER `zfb_interest1`,
ADD COLUMN `wx_interest1` bigint(20) DEFAULT NULL COMMENT '微信结息1' AFTER `wx_jour_interest`,
ADD COLUMN `wx_interest2` bigint(20) DEFAULT NULL COMMENT '微信结息2' AFTER `wx_interest1`,
ADD COLUMN `interest1` bigint(20) DEFAULT NULL COMMENT '结息1' AFTER `jour_interest`,
ADD COLUMN `interest2` bigint(20) DEFAULT NULL COMMENT '结息2' AFTER `interest1`;

ALTER TABLE `dev_xn_htwt`.`tdq_credit` 
ADD COLUMN `note` VARCHAR(255) NULL COMMENT '征信说明' AFTER `cur_node_code`;



/*
-- Query: SELECT code,name,type,url,order_no,'admin' updater, now() as update_datetime,remark,parent_code FROM tsys_menu where code ='SM201807041817130182597'
-- Date: 2018-07-05 00:50
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201807041817130182597','区域经理审核','2','/regionalManager','12','admin','2018-07-04 16:51:06','准入审查','SM201805291013406492370');

INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807041817130182597','U201806200828281617971',now(),NULL);

INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('010_01','提交调查申请','010',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('010_02','风控专员审核','010',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('010_03','驻行人员审核','010',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('010_04','已完成','010',NULL);

INSERT INTO `tsys_node_flow` (`type`,`current_node`,`next_node`,`back_node`,`file_list`,`remark`) VALUES ('010','010_01','010_02',NULL,NULL,NULL);
INSERT INTO `tsys_node_flow` (`type`,`current_node`,`next_node`,`back_node`,`file_list`,`remark`) VALUES ('010','010_02','010_03','010_01',NULL,NULL);
INSERT INTO `tsys_node_flow` (`type`,`current_node`,`next_node`,`back_node`,`file_list`,`remark`) VALUES ('010','010_03','010_04','010_02',NULL,NULL);

DROP TABLE IF EXISTS `tdq_investigate_report`;
CREATE TABLE `tdq_investigate_report` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `budget_order_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `company_code` tinytext DEFAULT NULL COMMENT '业务公司',
  `biz_type` varchar(4) DEFAULT NULL COMMENT '业务种类',
  `apply_user_name` tinytext DEFAULT NULL COMMENT '客户姓名',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `loan_bank` tinytext DEFAULT NULL COMMENT '贷款银行',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `loan_period` tinytext DEFAULT NULL COMMENT '贷款期数',
  `is_advance_fund` varchar(4) DEFAULT NULL COMMENT '是否垫资',
  `sale_user_id` tinytext DEFAULT NULL COMMENT '业务员',
  `gua_mode` tinytext DEFAULT NULL COMMENT '担保方式',
  `customer_information` text DEFAULT NULL COMMENT '客户基本情况',
  `bank_credit_result_pdf` tinytext DEFAULT NULL COMMENT '申请人征信情况',
  `price_approval_pdf` tinytext DEFAULT NULL COMMENT '申请人贷款车辆价格核准情况',
  `car_168_price` bigint(20) DEFAULT NULL COMMENT '车行168车价',
  `apply_work_and_jour` tinytext DEFAULT NULL COMMENT '申请人工作情况及流水反映',
  `jour_datetime_start` datetime DEFAULT NULL COMMENT '流水时间起',
  `jour_datetime_end` datetime DEFAULT NULL COMMENT '流水时间止',
  `jour_income` bigint(20) DEFAULT NULL COMMENT '收入',
  `jour_expend` bigint(20) DEFAULT NULL COMMENT '支出',
  `jour_balance` bigint(20) DEFAULT NULL COMMENT '帐户余额',
  `jour_month_income` bigint(20) DEFAULT NULL COMMENT '月均收入',
  `jour_month_expend` bigint(20) DEFAULT NULL COMMENT '月均支出',
  `jour_remark` tinytext DEFAULT NULL COMMENT '银行流水情况',
  `zfb_jour_datetime_start` datetime DEFAULT NULL COMMENT '支付宝流水时间起',
  `zfb_jour_datetime_end` datetime DEFAULT NULL COMMENT '支付宝流水时间止',
  `zfb_jour_income` bigint(20) DEFAULT NULL COMMENT '支付宝收入',
  `zfb_jour_expend` bigint(20) DEFAULT NULL COMMENT '支付宝支出',
  `zfb_jour_balance` bigint(20) DEFAULT NULL COMMENT '支付宝帐户余额',
  `zfb_jour_month_income` bigint(20) DEFAULT NULL COMMENT '支付宝月均收入',
  `zfb_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '支付宝月均支出',
  `zfb_jour_remark` tinytext DEFAULT NULL COMMENT '支付宝流水情况',
  `wx_jour_datetime_start` datetime DEFAULT NULL COMMENT '微信流水时间起',
  `wx_jour_datetime_end` datetime DEFAULT NULL COMMENT '微信流水时间止',
  `wx_jour_income` bigint(20) DEFAULT NULL COMMENT '微信收入',
  `wx_jour_expend` bigint(20) DEFAULT NULL COMMENT '微信支出',
  `wx_jour_balance` bigint(20) DEFAULT NULL COMMENT '微信帐户余额',
  `wx_jour_month_income` bigint(20) DEFAULT NULL COMMENT '微信月均收入',
  `wx_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '微信月均支出',
  `wx_jour_remark` tinytext DEFAULT NULL COMMENT '微信流水情况',
  `house_contract` tinytext DEFAULT NULL COMMENT '房产情况及家访',
  `home_visit` tinytext DEFAULT NULL COMMENT '家访地址',
  `house_picture` tinytext DEFAULT NULL COMMENT '家访照片',
  `basics_information` text DEFAULT NULL COMMENT '车辆基础信息',
  `xsz_pdf` tinytext DEFAULT NULL COMMENT '行驶证主副页',
  `xsz_car_pdf` tinytext DEFAULT NULL COMMENT '行驶证车辆照片页',
  `frame_no` tinytext DEFAULT NULL COMMENT '车架号',
  `nameplate` tinytext DEFAULT NULL COMMENT '车辆铭牌',
  `forward_pdf` tinytext DEFAULT NULL COMMENT '车辆照片正前',
  `queen_pdf` tinytext DEFAULT NULL COMMENT '车辆照片正后',
  `left_pdf` tinytext DEFAULT NULL COMMENT '车辆照片正左',
  `right_pdf` tinytext DEFAULT NULL COMMENT '车辆照片正右',
  `lf45_pdf` tinytext DEFAULT NULL COMMENT '车辆照片左前45º',
  `rf45_pdf` tinytext DEFAULT NULL COMMENT '车辆照片右前45º',
  `lg45_pdf` tinytext DEFAULT NULL COMMENT '车辆照片左后45º',
  `rr45_pdf` tinytext DEFAULT NULL COMMENT '车辆照片右后45º',
  `engine_pdf` tinytext DEFAULT NULL COMMENT '车辆照片发动机仓',
  `szm_pdf` tinytext DEFAULT NULL COMMENT '车辆中控台照片',
  `gears_pdf` tinytext DEFAULT NULL COMMENT '车辆档位照片',
  `functional_zone_pdf` tinytext DEFAULT NULL COMMENT '车辆功能区里照片',
  `odometer_pdf` tinytext DEFAULT NULL COMMENT '车辆里程表照片',
  `front_row_pdf` tinytext DEFAULT NULL COMMENT '车辆前排内饰照片',
  `rock_row_pdf` tinytext DEFAULT NULL COMMENT '车辆中排内饰照片',
  `trunk_pdf` tinytext DEFAULT NULL COMMENT '车辆后备箱照片',
  `louver_pdf` tinytext DEFAULT NULL COMMENT '车辆天窗照片',
  `bank_row_pdf` tinytext DEFAULT NULL COMMENT '车辆后排娱乐系统照片',
  `check_approve_pdf` tinytext DEFAULT NULL COMMENT '车辆核准截图',
  `check_approve_link` tinytext DEFAULT NULL COMMENT '核准链接',
  `third_valuation_pdf` tinytext DEFAULT NULL COMMENT '第三方评估价截图',
  `check_approve_software` tinytext DEFAULT NULL COMMENT '核准软件',
  `used_car_current_rate` tinytext DEFAULT NULL COMMENT '二手车市场成交价最低及最高截图',
  `information_source` tinytext DEFAULT NULL COMMENT '信息源',
  `valuation` bigint(20) DEFAULT NULL COMMENT '评估价',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点编号',
  `updater` tinytext DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` tinytext DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调查报告';


