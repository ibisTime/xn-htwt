SET SQL_SAFE_UPDATES = 0;
DROP TABLE IF EXISTS `tdq_linshi`;
CREATE TABLE `tdq_linshi` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tdq_linshi` (code) SELECT t.id FROM tsys_biz_log t left join tdq_budget_order b on t.parent_order = b.code where t.deal_node = '002_01' and b.cur_node_code = '002_01';
DELETE FROM tsys_biz_log WHERE id in (SELECT code FROM tdq_linshi);
TRUNCATE `tdq_linshi`;
INSERT INTO `tdq_linshi` (code) SELECT t.code FROM tdq_credit t left join tdq_budget_order b on t.budget_code = b.code where b.cur_node_code = '002_01';
UPDATE tdq_credit SET cur_node_code = '001_08' WHERE code in (SELECT code FROM tdq_linshi);
UPDATE tdq_credit SET budget_code = null WHERE code in (SELECT code FROM tdq_linshi);
TRUNCATE `tdq_linshi`;
INSERT INTO `tdq_linshi` (code) select l.id from tsys_biz_log l left join tdq_credit c on l.parent_order = c.code where l.parent_order in (SELECT t.code FROM tdq_credit t left join tdq_budget_order b on t.budget_code = b.code where b.cur_node_code = '002_01') and l.deal_node > '001_01';
DELETE FROM tsys_biz_log WHERE id in (SELECT code FROM tdq_linshi);
DELETE FROM tdq_budget_order where cur_node_code = '002_01';

TRUNCATE `tdq_linshi`;
INSERT INTO `tdq_linshi` (code) select l.id from tsys_biz_log l left join tdq_credit c on l.parent_order = c.code where c.code = '001_02' and l.deal_node > '001_01';
DELETE FROM tsys_biz_log WHERE id in (SELECT code FROM tdq_linshi);
update tdq_credit set cur_node_code = '001_08' where cur_node_code = '001_02';
TRUNCATE `tdq_linshi`;
INSERT INTO `tdq_linshi` (code) select l.id from tsys_biz_log l left join tdq_credit c on l.parent_order = c.code where c.code = '001_03' and l.deal_node > '001_01';
DELETE FROM tsys_biz_log WHERE id in (SELECT code FROM tdq_linshi);
update tdq_credit set cur_node_code = '001_08' where cur_node_code = '001_03';
TRUNCATE `tdq_linshi`;
INSERT INTO `tdq_linshi` (code) select l.id from tsys_biz_log l left join tdq_credit c on l.parent_order = c.code where c.code = '001_05' and l.deal_node > '001_01';
DELETE FROM tsys_biz_log WHERE id in (SELECT code FROM tdq_linshi);
update tdq_credit set cur_node_code = '001_01' where cur_node_code = '001_05';
TRUNCATE `tdq_linshi`;
INSERT INTO `tdq_linshi` (code) select l.id from tsys_biz_log l left join tdq_credit c on l.parent_order = c.code where c.code = '001_06' and l.deal_node > '001_01';
DELETE FROM tsys_biz_log WHERE id in (SELECT code FROM tdq_linshi);
update tdq_credit set cur_node_code = '001_08' where cur_node_code = '001_06';

DROP TABLE IF EXISTS `tdq_linshi`;
SET SQL_SAFE_UPDATES = 1;



INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'people_status', '角色状态', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'people_status', '1', '正常', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'people_status', '2', '注销', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');


DROP TABLE IF EXISTS `tdq_file_list`;
CREATE TABLE `tdq_file_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `no` varchar(255) DEFAULT NULL COMMENT '序号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `number` int(11) DEFAULT NULL COMMENT '份数',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET SQL_SAFE_UPDATES = 0;
UPDATE `tsys_user` SET `status`='1' WHERE status = 0;
UPDATE `tsys_role` SET `updater`='USYS201800000000001';
SET SQL_SAFE_UPDATES = 1;

INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'sys_user_status', '用户状态', 'admin', '2018-06-25 08:23:27', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'sys_user_status', '1', '正常', 'admin', '2018-06-25 08:23:27', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'sys_user_status', '2', '注销', 'admin', '2018-06-25 08:23:27', 'CD-HTWT000020', 'CD-HTWT000020');

ALTER TABLE `tb_gps_apply` 
ADD COLUMN `apply_wired_count` int(11) NULL COMMENT '申请有线个数' AFTER `apply_count`,
ADD COLUMN `apply_wireless_count` int(11) NULL COMMENT '申请无线个数' AFTER `apply_wired_count`;

