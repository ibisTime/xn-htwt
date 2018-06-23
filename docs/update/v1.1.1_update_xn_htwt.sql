ALTER TABLE `tdq_credit` 
ADD COLUMN `team_code` VARCHAR(32) NULL COMMENT '团队编号' AFTER `sale_user_id`;

ALTER TABLE `tsys_department` 
DROP COLUMN `mobile`,
CHANGE COLUMN `type` `type` VARCHAR(32) NULL DEFAULT NULL COMMENT '类型(1=子公司，2=部门，3=岗位)' AFTER `code`,
CHANGE COLUMN `lead_name` `lead_user_id` VARCHAR(32) NULL DEFAULT NULL COMMENT '负责人编号' ,
ADD COLUMN `order_no` INT(11) NULL COMMENT '序号' AFTER `parent_code`;

ALTER TABLE `tsys_user` 
ADD COLUMN `archive_code` VARCHAR(32) NULL COMMENT '人事档案编号' AFTER `team_code`;

update tsys_user tu,tp_archive tp set tu.archive_code =tp.code where tu.user_id= tp.user_id;

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `region` tinytext DEFAULT NULL COMMENT '所属区域' AFTER `loan_product_name`,
ADD COLUMN `team_fee` bigint(20) DEFAULT NULL COMMENT '团队服务费' AFTER `company_fee`,
ADD COLUMN `car_type` tinytext DEFAULT NULL COMMENT '车辆类型' AFTER `car_model`,
DROP COLUMN `car_hgz_no`,
ADD COLUMN `age` INT(11) DEFAULT NULL COMMENT '年龄' AFTER `gender`,
ADD COLUMN `political` tinytext DEFAULT NULL COMMENT '政治面貌' AFTER `marry_state`,
ADD COLUMN `is_card_mail_address` varchar(255) DEFAULT NULL COMMENT '是否卡邮寄地址' AFTER `now_address`,
ADD COLUMN `work_is_card_mail_address` tinytext DEFAULT NULL COMMENT '是否卡邮寄地址' AFTER `work_company_address`,
ADD COLUMN `other_work_note` tinytext DEFAULT NULL COMMENT '其他工作描述' AFTER `self_company_area`,
ADD COLUMN `work_asset_pdf` tinytext DEFAULT NULL COMMENT '工作资料上传' AFTER `other_work_note`,
ADD COLUMN `mate_zfb_jour_interest` tinytext DEFAULT NULL COMMENT '配偶支付宝流水结息' AFTER `mate_zfb_jour_datetime_end`,
ADD COLUMN `mate_wx_jour_interest` tinytext DEFAULT NULL COMMENT '配偶微信流水结息' AFTER `mate_wx_jour_datetime_end`,
ADD COLUMN `mate_jour_interest` tinytext DEFAULT NULL COMMENT '配偶流水结息' AFTER `mate_jour_datetime_end`,
ADD COLUMN `gua_zfb_jour_interest` tinytext DEFAULT NULL COMMENT '担保人支付宝流水结息' AFTER `gua_zfb_jour_datetime_end`,
ADD COLUMN `gua_wx_jour_interest` tinytext DEFAULT NULL COMMENT '担保人微信流水结息' AFTER `gua_wx_jour_datetime_end`,
ADD COLUMN `gua_jour_interest` tinytext DEFAULT NULL COMMENT '担保人流水结息' AFTER `gua_jour_datetime_end`,
ADD COLUMN `zfb_jour_interest` tinytext DEFAULT NULL COMMENT '支付宝流水结息' AFTER `zfb_jour_datetime_end`,
ADD COLUMN `wx_jour_interest` tinytext DEFAULT NULL COMMENT '微信流水结息' AFTER `wx_jour_datetime_end`,
ADD COLUMN `jour_interest` tinytext DEFAULT NULL COMMENT '流水结息' AFTER `jour_datetime_end`,
ADD COLUMN `hk_book_pdf` tinytext DEFAULT NULL COMMENT '户口本资料' AFTER `house_picture`,
ADD COLUMN `id_card_pdf` tinytext DEFAULT NULL COMMENT '身份证资料' AFTER `hk_book_pdf`,
ADD COLUMN `marry_pdf` tinytext DEFAULT NULL COMMENT '结婚证资料' AFTER `id_card_pdf`,
ADD COLUMN `other_pdf` tinytext DEFAULT NULL COMMENT '其他资料' AFTER `marry_pdf`,
DROP COLUMN `interview_video`,
ADD COLUMN `bank_video` tinytext DEFAULT NULL COMMENT '银行视频' AFTER `is_advance_fund`,
ADD COLUMN `company_video` tinytext DEFAULT NULL COMMENT '公司视频' AFTER `bank_video`,
ADD COLUMN `advance_fund_amount_pdf` tinytext DEFAULT NULL COMMENT '资金划转授权书' AFTER `bill_pdf`,
ADD COLUMN `advance_fund_other_pdf` tinytext DEFAULT NULL COMMENT '垫资其他资料' AFTER `advance_fund_amount_pdf`,
DROP COLUMN `car_hgz`,
ADD COLUMN `car_settle_other_pdf` tinytext DEFAULT NULL COMMENT '其他资料' AFTER `car_syx`;
