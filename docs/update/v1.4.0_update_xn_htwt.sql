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
ADD COLUMN `advanf_cur_node_code` varchar(32) NULL COMMENT '垫资节点编号' AFTER `intev_cur_node_code`,
ADD COLUMN `is_entryMortgage` varchar(4) NULL COMMENT '是否录入发保合' AFTER `is_interview`,
ADD COLUMN `is_mortgage` varchar(4) NULL COMMENT '是否抵押完成' AFTER `bank_commit_note`;

ALTER TABLE `tstd_user` 
ADD COLUMN `produce_type` varchar(4) NULL COMMENT '产生类型' AFTER `kind`;
SET SQL_SAFE_UPDATES = 0;
UPDATE tstd_user SET produce_type='0';
UPDATE tstd_user u,tdq_budget_order b SET u.produce_type='1' where u.user_id = b.apply_user_id;
SET SQL_SAFE_UPDATES = 1;


ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `paper_photo` tinytext NULL COMMENT '纸质申请照片' AFTER `black_handle_note`;

INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_status', '3', '查询失败', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_status', '4', '重新查询', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('query_failure_days', 'days','90', 'admin', '2018-08-15 17:33:30', '立木征信重新查询天数', 'CD-CWZCD000020', 'CD-CWZCD000020');

ALTER TABLE `tdh_repay_plan` 
ADD COLUMN `prepay_photo` tinytext NULL COMMENT '还款截图' AFTER `cur_node_code`;

INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('006_06', '还款审核', '006');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('006', '006_06', '006_02', '006_01');
UPDATE `tsys_node_flow` SET `next_node`='006_06', `back_node`='' WHERE `id`='42';

SET SQL_SAFE_UPDATES = 0;
UPDATE tdq_budget_order SET is_entryMortgage='0';
UPDATE tdq_budget_order SET is_entryMortgage='1' WHERE cur_node_code = '002_19';
UPDATE tdq_budget_order SET is_entryMortgage='1' WHERE cur_node_code = '002_20';
UPDATE tdq_budget_order SET is_entryMortgage='1' WHERE cur_node_code = '002_21';
UPDATE tdq_budget_order SET is_entryMortgage='1' WHERE cur_node_code = '002_22';
UPDATE tdq_budget_order SET is_entryMortgage='1' WHERE cur_node_code = '002_23';

UPDATE tdq_budget_order SET is_mortgage='0';
UPDATE tdq_budget_order SET is_mortgage='1' WHERE cur_node_code = '002_21';
UPDATE tdq_budget_order SET is_mortgage='1' WHERE cur_node_code = '002_22';
UPDATE tdq_budget_order SET is_mortgage='1' WHERE cur_node_code = '002_23';
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE `tb_gps_apply` 
ADD COLUMN `apply_type` varchar(4) NULL COMMENT '申请类型(1 本部 2 分部)' AFTER `type`,
ADD COLUMN `team_code` varchar(32) NULL COMMENT '团队编号' AFTER `receive_datetime`,
ADD COLUMN `inside_job` varchar(32) NULL COMMENT '团队内勤' AFTER `team_code`,
ADD COLUMN `sale_user_id` varchar(32) NULL COMMENT '信贷专员' AFTER `inside_job`;


INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_37', '002_13');

INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'produce_type', '用户产生类型', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'produce_type', '0', '主动注册', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'produce_type', '1', '自动产生', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');


