ALTER TABLE `tsys_biz_log` 
ADD COLUMN `team_code` VARCHAR(32) COMMENT '团队编号' AFTER `speed_time`,
CHANGE COLUMN `operate_role` `operate_role` VARCHAR(32) NULL COMMENT '操作角色' ,
CHANGE COLUMN `operator` `operator` VARCHAR(32) NULL COMMENT '操作人' ;


