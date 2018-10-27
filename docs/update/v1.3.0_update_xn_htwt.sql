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
  `biz_type` varchar(4) DEFAULT NULL COMMENT '业务类型',
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

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','apiUrl','https://t.limuzhengxin.cn','admin','2018-08-15 17:33:30','立木征信apiUrl','CD-CWZCD000020','CD-CWZCD000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','apiKey','9665866375902170','admin','2018-08-15 17:33:30','立木征信apiKey','CD-CWZCD000020','CD-CWZCD000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','method','api.identity.idcheck','admin','2018-08-15 17:33:30','立木征信method','CD-CWZCD000020','CD-CWZCD000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','version','1.2.0','admin','2018-08-15 17:33:30','立木征信version','CD-CWZCD000020','CD-CWZCD000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','apiSecret','uMryJfeyNPHFtuB52h2BK1muD9JouBha','admin','2018-08-15 17:33:30','立木征信apiSecret','CD-CWZCD000020','CD-CWZCD000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('id_no_authentication','localhostUrl','http://120.26.6.213:2402/xn-htwt','admin','2018-08-15 17:33:30','立木征信localhostUrl',NULL,NULL);

INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'node_type', '011', 'gps资料传递', 'admin', '2018-06-25 08:25:28', 'CD-HTWT000020', 'CD-HTWT000020');
UPDATE `tsys_dict` SET `dvalue`='资料传递' WHERE `id`='918';
DELETE FROM `tsys_dict` WHERE `id`='919';
DELETE FROM `tsys_dict` WHERE `id`='920';
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'car_frame_price_count', '车架价格核算', 'admin', '2018-06-25 08:23:27', 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'car_frame_price_count', '1', 'www.chehang168.com', 'admin', '2018-06-25 08:23:27', 'CD-HTWT000020', 'CD-HTWT000020');

DROP TABLE IF EXISTS `tdq_interview_video_room`;
CREATE TABLE `tdq_interview_video_room` (
  `code` varchar(32) NOT NULL COMMENT '房间编号',
  `hl_url` varchar(255) DEFAULT NULL COMMENT '混流视频下载地址',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

---------------------------------------------------------------------------------------------------------
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
