DROP TABLE IF EXISTS `tdq_credit_jour`;
CREATE TABLE `tdq_credit_jour` (
	`code` varchar(32) NOT NULL COMMENT '编号',
  	`biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
	`credit_user_code` varchar(32) DEFAULT NULL COMMENT '征信人编号',
	`type` varchar(32) DEFAULT NULL COMMENT '类型（微信/支付宝/银行）',
  	`datetime_start` datetime DEFAULT NULL COMMENT '流水时间起',
  	`datetime_end` datetime DEFAULT NULL COMMENT '流水时间止',
  	`jour_interest1` mediumtext COMMENT '流水结息1',
  	`jour_interest2` mediumtext COMMENT '流水结息2',
  	`interest1` bigint(20) DEFAULT NULL COMMENT '结息1',
  	`interest2` bigint(20) DEFAULT NULL COMMENT '结息2',
  	`income` bigint(20) DEFAULT NULL COMMENT '收入',
  	`expend` bigint(20) DEFAULT NULL COMMENT '支出',
  	`balance` bigint(20) DEFAULT NULL COMMENT '帐户余额',
  	`month_income` bigint(20) DEFAULT NULL COMMENT '月均收入',
  	`month_expend` bigint(20) DEFAULT NULL COMMENT '月均支出',
  	`pic` mediumtext COMMENT '流水图片',
  	`remark` mediumtext COMMENT '流水备注',
  	PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征信流水';
