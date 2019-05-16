INSERT INTO `tsys_node`
VALUES ('010_01', '提交调查申请', '010', NULL),
       ('010_02', '风控专员审核', '010', NULL),
       ('010_03', '驻行人员审核', '010', NULL),
       ('010_04', '已完成', '010', NULL);

INSERT INTO `tsys_node_flow`
VALUES (52, '010', '010_01', '010_02', NULL, NULL, NULL),
       (53, '010', '010_02', '010_03', '010_01', NULL, NULL),
       (54, '010', '010_03', '010_04', '010_02', NULL, NULL);


INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '011', '待风控审核收件(银行放款)', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '010x', '待业务员重寄材料(银行放款)', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '012', '风控提交银行', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '013', '风控录入银行放款信息', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '014', '财务确认银行收款', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '015', '抵押申请', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '016', '业务员确认抵押申请', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '017', '风控寄抵押合同', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '018', '业务员审核抵押合同', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '019', '业务员录入抵押信息', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '020', '风控重寄抵押合同', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '021', '业务员寄送材料（车辆抵押）', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '022', '风控审核收件（车辆抵押）', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '023', '风控审核通过（车辆抵押）', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '024', '业务员重寄材料（车辆抵押）', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '025', '银行收件（车辆抵押）', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '026', '提交银行', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`,
                         `update_datetime`, `remark`, `company_code`, `system_code`)
VALUES ('1', 'cdbiz_status', '027', '抵押材料已确认提交', 'admin', '2019-05-04 13:58:44', '图片',
        'CD-HTWT000020', 'CD-HTWT000020');



INSERT INTO `tsys_node`
VALUES ('003_01', '还款中', '003', NULL),
       ('003_02', '清欠催收部审核', '003', NULL),
       ('003_03', '驻行人员审核	', '003', NULL),
       ('003_04', '总经理审核', '003', NULL),
       ('003_05', '财务审核', '003', NULL),
       ('003_06', '解除抵押', '003', NULL),
       ('003_07', '已完成', '003', NULL),
       ('003_08', '清欠催收部申请拖车', '003', NULL),
       ('003_09', '财务打款', '003', NULL),
       ('003_10', '清欠催收部拖车', '003', NULL),
       ('003_11', '清欠催收部已拖车', '003', NULL),
       ('003_12', '待用户赎回', '003', NULL),
       ('003_13', '司法诉讼', '003', NULL),
       ('003_14', '坏账', '003', NULL),
       ('003_15', '业务团队买断', '003', NULL),
       ('003_16', '业务团队租赁', '003', NULL),
       ('003_17', '清欠催收部申请赎回', '003', NULL),
       ('003_18', '风控主管审核', '003', NULL),
       ('003_19', '财务经理审核', '003', NULL),
       ('003_20', '提前还款审核', '003', NULL);

INSERT INTO `tsys_node_flow`
VALUES (27, '003', '003_02', '003_03', NULL, NULL, NULL),
       (28, '003', '003_03', '003_04', '003_02', NULL, NULL),
       (29, '003', '003_04', '003_05', '003_02', NULL, NULL),
       (30, '003', '003_05', '003_06', '003_02', NULL, NULL),
       (31, '003', '003_06', '003_07', NULL, NULL, NULL),
       (32, '003', '003_08', '003_09', NULL, NULL, NULL),
       (33, '003', '003_09', '003_10', NULL, NULL, NULL),
       (34, '003', '003_10', '003_11', NULL, NULL, NULL),
       (35, '003', '003_11', '003_17', '003_13', NULL, NULL),
       (36, '003', '003_17', '003_18', NULL, NULL, NULL),
       (37, '003', '003_18', '003_19', '003_17', NULL, NULL),
       (38, '003', '003_19', NULL, '003_18', NULL, NULL),
       (73, '003', '003_20', '003_02', '003_01', NULL, NULL);