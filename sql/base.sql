/*
 Navicat Premium Data Transfer

 Source Server         : localhost(windows)
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : bare

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 11/04/2022 09:10:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

--
-- 数据库： `bare`
--
CREATE DATABASE IF NOT EXISTS `bare` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bare`;

-- ----------------------------
-- Table structure for pb_cookie_config
-- ----------------------------
DROP TABLE IF EXISTS `pb_cookie_config`;
CREATE TABLE `pb_cookie_config`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`platform` tinyint(3) NOT NULL DEFAULT 1 COMMENT '平台标识 1:小红书',
`cookie` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '网站cookie',
`create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'cookie配置表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
