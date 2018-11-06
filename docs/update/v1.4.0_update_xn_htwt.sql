ALTER TABLE `tdq_budget_order` 
ADD COLUMN `intev_cur_node_code` varchar(32) NULL COMMENT '面签节点编号' AFTER `cur_node_code`;

INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_29', '财务审核', '002');

UPDATE `tsys_node_flow` SET `next_node`='002_07' WHERE `id`='63';
UPDATE `tsys_node_flow` SET `next_node`='002_29' WHERE `id`='60';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_29', '002_07');

INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '002_29');

ALTER TABLE `tp_archive` 
ADD COLUMN `avatar` varchar(255) NULL COMMENT '头像' AFTER `mobile`;

ALTER TABLE `tb_gps` 
ADD COLUMN `updater` varchar(255) NULL COMMENT '更新人' AFTER `customer_name`,
ADD COLUMN `update_datetime` datetime NULL COMMENT '更新时间' AFTER `updater`;

