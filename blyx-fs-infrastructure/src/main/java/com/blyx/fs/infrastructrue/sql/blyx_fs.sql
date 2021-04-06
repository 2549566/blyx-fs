/*
 Navicat Premium Data Transfer

 Source Server         : bailiyouxuan
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 39.105.133.157:3306
 Source Schema         : blyx_fs

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 06/04/2021 20:44:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL DEFAULT '0',
  `pid` int(11) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_ID` (`id`) COMMENT 'ID为索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fs_order
-- ----------------------------
DROP TABLE IF EXISTS `fs_order`;
CREATE TABLE `fs_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_code` varchar(255) NOT NULL COMMENT '订单编码',
  `type` int(1) DEFAULT NULL COMMENT '1：防水 ',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `user_mobile` varchar(255) DEFAULT NULL COMMENT '用户手机号',
  `order_province_code` int(10) DEFAULT NULL COMMENT '省份编码',
  `order_city_code` int(10) DEFAULT NULL COMMENT '城市编码',
  `order_area_code` int(10) DEFAULT NULL COMMENT '地区编码',
  `order_province_name` varchar(255) DEFAULT NULL,
  `order_city_name` varchar(255) DEFAULT NULL,
  `order_area_name` varchar(255) DEFAULT NULL,
  `order_address_detail` varchar(255) DEFAULT NULL,
  `status` int(10) DEFAULT NULL COMMENT '订单状态',
  `worker_pin` varchar(255) DEFAULT NULL COMMENT '工人pin',
  `sum_amount` int(10) DEFAULT NULL COMMENT '订单总金额',
  `worker_amount` int(10) DEFAULT NULL COMMENT '分配给工人的金额',
  `service_fee` int(10) DEFAULT NULL COMMENT '手续费',
  `context` varchar(255) DEFAULT NULL COMMENT '客户的订单描述',
  `worker_mark` varchar(255) DEFAULT NULL COMMENT '工人给订单的备注',
  `repair_region` varchar(255) DEFAULT NULL COMMENT '修补区域',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `score` int(10) DEFAULT NULL COMMENT '用户满意度评分',
  `user_evaluation` varchar(255) DEFAULT NULL COMMENT '用户评价',
  `error_msg` varchar(255) DEFAULT NULL COMMENT '订单异常信息',
  `error_code` int(255) DEFAULT NULL COMMENT '订单异常编码：1：被其他人接走 2：虚假订单',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `modified` datetime DEFAULT NULL COMMENT '修改时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(255) DEFAULT NULL COMMENT '修改人',
  `yn` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_ORDER_CODE` (`order_code`) USING BTREE COMMENT '订单编码索引',
  KEY `IDX_WORKER_PIN` (`worker_pin`) USING BTREE COMMENT '工人pin',
  KEY `IDX_STATUS` (`status`) USING BTREE COMMENT '订单状态 '
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fs_worker
-- ----------------------------
DROP TABLE IF EXISTS `fs_worker`;
CREATE TABLE `fs_worker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pin` varchar(255) NOT NULL,
  `type` int(2) DEFAULT NULL COMMENT '类型：0:普通防水工人 10：系统管理员',
  `mobile` varchar(255) NOT NULL COMMENT '手机号',
  `id_card` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `credit_level` int(10) DEFAULT NULL COMMENT '信用等级：0-5星，越大信用越高',
  `score` int(10) DEFAULT NULL COMMENT '用户评分',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(255) DEFAULT NULL COMMENT '身份证姓名',
  `references_pin` varchar(255) DEFAULT NULL COMMENT '推荐人pin',
  `image_header` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `password` varchar(255) DEFAULT NULL COMMENT '登陆密码',
  `address_province_code` int(10) DEFAULT NULL COMMENT '省份编码',
  `address_city_code` int(10) DEFAULT NULL COMMENT '市区编码',
  `address_area_code` int(10) DEFAULT NULL COMMENT '地区编码',
  `address_province_name` varchar(255) DEFAULT NULL,
  `address_city_name` varchar(255) DEFAULT NULL,
  `address_area_name` varchar(255) DEFAULT NULL,
  `address_detail` varchar(255) DEFAULT NULL,
  `locate_info` varchar(255) DEFAULT NULL COMMENT '定位信息',
  `is_auth` tinyint(1) DEFAULT NULL COMMENT '是否已认证：0：未认证，1：已认证',
  `is_accept_order` tinyint(1) DEFAULT NULL COMMENT '是否接受订单：1:接单，0：不接单',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `modified` datetime DEFAULT NULL COMMENT '修改日期',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(255) DEFAULT NULL COMMENT '修改人',
  `yn` tinyint(1) DEFAULT NULL COMMENT '该条记录是否有效 1：有效0：无效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_PIN` (`pin`) USING BTREE,
  UNIQUE KEY `IDX_MOBILE` (`mobile`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
