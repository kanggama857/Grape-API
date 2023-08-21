# 数据库初始化
-- 创建库
create database if not exists openapi;

-- 切换库
use openapi;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    `accessKey`  varchar(512) not null comment 'accessKey',
    `secretKey`  varchar(512) not null comment 'secretKey',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) comment '用户';

-- 接口信息
create table if not exists openapi.`interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '名称',
    `description` varchar(256) null comment '描述',
    `url` varchar(512) not null comment '接口地址',
    `requestParams` text not null comment '请求参数',
    `requestHeader` text null comment '请求头',
    `responseHeader` text null comment '响应头',
    `status` int default 0 not null comment '接口状态（0-关闭，1-开启）',
    `method` varchar(256) not null comment '请求类型',
    `userId` bigint not null comment '创建人',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '接口信息';
-- ----------------------------
-- Records of interface_info
-- ----------------------------
INSERT INTO `interface_info` VALUES (3, 'getName', '获取用户名', 'http://localhost:8123/api/interface/name/user', 1, '{\"Content-Type\":\"application/json\"}', '{\"Content-Type\":\"application/json\"}', 1, 'post',1, '2023-07-08 20:00:14', '2023-07-08 20:00:14', 0);
INSERT INTO `interface_info` VALUES (4, 'getRandomWork', '随机文本', 'http://localhost:8123/api/interface/random/word', 1, NULL, NULL, 1,'get', 1, '2023-07-29 20:33:55', '2023-07-29 20:33:55', 0);
INSERT INTO `interface_info` VALUES (5, 'getRandomImageUrl', '随机动漫图片地址', 'http://localhost:8123/api/interface/random/image', 1, NULL, NULL, 1,'post', 1, '2023-07-29 21:51:08', '2023-07-29 21:51:08', 0);
INSERT INTO `interface_info` VALUES (6, 'getDayWallpaperUrl', '每日壁纸URL', 'http://localhost:8123/api/interface/day/wallpaper', 1, NULL, NULL, 1, 'post',1, '2023-07-29 22:20:10', '2023-07-29 22:20:10', 0);

-- 用户调用接口关系表
create table if not exists openapi.`user_interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `userId` bigint not null comment '调用用户 id',
    `interfaceInfoId` bigint not null comment '接口 id',
    `totalNum` int default 0 not null comment '总调用次数',
    `leftNum` int default 0 not null comment '剩余调用次数',
    `status` int default 0 not null comment '0-正常，1-禁用',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户调用接口关系';
-- ----------------------------
-- Records of user_interface_info
-- ----------------------------
INSERT INTO `user_interface_info` VALUES (1, 1, 3, 2, 98, 0, '2023-08-02 17:11:46', '2023-08-02 17:11:46', 0);
INSERT INTO `user_interface_info` VALUES (7, 1, 3, 2, 22, 0, '2023-08-02 17:11:48', '2023-08-02 17:11:48', 0);
INSERT INTO `user_interface_info` VALUES (8, 1, 4, 1, 189, 0, '2023-08-02 17:10:02', '2023-08-02 17:10:02', 0);
INSERT INTO `user_interface_info` VALUES (9, 1, 5, 1, 98, 0, '2023-08-02 17:10:34', '2023-08-02 17:10:34', 0);
INSERT INTO `user_interface_info` VALUES (10, 1, 6, 0, 99, 0, '2023-08-02 17:10:20', '2023-08-02 17:10:20', 0);
INSERT INTO `user_interface_info` VALUES (11, 1, 4, 0, 99, 0, '2023-08-02 17:10:20', '2023-08-02 17:10:20', 0);
INSERT INTO `user_interface_info` VALUES (12, 1, 5, 0, 98, 0, '2023-08-02 17:10:22', '2023-08-02 17:10:22', 0);
