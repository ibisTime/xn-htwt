ALTER TABLE `tdq_budget_order` 
CHANGE COLUMN `work_datetime` `work_datetime` tinytext NULL DEFAULT NULL COMMENT '何时进入现单位工作' ,

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

ALTER TABLE `tdq_credit` 
ADD COLUMN `note` VARCHAR(255) NULL COMMENT '征信说明' AFTER `cur_node_code`;
ADD COLUMN `user_name` VARCHAR(255) DEFAULT NULL COMMENT '客户姓名' AFTER `sale_user_id`,
ADD COLUMN `mobile` VARCHAR(32) DEFAULT NULL COMMENT '手机号' AFTER `user_name`,
ADD COLUMN `id_no` VARCHAR(32) DEFAULT NULL COMMENT '身份证号' AFTER `mobile`,
ADD COLUMN `operator` varchar(255) DEFAULT NULL COMMENT '操作人(录入征信结果的驻行人员)' AFTER `note`;

update tdq_credit tc,tdq_credit_user tcu
set tc.user_name=tcu.user_name,
tc.mobile=tcu.mobile,
tc.id_no =tcu.id_no
where tc.code =tcu.credit_code and tcu.loan_role='1'

ALTER TABLE `tdq_budget_order` 
CHANGE COLUMN `bank_photo` `bank_photo` text NULL DEFAULT NULL COMMENT '银行面签照片' ;
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','node_type','010','调查报告','admin','2018-06-11 23:42:18',NULL,'CD-HTWT000020','CD-HTWT000020');
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('002_24','区域经理审核','002',NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('002','002_01','002_24',NULL,NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('002','002_24','002_02','002_04',NULL,NULL);

insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807061110269813332','调查报告','1','/loanstools/investigateReport.htm','0','U201806060409046595411','2018-07-06 15:06:04','贷前工具','SM201805291053375683183');
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807061110459494752','申请','2','/apply','1','U201806060409046595411','2018-07-06 11:12:33','调查报告','SM201807061110269813332');
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807061111121668399','风控专员审核','2','/checkCommissioner','2','U201806060409046595411','2018-07-06 11:12:28','调查报告','SM201807061110269813332');
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807061112014755232','驻行人员审核','2','/checkStationed','3','U201806060409046595411','2018-07-06 11:12:23','调查报告','SM201807061110269813332');
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807061144057545778','详情','2','/detail','4','U201806060409046595411','2018-07-06 11:44:05','','SM201807061110269813332');
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807061518231844745','资料补录','2','/record','5','U201806061344020605969','2018-07-06 15:18:44','银行放款','SM201805291023424289358');

insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001', 'SM201807061110269813332', 'U201806061344020605969', '2018-07-06 16:23:45', NULL);
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001', 'SM201807061110459494752', 'U201806061344020605969', '2018-07-06 16:23:45', NULL);
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001', 'SM201807061111121668399', 'U201806061344020605969', '2018-07-06 16:23:46', NULL);
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001', 'SM201807061112014755232', 'U201806061344020605969', '2018-07-06 16:23:46', NULL);
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001', 'SM201807061144057545778', 'U201806061344020605969', '2018-07-06 16:23:46', NULL);
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001', 'SM201807061518231844745', 'U201806061344020605969', '2018-07-06 16:23:47', NULL);

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

insert into `tdq_investigate_report` (`code`, `budget_order_code`, `repay_biz_code`, `company_code`, `biz_type`, `apply_user_name`, `apply_datetime`, `loan_bank`, `loan_amount`, `loan_period`, `is_advance_fund`, `sale_user_id`, `jour_datetime_start`, `jour_datetime_end`, `jour_income`, `jour_expend`, `jour_balance`, `jour_month_income`, `jour_month_expend`, `jour_remark`, `zfb_jour_datetime_start`, `zfb_jour_datetime_end`, `zfb_jour_income`, `zfb_jour_expend`, `zfb_jour_balance`, `zfb_jour_month_income`, `zfb_jour_month_expend`, `zfb_jour_remark`, `wx_jour_datetime_start`, `wx_jour_datetime_end`, `wx_jour_income`, `wx_jour_expend`, `wx_jour_balance`, `wx_jour_month_income`, `wx_jour_month_expend`, `wx_jour_remark`, `house_contract`, `house_picture`, `cur_node_code`) 
select `code`,`code`,`repay_biz_code`,`company_code`,`biz_type`,`apply_user_name`,`apply_datetime`,`loan_bank`, `loan_amount`, `loan_period`, `is_advance_fund`, `sale_user_id`, `jour_datetime_start`, `jour_datetime_end`, `jour_income`, `jour_expend`, `jour_balance`, `jour_month_income`, `jour_month_expend`, `jour_remark`, `zfb_jour_datetime_start`, `zfb_jour_datetime_end`, `zfb_jour_income`, `zfb_jour_expend`, `zfb_jour_balance`, `zfb_jour_month_income`, `zfb_jour_month_expend`, `zfb_jour_remark`, `wx_jour_datetime_start`, `wx_jour_datetime_end`, `wx_jour_income`, `wx_jour_expend`, `wx_jour_balance`, `wx_jour_month_income`, `wx_jour_month_expend`, `wx_jour_remark`, `house_contract`, `house_picture`, `cur_node_code` from `tdq_budget_order` where cur_node_code >'002_04';

SET 
  SQL_SAFE_UPDATES = 0; 
UPDATE 
  tdq_investigate_report tr, 
  tdq_budget_order tbo 
SET 
  tr.`customer_information` = CONCAT(
    '借款人:', tbo.apply_user_name, 
    ', ', age, '岁, ', CASE WHEN marry_state = '4' THEN '丧偶' WHEN marry_state = '1' THEN '未婚' WHEN marry_state = '2' THEN '已婚' WHEN marry_state = '3' THEN '离异' END, 
    ', ', '性别：', CASE WHEN gender = '1' THEN '男' WHEN gender = '0' THEN '女' END, 
    ', ', '学历：', CASE WHEN education = '0' THEN '高中及以下' WHEN education = '1' THEN '博士及以上' WHEN education = '2' THEN '硕士' WHEN education = '3' THEN '大学本科' WHEN education = '4' THEN '大学专科' END, 
    ', ', '民族：', tbo.nation, ', ', 
    '身份证号：', tbo.id_no, ', ', 
    '政治面貌：', tbo.political, 
    ', ', '户口所在地：', tbo.residence_address, 
    ', ', '现在家庭住址：', tbo.now_address, 
    ', ', '联系电话：', tbo.mobile, 
    '口人，', '邮编：', tbo.post_code1, 
    ',', '借款人无重大疾病，身体健康'
  ) 
WHERE 
  tr.budget_order_code = tbo.code;


SET 
  SQL_SAFE_UPDATES = 0; 
UPDATE 
  tdq_investigate_report tr, 
  tdq_budget_order tbo 
SET 
  tr.`basics_information` = CONCAT(
    '品牌：', tbo.car_brand, ', ', 
    '车型：', tbo.car_model, ', ', 
    '新手指导价', tbo.original_price, 
    ', ', '落户地点：', tbo.settle_address, 
    ', '
  ) 
WHERE 
  tr.budget_order_code = tbo.code;
  

update tdq_investigate_report set cur_node_code='010_01';




ALTER TABLE `tdq_budget_order` 
CHANGE COLUMN `bank_video` `bank_video` TEXT NULL DEFAULT NULL COMMENT '银行视频' ,
CHANGE COLUMN `bank_photo` `bank_photo` TEXT NULL DEFAULT NULL COMMENT '银行面签照片' ,
CHANGE COLUMN `company_video` `company_video` TEXT NULL DEFAULT NULL COMMENT '公司视频' ,
CHANGE COLUMN `company_contract` `company_contract` TEXT NULL DEFAULT NULL COMMENT '公司合同' ,
CHANGE COLUMN `bank_contract` `bank_contract` TEXT NULL DEFAULT NULL COMMENT '银行合同' ,
CHANGE COLUMN `other_video` `other_video` TEXT NULL DEFAULT NULL COMMENT '其他视频' ,
CHANGE COLUMN `interview_other_pdf` `interview_other_pdf` TEXT NULL DEFAULT NULL COMMENT '面签其他资料' ;

