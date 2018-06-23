ALTER TABLE `tdq_credit` 
ADD COLUMN `team_code` VARCHAR(32) NULL COMMENT '团队编号' AFTER `sale_user_id`;

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
CHANGE COLUMN `employee_quantity` `employee_quantity` INT(11) NULL DEFAULT NULL COMMENT '员工数量' ;
CHANGE COLUMN `family_number` `family_number` INT(11) NULL DEFAULT NULL COMMENT '家庭人口' ;

ALTER TABLE `tp_archive` 
DROP COLUMN `is_delete`;

ALTER TABLE `tp_social_relation` 
DROP COLUMN `is_delete`;

ALTER TABLE `tsys_biz_team` 
ADD COLUMN `region` VARCHAR(255) NULL AFTER `water_bill`,
ADD COLUMN `place` VARCHAR(255) NULL AFTER `region`;

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

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','009','出差申请','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');

/*
-- Query: SELECT `code`,`name`,`type`,`remark` FROM tsys_node where type='009'
-- Date: 2018-06-23 22:44
*/
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_01','申请出差','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_02','部门主管审核','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_03','财务主管审核','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_04','总经理审核','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_05','审核通过','009',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('009_06','修改申请','009',NULL);

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

/*
-- Query: SELECT 'RO201800000000000001' role_code,code as menu_code ,'admin' updater, now() as update_datetime,'' remark FROM tsys_menu where code ='SM201806051500108276452' or code in 
(SELECT code  FROM tsys_menu where parent_code ='SM201806051500108276452')
or code in 
(SELECT code  FROM tsys_menu where parent_code in (SELECT code  FROM tsys_menu where parent_code ='SM201806051500108276452'))
-- Date: 2018-06-23 23:13
*/
INSERT INTO `TABLE` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051500108276452','admin','2018-06-23 15:11:09','');
INSERT INTO `TABLE` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806062003322256748','admin','2018-06-23 15:11:09','');
INSERT INTO `TABLE` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806062003487726270','admin','2018-06-23 15:11:09','');
INSERT INTO `TABLE` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806062004128529788','admin','2018-06-23 15:11:09','');
INSERT INTO `TABLE` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231911426804498','admin','2018-06-23 15:11:09','');
INSERT INTO `TABLE` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806231912209182943','admin','2018-06-23 15:11:09','');



INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'payment_project','交款项目','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','payment_project','1','gps','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','payment_project','2','月供保证金','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','payment_project','3','公证费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','payment_project','4','服务费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'fee','服务费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee','1','银行服务费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee','2','公司服务费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','fee','3','团队服务费','admin',now(),NULL,'CD-HTWT000020','CD-HTWT000020');
