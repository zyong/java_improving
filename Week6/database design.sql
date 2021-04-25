'CREATE DATABASE `taobaobao` /*!40100 DEFAULT CHARACTER SET utf8mb4 */';

'CREATE TABLE `user` (
  `uid` mediumint(32) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT ''用户名'',
  `passwd` char(32) NOT NULL COMMENT ''密码'',
  `avatar` varchar(1024) NOT NULL COMMENT ''头像'',
  `email` varchar(255) DEFAULT NULL COMMENT ''邮箱地址'',
  `phone` char(11) DEFAULT NULL COMMENT ''手机号'',
  `telephone` varchar(15) DEFAULT NULL COMMENT ''电话'',
  `is_vallid_email` tinyint(1) DEFAULT ''0'' COMMENT ''是否验证邮箱'',
  `is_valid_phone` tinyint(1) DEFAULT ''0'' COMMENT ''是否验证手机'',
  `is_valid_telephone` tinyint(1) DEFAULT ''0'' COMMENT ''是否验证电话'',
  `is_del` tinyint(1) NOT NULL DEFAULT ''0'' COMMENT ''是否删除'',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `id_UNIQUE` (`uid`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `telephone_UNIQUE` (`telephone`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4';

'CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT ''产品名'',
  `description` varchar(255) DEFAULT '''' COMMENT ''''''描述'''''',
  `category` smallint(12) unsigned NOT NULL COMMENT ''一级类目'',
  `child_category` smallint(12) unsigned NOT NULL COMMENT ''二级类目'',
  `price` decimal(9,2) DEFAULT ''0.00'' COMMENT ''产品单价'',
  `shop_id` int(11) NOT NULL COMMENT ''商家id'',
  `is_del` tinyint(1) NOT NULL DEFAULT ''0'' COMMENT ''是否删除'',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4'


'CREATE TABLE `order` (
  `order_id` bigint(19) NOT NULL,
  `product_id` mediumint(32) NOT NULL COMMENT ''产品id'',
  `shop_id` int(11) NOT NULL COMMENT ''店铺id\n'',
  `uid` mediumint(32) NOT NULL COMMENT ''购买用户id\n'',
  `nums` smallint(8) NOT NULL COMMENT ''购买数量'',
  `sale_price` decimal(9,2) NOT NULL COMMENT ''销售价格\n'',
  `origin_price` decimal(9,2) NOT NULL COMMENT ''原始价格\n'',
  `discount` varchar(45) DEFAULT ''0.0'' COMMENT ''折扣\n'',
  `is_payed` tinyint(1) NOT NULL DEFAULT ''0'' COMMENT ''是否支付'',
  `address` varchar(255) NOT NULL COMMENT ''用户地址'',
  `phone` varchar(15) NOT NULL COMMENT ''用户电话'',
  `username` varchar(45) NOT NULL COMMENT ''用户名'',
  `province` varchar(45) NOT NULL COMMENT ''省份'',
  `city` varchar(45) NOT NULL COMMENT ''城市'',
  `area` varchar(45) NOT NULL COMMENT ''区域'',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4';

'CREATE TABLE `shop` (
  `shop_id` mediumint(19) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT ''店名'',
  `description` varchar(255) NOT NULL COMMENT ''店描述'',
  `manage_id` int(11) NOT NULL COMMENT ''管理员ID\n'',
  `category` smallint(6) NOT NULL COMMENT ''店铺分类'',
  `child_category` smallint(6) NOT NULL COMMENT ''子目录'',
  `is_valid` tinyint(1) NOT NULL DEFAULT ''0'' COMMENT ''是否验证有效'',
  `is_del` tinyint(1) NOT NULL DEFAULT ''0'' COMMENT ''是否删除'',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`shop_id`),
  UNIQUE KEY `shop_UNIQUE` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4';



