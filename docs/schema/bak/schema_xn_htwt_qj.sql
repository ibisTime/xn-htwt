/*全局表脚本*/

DROP TABLE IF EXISTS `tqj_attachment`;
CREATE TABLE `tqj_attachment` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `attach_type` varchar(4) DEFAULT NULL COMMENT '附件类型（主贷人/担保人/共还人工行、同盾、立木）',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件 ';

DROP TABLE IF EXISTS `tqj_biz_task`;
CREATE TABLE `tqj_biz_task` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) NOT NULL COMMENT '业务编号',
  `ref_type` varchar(32) NOT NULL COMMENT '关联订单类型',
  `ref_order` varchar(32) NOT NULL COMMENT '关联订单编号',
  `content` varchar(32) DEFAULT NULL COMMENT '任务内容',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(32) NOT NULL COMMENT '状态(0 待处理 1 已完成)',
  `operater` varchar(32) DEFAULT NULL COMMENT '操作人',
  `operate_role` varchar(32) DEFAULT NULL COMMENT '操作角色',
  `finish_datetime` datetime DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '待办事项表';

CREATE TABLE `tqj_file_pool` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `file_name ` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `file_type` varchar(4) DEFAULT NULL COMMENT '文件类型（图，网页，视频）',
  `number ` INT DEFAULT NULL COMMENT '数量',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源池';

DROP TABLE IF EXISTS `tsys_biz_log`;
CREATE TABLE `tsys_biz_log` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `biz_code` varchar(32) NOT NULL COMMENT '业务编号',
  `ref_type` varchar(32) NOT NULL COMMENT '关联订单类型',
  `ref_order` varchar(32) NOT NULL COMMENT '关联订单编号',
  `deal_node` varchar(32) NOT NULL COMMENT '处理节点',
  `deal_note` varchar(255) DEFAULT NULL COMMENT '处理说明',
  `operate_role` varchar(32) DEFAULT NULL COMMENT '操作角色',
  `operator` varchar(32) DEFAULT NULL COMMENT '操作人',
  `operator_name` varchar(32) DEFAULT NULL COMMENT '操作人姓名',
  `operator_mobile` varchar(32) DEFAULT NULL COMMENT '操作人手机号',
  `start_datetime` datetime NOT NULL COMMENT '操作开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '操作结束时间',
  `speed_time` varchar(255) DEFAULT NULL COMMENT '花费时间(单位：秒)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '操作日志表';
