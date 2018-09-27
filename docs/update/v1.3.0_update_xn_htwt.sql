INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'people_status', '角色状态', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'people_status', '1', '正常', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'people_status', '2', '注销', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');


DROP TABLE IF EXISTS `tdq_file_list`;
CREATE TABLE `tdq_file_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `number` varchar(255) DEFAULT NULL COMMENT '序号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
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
