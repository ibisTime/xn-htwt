ALTER TABLE `tdq_budget_order` 
ADD COLUMN `pledge_status` VARCHAR(4) NULL COMMENT '抵押情况（1是，0否）' AFTER `pledge_bank_commit_note`;


INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('008_01', '财务退款', '008');
UPDATE `tsys_node` SET `name`='申请作废' WHERE `code`='007_01';


SET SQL_SAFE_UPDATES = 0;
UPDATE tdq_budget_order  SET pledge_status = '0';
UPDATE tdq_budget_order  SET pledge_status = '1'  WHERE car_number != '';
SET SQL_SAFE_UPDATES = 1;

UPDATE `tsys_node_flow` SET `back_node`= null WHERE `id`='27';

UPDATE `tsys_node_flow` SET `back_node`='003_17' WHERE `id`='37';
UPDATE `tsys_node_flow` SET `back_node`='003_18' WHERE `id`='38';
UPDATE `tsys_node_flow` SET `next_node`=null WHERE `id`='38';


