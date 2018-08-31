ALTER TABLE `tdq_budget_order` 
ADD COLUMN `pledge_status` VARCHAR(4) NULL COMMENT '抵押情况（1是，0否）' AFTER `pledge_bank_commit_note`;


INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('008_01', '财务退款', '008');
UPDATE `tsys_node` SET `name`='申请作废' WHERE `code`='007_01';


SET SQL_SAFE_UPDATES = 0;
UPDATE tdq_budget_order  SET pledge_status = '0';
UPDATE tdq_budget_order  SET pledge_status = '1'  WHERE car_number != '';
SET SQL_SAFE_UPDATES = 1;

INSERT INTO `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('car_periods', '36', '12.5', 'admin', '2018-08-15 17:33:30', '车贷期数管理的期数和利率', 'CD-CWZCD000020', 'CD-CWZCD000020');
DELETE FROM `tsys_menu` WHERE `code`='SM201805151423216129694';
UPDATE `tsys_node_flow` SET `back_node`= null WHERE `id`='27';

UPDATE `tsys_node_flow` SET `back_node`='003_17' WHERE `id`='37';
UPDATE `tsys_node_flow` SET `back_node`='003_18' WHERE `id`='38';
UPDATE `tsys_node_flow` SET `next_node`=null WHERE `id`='38';

INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808281918217763541','报表中心','1','#','7','U201806141609052491026','2018-08-28 19:18:33','','HTWTSM201800000000000000');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808281919108592405','统计分析','1','#','1','U201806141609052491026','2018-08-28 19:19:10','','SM201808281918217763541');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808281919304534607','查询分析','1','#','2','U201806141609052491026','2018-08-28 19:19:30','','SM201808281918217763541');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808281925256656678','征信统计表','1','/statistic/credit-report.htm','1','U201806141609052491026','2018-08-28 19:25:25','','SM201808281919108592405');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808281926055784648','进度日报表','1','/statistic/day-report.htm','2','U201806141609052491026','2018-08-28 19:26:05','','SM201808281919108592405');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808281927237334392','贷后统计表','1','/statistic/postloan-report.htm','3','U201806141609052491026','2018-08-28 19:27:23','','SM201808281919108592405');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808281928064436290','业务报表','1','/statistic/business-report.htm','4','U201806141609052491026','2018-08-28 19:28:06','','SM201808281919108592405');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808281928381327127','团队报表','1','/statistic/team-report.htm','5','U201806141609052491026','2018-08-28 19:28:38','','SM201808281919108592405');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808281931416733029','垫资超过1天未放款客户','1','/statistic/nonloan.htm','1','U201806141609052491026','2018-08-28 19:31:41','','SM201808281919304534607');

INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808281918217763541','U201806141609052491026','2018-08-28 21:18:14',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808281919108592405','U201806141609052491026','2018-08-28 21:18:14',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808281925256656678','U201806141609052491026','2018-08-28 21:18:14',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808281926055784648','U201806141609052491026','2018-08-28 21:18:14',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808281927237334392','U201806141609052491026','2018-08-28 21:18:14',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808281928064436290','U201806141609052491026','2018-08-28 21:18:14',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808281928381327127','U201806141609052491026','2018-08-28 21:18:14',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808281919304534607','U201806141609052491026','2018-08-28 21:18:14',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808281931416733029','U201806141609052491026','2018-08-28 21:18:14',NULL);



ALTER TABLE `tp_comp_regime` 
CHANGE COLUMN `content` `content` TEXT NULL DEFAULT NULL COMMENT '内容' ;
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'node_type', '008', '退客户垫资款', 'admin', '2018-06-25 08:25:28', 'CD-HTWT000020', 'CD-HTWT000020');

ALTER TABLE `tp_comp_regime` 
ADD COLUMN `enclosure` TINYTEXT NULL COMMENT '附件' AFTER `content`;

ALTER TABLE `tp_notice` 
ADD COLUMN `enclosure` TINYTEXT NULL COMMENT '附件' AFTER `publish_datetime`;

ALTER TABLE `tdq_logistics` 
DROP COLUMN `send_file_list`,
DROP COLUMN `ref_file_list`;

UPDATE `tsys_node` SET `name`='入档完成' WHERE `code`='002_23';

DELETE FROM `tsys_menu` WHERE `code`='SM201805081719260431762';

DELETE FROM `tsys_menu` WHERE `code`='SM201805311013495606615';

UPDATE `tsys_menu` SET `name`='垫资超1天未放款', `url`='/statistic/one-report.htm' WHERE `code`='SM201808281931416733029';

INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808291134334396154','详情','2','/detail','1','U201806141609052491026','2018-08-29 11:34:33','','SM201808281931416733029');

INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808291134334396154','U201806141609052491026','2018-08-29 16:22:36',NULL);

SET SQL_SAFE_UPDATES = 0;
UPDATE tdh_repay_biz  SET is_advance_settled = '0'  WHERE is_advance_settled is null;
SET SQL_SAFE_UPDATES = 1;



INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('011_01', 'GPS发件', '011');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('011_02', 'GPS收件', '011');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('011_03', 'GPS补件', '011');

UPDATE `tsys_node_flow` SET `next_node`='002_26' WHERE `id`='12';
UPDATE `tsys_node_flow` SET `next_node`='002_24' WHERE `id`='8';

INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('SR201800000000000000YWY', '002_11');


gps mei bu 011
INSERT INTO `dev_xn_htwt`.`tsys_node` (`code`, `name`, `type`) VALUES ('012_01', '业务贷后资料发件', '012');
INSERT INTO `dev_xn_htwt`.`tsys_node` (`code`, `name`, `type`) VALUES ('012_02', '业务贷后资料收件', '012');
INSERT INTO `dev_xn_htwt`.`tsys_node` (`code`, `name`, `type`) VALUES ('012_03', '驻行放款材料发件', '012');
INSERT INTO `dev_xn_htwt`.`tsys_node` (`code`, `name`, `type`) VALUES ('012_04', '驻行放款材料收件', '012');
INSERT INTO `dev_xn_htwt`.`tsys_node` (`code`, `name`, `type`) VALUES ('012_05', '驻行抵押材料发件', '012');
INSERT INTO `dev_xn_htwt`.`tsys_node` (`code`, `name`, `type`) VALUES ('012_06', '驻行抵押材料收件', '012');

UPDATE `dev_xn_htwt`.`tsys_node` SET `code`='013_01' WHERE `code`='012_03';
UPDATE `dev_xn_htwt`.`tsys_node` SET `code`='013_02' WHERE `code`='012_04';
UPDATE `dev_xn_htwt`.`tsys_node` SET `code`='014_01' WHERE `code`='012_05';
UPDATE `dev_xn_htwt`.`tsys_node` SET `code`='014_02' WHERE `code`='012_06';

UPDATE `dev_xn_htwt`.`tsys_node` SET `type`='013' WHERE `code`='013_01';
UPDATE `dev_xn_htwt`.`tsys_node` SET `type`='013' WHERE `code`='013_02';
UPDATE `dev_xn_htwt`.`tsys_node` SET `type`='014' WHERE `code`='014_01';
UPDATE `dev_xn_htwt`.`tsys_node` SET `type`='014' WHERE `code`='014_02';



INSERT INTO `tsys_biz_log` (`parent_order`, `ref_type`, `ref_order`, `deal_node`, `deal_note`, `status`, `operate_role`, `operator`, `operator_name`, `operator_mobile`, `start_datetime`, `team_code`) VALUES ('BO201807161505084842416', '002', 'BO201807161505084842416', '002_14', '驻行人员审核放款材料', '0', '', '', '', '', '2018-07-17 15:01:37', 'BT201807161416460323894');
UPDATE `tsys_biz_log` SET `end_datetime`='2018-07-17 15:01:37', `speed_time`='0天0时3分50秒' WHERE `id`='1243';


INSERT INTO `dev_xn_htwt`.`tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`) VALUES ('1', 'node_type', '012', '业务贷后资料传递', 'admin', '2018-06-25 08:25:28');
INSERT INTO `dev_xn_htwt`.`tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`) VALUES ('1', 'node_type', '013', '驻行放款资料传递', 'admin', '2018-06-25 08:25:28');
INSERT INTO `dev_xn_htwt`.`tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`) VALUES ('1', 'node_type', '014', '驻行抵押资料传递', 'admin', '2018-06-25 08:25:28');
