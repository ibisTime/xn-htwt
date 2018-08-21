ALTER TABLE `tsys_biz_log` 
ADD COLUMN `team_code` VARCHAR(32) COMMENT '团队编号' AFTER `speed_time`,
CHANGE COLUMN `operate_role` `operate_role` VARCHAR(32) NULL COMMENT '操作角色' ,
CHANGE COLUMN `operator` `operator` VARCHAR(32) NULL COMMENT '操作人' ;

------------------------------------------------------------------

INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_25', '内勤主管审核', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_26', '内勤主管审核', '002');

UPDATE `tsys_node_flow` SET `next_node`='002_25' WHERE `id`='56';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('002', '002_25', '002_02', '002_04');

UPDATE `tsys_node_flow` SET `next_node`='002_26' WHERE `id`='10';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('002', '002_26', '002_07', '002_08');


UPDATE `tsys_node_flow` SET `next_node`='002_26' WHERE `id`='9';
UPDATE `tsys_node_flow` SET `next_node`='002_06' WHERE `id`='60';
UPDATE `tsys_node_flow` SET `next_node`='002_07' WHERE `id`='10';

ALTER TABLE `tsys_biz_log` 
ADD COLUMN `team_code` VARCHAR(32) COMMENT '团队编号' AFTER `speed_time`,
CHANGE COLUMN `operate_role` `operate_role` VARCHAR(32) NULL COMMENT '操作角色' ,
CHANGE COLUMN `operator` `operator` VARCHAR(32) NULL COMMENT '操作人' ;

SET SQL_SAFE_UPDATES = 0;
UPDATE tsys_biz_log s,tdq_credit c SET s.team_code = c.team_code  WHERE s.parent_order = c.code;
UPDATE tsys_biz_log s,tdq_budget_order b SET s.team_code = b.team_code  WHERE s.parent_order = b.code;
SET SQL_SAFE_UPDATES = 1;