UPDATE `tsys_node` SET `name`='风控一审' WHERE `code`='002_02';
UPDATE `tsys_node` SET `name`='风控终审' WHERE `code`='002_03';
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_27', '风控二审', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('002_28', '业务总监审核', '002');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('001_08', '派单', '001');

INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('001', '001_08', '001_02');
UPDATE `tsys_node_flow` SET `next_node`='001_08' WHERE `id`='1';
UPDATE `tsys_node_flow` SET `next_node`='002_27' WHERE `id`='6';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('002', '002_27', '002_03', '002_04');
UPDATE `tsys_node_flow` SET `next_node`='002_28' WHERE `id`='7';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('002', '002_28', '002_05', '002_04');

ALTER TABLE `tdq_logistics` 
ADD COLUMN `filelist` VARCHAR(255) NULL COMMENT '材料清单' AFTER `receiver`,
ADD COLUMN `sender` VARCHAR(32) NULL COMMENT '发件人' AFTER `receipt_datetime`;

SET SQL_SAFE_UPDATES = 0;
UPDATE tdq_logistics t SET t.receiver = null WHERE t.receiver = '0';
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `pledge_user_id_card_copy` text NULL COMMENT '代理人身份证复印件' AFTER `pledge_user`,
ADD COLUMN `inside_job` varchar(32) NULL COMMENT '内勤' AFTER `sale_user_id`,
ADD COLUMN `is_gps_az` VARCHAR(4) NULL COMMENT '是否安装了GPS' AFTER `frozen_status`,
ADD COLUMN `enter_datetime` datetime NULL COMMENT '入档日期' AFTER `enter_location`,
ADD COLUMN `vehicle_company_name` varchar(255) NULL COMMENT '机动车销售公司' AFTER `loan_period`,
ADD COLUMN `other_fee` bigint(20) NULL COMMENT '其他费用' AFTER `auth_fee`,
ADD COLUMN `is_financing` VARCHAR(4) NULL COMMENT '是否融资' AFTER `is_advance_fund`,
ADD COLUMN `is_logistics` VARCHAR(4) NULL COMMENT '是否是资料传递中' AFTER `is_gps_az`,
ADD COLUMN `car_model_name` varchar(255) NULL COMMENT '车型名称' AFTER `car_model`,
ADD COLUMN `advance_note` MEDIUMTEXT NULL COMMENT '垫资说明' AFTER `bill_pdf`,
ADD COLUMN `enter_fileList` MEDIUMTEXT NULL COMMENT '入档清单' AFTER `enter_datetime`,
ADD COLUMN `car_price_check_report` varchar(255) NULL COMMENT '车辆价格核实报告' AFTER `pledge_datetime`,
CHANGE COLUMN `mate_zfb_jour_interest` `mate_zfb_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '配偶支付宝流水结息1' ,
ADD COLUMN `mate_zfb_jour_interest2` MEDIUMTEXT NULL COMMENT '配偶支付宝流水结息2' AFTER `mate_zfb_jour_interest1`,
CHANGE COLUMN `mate_wx_jour_interest` `mate_wx_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '配偶微信流水结息1' ,
ADD COLUMN `mate_wx_jour_interest2` MEDIUMTEXT NULL COMMENT '配偶微信流水结息2' AFTER `mate_wx_jour_interest1`,
CHANGE COLUMN `mate_jour_interest` `mate_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '配偶流水结息1' ,
ADD COLUMN `mate_jour_interest2` MEDIUMTEXT NULL COMMENT '配偶流水结息2' AFTER `mate_jour_interest1`,
CHANGE COLUMN `gua_zfb_jour_interest` `gua_zfb_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '担保人支付宝流水结息1' ,
ADD COLUMN `gua_zfb_jour_interest2` MEDIUMTEXT NULL COMMENT '担保人支付宝流水结息2' AFTER `gua_zfb_jour_interest1`,
CHANGE COLUMN `gua_wx_jour_interest` `gua_wx_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '担保人微信流水结息1' ,
ADD COLUMN `gua_wx_jour_interest2` MEDIUMTEXT NULL COMMENT '担保人微信流水结息2' AFTER `gua_wx_jour_interest1`,
CHANGE COLUMN `gua_jour_interest` `gua_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '担保人流水结息1' ,
ADD COLUMN `gua_jour_interest2` MEDIUMTEXT NULL COMMENT '担保人流水结息2' AFTER `gua_jour_interest1`,
CHANGE COLUMN `zfb_jour_interest` `zfb_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '支付宝流水结息1' ,
ADD COLUMN `zfb_jour_interest2` MEDIUMTEXT NULL COMMENT '支付宝流水结息2' AFTER `zfb_jour_interest1`,
CHANGE COLUMN `wx_jour_interest` `wx_jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '微信流水结息1' ,
ADD COLUMN `wx_jour_interest2` MEDIUMTEXT NULL COMMENT '微信流水结息2' AFTER `wx_jour_interest1`,
CHANGE COLUMN `jour_interest` `jour_interest1` MEDIUMTEXT NULL DEFAULT NULL COMMENT '流水结息1' ,
ADD COLUMN `jour_interest2` MEDIUMTEXT NULL COMMENT '流水结息2' AFTER `jour_interest1`;

