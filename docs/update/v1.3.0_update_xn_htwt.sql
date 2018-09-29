INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'people_status', '角色状态', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'people_status', '1', '正常', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'people_status', '2', '注销', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');


DROP TABLE IF EXISTS `tdq_file_list`;
CREATE TABLE `tdq_file_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `no` varchar(255) DEFAULT NULL COMMENT '序号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `number` int(11) DEFAULT NULL COMMENT '份数',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET SQL_SAFE_UPDATES = 0;
UPDATE `tsys_user` SET `status`='1' WHERE status = 0;
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE `tb_gps_apply` 
ADD COLUMN `apply_wired_count` int(11) NULL COMMENT '申请有线个数' AFTER `apply_count`,
ADD COLUMN `apply_wireless_count` int(11) NULL COMMENT '申请无线个数' AFTER `apply_wired_count`;

UPDATE `tsys_node` SET `name`='风控一审' WHERE `code`='002_02';
UPDATE `tsys_node` SET `name`='风控终审' WHERE `code`='002_03';
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_27', '风控二审', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_28', '业务总监审核', '002');

INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('001', '001_08', '001_02');
UPDATE `tsys_node_flow` SET `next_node`='001_08' WHERE `id`='1';
UPDATE `tsys_node_flow` SET `next_node`='002_27' WHERE `id`='6';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('002', '002_27', '002_03', '002_04');
UPDATE `tsys_node_flow` SET `next_node`='002_28' WHERE `id`='7';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('002', '002_28', '002_05', '002_04');

ALTER TABLE `tdq_logistics` 
ADD COLUMN `filelist` VARCHAR(255) NULL COMMENT '材料清单' AFTER `receiver`,
ADD COLUMN `sender` VARCHAR(32) NULL COMMENT '发件人' AFTER `receipt_datetime`;

SET SQL_SAFE_UPDATES = 0;
UPDATE tdq_logistics t SET t.receiver = null WHERE t.receiver = '0';
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `pledge_user_id_card_copy` text NULL COMMENT '代理人身份证复印件' AFTER `pledge_user`,
ADD COLUMN `inside_job` varchar(32) NULL COMMENT '内勤' AFTER `sale_user_id`,
CHANGE COLUMN `mate_zfb_jour_interest` `mate_zfb_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '配偶支付宝流水结息1' ,
ADD COLUMN `mate_zfb_jour_interest2` MEDIUMTEXT NULL COMMENT '配偶支付宝流水结息2' AFTER `mate_zfb_jour_interest1`,
CHANGE COLUMN `mate_wx_jour_interest` `mate_wx_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '配偶微信流水结息1' ,
ADD COLUMN `mate_wx_jour_interest2` MEDIUMTEXT NULL COMMENT '配偶微信流水结息2' AFTER `mate_wx_jour_interest1`,
CHANGE COLUMN `mate_jour_interest` `mate_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '配偶流水结息1' ,
ADD COLUMN `mate_jour_interest2` MEDIUMTEXT NULL COMMENT '配偶流水结息2' AFTER `mate_jour_interest1`,
CHANGE COLUMN `gua_zfb_jour_interest` `gua_zfb_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '担保人支付宝流水结息1' ,
ADD COLUMN `gua_zfb_jour_interest2` MEDIUMTEXT NULL COMMENT '担保人支付宝流水结息2' AFTER `gua_zfb_jour_interest1`,
CHANGE COLUMN `gua_wx_jour_interest` `gua_wx_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '担保人微信流水结息1' ,
ADD COLUMN `gua_wx_jour_interest2` MEDIUMTEXT NULL COMMENT '担保人微信流水结息2' AFTER `gua_wx_jour_interest1`,
CHANGE COLUMN `gua_jour_interest` `gua_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '担保人流水结息1' ,
ADD COLUMN `gua_jour_interest2` MEDIUMTEXT NULL COMMENT '担保人流水结息2' AFTER `gua_jour_interest1`,
CHANGE COLUMN `zfb_jour_interest` `zfb_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '支付宝流水结息1' ,
ADD COLUMN `zfb_jour_interest2` MEDIUMTEXT NULL COMMENT '支付宝流水结息2' AFTER `zfb_jour_interest1`,
CHANGE COLUMN `wx_jour_interest` `wx_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '微信流水结息1' ,
ADD COLUMN `wx_jour_interest2` MEDIUMTEXT NULL COMMENT '微信流水结息2' AFTER `wx_jour_interest1`,
CHANGE COLUMN `jour_interest` `jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '流水结息1' ,
ADD COLUMN `jour_interest2` MEDIUMTEXT NULL COMMENT '流水结息2' AFTER `jour_interest1`;

SET SQL_SAFE_UPDATES = 0;
update tdq_budget_order b,tsys_biz_log z set b.inside_job = z.operator where b.code = z.ref_order and z.deal_node = '002_01';
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `is_gps_az` VARCHAR(4) NULL COMMENT '是否安装了GPS' AFTER `frozen_status`;

SET SQL_SAFE_UPDATES = 0;
update tdq_budget_order set is_gps_az = '0';
update tdq_budget_order b,tdq_budget_order_gps g set b.is_gps_az = '1' where b.code = g.budget_order;
SET SQL_SAFE_UPDATES = 1;








