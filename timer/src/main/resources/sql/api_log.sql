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
