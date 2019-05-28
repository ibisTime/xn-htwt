INSERT INTO `tdq_file_list` (`category`,`kname`,`vname`,`attach_type`,`number`,`updater`,`update_datetime`) VALUES ('icbank','special_quato_pic','专项额度核定申请表','图片',1,'USYS201800000000001',now());
INSERT INTO `tdq_file_list` (`category`,`kname`,`vname`,`attach_type`,`number`,`updater`,`update_datetime`) VALUES ('icbank','red_card_pic_with_id_pic','开卡申请表','图片',1,'USYS201800000000001',now());




ALTER TABLE `tqj_cdbiz`
  ADD COLUMN `card_post_province` VARCHAR(64) NULL COMMENT '卡邮寄地址邮编' AFTER `repay_card_number`,
  ADD COLUMN `card_post_city` VARCHAR(64) NULL COMMENT '卡邮寄地址邮编' AFTER `card_post_address`,
  ADD COLUMN `card_post_area` VARCHAR(64) NULL COMMENT '卡邮寄地址邮编' AFTER `card_post_address`,
  ADD COLUMN `card_post_code` VARCHAR(64) NULL COMMENT '卡邮寄地址邮编' AFTER `card_post_address`;


ALTER TABLE `tdq_credit_user`
  ADD COLUMN `english_name` VARCHAR(32) NULL COMMENT '英文名' AFTER `user_name`,
  ADD COLUMN `authref` VARCHAR(64) NULL COMMENT '发证机关' AFTER `id_no`,
  ADD COLUMN `statdate` VARCHAR(64) NULL COMMENT '证件有效期' AFTER `authref`,
  ADD COLUMN `emergency_sex1` VARCHAR(8) NULL COMMENT '联系人1性别' AFTER `emergency_name1`,
  ADD COLUMN `emergency_sex2` VARCHAR(8) NULL COMMENT '联系人2性别' AFTER `emergency_name2`,
  ADD COLUMN `company_province` VARCHAR(255) NULL COMMENT '单位所在省' AFTER `company_name`,
  ADD COLUMN `company_city` VARCHAR(255) NULL COMMENT '单位所在市' AFTER `company_province`,
  ADD COLUMN `company_area` VARCHAR(255) NULL COMMENT '单位所在区域' AFTER `company_city`,
  ADD COLUMN `now_address_date` VARCHAR(64) NULL COMMENT '何时入住现住地' AFTER `now_address`;


ALTER TABLE `tdq_bank_loan`
  ADD COLUMN `repay_first_month_datetime` VARCHAR(255) NULL AFTER `month_amount`,
  ADD COLUMN `repay_first_month_amount` VARCHAR(255) NULL AFTER `repay_first_month_datetime`,
  ADD COLUMN `repay_month_amount` VARCHAR(255) NULL AFTER `repay_first_month_amount`,
  ADD COLUMN `bank_fk_date` VARCHAR(255) NULL AFTER `repay_month_amount`;
