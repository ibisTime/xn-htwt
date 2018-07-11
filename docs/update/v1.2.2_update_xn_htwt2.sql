DELETE FROM `tsys_menu` WHERE `code`='SM201805171747477945012';
DELETE FROM `tsys_menu` WHERE `code`='SM201805171749254406565';
DELETE FROM `tsys_menu` WHERE `code`='SM201807102222115797443';
DELETE FROM `tsys_menu` WHERE `code`='SM201807102223052449230';
DELETE FROM `tsys_menu` WHERE `code`='SM201807102223342132405';
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807102222115797443','征信统计表','1','/statistic/creditReport.htm','3','U201806060409046595411','2018-07-10 23:30:54','统计分析','SM201805171730323054680');
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807102223052449230','进度日报表','1','/statistic/dayReport.htm','4','U201806061344020605969','2018-07-10 23:58:49','统计分析','SM201805171730323054680');
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807102223342132405','贷后统计表','1','/statistic/postloanReport.htm','5','U201806060409046595411','2018-07-11 13:59:22','统计分析','SM201805171730323054680');
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807111339063962570','业务报表','1','/statistic/businessReport.htm','6','U201806060409046595411','2018-07-11 14:59:28','','SM201805171730323054680');
insert into `tsys_menu` (`code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `parent_code`) values('SM201807111345256256205','团队报表','1','/statistic/teamReport.htm','7','U201806060409046595411','2018-07-11 14:59:33','','SM201805171730323054680');

insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001','SM201807111345256256205','U201806060409046595411','2018-07-11 15:09:11',NULL);
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001','SM201807111339063962570','U201806060409046595411','2018-07-11 15:09:11',NULL);
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001','SM201807102222115797443','U201806060409046595411','2018-07-11 15:09:11',NULL);
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001','SM201807102223342132405','U201806060409046595411','2018-07-11 15:09:11',NULL);
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`) values('RO201800000000000001','SM201807102223052449230','U201806060409046595411','2018-07-11 15:09:11',NULL);