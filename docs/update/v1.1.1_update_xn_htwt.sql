ALTER TABLE `tdq_budget_order_fee_detail` 
ADD COLUMN `status` VARCHAR(32) NULL COMMENT '状态' AFTER `reach_datetime`;

update tdq_budget_order_fee_detail set status ='1';

ALTER TABLE `tdq_credit` 
ADD COLUMN `team_code` VARCHAR(32) NULL COMMENT '团队编号' AFTER `sale_user_id`;

ALTER TABLE `tdq_loan_product` 
CHANGE COLUMN `loan_bank` `loan_bank` VARCHAR(255) NULL DEFAULT NULL COMMENT '贷款银行' AFTER `back_rate`,
ADD COLUMN `is_pre` CHAR(1) NULL COMMENT '是否前置' AFTER `loan_bank`;

update tdq_credit tc,tsys_user tu set tc.team_code=tu.team_code where tc.sale_user_id=tu.user_id;

ALTER TABLE `tsys_department` 
DROP COLUMN `mobile`,
CHANGE COLUMN `type` `type` VARCHAR(32) NULL DEFAULT NULL COMMENT '类型(1=子公司，2=部门，3=岗位)' AFTER `code`,
CHANGE COLUMN `lead_name` `lead_user_id` VARCHAR(32) NULL DEFAULT NULL COMMENT '负责人编号' ,
ADD COLUMN `order_no` INT(11) NULL COMMENT '序号' AFTER `parent_code`;

update tsys_department td,tsys_user tu set td.lead_user_id=tu.user_id;

ALTER TABLE `tsys_user` 
ADD COLUMN `archive_code` VARCHAR(32) NULL COMMENT '人事档案编号' AFTER `team_code`;

update tsys_user tu,tp_archive tpa set tu.archive_code =tpa.code where tu.real_name= tpa.real_name;

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `region` tinytext DEFAULT NULL COMMENT '所属区域' AFTER `loan_product_name`,
ADD COLUMN `team_fee` bigint(20) DEFAULT NULL COMMENT '团队服务费' AFTER `company_fee`,
ADD COLUMN `car_type` tinytext DEFAULT NULL COMMENT '车辆类型' AFTER `car_model`,
DROP COLUMN `car_hgz_no`,
ADD COLUMN `age` INT(11) DEFAULT NULL COMMENT '年龄' AFTER `gender`,
ADD COLUMN `political` tinytext DEFAULT NULL COMMENT '政治面貌' AFTER `marry_state`,
ADD COLUMN `is_card_mail_address` varchar(255) DEFAULT NULL COMMENT '是否卡邮寄地址' AFTER `now_address`,
ADD COLUMN `work_is_card_mail_address` tinytext DEFAULT NULL COMMENT '是否卡邮寄地址' AFTER `work_company_address`,
ADD COLUMN `other_work_note` tinytext DEFAULT NULL COMMENT '其他工作描述' AFTER `self_company_area`,
ADD COLUMN `work_asset_pdf` tinytext DEFAULT NULL COMMENT '工作资料上传' AFTER `other_work_note`,
ADD COLUMN `mate_zfb_jour_interest` tinytext DEFAULT NULL COMMENT '配偶支付宝流水结息' AFTER `mate_zfb_jour_datetime_end`,
ADD COLUMN `mate_wx_jour_interest` tinytext DEFAULT NULL COMMENT '配偶微信流水结息' AFTER `mate_wx_jour_datetime_end`,
ADD COLUMN `mate_jour_interest` tinytext DEFAULT NULL COMMENT '配偶流水结息' AFTER `mate_jour_datetime_end`,
ADD COLUMN `gua_zfb_jour_interest` tinytext DEFAULT NULL COMMENT '担保人支付宝流水结息' AFTER `gua_zfb_jour_datetime_end`,
ADD COLUMN `gua_wx_jour_interest` tinytext DEFAULT NULL COMMENT '担保人微信流水结息' AFTER `gua_wx_jour_datetime_end`,
ADD COLUMN `gua_jour_interest` tinytext DEFAULT NULL COMMENT '担保人流水结息' AFTER `gua_jour_datetime_end`,
ADD COLUMN `zfb_jour_interest` tinytext DEFAULT NULL COMMENT '支付宝流水结息' AFTER `zfb_jour_datetime_end`,
ADD COLUMN `wx_jour_interest` tinytext DEFAULT NULL COMMENT '微信流水结息' AFTER `wx_jour_datetime_end`,
ADD COLUMN `jour_interest` tinytext DEFAULT NULL COMMENT '流水结息' AFTER `jour_datetime_end`,
ADD COLUMN `hk_book_pdf` tinytext DEFAULT NULL COMMENT '户口本资料' AFTER `house_picture`,
ADD COLUMN `id_card_pdf` tinytext DEFAULT NULL COMMENT '身份证资料' AFTER `hk_book_pdf`,
ADD COLUMN `marry_pdf` tinytext DEFAULT NULL COMMENT '结婚证资料' AFTER `id_card_pdf`,
ADD COLUMN `other_pdf` tinytext DEFAULT NULL COMMENT '其他资料' AFTER `marry_pdf`,
DROP COLUMN `interview_video`,
ADD COLUMN `bank_video` tinytext DEFAULT NULL COMMENT '银行视频' AFTER `is_advance_fund`,
ADD COLUMN `company_video` tinytext DEFAULT NULL COMMENT '公司视频' AFTER `bank_video`,
ADD COLUMN `advance_fund_amount_pdf` tinytext DEFAULT NULL COMMENT '资金划转授权书' AFTER `bill_pdf`,
ADD COLUMN `advance_fund_other_pdf` tinytext DEFAULT NULL COMMENT '垫资其他资料' AFTER `advance_fund_amount_pdf`,
DROP COLUMN `car_hgz`,
ADD COLUMN `car_settle_other_pdf` tinytext DEFAULT NULL COMMENT '其他资料' AFTER `car_syx`;

