--
-- Table structure for table `tb_bank`
--

DROP TABLE IF EXISTS `tb_bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_bank` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `mechanism_abb` varchar(255) DEFAULT NULL COMMENT '贷款机构简称',
  `bank_full_name` varchar(255) DEFAULT NULL COMMENT '银行全称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '支行名称',
  `mobile` varchar(32) DEFAULT NULL COMMENT '电话',
  `rate12` decimal(18,8) DEFAULT NULL COMMENT '12期',
  `rate18` decimal(18,8) DEFAULT NULL COMMENT '18期',
  `rate24` decimal(18,8) DEFAULT NULL COMMENT '24期',
  `rate36` decimal(18,8) DEFAULT NULL COMMENT '36期',
  `zk_rate12` decimal(18,8) DEFAULT NULL COMMENT '直客12期',
  `zk_rate18` decimal(18,8) DEFAULT NULL COMMENT '直客18期',
  `zk_rate24` decimal(18,8) DEFAULT NULL COMMENT '直客24期',
  `zk_rate36` decimal(18,8) DEFAULT NULL COMMENT '直客36期',
  `address` varchar(255) DEFAULT NULL COMMENT '银行地址',
  `phone_number` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `post_code` varchar(32) DEFAULT NULL COMMENT '邮编',
  `bank_client` varchar(255) DEFAULT NULL COMMENT '银行委托人',
  `client_valid_date` varchar(255) DEFAULT NULL COMMENT '委托有效期',
  `auther_name` varchar(255) DEFAULT NULL COMMENT '授权人姓名',
  `auther_phone_number` varchar(32) DEFAULT NULL COMMENT '授权人电话',
  `auther_id_no` varchar(255) DEFAULT NULL COMMENT '授权人身份证',
  `auther_address` varchar(255) DEFAULT NULL COMMENT '授权人地址',
  `credit_card_type` varchar(4) DEFAULT NULL COMMENT '信用卡类型',
  `credit_card_name` varchar(255) DEFAULT NULL COMMENT '信用卡名称',
  `belong_area` varchar(255) DEFAULT NULL COMMENT '所属地区',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 已下架 1 已上架)',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台银行信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_car_dealer`
--

DROP TABLE IF EXISTS `tb_car_dealer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_car_dealer` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `full_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `abbr_name` varchar(255) DEFAULT NULL COMMENT '简称',
  `is_self_develop` varchar(1) DEFAULT NULL COMMENT '是否自主开发',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `car_dealer_type` varchar(4) DEFAULT NULL COMMENT '车行经营性质',
  `main_contact` varchar(255) DEFAULT NULL COMMENT '主要联系人',
  `contact_phone` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `main_brand` varchar(255) DEFAULT NULL COMMENT '主营品牌',
  `parent_group` varchar(255) DEFAULT NULL COMMENT '所属集团',
  `agreement_valid_date_start` datetime DEFAULT NULL COMMENT '合作协议有效期起',
  `agreement_valid_date_end` datetime DEFAULT NULL COMMENT '合作协议有效期止',
  `agreement_status` varchar(4) DEFAULT NULL COMMENT '协议状态',
  `agreement_pic` varchar(255) DEFAULT NULL COMMENT '车商合作协议',
  `settle_way` varchar(255) DEFAULT NULL COMMENT '结算方式(1现结2月结3季结)',
  `business_area` varchar(255) DEFAULT NULL COMMENT '业务区域',
  `belong_branch_company` varchar(255) DEFAULT NULL COMMENT '归属分公司',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
  `policy_note` varchar(255) DEFAULT NULL COMMENT '政策说明',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `approve_note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经销商信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_collect_bankcard`
--

DROP TABLE IF EXISTS `tb_collect_bankcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_collect_bankcard` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(1 普通账户 2 经销商的收款账号 3 经销商返点账号)',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `belong_bank` varchar(32) DEFAULT NULL COMMENT '三种银行',
  `real_name` varchar(255) DEFAULT NULL COMMENT '户名',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `bankcard_number` varchar(255) DEFAULT NULL COMMENT '账号',
  `point_rate` decimal(18,8) DEFAULT NULL COMMENT '返点比例',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收款账号表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_gps`
--

DROP TABLE IF EXISTS `tb_gps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_gps` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `gps_dev_no` varchar(32) NOT NULL COMMENT 'gps编号',
  `gps_type` varchar(32) NOT NULL COMMENT 'gps类型( 1 有线 0 无线)',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申领人',
  `apply_status` varchar(32) DEFAULT NULL COMMENT '申领状态(0 待申领 1 已申领)',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申领日期',
  `apply_code` varchar(32) DEFAULT NULL COMMENT '申领编号',
  `use_status` varchar(32) DEFAULT NULL COMMENT '使用状态(0 待使用 1 已使用)',
  `use_datetime` datetime DEFAULT NULL COMMENT '使用日期',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='gps库存管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_gps_apply`
--

DROP TABLE IF EXISTS `tb_gps_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_gps_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(1 公司 2 个人)',
  `apply_type` varchar(4) DEFAULT NULL COMMENT '申请类型(1 本部 2 分部)',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请日期',
  `apply_reason` varchar(255) DEFAULT NULL COMMENT '申请原因',
  `apply_count` int(11) DEFAULT NULL COMMENT '申请个数',
  `apply_wired_count` int(11) DEFAULT NULL COMMENT '申请有线个数',
  `apply_wireless_count` int(11) DEFAULT NULL COMMENT '申请无线个数',
  `budget_order_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `car_frame_no` varchar(255) DEFAULT NULL COMMENT '车架号',
  `send_datetime` datetime DEFAULT NULL COMMENT '发货日期',
  `receive_datetime` datetime DEFAULT NULL COMMENT '收货日期',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  `inside_job` varchar(32) DEFAULT NULL COMMENT '团队内勤',
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '信贷专员',
  `operator` varchar(32) DEFAULT NULL COMMENT '操作人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0 待审核 1 审核通过,待发货 2 审核不通过 3 已发货,待收货 4 已收货)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='gps申领管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_insurance_company`
--

DROP TABLE IF EXISTS `tb_insurance_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_insurance_company` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保险公司信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbf_withhold`
--

