INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('h3', '制卡完成', 'h');

UPDATE `tsys_dict` SET `dkey`='1' WHERE `id`='821';
UPDATE `tsys_dict` SET `dkey`='0' WHERE `id`='822';


INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g1', '确认用款单', 'g');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g2', '用款一审', 'g');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g3', '用款二审', 'g');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g4', '制单回录', 'g');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g5', '垫资回录', 'g');

INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('g', 'g1', 'g2');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('g', 'g2', 'g3', 'c1');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('g', 'g3', 'g4', 'c1');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('g', 'g4', 'g5');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('g', 'g5', 'c1');

INSERT INTO `tdq_file_list` (`category`, `kname`, `vname`, `attach_type`, `number`) VALUES ('advance', 'advance_bill_pdf', '垫资水单', '图片', '1');

DELETE FROM `tsys_node` WHERE `code`='f7';

UPDATE `tsys_node_flow` SET `next_node`='f8' WHERE `id`='105';
DELETE FROM `tsys_node_flow` WHERE `id`='107';


INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'credit_query', '征信查询', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'credit_query', 'a1', '新录征信资料', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('2', 'credit_query', 'a2', '录入征信结果', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('3', 'credit_query', 'a3', '审核征信', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('4', 'credit_query', 'a1x', '重录征信资料', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'budget_query', '准入查询', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'budget_query', 'b1', '录入准入单资料', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('2', 'budget_query', 'b2', '区域总审核准入单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('3', 'budget_query', 'b3', '风控一审准入单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('4', 'budget_query', 'b4', '风控二审准入单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('5', 'budget_query', 'b5', '风控终审准入单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('6', 'budget_query', 'b6', '业务总监审核准入单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('7', 'budget_query', 'b7', '财务总监审核准入单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('8', 'budget_query', 'b1x', '重录准入单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'make_card_query', '制卡查询', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'make_card_query', 'h1', '制卡申请', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('2', 'make_card_query', 'h2', '回录卡号', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('3', 'make_card_query', 'h3', '制卡完成', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'interview_query', '面签查询', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'interview_query', 'b01', '新录面签信息', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('2', 'interview_query', 'b02', '主管审核面签信息', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('3', 'interview_query', 'b01x', '重录面签信息', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('4', 'interview_query', 'b03', '面签完成', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'advance_query', '垫资查询', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'advance_query', 'g1', '确认用款单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('2', 'advance_query', 'g2', '区域总经理审批', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('3', 'advance_query', 'g3', '省分公司总经理审批', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('4', 'advance_query', 'g4', '确认制单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('5', 'advance_query', 'g5', '上传复核回单', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'fbh_query', '发保合查询', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'fbh_query', 'c1', '新录入发保合', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('2', 'fbh_query', 'c2', '审核发保合', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('3', 'fbh_query', 'c1x', '重录入发保合', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'gps_az_query', 'gps安装查询', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'gps_az_query', 'd1', '安装gps', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('2', 'gps_az_query', 'd2', '审核gps', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('3', 'gps_az_query', 'd3', 'gps审核不通过', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('4', 'gps_az_query', 'd4', 'gps安装完成', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'bank_loan_query', '银行放款查询', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'bank_loan_query', 'e1', '业务员寄送银行放款材料', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('2', 'bank_loan_query', 'e2', '风控审核收件（银行放款）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('3', 'bank_loan_query', 'e1x', '业务员重寄材料（银行放款）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('4', 'bank_loan_query', 'e3', '风控提交银行', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('5', 'bank_loan_query', 'e4', '风控录入银行放款信息', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('6', 'bank_loan_query', 'e5', '财务确认银行收款', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('7', 'bank_loan_query', 'e7', '风控寄送银行放款材料', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('8', 'bank_loan_query', 'e8', '贷后收件（银行放款）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('9', 'bank_loan_query', 'e9', '第一次已收件待存档', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('10', 'bank_loan_query', 'e10', '第一次已存档', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'pledge_query', '车辆抵押查询', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'pledge_query', 'f1', '待业务员确认抵押申请', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('2', 'pledge_query', 'f2', '风控寄抵押合同', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('3', 'pledge_query', 'f3', '业务员审核抵押合同', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('4', 'pledge_query', 'f2x', '风控重寄抵押合同', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('5', 'pledge_query', 'f4', '业务员录入抵押信息', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('6', 'pledge_query', 'f5', '业务员寄送材料（车辆抵押）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('7', 'pledge_query', 'f6', '风控审核收件（车辆抵押）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('8', 'pledge_query', 'f5x', '业务员重寄送材料（车辆抵押）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('9', 'pledge_query', 'f7', '风控审核通过（车辆抵押）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('10', 'pledge_query', 'f8', '银行收件（车辆抵押）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('11', 'pledge_query', 'f9', '提交银行', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('12', 'pledge_query', 'f10', '抵押材料已确认提交', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('13', 'pledge_query', 'f11', '待风控寄件（车辆抵押）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('14', 'pledge_query', 'f12', '待担保公司收件（车辆抵押）', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('15', 'pledge_query', 'f13', '第二次已收件待存档', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('16', 'pledge_query', 'f14', '第二次已存档', 'admin', now(), 'CD-HTWT000020', 'CD-HTWT000020');