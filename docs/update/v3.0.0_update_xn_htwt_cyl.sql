INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`,
                         `company_code`, `system_code`)
VALUES ('0', NULL, 'guarant_print_template_id', '套打模板', 'USYS201800000000001',
        '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020'),
       ('1', 'guarant_print_template_id', '1', '工行', 'USYS201800000000001', '2018-08-15 17:32:12',
        'CD-CWZCD000020', 'CD-CWZCD000020'),
       ('1', 'guarant_print_template_id', '2', '中行总对总-手续费分期', 'USYS201800000000001',
        '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020'),
       ('1', 'guarant_print_template_id', '3', '中行总对总 手续费一次性', 'USYS201800000000001',
        '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020'),
       ('1', 'guarant_print_template_id', '5', '中行 传统', 'USYS201800000000001',
        '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020'),
       ('1', 'guarant_print_template_id', '8', '中行总对总-附加费', 'USYS201800000000001',
        '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020'),
       ('1', 'guarant_print_template_id', '10', '建设银行-服务费', 'USYS201800000000001',
        '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020'),
       ('1', 'guarant_print_template_id', '11', '建设银行-附加贷', 'USYS201800000000001',
        '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020'),
       ('1', 'guarant_print_template_id', '13', '建设银行-信用+担保', 'USYS201800000000001',
        '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');


CREATE TABLE `tb_insurance_company`
(
  `code`    varchar(32) NOT NULL COMMENT '编号',
  `name`    varchar(255) DEFAULT NULL COMMENT '名称',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系人',
  `mobile`  varchar(32)  DEFAULT NULL COMMENT '联系电话',
  `remark`  varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='保险公司信息表';

INSERT INTO `tb_insurance_company`
VALUES ('IC201809191430007283689', '太平洋保险', '赵菊', '15122222223', '测试');