DROP TABLE IF EXISTS `tbf_withhold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbf_withhold` (
  `trans_id` varchar(32) NOT NULL COMMENT '商户订单号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编码',
  `bankcard_number` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `trans_amount` bigint(32) DEFAULT NULL COMMENT '代扣金额',
  `ref_no` varchar(32) DEFAULT NULL COMMENT '关联订单号',
  `resp_code` varchar(32) DEFAULT NULL COMMENT '应答码',
  `resp_msg` varchar(255) DEFAULT NULL COMMENT '应答信息',
  `member_id` varchar(32) DEFAULT NULL COMMENT '商户号',
  `terminal_id` varchar(32) DEFAULT NULL COMMENT '终端号',
  `txn_type` varchar(32) DEFAULT NULL COMMENT '交易类型',
  `txn_sub_type` varchar(32) DEFAULT NULL COMMENT '交易子类',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '接入类型',
  `trade_date` datetime DEFAULT NULL COMMENT '订单发送时间',
  `trans_no` varchar(32) DEFAULT NULL COMMENT '宝付交易号',
  `succ_amt` bigint(32) DEFAULT NULL COMMENT '成功金额',
  `trans_serial_no` varchar(32) DEFAULT NULL COMMENT '商户流水号',
  PRIMARY KEY (`trans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdh_cost`
--

DROP TABLE IF EXISTS `tdh_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdh_cost` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_plan_code` varchar(32) DEFAULT NULL COMMENT '还款计划编号',
  `item` varchar(255) DEFAULT NULL COMMENT '费用项名称',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `pay_datetime` datetime DEFAULT NULL COMMENT '发生时间',
  `pay_way` varchar(255) DEFAULT NULL COMMENT '发生付款方式',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `repay_datetime` datetime DEFAULT NULL COMMENT '执行时间',
  `repay_way` varchar(255) DEFAULT NULL COMMENT '执行付款方式',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdh_overdue_menu`
--

DROP TABLE IF EXISTS `tdh_overdue_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdh_overdue_menu` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `id_no` varchar(32) DEFAULT NULL COMMENT '证件号',
  `loan_bank_name` varchar(255) DEFAULT NULL COMMENT '贷款银行名称',
  `loan_amount` bigint(11) DEFAULT NULL COMMENT '贷款金额',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `remain_amount` bigint(11) DEFAULT NULL COMMENT '剩余金额',
  `fk_datetime` datetime DEFAULT NULL COMMENT '放款日期',
  `overdue_amount` bigint(11) DEFAULT NULL COMMENT '逾期金额',
  `overdue_datetime` datetime DEFAULT NULL COMMENT '逾期日期',
  `import_datetime` datetime DEFAULT NULL COMMENT '导入日期',
  `import_note` varchar(255) DEFAULT NULL COMMENT '导入说明',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 待处理 1 已处理)',
  `handle_datetime` datetime DEFAULT NULL COMMENT '处理日期',
  `handle_note` varchar(255) DEFAULT NULL COMMENT '处理说明',
  `budget_order_code` varchar(32) DEFAULT NULL COMMENT '准入单编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `repay_plan_code` varchar(32) DEFAULT NULL COMMENT '还款计划编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导入逾期名单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdh_overdue_repay`
--

DROP TABLE IF EXISTS `tdh_overdue_repay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdh_overdue_repay` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `overdue_code` varchar(32) DEFAULT NULL COMMENT '逾期名单编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='逾期名单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdh_remind_log`
--

DROP TABLE IF EXISTS `tdh_remind_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdh_remind_log` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_plan_code` varchar(32) DEFAULT NULL COMMENT '还款计划编号',
  `way` varchar(255) DEFAULT NULL COMMENT '催收方式',
  `to_user` varchar(255) DEFAULT NULL COMMENT '催收对象姓名',
  `content` text COMMENT '催收文本',
  `create_datetime` datetime DEFAULT NULL COMMENT '催收时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdh_repay_biz`
--

DROP TABLE IF EXISTS `tdh_repay_biz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdh_repay_biz` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `loan_product_code` varchar(32) DEFAULT NULL COMMENT '贷款产品编号',
  `loan_product_name` varchar(64) DEFAULT NULL COMMENT '贷款产品名称',
  `user_id` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `id_kind` varchar(32) DEFAULT NULL COMMENT '证件号类型',
  `id_no` varchar(32) DEFAULT NULL COMMENT '证件号编号',
  `bankcard_code` varchar(32) DEFAULT NULL COMMENT '还款卡编号',
  `ref_type` varchar(4) DEFAULT NULL COMMENT '关联类型(0=商品，1=车贷)',
  `ref_code` varchar(32) DEFAULT NULL COMMENT '关联编号',
  `biz_price` bigint(20) DEFAULT NULL COMMENT '业务总价',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `sf_amount` varchar(20) DEFAULT NULL COMMENT '首付金额',
  `loan_bank` varchar(32) DEFAULT NULL COMMENT '贷款银行',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `rest_periods` int(11) DEFAULT NULL COMMENT '剩余期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `bank_benchmark_rate` decimal(18,8) DEFAULT NULL,
  `company_loan_cs` decimal(18,8) DEFAULT NULL COMMENT '我司贷款成数',
  `global_rate` decimal(18,8) DEFAULT NULL COMMENT '综合利率',
  `loan_start_datetime` datetime DEFAULT NULL COMMENT '贷款时间起点',
  `loan_end_datetime` datetime DEFAULT NULL COMMENT '贷款时间终点',
  `bank_fk_datetime` datetime DEFAULT NULL COMMENT '银行放款时间',
  `fx_deposit` bigint(20) DEFAULT NULL COMMENT '风险保证金',
  `first_repay_datetime` datetime DEFAULT NULL COMMENT '首期还款日期',
  `first_repay_amount` bigint(20) DEFAULT NULL COMMENT '首期月供金额',
  `month_datetime` int(11) DEFAULT NULL COMMENT '每期还款日期',
  `month_amount` bigint(20) DEFAULT NULL COMMENT '每期月供金额',
  `ly_deposit` bigint(20) DEFAULT NULL COMMENT '履约保证金（可退）',
  `cut_ly_deposit` bigint(20) DEFAULT NULL COMMENT '扣除的履约保证金',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
  `fx_amount` bigint(20) DEFAULT NULL COMMENT '担保风险金',
  `rest_amount` bigint(20) DEFAULT NULL COMMENT '剩余欠款',
  `rest_total_cost` bigint(20) DEFAULT NULL COMMENT '未还清收总成本',
  `overdue_total_deposit` bigint(20) DEFAULT NULL COMMENT '再次逾期保证金总额',
  `overdue_total_deposit_income` bigint(20) DEFAULT NULL COMMENT '再次逾期保证金总收入',
  `total_in_deposit` bigint(20) DEFAULT NULL COMMENT '额外保证金收入',
  `overdue_amount` bigint(20) DEFAULT NULL COMMENT '逾期总金额',
  `total_overdue_count` int(11) DEFAULT NULL COMMENT '累计逾期期数',
  `cur_overdue_count` int(11) DEFAULT NULL COMMENT '实际逾期期数',
  `black_handle_note` text COMMENT '黑名单处理结果备案',
  `paper_photo` tinytext COMMENT '纸质申请照片',
  `is_advance_settled` varchar(255) DEFAULT NULL COMMENT '是否提前结清(0=正常结清 1=提前结清)',
  `settle_attach` varchar(255) DEFAULT NULL COMMENT '结清证明',
  `settle_datetime` datetime DEFAULT NULL COMMENT '结清时间',
  `release_datetime` datetime DEFAULT NULL COMMENT '解除抵押时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdh_repay_plan`
--

DROP TABLE IF EXISTS `tdh_repay_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdh_repay_plan` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `ref_type` varchar(32) DEFAULT NULL COMMENT '类型',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '借款人编号',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `cur_periods` int(11) DEFAULT NULL COMMENT '当前期数',
  `repay_datetime` datetime DEFAULT NULL COMMENT '还款时间',
  `repay_capital` bigint(20) DEFAULT NULL COMMENT '本期本金',
  `repay_interest` bigint(20) DEFAULT NULL COMMENT '本期利息',
  `repay_amount` bigint(20) DEFAULT NULL COMMENT '还款金额',
  `payed_amount` bigint(20) DEFAULT NULL COMMENT '已还金额',
  `overplus_amount` bigint(20) DEFAULT NULL COMMENT '剩余欠款',
  `overdue_amount` bigint(20) DEFAULT NULL COMMENT '逾期金额',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点',
  `prepay_photo` tinytext COMMENT '还款截图',
  `overdue_handler` varchar(255) DEFAULT NULL COMMENT '逾期处理人',
  `overdue_handle_datetime` datetime DEFAULT NULL COMMENT '逾期处理时间',
  `overdue_handle_note` text COMMENT '逾期处理说明',
  `total_fee` bigint(20) DEFAULT NULL COMMENT '清收费用总额',
  `payed_fee` bigint(20) DEFAULT NULL COMMENT '已缴纳清收费用总额',
  `overdue_deposit` bigint(20) DEFAULT NULL COMMENT '再次逾期保证金',
  `deposit_way` varchar(255) DEFAULT NULL COMMENT '再次逾期保证金收取方式',
  `should_deposit` bigint(20) DEFAULT NULL COMMENT '实际可退的再次逾期保证金',
  `remind_count` int(11) DEFAULT NULL COMMENT '已催款次数',
  `real_repay_amount` bigint(20) DEFAULT NULL COMMENT '实际代偿金额',
  `is_repay` varchar(4) DEFAULT NULL COMMENT '代偿是否缴纳',
  `ts_car_amount` bigint(20) DEFAULT NULL COMMENT '拖车申请金额',
  `ts_bankcard_number` varchar(255) DEFAULT NULL COMMENT '拖车收款账号',
  `ts_bank_name` varchar(255) DEFAULT NULL COMMENT '拖车开户行',
  `ts_subbranch` varchar(255) DEFAULT NULL COMMENT '拖车开户支行',
  `tc_apply_note` varchar(255) DEFAULT NULL COMMENT '拖车申请说明',
  `remit_amount` bigint(20) DEFAULT NULL COMMENT '打款金额',
  `remit_bill_pdf` varchar(255) DEFAULT NULL COMMENT '打款水单',
  `take_car_address` varchar(255) DEFAULT NULL COMMENT '收车地点',
  `take_datetime` datetime DEFAULT NULL COMMENT '拖车时间',
  `take_name` varchar(255) DEFAULT NULL COMMENT '拖车人员',
  `take_location` varchar(255) DEFAULT NULL COMMENT '拖车停放位置',
  `take_note` varchar(255) DEFAULT NULL COMMENT '拖车说明',
  `jour_pdf` varchar(255) DEFAULT NULL COMMENT '流水',
  `house_pdf` varchar(255) DEFAULT NULL COMMENT '房产',
  `gua_name` varchar(255) DEFAULT NULL COMMENT '担保人姓名',
  `gua_id_no` varchar(255) DEFAULT NULL COMMENT '担保人身份证号',
  `gua_mobile` varchar(255) DEFAULT NULL COMMENT '担保人手机号',
  `gua_now_address` varchar(255) DEFAULT NULL COMMENT '担保人现居住地址',
  `gua_note` varchar(255) DEFAULT NULL COMMENT '担保赎回说明',
  `suggest` varchar(255) DEFAULT NULL COMMENT '建议(1=6个月保证金/2=已结清)',
  `suggest_note` varchar(255) DEFAULT NULL COMMENT '建议说明',
  `buy_out_amount` bigint(20) DEFAULT NULL COMMENT '团队买断扣除金额',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdh_repoint`
--

DROP TABLE IF EXISTS `tdh_repoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdh_repoint` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  `captain` varchar(32) DEFAULT NULL,
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `should_amount` bigint(20) DEFAULT NULL COMMENT '应返金额',
  `actual_amount` bigint(20) DEFAULT NULL COMMENT '实返金额',
  `account_no` varchar(255) DEFAULT NULL COMMENT '收款账号',
  `bank` varchar(255) DEFAULT NULL COMMENT '收款银行',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '收款支行',
  `water_bill` varchar(255) DEFAULT NULL COMMENT '水单',
  `status` char(1) DEFAULT NULL COMMENT '状态（0待返点 1已返点）',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='返点表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_advance`
--

DROP TABLE IF EXISTS `tdq_advance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_advance` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
  `type` varchar(4) DEFAULT NULL COMMENT '1总公司业务 2分公司业务',
  `back_advance_status` varchar(32) DEFAULT NULL COMMENT '退客户垫资款状态',
  `back_advance_fund_type` varchar(32) DEFAULT NULL COMMENT '收回垫资款类型（1客户作废2垫资款退回）',
  `advance_fund_datetime` datetime DEFAULT NULL COMMENT '垫资日期',
  `advance_fund_amount` bigint(20) DEFAULT NULL COMMENT '垫资金额',
  `total_advance_fund_code` varchar(32) DEFAULT NULL COMMENT '垫资汇总单编号(分公司业务才有)',
  `bill_pdf` tinytext COMMENT '水单',
  `advance_note` varchar(255) DEFAULT NULL COMMENT '垫资说明',
  `back_advance_amount` bigint(20) DEFAULT NULL COMMENT '退客户垫资款 退款金额',
  `back_advance_account` varchar(32) DEFAULT NULL COMMENT '退客户垫资款 收款账号',
  `back_advance_open_bank` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 开户行',
  `back_advance_subbranch` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 开户支行',
  `back_advance_water_bill` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 水单',
  `use_amount` bigint(20) DEFAULT NULL COMMENT '用款金额(应退按揭款)',
  `fund_source` varchar(4) DEFAULT NULL COMMENT '金额来源(1财务部2预支款)',
  `make_bill_note` varchar(255) DEFAULT NULL COMMENT '制单意见说明',
  `cancel_reason` varchar(255) DEFAULT NULL COMMENT '撤销理由',
  `pay_back_datetime` datetime DEFAULT NULL COMMENT '付款时间',
  `pay_back_bankcard_code` varchar(255) DEFAULT NULL COMMENT '付款银行',
  `pay_back_bill_pdf` varchar(255) DEFAULT NULL COMMENT '付款凭证',
  `advance_card_code` varchar(32) DEFAULT NULL COMMENT '垫资账号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='财务垫资';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_bank_loan`
--

DROP TABLE IF EXISTS `tdq_bank_loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_bank_loan` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
  `repay_bank_code` varchar(32) DEFAULT NULL COMMENT '还款卡银行编号',
  `repay_bank_name` varchar(255) DEFAULT NULL COMMENT '还款卡银行名称',
  `repay_subbranch` varchar(255) DEFAULT NULL COMMENT '还款卡开户支行',
  `repay_bankcard_number` varchar(255) DEFAULT NULL COMMENT '还款卡银行卡号',
  `receipt_bank_code` varchar(255) DEFAULT NULL COMMENT '收款银行编号',
  `receipt_bank_name` varchar(255) DEFAULT NULL COMMENT '收款银行名称',
  `receipt_subbranch` varchar(255) DEFAULT NULL COMMENT '收款银行支行',
  `receipt_bankcard_number` varchar(255) DEFAULT NULL COMMENT '收款银行卡号',
  `bank_commit_datetime` datetime DEFAULT NULL COMMENT '银行提交时间',
  `bank_commit_note` varchar(255) DEFAULT NULL COMMENT '银行提交说明',
  `bank_fk_datetime` datetime DEFAULT NULL COMMENT '银行放款时间',
  `repay_bill_date` int(11) DEFAULT NULL COMMENT '银行账单日',
  `repay_bank_date` int(11) DEFAULT NULL COMMENT '银行还款日',
  `repay_company_date` int(11) DEFAULT NULL COMMENT '公司还款日',
  `receipt_pdf` varchar(255) DEFAULT NULL COMMENT '收款凭证',
  `receipt_remark` varchar(255) DEFAULT NULL COMMENT '收款备注',
  `bank_fk_send_datetime` datetime DEFAULT NULL COMMENT '银行放款进件时间',
  `has_loan_list_pic` varchar(255) DEFAULT NULL COMMENT '已放款名单',
  `bank_fk_amount` bigint(20) DEFAULT NULL COMMENT '银行放款金额',
  `month_amount` bigint(20) DEFAULT NULL COMMENT '月还款额',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行放款';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_budget_order`
--

DROP TABLE IF EXISTS `tdq_budget_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_budget_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `loan_product_code` varchar(32) DEFAULT NULL COMMENT '贷款产品编号',
  `loan_product_name` tinytext COMMENT '贷款产品名称',
  `region` tinytext COMMENT '所属区域',
  `loan_bank` tinytext COMMENT '贷款银行',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS费用',
  `auth_fee` bigint(20) DEFAULT NULL COMMENT '公证费',
  `other_fee` bigint(20) DEFAULT NULL COMMENT '其他费用',
  `bank_fee` bigint(20) DEFAULT NULL COMMENT '银行服务费',
  `company_fee` bigint(20) DEFAULT NULL COMMENT '公司服务费',
  `team_fee` bigint(20) DEFAULT NULL COMMENT '团队服务费',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '征信单编号',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务种类',
  `loan_period` varchar(32) DEFAULT NULL COMMENT '贷款期限',
  `vehicle_company_name` varchar(255) DEFAULT NULL COMMENT '机动车销售公司',
  `invoice_company` tinytext COMMENT '开票单位',
  `car_brand` tinytext COMMENT '品牌',
  `car_series` tinytext COMMENT '车系',
  `car_model` tinytext COMMENT '车型',
  `car_model_name` varchar(255) DEFAULT NULL COMMENT '车型名称',
  `car_type` tinytext COMMENT '车辆类型',
  `car_pic` mediumtext COMMENT '车辆照片',
  `car_hgz_pic` mediumtext COMMENT '合格证',
  `drive_license_front` tinytext COMMENT '行驶证正面',
  `drive_license_reverse` tinytext COMMENT '行驶证反面',
  `evaluate_column` text COMMENT '评估栏',
  `car_frame_no` tinytext COMMENT '车架号',
  `car_engine_no` tinytext COMMENT '发动机号',
  `original_price` bigint(20) DEFAULT NULL COMMENT '市场指导价',
  `invoice_price` bigint(20) DEFAULT NULL COMMENT '开票价',
  `car_color` tinytext COMMENT '颜色',
  `month_deposit` bigint(20) DEFAULT NULL COMMENT '月供保证金',
  `first_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `first_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款额',
  `settle_address` tinytext COMMENT '落户地点',
  `apply_user_id` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_user_name` tinytext COMMENT '申请人姓名',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `marry_state` mediumtext COMMENT '婚姻状况',
  `political` varchar(255) DEFAULT NULL COMMENT '政治面貌',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `education` varchar(255) DEFAULT NULL COMMENT '学历',
  `id_kind` varchar(32) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `family_number` int(11) DEFAULT NULL COMMENT '家庭人口',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `is_card_mail_address` varchar(255) DEFAULT NULL COMMENT '是否卡邮寄地址',
  `post_code1` varchar(255) DEFAULT NULL COMMENT '邮编1',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户口所在地',
  `post_code2` varchar(255) DEFAULT NULL COMMENT '邮编2',
  `family_main_asset` mediumtext COMMENT '家庭主要财产',
  `main_asset_include` mediumtext COMMENT '主要财产包括',
  `main_income` mediumtext COMMENT '主要收入来源',
  `work_company_name` tinytext COMMENT '工作单位名称',
  `work_company_address` tinytext COMMENT '工作单位地址',
  `work_is_card_mail_address` tinytext COMMENT '是否卡邮寄地址',
  `work_company_property` tinytext COMMENT '单位性质',
  `work_belong_industry` tinytext COMMENT '所属行业',
  `work_profession` tinytext COMMENT '职业',
  `work_datetime` tinytext COMMENT '何时进入现单位工作',
  `self_company_area` tinytext COMMENT '自营公司单位面积',
  `other_work_note` mediumtext COMMENT '其他工作描述',
  `work_asset_pdf` mediumtext COMMENT '工作资料上传',
  `employee_quantity` int(11) DEFAULT NULL COMMENT '员工数量',
  `enterprise_month_output` tinytext COMMENT '企业月产值',
  `position` tinytext COMMENT '职位',
  `post_title` tinytext COMMENT '职称',
  `month_income` tinytext COMMENT '月收入',
  `mate_name` tinytext COMMENT '配偶姓名',
  `mate_mobile` tinytext COMMENT '配偶手机号',
  `mate_id_no` tinytext COMMENT '配偶身份证号',
  `mate_education` tinytext COMMENT '配偶学历',
  `mate_company_name` tinytext COMMENT '配偶工作单位名称',
  `mate_company_address` tinytext COMMENT '配偶工作单位地址',
  `mate_company_contact_no` tinytext COMMENT '配偶工作单位联系电话',
  `mate_zfb_jour_datetime_start` datetime DEFAULT NULL COMMENT '配偶支付宝流水时间起',
  `mate_zfb_jour_datetime_end` datetime DEFAULT NULL COMMENT '配偶支付宝流水时间止',
  `mate_zfb_jour_interest1` mediumtext COMMENT '配偶支付宝流水结息1',
  `mate_zfb_jour_interest2` mediumtext COMMENT '配偶支付宝流水结息2',
  `mate_zfb_interest1` bigint(20) DEFAULT NULL COMMENT '配偶支付宝结息1',
  `mate_zfb_interest2` bigint(20) DEFAULT NULL COMMENT '配偶支付宝结息2',
  `mate_zfb_jour_income` bigint(20) DEFAULT NULL COMMENT '配偶支付宝收入',
  `mate_zfb_jour_expend` bigint(20) DEFAULT NULL COMMENT '配偶支付宝支出',
  `mate_zfb_jour_balance` bigint(20) DEFAULT NULL COMMENT '配偶支付宝帐户余额',
  `mate_zfb_jour_month_income` bigint(20) DEFAULT NULL COMMENT '配偶支付宝月均收入',
  `mate_zfb_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '配偶支付宝月均支出',
  `mate_zfb_jour_pic` mediumtext COMMENT '配偶支付宝流水图片',
  `mate_zfb_jour_remark` mediumtext COMMENT '配偶支付宝流水备注',
  `mate_wx_jour_datetime_start` datetime DEFAULT NULL COMMENT '配偶微信流水时间起',
  `mate_wx_jour_datetime_end` datetime DEFAULT NULL COMMENT '配偶微信流水时间止',
  `mate_wx_jour_interest1` mediumtext COMMENT '配偶微信流水结息1',
  `mate_wx_jour_interest2` mediumtext COMMENT '配偶微信流水结息2',
  `mate_wx_interest1` bigint(20) DEFAULT NULL COMMENT '配偶微信结息1',
  `mate_wx_interest2` bigint(20) DEFAULT NULL COMMENT '配偶微信结息2',
  `mate_wx_jour_income` bigint(20) DEFAULT NULL COMMENT '配偶微信收入',
  `mate_wx_jour_expend` bigint(20) DEFAULT NULL COMMENT '配偶微信支出',
  `mate_wx_jour_balance` bigint(20) DEFAULT NULL COMMENT '配偶微信帐户余额',
  `mate_wx_jour_month_income` bigint(20) DEFAULT NULL COMMENT '配偶微信月均收入',
  `mate_wx_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '配偶微信月均支出',
  `mate_wx_jour_pic` mediumtext COMMENT '配偶微信流水图片',
  `mate_wx_jour_remark` mediumtext COMMENT '配偶微信流水备注',
  `mate_jour_datetime_start` datetime DEFAULT NULL COMMENT '配偶流水时间起',
  `mate_jour_datetime_end` datetime DEFAULT NULL COMMENT '配偶流水时间止',
  `mate_jour_interest1` mediumtext COMMENT '配偶流水结息1',
  `mate_jour_interest2` mediumtext COMMENT '配偶流水结息2',
  `mate_interest1` bigint(20) DEFAULT NULL COMMENT '配偶结息1',
  `mate_interest2` bigint(20) DEFAULT NULL COMMENT '配偶结息2',
  `mate_jour_income` bigint(20) DEFAULT NULL COMMENT '配偶收入',
  `mate_jour_expend` bigint(20) DEFAULT NULL COMMENT '配偶支出',
  `mate_jour_balance` bigint(20) DEFAULT NULL COMMENT '配偶帐户余额',
  `mate_jour_month_income` bigint(20) DEFAULT NULL COMMENT '配偶月均收入',
  `mate_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '配偶月均支出',
  `mate_jour_pic` mediumtext COMMENT '配偶流水图片',
  `mate_jour_remark` mediumtext COMMENT '配偶流水备注',
  `mate_asset_pdf` mediumtext COMMENT '配偶资产资料pdf',
  `gua_name` tinytext COMMENT '担保人姓名',
  `gua_mobile` tinytext COMMENT '担保人手机号',
  `gua_id_no` tinytext COMMENT '担保人身份证号',
  `gua_phone` tinytext COMMENT '担保人固定电话',
  `gua_company_name` tinytext COMMENT '担保人工作单位名称',
  `gua_company_address` tinytext COMMENT '担保人工作单位地址',
  `gua_house_asset_address` tinytext COMMENT '担保人房产地址',
  `gua_zfb_jour_datetime_start` datetime DEFAULT NULL COMMENT '担保人支付宝流水时间起',
  `gua_zfb_jour_datetime_end` datetime DEFAULT NULL COMMENT '担保人支付宝流水时间止',
  `gua_zfb_jour_interest1` mediumtext COMMENT '担保人支付宝流水结息1',
  `gua_zfb_jour_interest2` mediumtext COMMENT '担保人支付宝流水结息2',
  `gua_zfb_interest1` bigint(20) DEFAULT NULL COMMENT '担保人支付宝结息1',
  `gua_zfb_interest2` bigint(20) DEFAULT NULL COMMENT '担保人支付宝结息2',
  `gua_zfb_jour_income` bigint(20) DEFAULT NULL COMMENT '担保人支付宝收入',
  `gua_zfb_jour_expend` bigint(20) DEFAULT NULL COMMENT '担保人支付宝支出',
  `gua_zfb_jour_balance` bigint(20) DEFAULT NULL COMMENT '担保人支付宝帐户余额',
  `gua_zfb_jour_month_income` bigint(20) DEFAULT NULL COMMENT '担保人支付宝月均收入',
  `gua_zfb_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '担保人支付宝月均支出',
  `gua_zfb_jour_pic` mediumtext COMMENT '担保人支付宝流水图片',
  `gua_zfb_jour_remark` mediumtext COMMENT '担保人支付宝流水备注',
  `gua_wx_jour_datetime_start` datetime DEFAULT NULL COMMENT '担保人微信流水时间起',
  `gua_wx_jour_datetime_end` datetime DEFAULT NULL COMMENT '担保人微信流水时间止',
  `gua_wx_jour_interest1` mediumtext COMMENT '担保人微信流水结息1',
  `gua_wx_jour_interest2` mediumtext COMMENT '担保人微信流水结息2',
  `gua_wx_interest1` bigint(20) DEFAULT NULL COMMENT '担保人微信结息1',
  `gua_wx_interest2` bigint(20) DEFAULT NULL COMMENT '担保人微信结息2',
  `gua_wx_jour_income` bigint(20) DEFAULT NULL COMMENT '担保人微信收入',
  `gua_wx_jour_expend` bigint(20) DEFAULT NULL COMMENT '担保人微信支出',
  `gua_wx_jour_balance` bigint(20) DEFAULT NULL COMMENT '担保人微信帐户余额',
  `gua_wx_jour_month_income` bigint(20) DEFAULT NULL COMMENT '担保人微信月均收入',
  `gua_wx_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '担保人微信月均支出',
  `gua_wx_jour_pic` mediumtext COMMENT '担保人微信流水图片',
  `gua_wx_jour_remark` mediumtext COMMENT '担保人微信流水备注',
  `gua_jour_datetime_start` datetime DEFAULT NULL COMMENT '担保人流水时间起',
  `gua_jour_datetime_end` datetime DEFAULT NULL COMMENT '担保人流水时间止',
  `gua_jour_interest1` mediumtext COMMENT '担保人流水结息1',
  `gua_jour_interest2` mediumtext COMMENT '担保人流水结息2',
  `gua_interest1` bigint(20) DEFAULT NULL COMMENT '担保人结息1',
  `gua_interest2` bigint(20) DEFAULT NULL COMMENT '担保人结息2',
  `gua_jour_income` bigint(20) DEFAULT NULL COMMENT '担保人收入',
  `gua_jour_expend` bigint(20) DEFAULT NULL COMMENT '担保人支出',
  `gua_jour_balance` bigint(20) DEFAULT NULL COMMENT '担保人帐户余额',
  `gua_jour_month_income` bigint(20) DEFAULT NULL COMMENT '担保人月均收入',
  `gua_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '担保人月均支出',
  `gua_jour_pic` mediumtext COMMENT '担保人流水图片',
  `gua_jour_remark` mediumtext COMMENT '担保人流水备注',
  `gua_asset_pdf` mediumtext COMMENT '担保人资产资料pdf',
  `emergency_name1` tinytext COMMENT '家庭紧急联系人信息1 姓名',
  `emergency_relation1` tinytext COMMENT '家庭紧急联系人信息1 与申请人关系',
  `emergency_mobile1` tinytext COMMENT '家庭紧急联系人信息1 手机号码',
  `emergency_name2` tinytext COMMENT '家庭紧急联系人信息2 姓名',
  `emergency_relation2` tinytext COMMENT '家庭紧急联系人信息2 与申请人关系',
  `emergency_mobile2` tinytext COMMENT '家庭紧急联系人信息2 手机号码',
  `zfb_jour_datetime_start` datetime DEFAULT NULL COMMENT '支付宝流水时间起',
  `zfb_jour_datetime_end` datetime DEFAULT NULL COMMENT '支付宝流水时间止',
  `zfb_jour_interest1` mediumtext COMMENT '支付宝流水结息1',
  `zfb_jour_interest2` mediumtext COMMENT '支付宝流水结息2',
  `zfb_interest1` bigint(20) DEFAULT NULL COMMENT '支付宝结息1',
  `zfb_interest2` bigint(20) DEFAULT NULL COMMENT '支付宝结息2',
  `zfb_jour_income` bigint(20) DEFAULT NULL COMMENT '支付宝收入',
  `zfb_jour_expend` bigint(20) DEFAULT NULL COMMENT '支付宝支出',
  `zfb_jour_balance` bigint(20) DEFAULT NULL COMMENT '支付宝帐户余额',
  `zfb_jour_month_income` bigint(20) DEFAULT NULL COMMENT '支付宝月均收入',
  `zfb_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '支付宝月均支出',
  `zfb_jour_pic` mediumtext COMMENT '支付宝流水图片',
  `zfb_jour_remark` mediumtext COMMENT '支付宝流水备注',
  `wx_jour_datetime_start` datetime DEFAULT NULL COMMENT '微信流水时间起',
  `wx_jour_datetime_end` datetime DEFAULT NULL COMMENT '微信流水时间止',
  `wx_jour_interest1` mediumtext COMMENT '微信流水结息1',
  `wx_jour_interest2` mediumtext COMMENT '微信流水结息2',
  `wx_interest1` bigint(20) DEFAULT NULL COMMENT '微信结息1',
  `wx_interest2` bigint(20) DEFAULT NULL COMMENT '微信结息2',
  `wx_jour_income` bigint(20) DEFAULT NULL COMMENT '微信收入',
  `wx_jour_expend` bigint(20) DEFAULT NULL COMMENT '微信支出',
  `wx_jour_balance` bigint(20) DEFAULT NULL COMMENT '微信帐户余额',
  `wx_jour_month_income` bigint(20) DEFAULT NULL COMMENT '微信月均收入',
  `wx_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '微信月均支出',
  `wx_jour_pic` mediumtext COMMENT '微信流水图片',
  `wx_jour_remark` mediumtext COMMENT '微信流水备注',
  `jour_datetime_start` datetime DEFAULT NULL COMMENT '流水时间起',
  `jour_datetime_end` datetime DEFAULT NULL COMMENT '流水时间止',
  `jour_interest1` mediumtext COMMENT '流水结息1',
  `jour_interest2` mediumtext COMMENT '流水结息2',
  `interest1` bigint(20) DEFAULT NULL COMMENT '结息1',
  `interest2` bigint(20) DEFAULT NULL COMMENT '结息2',
  `jour_income` bigint(20) DEFAULT NULL COMMENT '收入',
  `jour_expend` bigint(20) DEFAULT NULL COMMENT '支出',
  `jour_balance` bigint(20) DEFAULT NULL COMMENT '帐户余额',
  `jour_month_income` bigint(20) DEFAULT NULL COMMENT '月均收入',
  `jour_month_expend` bigint(20) DEFAULT NULL COMMENT '月均支出',
  `jour_pic` mediumtext COMMENT '流水图片',
  `jour_remark` mediumtext COMMENT '流水备注',
  `asset_pdf` mediumtext COMMENT '资产资料pdf',
  `house_contract` mediumtext COMMENT '购房合同',
  `house_picture` mediumtext COMMENT '房屋照片',
  `hk_book_pdf` mediumtext COMMENT '户口本资料',
  `id_card_pdf` mediumtext COMMENT '身份证资料',
  `marry_pdf` mediumtext COMMENT '结婚证资料',
  `other_pdf` mediumtext COMMENT '其他资料',
  `is_advance_fund` varchar(32) DEFAULT NULL COMMENT '是否垫资',
  `is_financing` varchar(4) DEFAULT NULL COMMENT '是否融资',
  `bank_video` text COMMENT '银行视频',
  `bank_photo` text COMMENT '银行面签照片',
  `company_contract` text COMMENT '公司合同',
  `bank_contract` text COMMENT '银行合同',
  `other_video` text COMMENT '其他视频',
  `interview_other_pdf` text COMMENT '面签其他资料',
  `is_interview` varchar(4) DEFAULT NULL COMMENT '是否面签完成',
  `is_entryMortgage` varchar(4) DEFAULT NULL COMMENT '是否录入发保合',
  `company_video` text COMMENT '公司视频',
  `advance_fund_datetime` datetime DEFAULT NULL COMMENT '垫资日期',
  `advance_fund_amount` bigint(20) DEFAULT NULL COMMENT '垫资金额',
  `bill_pdf` mediumtext COMMENT '水单',
  `advance_note` mediumtext COMMENT '垫资说明',
  `advance_fund_amount_pdf` mediumtext COMMENT '资金划转授权书',
  `supplement_note` tinytext COMMENT '补充说明',
  `car_settle_datetime` datetime DEFAULT NULL COMMENT '车辆落户日期',
  `car_number` tinytext COMMENT '车牌号',
  `car_invoice` tinytext COMMENT '车辆发票',
  `car_jqx` mediumtext COMMENT '交强险',
  `car_syx` mediumtext COMMENT '商业险',
  `policy_datetime` datetime DEFAULT NULL COMMENT '保单日期',
  `policy_due_date` datetime DEFAULT NULL COMMENT '保单到期日',
  `car_settle_other_pdf` mediumtext COMMENT '其他资料',
  `car_regcerti` mediumtext COMMENT '登记证书',
  `car_pd` mediumtext COMMENT '车辆批单',
  `car_key` mediumtext COMMENT '车钥匙',
  `car_big_smj` mediumtext COMMENT '大本扫描件',
  `car_xsz_smj` tinytext COMMENT '车辆行驶证扫描件',
  `duty_paid_prove_smj` tinytext COMMENT '完税证明扫描件',
  `bank_commit_datetime` datetime DEFAULT NULL COMMENT '银行提交时间',
  `bank_commit_note` mediumtext COMMENT '银行提交说明',
  `is_mortgage` varchar(4) DEFAULT NULL COMMENT '是否抵押完成',
  `bank_fk_datetime` datetime DEFAULT NULL COMMENT '银行放款时间',
  `repay_bank_code` varchar(32) DEFAULT NULL COMMENT '还款卡银行编号',
  `repay_bank_name` tinytext COMMENT '还款卡银行名称',
  `repay_subbranch` tinytext COMMENT '还款卡开户支行',
  `repay_bankcard_number` tinytext COMMENT '还款卡银行卡号',
  `repay_bill_date` int(11) DEFAULT NULL COMMENT '银行账单日',
  `repay_bank_date` int(11) DEFAULT NULL COMMENT '银行还款日',
  `repay_company_date` int(11) DEFAULT NULL COMMENT '公司还款日',
  `repay_first_month_amount` bigint(20) DEFAULT NULL COMMENT '首期月供金额',
  `repay_first_month_datetime` datetime DEFAULT NULL COMMENT '首期还款日期',
  `repay_month_amount` bigint(20) DEFAULT NULL COMMENT '每期月供金额',
  `receipt_bank_code` tinytext COMMENT '收款银行编号',
  `receipt_bank_name` tinytext COMMENT '收款银行名称',
  `receipt_bankcard_number` tinytext COMMENT '收款银行卡号',
  `receipt_pdf` mediumtext COMMENT '收款凭证',
  `receipt_remark` mediumtext COMMENT '收款备注',
  `pledge_user` tinytext COMMENT '代理人',
  `pledge_user_id_card_copy` text COMMENT '代理人身份证复印件',
  `pledge_address` tinytext COMMENT '抵押地点',
  `pledge_datetime` datetime DEFAULT NULL COMMENT '抵押日期',
  `car_price_check_report` varchar(255) DEFAULT NULL COMMENT '车辆价格核实报告',
  `green_big_smj` mediumtext COMMENT '绿大本扫描件',
  `pledge_bank_commit_datetime` datetime DEFAULT NULL COMMENT '抵押提交银行时间',
  `pledge_bank_commit_note` mediumtext COMMENT '抵押提交说明',
  `pledge_status` varchar(4) DEFAULT NULL COMMENT '抵押情况（1是，0否）',
  `enter_location` varchar(255) DEFAULT NULL COMMENT '入档位置',
  `enter_datetime` datetime DEFAULT NULL COMMENT '入档日期',
  `enter_fileList` mediumtext COMMENT '入档清单',
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `inside_job` varchar(32) DEFAULT NULL COMMENT '内勤',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `back_advance_status` char(1) DEFAULT NULL COMMENT '退客户垫资款状态（0无需退款 1银行已放款待财务退款 2财务已退垫资款）',
  `back_advance_amount` bigint(20) DEFAULT NULL COMMENT '退客户垫资款 退款金额',
  `back_advance_account` varchar(32) DEFAULT NULL COMMENT '退客户垫资款 收款账号',
  `back_advance_open_bank` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 开户行',
  `back_advance_subbranch` varchar(255) DEFAULT NULL COMMENT '退客户垫资款 开户支行',
  `back_advance_water_bill` mediumtext COMMENT '退客户垫资款 水单',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
  `intev_cur_node_code` varchar(32) DEFAULT NULL COMMENT '面签节点编号',
  `advanf_cur_node_code` varchar(32) DEFAULT NULL COMMENT '垫资节点编号',
  `cancel_node_code` varchar(32) DEFAULT NULL COMMENT '客户申请作废时的节点编号',
  `frozen_status` char(1) DEFAULT NULL COMMENT '冻结状态 （0冻结 1正常）',
  `is_gps_az` varchar(4) DEFAULT NULL COMMENT '是否安装了GPS',
  `is_logistics` varchar(4) DEFAULT NULL COMMENT '是否是资料传递中',
  `remark` mediumtext COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='准入单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_budget_order_fee`
--

DROP TABLE IF EXISTS `tdq_budget_order_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_budget_order_fee` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `should_amount` bigint(20) DEFAULT NULL COMMENT '应收手续费总额',
  `real_amount` bigint(20) DEFAULT NULL COMMENT '实收手续费总额',
  `is_settled` varchar(32) DEFAULT NULL COMMENT '是否已结清(0 待结清 1 已结清)',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `budget_order` varchar(32) NOT NULL COMMENT '预算单编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_budget_order_fee_detail`
--

DROP TABLE IF EXISTS `tdq_budget_order_fee_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_budget_order_fee_detail` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `remit_type` varchar(32) NOT NULL COMMENT '交款类型',
  `plat_bankcard` varchar(32) DEFAULT NULL COMMENT '平台账号',
  `remit_project` varchar(255) DEFAULT NULL COMMENT '交款项目',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `remit_user` varchar(255) DEFAULT NULL COMMENT '汇款人',
  `reach_datetime` datetime DEFAULT NULL COMMENT '到账时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(32) NOT NULL COMMENT '备注',
  `fee_code` varchar(32) NOT NULL COMMENT '手续费编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_budget_order_gps`
--

DROP TABLE IF EXISTS `tdq_budget_order_gps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_budget_order_gps` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `gps_dev_no` varchar(32) DEFAULT NULL COMMENT 'gps设备号',
  `gps_type` varchar(32) DEFAULT NULL COMMENT 'gps类型',
  `az_location` varchar(32) DEFAULT NULL COMMENT '安装位置',
  `az_datetime` datetime DEFAULT NULL COMMENT '安装时间',
  `az_user` varchar(255) DEFAULT NULL COMMENT '安装人员',
  `dev_photos` tinytext COMMENT '设备图片',
  `az_photos` tinytext COMMENT '安装图片',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `budget_order` varchar(32) NOT NULL COMMENT '预算单编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_car_info`
--

DROP TABLE IF EXISTS `tdq_car_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_car_info` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `car_brand` varchar(64) DEFAULT NULL COMMENT '车辆品牌',
  `car_series` varchar(64) DEFAULT NULL COMMENT '车系',
  `car_model` varchar(64) DEFAULT NULL COMMENT '车型',
  `car_model_name` varchar(64) DEFAULT NULL COMMENT '车型名称',
  `car_type` varchar(4) DEFAULT NULL COMMENT '车辆类型',
  `car_color` varchar(64) DEFAULT NULL COMMENT '颜色',
  `car_frame_no` varchar(64) DEFAULT NULL COMMENT '车架号',
  `car_engine_no` varchar(64) DEFAULT NULL COMMENT '发动机号',
  `original_price` bigint(20) DEFAULT NULL COMMENT '市场指导价',
  `invoice_price` bigint(20) DEFAULT NULL COMMENT '开票价',
  `vehicle_company_name` varchar(64) DEFAULT NULL COMMENT '机动车销售公司',
  `invoice_company` varchar(64) DEFAULT NULL COMMENT '开票单位',
  `region` varchar(64) DEFAULT NULL COMMENT '所属区域',
  `evaluate_column` varchar(255) DEFAULT NULL COMMENT '评估栏',
  `settle_address` varchar(255) DEFAULT NULL COMMENT '所属区域',
  `policy_datetime` datetime DEFAULT NULL COMMENT '保单日期',
  `policy_due_date` datetime DEFAULT NULL COMMENT '保单到期日',
  `car_dealer_code` varchar(32) DEFAULT NULL COMMENT '汽车经销商编号',
  `out_car_dealer_name` varchar(64) DEFAULT NULL COMMENT '汽车经销商名称（外单）',
  `shop_way` varchar(32) DEFAULT NULL COMMENT '购车途径',
  `commerce_insurance` varchar(32) DEFAULT NULL COMMENT '商业险合计',
  `guarantee_contract_code` varchar(32) DEFAULT NULL COMMENT '担保合同编号',
  `bank_contract_code` varchar(32) DEFAULT NULL COMMENT '银行合同编号',
  `contract_sign_date` datetime DEFAULT NULL COMMENT '合同签订日',
  `reg_certificate_code` varchar(32) DEFAULT NULL COMMENT '登记证书号',
  `second_odometer` varchar(255) DEFAULT NULL COMMENT '里程表',
  `check_approve_link` varchar(255) DEFAULT NULL COMMENT '核准链接',
  `check_approve_software` varchar(255) DEFAULT NULL COMMENT '核准软件',
  `information_source` varchar(64) DEFAULT NULL COMMENT '信息源',
  `valuation` bigint(20) DEFAULT NULL COMMENT '评估价',
  `car_168_price` bigint(20) DEFAULT NULL COMMENT '车行168车价',
  `second_number` varchar(64) DEFAULT NULL COMMENT '铭牌',
  `is_right_invoice` varchar(4) DEFAULT NULL COMMENT '发票是否正确',
  `current_invoice_price` bigint(20) DEFAULT NULL COMMENT '现发票价',
  `green_big_code` varchar(32) DEFAULT NULL COMMENT '绿大本编号',
  `car_number` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `car_settle_datetime` datetime DEFAULT NULL COMMENT '车辆落户日期',
  `car_dealer_subsidy` double DEFAULT NULL COMMENT '汽车经销商厂家贴息',
  `oil_subsidy` bigint(20) DEFAULT NULL COMMENT '油补',
  `oil_subsidy_kil` double DEFAULT NULL COMMENT '油补公里数',
  `gps_deduct` bigint(20) DEFAULT NULL COMMENT 'GPS提成',
  `gps_fee_way` varchar(4) DEFAULT NULL COMMENT 'GPS收费方式（1转账2按揭款3返点4不收费）',
  `gps_fee` bigint(20) DEFAULT NULL,
  `auth_fee` bigint(20) DEFAULT NULL,
  `other_fee` bigint(20) DEFAULT NULL,
  `company_fee` bigint(20) DEFAULT NULL,
  `team_fee` bigint(20) DEFAULT NULL,
  `bank_fee` bigint(20) DEFAULT NULL COMMENT '银行服务费',
  `month_deposit` bigint(20) DEFAULT NULL COMMENT '月供保证金',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_car_pledge`
--

DROP TABLE IF EXISTS `tdq_car_pledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_car_pledge` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
  `pledge_user` varchar(32) DEFAULT NULL COMMENT '代理人',
  `pledge_user_id_card` tinytext COMMENT '代理人身份证复印件',
  `pledge_address` varchar(255) DEFAULT NULL COMMENT '抵押地点',
  `pledge_datetime` datetime DEFAULT NULL COMMENT '抵押日期',
  `pledge_bank_commit_datetime` datetime DEFAULT NULL COMMENT '抵押提交银行时间',
  `pledge_bank_commit_note` varchar(255) DEFAULT NULL COMMENT '抵押提交说明',
  `pledge_supplement_note` varchar(255) DEFAULT NULL COMMENT '车辆抵押补充说明',
  `pledge_contract_code` varchar(255) DEFAULT NULL COMMENT '抵押合同编号',
  `pledge_print_template_id` varchar(255) DEFAULT NULL COMMENT '抵押套打模板',
  `pledge_print_user` varchar(255) DEFAULT NULL COMMENT '抵押打印人',
  `pledge_print_datetime` datetime DEFAULT NULL COMMENT '抵押打印日期',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆抵押';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_credit`
--

DROP TABLE IF EXISTS `tdq_credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_credit` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `loan_bank_code` varchar(32) DEFAULT NULL COMMENT '贷款银行编号',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `biz_type` varchar(4) DEFAULT NULL COMMENT '业务种类',
  `second_car_report` varchar(255) DEFAULT NULL COMMENT '二手车评估报告',
  `xsz_front` varchar(255) DEFAULT NULL,
  `xsz_reverse` varchar(255) DEFAULT NULL,
  `budget_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司',
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
  `note` varchar(255) DEFAULT NULL COMMENT '征信说明',
  `inside_job` varchar(32) DEFAULT NULL COMMENT '内勤',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人(录入征信结果的驻行人员)',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_credit_jour`
--

DROP TABLE IF EXISTS `tdq_credit_jour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_credit_user`
--

DROP TABLE IF EXISTS `tdq_credit_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_credit_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `relation` varchar(255) DEFAULT NULL COMMENT '与借款人关系',
  `loan_role` varchar(255) DEFAULT NULL COMMENT '贷款角色',
  `user_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `english_name` varchar(32) DEFAULT NULL COMMENT '英文名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `id_kind` varchar(4) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `authref` varchar(64) DEFAULT NULL COMMENT '发证机关',
  `statdate` varchar(64) DEFAULT NULL COMMENT '证件有效期',
  `credit_card_occupation` double DEFAULT NULL COMMENT '信用卡占比',
  `bank_credit_result` varchar(4) DEFAULT NULL COMMENT '银行征信结果说明',
  `bank_credit_result_remark` varchar(255) DEFAULT NULL,
  `gender` varchar(4) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `political` varchar(4) DEFAULT NULL COMMENT '政治面貌',
  `nation` varchar(4) DEFAULT NULL COMMENT '民族',
  `education` varchar(32) DEFAULT NULL COMMENT '学历',
  `work_profession` varchar(32) DEFAULT NULL COMMENT '职业',
  `post_title` varchar(32) DEFAULT NULL COMMENT '职称',
  `customer_birth` varchar(32) DEFAULT NULL COMMENT '客户生日',
  `car_type` varchar(255) DEFAULT NULL COMMENT '现有车辆类型',
  `is_drice_license` varchar(4) DEFAULT NULL COMMENT '有无驾照',
  `main_income` varchar(255) DEFAULT NULL COMMENT '主要收入来源',
  `other_income_note` varchar(255) DEFAULT NULL COMMENT '其他收入说明',
  `is_house_property` varchar(4) DEFAULT NULL COMMENT '房产证情况',
  `emergency_name1` varchar(32) DEFAULT NULL COMMENT '联系人1姓名',
  `emergency_sex1` varchar(8) DEFAULT NULL COMMENT '联系人1性别',
  `emergency_relation1` varchar(4) DEFAULT NULL COMMENT '联系人1与申请人关系',
  `emergency_mobile1` varchar(32) DEFAULT NULL COMMENT '联系人1手机号码',
  `emergency_name2` varchar(32) DEFAULT NULL COMMENT '联系人2姓名',
  `emergency_sex2` varchar(8) DEFAULT NULL COMMENT '联系人2性别',
  `emergency_relation2` varchar(4) DEFAULT NULL COMMENT '联系人2与申请人关系',
  `emergency_mobile2` varchar(32) DEFAULT NULL COMMENT '联系人2手机号码',
  `work_belong_industry` varchar(32) DEFAULT NULL COMMENT '所属行业',
  `work_company_property` varchar(32) DEFAULT NULL COMMENT '单位性质',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位名称',
  `company_province` varchar(255) DEFAULT NULL COMMENT '单位所在省',
  `company_city` varchar(255) DEFAULT NULL COMMENT '单位所在市',
  `company_area` varchar(255) DEFAULT NULL COMMENT '单位所在区域',
  `company_address` varchar(255) DEFAULT NULL COMMENT '工作单位地址',
  `company_contact_no` varchar(32) DEFAULT NULL COMMENT '工作单位联系电话',
  `work_datetime` varchar(32) DEFAULT NULL COMMENT '何时进入现单位工作',
  `position` varchar(32) DEFAULT NULL COMMENT '职位',
  `employee_quantity` varchar(32) DEFAULT NULL COMMENT '员工数量',
  `enterprise_month_output` varchar(32) DEFAULT NULL COMMENT '企业月产值',
  `month_income` bigint(20) DEFAULT NULL COMMENT '月收入',
  `other_work_note` varchar(255) DEFAULT NULL COMMENT '工作描述及还款来源分析（已确定）',
  `marry_state` varchar(4) DEFAULT NULL COMMENT '婚姻状况',
  `family_number` int(11) DEFAULT '0' COMMENT '家庭人口',
  `family_phone` varchar(32) DEFAULT NULL COMMENT '家庭电话',
  `family_main_asset` varchar(255) DEFAULT NULL COMMENT '家庭主要财产',
  `main_asset_include` varchar(255) DEFAULT NULL COMMENT '主要财产包括',
  `birth_address_province` varchar(32) DEFAULT NULL COMMENT '户籍地省',
  `birth_address_city` varchar(32) DEFAULT NULL COMMENT '户籍地市',
  `birth_address_area` varchar(32) DEFAULT NULL COMMENT '户籍地区',
  `birth_address` varchar(255) DEFAULT NULL COMMENT '户籍地详细地址',
  `birth_post_code` varchar(32) DEFAULT NULL COMMENT '户口所在地邮编',
  `now_house_type` varchar(4) DEFAULT NULL COMMENT '现住房屋类型',
  `now_address_province` varchar(32) DEFAULT NULL COMMENT '现住地址省',
  `now_address_city` varchar(32) DEFAULT NULL COMMENT '现住地址市',
  `now_address_area` varchar(32) DEFAULT NULL COMMENT '现住地址区',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `now_address_date` varchar(64) DEFAULT NULL,
  `now_post_code` varchar(32) DEFAULT NULL COMMENT '现居住地址邮编',
  `icbank_code` varchar(32) DEFAULT NULL COMMENT '工行征信编号',
  `result` varchar(50) DEFAULT NULL,
  `loan_crdt` varchar(255) DEFAULT NULL,
  `card_crdt` varchar(255) DEFAULT NULL,
  `left_num` bigint(20) DEFAULT NULL,
  `left_amount` bigint(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_credit_user_bak`
--

DROP TABLE IF EXISTS `tdq_credit_user_bak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_credit_user_bak` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '征信业务编号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `relation` varchar(255) DEFAULT NULL COMMENT '与借款人关系',
  `loan_role` varchar(255) DEFAULT NULL COMMENT '贷款角色',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `id_kind` varchar(4) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `id_no_front` varchar(255) DEFAULT NULL COMMENT '身份证正面',
  `id_no_reverse` varchar(255) DEFAULT NULL COMMENT '身份证反面',
  `education` varchar(32) DEFAULT NULL COMMENT '学历',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位名称',
  `company_address` varchar(255) DEFAULT NULL COMMENT '工作单位地址',
  `company_contact_no` varchar(32) DEFAULT NULL COMMENT '工作单位联系电话',
  `asset_pdf` tinytext COMMENT '资产资料pdf',
  `house_asset_address` varchar(255) DEFAULT NULL COMMENT '房产地址',
  `hkb` tinytext COMMENT '户口本',
  `birth_address_province` varchar(32) DEFAULT NULL COMMENT '户籍地省',
  `birth_address_city` varchar(32) DEFAULT NULL COMMENT '户籍地市',
  `birth_address_area` varchar(32) DEFAULT NULL COMMENT '户籍地区',
  `birth_address` varchar(255) DEFAULT NULL COMMENT '户籍地详细地址',
  `post_code` varchar(32) DEFAULT NULL COMMENT '户口所在地邮编',
  `auth_pdf` varchar(255) DEFAULT NULL COMMENT '征信查询授权书',
  `interview_pic` varchar(255) DEFAULT NULL COMMENT '面签照片',
  `house_picture` varchar(32) DEFAULT NULL COMMENT '家访照片',
  `credit_card_occupation` double DEFAULT NULL COMMENT '信用卡占比',
  `bank_credit_result` varchar(4) DEFAULT NULL COMMENT '银行征信结果说明',
  `bank_credit_result_remark` varchar(255) DEFAULT NULL,
  `bank_report` varchar(255) DEFAULT NULL,
  `data_report` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_credit_user_ext`
--

DROP TABLE IF EXISTS `tdq_credit_user_ext`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_credit_user_ext` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `credit_user_code` varchar(32) DEFAULT NULL COMMENT '征信人编号',
  `gender` varchar(4) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `marry_state` varchar(4) DEFAULT NULL COMMENT '婚姻状况',
  `political` varchar(4) DEFAULT NULL COMMENT '政治面貌',
  `nation` varchar(4) DEFAULT NULL COMMENT '民族',
  `customer_type` varchar(4) DEFAULT NULL COMMENT '客户类型',
  `customer_birth` varchar(32) DEFAULT NULL COMMENT '客户生日',
  `now_house_type` varchar(4) DEFAULT NULL COMMENT '现住房屋类型',
  `now_address_province` varchar(32) DEFAULT NULL COMMENT '现住地址省',
  `now_address_city` varchar(32) DEFAULT NULL COMMENT '现住地址市',
  `now_address_area` varchar(32) DEFAULT NULL COMMENT '现住地址区',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `post_code` varchar(32) DEFAULT NULL COMMENT '现居住地址邮编',
  `is_card_mail_address` varchar(255) DEFAULT NULL COMMENT '是否卡邮寄地址',
  `family_number` int(11) DEFAULT '0' COMMENT '家庭人口',
  `family_phone` varchar(32) DEFAULT NULL COMMENT '家庭电话',
  `family_main_asset` varchar(255) DEFAULT NULL COMMENT '家庭主要财产',
  `main_asset_include` varchar(255) DEFAULT NULL COMMENT '主要财产包括',
  `main_income` varchar(255) DEFAULT NULL COMMENT '主要收入来源',
  `other_income_note` varchar(255) DEFAULT NULL COMMENT '其他收入说明',
  `house_contract` tinytext COMMENT '购房合同',
  `is_house_property` varchar(4) DEFAULT NULL COMMENT '房产证情况',
  `house_property` tinytext COMMENT '房产证',
  `month_income` bigint(20) DEFAULT NULL COMMENT '月收入',
  `work_company_property` varchar(32) DEFAULT NULL COMMENT '单位性质',
  `work_belong_industry` varchar(32) DEFAULT NULL COMMENT '所属行业',
  `work_profession` varchar(32) DEFAULT NULL COMMENT '职业',
  `position` varchar(32) DEFAULT NULL COMMENT '职位',
  `post_title` varchar(32) DEFAULT NULL COMMENT '职称',
  `work_datetime` varchar(32) DEFAULT NULL COMMENT '何时进入现单位工作',
  `self_company_area` varchar(32) DEFAULT NULL COMMENT '自营公司单位面积',
  `employee_quantity` varchar(32) DEFAULT NULL COMMENT '员工数量',
  `enterprise_month_output` varchar(32) DEFAULT NULL COMMENT '企业月产值',
  `is_license` varchar(4) DEFAULT NULL COMMENT '营业执照情况',
  `license` tinytext COMMENT '营业执照',
  `organization_code_card` varchar(255) DEFAULT NULL COMMENT '组织机构代码证',
  `code_card_address` varchar(255) DEFAULT NULL COMMENT '代码证上的地址',
  `is_site_prove` varchar(4) DEFAULT NULL COMMENT '提供场地证明',
  `site_prove` tinytext COMMENT '场地证明',
  `site_area` varchar(32) DEFAULT NULL COMMENT '经营场地面积',
  `emergency_name1` varchar(32) DEFAULT NULL COMMENT '联系人1姓名',
  `emergency_relation1` varchar(4) DEFAULT NULL COMMENT '联系人1与申请人关系',
  `emergency_mobile1` varchar(32) DEFAULT NULL COMMENT '联系人1手机号码',
  `emergency_name2` varchar(32) DEFAULT NULL COMMENT '联系人2姓名',
  `emergency_relation2` varchar(4) DEFAULT NULL COMMENT '联系人2与申请人关系',
  `emergency_mobile2` varchar(32) DEFAULT NULL COMMENT '联系人2手机号码',
  `car_type` varchar(4) DEFAULT NULL COMMENT '现有车辆类型',
  `is_drice_license` varchar(4) DEFAULT NULL COMMENT '有无驾照',
  `drice_license` tinytext COMMENT '驾照',
  `marry_pdf` tinytext COMMENT '结婚证资料',
  `other_pdf` tinytext COMMENT '其他资料',
  `work_asset_pdf` tinytext COMMENT '工作资料',
  `single_prove_pdf` tinytext COMMENT '单身证明',
  `income_prove_pdf` tinytext COMMENT '收入证明',
  `live_prove_pdf` tinytext COMMENT '居住证明',
  `build_prove_pdf` tinytext COMMENT '自建房证明',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征信人辅助资料';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_enter_file_list`
--

DROP TABLE IF EXISTS `tdq_enter_file_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_enter_file_list` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `content` text COMMENT '内容',
  `file_count` int(11) DEFAULT NULL COMMENT '份数',
  `deposit_date_time` datetime DEFAULT NULL COMMENT '存放时间',
  `operator` varchar(32) DEFAULT NULL COMMENT '存放人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='档案存放清单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_file_list`
--

DROP TABLE IF EXISTS `tdq_file_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_file_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category` varchar(32) DEFAULT NULL COMMENT '序号',
  `kname` varchar(32) DEFAULT NULL COMMENT '名称',
  `vname` varchar(255) DEFAULT NULL,
  `attach_type` varchar(32) DEFAULT NULL,
  `number` int(11) DEFAULT NULL COMMENT '份数',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_interview_video`
--

DROP TABLE IF EXISTS `tdq_interview_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_interview_video_room`
--

DROP TABLE IF EXISTS `tdq_interview_video_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_interview_video_room` (
  `code` varchar(32) NOT NULL COMMENT '房间编号',
  `home_owner_id` varchar(32) DEFAULT NULL COMMENT '房主id',
  `hl_url` varchar(255) DEFAULT NULL COMMENT '混流视频下载地址',
  `status` varchar(4) DEFAULT NULL COMMENT '状态（0可用，1不可用）',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `budget_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_investigate_report`
--

DROP TABLE IF EXISTS `tdq_investigate_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_investigate_report` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `budget_order_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `company_code` tinytext COMMENT '业务公司',
  `biz_type` varchar(4) DEFAULT NULL COMMENT '业务种类',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  `apply_user_name` tinytext COMMENT '客户姓名',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `loan_bank` tinytext COMMENT '贷款银行',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `loan_period` tinytext COMMENT '贷款期数',
  `is_advance_fund` varchar(4) DEFAULT NULL COMMENT '是否垫资',
  `sale_user_id` tinytext COMMENT '业务员',
  `gua_mode` tinytext COMMENT '担保方式',
  `customer_information` text COMMENT '客户基本情况',
  `bank_credit_result_remark` text COMMENT '申请人征信情况',
  `price_approval_pdf` mediumtext COMMENT '申请人贷款车辆价格核准情况',
  `car_168_price` bigint(20) DEFAULT NULL COMMENT '车行168车价',
  `apply_work_and_jour` tinytext COMMENT '申请人工作情况及流水反映',
  `jour_datetime_start` datetime DEFAULT NULL COMMENT '流水时间起',
  `jour_datetime_end` datetime DEFAULT NULL COMMENT '流水时间止',
  `jour_interest1` varchar(255) DEFAULT NULL COMMENT '流水结息1',
  `jour_interest2` varchar(255) DEFAULT NULL COMMENT '流水结息2',
  `interest1` varchar(255) DEFAULT NULL COMMENT '结息1',
  `interest2` varchar(255) DEFAULT NULL COMMENT '结息2',
  `jour_income` bigint(20) DEFAULT NULL COMMENT '收入',
  `jour_expend` bigint(20) DEFAULT NULL COMMENT '支出',
  `jour_balance` bigint(20) DEFAULT NULL COMMENT '帐户余额',
  `jour_month_income` bigint(20) DEFAULT NULL COMMENT '月均收入',
  `jour_month_expend` bigint(20) DEFAULT NULL COMMENT '月均支出',
  `jour_pic` text COMMENT '流水图片',
  `jour_remark` text COMMENT '银行流水情况',
  `zfb_jour_datetime_start` datetime DEFAULT NULL COMMENT '支付宝流水时间起',
  `zfb_jour_datetime_end` datetime DEFAULT NULL COMMENT '支付宝流水时间止',
  `zfb_jour_interest1` varchar(255) DEFAULT NULL COMMENT '支付宝流水结息1',
  `zfb_jour_interest2` varchar(255) DEFAULT NULL COMMENT '支付宝流水结息2',
  `zfb_interest1` varchar(255) DEFAULT NULL COMMENT '支付宝结息1',
  `zfb_interest2` varchar(255) DEFAULT NULL COMMENT '支付宝结息2',
  `zfb_jour_income` bigint(20) DEFAULT NULL COMMENT '支付宝收入',
  `zfb_jour_expend` bigint(20) DEFAULT NULL COMMENT '支付宝支出',
  `zfb_jour_balance` bigint(20) DEFAULT NULL COMMENT '支付宝帐户余额',
  `zfb_jour_month_income` bigint(20) DEFAULT NULL COMMENT '支付宝月均收入',
  `zfb_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '支付宝月均支出',
  `zfb_jour_pic` text COMMENT '支付宝流水图片',
  `zfb_jour_remark` text COMMENT '支付宝流水情况',
  `wx_jour_datetime_start` datetime DEFAULT NULL COMMENT '微信流水时间起',
  `wx_jour_datetime_end` datetime DEFAULT NULL COMMENT '微信流水时间止',
  `wx_jour_interest1` varchar(255) DEFAULT NULL COMMENT '微信流水结息1',
  `wx_jour_interest2` varchar(255) DEFAULT NULL COMMENT '微信流水结息2',
  `wx_interest1` varchar(255) DEFAULT NULL COMMENT '微信结息1',
  `wx_interest2` varchar(255) DEFAULT NULL COMMENT '微信结息2',
  `wx_jour_income` bigint(20) DEFAULT NULL COMMENT '微信收入',
  `wx_jour_expend` bigint(20) DEFAULT NULL COMMENT '微信支出',
  `wx_jour_balance` bigint(20) DEFAULT NULL COMMENT '微信帐户余额',
  `wx_jour_month_income` bigint(20) DEFAULT NULL COMMENT '微信月均收入',
  `wx_jour_month_expend` bigint(20) DEFAULT NULL COMMENT '微信月均支出',
  `wx_jour_pic` text COMMENT '微信流水图片',
  `wx_jour_remark` text COMMENT '微信流水情况',
  `house_contract` text COMMENT '房产情况及家访',
  `home_visit` tinytext COMMENT '家访地址',
  `house_picture` text COMMENT '家访照片',
  `basics_information` text COMMENT '车辆基础信息',
  `xsz_pdf` text COMMENT '行驶证主副页',
  `xsz_car_pdf` text COMMENT '行驶证车辆照片页',
  `frame_no` tinytext COMMENT '车架号',
  `nameplate` tinytext COMMENT '车辆铭牌',
  `forward_pdf` text COMMENT '车辆照片正前',
  `queen_pdf` text COMMENT '车辆照片正后',
  `left_pdf` text COMMENT '车辆照片正左',
  `right_pdf` text COMMENT '车辆照片正右',
  `lf45_pdf` text COMMENT '车辆照片左前45º',
  `rf45_pdf` text COMMENT '车辆照片右前45º',
  `lg45_pdf` text COMMENT '车辆照片左后45º',
  `rr45_pdf` text COMMENT '车辆照片右后45º',
  `engine_pdf` text COMMENT '车辆照片发动机仓',
  `szm_pdf` text COMMENT '车辆中控台照片',
  `gears_pdf` text COMMENT '车辆档位照片',
  `functional_zone_pdf` text COMMENT '车辆功能区里照片',
  `odometer_pdf` text COMMENT '车辆里程表照片',
  `front_row_pdf` text COMMENT '车辆前排内饰照片',
  `rock_row_pdf` text COMMENT '车辆中排内饰照片',
  `trunk_pdf` text COMMENT '车辆后备箱照片',
  `louver_pdf` text COMMENT '车辆天窗照片',
  `bank_row_pdf` text COMMENT '车辆后排娱乐系统照片',
  `check_approve_pdf` text COMMENT '车辆核准截图',
  `check_approve_link` tinytext COMMENT '核准链接',
  `third_valuation_pdf` text COMMENT '第三方评估价截图',
  `check_approve_software` text COMMENT '核准软件',
  `used_car_current_rate` text COMMENT '二手车市场成交价最低及最高截图',
  `information_source` tinytext COMMENT '信息源',
  `valuation` bigint(20) DEFAULT NULL COMMENT '评估价',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点编号',
  `updater` tinytext COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` tinytext COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调查报告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_limu_credit`
--

DROP TABLE IF EXISTS `tdq_limu_credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_limu_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务类型',
  `token` varchar(255) DEFAULT NULL COMMENT '标记',
  `found_datetime` datetime DEFAULT NULL COMMENT '查询时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `result` longtext COMMENT '查询结果',
  `callback_datetime` datetime DEFAULT NULL COMMENT '回调时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_linshi`
--

DROP TABLE IF EXISTS `tdq_linshi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_linshi` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_loan_product`
--

DROP TABLE IF EXISTS `tdq_loan_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_loan_product` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `loan_bank` varchar(255) DEFAULT NULL COMMENT '贷款银行',
  `loan_period` varchar(4) DEFAULT NULL COMMENT '贷款期限',
  `wan_factor` bigint(20) DEFAULT NULL COMMENT '万元系数',
  `year_rate` decimal(18,8) DEFAULT NULL COMMENT '年利率',
  `auth_rate` decimal(18,8) DEFAULT NULL COMMENT '公证费比率',
  `is_pre` char(1) DEFAULT NULL COMMENT '是否前置',
  `pre_rate` decimal(18,8) DEFAULT NULL COMMENT '前置利率',
  `assure_type` varchar(32) DEFAULT NULL COMMENT '担保费类型(1单笔/2贷款额百分比)',
  `assure_fee` bigint(20) DEFAULT NULL COMMENT '单笔担保费',
  `assure_rate` decimal(18,8) DEFAULT NULL COMMENT '担保费贷款额百分比',
  `dz_type` varchar(32) DEFAULT NULL COMMENT '垫资费类型(1单笔/2贷款额百分比)',
  `dz_fee` bigint(20) DEFAULT NULL COMMENT '单笔垫资费',
  `dz_rate` decimal(18,8) DEFAULT NULL COMMENT '垫资费贷款额百分比',
  `ly_amount_type` varchar(32) DEFAULT NULL COMMENT '履约保证金类型(1单笔/2贷款额百分比)',
  `ly_amount_fee` bigint(20) DEFAULT NULL COMMENT '单笔履约保证金',
  `ly_amount_rate` decimal(18,8) DEFAULT NULL COMMENT '履约保证金贷款额百分比',
  `gps_type` varchar(32) DEFAULT NULL COMMENT 'GPS类型(1单笔/2贷款额百分比)',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT '单笔GPS费',
  `gps_rate` decimal(18,8) DEFAULT NULL COMMENT 'GPS垫资费贷款额百分比',
  `other_type` varchar(32) DEFAULT NULL COMMENT '杂费类型(1单笔/2贷款额百分比)',
  `other_fee` bigint(20) DEFAULT NULL COMMENT '单笔杂费',
  `other_rate` decimal(18,8) DEFAULT NULL COMMENT '杂费贷款额百分比',
  `introduce_type` varchar(32) DEFAULT NULL COMMENT '介绍费类型(1单笔/2贷款额百分比)',
  `introduce_fee` bigint(20) DEFAULT NULL COMMENT '单笔介绍费',
  `introduce_rate` decimal(18,8) DEFAULT NULL COMMENT '介绍费贷款额百分比',
  `return_point_type` varchar(32) DEFAULT NULL COMMENT '返点类型(1单笔/2贷款额百分比)',
  `return_point_fee` bigint(20) DEFAULT NULL COMMENT '单笔返点',
  `return_point_rate` decimal(18,8) DEFAULT NULL COMMENT '返点贷款额百分比',
  `insu_agency_year1_type` varchar(32) DEFAULT NULL COMMENT '1年保险代理费类型(1平台/2车行)',
  `insu_agency_year1_fee` bigint(20) DEFAULT NULL COMMENT '1年保险代理费',
  `insu_agency_year2_type` varchar(32) DEFAULT NULL COMMENT '2年保险代理费类型(1平台/2车行)',
  `insu_agency_year2_fee` bigint(20) DEFAULT NULL COMMENT '2年保险代理费',
  `insu_agency_year3_type` varchar(32) DEFAULT NULL COMMENT '3年保险代理费类型(1平台/2车行)',
  `insu_agency_year3_fee` bigint(20) DEFAULT NULL COMMENT '3年保险代理费',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0 待上架 1已上架 2已下架)',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tdq_logistics`
--

DROP TABLE IF EXISTS `tdq_logistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdq_logistics` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1 贷前)',
  `cur_node_type` varchar(4) DEFAULT NULL COMMENT '节点类型',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  `from_node_code` varchar(255) DEFAULT NULL COMMENT '来方节点',
  `to_node_code` varchar(255) DEFAULT NULL COMMENT '去方节点',
  `send_type` varchar(4) DEFAULT NULL COMMENT '寄送方式(1 线下 2 快递)',
  `logistics_company` varchar(32) DEFAULT NULL COMMENT '快递公司',
  `logistics_code` varchar(255) DEFAULT NULL COMMENT '快递单号',
  `send_datetime` datetime DEFAULT NULL COMMENT '发货时间',
  `send_note` varchar(255) DEFAULT NULL COMMENT '发货说明',
  `receipt_datetime` datetime DEFAULT NULL COMMENT '收件时间',
  `sender` varchar(32) DEFAULT NULL COMMENT '发件人',
  `receiver` varchar(32) DEFAULT NULL COMMENT '收件人(gps 落地具体某个人/ 非gps默认0)',
  `filelist` varchar(255) DEFAULT NULL COMMENT '材料清单',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 待发件 1已发件待收件 2已收件审核 3已收件待补件)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tht_action`
--

DROP TABLE IF EXISTS `tht_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tht_action` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型（0 分享，1 足迹，2 关注，3 收藏，4 点赞）',
  `to_type` varchar(4) NOT NULL COMMENT '操作对象类型（0 车，1 资讯）',
  `to_code` varchar(32) NOT NULL COMMENT '操作对象编号',
  `creater` varchar(32) NOT NULL COMMENT '操作人',
  `create_datetime` datetime NOT NULL COMMENT '操作时间',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户行为';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tht_brand`
--

DROP TABLE IF EXISTS `tht_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tht_brand` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `letter` varchar(32) DEFAULT NULL COMMENT '字母序号',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `description` text COMMENT '品牌介绍',
  `location` varchar(32) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL COMMENT '次序',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最新修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最新修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '品牌'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tht_car`
--

DROP TABLE IF EXISTS `tht_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tht_car` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `is_referee` varchar(4) DEFAULT NULL COMMENT '是否推荐',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `series_code` varchar(32) DEFAULT NULL COMMENT '车系编号',
  `series_name` varchar(255) DEFAULT NULL COMMENT '车系名称',
  `brand_code` varchar(32) DEFAULT NULL COMMENT '品牌编号',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `level` varchar(4) DEFAULT NULL COMMENT '级别（0 SUV，1 轿车，2 MPV，3 跑车，4 皮卡，5 房车）',
  `version` varchar(4) DEFAULT NULL COMMENT '规格/版本（1 中东 2 美规 3 加规 4 墨版 5 欧规）',
  `structure` varchar(4) DEFAULT NULL COMMENT '结构（1 两厢 2 三厢 3 掀背 4 旅行版 5 硬顶敞篷 6 软顶敞篷 7 硬顶跑车）',
  `displacement` double DEFAULT NULL COMMENT '排量',
  `from_place` varchar(64) DEFAULT NULL COMMENT '车源地',
  `car_procedure` varchar(64) DEFAULT NULL COMMENT '手续',
  `original_price` bigint(32) DEFAULT NULL COMMENT '原价',
  `sale_price` bigint(32) DEFAULT NULL COMMENT '参考价',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `fw_amount` bigint(20) DEFAULT NULL COMMENT '服务费',
  `jsq_byhf` bigint(20) DEFAULT NULL COMMENT '必要花费',
  `jsq_sybx` bigint(20) DEFAULT NULL COMMENT '商业保险',
  `location` varchar(4) DEFAULT NULL COMMENT 'UI位置',
  `order_no` int(11) DEFAULT NULL COMMENT 'UI次序',
  `slogan` text COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `pic_number` int(11) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `description` mediumtext COMMENT '图文描述',
  `outside_color` varchar(32) DEFAULT NULL COMMENT '外部颜色',
  `inside_color` varchar(32) DEFAULT NULL COMMENT '内部颜色',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最新修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最新修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '车型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tht_car_carconfig`
--

DROP TABLE IF EXISTS `tht_car_carconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tht_car_carconfig` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `car_code` varchar(32) DEFAULT NULL COMMENT '车型编号',
  `config_code` varchar(32) DEFAULT NULL COMMENT '配置编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车型配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tht_car_news`
--

DROP TABLE IF EXISTS `tht_car_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tht_car_news` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `author` varchar(64) DEFAULT NULL COMMENT '作者',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `pic_number` int(11) DEFAULT NULL COMMENT '图片数量',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `read_count` bigint(20) DEFAULT NULL COMMENT '阅读量',
  `context` text COMMENT '内容',
  `tag` varchar(255) DEFAULT NULL COMMENT '标签',
  `status` varchar(4) DEFAULT NULL COMMENT '状态（0 待上架，1 上架，2 下架）',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tht_car_order`
--

DROP TABLE IF EXISTS `tht_car_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tht_car_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `user_mobile` varchar(16) DEFAULT NULL COMMENT '申请人手机号',
  `name` varchar(64) DEFAULT NULL COMMENT '申请人姓名',
  `brand_code` varchar(32) DEFAULT NULL COMMENT '品牌编号',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `series_code` varchar(32) DEFAULT NULL COMMENT '车系编号',
  `series_name` varchar(255) DEFAULT NULL COMMENT '车系名称',
  `car_code` varchar(32) DEFAULT NULL COMMENT '车型编号',
  `car_name` varchar(255) DEFAULT NULL COMMENT '车型名称',
  `price` bigint(20) DEFAULT NULL COMMENT '车辆总价',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `periods` int(11) DEFAULT NULL COMMENT '分期期数',
  `create_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `sale_desc` text COMMENT '计算器信息',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `handler` varchar(32) DEFAULT NULL COMMENT '处理人',
  `handle_datetime` datetime DEFAULT NULL COMMENT '处理时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '购车意向'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tht_carconfig`
--

DROP TABLE IF EXISTS `tht_carconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tht_carconfig` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tht_series`
--

DROP TABLE IF EXISTS `tht_series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tht_series` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `brand_code` varchar(32) DEFAULT NULL COMMENT '品牌编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `slogan` text COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `pic_number` int(11) DEFAULT NULL COMMENT '照片数量',
  `price` bigint(20) DEFAULT NULL COMMENT '价格区间',
  `highest` bigint(20) DEFAULT NULL COMMENT '最高价',
  `lowest` bigint(20) DEFAULT NULL COMMENT '最低价',
  `level` varchar(4) DEFAULT NULL COMMENT '级别（0 SUV，1 轿车，2 MPV，3 跑车，4 皮卡，5 房车）',
  `is_referee` varchar(4) DEFAULT NULL COMMENT '是否推荐',
  `location` varchar(4) DEFAULT NULL COMMENT 'UI位置',
  `order_no` int(11) DEFAULT NULL COMMENT 'UI次序',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最新修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最新修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '车系'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tmall_category`
--

DROP TABLE IF EXISTS `tmall_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmall_category` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父节点',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`code`) COMMENT '分类'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tmall_order`
--

DROP TABLE IF EXISTS `tmall_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmall_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收件人姓名',
  `re_mobile` varchar(32) DEFAULT NULL COMMENT '收件人电话',
  `re_address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '下单人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '下单嘱咐',
  `apply_datetime` datetime DEFAULT NULL COMMENT '下单时间',
  `amount` bigint(20) DEFAULT NULL COMMENT '总金额',
  `yunfei` bigint(20) DEFAULT NULL COMMENT '总运费',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `pay_type` varchar(32) DEFAULT NULL COMMENT '支付方式',
  `pay_group` varchar(32) DEFAULT NULL COMMENT '支付组号',
  `pay_code` varchar(32) DEFAULT NULL COMMENT '支付编号',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `pay_amount` bigint(20) DEFAULT NULL COMMENT '支付金额',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '订单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tmall_product`
--

DROP TABLE IF EXISTS `tmall_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmall_product` (
  `code` varchar(32) NOT NULL COMMENT '商品编号',
  `category` varchar(32) DEFAULT NULL COMMENT '大类',
  `type` varchar(32) DEFAULT NULL COMMENT '小类',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `slogan` varchar(255) DEFAULT NULL COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `sale_status` varchar(255) DEFAULT NULL COMMENT '销售状态',
  `pic` text COMMENT 'pic',
  `description` text COMMENT '图文描述',
  `original_price` bigint(20) DEFAULT NULL COMMENT '原价',
  `price` bigint(20) DEFAULT NULL COMMENT '价格（人民币）',
  `credit_score` bigint(20) DEFAULT NULL COMMENT '最低购买信用分',
  `location` varchar(32) DEFAULT NULL COMMENT '位置(0 普通 1 热门)',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  `status` varchar(4) DEFAULT NULL COMMENT '产品状态',
  `bought_count` int(11) DEFAULT NULL COMMENT '已购买数量',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '产品'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tmall_product_specs`
--

DROP TABLE IF EXISTS `tmall_product_specs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmall_product_specs` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '规格名称',
  `pic` text COMMENT 'pic',
  `product_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `original_price` bigint(20) DEFAULT NULL COMMENT '原价',
  `price` bigint(20) DEFAULT NULL COMMENT '价格（人民币）',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `quantity` int(11) DEFAULT NULL COMMENT '库存',
  `province` varchar(255) DEFAULT NULL COMMENT '发货地,精确到省份',
  `weight` decimal(18,8) DEFAULT NULL COMMENT '重量',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tmall_specs_order`
--

DROP TABLE IF EXISTS `tmall_specs_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmall_specs_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `order_code` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `product_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `product_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `product_specs_code` varchar(32) DEFAULT NULL COMMENT '商品参数编号',
  `product_specs_name` varchar(32) DEFAULT NULL COMMENT '商品参数名称',
  `bankcardCode` varchar(32) DEFAULT NULL COMMENT '银行卡编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` bigint(20) DEFAULT NULL COMMENT '价格',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `yunfei` bigint(20) DEFAULT NULL COMMENT '运费',
  `deliverer` varchar(32) DEFAULT NULL COMMENT '发货人',
  `delivery_datetime` datetime DEFAULT NULL COMMENT '发货时间',
  `logistics_company` varchar(32) DEFAULT NULL COMMENT '物流公司编号',
  `logistics_code` varchar(32) DEFAULT NULL COMMENT '物流单号',
  `pdf` varchar(255) DEFAULT NULL COMMENT '物流单',
  `signer` varchar(32) DEFAULT NULL COMMENT '签收人',
  `sign_datetime` datetime DEFAULT NULL COMMENT '签收时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单快照';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_archive`
--

DROP TABLE IF EXISTS `tp_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_archive` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `id_no` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `job_no` varchar(32) DEFAULT NULL COMMENT '工号',
  `entry_datetime` datetime DEFAULT NULL COMMENT '入职时间',
  `department_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `post_code` varchar(32) DEFAULT NULL COMMENT '职务岗位编号',
  `job_classes` varchar(32) DEFAULT NULL COMMENT '上班班次',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `marry_status` varchar(32) DEFAULT NULL COMMENT '婚姻状况',
  `politics` varchar(32) DEFAULT NULL COMMENT '政治面貌',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `education` varchar(32) DEFAULT NULL COMMENT '学历',
  `work_status` varchar(32) DEFAULT NULL COMMENT '状态',
  `health` varchar(32) DEFAULT NULL COMMENT '健康状况',
  `salary_card` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `five_insurance_info` varchar(255) DEFAULT NULL COMMENT '五险一金信息',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍地址',
  `residence_property` varchar(32) DEFAULT NULL COMMENT '户籍性质',
  `social_security_reg_datetime` datetime DEFAULT NULL COMMENT '社保登记日期',
  `current_address` varchar(255) DEFAULT NULL COMMENT '现住址',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(11) DEFAULT NULL COMMENT '紧急联系号码',
  `contract_deadline` varchar(32) DEFAULT NULL COMMENT '合同期限',
  `contract_type` varchar(32) DEFAULT NULL COMMENT '合同类型',
  `probation_time` varchar(32) DEFAULT NULL COMMENT '试用期时间',
  `convert_datetime` datetime DEFAULT NULL COMMENT '转正日期',
  `leave_datetime` datetime DEFAULT NULL COMMENT '离职日期',
  `leave_reason` varchar(255) DEFAULT NULL COMMENT '离职缘由',
  `heir_people` varchar(255) DEFAULT NULL COMMENT '交接人',
  `entrance_no` varchar(32) DEFAULT NULL COMMENT '门禁号',
  `check_no` varchar(32) DEFAULT NULL COMMENT '考勤号',
  `car_no` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `id_no_pdf` varchar(255) DEFAULT NULL COMMENT '身份证复印件',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `wechat` varchar(32) DEFAULT NULL COMMENT '微信',
  `qq` varchar(32) DEFAULT NULL COMMENT 'QQ',
  `perform_salary_standard` varchar(255) DEFAULT NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` varchar(255) DEFAULT NULL COMMENT '季度奖考核标准',
  `commumication_fee_standard` varchar(255) DEFAULT NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '省会住宿报销标准',
  `no_provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '非省会住宿报销标准',
  `traffic_award` bigint(20) DEFAULT NULL COMMENT '市内交通现金补助',
  `mobile_award` bigint(20) DEFAULT NULL COMMENT '电话现金补贴',
  `taxi_ward` bigint(20) DEFAULT NULL COMMENT '出租车',
  `meal_award` bigint(20) DEFAULT NULL COMMENT '餐补',
  `working_years` varchar(32) DEFAULT NULL COMMENT '工龄',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人事档案';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_archive_location`
--

DROP TABLE IF EXISTS `tp_archive_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_archive_location` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `location` varchar(255) DEFAULT NULL COMMENT '位置编号',
  `name` varchar(255) DEFAULT NULL COMMENT '位置名称',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='档案存放位置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_ask_for_apply`
--

DROP TABLE IF EXISTS `tp_ask_for_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_ask_for_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `lead_user_id` varchar(255) DEFAULT NULL COMMENT '请示领导',
  `content` varchar(255) DEFAULT NULL COMMENT '请示内容',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领导请示申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_assert_apply`
--

DROP TABLE IF EXISTS `tp_assert_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_assert_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` char(1) DEFAULT NULL COMMENT '类型(1=办公 2=固定资产)',
  `apply_user` varchar(255) DEFAULT NULL COMMENT '申请人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `is_print` char(1) DEFAULT NULL COMMENT '是否印刷品（1是 2不是）',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公用品/固定资产';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_assert_goods`
--

DROP TABLE IF EXISTS `tp_assert_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_assert_goods` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `assert_code` varchar(32) DEFAULT NULL COMMENT '办公用品编号',
  `product_code` varchar(45) DEFAULT NULL COMMENT '品名',
  `mode` varchar(255) DEFAULT NULL COMMENT '规格',
  `quantity` varchar(32) DEFAULT NULL COMMENT '申请数量',
  `price` bigint(20) DEFAULT NULL COMMENT '出库价格',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公物品列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_assert_user`
--

DROP TABLE IF EXISTS `tp_assert_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_assert_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `assert_code` varchar(32) DEFAULT NULL COMMENT '办公用品编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `print_quantity` varchar(32) DEFAULT NULL COMMENT '印刷数量',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公用户列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_bus`
--

DROP TABLE IF EXISTS `tp_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_bus` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `model` varchar(32) DEFAULT NULL COMMENT '车辆型号',
  `number` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `insurance_end_datetime` datetime DEFAULT NULL COMMENT '保险到期日',
  `park_location` varchar(255) DEFAULT NULL COMMENT '停放位置',
  `pic` varchar(255) DEFAULT NULL COMMENT '车辆照片',
  `status` varchar(4) DEFAULT NULL COMMENT '领用状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公车';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_bus_borrow`
--

DROP TABLE IF EXISTS `tp_bus_borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_bus_borrow` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `bus_code` varchar(32) DEFAULT NULL COMMENT '公车编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申领人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '领用说明',
  `department_code` varchar(32) DEFAULT NULL COMMENT '所属部门',
  `use_datetime_start` datetime DEFAULT NULL COMMENT '使用时间起',
  `use_datetime_end` datetime DEFAULT NULL COMMENT '使用时间止',
  `drive_kil` double DEFAULT NULL COMMENT '行驶公里数',
  `return_datetime` datetime DEFAULT NULL COMMENT '归还时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公车借用';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_business_trip_apply`
--

DROP TABLE IF EXISTS `tp_business_trip_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_car_break`
--

DROP TABLE IF EXISTS `tp_car_break`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_car_break` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '违章人编号',
  `car_no` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `happen_datetime` datetime DEFAULT NULL COMMENT '违章时间',
  `address` varchar(255) DEFAULT NULL COMMENT '违章地点',
  `action` varchar(255) DEFAULT NULL COMMENT '违章行为',
  `score` int(11) DEFAULT NULL COMMENT '记分',
  `punish_amount` decimal(18,8) DEFAULT NULL COMMENT '罚款金额',
  `handle_note` varchar(255) DEFAULT NULL COMMENT '处理情况',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆违章处理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_check_project`
--

DROP TABLE IF EXISTS `tp_check_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_check_project` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `check_result` varchar(255) DEFAULT NULL COMMENT '考核指标',
  `check_user` varchar(255) DEFAULT NULL COMMENT '考核人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `employ_apply_code` varchar(32) NOT NULL COMMENT '应聘岗位编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考核项目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_comp_category`
--

DROP TABLE IF EXISTS `tp_comp_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_comp_category` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类别管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_comp_product`
--

DROP TABLE IF EXISTS `tp_comp_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_comp_product` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `name` varchar(255) DEFAULT NULL COMMENT '品名',
  `model` varchar(255) DEFAULT NULL COMMENT '规格型号',
  `unit` varchar(32) DEFAULT NULL COMMENT '单位',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品名管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_comp_regime`
--

DROP TABLE IF EXISTS `tp_comp_regime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_comp_regime` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1行政事务类 2 人力资源管理类 3 财务管理类 4 营销管理类 5 生产管理类)',
  `regime_code` varchar(32) DEFAULT NULL COMMENT '制度编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `scope` varchar(32) DEFAULT NULL COMMENT '授权查看范围',
  `content` text COMMENT '内容',
  `enclosure` tinytext COMMENT '附件',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司制度';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_contract`
--

DROP TABLE IF EXISTS `tp_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_contract` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(255) DEFAULT NULL COMMENT '合同类型',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `archive_code` varchar(32) DEFAULT NULL COMMENT '档案编号',
  `contract_no` varchar(255) DEFAULT NULL COMMENT '合同编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始日期',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束日期',
  `pdf` varchar(255) DEFAULT NULL COMMENT '合同附件',
  `remark` varchar(255) DEFAULT NULL COMMENT '说明',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除 1正常',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_convert_apply`
--

DROP TABLE IF EXISTS `tp_convert_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_convert_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `entry_code` varchar(32) DEFAULT NULL COMMENT '入职编号',
  `apply_user` varchar(255) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `work_summary` varchar(255) DEFAULT NULL COMMENT '工作总结',
  `all_evaluation` varchar(255) DEFAULT NULL COMMENT '总体评价',
  `is_full_worker` varchar(4) DEFAULT NULL COMMENT '是否转正',
  `effect_datetime` datetime DEFAULT NULL COMMENT '生效日期',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='转正申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_day_rest`
--

DROP TABLE IF EXISTS `tp_day_rest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_day_rest` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `is_rest` varchar(4) DEFAULT NULL COMMENT '是否休息',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='休息日记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_employ_apply`
--

DROP TABLE IF EXISTS `tp_employ_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_employ_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `position` varchar(255) DEFAULT NULL COMMENT '应聘岗位',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `id_no` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  `contact_mobile` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍所在地',
  `speciality` varchar(255) DEFAULT NULL COMMENT '特长技能',
  `expect_salary` bigint(20) DEFAULT NULL COMMENT '期望薪资',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(255) DEFAULT NULL COMMENT '紧急联系号码',
  `postcode` varchar(255) DEFAULT NULL COMMENT '邮编',
  `award` varchar(255) DEFAULT NULL COMMENT '受过何种奖励或专业训练',
  `is_out` char(1) DEFAULT NULL COMMENT '能否出差',
  `is_over_time` char(1) DEFAULT NULL COMMENT '能否加班',
  `is_adjust_work` char(1) DEFAULT NULL COMMENT '能否接受工作调动',
  `is_once_recruited` char(1) DEFAULT NULL COMMENT '是否曾在我公司应聘',
  `is_friend_work` char(1) DEFAULT NULL COMMENT '是否有亲属或朋友在我司工作',
  `composite` varchar(255) DEFAULT NULL COMMENT '综合',
  `quality` varchar(255) DEFAULT NULL COMMENT '素质',
  `interview_record` varchar(255) DEFAULT NULL COMMENT '面试记录',
  `employ_result` varchar(255) DEFAULT NULL COMMENT '录用结果',
  `probation` varchar(255) DEFAULT NULL COMMENT '试用期',
  `employ_salary` bigint(20) DEFAULT NULL COMMENT '薪资',
  `employ_department_code` varchar(255) DEFAULT NULL COMMENT '入职部门',
  `employ_position_code` varchar(255) DEFAULT NULL COMMENT '入职职务',
  `employ_approve_user` varchar(255) DEFAULT NULL COMMENT '审核人',
  `employ_approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `employ_approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=待面试 1=已面试通过 2已面试不通过)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应聘岗位';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_entry_apply`
--

DROP TABLE IF EXISTS `tp_entry_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_entry_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `position` varchar(255) DEFAULT NULL COMMENT '入职岗位',
  `department_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `entry_datetime` datetime DEFAULT NULL COMMENT '入职时间',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(4) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `health` varchar(32) DEFAULT NULL COMMENT '健康状况',
  `marry_status` varchar(32) DEFAULT NULL COMMENT '婚姻状况',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(32) DEFAULT NULL COMMENT '紧急联系号码',
  `residence_property` varchar(255) DEFAULT NULL COMMENT '户籍性质',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍所在地',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `is_other_company_relation` varchar(32) DEFAULT NULL COMMENT '是否与其他单位存在劳动关系',
  `relative_name` varchar(255) DEFAULT NULL COMMENT '亲属从事本行姓名',
  `relative_relation` varchar(255) DEFAULT NULL COMMENT '亲属与本人关系',
  `relative_position` varchar(255) DEFAULT NULL COMMENT '亲属职务',
  `main_perform` varchar(255) DEFAULT NULL COMMENT '主要业绩及工作能力简述',
  `probation_start_datetime` datetime DEFAULT NULL COMMENT '试用期期限开始',
  `probation_end_datetime` datetime DEFAULT NULL COMMENT '试用期期限结束',
  `probation_salary` bigint(20) DEFAULT NULL COMMENT '试用期工资',
  `base_salary` bigint(20) DEFAULT NULL COMMENT '转正后基本工资',
  `perform_salary` bigint(20) DEFAULT NULL COMMENT '转正后绩效工资',
  `perform_salary_standard` varchar(255) DEFAULT NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` varchar(255) DEFAULT NULL COMMENT '季度奖考核标准',
  `communicate_pay_standard` varchar(255) DEFAULT NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '省会住宿报销标准',
  `non_provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '非省会住宿报销标准',
  `traffic_standard` bigint(20) DEFAULT NULL COMMENT '市内交通现金补助',
  `mobile_standard` bigint(20) DEFAULT NULL COMMENT '电话现金补贴',
  `taxi_standard` bigint(20) DEFAULT NULL COMMENT '出租车',
  `meal_standard` bigint(20) DEFAULT NULL COMMENT '餐补',
  `salary_card_no` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '开户行行号',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入职申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_fee_advance_apply`
--

DROP TABLE IF EXISTS `tp_fee_advance_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_fee_advance_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `ref_assert_code` varchar(32) DEFAULT NULL COMMENT '关联资产审批编号',
  `ref_budget_order_code` varchar(32) DEFAULT NULL COMMENT '关联车贷业务编号',
  `amount` bigint(20) DEFAULT NULL COMMENT '预支金额',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户银行',
  `bankcard_number` varchar(255) DEFAULT NULL COMMENT '银行账号',
  `account_name` varchar(255) DEFAULT NULL COMMENT '账户名',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `pay_datetime` datetime DEFAULT NULL COMMENT '付款时间',
  `pay_bank` varchar(32) DEFAULT NULL COMMENT '付款银行',
  `pay_bankcard` varchar(255) DEFAULT NULL COMMENT '付款账号',
  `pay_pdf` varchar(255) DEFAULT NULL COMMENT '付款凭证',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=待审核 1=审核通过 2=审核不通过 3=财务审核通过 4=财务审核不通过 5=确认放款)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='费用预支申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_leave_apply`
--

DROP TABLE IF EXISTS `tp_leave_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_leave_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `type` varchar(4) DEFAULT NULL COMMENT '请假类别',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` int(11) DEFAULT NULL COMMENT '时长',
  `pdf` varchar(32) DEFAULT NULL COMMENT '附件',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_notice`
--

DROP TABLE IF EXISTS `tp_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_notice` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1 公司动态 2 公司文件 3 培训说明)',
  `title` varchar(255) NOT NULL COMMENT '公告标题',
  `urgent_status` varchar(4) NOT NULL COMMENT '紧急程度（1 普通 2 紧急）',
  `publish_department_code` varchar(32) NOT NULL COMMENT '发布部门',
  `scope` varchar(32) DEFAULT NULL COMMENT '公告范围',
  `content` varchar(255) NOT NULL COMMENT '公告内容',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `enclosure` tinytext COMMENT '附件',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_notice_read`
--

DROP TABLE IF EXISTS `tp_notice_read`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_notice_read` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=未读，1=已读)',
  `notice_code` varchar(32) DEFAULT NULL COMMENT '公告编号',
  `ref_type` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告阅读记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_overtime_apply`
--

DROP TABLE IF EXISTS `tp_overtime_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_overtime_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '共计时长',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加班申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_probation_assess`
--

DROP TABLE IF EXISTS `tp_probation_assess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_probation_assess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `convert_code` varchar(32) DEFAULT NULL COMMENT '转正申请编号',
  `eval_item` varchar(255) DEFAULT NULL COMMENT '评估项目',
  `grade` decimal(18,8) DEFAULT NULL COMMENT '评估分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试用期评估';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_recruit_apply`
--

DROP TABLE IF EXISTS `tp_recruit_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_recruit_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `department_code` varchar(32) DEFAULT NULL COMMENT '申请部门编号',
  `position` varchar(255) DEFAULT NULL COMMENT '招聘岗位',
  `establish_quantity` int(11) DEFAULT NULL COMMENT '编制人数',
  `now_quantity` int(11) DEFAULT NULL COMMENT '现有人数',
  `apply_quantity` int(11) DEFAULT NULL COMMENT '申请补充人数',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `require_datetime` datetime DEFAULT NULL COMMENT '需要到岗时间',
  `replace_position` varchar(255) DEFAULT NULL COMMENT '被替代职位',
  `replace_real_name` varchar(255) DEFAULT NULL COMMENT '被替代者姓名',
  `new_apply_reason` varchar(255) DEFAULT NULL COMMENT '新申请职位原因',
  `position_now_quantity` int(11) DEFAULT NULL COMMENT '该职位现有人数',
  `position_add_reason` varchar(255) DEFAULT NULL COMMENT '该职位增加原因',
  `temp_start_datetime` datetime DEFAULT NULL COMMENT '临时聘用开始时间',
  `temp_end_datetime` datetime DEFAULT NULL COMMENT '临时聘用结束时间',
  `note` varchar(255) DEFAULT NULL COMMENT '说明',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` varchar(255) DEFAULT NULL COMMENT '年龄',
  `marry_state` varchar(255) DEFAULT NULL COMMENT '婚育情况',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `major_require` varchar(255) DEFAULT NULL COMMENT '专业资格',
  `ability_require` varchar(255) DEFAULT NULL COMMENT '能力要求',
  `experience` varchar(255) DEFAULT NULL COMMENT '相关工作经验',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用人申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_scope_people`
--

DROP TABLE IF EXISTS `tp_scope_people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_scope_people` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `type` varchar(32) NOT NULL COMMENT '类型(所有人员=-1,分公司=1，部门=2,职位=3，具体人=4)',
  `people_code` varchar(32) DEFAULT NULL COMMENT '具体类型人员编号',
  `ref_code` varchar(32) DEFAULT NULL COMMENT '参考编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告或制度人员范围';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_social_relation`
--

DROP TABLE IF EXISTS `tp_social_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_social_relation` (
  `code` varchar(32) NOT NULL,
  `archive_code` varchar(32) DEFAULT NULL COMMENT '人事档案编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '成员姓名',
  `relation` varchar(255) DEFAULT NULL COMMENT '与本人关系',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `post` varchar(255) DEFAULT NULL COMMENT '担任职务',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社会关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_storage_in`
--

DROP TABLE IF EXISTS `tp_storage_in`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_storage_in` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `product_code` varchar(255) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(18,8) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(18,8) DEFAULT NULL COMMENT '总价',
  `valid_date_start` datetime DEFAULT NULL COMMENT '有效期起',
  `valid_date_end` datetime DEFAULT NULL COMMENT '有效期止',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入库管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_storage_out`
--

DROP TABLE IF EXISTS `tp_storage_out`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_storage_out` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `product_code` varchar(255) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(18,8) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(18,8) DEFAULT NULL COMMENT '总价',
  `storage_in_code` varchar(32) DEFAULT NULL COMMENT '入库编号',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_supple_sign_apply`
--

DROP TABLE IF EXISTS `tp_supple_sign_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_supple_sign_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补签申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_supple_sign_apply_detail`
--

DROP TABLE IF EXISTS `tp_supple_sign_apply_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_supple_sign_apply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `supply_sign_apply_code` varchar(32) DEFAULT NULL COMMENT '补签申请编号',
  `supple_datetime` datetime DEFAULT NULL COMMENT '漏签日期',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补签申请明细';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_transfer_position_apply`
--

DROP TABLE IF EXISTS `tp_transfer_position_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_transfer_position_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `new_department` varchar(255) DEFAULT NULL COMMENT '新部门',
  `new_position` varchar(255) DEFAULT NULL COMMENT '新岗位',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始日期',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束日期',
  `reason` varchar(255) DEFAULT NULL COMMENT '缘由',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调岗申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_travel_apply`
--

DROP TABLE IF EXISTS `tp_travel_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_travel_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型(1=出差,2=公出)',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '共计时长',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出差/公出申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_travel_apply_detail`
--

DROP TABLE IF EXISTS `tp_travel_apply_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_travel_apply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `travel_apply_code` varchar(32) DEFAULT NULL COMMENT '出差申请编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '时长',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='时间申请明细';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_welfare_apply`
--

DROP TABLE IF EXISTS `tp_welfare_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_welfare_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='福利发放申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_welfare_user`
--

DROP TABLE IF EXISTS `tp_welfare_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_welfare_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `welfare_code` varchar(255) DEFAULT NULL COMMENT '福利编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='福利关联人员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tp_work_experience`
--

DROP TABLE IF EXISTS `tp_work_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_work_experience` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父级编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '起始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '截止时间',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `leave_reason` varchar(255) DEFAULT NULL COMMENT '离职原因',
  `prover` varchar(255) DEFAULT NULL COMMENT '证明人',
  `prover_mobile` varchar(255) DEFAULT NULL COMMENT '证明人联系电话',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作经历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tqj_attachment`
--

DROP TABLE IF EXISTS `tqj_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tqj_attachment` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `category` varchar(32) DEFAULT NULL COMMENT '附件分类',
  `kname` varchar(45) DEFAULT NULL COMMENT '附件key',
  `vname` varchar(45) DEFAULT NULL COMMENT '附件value',
  `attach_type` varchar(64) DEFAULT NULL COMMENT '附件类型（图片/视频/网页）',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件 ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tqj_biz_task`
--

DROP TABLE IF EXISTS `tqj_biz_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tqj_biz_task` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) NOT NULL COMMENT '业务编号',
  `ref_type` varchar(32) NOT NULL COMMENT '关联订单类型',
  `ref_order` varchar(32) NOT NULL COMMENT '关联订单编号',
  `ref_node` varchar(32) NOT NULL COMMENT '关联节点编号',
  `content` varchar(32) DEFAULT NULL COMMENT '任务内容',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(32) NOT NULL COMMENT '状态(0 待处理 1 已完成)',
  `operater` varchar(32) DEFAULT NULL COMMENT '操作人',
  `operate_role` varchar(32) DEFAULT NULL COMMENT '操作角色',
  `finish_datetime` datetime DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='待办事项表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tqj_cdbiz`
--

DROP TABLE IF EXISTS `tqj_cdbiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tqj_cdbiz` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `biz_code` varchar(32) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `biz_type` varchar(4) DEFAULT NULL COMMENT '业务类型（0新车，1二手车）',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  `repay_card_number` varchar(64) DEFAULT NULL COMMENT '还款卡号',
  `card_post_province` varchar(64) DEFAULT NULL COMMENT '卡邮寄地址省',
  `card_post_city` varchar(64) DEFAULT NULL COMMENT '卡邮寄地址市',
  `card_post_area` varchar(64) DEFAULT NULL COMMENT '卡邮寄地址区',
  `card_post_address` varchar(255) DEFAULT NULL COMMENT '卡邮寄地址',
  `card_post_code` varchar(64) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL COMMENT '主状态',
  `make_card_status` varchar(4) DEFAULT NULL COMMENT '制卡状态',
  `intev_status` varchar(4) DEFAULT NULL COMMENT '面签状态',
  `fbhgps_status` varchar(4) DEFAULT NULL COMMENT '发保合gps状态',
  `enter_status` varchar(4) DEFAULT NULL COMMENT '第一次入档状态',
  `cancel_status` varchar(4) DEFAULT NULL COMMENT '作废状态',
  `cur_node_code` varchar(8) DEFAULT NULL COMMENT '主流程节点',
  `intev_cur_node_code` varchar(5) DEFAULT NULL COMMENT '面签节点',
  `make_card_node` varchar(5) DEFAULT NULL COMMENT '制卡节点',
  `fbhgps_node` varchar(5) DEFAULT NULL COMMENT '发保合gps节点',
  `enter_node_code` varchar(5) DEFAULT NULL COMMENT '入档节点',
  `cancel_node_code` varchar(5) DEFAULT NULL COMMENT '客户作废节点',
  `is_gps_az` varchar(4) DEFAULT NULL COMMENT '是否安装gps',
  `is_finacing` varchar(4) DEFAULT NULL COMMENT '是否融资',
  `is_advance_fund` varchar(4) DEFAULT NULL COMMENT '是否垫资',
  `is_plat_insure` varchar(4) DEFAULT NULL COMMENT '是否我司续保',
  `should_fee_amount` bigint(20) DEFAULT NULL COMMENT '应收手续费总额',
  `real_fee_amount` bigint(20) DEFAULT NULL COMMENT '实收手续费总额',
  `gua_mode` varchar(4) DEFAULT NULL COMMENT '担保方式',
  `credit_note` varchar(255) DEFAULT NULL COMMENT '征信说明',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `captain_code` varchar(32) DEFAULT NULL COMMENT '团队长编号',
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `inside_job` varchar(32) DEFAULT NULL COMMENT '内勤编号',
  `loan_bank` varchar(32) DEFAULT NULL COMMENT '经办银行',
  `credit_loan_amount` bigint(20) DEFAULT NULL COMMENT '征信贷款金额',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `enter_location` varchar(32) DEFAULT NULL COMMENT '入档位置',
  `enter_datetime` datetime DEFAULT NULL COMMENT '入档时间',
  `enter_filelist` varchar(32) DEFAULT NULL COMMENT '档案目录',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tqj_mission`
--

DROP TABLE IF EXISTS `tqj_mission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tqj_mission` (
  `code` varchar(32) NOT NULL,
  `biz_code` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `creater` varchar(32) DEFAULT NULL,
  `get_user` varchar(32) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `finish_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_account`
--

DROP TABLE IF EXISTS `tstd_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_account` (
  `account_number` varchar(32) NOT NULL DEFAULT '' COMMENT '账号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '真实姓名',
  `type` varchar(4) DEFAULT NULL COMMENT '类别（B端账号，C端账号，平台账号）',
  `status` varchar(2) DEFAULT NULL COMMENT '状态（正常/程序冻结/人工冻结）',
  `currency` varchar(8) DEFAULT NULL COMMENT '币种',
  `amount` decimal(64,0) DEFAULT NULL COMMENT '余额',
  `frozen_amount` decimal(64,0) DEFAULT NULL COMMENT '冻结金额',
  `md5` varchar(32) DEFAULT NULL COMMENT 'MD5',
  `add_amount` decimal(64,0) DEFAULT '0' COMMENT '累计增加金额',
  `in_amount` decimal(64,0) DEFAULT '0' COMMENT '入金',
  `out_amount` decimal(64,0) DEFAULT '0' COMMENT '出金',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `last_order` varchar(32) DEFAULT NULL COMMENT '最近一次变动对应的流水编号',
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_address`
--

DROP TABLE IF EXISTS `tstd_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_address` (
  `code` varchar(32) NOT NULL COMMENT '收件编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `addressee` varchar(64) DEFAULT NULL COMMENT '收件人姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `city` varchar(64) DEFAULT NULL COMMENT '城市',
  `area` varchar(64) DEFAULT NULL COMMENT '区',
  `detail` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `is_default` char(1) DEFAULT NULL COMMENT '是否默认地址',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_bankcard`
--

DROP TABLE IF EXISTS `tstd_bankcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_bankcard` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '户名',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `bankcard_number` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `bind_mobile` varchar(32) DEFAULT NULL COMMENT '银行卡绑定手机号',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_channel_bank`
--

DROP TABLE IF EXISTS `tstd_channel_bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_channel_bank` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '编号（自增长）',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `bank_name` varchar(32) DEFAULT NULL COMMENT '银行名称',
  `channel_type` varchar(4) DEFAULT NULL COMMENT '渠道类型',
  `status` varchar(4) DEFAULT NULL COMMENT '状态（启用/不启用）',
  `channel_bank` varchar(32) DEFAULT NULL COMMENT '渠道给银行的代号',
  `max_order` bigint(32) DEFAULT NULL COMMENT '笔数限制',
  `order_amount` bigint(32) DEFAULT NULL COMMENT '单笔限额',
  `day_amount` bigint(32) DEFAULT NULL COMMENT '每日限额',
  `month_amount` bigint(32) DEFAULT NULL COMMENT '每月限额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_charge`
--

DROP TABLE IF EXISTS `tstd_charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_charge` (
  `code` varchar(32) NOT NULL COMMENT '针对编号',
  `pay_group` varchar(32) DEFAULT NULL COMMENT '支付组号',
  `ref_no` varchar(255) DEFAULT NULL COMMENT '流水分组组号',
  `account_number` varchar(32) DEFAULT NULL COMMENT '针对账号',
  `amount` decimal(64,0) DEFAULT NULL COMMENT '充值金额',
  `account_name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '针对户名',
  `type` varchar(4) DEFAULT NULL COMMENT '账户类型',
  `currency` varchar(8) DEFAULT NULL COMMENT '币种',
  `biz_type` varchar(32) DEFAULT NULL,
  `biz_note` varchar(255) DEFAULT NULL,
  `pay_card_info` varchar(255) DEFAULT NULL COMMENT '支付渠道账号信息',
  `pay_card_no` varchar(255) DEFAULT NULL COMMENT '支付渠道账号',
  `status` varchar(4) NOT NULL COMMENT '状态',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `pay_user` varchar(32) DEFAULT NULL COMMENT '支付回录人',
  `pay_note` varchar(255) DEFAULT NULL COMMENT '支付渠道说明',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '支付渠道',
  PRIMARY KEY (`code`) COMMENT '充值订单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_cnavigate`
--

DROP TABLE IF EXISTS `tstd_cnavigate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_cnavigate` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `url` varchar(255) DEFAULT NULL COMMENT '访问Url',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 显示 0 不显示)',
  `location` varchar(32) DEFAULT NULL COMMENT '位置',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  `belong` varchar(32) DEFAULT NULL COMMENT '属于(1 全局 2 地方默认 3 地方默认编号)',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `content_type` varchar(32) DEFAULT NULL COMMENT '内容源类型',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_jour`
--

DROP TABLE IF EXISTS `tstd_jour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_jour` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `kind` varchar(32) DEFAULT NULL COMMENT '流水类型（余额流水、冻结流水）',
  `pay_group` varchar(255) DEFAULT NULL COMMENT '订单分组组号',
  `ref_no` varchar(255) DEFAULT NULL COMMENT '参考订单号',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '支付渠道类型',
  `channel_order` varchar(255) DEFAULT NULL COMMENT '支付渠道单号',
  `account_number` varchar(32) DEFAULT NULL COMMENT '账号',
  `trans_amount` decimal(64,0) DEFAULT NULL COMMENT '变动金额',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '真实姓名',
  `type` varchar(4) DEFAULT NULL COMMENT '账户类型',
  `currency` varchar(8) DEFAULT NULL COMMENT '币种',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务类型',
  `biz_note` varchar(255) DEFAULT NULL COMMENT '业务类型',
  `pre_amount` decimal(64,0) DEFAULT NULL COMMENT '变动前金额',
  `post_amount` decimal(64,0) DEFAULT NULL COMMENT '变动后金额',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `work_date` varchar(8) DEFAULT NULL COMMENT '拟对账时间',
  `check_user` varchar(32) DEFAULT NULL COMMENT '对账人',
  `check_note` varchar(255) DEFAULT NULL COMMENT '对账说明',
  `check_datetime` datetime DEFAULT NULL COMMENT '对账时间',
  `adjust_user` varchar(32) DEFAULT NULL COMMENT '调账人',
  `adjust_note` varchar(255) DEFAULT NULL COMMENT '调账说明',
  `adjust_datetime` datetime DEFAULT NULL COMMENT '调账时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_sms`
--

DROP TABLE IF EXISTS `tstd_sms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_sms` (
  `code` varchar(32) NOT NULL DEFAULT '' COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '消息类型',
  `title` varchar(255) DEFAULT NULL COMMENT '消息标题',
  `content` text COMMENT '消息内容',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_user`
--

DROP TABLE IF EXISTS `tstd_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_user` (
  `user_id` varchar(32) NOT NULL COMMENT '编号',
  `produce_type` varchar(4) DEFAULT NULL COMMENT '产生类型',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `login_pwd` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` varchar(4) DEFAULT NULL COMMENT '登录密码强度',
  `trade_pwd` varchar(32) DEFAULT NULL COMMENT '支付密码',
  `trade_pwd_strength` varchar(4) DEFAULT NULL COMMENT '支付密码强度',
  `user_referee` varchar(32) DEFAULT NULL COMMENT '推荐人编号',
  `referee_mobile` varchar(16) DEFAULT NULL COMMENT '推荐人手机号',
  `id_kind` varchar(4) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(32) DEFAULT NULL COMMENT '证件号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `create_datetime` datetime DEFAULT NULL COMMENT '注册时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) COMMENT '用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tstd_withdraw`
--

DROP TABLE IF EXISTS `tstd_withdraw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstd_withdraw` (
  `code` varchar(32) NOT NULL COMMENT '针对编号',
  `account_number` varchar(32) DEFAULT NULL COMMENT '针对账号',
  `account_name` varchar(32) DEFAULT NULL COMMENT '针对户名',
  `type` varchar(4) DEFAULT NULL COMMENT '类别（B端账号，C端账号，平台账号）',
  `amount` decimal(64,0) DEFAULT NULL COMMENT '取现金额',
  `fee` decimal(64,0) DEFAULT NULL COMMENT '手续费',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '支付渠道',
  `channel_bank` varchar(32) DEFAULT NULL COMMENT '渠道银行代号',
  `channel_order` varchar(255) DEFAULT NULL COMMENT '支付渠道编号',
  `pay_card_info` varchar(255) DEFAULT NULL COMMENT '支付渠道账号信息',
  `pay_card_no` varchar(255) DEFAULT NULL COMMENT '支付渠道账号',
  `status` varchar(4) NOT NULL COMMENT '状态',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `approve_user` varchar(32) DEFAULT NULL COMMENT '审批人',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审批说明',
  `approve_datetime` varchar(32) DEFAULT NULL COMMENT '审批时间',
  `pay_user` varchar(255) DEFAULT NULL COMMENT '支付回录人',
  `pay_note` varchar(255) DEFAULT NULL COMMENT '支付回录说明',
  `pay_group` varchar(255) DEFAULT NULL COMMENT '支付组号',
  `pay_code` varchar(255) DEFAULT NULL COMMENT '支付渠道订单编号',
  `pay_fee` decimal(64,0) DEFAULT NULL COMMENT '支付渠道手续费（矿工费）',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付回录时间',
  PRIMARY KEY (`code`) COMMENT '取现订单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_biz_log`
--

DROP TABLE IF EXISTS `tsys_biz_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_biz_log` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `parent_order` varchar(32) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=356 DEFAULT CHARSET=utf8 COMMENT='操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_biz_team`
--

DROP TABLE IF EXISTS `tsys_biz_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_biz_team` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '团队名称',
  `captain` varchar(32) DEFAULT NULL COMMENT '团队长',
  `company_code` varchar(32) DEFAULT NULL COMMENT '所属公司编号',
  `status` char(1) DEFAULT NULL COMMENT '状态（1正常0删除）',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `account_no` varchar(32) DEFAULT NULL COMMENT '收款账号',
  `bank` varchar(255) DEFAULT NULL COMMENT '收款银行',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '收款支行',
  `water_bill` varchar(255) DEFAULT NULL COMMENT '水单',
  `region` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务团队';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_config`
--

DROP TABLE IF EXISTS `tsys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(96) DEFAULT NULL,
  `ckey` varchar(765) DEFAULT NULL,
  `cvalue` text,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  `company_code` varchar(96) DEFAULT NULL,
  `system_code` varchar(96) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_department`
--

DROP TABLE IF EXISTS `tsys_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_department` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型(1=子公司，2=部门，3=岗位)',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `lead_user_id` varchar(32) DEFAULT NULL COMMENT '负责人编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '上级部门编号',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '部门表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_dict`
--

DROP TABLE IF EXISTS `tsys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` char(3) DEFAULT NULL,
  `parent_key` varchar(96) DEFAULT NULL,
  `dkey` varchar(96) DEFAULT NULL,
  `dvalue` varchar(765) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  `company_code` varchar(96) DEFAULT NULL,
  `system_code` varchar(96) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2432 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_menu`
--

DROP TABLE IF EXISTS `tsys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_menu` (
  `code` varchar(96) NOT NULL,
  `name` varchar(96) DEFAULT NULL,
  `type` varchar(6) DEFAULT NULL,
  `url` varchar(192) DEFAULT NULL,
  `order_no` varchar(24) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  `parent_code` varchar(96) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_menu_role`
--

DROP TABLE IF EXISTS `tsys_menu_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(96) DEFAULT NULL,
  `menu_code` varchar(96) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7191 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_node`
--

DROP TABLE IF EXISTS `tsys_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_node` (
  `code` varchar(32) NOT NULL COMMENT '节点编号',
  `name` varchar(255) DEFAULT NULL COMMENT '节点名称',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '流程'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_node_flow`
--

DROP TABLE IF EXISTS `tsys_node_flow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_node_flow` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `current_node` varchar(32) NOT NULL COMMENT '当前节点',
  `next_node` varchar(32) DEFAULT NULL COMMENT '下一个节点',
  `back_node` varchar(32) DEFAULT NULL COMMENT '返回节点',
  `file_list` text,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) COMMENT '节点流程配置'
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_role`
--

DROP TABLE IF EXISTS `tsys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_role` (
  `code` varchar(96) NOT NULL,
  `name` varchar(96) DEFAULT NULL,
  `level` varchar(6) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_role_node`
--

DROP TABLE IF EXISTS `tsys_role_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_role_node` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `node_code` varchar(32) DEFAULT NULL COMMENT '节点编号',
  PRIMARY KEY (`id`) COMMENT '角色节点'
) ENGINE=InnoDB AUTO_INCREMENT=569 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_ssq`
--

DROP TABLE IF EXISTS `tsys_ssq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_ssq` (
  `code` varchar(32) NOT NULL COMMENT '编码',
  `name` varchar(32) NOT NULL COMMENT '名称',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省市区';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_table_export`
--

DROP TABLE IF EXISTS `tsys_table_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_table_export` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `url` varchar(255) DEFAULT NULL COMMENT 'URL',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `update_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表格导出';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tsys_user`
--

DROP TABLE IF EXISTS `tsys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `real_name` varchar(255) DEFAULT NULL,
  `login_pwd` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` char(1) DEFAULT NULL COMMENT '登录密码强度',
  `create_datetime` datetime DEFAULT NULL COMMENT '注册时间',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `company_code` varchar(32) DEFAULT NULL,
  `department_code` varchar(32) DEFAULT NULL,
  `post_code` varchar(32) DEFAULT NULL,
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` text COMMENT '备注',
  `team_code` varchar(32) DEFAULT NULL COMMENT '所属业务团队编号',
  `archive_code` varchar(32) DEFAULT NULL COMMENT '人事档案编号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

