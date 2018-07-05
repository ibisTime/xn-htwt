ALTER TABLE `tdq_budget_order` 
ADD COLUMN `bank_photo` tinytext DEFAULT NULL COMMENT '银行面签照片' AFTER `bank_video`,
DROP COLUMN `interview_contract`,
ADD COLUMN `company_contract` tinytext DEFAULT NULL COMMENT '公司合同' AFTER `bank_photo`,
ADD COLUMN `bank_contract` tinytext DEFAULT NULL COMMENT '银行合同' AFTER `company_contract`,
ADD COLUMN `other_video` tinytext DEFAULT NULL COMMENT '其他视频' AFTER `bank_contract`,
ADD COLUMN `interview_other_pdf` tinytext DEFAULT NULL COMMENT '面签其他资料' AFTER `other_video`,
DROP COLUMN `advance_fund_other_pdf`,
CHANGE COLUMN `work_datetime` `work_datetime` tinytext NULL DEFAULT NULL COMMENT '何时进入现单位工作' ,
CHANGE COLUMN `team_fee` `fee` bigint(20) NULL DEFAULT NULL COMMENT '服务费' ,
ADD COLUMN `mate_zfb_interest1` bigint(20) DEFAULT NULL COMMENT '配偶支付宝结息1' AFTER `mate_zfb_jour_interest`,
ADD COLUMN `mate_zfb_interest2` bigint(20) DEFAULT NULL COMMENT '配偶支付宝结息2' AFTER `mate_zfb_interest1`,
ADD COLUMN `mate_wx_interest1` bigint(20) DEFAULT NULL COMMENT '配偶微信结息1' AFTER `mate_wx_jour_interest`,
ADD COLUMN `mate_wx_interest2` bigint(20) DEFAULT NULL COMMENT '配偶微信结息2' AFTER `mate_wx_interest1`,
ADD COLUMN `mate_interest1` bigint(20) DEFAULT NULL COMMENT '配偶结息1' AFTER `mate_jour_interest`,
ADD COLUMN `mate_interest2` bigint(20) DEFAULT NULL COMMENT '配偶结息2' AFTER `mate_interest1`,
ADD COLUMN `gua_zfb_interest1` bigint(20) DEFAULT NULL COMMENT '担保人支付宝结息1' AFTER `gua_zfb_jour_interest`,
ADD COLUMN `gua_zfb_interest2` bigint(20) DEFAULT NULL COMMENT '担保人支付宝结息2' AFTER `gua_zfb_interest1`,
ADD COLUMN `gua_wx_interest1` bigint(20) DEFAULT NULL COMMENT '担保人微信结息1' AFTER `gua_wx_jour_interest`,
ADD COLUMN `gua_wx_interest2` bigint(20) DEFAULT NULL COMMENT '担保人微信结息2' AFTER `gua_wx_interest1`,
ADD COLUMN `gua_interest1` bigint(20) DEFAULT NULL COMMENT '担保人结息1' AFTER `gua_jour_interest`,
ADD COLUMN `gua_interest2` bigint(20) DEFAULT NULL COMMENT '担保人结息2' AFTER `gua_interest1`,
ADD COLUMN `zfb_interest1` bigint(20) DEFAULT NULL COMMENT '支付宝结息1' AFTER `zfb_jour_interest`,
ADD COLUMN `zfb_interest2` bigint(20) DEFAULT NULL COMMENT '支付宝结息2' AFTER `zfb_interest1`,
ADD COLUMN `wx_interest1` bigint(20) DEFAULT NULL COMMENT '微信结息1' AFTER `wx_jour_interest`,
ADD COLUMN `wx_interest2` bigint(20) DEFAULT NULL COMMENT '微信结息2' AFTER `wx_interest1`,
ADD COLUMN `interest1` bigint(20) DEFAULT NULL COMMENT '结息1' AFTER `jour_interest`,
ADD COLUMN `interest2` bigint(20) DEFAULT NULL COMMENT '结息2' AFTER `interest1`;


/*
-- Query: SELECT code,name,type,url,order_no,'admin' updater, now() as update_datetime,remark,parent_code FROM tsys_menu where code ='SM201807041817130182597'
-- Date: 2018-07-05 00:50
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201807041817130182597','区域经理审核','2','/regionalManager','12','admin','2018-07-04 16:51:06','准入审查','SM201805291013406492370');

INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807041817130182597','U201806200828281617971',now(),NULL);





