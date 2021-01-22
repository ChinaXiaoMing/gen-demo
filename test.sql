/*
 Navicat Premium Data Transfer

 Source Server         : localhost_root
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 22/01/2021 17:48:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '登录日志id',
  `login_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录IP',
  `login_status` int(2) NOT NULL COMMENT '登录状态（1：成功，0：失败）',
  `login_time` datetime(0) NOT NULL COMMENT '登录时间',
  `spend_time` bigint(32) NOT NULL COMMENT '登录耗时（单位：ms）',
  `browser_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器名称',
  `browser_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器类型',
  `browser_version` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operation_system` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (2, 'xiaoming', '127.0.0.1', 1, '2018-05-18 17:04:51', 327, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (3, 'xiaoming', '127.0.0.1', 1, '2018-05-18 17:05:18', 2, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (4, 'xiaoming', '127.0.0.1', 1, '2018-05-18 17:06:57', 6, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (5, 'xiaoming', '127.0.0.1', 1, '2018-05-18 17:26:45', 10, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (6, 'xiaoming', '127.0.0.1', 1, '2018-05-22 10:17:17', 522, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (7, 'xiaoming', '127.0.0.1', 1, '2018-05-22 10:25:17', 326, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (8, 'xiaoming', '127.0.0.1', 1, '2018-05-22 10:27:40', 344, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (9, 'xiaoming', '127.0.0.1', 1, '2018-05-22 10:29:43', 308, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (10, 'xiaoming', '127.0.0.1', 1, '2018-05-22 10:36:29', 304, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (11, 'xiaoming', '127.0.0.1', 1, '2018-05-22 10:49:13', 313, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (12, 'xiaoming', '127.0.0.1', 1, '2018-05-22 10:53:46', 339, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (13, 'xiaoming', '127.0.0.1', 1, '2018-05-22 10:55:06', 302, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (14, 'xiaoming', '127.0.0.1', 1, '2018-05-22 11:00:29', 322, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (15, 'xiaoming', '127.0.0.1', 1, '2018-05-22 11:13:00', 323, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (16, 'xiaoming', '127.0.0.1', 1, '2018-05-22 11:16:40', 666, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (17, 'xiaoming', '127.0.0.1', 1, '2018-05-22 11:23:25', 380, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (18, 'xiaoming', '127.0.0.1', 1, '2018-05-22 11:35:07', 474, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (19, 'xiaoming', '127.0.0.1', 1, '2018-05-22 18:17:31', 796, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (20, 'xiaoming', '127.0.0.1', 1, '2018-05-23 09:23:46', 434, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (21, 'xiaoming', '127.0.0.1', 1, '2018-05-23 09:24:55', 748, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (22, 'xiaoming', '127.0.0.1', 1, '2018-05-23 11:46:41', 345, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (23, 'xiaoming', '127.0.0.1', 1, '2018-05-23 11:54:03', 361, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (24, 'xiaoming', '127.0.0.1', 1, '2018-05-23 11:54:08', 1, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (25, 'xiaoming', '127.0.0.1', 1, '2018-05-23 11:54:22', 1, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (26, 'xiaoming', '127.0.0.1', 1, '2018-05-23 11:54:28', 2, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (27, 'xiaoming', '127.0.0.1', 1, '2018-05-23 11:54:37', 1, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (28, 'xiaoming', '127.0.0.1', 1, '2018-05-23 13:47:50', 703, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (29, 'xiaoming', '127.0.0.1', 1, '2018-05-23 13:48:03', 1, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (30, 'xiaoming', '127.0.0.1', 1, '2018-05-23 13:48:09', 1, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (31, 'xiaoming', '127.0.0.1', 1, '2018-05-23 13:48:13', 2, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (32, 'xiaoming', '127.0.0.1', 1, '2018-05-23 14:10:10', 323, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (33, 'xiaoming', '127.0.0.1', 1, '2018-05-23 14:11:30', 282, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (34, 'xiaoming', '127.0.0.1', 1, '2018-05-23 14:12:41', 34, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (35, 'xiaoming', '127.0.0.1', 1, '2018-05-23 14:33:51', 268, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (36, 'xiaoming', '127.0.0.1', 1, '2018-06-06 15:59:08', 1253, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (37, 'xiaoming', '127.0.0.1', 1, '2018-06-06 16:10:21', 360, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (38, 'xiaoming', '127.0.0.1', 1, '2018-06-19 15:03:16', 514, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (39, 'xiaoming', '127.0.0.1', 1, '2018-06-20 13:46:36', 1335, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (40, 'xiaoming', '127.0.0.1', 1, '2018-06-20 13:48:30', 590, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (41, 'xiaoming', '127.0.0.1', 1, '2018-06-20 13:49:48', 642, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (42, 'xiaoming', '127.0.0.1', 1, '2018-06-20 13:49:56', 15, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (43, 'xiaoming', '127.0.0.1', 1, '2018-06-20 13:50:47', 376, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (44, 'xiaoming', '127.0.0.1', 1, '2018-06-20 13:52:08', 529, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (45, 'xiaoming', '127.0.0.1', 1, '2018-06-20 13:56:27', 515, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (46, 'xiaoming', '127.0.0.1', 1, '2018-06-20 13:56:47', 2, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (47, 'xiaoming', '127.0.0.1', 1, '2018-06-20 13:56:58', 2, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (48, 'xiaoming', '127.0.0.1', 1, '2018-06-20 14:00:06', 604, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (49, 'xiaoming', '127.0.0.1', 1, '2018-06-20 14:00:37', 2, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (50, 'xiaoming', '127.0.0.1', 1, '2018-06-20 14:05:57', 452, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (51, 'xiaoming', '127.0.0.1', 1, '2018-06-20 14:21:48', 334, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (52, 'xiaoming', '127.0.0.1', 1, '2018-06-20 14:33:03', 308, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (53, 'xiaoming', '127.0.0.1', 1, '2018-06-21 09:11:59', 354, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (54, 'xiaoming', '127.0.0.1', 1, '2018-06-21 09:14:16', 329, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (55, 'xiaoming', '127.0.0.1', 1, '2018-06-22 14:10:36', 1071, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (56, 'xiaoming', '127.0.0.1', 1, '2018-06-22 14:22:35', 343, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (57, 'xiaoming', '127.0.0.1', 1, '2018-06-22 14:23:55', 326, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (58, 'xiaoming', '127.0.0.1', 1, '2018-06-22 14:56:42', 40, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (59, 'xiaoming', '127.0.0.1', 1, '2018-06-22 14:57:26', 321, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (60, 'xiaoming', '127.0.0.1', 1, '2018-06-22 14:58:40', 349, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (61, 'xiaoming', '127.0.0.1', 1, '2018-06-22 15:01:39', 336, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (62, 'xiaoming', '127.0.0.1', 1, '2018-06-22 15:03:26', 296, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (63, 'xiaoming', '127.0.0.1', 1, '2018-06-22 15:14:20', 299, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (64, 'xiaoming', '127.0.0.1', 1, '2018-06-22 15:15:30', 295, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (65, 'xiaoming', '127.0.0.1', 1, '2018-06-22 15:17:31', 271, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (66, 'xiaoming', '127.0.0.1', 1, '2018-06-22 15:19:56', 268, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (67, 'xiaoming', '127.0.0.1', 1, '2018-06-22 15:21:35', 262, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (68, 'xiaoming', '127.0.0.1', 1, '2018-06-22 15:30:52', 274, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (69, 'xiaoming', '127.0.0.1', 1, '2018-06-22 16:06:54', 297, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (70, 'xiaoming', '127.0.0.1', 1, '2018-06-22 16:16:27', 374, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (71, 'xiaoming', '127.0.0.1', 1, '2018-06-22 16:20:37', 267, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (72, 'xiaoming', '127.0.0.1', 1, '2018-06-22 16:22:46', 270, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (73, 'xiaoming', '127.0.0.1', 1, '2018-06-22 16:26:36', 269, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (74, 'xiaoming', '127.0.0.1', 1, '2018-06-22 16:28:22', 360, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (75, 'xiaoming', '127.0.0.1', 1, '2018-06-22 16:34:43', 268, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (76, 'xiaoming', '127.0.0.1', 1, '2018-06-22 16:35:22', 263, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (77, 'xiaoming', '127.0.0.1', 1, '2018-06-22 16:48:43', 283, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);
INSERT INTO `login_log` VALUES (78, 'xiaoming', '127.0.0.1', 1, '2018-06-22 17:20:32', 316, 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', NULL);

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions`  (
  `permission_id` int(10) NOT NULL COMMENT '权限id',
  `permission` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES (1, 'user:add', 'admin');
INSERT INTO `roles_permissions` VALUES (2, 'user:delete', 'user');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单编号',
  `parent_menu_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单父编号',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url地址',
  `roder_num` int(65) NULL DEFAULT NULL COMMENT '菜单排序号',
  `level` int(65) NULL DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) NULL DEFAULT NULL COMMENT '是否是菜单（1：是 0：不是）',
  `status` int(65) NULL DEFAULT NULL COMMENT '菜单状态（1:启用 0:不启用）',
  `isopen` int(2) NULL DEFAULT NULL COMMENT '是否打开（1:打开 0:不打开）',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(10) NOT NULL COMMENT 'user_id',
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'xiaoming', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles`  (
  `id` int(10) NOT NULL COMMENT '角色id',
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES (1, 'admin', 'xiaoming');
INSERT INTO `user_roles` VALUES (2, 'user', 'xiaoming');

SET FOREIGN_KEY_CHECKS = 1;
