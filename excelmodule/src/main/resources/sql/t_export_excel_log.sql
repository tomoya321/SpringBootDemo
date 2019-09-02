SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_export_excel_log
-- ----------------------------
DROP TABLE IF EXISTS `t_export_excel_log`;
CREATE TABLE `t_export_excel_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) DEFAULT NULL,
  `create_user` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '操作人id',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件名',
  `finish_time` datetime(0) DEFAULT NULL COMMENT '完成时间',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '查询参数',
  `params_hash` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '查询参数hash',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态,1:生成中,2:有效',
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 357 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'excel导出记录' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