SET SQL_SAFE_UPDATES = 0;
update tdq_budget_order b,tsys_biz_log z set b.inside_job = z.operator where b.code = z.ref_order and z.deal_node = '002_01';

update tdq_budget_order set is_gps_az = '0';
update tdq_budget_order b,tdq_budget_order_gps g set b.is_gps_az = '1' where b.code = g.budget_order;

update tdq_budget_order SET is_logistics = '0';
update tdq_budget_order b,tdq_logistics l set b.is_logistics = '1' where b.code = l.biz_code and l.status = '1';
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE `tdq_credit` 
ADD COLUMN `inside_job` varchar(32) NULL COMMENT '内勤' AFTER `note`;

ALTER TABLE `tb_gps_apply` 
ADD COLUMN `customer_name` varchar(255) NULL COMMENT '客户姓名' AFTER `apply_wireless_count`,
ADD COLUMN `mobile` varchar(32) NULL COMMENT '手机号' AFTER `customer_name`,
ADD COLUMN `car_frame_no` varchar(255) NULL COMMENT '车架号' AFTER `mobile`;

DELETE FROM `tsys_node` WHERE `code`='002_06';
UPDATE `tsys_node_flow` SET `next_node`='002_07' WHERE `id`='60';
DELETE FROM `tsys_node_flow` WHERE `id`='10';

ALTER TABLE `tdq_budget_order_gps` 
ADD COLUMN `dev_photos` tinytext NULL COMMENT '设备图片' AFTER `az_user`,
ADD COLUMN `az_photos` tinytext NULL COMMENT '安装图片' AFTER `dev_photos`;


DROP TABLE IF EXISTS `tdq_limu_credit`;
CREATE TABLE `tdq_limu_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务类型',
  `token` varchar(255) DEFAULT NULL COMMENT '标记',
  `found_datetime` datetime DEFAULT NULL COMMENT '查询时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `result` LONGTEXT DEFAULT NULL COMMENT '查询结果',
  `callback_datetime` datetime DEFAULT NULL COMMENT '回调时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `tb_gps_apply` 
ADD COLUMN `budget_order_code` varchar(32) NULL COMMENT '预算单编号' AFTER `apply_wireless_count`;


INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'lmzx_biz_type', '立木征信业务类型', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'identity', '身份证实名认证', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'involvedlistcheck', '涉案列表', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'involveddetailscheck', '涉案详情', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'bankcard4check', '银行卡四要素核验', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'shixin', '失信被执行人查询', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'socialsecurity', '社保查询', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'housefund', '公积金查询', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'jd', '京东查询', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'taobao', '淘宝查询', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'mobileReportTask', '运营商报告结果获取', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_biz_type', 'taobao_report', '电商报告结果获取', 'admin', '2018-06-25 08:24:17', 'CD-HTWT000020', 'CD-HTWT000020');


UPDATE `tsys_config` SET `cvalue`='-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgMEcLIbyOAGxfK+P1\nZi/47tlslJBHujLudBWAr4KhSHWhRANCAASiSJTODFYvLhQ9PxKKr9wsbaNkqw89\nRpefKvJS9iVJ9473r8byj7WmWUHDyEClz3yyb/FOBl6fognJ102zcePG\n-----END PRIVATE KEY-----\n' WHERE `id`='36';
UPDATE `tsys_config` SET `cvalue`='-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEokiUzgxWLy4UPT8Siq/cLG2jZKsP\nPUaXnyryUvYlSfeO96/G8o+1pllBw8hApc98sm/xTgZen6IJyddNs3Hjxg==\n-----END PUBLIC KEY-----\n' WHERE `id`='35';
UPDATE `tsys_config` SET `cvalue`='36862' WHERE `id`='37';
UPDATE `tsys_config` SET `cvalue`='1400144984' WHERE `id`='33';

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','apiUrl','https://api.limuzhengxin.com','admin','2018-08-15 17:33:30','立木征信apiUrl','CD-CWZCD000020','CD-CWZCD000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','apiKey','4268765441801243','admin','2018-08-15 17:33:30','立木征信apiKey','CD-CWZCD000020','CD-CWZCD000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','version','1.2.0','admin','2018-08-15 17:33:30','立木征信version','CD-CWZCD000020','CD-CWZCD000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','apiSecret','oWzX8DM3PnlezJ1AVclYaVgjJxKASwBb','admin','2018-08-15 17:33:30','立木征信apiSecret','CD-CWZCD000020','CD-CWZCD000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','localhostUrl','http://120.26.6.213:2402/xn-htwt','admin','2018-08-15 17:33:30','立木征信localhostUrl',NULL,NULL);

INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'node_type', '011', 'gps资料传递', 'admin', '2018-06-25 08:25:28', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'car_frame_price_count', '车架价格核算', 'admin', '2018-06-25 08:23:27', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'car_frame_price_count', '1', 'http://www.chehang168.com', 'admin', '2018-06-25 08:23:27', 'CD-HTWT000020', 'CD-HTWT000020');

DROP TABLE IF EXISTS `tdq_interview_video_room`;
CREATE TABLE `tdq_interview_video_room` (
  `code` varchar(32) NOT NULL COMMENT '房间编号',
  `hl_url` varchar(255) DEFAULT NULL COMMENT '混流视频下载地址',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tdq_interview_video`;
