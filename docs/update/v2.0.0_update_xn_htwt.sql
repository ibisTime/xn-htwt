ALTER TABLE `tdq_credit` 
ADD COLUMN `biz_code` VARCHAR(32) NULL COMMENT '业务编号' AFTER `code`;


ALTER TABLE `tdq_budget_order` 
ADD COLUMN `biz_code` VARCHAR(32) NULL COMMENT '业务编号' AFTER `code`;


insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('a1','新录征信资料','a',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('a2','录入征信结果','a',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('a3','审核征信','a',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('a1x','重录征信资料','a',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('b1','录入准入单资料','b',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('b2','区域总审核准入单','b',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('b3','风控一审准入单','b',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('b4','风控二审准入单','b',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('b5','风控终审准入单','b',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('b6','业务总监审核准入单','b',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('b7','财务总监审核准入单','b',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('b1x','重录准入单','b',NULL);




insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('a','a1','a2',NULL,NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('a','a2','a3',NULL,NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('a','a3','b1','a1x',NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('a','a1x','a2',NULL,NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('b','b1','b2',NULL,NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('b','b2','b3','b1x',NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('b','b3','b4','b1x',NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('b','b4','b5','b1x',NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('b','b5','b6','b1x',NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('b','b6','b7','b1x',NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('b','b7','0','b1x',NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('b','b1x','a2',NULL,NULL,NULL);









insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('0',NULL,'attachment_name','附件名字','admin','2018-06-23 09:19:19',NULL,'CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','a1','二手车报告','admin','2018-06-23 09:19:19','网页','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','a2','行驶证正面','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','a3','行驶证反面','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','z1','主贷人银行征信结果','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','z2','主贷人身份证正面','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','z3','主贷人身份证反面','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','z4','主贷人征信查询授权书','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','z5','主贷人面签照片','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','g1','共还人银行征信结果','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','g2','共还人身份证正面','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','g3','共还人身份证反面','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','g4','共还人征信查询授权书','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','g5','共还人面签照片','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','d1','担保人银行征信结果','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','d2','担保人身份证正面','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','d3','担保人身份证反面','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','d4','担保人征信查询授权书','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','attachment_name','d5','担保人面签照片','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');

insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('0',NULL,'cdbiz_status','业务主状态','admin','2018-06-23 09:19:19',NULL,'CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','cdbiz_status','000','待新录征信信息','admin','2018-06-23 09:19:19','网页','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','cdbiz_status','001','待录入征信单','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','cdbiz_status','002','待风控专员审核征信单','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','cdbiz_status','001x','风控专员审核征信单不通过','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','cdbiz_status','003','待录入准入单','admin','2018-06-23 09:19:19','图片','CD-HTWT000020','CD-HTWT000020');

insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('0',NULL,'mq_status','面签状态','admin','2018-06-23 09:19:19',NULL,'CD-HTWT000020','CD-HTWT000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','mq_status','000','待录入面签信息','admin','2018-06-23 09:19:19',NULL,'CD-HTWT000020','CD-HTWT000020');




CREATE TABLE `dev_xn_htwt`.`tqj_mission` (
  `code` VARCHAR(32) NOT NULL,
  `biz_code` VARCHAR(32) NULL,
  `name` VARCHAR(255) NULL,
  `time` INT NULL,
  `creater` VARCHAR(32) NULL,
  `get_user` VARCHAR(32) NULL,
  `status` VARCHAR(4) NULL,
  `create_datetime` DATETIME NULL,
  `deadline` DATETIME NULL,
  `finish_datetime` DATETIME NULL,
  PRIMARY KEY (`code`));


