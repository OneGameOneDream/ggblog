

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `tags` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `hits` int(5) NULL DEFAULT 0 COMMENT '点击量',
  `author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `allow_comment` int(1) NULL DEFAULT 0 COMMENT '开启评论',
  `link` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章链接',
  `image` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章图片',
  `sort` int(11) NULL DEFAULT 0 COMMENT '权重，越大越靠前',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(0：删除；1：正常；2：草稿)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for blog_skill
-- ----------------------------
DROP TABLE IF EXISTS `blog_skill`;
CREATE TABLE `blog_skill`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `image` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技能图片',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(0：删除；1：正常；2：草稿)',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技能名',
  `sort` int(255) NULL DEFAULT NULL COMMENT '权重',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '技能表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for blog_user_info
-- ----------------------------
DROP TABLE IF EXISTS `blog_user_info`;
CREATE TABLE `blog_user_info`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博主姓名',
  `qrcode` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二维码',
  `wechat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业介绍',
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '爱好',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(0：删除；1：正常；2：草稿)',
  `head` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博主头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for blog_version
-- ----------------------------
DROP TABLE IF EXISTS `blog_version`;
CREATE TABLE `blog_version`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '域名',
  `logo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'logo',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `banner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主页图片',
  `hits` int(255) NULL DEFAULT NULL COMMENT '访问量',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(0：删除；1：正常；2：草稿)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数值',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `sort` int(255) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(0：删除；1：正常)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` bigint(20) NULL DEFAULT NULL,
  `exception_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `http_status_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `param_data` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` bigint(20) NULL DEFAULT NULL,
  `time_consuming` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级菜单编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级菜单名字',
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单链接',
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单目标',
  `type` int(255) NULL DEFAULT NULL COMMENT '菜单类型( 0：目录 1：菜单 2：按钮)',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `sort` int(255) NULL DEFAULT NULL COMMENT '排序',
  `is_show` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否在菜单中显示（1：显示；0：不显示）',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(0：删除；1：正常)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_sign` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色标识',
  `is_available` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否可用',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(0：删除；1：正常)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单id',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stats` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(0：正常；1：删除)',
  `login_ip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登陆时间',
  `login_count` int(255) UNSIGNED NULL DEFAULT 0 COMMENT '登录次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;






