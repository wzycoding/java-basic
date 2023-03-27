create table t_goods
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        varchar(20)   NOT NULL COMMENT '商品名称',
    `price`       int(10) NOT NULL COMMENT '商品价格',
    `description` varchar(1024) NOT NULL COMMENT '商品描述',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3),
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '商品表';

-- 初始化数据

insert into t_goods(`name`, `price`, `description`)
values ('小米10s', 240000, '米粉最爱，销量冠军');

insert into t_goods(`name`, `price`, `description`)
values ('MacBook PRO 16+512', 1600000, '生产力首选');

insert into t_goods(`name`, `price`, `description`)
values ('小米12s', 440000, '新旗舰，快来买');

insert into t_goods(`name`, `price`, `description`)
values ('菠萝手机', 34000, '菠萝手机，高端大气');

insert into t_goods(`name`, `price`, `description`)
values ('诺基亚', 50000, '质量王者，摔坏算我输');

create table t_category
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        varchar(20)   NOT NULL COMMENT '分类名称',
    `description` varchar(1024) NOT NULL COMMENT '分类描述',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3),
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '商品分类表';

create table t_goods_category_relation
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `goods_id`    bigint(20) NOT NULL COMMENT '商品id',
    `category_id` bigint(20) NOT NULL COMMENT '分类id',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '商品分类关联关系表';

insert into t_category(`name`, `description`)
values ('手机', '这是手机的分类');
insert into t_category(`name`, `description`)
values ('电脑', '这是电脑的分类');

insert into t_goods_category_relation(`goods_id`, `category_id`)
values (1, 1);
insert into t_goods_category_relation(`goods_id`, `category_id`)
values (2, 2);
insert into t_goods_category_relation(`goods_id`, `category_id`)
values (3, 1);
insert into t_goods_category_relation(`goods_id`, `category_id`)
values (4, 1);
insert into t_goods_category_relation(`goods_id`, `category_id`)
values (5, 1);

create table t_user_login_record_0
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';

create table t_user_login_record_1
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';

create table t_user_login_record_2
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';

create table t_user_login_record_3
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';

create table t_user_login_record_4
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';

create table t_user_login_record_5
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';

create table t_user_login_record_6
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';

create table t_user_login_record_7
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';

create table t_user_login_record_8
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';

create table t_user_login_record_9
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`    bigint(20) NOT NULL COMMENT '商品id',
    `login_type` int(11) NOT NULL COMMENT '登录方式：0：手机号码登录，1：微信登录，2：一键登录',
    `login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '登录时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户登录记录表';
