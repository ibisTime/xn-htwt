DROP TABLE IF EXISTS `tdh_repoint_account`;
CREATE TABLE `tdh_repoint_account`
(
  `code`              varchar(32) NOT NULL COMMENT '编号',
  `repoint_code`      varchar(32)  DEFAULT NULL COMMENT '返点编号',
  `repoint_card_code` varchar(32)  DEFAULT NULL COMMENT '返点账号编号',
  `actual_amount`     bigint(20)   DEFAULT NULL COMMENT '实返金额',
  `water_bill`        text         DEFAULT NULL COMMENT '水单',
  `updater`           varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime`   datetime     DEFAULT NULL COMMENT '更新时间',
  `remark`            varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='返点账号列表';