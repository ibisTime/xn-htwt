ALTER TABLE `tdq_budget_order` 
ADD COLUMN `intev_cur_node_code` varchar(32) NULL COMMENT '面签节点编号' AFTER `cur_node_code`;

UPDATE `tsys_node_flow` SET `next_node`='002_07' WHERE `id`='63';


ALTER TABLE `tb_gps_apply` 
ADD COLUMN `operator` varchar(32) NULL COMMENT '操作人' AFTER `status`,
ADD COLUMN `update_datetime` datetime NULL COMMENT '更新时间' AFTER `operator`;

ALTER TABLE `tp_archive` 
ADD COLUMN `avatar` varchar(255) NULL COMMENT '头像' AFTER `mobile`;