INSERT INTO `blog_article`(`id`, `title`, `content`, `tags`, `hits`, `author`, `allow_comment`, `link`, `image`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('451fcead644a42659521850cdf662649', '测试测试', '<p><b><i><u><strike>  \r\n					  	测试测试测试测试测试测试测试<img src=\"http://localhost:8080/ogod/lib/layui/images/face/50.gif\" alt=\"[熊猫]\"><img src=\"/ogod/upload/article/pics/31230053-001d-47da-8ee3-e19689050bc8.png\" alt=\"31230053-001d-47da-8ee3-e19689050bc8.png\"></strike></u></i></b></p>', NULL, NULL, '冰心', NULL, NULL, '/ogod/upload/article/pics/9c71775d-7f5a-4185-9af1-2e5cea525ec5.jpeg', NULL, 'admin', '2019-02-14 08:13:22', 'admin', '2019-02-20 07:35:33', '无', '1');
INSERT INTO `blog_article`(`id`, `title`, `content`, `tags`, `hits`, `author`, `allow_comment`, `link`, `image`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('48d47df6bc0a4c18b3f3d615e5ed1bd3', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', '  \r\n					  	的烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦', NULL, 0, '哈哈', NULL, NULL, '/ogod/upload/article/pics/b952ccea-0a14-4947-a730-7771be830c6b.jpeg', NULL, 'admin', '2019-02-19 09:33:14', 'admin', '2019-02-20 07:35:06', '哈哈斤斤计较急急急急急急急急急急急急急急急', '1');
INSERT INTO `blog_article`(`id`, `title`, `content`, `tags`, `hits`, `author`, `allow_comment`, `link`, `image`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('5743fa7719724407b99ab6c911a80f10', '十一天深度体验 Model 3 之后，我想把它推荐给每一个人', '<p>这十一天开下来，我想把它推荐给每一个人。</p><p>它可能是你见过最酷最有科技感的车，但同时又很实用，<span>更重要的是，买得起。</span></p><p>这篇我会用最平实的语言，介绍 Model 3 的几大亮点，以及大家最关心的一些问题。争取让大家「一篇看懂 Model 3」。</p><h2 id=\"ss-H2-1550461645214\">极简设计：什么都「没有」的 Model 3</h2><p>Model 3 的设计完美诠释了「超前」二字，极简的程度甚至超过了它的前辈 Model S / X 。</p><p>首先，Model 3&nbsp;<span>没有车钥匙</span>。</p><p>每辆 Model 3 配有两张钥匙卡片，你可以用它刷卡开门、启动车辆。</p>', '汽车', 0, 'cc', NULL, NULL, '/ogod/upload/article/pics/a83f7a5f-4c4b-4615-979e-c025d075c7fa.jpeg', NULL, 'admin', '2019-02-20 08:37:14', 'admin', '2019-02-20 08:37:14', 'Model 3', '0');
INSERT INTO `blog_article`(`id`, `title`, `content`, `tags`, `hits`, `author`, `allow_comment`, `link`, `image`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('c66a0993f9224f5ba0a09261c4a66e8f', 'Spring Cloud（零）：微服务的那些事儿', '<p style=\"text-align: justify;\">Spring Cloud 是一系列框架的有序集合。它利用 Spring Boot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 Spring Boot 的开发风格做到一键启动和部署。Spring 并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过 Spring Boot 风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。</p><p style=\"text-align: justify;\">本文主要讲述我们为什么选择 Spring Cloud 和它的技术概览。</p><h1 id=\"什么是微服务\" style=\"text-align: justify;\"><a href=\"https://windmt.com/2018/04/14/spring-cloud-0-microservices/#%E4%BB%80%E4%B9%88%E6%98%AF%E5%BE%AE%E6%9C%8D%E5%8A%A1\" class=\"headerlink\" title=\"什么是微服务\"></a>什么是微服务</h1><p style=\"text-align: justify;\">要了解 Spring Cloud 就绕不开微服务这个概念。因为 Spring Cloud 是 Spring 为微服务架构思想做的一个一站式实现。从某种程度是可以简单的理解为，微服务是一个概念、一个项目开发的架构思想。Spring Cloud 是微服务架构的一种 Java 实现。</p><p style=\"text-align: justify;\">微服务的概念源于 Martin Fowler 于 2014 年 3 月 25 日写的一篇文章&nbsp;<a href=\"https://martinfowler.com/articles/microservices.html\" target=\"_blank\" rel=\"noopener\">Microservices</a>（中文版翻译<a href=\"http://www.cnblogs.com/liuning8023/p/4493156.html\" target=\"_blank\" rel=\"noopener\">点击查看</a>）</p><p><a id=\"more\" style=\"text-align: justify;\"></a><span style=\"text-align: justify;\"></span></p><p style=\"text-align: justify;\">微服务架构模式（Microservices Architecture Pattern）的目的是将大型的、复杂的、长期运行的应用程序构建为一组相互配合的服务，每个服务都可以很容易得局部改良。 Micro 这个词意味着每个服务都应该足够小，但是，这里的小不能用代码量来比较，而应该是从业务逻辑上比较——符合&nbsp;<a href=\"https://en.wikipedia.org/wiki/Single_responsibility_principle\" target=\"_blank\" rel=\"noopener\">SRP 原则</a>的才叫微服务。</p>', '学习', 0, 'cc', NULL, NULL, '/ogod/upload/article/pics/cb3e3456-381f-40ab-97c0-606c490ca17c.jpeg', NULL, 'admin', '2019-02-20 07:51:10', 'admin', '2019-02-20 08:42:37', ' Spring Cloud 技术概览', '0');
INSERT INTO `blog_article`(`id`, `title`, `content`, `tags`, `hits`, `author`, `allow_comment`, `link`, `image`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('cddff8a41d6d46338b4e4e565d492845', 'asdasd', '  \r\n					  	把编辑器的初始内容放在这textarea即可\r\n					', NULL, NULL, 'vv', NULL, NULL, '/ogod/upload/article/pics/4c93699a-64b4-4093-b927-f91e4a6f9985.jpeg', 10, 'admin', '2019-02-19 08:24:35', 'admin', '2019-02-19 09:01:09', '啦啦啦啦', '1');


INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('096ada0208944fdcb25f8033a7e49f55', '/ogod/upload/article/pics/2eb5597b-dbff-4079-9aa8-6353d80c141e.jpeg', 'admin', '2019-02-21 11:57:32', 'admin', '2019-02-21 11:57:32', '熟练掌握', '0', 'SVN', 66);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('0a29c4b2ad1e4e1299edf65226d5a8d6', '/ogod/upload/article/pics/9c956be4-50a2-46d5-bd50-ba6b7c7554da.jpeg', 'admin', '2019-02-21 11:51:26', 'admin', '2019-02-21 11:51:26', '熟练掌握', '0', 'SpringDataJpa', 60);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('1041e3c758ee4951838505910133929f', '/ogod/upload/article/pics/63c91888-49e7-4ab3-855a-7574ad15fec1.jpeg', 'admin', '2019-02-21 11:57:50', 'admin', '2019-02-21 11:57:50', '熟练掌握', '0', '65', 65);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('11a2e0ef4765478f96361255ddf03bd0', '/ogod/upload/article/pics/855e57fd-430c-4773-a042-35a3c861a7eb.png', 'admin', '2019-02-21 11:55:18', 'admin', '2019-02-21 11:55:18', '熟练掌握', '0', 'Oracle', 68);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('2165a88948874e84bd12692be46a6e62', '/ogod/upload/article/pics/39b6cb6c-1b6f-406f-95a2-579756b43e23.png', 'admin', '2019-02-21 11:53:12', 'admin', '2019-02-21 11:53:12', '熟练掌握', '0', 'Thymeleaf', 50);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('220e3a2c57ef41e38477c8604198fd01', '/ogod/upload/article/pics/a380e61c-0c04-4182-b1dc-0161ee3a29fa.jpeg', 'admin', '2019-02-21 11:57:09', 'admin', '2019-02-21 11:57:09', '熟练掌握', '0', 'Jquery', 67);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('4700680a11ae4533a23758c7eaabb420', '/ogod/upload/article/pics/92cac21a-9ae2-4818-b7e7-155a3af79c44.jpeg', 'admin', '2019-02-21 11:50:24', 'admin', '2019-02-21 11:50:24', '熟练掌握', '0', 'SpringBoot', 90);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('4b520d1a33934d86a41ada405e117099', '/ogod/upload/article/pics/fe28b5f1-5d3c-48d2-8d51-29544feac1f9.png', 'admin', '2019-02-21 11:33:42', 'admin', '2019-02-21 11:33:42', '熟练掌握java技术', '0', 'JAVA', 100);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('68ba03c5d2344a73b874ba1d2663b13a', '/ogod/upload/article/pics/534583c9-53c7-49a3-8852-1c37f0dde4e7.jpeg', 'admin', '2019-02-21 11:53:37', 'admin', '2019-02-21 11:53:37', '熟练掌握', '0', 'JSP', 40);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('6f78598c4d2f412faafcb573b7bd3f8f', '/ogod/upload/article/pics/a94e3f3f-5829-4ed8-8eb5-b83d21f872b9.jpeg', 'admin', '2019-02-21 11:54:55', 'admin', '2019-02-21 11:54:55', '熟练掌握', '0', 'MySql', 69);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('7ab8ed62be1a4c109a46ad5c53700a96', '/ogod/upload/article/pics/6f944a78-f55a-4056-b7f0-9f2ed2563d52.png', 'admin', '2019-02-21 11:58:18', 'admin', '2019-02-21 11:58:18', '熟练掌握', '0', 'Echars', 20);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('b804584bcaee4eddba98113e87220d3d', '/ogod/upload/article/pics/14b07bff-d293-46b7-be18-7f2610fa14c1.png', 'admin', '2019-02-21 11:56:02', 'admin', '2019-02-21 11:56:02', '熟练掌握', '0', 'JavaScript', 67);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('c7066d43cfa4478b8a2eec6517f09f2a', '/ogod/upload/article/pics/60c36b3b-1998-4ad2-8e9f-881f4b34c1e4.jpeg', 'admin', '2019-02-21 11:52:33', 'admin', '2019-02-21 11:52:33', '熟练掌握', '0', 'SpringMvc', 70);
INSERT INTO `blog_skill`(`id`, `image`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `name`, `sort`) VALUES ('f23d12831f2c49529770e960fbd27769', '/ogod/upload/article/pics/921f7674-8eee-4e01-b642-146dbee3f480.jpeg', 'admin', '2019-02-21 11:50:46', 'admin', '2019-02-21 11:50:46', '熟练掌握', '0', 'MyBatis', 80);


INSERT INTO `blog_user_info`(`id`, `name`, `qrcode`, `wechat`, `phone`, `email`, `age`, `job`, `hobby`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `head`) VALUES ('1', '高瑞春', '/ogod/upload/userInfo/pics/d02b916c-8479-4ec8-8e0a-e918f1dbbd58.png', 'Gao-xin1996', '18966854671', 'gao199623@gmail.com', 24, 'java工程师', '足球、互联网、汽车', '1', '2019-02-21 17:41:43', 'admin', '2019-02-21 10:25:29', NULL, '0', '/ogod/upload/version/pics/dfab89eb-982f-4102-a4f3-1087b8d734b1.jpeg');



INSERT INTO `blog_version`(`id`, `url`, `logo`, `title`, `banner`, `hits`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('1', 'http://127.0.0.1:8080/ogod/f', '/ogod/upload/version/pics/d425a895-b77a-4e62-bc16-d6552f9d4779.jpeg', '太阳照亮人生的路    月亮照亮心灵的路', '/ogod/upload/version/pics/b44da860-edb0-4026-81b8-b3c8e9fb0b1b.jpeg', 269, 'admin', '2019-02-20 11:28:49', 'admin', '2019-02-22 01:07:17', NULL, '0');


INSERT INTO `sys_dict`(`id`, `label`, `value`, `type`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('2b109bc45f2f4dc598b7f3616e6de8da', '正常', '0', 'stats', 20, 'admin', '2019-02-13 07:26:29', 'admin', '2019-02-13 07:26:29', '用户状态', '0');
INSERT INTO `sys_dict`(`id`, `label`, `value`, `type`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('8caeb1b3ea004340a5403eae2eb38c8f', '男', '0', 'sex', 20, 'admin', '2019-02-13 07:03:04', 'admin', '2019-02-13 07:03:04', '性别', '0');
INSERT INTO `sys_dict`(`id`, `label`, `value`, `type`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('92082a376e6f490b93446f1783772aee', '禁用', '1', 'stats', 10, 'admin', '2019-02-13 07:26:47', 'admin', '2019-02-13 07:26:57', '用户状态', '0');
INSERT INTO `sys_dict`(`id`, `label`, `value`, `type`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('c6d0d3b7d6e5432eaa95e0755658faeb', '男', '0', 'sex', 20, 'admin', '2019-02-13 07:00:43', 'admin', '2019-02-13 07:00:43', '性别', '1');
INSERT INTO `sys_dict`(`id`, `label`, `value`, `type`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('f9dd23c3dde3495399a109f7fda1d456', '女', '1', 'sex', 10, 'admin', '2019-02-13 07:00:28', 'admin', '2019-02-13 07:00:28', '性别', '0');



INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('00fbe1aa46dd4183a0c145e0caea2229', 'd6672c9135c944c69dea50c46bbe2e3d', '修改文章', '', NULL, 2, NULL, 10, '0', 'blog:article:edit', 'admin', '2019-02-14 05:58:57', 'admin', '2019-02-14 05:58:57', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('01a500facf814b258be003308974830e', '5c7008a1880a421187415f598d6e2d02', '字典编辑', '', NULL, 2, NULL, 20, '0', 'sys:dict:edit', 'admin', '2019-02-13 06:35:28', 'admin', '2019-02-13 06:35:28', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('1', '0', '顶级菜单', NULL, NULL, 0, NULL, 900, '0', '', 'admin', '2018-12-25 16:04:53', 'admin', '2018-12-25 16:04:44', '顶级菜单', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('10', '1', '博客管理', '', NULL, 0, 'layui-icon-component', 40, '0', '', 'admin', '2019-01-22 10:08:22', 'admin', '2019-02-14 05:51:35', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('11', '2', '角色管理', 'sys/role', '_blank', 1, NULL, 60, '0', '', 'admin', '2019-01-24 09:11:25', 'admin', '2019-02-13 06:33:31', '角色菜单', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('12', '11', '角色新增', '', NULL, 2, NULL, 40, '0', 'sys:role:add', 'admin', '2019-01-24 09:12:31', 'admin', '2019-01-30 08:56:23', '角色添加', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('13', '11', '角色编辑', '', NULL, 2, NULL, 30, '0', 'sys:role:edit', 'admin', '2019-01-24 09:13:23', 'admin', '2019-01-30 08:56:54', '角色编辑', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('14', '11', '角色删除', NULL, NULL, 2, NULL, 10, '0', 'sys:role:del', 'admin', '2019-01-24 09:14:09', 'admin', '2019-01-24 09:14:14', '角色删除', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('14f2068bca9c4030890b0c65a7c4907a', 'd6672c9135c944c69dea50c46bbe2e3d', '删除文章', '', NULL, 2, NULL, 20, '0', 'blog:article:del', 'admin', '2019-02-14 05:58:24', 'admin', '2019-02-14 05:58:24', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('15', '11', '角色列表', NULL, NULL, 2, NULL, 20, '0', 'sys:role:list', 'admin', '2019-01-25 09:24:00', 'admin', '2019-01-25 09:24:07', '角色列表', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('16', '3', '用户列表', NULL, NULL, 2, NULL, 20, '0', 'sys:user:list', 'admin', '2019-01-25 09:25:05', 'admin', '2019-01-25 09:25:12', '用户列表', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('17', '7', '日志列表', '', NULL, 2, NULL, 20, '0', 'sys:log:list', 'admin', '2019-01-25 09:25:57', 'admin', '2019-01-30 08:57:18', '日志列表', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('18', '7', '日志详情', '', NULL, 2, NULL, 10, '0', 'sys:log:details', 'admin', '2019-01-25 09:37:13', 'admin', '2019-01-30 08:57:23', '日志详情', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('19', '2', '菜单管理', 'sys/menu', '_blank', 1, NULL, 50, '0', '', 'admin', '2019-01-30 11:02:19', 'admin', '2019-02-13 06:33:37', '菜单列表', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('2', '1', '系統管理', '', '', 0, 'layui-icon-set', 50, '0', '', 'admin', '2018-12-25 16:12:23', 'admin', '2018-12-25 16:12:26', '系统管理', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('20', '19', '菜单列表', '', NULL, 2, NULL, 40, '0', 'sys:menu:list', 'admin', '2019-01-30 14:35:21', 'admin', '2019-01-30 08:55:58', '菜单列表', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('21', '19', '菜单新增', '', NULL, 2, NULL, 30, '0', 'sys:menu:add', 'admin', '2019-01-30 15:29:03', 'admin', '2019-01-30 08:56:05', '菜单新增', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('3', '2', '用户管理', 'sys/user', '_blank', 1, NULL, 80, '0', '', 'admin', '2018-12-25 18:10:37', 'admin', '2019-02-13 06:33:19', '用户菜单', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('339a83f26dad4fe2bb5871a48dc94997', '10', '版本管理', '/ogod/blog/version/edit/1', NULL, 2, NULL, 30, '0', '', 'admin', '2019-02-20 11:09:58', 'admin', '2019-02-21 09:58:42', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('4', '3', '用户新增', '', NULL, 2, NULL, 40, '0', 'sys:user:add', 'admin', '2019-01-08 16:21:28', 'admin', '2019-01-30 08:57:53', '用户添加', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('4e563684409043129f12f112bf80ffe1', '19', '菜单编辑', '', NULL, 2, NULL, 20, '0', 'sys:menu:edit', 'admin', '2019-01-30 08:07:04', 'admin', '2019-01-30 08:56:11', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('5', '3', '用户编辑', '', NULL, 2, NULL, 30, '0', 'sys:user:edit', 'admin', '2019-01-08 16:25:29', 'admin', '2019-01-30 08:57:49', '用户编辑', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('5537b9284891404fa26a2e51d9e13f2e', '19', '菜单删除', '', NULL, 2, NULL, 10, '0', 'sys:menu:del', 'admin', '2019-01-30 08:23:31', 'admin', '2019-01-30 08:25:35', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('5c7008a1880a421187415f598d6e2d02', '2', '字典管理', 'sys/dict', NULL, 1, NULL, 40, '0', '', 'admin', '2019-02-13 06:33:53', 'admin', '2019-02-13 06:34:01', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('6', '3', '用户删除', NULL, NULL, 2, NULL, 10, '0', 'sys:user:del', 'admin', '2019-01-08 16:26:33', 'admin', '2019-01-08 16:26:36', '用户删除', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('7', '2', '日志管理', 'common/log/', '_blank', 1, NULL, 70, '0', '', 'admin', '2019-01-15 11:11:31', 'admin', '2019-02-13 06:33:24', '日志菜单', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('7f0b0f52544344f085957e993ec56d01', '339a83f26dad4fe2bb5871a48dc94997', '修改版本信息', '', NULL, 0, NULL, NULL, '0', 'blog:version:edit', 'admin', '2019-02-20 11:11:08', 'admin', '2019-02-20 11:31:43', NULL, '1');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('8', '7', '日志删除', '', NULL, 2, NULL, 30, '0', 'sys:log:del', 'admin', '2019-01-15 11:12:37', 'admin', '2019-01-30 08:57:13', '日志删除', '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('814ff16585164e3596c3c41881447ff6', 'd6672c9135c944c69dea50c46bbe2e3d', '文章列表', '', NULL, 2, NULL, 30, '0', 'blog:article:list', 'admin', '2019-02-14 05:57:55', 'admin', '2019-02-14 05:57:55', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('a7ba243bc97e4ff7920af6530c774b7a', '10', '拉拉', '', NULL, 1, NULL, 1, '0', 'asd', 'admin', '2019-01-30 08:24:40', 'admin', '2019-01-30 08:24:40', NULL, '1');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('af682640b32f4ef68c7d8c07abe0c4fd', '5c7008a1880a421187415f598d6e2d02', '字典删除', '', NULL, 2, NULL, 10, '0', 'sys:dict:del', 'admin', '2019-02-13 06:35:49', 'admin', '2019-02-13 06:35:49', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('b51f02b68781405dbff0fd6fa2a57155', '10', '技能管理', 'blog/skill', NULL, 1, NULL, 10, '0', '', 'admin', '2019-02-21 11:19:33', 'admin', '2019-02-21 11:19:33', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('b5302b055faa48c082f0eea7b4945fd3', '5c7008a1880a421187415f598d6e2d02', '字典列表', '', NULL, 2, NULL, 40, '0', 'sys:dict:list', 'admin', '2019-02-13 06:34:32', 'admin', '2019-02-13 06:34:32', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('b912c471a13b4c4d817a311bca670cdc', 'b51f02b68781405dbff0fd6fa2a57155', '技能列表', '', NULL, 2, NULL, 30, '0', 'blog:skill:list', 'admin', '2019-02-21 11:20:29', 'admin', '2019-02-21 11:20:40', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('b9b25ded3c4d43339ebbe299eafad326', '10', '博主信息', 'blog/userInfo/edit/1', NULL, 2, NULL, 20, '0', '', 'admin', '2019-02-21 09:58:09', 'admin', '2019-02-21 09:59:38', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('ba36a9899d20469e9a34abb2c68192fb', 'd6672c9135c944c69dea50c46bbe2e3d', '发布文章', '', NULL, 2, NULL, 40, '0', 'blog:article:add', 'admin', '2019-02-14 05:57:15', 'admin', '2019-02-14 05:57:15', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('c66ef03e3e744867892ce0395434c32b', '5c7008a1880a421187415f598d6e2d02', '字典新增', '', NULL, 2, NULL, 30, '0', 'sys:dict:add', 'admin', '2019-02-13 06:35:09', 'admin', '2019-02-13 06:35:09', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('d6672c9135c944c69dea50c46bbe2e3d', '10', '文章管理', 'blog/article', NULL, 1, NULL, 40, '0', '', 'admin', '2019-02-14 05:53:43', 'admin', '2019-02-20 11:10:08', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('e59f539509d84b0a835e2d67e18a787b', 'b51f02b68781405dbff0fd6fa2a57155', '添加技能', '', NULL, 2, NULL, 40, '0', 'blog:skill:add', 'admin', '2019-02-21 11:20:08', 'admin', '2019-02-21 11:20:08', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('e9ef8dd49f5f4ad5ae0d330109b61310', 'b51f02b68781405dbff0fd6fa2a57155', '修改技能', '', NULL, 2, NULL, 10, '0', 'blog:skill:edit', 'admin', '2019-02-21 11:22:05', 'admin', '2019-02-21 11:22:05', NULL, '0');
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `href`, `target`, `type`, `icon`, `sort`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('ea5deb948c1042249b0e6a94c639a5c7', 'b51f02b68781405dbff0fd6fa2a57155', '删除技能', '', NULL, 2, NULL, 20, '0', 'blog:skill:del', 'admin', '2019-02-21 11:21:03', 'admin', '2019-02-21 11:21:03', NULL, '0');


INSERT INTO `sys_role`(`id`, `role_name`, `role_sign`, `is_available`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('1', '系统管理员', 'admin', '0', '1', '2019-01-02 09:12:30', 'admin', '2019-02-21 11:22:24', '拥有系统最高权限', '0');
INSERT INTO `sys_role`(`id`, `role_name`, `role_sign`, `is_available`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('12f48f76f33d4086bbe4f1e5ecaeda57', NULL, NULL, NULL, 'admin', '2019-02-13 06:53:02', 'admin', '2019-02-13 06:53:02', '性别', '1');
INSERT INTO `sys_role`(`id`, `role_name`, `role_sign`, `is_available`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('2', '普通用户', 'normal', '0', '1', '2019-01-02 09:20:11', 'admin', '2019-01-24 03:00:18', '拥有系统部分权限', '1');
INSERT INTO `sys_role`(`id`, `role_name`, `role_sign`, `is_available`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('6163fc5ce2e644fdafdf2e84f28664ca', '测试用户', 'test', '0', 'admin', '2019-01-24 03:08:25', 'admin', '2019-01-30 06:35:48', '测试', '0');
INSERT INTO `sys_role`(`id`, `role_name`, `role_sign`, `is_available`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('85de3e7726b943699bdb45587e36d19a', NULL, NULL, NULL, 'admin', '2019-02-13 06:55:26', 'admin', '2019-02-13 06:55:26', '性别', '1');
INSERT INTO `sys_role`(`id`, `role_name`, `role_sign`, `is_available`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('dff311ebb6c04fc8bb1dce4cd26e4469', NULL, NULL, NULL, 'admin', '2019-02-13 06:51:25', 'admin', '2019-02-13 06:51:25', '性别', '1');


INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('07cd5ccdde9e4bcdacd9029bf8d5a698', '1', '10', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('08d0fad5438d4c34a77ad656ee6bf080', '1', '00fbe1aa46dd4183a0c145e0caea2229', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('20e65dd429ca4997ba190c8d54c1338f', '1', '5', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('219588877d5d4fd8b8c42f980af98d9c', '6163fc5ce2e644fdafdf2e84f28664ca', '2', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('226b1dabd00847caa100b1ddb58e1bde', '6163fc5ce2e644fdafdf2e84f28664ca', '20', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('229d1dd49fd34fc98b475a8226239340', '6163fc5ce2e644fdafdf2e84f28664ca', '7', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('2a17554b0912466ba0b8a37b49425e18', '1', '16', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('2c7a5a062fea4457986805d8f594b963', '1', 'b912c471a13b4c4d817a311bca670cdc', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('3e4469b0eceb489c92474aa079cc9830', '6163fc5ce2e644fdafdf2e84f28664ca', '3', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('45a8010c19c94d3db39c431337a8b0d4', '6163fc5ce2e644fdafdf2e84f28664ca', '19', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('46c4a11ac0f44e05b9c61c96d4e720fd', '1', 'ba36a9899d20469e9a34abb2c68192fb', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('4cb86a3908dd42d09da08b94746ac5a4', '6163fc5ce2e644fdafdf2e84f28664ca', '15', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('4cdd3dbc3cb3457ca8825ecf3656b265', '1', '814ff16585164e3596c3c41881447ff6', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('4d32c154227a494a97a2480de6b098d2', '6163fc5ce2e644fdafdf2e84f28664ca', '16', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('4d7bee8f01c14ca3940f973f3975f40a', '1', 'b5302b055faa48c082f0eea7b4945fd3', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('505060a6cfa748a8ade458a4549395d6', '1', '1', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('51981755425e490c8a36fc2fcad3b75c', '1', 'e9ef8dd49f5f4ad5ae0d330109b61310', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('56b5022f2b8140cb82a2fd488f68fb0e', '6163fc5ce2e644fdafdf2e84f28664ca', '11', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('5d96f5a558944c008ede25b4c2f69fc5', '1', '14f2068bca9c4030890b0c65a7c4907a', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('634f4c12dd874f69a15e7df8c3e931b7', '6163fc5ce2e644fdafdf2e84f28664ca', '17', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('6b25a386820d49dfb76bd2bc1302cd1a', '1', '8', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('6d79b0fdfa5745538b6a338c0d6d9cf1', '6163fc5ce2e644fdafdf2e84f28664ca', '1', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('7a450f8e1bbc4a899beb398994559fc5', '1', 'c66ef03e3e744867892ce0395434c32b', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('7f8a5d6873b54c5aaf9c0d3492f086c5', '1', '17', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('832778d30b424777a089debb887b0402', '1', '7', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('83d3aea7753e46a58b4651f32ea1e039', '1', '14', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('859034f39fe7465c8ff66257372ee45e', '6163fc5ce2e644fdafdf2e84f28664ca', '10', 'admin', '2019-01-30 06:35:48', 'admin', '2019-01-30 06:35:48', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('8f5c087d04884b82959266b085ad54e8', '1', '18', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('9038fc1afa4f4f2299865797089227f7', '1', '12', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('946417b2d0ae4a5ca7c7459ec60bed4c', '1', '6', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('950cd3dc45c442c9bde23aaa9085f101', '1', 'b9b25ded3c4d43339ebbe299eafad326', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('9a40a27b55a142d6920608141a335b96', '1', 'e59f539509d84b0a835e2d67e18a787b', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('9d2ee805467d42cbb695336acf7ed3e1', '1', '2', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('9fecfcf6b77c46a9a5577286fbe5067d', '1', 'ea5deb948c1042249b0e6a94c639a5c7', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('a046e629d16549ad878b47ac79be9648', '1', '3', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('a12d12460ef942798be6212b9cf1c976', '1', '5537b9284891404fa26a2e51d9e13f2e', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('a5589fbfe6d44f4f8fa464d1e0b793aa', '1', '339a83f26dad4fe2bb5871a48dc94997', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('af7281f48ea34bca8a14323b7c9951b1', '1', 'd6672c9135c944c69dea50c46bbe2e3d', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('b1fdfe43ef3b4b57ae715d4f209d1a81', '1', '21', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('bda1fc3c29ec47f6becf2bd5449f7f7b', '1', '13', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('cb3950d5e6a54779b1306fb3dfbfea62', '1', '11', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('e05e99a81ad7459ab6fb6742bcb9b4b0', '1', '4e563684409043129f12f112bf80ffe1', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('f0ef5197b97e411ba01a3c84a4b5511b', '1', '01a500facf814b258be003308974830e', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('f380c7db1c324643899e5ea75df53fab', '1', '19', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('f3c5639fcc7d4481b176722ff608480f', '1', '15', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('f57265227fe64062b02894b477926959', '1', '20', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('f5e4244186174e97a688ac66f93ca19a', '1', '4', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('f66be9e92c4348cc93ba2ae0a587c6c0', '1', 'b51f02b68781405dbff0fd6fa2a57155', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('f74f732b44164df2b2f5a4c2c01c5144', '1', 'af682640b32f4ef68c7d8c07abe0c4fd', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);
INSERT INTO `sys_role_menu`(`id`, `role_id`, `menu_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('f98c3bffb0c64e9cbdc1346d0b48892c', '1', '5c7008a1880a421187415f598d6e2d02', 'admin', '2019-02-21 11:22:24', 'admin', '2019-02-21 11:22:24', NULL);


INSERT INTO `sys_user`(`id`, `dept_id`, `email`, `hobby`, `mobile`, `name`, `password`, `sex`, `stats`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `username`, `del_flag`, `login_ip`, `login_date`, `login_count`) VALUES ('1', '2', 'test00000@gmail.com', '足球', '18966563250', '超级管理员', 'df655ad8d3229f3269fad2a8bab59b6c', '0', '0', '1', '2018-12-21 09:46:19', 'admin', '2019-02-22 00:54:20', '此用户为超级管理员，拥有当前系统所有权限', 'admin', '0', '0:0:0:0:0:0:0:1', '2019-02-22 00:54:20', 172);
INSERT INTO `sys_user`(`id`, `dept_id`, `email`, `hobby`, `mobile`, `name`, `password`, `sex`, `stats`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `username`, `del_flag`, `login_ip`, `login_date`, `login_count`) VALUES ('80e286e427ce43e8bd293512d91c52be', NULL, 'gao199623@gmail.com', NULL, '13571825771', NULL, '2823ef8d65a3b6ba7b1da8b2aa63eff5', '0', '0', 'gao', '2019-01-09 06:28:34', 'admin', '2019-02-12 01:19:42', '作者吱吱吱吱吱吱吱吱吱吱吱吱', 'zhang', '0', '0:0:0:0:0:0:0:1', '2019-02-12 01:05:16', 20);


INSERT INTO `sys_user_role`(`id`, `user_id`, `role_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('1', '1', '1', NULL, NULL, 'admin', '2019-01-23 02:20:41', NULL);
INSERT INTO `sys_user_role`(`id`, `user_id`, `role_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`) VALUES ('3', '80e286e427ce43e8bd293512d91c52be', '6163fc5ce2e644fdafdf2e84f28664ca', NULL, NULL, 'zhang', '2019-01-25 03:02:04', NULL);
