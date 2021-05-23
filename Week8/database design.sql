CREATE DATABASE `orderdb0` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
CREATE DATABASE `orderdb1` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

use `orderdb0`;

CREATE TABLE `order0`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order1`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order2`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order3`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order4`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order5`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order6`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order7`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order8`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order9`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order10`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order11`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order12`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order13`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order14`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order15`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

use `orderdb1`;

CREATE TABLE `order0`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order1`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order2`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order3`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order4`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order5`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order6`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order7`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order8`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order9`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order10`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order11`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order12`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order13`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order14`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `order15`
(
    `order_id`     bigint(19)    NOT NULL,
    `product_id`   mediumint(32) NOT NULL COMMENT '产品id',
    `shop_id`      int(11)       NOT NULL COMMENT '店铺id',
    `uid`          mediumint(32) NOT NULL COMMENT '购买用户id',
    `nums`         smallint(8)   NOT NULL COMMENT '购买数量',
    `sale_price`   decimal(9, 2) NOT NULL COMMENT '销售价格',
    `origin_price` decimal(9, 2) NOT NULL COMMENT '原始价格',
    `discount`     varchar(45)            DEFAULT '0.0' COMMENT '折扣',
    `is_payed`     tinyint(1)    NOT NULL DEFAULT '0' COMMENT '是否支付',
    `address`      varchar(255)  NOT NULL COMMENT '用户地址',
    `phone`        varchar(15)   NOT NULL COMMENT '用户电话',
    `username`     varchar(45)   NOT NULL COMMENT '用户名',
    `province`     varchar(45)   NOT NULL COMMENT '省份',
    `city`         varchar(45)   NOT NULL COMMENT '城市',
    `area`         varchar(45)   NOT NULL COMMENT '区域',
    `create_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date`  datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `ordeid_UNIQUE` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;