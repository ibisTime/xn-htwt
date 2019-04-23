
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('budget_order','budget_gps_deduct_rate','0.006','U201807081543249555383','2018-08-25 11:32:47','GPS提成比例','CD-CHTWT000020','CD-CHTWT000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('budget_order','budget_oil_subsidy_rate','0.006','U201807081543249555383','2018-08-25 11:32:47','油补提成比例','CD-CHTWT000020','CD-CHTWT000020');

ALTER TABLE `tqj_cdbiz` 
DROP COLUMN `ywy_user`,
ADD COLUMN `captain_code` VARCHAR(32) NULL AFTER `team_code`,
ADD COLUMN `sale_user_id` VARCHAR(32) NULL COMMENT '业务员编号' AFTER `captain_code`,
ADD COLUMN `inside_job` VARCHAR(32) NULL COMMENT '内勤' AFTER `sale_user_id`,
ADD COLUMN `loan_bank` VARCHAR(32) NULL COMMENT '经办银行' AFTER `inside_job`,
ADD COLUMN `loan_amount` BIGINT(20) NULL COMMENT '贷款金额' AFTER `loan_bank`,
ADD COLUMN `enter_location` VARCHAR(32) NULL COMMENT '入档位置' AFTER `loan_amount`,
ADD COLUMN `enter_datetime` DATETIME NULL COMMENT '入档时间' AFTER `enter_location`,
ADD COLUMN `enter_filelist` VARCHAR(32) NULL COMMENT '档案目录' AFTER `enter_datetime`,
ADD COLUMN `make_card_status` VARCHAR(4) NULL COMMENT '制卡状态' AFTER `status`,
ADD COLUMN `cur_node_code` VARCHAR(5) NULL COMMENT '当前节点' AFTER `zf_status`,
ADD COLUMN `intev_cur_node_code` VARCHAR(5) NULL COMMENT '面签节点' AFTER `cur_node_code`,
ADD COLUMN `make_card_node` VARCHAR(5) NULL COMMENT '制卡节点' AFTER `intev_cur_node_code`,
ADD COLUMN `fbhgps_node` VARCHAR(5) NULL COMMENT '发保合gps节点' AFTER `make_card_node`,
ADD COLUMN `cancel_node_code` VARCHAR(5) NULL COMMENT '客户作废节点' AFTER `fbhgps_node`,
ADD COLUMN `is_gps_az` VARCHAR(4) NULL COMMENT '是否安装gps' AFTER `cancel_node_code`,
ADD COLUMN `is_finacing` VARCHAR(4) NULL COMMENT '是否融资' AFTER `is_gps_az`,
ADD COLUMN `is_advance_fund` VARCHAR(4) NULL COMMENT '是否垫资' AFTER `is_finacing`,
ADD COLUMN `is_plat_insure` VARCHAR(4) NULL COMMENT '是否我司续保' AFTER `is_advance_fund`,
ADD COLUMN `should_fee_amount` BIGINT(20) NULL COMMENT '应收手续费总额' AFTER `is_plat_insure`,
ADD COLUMN `real_fee_amount` BIGINT(20) NULL COMMENT '实收手续费总额' AFTER `should_fee_amount`,
ADD COLUMN `gua_mode` VARCHAR(4) NULL COMMENT '担保方式' AFTER `real_fee_amount`,
ADD COLUMN `credit_note` VARCHAR(255) NULL COMMENT '征信说明' AFTER `gua_mode`,
ADD COLUMN `apply_datetime` DATETIME NULL COMMENT '申请时间' AFTER `credit_note`,
ADD COLUMN `remark` VARCHAR(255) NULL COMMENT '备注' AFTER `apply_datetime`,
CHANGE COLUMN `team_code` `team_code` VARCHAR(32) NULL AFTER `company_code`,
CHANGE COLUMN `main_loaner` `type` VARCHAR(4) NULL DEFAULT NULL ,
CHANGE COLUMN `bank_code` `biz_type` VARCHAR(4) NULL DEFAULT NULL ,
CHANGE COLUMN `biz_type` `repay_biz_code` VARCHAR(32) NULL DEFAULT NULL ,
CHANGE COLUMN `dk_amount` `company_code` VARCHAR(32) NULL DEFAULT NULL ;


