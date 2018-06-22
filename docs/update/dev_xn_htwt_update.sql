ALTER TABLE `tp_archive` 
DROP COLUMN `is_delete`;

ALTER TABLE `tp_social_relation` 
DROP COLUMN `is_delete`;

ALTER TABLE `tsys_biz_team` 
ADD COLUMN `region` VARCHAR(255) NULL AFTER `water_bill`,
ADD COLUMN `place` VARCHAR(255) NULL AFTER `region`;


