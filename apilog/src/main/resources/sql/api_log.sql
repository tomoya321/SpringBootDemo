/*
 Navicat Premium Data Transfer

 Source Server         : 卫岗uat
 Source Server Type    : MySQL
 Source Server Version : 50616
 Source Host           : rm-uf6v4h7772750ax557o.mysql.rds.aliyuncs.com:3306
 Source Schema         : wg_uat1

 Target Server Type    : MySQL
 Target Server Version : 50616
 File Encoding         : 65001

 Date: 09/08/2019 12:13:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_api_log
-- ----------------------------
DROP TABLE IF EXISTS `api_log`;
CREATE TABLE `api_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型',
  `post_time` datetime(0) DEFAULT NULL,
  `request` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '请求入参',
  `response` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '响应参数',
  `error` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '错误信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 99856 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'api调用日志' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