update tdq_budget_order set employee_quantity=NULL where employee_quantity='';

update tdq_budget_order set family_number=NULL where family_number='';

ALTER TABLE `tdq_budget_order` 
CHANGE COLUMN `employee_quantity` `employee_quantity` INT(11) NULL DEFAULT NULL COMMENT '员工数量' ;

ALTER TABLE `tdq_budget_order` 
CHANGE COLUMN `family_number` `family_number` INT(11) NULL DEFAULT NULL COMMENT '家庭人口' ;

ALTER TABLE `tsys_biz_team` 
ADD COLUMN `region` VARCHAR(255) NULL AFTER `water_bill`,
ADD COLUMN `place` VARCHAR(255) NULL AFTER `region`;

ALTER TABLE `tdq_logistics`
ADD COLUMN `team_code` VARCHAR(32) NULL COMMENT '团队编号' AFTER `user_id`,
ADD COLUMN `receiver` VARCHAR(32) NULL COMMENT '收件人(gps 落地具体某个人/ 非gps默认0)' AFTER `receipt_datetime`;

ALTER TABLE `tdq_loan_product`
ADD COLUMN `is_pre` VARCHAR(32) NULL COMMENT '是否前置' AFTER `back_rate`,

CREATE TABLE `tp_business_trip_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user_code` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `job_no` varchar(32) DEFAULT NULL COMMENT '工号',
  `department_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `post_code` varchar(32) DEFAULT NULL COMMENT '职位编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `trip_datetime_start` datetime DEFAULT NULL COMMENT '出差时间起',
  `trip_datetime_end` datetime DEFAULT NULL COMMENT '出差时间止',
  `trip_reason` varchar(255) DEFAULT NULL COMMENT '出差事由',
  `trip_line` varchar(255) DEFAULT NULL COMMENT '出差线路',
  `aircraft_fee_standard` varchar(255) DEFAULT NULL COMMENT '飞机票费用标准',
  `aircraft_days` varchar(255) DEFAULT NULL COMMENT '飞机票天数',
  `aircraft_budget` bigint(20) DEFAULT NULL COMMENT '飞机票预算金额',
  `train_fee_standard` varchar(255) DEFAULT NULL COMMENT '火车票费用标准',
  `train_days` varchar(255) DEFAULT NULL COMMENT '火车票天数',
  `train_budget` bigint(20) DEFAULT NULL COMMENT '火车票预算金额',
  `urban_fee_standart` varchar(255) DEFAULT NULL COMMENT '市内交通费用标准',
  `urban_days` varchar(255) DEFAULT NULL COMMENT '市内交通天数',
  `urban_budget` bigint(20) DEFAULT NULL COMMENT '市内交通预算金额',
  `hotel_cost` bigint(20) DEFAULT NULL COMMENT '住宿费',
  `food_subsidy` bigint(20) DEFAULT NULL COMMENT '伙食补助',
  `entertainment_cost` bigint(20) DEFAULT NULL COMMENT '招待费',
  `other` varchar(255) DEFAULT NULL COMMENT '其他',
  `subtotal` bigint(20) DEFAULT NULL COMMENT '小计',
  `spare_cash` bigint(20) DEFAULT NULL COMMENT '备用金',
  `cost_total` bigint(20) DEFAULT NULL COMMENT '费用合计',
  `department_manager_code` varchar(32) DEFAULT NULL COMMENT '部门主管编号',
  `finance_manager_code` varchar(32) DEFAULT NULL COMMENT '财务主管编号',
  `general_manager_code` varchar(32) DEFAULT NULL COMMENT '总经理编号',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出差申请';

CREATE TABLE `tp_bus` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `model` varchar(32) DEFAULT NULL COMMENT '车辆型号',
  `number` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `insurance_end_datetime` datetime DEFAULT NULL COMMENT '保险到期日',
  `park_location` varchar(255) DEFAULT NULL COMMENT '停放位置',
  `pic` varchar(255) DEFAULT NULL COMMENT '车辆照片',
  `status` varchar(4) DEFAULT NULL COMMENT '领用状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公车';

CREATE TABLE `tp_bus_borrow` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `bus_code` varchar(32) DEFAULT NULL COMMENT '公车编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申领人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '领用说明',
  `department_code` varchar(32) DEFAULT NULL COMMENT '所属部门',
  `use_datetime_start` datetime DEFAULT NULL COMMENT '使用时间起',
  `use_datetime_end` datetime DEFAULT NULL COMMENT '使用时间止',
  `drive_kil` double DEFAULT NULL COMMENT '行驶公里数',
  `return_datetime` datetime DEFAULT NULL COMMENT '归还时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公车借用';

/*
-- Query: SELECT `code`,`name`,`type`,`remark` FROM tsys_node where type='009'
-- Date: 2018-06-23 22:44
*/
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_01','申请出差','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_02','部门主管审核','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_03','财务主管审核','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_04','总经理审核','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_05','审核通过','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_06','审核不通过','009',NULL);

/*
-- Query: SELECT `type`,`current_node`,`next_node`,`back_node`,`file_list`,`remark` FROM tsys_node_flow where type='009'
-- Date: 2018-06-23 22:45
*/
INSERT INTO `tsys_node_flow` (`type`,`current_node`,`next_node`,`back_node`,`file_list`,`remark`) VALUES ('009','009_01','009_02',NULL,NULL,NULL);
INSERT INTO `tsys_node_flow` (`type`,`current_node`,`next_node`,`back_node`,`file_list`,`remark`) VALUES ('009','009_02','009_03','009_06',NULL,NULL);
INSERT INTO `tsys_node_flow` (`type`,`current_node`,`next_node`,`back_node`,`file_list`,`remark`) VALUES ('009','009_03','009_04','009_06',NULL,NULL);
INSERT INTO `tsys_node_flow` (`type`,`current_node`,`next_node`,`back_node`,`file_list`,`remark`) VALUES ('009','009_04','009_05','009_06',NULL,NULL);
INSERT INTO `tsys_node_flow` (`type`,`current_node`,`next_node`,`back_node`,`file_list`,`remark`) VALUES ('009','009_06','009_02',NULL,NULL,NULL);

/*
-- Query: SELECT code,name,type,url,order_no,'admin' updater, now() as update_datetime,remark,parent_code FROM tsys_menu where code ='SM201806231528252838941' or code in 
(SELECT code  FROM tsys_menu where parent_code ='SM201806231528252838941')
or code in 
(SELECT code  FROM tsys_menu where parent_code in (SELECT code  FROM tsys_menu where parent_code ='SM201806231528252838941'))
-- Date: 2018-06-23 22:50
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231528252838941','公车管理','1','#','4','admin',now(),'','SM201806070023189526060');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231529001154395','公车管理','1','/bus/busmanager.htm','1','admin',now(),'公车管理','SM201806231528252838941');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231529246294977','公车申请使用','1','/bus/busapply.htm','2','admin',now(),'公车管理','SM201806231528252838941');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231529439354133','公车归还','1','/bus/busreturn.htm','3','admin',now(),'公车管理','SM201806231528252838941');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231534000522907','新增','2','/add','1','admin',now(),'公车管理','SM201806231529001154395');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231534198743900','修改','2','/edit','2','admin',now(),'公车管理','SM201806231529001154395');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231534437157702','删除','2','/delete','3','admin',now(),'公车管理','SM201806231529001154395');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231535122236082','领用历史','2','/check','4','admin',now(),'公车管理','SM201806231529001154395');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231535263694605','详情','2','/detail','5','admin',now(),'公车管理','SM201806231529001154395');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231537062847842','申请','2','/apply','1','admin',now(),'公车申请使用','SM201806231529246294977');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231537162096124','审核','2','/check','2','admin',now(),'公车申请使用','SM201806231529246294977');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231537280401251','详情','2','/detail','3','admin',now(),'公车申请使用','SM201806231529246294977');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231539201248617','归还','2','/return','1','admin',now(),'公车归还','SM201806231529439354133');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231540188028655','审核','2','/check','2','admin',now(),'公车归还','SM201806231529439354133');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231540385099307','详情','2','/detail','3','admin',now(),'公车归还','SM201806231529439354133');

/*
-- Query: SELECT 'RO201800000000000001' role_code,code as menu_code ,'admin' updater, now() as update_datetime,'' remark FROM tsys_menu where code ='SM201806231528252838941' or code in 
(SELECT code  FROM tsys_menu where parent_code ='SM201806231528252838941')
or code in 
(SELECT code  FROM tsys_menu where parent_code in (SELECT code  FROM tsys_menu where parent_code ='SM201806231528252838941'))
-- Date: 2018-06-23 22:55
*/
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231528252838941','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231529001154395','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231529246294977','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231529439354133','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231534000522907','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231534198743900','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231534437157702','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231535122236082','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231535263694605','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231537062847842','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231537162096124','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231537280401251','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231539201248617','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231540188028655','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231540385099307','admin',now(),'');

delete from tsys_menu where code in ('SM201806051500108276452','SM201806062003322256748','SM201806062003487726270','SM201806062004128529788','SM201806231911426804498','SM201806231912209182943');
delete from tsys_menu_role where menu_code in ('SM201806051500108276452','SM201806062003322256748','SM201806062003487726270','SM201806062004128529788','SM201806231911426804498','SM201806231912209182943');

/*
-- Query: SELECT code,name,type,url,order_no,'admin' updater, now() as update_datetime,remark,parent_code FROM tsys_menu where code ='SM201806051500108276452' or code in 
(SELECT code  FROM tsys_menu where parent_code ='SM201806051500108276452')
or code in 
(SELECT code  FROM tsys_menu where parent_code in (SELECT code  FROM tsys_menu where parent_code ='SM201806051500108276452'))
-- Date: 2018-06-23 23:45
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806051500108276452','出差申请','1','/attendance/travel.htm','4','admin',now(),'出勤审批','SM201806051423173655598');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806062003322256748','申请','2','/apply','1','admin',now(),'','SM201806051500108276452');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806062003487726270','部门主管审核','2','/departmentCheck','2','admin',now(),'','SM201806051500108276452');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806062004128529788','详情','2','/detail','5','admin',now(),'','SM201806051500108276452');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231911426804498','财务主管审核','2','/financeCheck','3','admin',now(),'出差申请','SM201806051500108276452');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806231912209182943','总经理审核','2','/managerCheck','4','admin',now(),'出差申请','SM201806051500108276452');

/*
-- Query: SELECT 'RO201800000000000001' role_code,code as menu_code ,'admin' updater, now() as update_datetime,'' remark FROM tsys_menu where code ='SM201806051500108276452' or code in 
(SELECT code  FROM tsys_menu where parent_code ='SM201806051500108276452')
or code in 
(SELECT code  FROM tsys_menu where parent_code in (SELECT code  FROM tsys_menu where parent_code ='SM201806051500108276452'))
-- Date: 2018-06-23 23:46
*/
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051500108276452','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806062003322256748','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806062003487726270','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806062004128529788','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231911426804498','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231912209182943','admin',now(),'');

delete from tsys_menu where code in ('SM201805291121432585610','SM201805291122139078139','SM201805310740331801105','SM201805310741598422718','SM201805310742150248924');
delete from tsys_menu_role where menu_code in ('SM201805291121432585610','SM201805291122139078139','SM201805310740331801105','SM201805310741598422718','SM201805310742150248924');

/*
-- Query: SELECT code,name,type,url,order_no,'admin' updater, now() as update_datetime,remark,parent_code FROM tsys_menu where code ='SM201805291121432585610' or code in 
(SELECT code  FROM tsys_menu where parent_code ='SM201805291121432585610')
or code in 
(SELECT code  FROM tsys_menu where parent_code in (SELECT code  FROM tsys_menu where parent_code ='SM201805291121432585610'))
-- Date: 2018-06-24 23:16
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201805291121432585610','资料传递','1','#','6','admin',now(),'','SM201804241904336827315');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201805291122139078139','资料发件','1','/transmit/transmit.htm','1','admin',now(),'','SM201805291121432585610');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201805310740331801105','发件','2','/send','1','admin',now(),'资料传递','SM201805291122139078139');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201805310741598422718','收件并审核','2','/check','2','admin',now(),'资料收件','SM201806242131147945101');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201805310742150248924','详情','2','/detail','3','admin',now(),'资料传递','SM201805291122139078139');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806242131147945101','资料收件','1','/transmit/collection.htm','2','admin',now(),'','SM201805291121432585610');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806242133115035223','详情','2','/detail','2','admin',now(),'','SM201806242131147945101');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806242217285108940','GPS收件','1','/transmit/collectionGPS.htm','3','admin',now(),'资料传递','SM201805291121432585610');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806242218033719916','收件并审核','2','/check','1','admin',now(),'GPS收件','SM201806242217285108940');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806242218130345331','详情','2','/detail','2','admin',now(),'GPS收件','SM201806242217285108940');

/*
-- Query: SELECT 'RO201800000000000001' role_code,code as menu_code ,'admin' updater, now() as update_datetime,'' remark FROM tsys_menu where code ='SM201805291121432585610' or code in 
(SELECT code  FROM tsys_menu where parent_code ='SM201805291121432585610')
or code in 
(SELECT code  FROM tsys_menu where parent_code in (SELECT code  FROM tsys_menu where parent_code ='SM201805291121432585610'))
-- Date: 2018-06-24 23:19
*/
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291121432585610','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291122139078139','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310740331801105','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310741598422718','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310742150248924','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806242131147945101','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806242133115035223','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806242217285108940','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806242218033719916','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806242218130345331','admin',now(),'');

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('repayplan','repayplan_step','50','admin',now(),'还款计划每次处理的条数','CD-CHTWT000020','CD-CHTWT000020');

ALTER TABLE `tdh_repay_plan` 
CHANGE COLUMN `repay_interest` `repay_interest` BIGINT(20) NULL DEFAULT NULL COMMENT '本期利息' ,
ADD COLUMN `repay_amount` BIGINT(20) NULL COMMENT '还款金额' AFTER `repay_interest`;

update tdh_repay_plan set repay_amount = repay_interest+repay_capital;

delete from tsys_menu where code in('SM201806082250402178394','SM201806082258364384563','SM201806082259103138937','SM201806082259536645110','SM201806082300058567560','SM201806082300333927480','SM201806082300569115566','SM201806082301163207610');
/*
-- Query: SELECT code,name,type,url,order_no,'admin' updater, now() as update_datetime,remark,parent_code FROM tsys_menu where code ='SM201806082250402178394' or code in 
(SELECT code  FROM tsys_menu where parent_code ='SM201806082250402178394')
or code in 
(SELECT code  FROM tsys_menu where parent_code in (SELECT code  FROM tsys_menu where parent_code ='SM201806082250402178394'))
-- Date: 2018-06-25 02:48
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806082250402178394','GPS设备管理','1','#','4','admin',now(),'','SM201806070023189526060');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806082258364384563','GPS库存管理','1','/postloantools/manageGps.htm','1','admin',now(),'','SM201806082250402178394');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806082259103138937','GPS申领','1','/postloantools/applyGps.htm','2','admin',now(),'','SM201806082250402178394');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806082259536645110','新增','2','/add','1','admin',now(),'','SM201806082258364384563');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806082300058567560','详情','2','/detail','2','admin',now(),'','SM201806082258364384563');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806082300333927480','申领','2','/apply','1','admin',now(),'','SM201806082259103138937');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806082300569115566','审核','2','/check','2','admin',now(),'','SM201806082259103138937');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806082301163207610','详情','2','/detail','3','admin',now(),'','SM201806082259103138937');

delete from tsys_menu_role where menu_code in('SM201806082250402178394','SM201806082258364384563','SM201806082259103138937','SM201806082259536645110','SM201806082300058567560','SM201806082300333927480','SM201806082300569115566','SM201806082301163207610');
/*
-- Query: SELECT 'RO201800000000000001' role_code,code as menu_code ,'admin' updater, now() as update_datetime,'' remark FROM tsys_menu where code ='SM201806082250402178394' or code in 
(SELECT code  FROM tsys_menu where parent_code ='SM201806082250402178394')
or code in 
(SELECT code  FROM tsys_menu where parent_code in (SELECT code  FROM tsys_menu where parent_code ='SM201806082250402178394'))
-- Date: 2018-06-25 02:49
*/
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082250402178394','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082258364384563','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082259103138937','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082259536645110','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082300058567560','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082300333927480','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082300569115566','admin',now(),'');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082301163207610','admin',now(),'');

delete from tsys_dict;

/*
-- Query: SELECT type,parent_key,dkey,dvalue,updater,now() update_datetime,remark,company_code,system_code FROM dev_xn_htwt.tsys_dict
-- Date: 2018-06-24 23:23
*/
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'kd_company','物流公司','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','EMS','邮政EMS','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','STO','申通快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','ZTO','中通快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','YTO','圆通快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','HTKY','汇通快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','SF','顺丰快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','TTKD','天天快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','ZJS','宅急送','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','BSHT','百世汇通','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','YDKD','韵达快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','DBKD','德邦快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','QFKD','全峰快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','GTKD','国通快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','TDHY','天地华宇','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','JJWL','佳吉物流','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','JJKD','快捷快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','YSKD','优速快递','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','kd_company','QTKD','其他','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'marry_state','婚姻状况','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','marry_state','1','未婚','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','marry_state','2','已婚','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','marry_state','3','离异','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','marry_state','4','丧偶','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'education','学历','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','education','1','博士及以上','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','education','2','硕士','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','education','3','大学本科','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','education','4','大学专科','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'main_income','主要收入来源','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','main_income','1','工资','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','main_income','2','分红','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','main_income','3','销售佣金','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','main_income','4','自营收入','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','main_income','5','租金','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','main_income','6','其他','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'gender','性别','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','gender','1','男','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','gender','2','女','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','NULL','loan_period','贷款期限','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_period','12','一年','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_period','24','两年','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_period','36','三年','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'loan_product_status','贷款商品状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_product_status','1','待上架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_product_status','2','已上架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_product_status','3','已下架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'enter_location','存放位置','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','enter_location','01','保险柜','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'role_level','角色等级','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','role_level','1','运维','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','role_level','2','运营','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','role_level','3','客户','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'status','状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','status','0','待上架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','status','1','已上架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','status','2','已下架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'user_status','用户状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_status','0','正常','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_status','1','程序锁定','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_status','2','人工锁定','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'product_status','商品状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_status','1','待上架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_status','3','已上架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_status','4','已下架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_status','9','已回收','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'product_location','商品位置','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_location','0','普通','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','product_location','1','推荐','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'account_status','账户状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_status','0','正常','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_status','1','程序锁定','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_status','2','人工锁定','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'currency','币种','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','currency','CNY','人民币','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','currency','JF','积分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','currency','XYF','信用分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'account_type','账号类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_type','C','C端用户','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'bankcard','银行卡状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bankcard','0','正常','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bankcard','1','停用','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'channel_type','支付渠道','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','1','宝付代扣','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','0','内部账','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','90','人工线下','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'biz_type','业务类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','biz_type','-30','购物','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','biz_type','30','购物退款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'jour_status','账户状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','1','待对账','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','3','已对账且账已平','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','4','帐不平待调账审批','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','5','已对账且账不平','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','6','无需对账','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'withdraw_status','提款状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','1','待审批','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','2','审批不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','3','审批通过待支付','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','4','支付失败','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','5','支付成功','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'repay_way','执行付款方式','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repay_way','1','已线下收取','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repay_way','2','线上代扣','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'way','催收方式','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','way','0','短信催收','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','way','1','消息推送催收','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'loan_order_status','车贷订单状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_order_status','0','待提交','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_order_status','1','待审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_order_status','2','审核不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','loan_order_status','3','审核通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'repay_biz_status','还款业务状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repay_biz_status','0','还款中','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repay_biz_status','1','正常已还款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repay_biz_status','2','正常结清','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repay_biz_status','3','提前还款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repay_biz_status','4','确认提前结清','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repay_biz_status','5','确认不还','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repay_biz_status','6','确认处理结果','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'pay_type','支付类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','pay_type','1','余额支付','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','pay_type','2','代扣','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'order_status','商品分期订单状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','1','待支付','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','2','分期中','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','3','已支付','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','4','已发货','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','5','已收货','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','6','已评论','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','91','用户异常','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','92','商户异常','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','93','快递异常','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','order_status','94','用户删除','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','NULL','send_type','资料寄送方式','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','send_type','1','线下','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','send_type','2','快递','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','NULL','logistics_type','物流单类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','logistics_type','1','准入单','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','logistics_type','2','GPS','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','NULL','logistics_status','资料传递状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','logistics_status','0','待发件','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','logistics_status','1','已发件待收件','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','logistics_status','2','已收件审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','logistics_status','3','已收件待补件','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','NULL','user_kind','用户类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_kind','C','C端用户','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','NULL','notice_status','公告状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_status','0','未发布','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_status','1','已发布','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_status','2','已下架','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','NULL','gps_apply_type','gps申请单类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','gps_apply_type','1','公司','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','gps_apply_type','2','个人','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','NULL','gps_apply_status','gps申请单状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','gps_apply_status','0','待审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','gps_apply_status','1','审核通过,待发货','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','gps_apply_status','2','审核不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','gps_apply_status','3','已发货','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','gps_apply_status','4','已收货','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'remit_type','交款类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','remit_type','1','客户交款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'credit_user_relation','借款人关系','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','1','贷款人本人','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','2','丈夫','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','3','妻子','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','4','父亲','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','5','母亲','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','6','岳父','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','7','岳母','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','8','朋友','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'credit_user_loan_role','贷款角色','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_loan_role','1','申请人','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_loan_role','2','共同还款人','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_loan_role','3','担保人','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'budget_orde_biz_typer','业务类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','budget_orde_biz_typer','0','新车','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','budget_orde_biz_typer','1','二手车','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'work_company_property','单位经济性质','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_company_property','1','国有经济','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_company_property','2','集体经济','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_company_property','3','私营','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_company_property','4','民营','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_company_property','5','股份合作','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_company_property','6','其他股份制','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_company_property','7','三资','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_company_property','8','其他','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'work_belong_industry','所属行业','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','1','农林牧渔','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','2','邮电通讯','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','3','房地产','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','4','科教文卫','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','5','工业','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','6','银行','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','7','证券','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','8','保险','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','9','商业','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','10','机关团体','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_belong_industry','11','其他','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'work_profession','职业','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','1','业务员','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','2','事业单位员工','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','3','工人','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','4','农民','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','5','军人','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','6','职员','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','7','私人业主','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','8','学生','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','9','自由职业者','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_profession','10','无','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'position','职位','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'notice_type','公告类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_type','1','公司动态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_type','2','公司文件','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_type','3','培训说明','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','position','1','厅局级及以上/企业负责人','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','position','2','县处级/总经理','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','position','3','科级/部门经理','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','position','4','科员级/职员','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','position','5','其他','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'notice_urgent_status','公告紧急类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_urgent_status','1','普通','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_urgent_status','2','紧急','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','9','同事','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','credit_user_relation','10','兄弟姐妹','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'regime_status','公告紧急类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','regime_status','1','行政事务类','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','regime_status','2','人力资源管理类','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','regime_status','3','财务管理类','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','regime_status','4','营销管理类','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','regime_status','5','生产管理类','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'job_classes','上班班次类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','1','办公班次','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','2','设计班次','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','3','版房班次','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','4','展厅班次','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','5','保安班次','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','6','客服班次','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','7','商品部司机','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','8','采购部司机','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','9','行政司机','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','10','设计部文员','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','11','清洁工班次','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','job_classes','12','督导班次','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'politics','政治面貌','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','politics','1','群众','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','politics','2','团员','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','politics','3','预备党员','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','politics','4','党员','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','politics','5','其他','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','','work_status','工作状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_status','1','试用','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_status','2','在职','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_status','3','离职','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_status','4','退休','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'five_insurance_info','五险一金信息','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','five_insurance_info','1','无','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','five_insurance_info','2','五险','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','five_insurance_info','3','工伤','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'residence_property','户籍性质','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','residence_property','1','农业','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','residence_property','2','非农','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','residence_property','3','居民','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','residence_property','4','城镇','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'probation_time','试用期时间','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','probation_time','1','无','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','probation_time','2','三个月','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'contract_type','合同类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','contract_type','1','试用期合同','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','contract_type','2','正式合同','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','contract_type','3','培训合同','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','contract_type','4','劳务合同','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'employ_apply_status','应聘登记状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','employ_apply_status','0','待面试','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','employ_apply_status','1','已面试通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','employ_apply_status','2','面试不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'leave_apply_type','请假类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','1','事假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','2','调休','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','3','年休假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','4','病假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','5','婚假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','6','丧假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','7','产假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','8','陪产假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','9','产检假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','10','探亲假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','11','公假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','12','工伤假','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_type','13','其他','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'leave_apply_status','请假状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_status','0','待审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_status','1','审核通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','leave_apply_status','2','审核不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'check_result','考核指标','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','check_result','1','极佳','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','check_result','2','良好','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','check_result','3','一般','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','check_result','4','欠佳','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'employ_result','录用结果','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','employ_result','1','拟予录用','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','employ_result','2','列入考虑','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','employ_result','3','不录用','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'probation','试用期','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','probation','1','六个月','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','probation','2','三个月','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','probation','3','两个月','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','probation','4','一个月','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'recruit_apply_status','用人申请状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','recruit_apply_status','0','待审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','recruit_apply_status','1','审核通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','recruit_apply_status','2','审核不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'remit_project','交款项目','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','remit_project','0','GPS','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','remit_project','1','月供保证金','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','remit_project','2','公证费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'post_duties','本岗位职责','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','post_duties','20','20分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','post_duties','18','18分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','post_duties','15','15分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','post_duties','10','10分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'work_procedure','工作程序','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_procedure','15','15分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_procedure','12','12分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_procedure','10','10分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_procedure','5','5分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'work_quality','工作素质','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_quality','15','15分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_quality','12','12分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_quality','10','10分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_quality','5','5分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'work_efficiency','工作效率','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_efficiency','10','10分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_efficiency','8','8分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_efficiency','5','5分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','work_efficiency','3','3分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'consciousness','自觉性','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','consciousness','10','10分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','consciousness','8','8分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','consciousness','5','5分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','consciousness','3','3分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'communication_skills','沟通能力','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','communication_skills','10','10分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','communication_skills','7','7分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','communication_skills','5','5分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','communication_skills','3','3分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'cooperative_ability','合作能力','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','cooperative_ability','10','10分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','cooperative_ability','7','7分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','cooperative_ability','5','5分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','cooperative_ability','3','3分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'attendance','出勤','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','attendance','10','10分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','attendance','8','8分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','attendance','5','5分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','attendance','3','3分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'fee_advance_apply_type','费用预支申请类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_type','01','采购固定资产','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_type','02','采购办公用品','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_type','03','出差费用','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_type','04','公关费用','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_type','05','采购GPS','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_type','06','贷后催收费用','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_type','07','其他','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'fee_advance_apply_status','费用预支申请类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_status','0','待审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_status','1','待财务审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_status','2','审核不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_status','3','财务审核通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_status','4','财务审核不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee_advance_apply_status','5','确认放款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'scope_people_type','公告范围类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','scope_people_type','-1','所有人员','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','scope_people_type','1','分公司','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','scope_people_type','2','部门','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','scope_people_type','3','职位','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','scope_people_type','4','具体人','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'notice_read_status','公告范围类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_read_status','0','未读','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_read_status','1','已读','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'welfare_apply_status','福利发放状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','welfare_apply_status','0','待审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','welfare_apply_status','1','审核通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','welfare_apply_status','2','审核不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'can_or_no','是否','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','can_or_no','0','是','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','can_or_no','1','否','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'account_type','账户类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_type','1','人民币','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_type','2','积分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_type','3','信用分','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'borrower_relation','借款人关系2','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','borrower_relation','2','丈夫','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','borrower_relation','3','妻子','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','borrower_relation','4','父亲','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','borrower_relation','5','母亲','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','borrower_relation','6','岳父','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','borrower_relation','7','岳母','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','borrower_relation','8','朋友','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','borrower_relation','9','同事','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','borrower_relation','10','兄弟姐妹','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'repoint_status','返点状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repoint_status','0','待返点','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','repoint_status','1','已返点','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'can_order_status','订单状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','can_order_status','0','待处理','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','can_order_status','1','已处理','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','can_order_status','2','已作废','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'car_break_status','车辆违规状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','car_break_status','0','待审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','car_break_status','1','审核通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','car_break_status','2','审核不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'notice_status','公告状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_status','0','待发布','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_status','1','已发布','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_status','2','已撤下','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'back_advance_status','退客户垫资款状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','back_advance_status','0','无需退款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','back_advance_status','1','银行已放款待财务退款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','back_advance_status','2','财务已退垫资款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'suggest','还款业务建议','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','suggest','1','6个月保证金','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','suggest','2','已结清','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'node_type','节点类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','001','征信单','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','002','准入单','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','003','车贷还款业务','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','004','车贷还款计划','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','005','商品还款业务','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','006','商品还款计划','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','007','客户作废','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','009','出差申请','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'cost_status','清收成本状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','cost_status','0','待收款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','cost_status','1','已收款','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'car_type','车辆类型','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','car_type','1','国产车','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','car_type','2','进口车','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','car_type','3','合资车','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'region','所属区域','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','region','1','乌鲁木齐','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','region','2','库尔勒','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','region','3','阿勒泰','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'interest','流水结息','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','interest','1','3月','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','interest','2','6月','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','interest','3','9月','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','interest','4','12月','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'is_card_mail_address','是否卡邮寄地址','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','is_card_mail_address','1','是','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','is_card_mail_address','2','否','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','is_card_mail_address','3','其他','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'bus_status','公车状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bus_status','0','未领用','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bus_status','1','领用中','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bus_status','2','已作废','admin',now(),'','CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'bus_borrow_status','公车借用状态','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bus_borrow_status','0','待审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bus_borrow_status','1','待归还','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bus_borrow_status','2','审核不通过','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bus_borrow_status','3','归还待审核','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','bus_borrow_status','4','已归还','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','education','0','高中及以下','admin',now(),'',NULL,NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','remit_project','3','银行服务费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','remit_project','4','公司服务费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','remit_project','5','团队服务费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');

delete from tsys_role where code ='SR201805291831307966076';
update tsys_menu_role set role_code='SR201805301244280427951' where role_code ='SR201805291831307966076';

/*
-- Query: SELECT `code`,`name`,`type`,`url`,`order_no`,`updater`,now() `update_datetime`,`remark`,`parent_code` FROM tsys_menu where code ='SM201806221601282435066'
-- Date: 2018-06-25 04:33
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201806221601282435066','新增','2','/add','1','U201806061344020605969','2018-06-24 20:33:11','数据字典管理','SM201804242145538683194');

/*
-- Query: SELECT 'RO201800000000000001' role_code,code as menu_code ,'admin' updater, now() as update_datetime,'' remark FROM tsys_menu where code ='SM201806221601282435066'
-- Date: 2018-06-25 04:35
*/
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806221601282435066','admin','2018-06-24 20:35:06','');