CREATE TABLE `tdq_interview_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `room_code` varchar(255) DEFAULT NULL COMMENT '房间编号',
  `stream_id` varchar(255) DEFAULT NULL COMMENT '直播码',
  `file_id` varchar(255) DEFAULT NULL COMMENT '视频编号',
  `video_url` varchar(255) DEFAULT NULL COMMENT '点播视频的下载地址',
  `file_size` varchar(255) DEFAULT NULL COMMENT '文件大小',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `file_format` varchar(32) DEFAULT NULL COMMENT '文件格式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `tb_gps` 
ADD COLUMN `customer_name` VARCHAR(255) NULL COMMENT '客户姓名' AFTER `biz_code`;

ALTER TABLE `tdq_limu_credit` 
ADD COLUMN `customer_name` VARCHAR(255) NULL COMMENT '客户姓名' AFTER `user_name`;

INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'lmzx_social_relation', '立木征信电商社会关系', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_social_relation', 'FATHER', '父亲 ', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_social_relation', 'MOTHER', '母亲 ', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_social_relation', 'SPOUSE', '配偶', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_social_relation', 'CHILD', '子女', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_social_relation', 'OTHER_RELATIVE', '其他亲属 ', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_social_relation', 'FRIEND', '朋友 ', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_social_relation', 'COWORKER', '同事', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_social_relation', 'OTHERS', '其他', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');

INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'lmzx_status', '立木征信状态', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_status', '1', '查询中', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'lmzx_status', '2', '查询成功', 'admin', '2018-10-25 09:59:32', 'CD-HTWT000020', 'CD-HTWT000020');

INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262330140403347','大数据管理','1','#','12','USYS201800000000001','2018-10-26 23:31:12','','SM201804241904336827315');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262332326732102','身份证实名核验','1','/credit/idcheck.htm','1','USYS201800000000001','2018-10-26 23:32:32','','SM201810262330140403347');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262333030488384','银行四要素核验','1','/credit/bank4check.htm','2','USYS201800000000001','2018-10-26 23:33:03','','SM201810262330140403347');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262333316533493','京东','1','/credit/jd.htm','3','USYS201800000000001','2018-10-27 00:03:49','','SM201810262330140403347');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262333581253517','运营商','1','/credit/mobile.htm','4','USYS201800000000001','2018-10-26 23:33:58','','SM201810262330140403347');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262334243005783','电商','1','/credit/tbcheck.htm','5','USYS201800000000001','2018-10-26 23:34:24','','SM201810262330140403347');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262335227549520','发起查询','2','/add','1','USYS201800000000001','2018-10-26 23:35:22','','SM201810262332326732102');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262335450112216','详情','2','/detail','2','USYS201800000000001','2018-10-26 23:35:45','','SM201810262332326732102');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262336051478662','发起查询','2','/add','1','USYS201800000000001','2018-10-26 23:36:05','','SM201810262333030488384');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262336183203333','详情','2','/detail','2','USYS201800000000001','2018-10-26 23:36:18','','SM201810262333030488384');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262336428534261','发起查询','2','/add','1','USYS201800000000001','2018-10-26 23:36:42','','SM201810262333316533493');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262336583274912','详情','2','/detail','2','USYS201800000000001','2018-10-26 23:36:58','','SM201810262333316533493');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262337384086399','发起查询','2','/add','1','USYS201800000000001','2018-10-26 23:37:38','','SM201810262333581253517');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262337592869042','详情','2','/detail','2','USYS201800000000001','2018-10-26 23:37:59','','SM201810262333581253517');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262338163812758','发起查询','2','/add','1','USYS201800000000001','2018-10-26 23:38:16','','SM201810262334243005783');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810262338332128523','详情','2','/detail','2','USYS201800000000001','2018-10-26 23:38:33','','SM201810262334243005783');

INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262330140403347','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262332326732102','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262335227549520','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262335450112216','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262333030488384','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262336051478662','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262336183203333','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262333316533493','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262336428534261','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262336583274912','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262333581253517','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262337384086399','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262337592869042','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262334243005783','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262338163812758','USYS201800000000001','2018-10-26 23:39:17',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810262338332128523','USYS201800000000001','2018-10-26 23:39:17',NULL);


ALTER TABLE `tp_archive_location` 
ADD COLUMN `location` VARCHAR(255) NULL COMMENT '位置编号' AFTER `code`;

ALTER TABLE `tdq_budget_order_fee` 
ADD COLUMN `customer_name` varchar(255) NULL COMMENT '客户姓名' AFTER `user_id`;

SET SQL_SAFE_UPDATES = 0;
UPDATE tdq_budget_order_fee f,tdq_budget_order b set f.customer_name = b.apply_user_name where f.budget_order = b.code;
SET SQL_SAFE_UPDATES = 1;




INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809271914229793995','删除','2','/delete','5','USYS201800000000001','2018-09-27 19:14:22','备注','SM201806051430270749521');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809281129084333407','节点材料清单','1','/basedata/materiallist.htm','6','USYS201800000000001','2018-09-28 11:29:08','备注','SM201804301415107007680');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809281129592887604','新增','2','/add','1','USYS201800000000001','2018-09-28 11:29:59','备注','SM201809281129084333407');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809281130199719600','修改','2','/edit','2','USYS201800000000001','2018-09-28 11:30:19','备注','SM201809281129084333407');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809281130423897425','删除','2','/delete','3','USYS201800000000001','2018-09-28 11:30:42','备注','SM201809281129084333407');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809291056410917156','导入','2','/import','99','USYS201800000000001','2018-09-29 11:07:14','备注','SM201806082258364384563');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809291511053446479','风控二审','2','/checkCommissionerTwo','5','USYS201800000000001','2018-09-29 15:11:05','备注','SM201805291013406492370');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809291513092815686','业务总监审核','2','/businessCheck','8','USYS201800000000001','2018-10-10 15:32:48','备注','SM201805291013406492370');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809291635053891748','内勤主管派单','2','/dispatch','2','USYS201800000000001','2018-09-29 16:35:05','备注','SM201805291008583268448');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201809301004051973291','新增','2','/add','1','USYS201800000000001','2018-09-30 10:04:05','备注','SM201804301415439657360');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810081508522461968','银行类别管理','1','/basedata/bankType.htm','5','USYS201800000000001','2018-10-08 15:09:33','基础数据','SM201804301415107007680');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810081510143761682','新增','2','/add','1','USYS201800000000001','2018-10-08 15:10:14','银行类别管理','SM201810081508522461968');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810081510563154417','详情','2','/detail','2','USYS201800000000001','2018-10-08 15:10:56','银行类别管理','SM201810081508522461968');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810081759068475261','修改','2','/edit','2','USYS201800000000001','2018-10-08 17:59:06','','SM201806082258364384563');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810101415345789815','财务垫资','1','/loan/advMoney.htm','2','USYS201800000000001','2018-10-10 14:15:34','车贷财务','SM201806120306549653438');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810111140276954558','大数据','2','/bigData','5','USYS201800000000001','2018-10-11 11:40:27','备注','SM201805291008583268448');
DELETE FROM `tsys_menu` WHERE `code`='SM201805301404545315674';
UPDATE `tsys_menu` SET `order_no`='3' WHERE `code`='SM201806082300058567560';
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810282145146014367','财务确认垫资','2','/edit','1','U201806141609052491026','2018-10-28 21:45:14','','SM201810101415345789815');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201810282145339691164','详情','2','/detail','2','U201806141609052491026','2018-10-28 21:45:33','','SM201810101415345789815');

INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809271914229793995','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809281129084333407','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809281129592887604','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809281130199719600','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809281130423897425','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809291056410917156','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809291511053446479','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809291513092815686','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809291635053891748','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201809301004051973291','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810081508522461968','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810081510143761682','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810081510563154417','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810081759068475261','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810101415345789815','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810111140276954558','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810282145146014367','USYS201800000000001','2018-10-28 13:44:41',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201810282145339691164','USYS201800000000001','2018-10-28 13:44:41',NULL);
	
UPDATE `tsys_menu` SET `name`='风控终审' WHERE `code`='SM201805301403549725902';
UPDATE `tsys_menu` SET `name`='风控一审' WHERE `code`='SM201805301402526871471';
UPDATE `tsys_menu` SET `order_no`='3' WHERE `code`='SM201805301353172967295';
UPDATE `tsys_menu` SET `order_no`='4' WHERE `code`='SM201805301354371318364';
UPDATE `tsys_menu` SET `order_no`='9' WHERE `code`='SM201805301354548731957';
UPDATE `tsys_menu` SET `order_no`='7' WHERE `code`='SM201805301403549725902';
UPDATE `tsys_menu` SET `order_no`='9' WHERE `code`='SM201805301404079981243';
UPDATE `tb_bank` SET `updater`='USYS201800000000001' WHERE `code`='BA201806011006085041799';
UPDATE `tb_bank` SET `updater`='USYS201800000000001' WHERE `code`='BA201809101215201166542';
UPDATE `tsys_menu` SET `order_no`='2' WHERE `code`='SM201804251904256377856';
DELETE FROM `tsys_menu` WHERE `code`='SM201805171816173306551';
DELETE FROM `tsys_menu` WHERE `code`='SM201805171817010037298';
DELETE FROM `tsys_menu` WHERE `code`='SM201805081718535897157';


INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','node_type','012','资料传递','USYS201800000000001','2018-10-28 14:14:21',NULL,NULL,NULL);
INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '001_08');
INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '002_27');
INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '002_28');
INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '008_01');
INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '011_01');
INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '011_02');
INSERT INTO `tsys_role_node` (`role_code`, `node_code`) VALUES ('RO201800000000000001', '011_03');


SET SQL_SAFE_UPDATES = 0;
UPDATE tdq_budget_order b SET b.enter_location='AL201810231847482876866' WHERE b.cur_node_code = '002_23';
UPDATE tdq_budget_order b,tsys_biz_log l SET b.enter_datetime = l.end_datetime where l.parent_order = b.code and l.deal_node = '002_22' and l.status = '1' and b.cur_node_code = '002_23';
UPDATE tb_gps g,tdq_budget_order b SET g.customer_name=b.apply_user_name WHERE g.biz_code=b.code;
UPDATE tdq_budget_order SET cur_node_code='002_07' WHERE cur_node_code = '002_06';
UPDATE tsys_biz_log SET deal_node='002_07' WHERE deal_node = '002_06';
UPDATE tstd_cnavigate SET location='index_banner';
UPDATE tsys_user SET role_code='SR201805301244280427951' WHERE user_id='U201806150132244051603';
UPDATE tsys_user SET role_code='SR201805301244280427951' WHERE user_id='U201806191450138622121';
SET SQL_SAFE_UPDATES = 1;



INSERT INTO `tdq_budget_order` (`code`,`repay_biz_code`,`loan_product_code`,`loan_product_name`,`region`,`loan_bank`,`gps_fee`,`auth_fee`,`other_fee`,`bank_fee`,`company_fee`,`team_fee`,`credit_code`,`biz_type`,`loan_period`,`vehicle_company_name`,`invoice_company`,`car_brand`,`car_series`,`car_model`,`car_model_name`,`car_type`,`car_pic`,`car_hgz_pic`,`drive_license_front`,`drive_license_reverse`,`evaluate_column`,`car_frame_no`,`car_engine_no`,`original_price`,`invoice_price`,`car_color`,`month_deposit`,`first_amount`,`first_rate`,`loan_amount`,`settle_address`,`apply_user_id`,`apply_user_name`,`gender`,`age`,`marry_state`,`political`,`nation`,`education`,`id_kind`,`id_no`,`family_number`,`mobile`,`now_address`,`is_card_mail_address`,`post_code1`,`residence_address`,`post_code2`,`family_main_asset`,`main_asset_include`,`main_income`,`work_company_name`,`work_company_address`,`work_is_card_mail_address`,`work_company_property`,`work_belong_industry`,`work_profession`,`work_datetime`,`self_company_area`,`other_work_note`,`work_asset_pdf`,`employee_quantity`,`enterprise_month_output`,`position`,`post_title`,`month_income`,`mate_name`,`mate_mobile`,`mate_id_no`,`mate_education`,`mate_company_name`,`mate_company_address`,`mate_company_contact_no`,`mate_zfb_jour_datetime_start`,`mate_zfb_jour_datetime_end`,`mate_zfb_jour_interest1`,`mate_zfb_jour_interest2`,`mate_zfb_interest1`,`mate_zfb_interest2`,`mate_zfb_jour_income`,`mate_zfb_jour_expend`,`mate_zfb_jour_balance`,`mate_zfb_jour_month_income`,`mate_zfb_jour_month_expend`,`mate_zfb_jour_pic`,`mate_zfb_jour_remark`,`mate_wx_jour_datetime_start`,`mate_wx_jour_datetime_end`,`mate_wx_jour_interest1`,`mate_wx_jour_interest2`,`mate_wx_interest1`,`mate_wx_interest2`,`mate_wx_jour_income`,`mate_wx_jour_expend`,`mate_wx_jour_balance`,`mate_wx_jour_month_income`,`mate_wx_jour_month_expend`,`mate_wx_jour_pic`,`mate_wx_jour_remark`,`mate_jour_datetime_start`,`mate_jour_datetime_end`,`mate_jour_interest1`,`mate_jour_interest2`,`mate_interest1`,`mate_interest2`,`mate_jour_income`,`mate_jour_expend`,`mate_jour_balance`,`mate_jour_month_income`,`mate_jour_month_expend`,`mate_jour_pic`,`mate_jour_remark`,`mate_asset_pdf`,`gua_name`,`gua_mobile`,`gua_id_no`,`gua_phone`,`gua_company_name`,`gua_company_address`,`gua_house_asset_address`,`gua_zfb_jour_datetime_start`,`gua_zfb_jour_datetime_end`,`gua_zfb_jour_interest1`,`gua_zfb_jour_interest2`,`gua_zfb_interest1`,`gua_zfb_interest2`,`gua_zfb_jour_income`,`gua_zfb_jour_expend`,`gua_zfb_jour_balance`,`gua_zfb_jour_month_income`,`gua_zfb_jour_month_expend`,`gua_zfb_jour_pic`,`gua_zfb_jour_remark`,`gua_wx_jour_datetime_start`,`gua_wx_jour_datetime_end`,`gua_wx_jour_interest1`,`gua_wx_jour_interest2`,`gua_wx_interest1`,`gua_wx_interest2`,`gua_wx_jour_income`,`gua_wx_jour_expend`,`gua_wx_jour_balance`,`gua_wx_jour_month_income`,`gua_wx_jour_month_expend`,`gua_wx_jour_pic`,`gua_wx_jour_remark`,`gua_jour_datetime_start`,`gua_jour_datetime_end`,`gua_jour_interest1`,`gua_jour_interest2`,`gua_interest1`,`gua_interest2`,`gua_jour_income`,`gua_jour_expend`,`gua_jour_balance`,`gua_jour_month_income`,`gua_jour_month_expend`,`gua_jour_pic`,`gua_jour_remark`,`gua_asset_pdf`,`emergency_name1`,`emergency_relation1`,`emergency_mobile1`,`emergency_name2`,`emergency_relation2`,`emergency_mobile2`,`zfb_jour_datetime_start`,`zfb_jour_datetime_end`,`zfb_jour_interest1`,`zfb_jour_interest2`,`zfb_interest1`,`zfb_interest2`,`zfb_jour_income`,`zfb_jour_expend`,`zfb_jour_balance`,`zfb_jour_month_income`,`zfb_jour_month_expend`,`zfb_jour_pic`,`zfb_jour_remark`,`wx_jour_datetime_start`,`wx_jour_datetime_end`,`wx_jour_interest1`,`wx_jour_interest2`,`wx_interest1`,`wx_interest2`,`wx_jour_income`,`wx_jour_expend`,`wx_jour_balance`,`wx_jour_month_income`,`wx_jour_month_expend`,`wx_jour_pic`,`wx_jour_remark`,`jour_datetime_start`,`jour_datetime_end`,`jour_interest1`,`jour_interest2`,`interest1`,`interest2`,`jour_income`,`jour_expend`,`jour_balance`,`jour_month_income`,`jour_month_expend`,`jour_pic`,`jour_remark`,`asset_pdf`,`house_contract`,`house_picture`,`hk_book_pdf`,`id_card_pdf`,`marry_pdf`,`other_pdf`,`is_advance_fund`,`is_financing`,`bank_video`,`bank_photo`,`company_contract`,`bank_contract`,`other_video`,`interview_other_pdf`,`is_interview`,`company_video`,`advance_fund_datetime`,`advance_fund_amount`,`bill_pdf`,`advance_note`,`advance_fund_amount_pdf`,`supplement_note`,`car_settle_datetime`,`car_number`,`car_invoice`,`car_jqx`,`car_syx`,`policy_datetime`,`policy_due_date`,`car_settle_other_pdf`,`car_regcerti`,`car_pd`,`car_key`,`car_big_smj`,`car_xsz_smj`,`duty_paid_prove_smj`,`bank_commit_datetime`,`bank_commit_note`,`bank_fk_datetime`,`repay_bank_code`,`repay_bank_name`,`repay_subbranch`,`repay_bankcard_number`,`repay_bill_date`,`repay_bank_date`,`repay_company_date`,`repay_first_month_amount`,`repay_first_month_datetime`,`repay_month_amount`,`receipt_bank_code`,`receipt_bank_name`,`receipt_bankcard_number`,`receipt_pdf`,`receipt_remark`,`pledge_user`,`pledge_user_id_card_copy`,`pledge_address`,`pledge_datetime`,`car_price_check_report`,`green_big_smj`,`pledge_bank_commit_datetime`,`pledge_bank_commit_note`,`pledge_status`,`enter_location`,`enter_datetime`,`enter_fileList`,`sale_user_id`,`inside_job`,`team_code`,`company_code`,`apply_datetime`,`back_advance_status`,`back_advance_amount`,`back_advance_account`,`back_advance_open_bank`,`back_advance_subbranch`,`back_advance_water_bill`,`cur_node_code`,`intev_cur_node_code`,`advanf_cur_node_code`,`cancel_node_code`,`frozen_status`,`is_gps_az`,`is_logistics`,`remark`) VALUES ('BO201811010327390999958',NULL,'LP201806251457534104597','产品D','1','BA201806011006085041799',600000,0,1000,0,1200,1000,'C201810311508459496343','0','36','12','12','12','1','12','1','1','FmZH_qif2rkvi2WoyjSGXm_ezrWg','FmZH_qif2rkvi2WoyjSGXm_ezrWg',NULL,NULL,'','1','12',12000,12000,'12',270,4000,0.33000000,8000,'12',NULL,'1111','1',1,'1','1','1','1','1','650105196606062121',1,'13000020000','1','1','1','1','1','1','12','1,2,3,4','1','12','1','1','1','',NULL,'','','',NULL,'','','','12000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12','1','13121212121','11','2','13121212121',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','','1','1','FtFORuHPbv9YIdsodMYItrVbxEza','FmZH_qif2rkvi2WoyjSGXm_ezrWg','FmZH_qif2rkvi2WoyjSGXm_ezrWg','FmZH_qif2rkvi2WoyjSGXm_ezrWg','','',NULL,'FtFORuHPbv9YIdsodMYItrVbxEza','2018-11-01 00:00:00',8000,'FmZH_qif2rkvi2WoyjSGXm_ezrWg','0202020202','FmZH_qif2rkvi2WoyjSGXm_ezrWg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'BA201806011006085041799','中国工商银行','新疆工商银行',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11','FmZH_qif2rkvi2WoyjSGXm_ezrWg','11',NULL,'FmZH_qif2rkvi2WoyjSGXm_ezrWg',NULL,NULL,NULL,'0',NULL,NULL,NULL,'U201806131315524345485','U201807122014448971110','BT201807161416460323894','DP201800000000000000001','2018-11-01 03:27:39',NULL,NULL,NULL,NULL,NULL,NULL,'002_10',NULL,'002_10',NULL,NULL,'1','0','');

ALTER TABLE `tdq_interview_video_room` 
ADD COLUMN `budget_code` VARCHAR(32) NULL COMMENT '预算单编号' AFTER `create_datetime`,
ADD COLUMN `status` VARCHAR(4) NULL COMMENT '状态（0可用，1不可用）' AFTER `hl_url`;

ALTER TABLE `tdq_interview_video_room` 
ADD COLUMN `home_owner_id` VARCHAR(32) NULL COMMENT '房主id' AFTER `code`;
