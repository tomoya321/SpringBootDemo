SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_import_excel_log
-- ----------------------------
DROP TABLE IF EXISTS `t_import_excel_log`;
CREATE TABLE `t_import_excel_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) DEFAULT NULL,
  `create_user` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '操作人id',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件名',
  `finish_time` datetime(0) DEFAULT NULL COMMENT '完成时间',
  `result_json` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '查询参数',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态,1:生成中,2:有效',
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型',
  `total_count` int(10) DEFAULT NULL COMMENT '总条数',
  `success_count` int(10) DEFAULT NULL COMMENT '成功条数',
  `failed_count` int(10) DEFAULT NULL COMMENT '失败条数',
  `url` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '原始文件地址',
  `result_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '批量暂停失败文件地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 292 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'excel导入记录' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
