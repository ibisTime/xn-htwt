ALTER TABLE `tsys_department` 
DROP COLUMN `mobile`,
CHANGE COLUMN `type` `type` VARCHAR(32) NULL DEFAULT NULL COMMENT '类型(1=子公司，2=部门，3=岗位)' AFTER `code`,
CHANGE COLUMN `lead_name` `lead_user_id` VARCHAR(32) NULL DEFAULT NULL COMMENT '负责人编号' ,
ADD COLUMN `order_no` INT(11) NULL COMMENT '序号' AFTER `parent_code`;