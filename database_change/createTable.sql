-- 创建用户表
CREATE TABLE `user_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_name` varchar (20) NOT NULL COMMENT '用户名',
  `user_password` varchar(31) NOT NULL COMMENT '用户密码',
  `user_age` int DEFAULT NULL COMMENT '用户年龄',
  `user_authority` varchar(20) DEFAULT NULL COMMENT '用户权限vip管理员或普通用户',
  `phone_number` varchar(20) NOT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


-- 创建新闻表


-- 创建标签表 -标签名也作为主键


-- 创建评论表


-- 创建回复表

