ALTER TABLE `tsys_user`
ADD COLUMN `job_no` VARCHAR(32) NULL COMMENT '工号' AFTER `post_code`;
