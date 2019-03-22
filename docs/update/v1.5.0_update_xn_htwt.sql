ALTER TABLE `tmall_product_order` 
ADD COLUMN `repay_biz_code` VARCHAR(32) NULL COMMENT '还款业务编号' AFTER `code`,
ADD COLUMN `bankcardCode` VARCHAR(32) NULL COMMENT '银行卡编号' AFTER `product_specs_name`,
ADD COLUMN `sf_amount` BIGINT(20) NULL COMMENT '首付金额' AFTER `sf_rate`,
ADD COLUMN `loan_amount` BIGINT(20) NULL COMMENT '贷款金额' AFTER `sf_amount`,
ADD COLUMN `status` VARCHAR(4) NULL COMMENT '状态' AFTER `periods`;
ADD COLUMN `yunfei` BIGINT(20) NULL COMMENT '运费' AFTER `bank_rate`,
ADD COLUMN `deliverer` VARCHAR(32) NULL COMMENT '发货人' AFTER `yunfei`,
ADD COLUMN `delivery_datetime` DATETIME NULL COMMENT '发货时间' AFTER `deliverer`,
ADD COLUMN `logistics_company` VARCHAR(32) NULL COMMENT '物流公司编号' AFTER `delivery_datetime`,
ADD COLUMN `logistics_code` VARCHAR(32) NULL COMMENT '物流单号' AFTER `logistics_company`,
ADD COLUMN `pdf` VARCHAR(255) NULL COMMENT '物流单' AFTER `logistics_code`,
ADD COLUMN `signer` VARCHAR(32) NULL COMMENT '签收人' AFTER `pdf`,
ADD COLUMN `sign_datetime` DATETIME NULL COMMENT '签收时间' AFTER `signer`, COMMENT = '订单快照' , RENAME TO  `dev_xn_htwt`.`tmall_specs_order` ;


ALTER TABLE `tmall_order` 
DROP COLUMN `sign_datetime`,
DROP COLUMN `signer`,
DROP COLUMN `pdf`,
DROP COLUMN `logistics_code`,
DROP COLUMN `logistics_company`,
DROP COLUMN `delivery_datetime`,
DROP COLUMN `deliverer`,
DROP COLUMN `bank_rate`,
DROP COLUMN `periods`,
DROP COLUMN `loan_amount`,
DROP COLUMN `sf_amount`,
DROP COLUMN `sf_rate`,
DROP COLUMN `bankcard_code`,
DROP COLUMN `repay_biz_code`,
CHANGE COLUMN `amount` `amount` BIGINT(20) NULL DEFAULT NULL COMMENT '总金额' ,
CHANGE COLUMN `yunfei` `yunfei` BIGINT(20) NULL DEFAULT NULL COMMENT '总运费' , COMMENT = '订单' ;


ALTER TABLE `tstd_user` 
DROP COLUMN `kind`;

ALTER TABLE `tht_brand` 
ADD COLUMN `is_referee` VARCHAR(4) NULL COMMENT '是否推荐' AFTER `code`;


ALTER TABLE `tht_series` 
ADD COLUMN `pic_number` INT NULL COMMENT '照片数量' AFTER `adv_pic`,
ADD COLUMN `highest` BIGINT(20) NULL COMMENT '最高价' AFTER `price`,
ADD COLUMN `lowest` BIGINT(20) NULL COMMENT '最低价' AFTER `highest`,
ADD COLUMN `level` VARCHAR(4) NULL COMMENT '级别（0 SUV，1 轿车，2 MPV，3 跑车，4 皮卡，5 房车）' AFTER `lowest`,
ADD COLUMN `is_referee` VARCHAR(4) NULL COMMENT '是否推荐' AFTER `level`;


ALTER TABLE `tht_car` 
ADD COLUMN `is_referee` VARCHAR(4) NULL COMMENT '是否推荐' AFTER `code`,
ADD COLUMN `bank_code` VARCHAR(32) NULL COMMENT '银行编号' AFTER `brand_name`,
ADD COLUMN `level` VARCHAR(4) NULL COMMENT '级别（0 SUV，1 轿车，2 MPV，3 跑车，4 皮卡，5 房车）' AFTER `bank_code`,
ADD COLUMN `version` VARCHAR(4) NULL COMMENT '规格/版本（1 中东 2 美规 3 加规 4 墨版 5 欧规）' AFTER `level`,
ADD COLUMN `structure` VARCHAR(4) NULL COMMENT '结构（1 两厢 2 三厢 3 掀背 4 旅行版 5 硬顶敞篷 6 软顶敞篷 7 硬顶跑车）' AFTER `version`,
ADD COLUMN `displacement` DOUBLE NULL COMMENT '排量' AFTER `structure`,
ADD COLUMN `from_place` VARCHAR(64) NULL COMMENT '车源地' AFTER `displacement`,
ADD COLUMN `car_procedure` VARCHAR(64) NULL COMMENT '手续' AFTER `from_place`,
ADD COLUMN `fw_amount` BIGINT(20) NULL COMMENT '服务费' AFTER `sf_amount`,
ADD COLUMN `jsq_byhf` BIGINT(20) NULL COMMENT '必要花费' AFTER `fw_amount`,
ADD COLUMN `jsq_sybx` BIGINT(20) NULL COMMENT '商业保险' AFTER `jsq_byhf`,
ADD COLUMN `pic_number` INT NULL AFTER `adv_pic`;

DROP TABLE IF EXISTS `tht_carconfig`;
CREATE TABLE `tht_carconfig` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `name` VARCHAR(64) NULL COMMENT '名称',
  `pic` VARCHAR(255) NULL COMMENT '图片',
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
COMMENT = '车辆配置';

DROP TABLE IF EXISTS `tht_car_carconfig`;
CREATE TABLE `tht_car_carconfig` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `car_code` VARCHAR(32) NULL COMMENT '车型编号',
  `config_code` VARCHAR(32) NULL COMMENT '配置编号',
  PRIMARY KEY (`code`))
COMMENT = '车型配置';

ALTER TABLE `tht_car_order` 
ADD COLUMN `name` VARCHAR(64) NULL COMMENT '申请人姓名' AFTER `user_mobile`;

DROP TABLE IF EXISTS `tht_car_news`;
CREATE TABLE `tht_car_news` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `title` VARCHAR(255) NULL COMMENT '标题',
  `author` VARCHAR(64) NULL COMMENT '作者',
  `adv_pic` VARCHAR(255) NULL COMMENT '广告图',
  `pic_number` INT NULL COMMENT '图片数量',
  `pic` VARCHAR(255) NULL COMMENT '图片',
  `read_count` BIGINT(20) NULL COMMENT '阅读量',
  `context` TEXT NULL COMMENT '内容',
  `tag` VARCHAR(255) NULL COMMENT '标签',
  `status` VARCHAR(4) NULL COMMENT '状态（0 待上架，1 上架，2 下架）',
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
COMMENT = '车辆资讯';

DROP TABLE IF EXISTS `tht_action`;
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


insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('hot_series','benz','奔驰','admin',now(),'热门车系','CD-CHTWT000020','CD-CHTWT000020');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('hot_series','BMW','宝马','admin',now(),'热门车系','CD-CHTWT000020','CD-CHTWT000020');

insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('kf_phone','kf_phone','4008888666','admin',now(),'客服电话','CD-CHTWT000020','CD-CHTWT000020');
