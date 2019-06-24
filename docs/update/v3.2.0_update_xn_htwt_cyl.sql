ALTER TABLE `tsys_user`
ADD COLUMN `job_no` VARCHAR(32) NULL COMMENT '工号' AFTER `post_code`;


INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201906231556045782685','车系刷新','2','/refreshSeries','91','USYS201800000000001','2019-06-23 15:59:36','','SM201804261354380715184');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201906231556482546130','车型刷新','2','/refreshShape','91','USYS201800000000001','2019-06-23 15:59:06','','SM201804261354595823870');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201906231610429433089','城市列表','1','/basedata/cities.htm','91','USYS201800000000001','2019-06-23 16:13:24','','SM201804301415107007680');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201906231611200089894','刷新','2','/refresh','1','USYS201800000000001','2019-06-23 16:11:20','','SM201906231610429433089');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201908230006532272220','人工确认逾期','2','/ManualConfirmationOverdue','4','USYS201800000000001','2019-06-07 12:03:02','','SM201805081056379762242');