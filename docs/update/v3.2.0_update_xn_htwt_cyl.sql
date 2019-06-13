INSERT INTO `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('car_refresh', 'url', 'http://api.che300.com/service', 'USYS201800000000001', now(), '车辆刷新url', 'CD-CHTWT000020', 'CD-CHTWT000020');
INSERT INTO `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('car_refresh', 'token', 'ed34a9f390e806112420863423cd8dbc', 'USYS201800000000001', now(), '车辆刷新token', 'CD-CHTWT000020', 'CD-CHTWT000020');


ALTER TABLE `tht_brand`
ADD COLUMN `brand_id` VARCHAR(255) NULL COMMENT '品牌标识' AFTER `code`,
ADD COLUMN `type` VARCHAR(4) NULL COMMENT '品牌类型（1接口导入,2用户新增）' AFTER `brand_id`;

ALTER TABLE `tht_series`
ADD COLUMN `brand_id` VARCHAR(255) NULL COMMENT '品牌标识' AFTER `code`,
ADD COLUMN `series_id` VARCHAR(255) NULL COMMENT '车系标识' AFTER `brand_id`,
ADD COLUMN `type` VARCHAR(4) NULL COMMENT '车系类型（1接口导入,2用户新增）' AFTER `series_id`,
ADD COLUMN `maker_type` VARCHAR(4) NULL COMMENT '制造商类型' AFTER `type`,
ADD COLUMN `series_group_name` VARCHAR(255) NULL COMMENT '系列组名' AFTER `name`;

ALTER TABLE `tht_car`
ADD COLUMN `series_id` VARCHAR(255) NULL COMMENT '车系标识' AFTER `is_referee`,
ADD COLUMN `model_id` VARCHAR(255) NULL COMMENT '车型标识' AFTER `series_id`,
ADD COLUMN `type` VARCHAR(4) NULL COMMENT '车型类型（1接口导入,2用户新增）' AFTER `model_id`,
ADD COLUMN `model_year` VARCHAR(255) NULL COMMENT '年款' AFTER `sale_price`,
ADD COLUMN `min_reg_year` VARCHAR(255) NULL COMMENT '最小上牌年份' AFTER `model_year`,
ADD COLUMN `max_reg_year` VARCHAR(255) NULL COMMENT '最大上牌年份' AFTER `min_reg_year`,
ADD COLUMN `liter` VARCHAR(255) NULL COMMENT '排量' AFTER `max_reg_year`,
ADD COLUMN `gear_type` VARCHAR(255) NULL COMMENT '变速箱' AFTER `liter`,
ADD COLUMN `discharge_standard` VARCHAR(255) NULL COMMENT '排放标准' AFTER `gear_type`,
ADD COLUMN `seat_number` VARCHAR(255) NULL COMMENT '座位数' AFTER `discharge_standard`;
