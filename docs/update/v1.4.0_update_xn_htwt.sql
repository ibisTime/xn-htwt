ALTER TABLE `tdq_budget_order` 
ADD COLUMN `intev_cur_node_code` varchar(32) NULL COMMENT '面签节点编号' AFTER `cur_node_code`;

INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_29', '财务审核', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_30', '风控专员审核', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_31', '银行已放款', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_32', 'gps管理员审核通过', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_33', '驻行抵押申请', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_34', '内勤确认', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_35', '驻行寄送抵押合同', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_36', '内勤收件审核', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_37', '内勤寄送材料', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_38', '业务贷后审核材料', '002');

UPDATE `tsys_node` SET `name`='内勤录入发保合' WHERE `code`='002_18';
UPDATE `tsys_node` SET `name`='内勤录入抵押信息' WHERE `code`='002_21';




DELETE FROM `tsys_node_flow` WHERE `id`='55';

UPDATE `tsys_node_flow` SET `next_node`='002_13', `back_node`='002_05' WHERE `id`='60';
UPDATE `tsys_node_flow` SET `next_node`='002_30' WHERE `id`='17';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_30', '002_14');
UPDATE `tsys_node_flow` SET `next_node`='002_31' WHERE `id`='21';
UPDATE `tsys_node_flow` SET `next_node`='002_09' WHERE `id`='22';
UPDATE `tsys_node_flow` SET `next_node`='002_32' WHERE `id`='14';
DELETE FROM `tsys_node_flow` WHERE `id`='11';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_33', '002_34');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_34', '002_21');
UPDATE `tsys_node_flow` SET `next_node`='002_22' WHERE `id`='24';
UPDATE `tsys_node_flow` SET `next_node`='002_29' WHERE `id`='63';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('002', '002_29', '002_07', '002_28');
UPDATE `tsys_node_flow` SET `next_node`='002_36' WHERE `id`='66';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_36', '002_21');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_38', '002_19');
UPDATE `tsys_node_flow` SET `next_node`='002_38' WHERE `id`='25';





INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '002_29');

ALTER TABLE `tp_archive` 
ADD COLUMN `avatar` varchar(255) NULL COMMENT '头像' AFTER `mobile`;

ALTER TABLE `tdq_logistics` 
ADD COLUMN `cur_node_type` varchar(4) NULL COMMENT '节点类型' AFTER `type`;

ALTER TABLE `tb_gps` 
ADD COLUMN `updater` varchar(255) NULL COMMENT '更新人' AFTER `customer_name`,
ADD COLUMN `update_datetime` datetime NULL COMMENT '更新时间' AFTER `updater`;

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `car_xsz_smj` tinytext NULL COMMENT '车辆行驶证扫描件' AFTER `car_big_smj`,
ADD COLUMN `duty_paid_prove_smj` tinytext NULL COMMENT '完税证明扫描件' AFTER `car_xsz_smj`,
ADD COLUMN `supplement_note` tinytext NULL COMMENT '补充说明' AFTER `advance_fund_amount_pdf`,
ADD COLUMN `is_interview` varchar(4) NULL COMMENT '是否面签完成' AFTER `interview_other_pdf`,
ADD COLUMN `advanf_cur_node_code` varchar(32) NULL COMMENT '垫资节点编号' AFTER `intev_cur_node_code`;

ALTER TABLE `tstd_user` 
ADD COLUMN `produce_type` varchar(4) NULL COMMENT '产生类型' AFTER `kind`;
SET SQL_SAFE_UPDATES = 0;
UPDATE tstd_user SET produce_type='0';
UPDATE tstd_user u,tdq_budget_order b SET u.produce_type='1' where u.user_id = b.apply_user_id;
SET SQL_SAFE_UPDATES = 1;


ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `paper_photo` tinytext NULL COMMENT '纸质申请照片' AFTER `black_handle_note`;