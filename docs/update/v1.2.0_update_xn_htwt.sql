ALTER TABLE `tdq_budget_order` 
ADD COLUMN `bank_photo` tinytext DEFAULT NULL COMMENT '银行面签照片' AFTER `bank_video`;
DROP COLUMN `interview_contract`,
ADD COLUMN `company_contract` tinytext DEFAULT NULL COMMENT '公司合同' AFTER `bank_photo`,
ADD COLUMN `bank_contract` tinytext DEFAULT NULL COMMENT '银行合同' AFTER `company_contract`,
ADD COLUMN `other_video` tinytext DEFAULT NULL COMMENT '其他视频' AFTER `bank_contract`,
ADD COLUMN `interview_other_pdf` tinytext DEFAULT NULL COMMENT '面签其他资料' AFTER `other_video`,
DROP COLUMN `advance_fund_other_pdf`;

ALTER TABLE `dev_xn_htwt`.`tdq_credit` 
ADD COLUMN `note` VARCHAR(255) NULL COMMENT '征信说明' AFTER `cur_node_code`;







