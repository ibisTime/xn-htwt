ALTER TABLE `tdq_credit` 
ADD COLUMN `biz_code` VARCHAR(32) NULL COMMENT '业务编号' AFTER `code`;


ALTER TABLE `tdq_budget_order` 
ADD COLUMN `biz_code` VARCHAR(32) NULL COMMENT '业务编号' AFTER `code`;
