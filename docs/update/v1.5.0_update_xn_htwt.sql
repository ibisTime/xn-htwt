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
ADD COLUMN `level` VARCHAR(4) NULL COMMENT '级别（0 SUV，1 轿车，2 MPV，3 跑车，4 皮卡，5 房车）' AFTER `brand_name`,
ADD COLUMN `version` VARCHAR(4) NULL COMMENT '规格/版本（1 中东 2 美规 3 加规 4 墨版 5 欧规）' AFTER `level`,
ADD COLUMN `structure` VARCHAR(4) NULL COMMENT '结构（1 两厢 2 三厢 3 掀背 4 旅行版 5 硬顶敞篷 6 软顶敞篷 7 硬顶跑车）' AFTER `version`,
ADD COLUMN `displacement` DOUBLE NULL COMMENT '排量' AFTER `structure`,
ADD COLUMN `from_place` VARCHAR(64) NULL COMMENT '车源地' AFTER `displacement`,
ADD COLUMN `procedure` VARCHAR(64) NULL COMMENT '手续' AFTER `from_place`,
ADD COLUMN `jsq_byhf` BIGINT(20) NULL COMMENT '必要花费' AFTER `sf_amount`,
ADD COLUMN `jsq_sybx` BIGINT(20) NULL COMMENT '商业保险' AFTER `jsq_byhf`,
ADD COLUMN `pic_number` INT NULL AFTER `adv_pic`;

