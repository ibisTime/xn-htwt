ALTER TABLE `tdq_budget_order` 
ADD COLUMN `intev_cur_node_code` varchar(32) NULL COMMENT '面签节点编号' AFTER `cur_node_code`;

INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_29', '财务审核', '002');

UPDATE `tsys_node_flow` SET `next_node`='002_07' WHERE `id`='63';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_29', '002_07');
DELETE FROM `tsys_node_flow` WHERE `id`='55';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_30', '002_14');
UPDATE `tsys_node_flow` SET `next_node`='002_13', `back_node`='002_05' WHERE `id`='60';
UPDATE `tsys_node_flow` SET `next_node`='002_30' WHERE `id`='17';
UPDATE `tsys_node_flow` SET `next_node`='002_31' WHERE `id`='21';
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_29', '财务审核', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_30', '风控专员审核', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_31', '银行已放款', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_32', 'gps管理员审核通过', '002');
UPDATE `tsys_node_flow` SET `next_node`='002_09' WHERE `id`='22';
UPDATE `tsys_node_flow` SET `next_node`='002_32' WHERE `id`='14';




INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '002_29');

ALTER TABLE `tp_archive` 
ADD COLUMN `avatar` varchar(255) NULL COMMENT '头像' AFTER `mobile`;

ALTER TABLE `tb_gps` 
ADD COLUMN `updater` varchar(255) NULL COMMENT '更新人' AFTER `customer_name`,
ADD COLUMN `update_datetime` datetime NULL COMMENT '更新时间' AFTER `updater`;

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `is_interview` varchar(4) NULL COMMENT '是否面签完成' AFTER `interview_other_pdf`,
ADD COLUMN `advanf_cur_node_code` varchar(32) NULL COMMENT '垫资节点编号' AFTER `intev_cur_node_code`;