DROP TABLE IF EXISTS `tstd_sms`;
CREATE TABLE `tstd_sms` (
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '消息类型',
  `title` varchar(255) DEFAULT NULL COMMENT '消息标题',
  `content` TEXT DEFAULT NULL COMMENT '消息内容',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('002', '002_07', '002_33');
UPDATE `tsys_node` SET `name`='提前还款审核' WHERE `code`='003_20';
DELETE FROM `tsys_node` WHERE `code`='003_21';
DELETE FROM `tsys_node` WHERE `code`='003_22';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('003', '003_20', '003_02', '003_01');
UPDATE `tsys_node` SET `name`='已结清' WHERE `code`='005_03';
UPDATE `tsys_node` SET `name`='确认结清' WHERE `code`='005_02';


SET SQL_SAFE_UPDATES = 0;
DELETE FROM tdq_logistics WHERE code ='L201811010737293924675';
DELETE FROM tdq_logistics WHERE code ='L201812101620098231500';
DELETE FROM `tsys_biz_log` WHERE `id`='4888';
DELETE FROM `tsys_biz_log` WHERE `id`='7671';
DELETE FROM `tsys_biz_log` WHERE `id`='7574';
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE `tb_gps_apply` 
CHANGE COLUMN `type` `type` VARCHAR(4) NULL COMMENT '类型(1 公司 2 个人)' ;

SET SQL_SAFE_UPDATES = 0;
UPDATE tb_gps SET use_status='0';
UPDATE tb_gps SET use_status='1' WHERE code in 
(select code from tdq_budget_order_gps where budget_order in 
(select code from tdq_budget_order where cur_node_code in ('002_19','002_20','002_21','002_22','002_23')));
SET SQL_SAFE_UPDATES = 1;


ALTER TABLE `tdq_investigate_report` 
ADD COLUMN `jour_interest1` varchar(255) NULL COMMENT '流水结息1' AFTER `jour_datetime_end`,
ADD COLUMN `jour_interest2` varchar(255) NULL COMMENT '流水结息2' AFTER `jour_interest1`,
ADD COLUMN `interest1` varchar(255) NULL COMMENT '结息1' AFTER `jour_interest2`,
ADD COLUMN `interest2` varchar(255) NULL COMMENT '结息2' AFTER `interest1`,
ADD COLUMN `jour_pic` TEXT NULL COMMENT '流水图片' AFTER `jour_month_expend`,
ADD COLUMN `zfb_jour_interest1` varchar(255) NULL COMMENT '支付宝流水结息1' AFTER `zfb_jour_datetime_end`,
ADD COLUMN `zfb_jour_interest2` varchar(255) NULL COMMENT '支付宝流水结息2' AFTER `zfb_jour_interest1`,
ADD COLUMN `zfb_interest1` varchar(255) NULL COMMENT '支付宝结息1' AFTER `zfb_jour_interest2`,
ADD COLUMN `zfb_interest2` varchar(255) NULL COMMENT '支付宝结息2' AFTER `zfb_interest1`,
ADD COLUMN `zfb_jour_pic` TEXT NULL COMMENT '支付宝流水图片' AFTER `zfb_jour_month_expend`,
ADD COLUMN `wx_jour_interest1` varchar(255) NULL COMMENT '微信流水结息1' AFTER `wx_jour_datetime_end`,
ADD COLUMN `wx_jour_interest2` varchar(255) NULL COMMENT '微信流水结息2' AFTER `wx_jour_interest1`,
ADD COLUMN `wx_interest1` varchar(255) NULL COMMENT '微信结息1' AFTER `wx_jour_interest2`,
ADD COLUMN `wx_interest2` varchar(255) NULL COMMENT '微信结息2' AFTER `wx_interest1`,
ADD COLUMN `wx_jour_pic` TEXT NULL COMMENT '微信流水图片' AFTER `wx_jour_month_expend`;


SET SQL_SAFE_UPDATES = 0;
CREATE TABLE tmp as select code from tdq_investigate_report group by budget_order_code having count(budget_order_code) > 1;
DELETE FROM tdq_investigate_report  WHERE code in (SELECT code FROM tmp);
drop table tmp;
SET SQL_SAFE_UPDATES = 1;

SET SQL_SAFE_UPDATES = 0;
UPDATE tstd_bankcard c,tb_bank b SET c.bank_code=b.bank_code WHERE c.bank_code = b.code;
UPDATE tdh_repay_biz r,tb_bank b SET r.loan_bank=b.bank_code WHERE r.loan_bank = b.code;
SET SQL_SAFE_UPDATES = 1;


SET SQL_SAFE_UPDATES = 0;
UPDATE tdq_budget_order SET is_logistics='0';
UPDATE tdq_budget_order SET intev_cur_node_code='002_05',cur_node_code = '002_29',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_05';
UPDATE tdq_budget_order SET intev_cur_node_code='002_08',cur_node_code = '002_29',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_08';
UPDATE tdq_budget_order SET intev_cur_node_code='002_26',cur_node_code = '002_29',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_26';
UPDATE tdq_budget_order SET intev_cur_node_code='002_13',cur_node_code = '002_29',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_07';

UPDATE tdq_budget_order SET intev_cur_node_code='002_13',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_11';
UPDATE tdq_budget_order SET intev_cur_node_code='002_13',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_13';
UPDATE tdq_budget_order SET intev_cur_node_code='002_14',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_14';
UPDATE tdq_budget_order SET intev_cur_node_code='002_15',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_15';
UPDATE tdq_budget_order SET intev_cur_node_code='002_16',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_16';
UPDATE tdq_budget_order SET intev_cur_node_code='002_17',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_17';
UPDATE tdq_budget_order SET intev_cur_node_code='002_31',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_18';

UPDATE tdq_budget_order SET intev_cur_node_code='002_13',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_09';
UPDATE tdq_budget_order SET intev_cur_node_code='002_13',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_10';
UPDATE tdq_budget_order SET intev_cur_node_code='002_13',cur_node_code = '002_33',advanf_cur_node_code = '002_18',is_interview = '1',is_gps_az = '0' WHERE cur_node_code = '002_12';

UPDATE tdq_budget_order SET intev_cur_node_code='002_05',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_01';
UPDATE tdq_budget_order SET intev_cur_node_code='002_05',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_24';
UPDATE tdq_budget_order SET intev_cur_node_code='002_05',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_25';
UPDATE tdq_budget_order SET intev_cur_node_code='002_05',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_02';
UPDATE tdq_budget_order SET intev_cur_node_code='002_05',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_27';
UPDATE tdq_budget_order SET intev_cur_node_code='002_05',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_03';
UPDATE tdq_budget_order SET intev_cur_node_code='002_05',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_28';
UPDATE tdq_budget_order SET intev_cur_node_code='002_05',is_interview = '0',is_gps_az = '0' WHERE cur_node_code = '002_04';

UPDATE tdq_budget_order SET cur_node_code='002_21',intev_cur_node_code='002_31',advanf_cur_node_code = '002_32',is_interview = '1',is_gps_az = '1' WHERE cur_node_code = '002_19';
UPDATE tdq_budget_order SET cur_node_code='002_21',intev_cur_node_code='002_31',advanf_cur_node_code = '002_32',is_interview = '1',is_gps_az = '1' WHERE cur_node_code = '002_20';
UPDATE tdq_budget_order SET intev_cur_node_code='002_31',advanf_cur_node_code = '002_32',is_interview = '1',is_gps_az = '1' WHERE cur_node_code = '002_21';
UPDATE tdq_budget_order SET intev_cur_node_code='002_31',advanf_cur_node_code = '002_32',is_interview = '1',is_gps_az = '1' WHERE cur_node_code = '002_22';
UPDATE tdq_budget_order SET intev_cur_node_code='002_31',advanf_cur_node_code = '002_32',is_interview = '1',is_gps_az = '1' WHERE cur_node_code = '002_23';
SET SQL_SAFE_UPDATES = 1;