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
