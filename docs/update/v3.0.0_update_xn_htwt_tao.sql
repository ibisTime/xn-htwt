
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('budget_order','budget_gps_deduct_rate','0.006','U201807081543249555383','2018-08-25 11:32:47','GPS提成比例','CD-CHTWT000020','CD-CHTWT000020');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('budget_order','budget_oil_subsidy_rate','0.006','U201807081543249555383','2018-08-25 11:32:47','油补提成比例','CD-CHTWT000020','CD-CHTWT000020');

ALTER TABLE `tqj_cdbiz` 
DROP COLUMN `ywy_user`,
ADD COLUMN `captain_code` VARCHAR(32) NULL AFTER `team_code`,
ADD COLUMN `sale_user_id` VARCHAR(32) NULL COMMENT '业务员编号' AFTER `captain_code`,
ADD COLUMN `inside_job` VARCHAR(32) NULL COMMENT '内勤' AFTER `sale_user_id`,
ADD COLUMN `loan_bank` VARCHAR(32) NULL COMMENT '经办银行' AFTER `inside_job`,
ADD COLUMN `loan_amount` BIGINT(20) NULL COMMENT '贷款金额' AFTER `loan_bank`,
ADD COLUMN `enter_location` VARCHAR(32) NULL COMMENT '入档位置' AFTER `loan_amount`,
ADD COLUMN `enter_datetime` DATETIME NULL COMMENT '入档时间' AFTER `enter_location`,
ADD COLUMN `enter_filelist` VARCHAR(32) NULL COMMENT '档案目录' AFTER `enter_datetime`,
ADD COLUMN `make_card_status` VARCHAR(4) NULL COMMENT '制卡状态' AFTER `status`,
ADD COLUMN `cur_node_code` VARCHAR(5) NULL COMMENT '当前节点' AFTER `zf_status`,
ADD COLUMN `intev_cur_node_code` VARCHAR(5) NULL COMMENT '面签节点' AFTER `cur_node_code`,
ADD COLUMN `make_card_node` VARCHAR(5) NULL COMMENT '制卡节点' AFTER `intev_cur_node_code`,
ADD COLUMN `fbhgps_node` VARCHAR(5) NULL COMMENT '发保合gps节点' AFTER `make_card_node`,
ADD COLUMN `cancel_node_code` VARCHAR(5) NULL COMMENT '客户作废节点' AFTER `fbhgps_node`,
ADD COLUMN `is_gps_az` VARCHAR(4) NULL COMMENT '是否安装gps' AFTER `cancel_node_code`,
ADD COLUMN `is_finacing` VARCHAR(4) NULL COMMENT '是否融资' AFTER `is_gps_az`,
ADD COLUMN `is_advance_fund` VARCHAR(4) NULL COMMENT '是否垫资' AFTER `is_finacing`,
ADD COLUMN `is_plat_insure` VARCHAR(4) NULL COMMENT '是否我司续保' AFTER `is_advance_fund`,
ADD COLUMN `should_fee_amount` BIGINT(20) NULL COMMENT '应收手续费总额' AFTER `is_plat_insure`,
ADD COLUMN `real_fee_amount` BIGINT(20) NULL COMMENT '实收手续费总额' AFTER `should_fee_amount`,
ADD COLUMN `gua_mode` VARCHAR(4) NULL COMMENT '担保方式' AFTER `real_fee_amount`,
ADD COLUMN `credit_note` VARCHAR(255) NULL COMMENT '征信说明' AFTER `gua_mode`,
ADD COLUMN `apply_datetime` DATETIME NULL COMMENT '申请时间' AFTER `credit_note`,
ADD COLUMN `remark` VARCHAR(255) NULL COMMENT '备注' AFTER `apply_datetime`,
CHANGE COLUMN `team_code` `team_code` VARCHAR(32) NULL AFTER `company_code`,
CHANGE COLUMN `main_loaner` `type` VARCHAR(4) NULL DEFAULT NULL ,
CHANGE COLUMN `bank_code` `biz_type` VARCHAR(4) NULL DEFAULT NULL ,
CHANGE COLUMN `biz_type` `repay_biz_code` VARCHAR(32) NULL DEFAULT NULL ,
CHANGE COLUMN `bank_credit_result_pdf` `bank_credit_result` VARCHAR(4) NULL DEFAULT NULL ,
CHANGE COLUMN `dk_amount` `company_code` VARCHAR(32) NULL DEFAULT NULL ;

ALTER TABLE `tdq_file_list` 
ADD COLUMN `vname` VARCHAR(32) NULL AFTER `kname`,
ADD COLUMN `attach_type` VARCHAR(32) NULL AFTER `vname`,
CHANGE COLUMN `no` `category` VARCHAR(32) NULL DEFAULT NULL COMMENT '序号' ,
CHANGE COLUMN `name` `kname` VARCHAR(32) NULL DEFAULT NULL COMMENT '名称' ;

INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_price', 'used_car_current_rate', '二手车市场成交价最低及最高截图', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_price', 'third_valuation_pdf', '第三方评估价截图（车辆价格核实报告）', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_price', 'second_car_report', '二手车评估报告', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_price', 'second_300_pdf', '车300评估页', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_price', 'second_qxb_pic', '汽修宝截图', '图片', '1');

INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'drive_license_front', '行驶证正面', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'drive_license_reverse', '行驶证反面', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'car_invoice', '车辆发票', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'car_hgz_pic', '合格证', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'car_jqx', '交强险', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'car_syx', '商业险', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'duty_paid_prove_smj', '完税证明扫描件', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'green_big_smj', '绿大本扫描件', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'car_regcerti', '机动车登记证书', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'car_xsz_smj', '车辆行驶证扫描件', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_procedure', 'car_pd', '车辆批单', '图片', '1');

INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'car_key', '车钥匙', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'forward_pdf', '车辆照片正前', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'queen_pdf', '车辆照片正后', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'left_pdf', '车辆照片正左', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'right_pdf', '车辆照片正右', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'lf45_pdf', '车辆照片左前45º', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'rf45_pdf', '车辆照片右前45º', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'lg45_pdf', '车辆照片左后45º', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'rr45_pdf', '车辆照片右后45º', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'engine_pdf', '车辆照片发动机仓', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'szm_pdf', '车辆中控台照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'gears_pdf', '车辆档位照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'functional_zone_pdf', '车辆功能区里照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'odometer_pdf', '车辆里程表照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'front_row_pdf', '车辆前排内饰照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'rock_row_pdf', '车辆中排内饰照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'trunk_pdf', '车辆后备箱照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'louver_pdf', '车辆天窗照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'bank_row_pdf', '车辆后排娱乐系统照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'car_config', 'check_approve_pdf', '车辆核准截图', '图片', '1');

INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'interview', 'bank_video', '银行视频', '视频', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'interview', 'bank_contract', '银行合同', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'interview', 'bank_photo', '银行面签照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'interview', 'company_video', '公司视频', '视频', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'interview', 'company_contract', '公司合同', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'interview', 'other_video', '其他视频', '视频', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'interview', 'advance_fund_amount_pdf', '资金划转授权书', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'interview', 'interview_other_pdf', '面签其他资料', '图片', '1');

INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'id_no_front_gua', '担保人身份证正面', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'id_no_reverse_gua', '担保人身份证反面', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'auth_pdf_gua', '担保人征信查询授权书', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'interview_pic_gua', '担保人面签照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'house_picture_gua', '担保人家访照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'bank_report_gua', '担保人银行征信报告', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'data_report_gua', '担保人大数据报告', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'hkb_gua', '担保人户口本', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'asset_pdf_gua', '担保人资产资料pdf', '图片', '1');

INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'id_no_front_apply', '申请人身份证正面', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'id_no_reverse_apply', '申请人身份证反面', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'auth_pdf_apply', '申请人征信查询授权书', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'interview_pic_apply', '申请人面签照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'house_picture_apply', '申请人家访照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'bank_report_apply', '申请人银行征信报告', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'data_report_apply', '申请人大数据报告', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'hkb_apply', '申请人户口本', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'asset_pdf_apply', '申请人资产资料pdf', '图片', '1');

INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'id_no_front_gh', '共还人身份证正面', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'id_no_reverse_gh', '共还人身份证反面', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'auth_pdf_gh', '共还人征信查询授权书', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'interview_pic_gh', '共还人面签照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'house_picture_gh', '共还人家访照片', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'bank_report_gh', '共还人银行征信报告', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'data_report_gh', '共还人大数据报告', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'hkb_gh', '共还人户口本', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user', 'asset_pdf_gh', '共还人资产资料pdf', '图片', '1');

INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'house_contract', '购房合同', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'house_property', '房产证', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'license', '营业执照', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'site_prove', '场地证明', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'drice_license', '驾照', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'marry_pdf', '结婚证资料', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'other_pdf', '其他资料', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'work_asset_pdf', '工作资料上传', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'single_prove_pdf', '单身证明', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'income_prove_pdf', '收入证明', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'live_prove_pdf', '居住证明', '图片', '1');
INSERT INTO `tdq_file_list` ( `category`, `kname`, `vname`, `attach_type`, `number`) VALUES ( 'credit_user_ext', 'build_prove_pdf', '自建房证明', '图片', '1');


