ALTER TABLE `tdq_budget_order` 
ADD COLUMN `pledge_status` VARCHAR(4) NULL COMMENT '抵押情况（1是，0否）' AFTER `pledge_bank_commit_note`;

UPDATE tdq_budget_order b SET b.pledge_status = '1';
UPDATE tdq_budget_order b SET b.pledge_status = '0'  WHERE b.car_number = null;