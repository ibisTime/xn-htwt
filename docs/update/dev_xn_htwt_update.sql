ALTER TABLE `tp_archive` 
DROP COLUMN `is_delete`;

ALTER TABLE `tp_social_relation` 
DROP COLUMN `is_delete`;

ALTER TABLE `tsys_biz_team` 
ADD COLUMN `region` VARCHAR(255) NULL AFTER `water_bill`,
ADD COLUMN `place` VARCHAR(255) NULL AFTER `region`;

CREATE TABLE `tp_business_trip_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user_code` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `job_no` varchar(32) DEFAULT NULL COMMENT '工号',
  `department_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `post_code` varchar(32) DEFAULT NULL COMMENT '职位编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `trip_datetime_start` datetime DEFAULT NULL COMMENT '出差时间起',
  `trip_datetime_end` datetime DEFAULT NULL COMMENT '出差时间止',
  `trip_reason` varchar(255) DEFAULT NULL COMMENT '出差事由',
  `trip_line` varchar(255) DEFAULT NULL COMMENT '出差线路',
  `aircraft_fee_standard` varchar(255) DEFAULT NULL COMMENT '飞机票费用标准',
  `aircraft_days` varchar(255) DEFAULT NULL COMMENT '飞机票天数',
  `aircraft_budget` bigint(20) DEFAULT NULL COMMENT '飞机票预算金额',
  `train_fee_standard` varchar(255) DEFAULT NULL COMMENT '火车票费用标准',
  `train_days` varchar(255) DEFAULT NULL COMMENT '火车票天数',
  `train_budget` bigint(20) DEFAULT NULL COMMENT '火车票预算金额',
  `urban_fee_standart` varchar(255) DEFAULT NULL COMMENT '市内交通费用标准',
  `urban_days` varchar(255) DEFAULT NULL COMMENT '市内交通天数',
  `urban_budget` bigint(20) DEFAULT NULL COMMENT '市内交通预算金额',
  `hotel_cost` bigint(20) DEFAULT NULL COMMENT '住宿费',
  `food_subsidy` bigint(20) DEFAULT NULL COMMENT '伙食补助',
  `entertainment_cost` bigint(20) DEFAULT NULL COMMENT '招待费',
  `other` varchar(255) DEFAULT NULL COMMENT '其他',
  `subtotal` bigint(20) DEFAULT NULL COMMENT '小计',
  `spare_cash` bigint(20) DEFAULT NULL COMMENT '备用金',
  `cost_total` bigint(20) DEFAULT NULL COMMENT '费用合计',
  `department_manager_code` varchar(32) DEFAULT NULL COMMENT '部门主管编号',
  `finance_manager_code` varchar(32) DEFAULT NULL COMMENT '财务主管编号',
  `general_manager_code` varchar(32) DEFAULT NULL COMMENT '总经理编号',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出差申请';

