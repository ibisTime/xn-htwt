ALTER TABLE `tdq_credit_user` 
ADD COLUMN `icbank_code` VARCHAR(32) NULL COMMENT '工行征信编号' AFTER `now_post_code`,
ADD COLUMN `result` VARCHAR(50) NULL AFTER `icbank_code`,
ADD COLUMN `loan_crdt` VARCHAR(255) NULL AFTER `result`,
ADD COLUMN `card_crdt` VARCHAR(255) NULL AFTER `loan_crdt`,
ADD COLUMN `left_num` BIGINT(20) NULL AFTER `card_crdt`,
ADD COLUMN `left_amount` BIGINT(20) NULL AFTER `left_num`,
ADD COLUMN `note` VARCHAR(255) NULL AFTER `left_amount`,
ADD COLUMN `status` VARCHAR(4) NULL AFTER `note`;