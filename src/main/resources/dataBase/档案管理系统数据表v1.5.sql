/*
Navicat MySQL Data Transfer

Source Server         : 档案管理系统
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : archivesmanagementsystem

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2021-02-28 10:39:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for birthday_info
-- ----------------------------
DROP TABLE IF EXISTS `birthday_info`;
CREATE TABLE `birthday_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` varchar(20) DEFAULT NULL COMMENT '员工ID',
  `employee_name` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `birthday_card` date DEFAULT NULL COMMENT '身份证中的出生日期',
  `birthday_archives` date DEFAULT NULL COMMENT '档案中的出生日期',
  `birthday_judgment` date DEFAULT NULL COMMENT '认定出生日期',
  `birthday_problem_detail` text COMMENT '出生日期问题描述',
  `birthday_check_result` text COMMENT '出生日期认定结果描述',
  `birthday_problem_category` varchar(255) DEFAULT NULL COMMENT '出生日期问题分类',
  `birthday_check_rule` varchar(255) DEFAULT NULL COMMENT '出生日期认定规则',
  `birthday_check_remark` varchar(255) DEFAULT NULL COMMENT '出生日期小结',
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1717 DEFAULT CHARSET=utf8 COMMENT='出生日期信息认定表';

-- ----------------------------
-- Records of birthday_info
-- ----------------------------
INSERT INTO `birthday_info` VALUES ('1711', '3245', '刘溜溜', '1966-07-02', null, '1996-07-02', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', null, '2021-02-20 14:46:45');
INSERT INTO `birthday_info` VALUES ('1712', '8397255', '周某某', '1966-07-02', null, '1996-07-02', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', null, '2021-02-20 14:46:45');
INSERT INTO `birthday_info` VALUES ('1713', '998', '老蔡', '1966-07-02', null, '1996-07-02', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', null, '2021-02-20 15:03:25');
INSERT INTO `birthday_info` VALUES ('1714', '955', '老王', '1966-07-02', null, '1996-07-02', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', null, '2021-02-20 15:03:25');
INSERT INTO `birthday_info` VALUES ('1715', '1999', '老方', '1966-07-02', null, '1996-07-02', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', null, '2021-02-25 21:22:19');
INSERT INTO `birthday_info` VALUES ('1716', '912', '小周', '1966-07-02', null, '1996-07-02', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', null, '2021-02-25 21:22:19');

-- ----------------------------
-- Table structure for education_career_info
-- ----------------------------
DROP TABLE IF EXISTS `education_career_info`;
CREATE TABLE `education_career_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` varchar(20) DEFAULT NULL COMMENT '员工ID',
  `employee_name` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `associate_school` varchar(255) DEFAULT NULL COMMENT '大专学校',
  `associate_college` varchar(255) DEFAULT NULL COMMENT '大专学院',
  `associate_major` varchar(255) DEFAULT NULL COMMENT '大专专业',
  `associate_career` varchar(255) DEFAULT NULL COMMENT '大专学历',
  `associate_degree` varchar(255) DEFAULT NULL COMMENT '大专学位',
  `undergraduate_school` varchar(255) DEFAULT NULL COMMENT '本科学校',
  `undergraduate_college` varchar(255) DEFAULT NULL COMMENT '本科学院',
  `undergraduate_major` varchar(255) DEFAULT NULL COMMENT '本科专业',
  `undergraduate_major_second` varchar(255) DEFAULT NULL COMMENT '本科第二专业',
  `undergraduate_career` varchar(255) DEFAULT NULL COMMENT '本科学历',
  `undergraduate_degree` varchar(255) DEFAULT NULL COMMENT '本科学位',
  `undergraduate_degree_second` varchar(255) DEFAULT NULL COMMENT '本科第二学位',
  `master_school` varchar(255) DEFAULT NULL COMMENT '硕士学校',
  `master_college` varchar(255) DEFAULT NULL COMMENT '硕士学院',
  `master_major` varchar(255) DEFAULT NULL COMMENT '硕士专业',
  `master_career` varchar(255) DEFAULT NULL COMMENT '硕士学历',
  `master_degree` varchar(255) DEFAULT NULL COMMENT '硕士学位',
  `phd_school` varchar(255) DEFAULT NULL COMMENT '博士学校',
  `phd_college` varchar(255) DEFAULT NULL COMMENT '博士学院',
  `phd_major` varchar(255) DEFAULT NULL COMMENT '博士专业',
  `phd_career` varchar(255) DEFAULT NULL COMMENT '博士学历',
  `phd_degree` varchar(255) DEFAULT NULL COMMENT '博士学位',
  `update_by` varchar(255) DEFAULT NULL COMMENT '最新的更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学位学历信息详细表';

-- ----------------------------
-- Records of education_career_info
-- ----------------------------
INSERT INTO `education_career_info` VALUES ('9', '2010', '张三', null, null, null, null, null, '北京大学', '信息学院', '信息管理', null, '本科', '学士', null, null, null, null, null, null, null, null, null, null, null, 'yyj', '2021-01-29 00:00:00');
INSERT INTO `education_career_info` VALUES ('10', '2011', '李四', null, null, null, null, null, '湖南大学', '计算机学院', '软件工程', null, '本科', '学士', null, '中南大学', '计算机学院', '计算机', '研究生', '工学硕士', null, null, null, null, null, 'yyj', '2021-01-29 00:00:00');
INSERT INTO `education_career_info` VALUES ('11', '28', 'yyj', '11', '11', null, '', '', '暨南大学', '计算机科学与工程学院', '网络工程', '', '', '', '', '', '', '', '', '', '', '', '', '', '11', 'yyj', '2021-01-27 00:00:00');

-- ----------------------------
-- Table structure for education_info
-- ----------------------------
DROP TABLE IF EXISTS `education_info`;
CREATE TABLE `education_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` varchar(20) DEFAULT NULL COMMENT '员工ID',
  `employee_name` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `education_degree` varchar(255) DEFAULT NULL COMMENT '最高学位',
  `education_backgroud` varchar(255) DEFAULT NULL COMMENT '最高学历',
  `education_problem_category` varchar(255) DEFAULT NULL COMMENT '学历问题分类',
  `education_problem_detail` text COMMENT '学历问题描述',
  `education_check_result` text COMMENT '学历认定结果描述',
  `education_backgroud_judgment` varchar(255) DEFAULT NULL COMMENT '最高学历认定',
  `education_degreee_judgment` varchar(255) DEFAULT NULL COMMENT '最高学位认定',
  `education_remark` varchar(255) DEFAULT NULL COMMENT '学历小结',
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1717 DEFAULT CHARSET=utf8 COMMENT='学历信息认定表';

-- ----------------------------
-- Records of education_info
-- ----------------------------
INSERT INTO `education_info` VALUES ('1711', '3245', '刘溜溜', null, null, '补充相关材料', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', '本科', '学士', '无问题', null, '2021-02-20 14:46:45');
INSERT INTO `education_info` VALUES ('1712', '8397255', '周某某', null, null, '补充相关材料', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', '本科', '学士', '无问题', null, '2021-02-20 14:46:45');
INSERT INTO `education_info` VALUES ('1713', '998', '老蔡', null, null, '补充相关材料', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', '本科', '学士', '无问题', null, '2021-02-20 15:03:25');
INSERT INTO `education_info` VALUES ('1714', '955', '老王', null, null, '补充相关材料', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', '本科', '学士', '无问题', null, '2021-02-20 15:03:25');
INSERT INTO `education_info` VALUES ('1715', '1999', '老方', null, null, '补充相关材料', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', '本科', '学士', '无问题', null, '2021-02-25 21:22:19');
INSERT INTO `education_info` VALUES ('1716', '912', '小周', null, null, '补充相关材料', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', '本科', '学士', '无问题', null, '2021-02-25 21:22:19');

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(20) DEFAULT NULL COMMENT '员工ID',
  `employee_name` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `department_name` varchar(64) DEFAULT NULL COMMENT '所在部门',
  `job_property` varchar(64) DEFAULT NULL COMMENT '岗位性质',
  `department_line` varchar(64) DEFAULT NULL COMMENT '所属线条',
  `confirmation_content_flag` tinyint(1) DEFAULT NULL COMMENT '认定表是否有内容',
  `confirmation_signature_flag` tinyint(1) DEFAULT NULL COMMENT '认定表是否已签字',
  `birthday_problem_detail` text COMMENT '出生日期问题描述',
  `birthday_check_result` text COMMENT '出生日期认定结果描述',
  `birthday_card` date DEFAULT NULL COMMENT '身份证出生日期',
  `birthday_archives` date DEFAULT NULL COMMENT '档案中的出生日期',
  `birthday_judgment` date DEFAULT NULL COMMENT '认定出生日期',
  `birthday_problem_category` varchar(255) DEFAULT NULL COMMENT '出生日期问题分类',
  `birthday_check_rule` varchar(255) DEFAULT NULL COMMENT '出生日期认定规则',
  `birthday_check_remark` varchar(255) DEFAULT NULL COMMENT '出生日期小结',
  `join_party_time_problem_detail` text COMMENT '入党时间问题描述',
  `join_party_time_check_result` text COMMENT '入党时间认定结果描述',
  `join_party_time_research_situation` text COMMENT '入党时间调研情况',
  `join_party_time` date DEFAULT NULL COMMENT '入党时间',
  `join_party_introducer` varchar(255) DEFAULT NULL COMMENT '入党介绍人',
  `join_group_time` date DEFAULT NULL COMMENT '入团时间',
  `join_party_time_remark` varchar(255) DEFAULT NULL COMMENT '入党时间小结',
  `starting_job_time_problem_detail` text COMMENT '参加工作时间问题描述',
  `starting_job_time_check_result` text COMMENT '参加工作时间认定结果描述',
  `starting_job_time_own` date DEFAULT NULL COMMENT '自填工作时间',
  `starting_job_time_archvies` date DEFAULT NULL COMMENT '档案材料中有效工作时间',
  `starting_job_time_judgment` date DEFAULT NULL COMMENT '参加工作时间认定时间',
  `starting_job_time_problem_category` varchar(255) DEFAULT NULL COMMENT '参加工作时间问题分类',
  `starting_job_time_check_remark` varchar(255) DEFAULT NULL COMMENT '参加工作时间小结',
  `education_problem_detail` text COMMENT '学历问题描述',
  `education_check_result` text COMMENT '学历认定结果描述',
  `education_degree` varchar(255) DEFAULT NULL COMMENT '最高学位',
  `education_backgroud` varchar(255) DEFAULT NULL COMMENT '最高学历',
  `education_backgroud_judgment` varchar(255) DEFAULT NULL COMMENT '认定后最高学历',
  `education_degree_judgment` varchar(255) DEFAULT NULL COMMENT '认定后最高学位',
  `education_problem_category` varchar(255) DEFAULT NULL COMMENT '学历问题分类',
  `education_remark` varchar(255) DEFAULT NULL COMMENT '学历小结',
  `work_experience_problem_detail` text COMMENT '工作经历问题描述',
  `work_experience_check_result` text COMMENT '工作经历认定结果描述',
  `work_experience_problem_category` varchar(255) DEFAULT NULL COMMENT '工作经历问题分类',
  `work_experience_remark` varchar(255) DEFAULT NULL COMMENT '工作经历小结',
  `marterial_supplement_remark` varchar(255) DEFAULT NULL COMMENT '补充材料情况',
  `electronic_paper_check_flag` tinyint(1) DEFAULT NULL COMMENT '是否已核对纸质电子版一致性',
  `check_user` varchar(255) DEFAULT NULL COMMENT '核对人',
  `update_by` varchar(255) DEFAULT NULL COMMENT '最后的更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1732 DEFAULT CHARSET=utf8 COMMENT='员工基本信息表';

-- ----------------------------
-- Records of employee_info
-- ----------------------------
INSERT INTO `employee_info` VALUES ('1726', '3245', '刘溜溜', '信息化营销中心', '普通员工', '网络线', '0', '0', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '1966-07-02', null, '1996-07-02', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', '无问题', '沃尔夫家偶尔玩', '软件饿哦网球拍', '2020-12-01', 'rejwpqo ', null, 'jfodsajp ', '啊发的视频', 'rl;qrjeowpqjwq ', '1999-02-01', '1999-02-01', null, 'i4329014u', 'ofdsh9w ', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', null, null, '本科', '学士', '补充相关材料', '无问题', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '认定结果可能影响退休工龄', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', '无问题', '0', 'lzz', null, null);
INSERT INTO `employee_info` VALUES ('1727', '8397255', '周某某', '信息化营销中心', '普通员工', '集客线', '0', '0', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '1966-07-02', null, '1996-07-02', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', '无问题', '沃尔夫家偶尔玩', '软件饿哦网球拍', '2020-12-01', 'rejwpqo ', null, 'jfodsajp ', '啊发的视频', 'rl;qrjeowpqjwq ', '1999-02-01', '1999-02-01', null, 'i4329014u', 'ofdsh9w ', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', null, null, '本科', '学士', '补充相关材料', '无问题', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '认定结果可能影响退休工龄', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', '无问题', '0', 'yyj', null, null);
INSERT INTO `employee_info` VALUES ('1728', '998', '老蔡', '信息集成中心', '普通员工', '集客线', '0', '0', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '1966-07-02', null, '1996-07-02', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', '无问题', '不存在任何问题', '经过调查，该同志思想觉悟很高', '2020-12-01', 'rejwpqo ', '2020-12-01', 'jfodsajp ', '参加工作时间与实际不太一致', 'rl;qrjeowpqjwq ', '1999-02-01', '1999-02-01', null, 'i4329014u', '暂无任何问题', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', null, null, '本科', '学士', '补充相关材料', '无问题', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '认定结果可能影响退休工龄', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', '无问题', '0', 'lzz', null, null);
INSERT INTO `employee_info` VALUES ('1729', '955', '老王', '信息化营销中心', '普通员工', '市场线', '0', '0', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '1966-07-02', null, '1996-07-02', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', '无问题', '不存在任何问题', '软件饿哦网球拍', '2020-12-01', 'rejwpqo ', '2020-12-01', 'jfodsajp ', '参加工作时间与实际不太一致', 'rl;qrjeowpqjwq ', '1999-02-01', '1999-02-01', null, 'i4329014u', '暂无任何问题', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', null, null, '本科', '学士', '补充相关材料', '无问题', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '认定结果可能影响退休工龄', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', '无问题', '0', 'yyj', null, null);
INSERT INTO `employee_info` VALUES ('1730', '1999', '老方', '信息集成中心', '普通员工', '集客线', '0', '0', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '1966-07-02', null, '1996-07-02', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', '无问题', '不存在任何问题', '经过调查，该同志思想觉悟很高', '2020-12-01', 'rejwpqo ', '2020-12-01', 'jfodsajp ', '参加工作时间与实际不太一致', 'rl;qrjeowpqjwq ', '1999-02-01', '1999-02-01', null, 'i4329014u', '暂无任何问题', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', null, null, '本科', '学士', '补充相关材料', '无问题', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '认定结果可能影响退休工龄', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', '无问题', '0', 'lzz', null, null);
INSERT INTO `employee_info` VALUES ('1731', '912', '小周', '信息化营销中心', '普通员工', '集客线', '0', '0', '最新任免表记载1966.07出生，最早形成材料高中等学生招生预选登记表记载出生时间为1966.08，还有大专院校毕业生登记表记载出生时间为1966年06月。', '根据省公司“出生日期允许出入55天内”的要求，经组织认定，其出生日期按身份证日期为1966.07', '1966-07-02', null, '1996-07-02', '出生日期前后不一致', '允许出生日期相差55天（阴阳历情况）', '认定结果与身份证一致', '无问题', '不存在任何问题', '软件饿哦网球拍', '2020-12-01', 'rejwpqo ', '2020-12-01', 'jfodsajp ', '参加工作时间与实际不太一致', 'rl;qrjeowpqjwq ', '1999-02-01', '1999-02-01', null, 'i4329014u', '暂无任何问题', '1、档案记载1985.09-1989.07就读华东工学院电子工程系电子工程专业全日制本科，缺少学生登记表。\n2、档案记载1992.09-1995.04就读华南理工大学无线电工程系通信与电子系统专业研究生，缺少研究生登记表、成绩单', '1、 学生登记表为一般性材料,经组织研究认定其具有华东工学院电子工程系电子工程专业全日制本科学历。\n2、 本人无法补充华南理工大学无线电工程系通信与电子系统专业研究生研究生登记表、成绩单，本人提供研究生学历鉴定报告，经组织研究认定其具有研究生学历。', null, null, '本科', '学士', '补充相关材料', '无问题', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '认定结果可能影响退休工龄', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', '无问题', '0', 'yyj', null, null);

-- ----------------------------
-- Table structure for join_party_time_info
-- ----------------------------
DROP TABLE IF EXISTS `join_party_time_info`;
CREATE TABLE `join_party_time_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` varchar(20) DEFAULT NULL COMMENT '员工ID',
  `employee_name` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `join_party_time` date DEFAULT NULL COMMENT '入党时间',
  `join_party_introducer` varchar(255) DEFAULT NULL COMMENT '入党介绍人',
  `join_group_time` date DEFAULT NULL COMMENT '入团时间',
  `join_party_time_problem_detail` text COMMENT '入党时间问题描述',
  `join_party_time_check_result` text COMMENT '入党时间认定结果描述',
  `join_party_time_research_situation` text COMMENT '入党时间调研情况',
  `join_party_time_remark` varchar(255) DEFAULT '' COMMENT '入党时间小结',
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1717 DEFAULT CHARSET=utf8 COMMENT='入党时间信息认定表';

-- ----------------------------
-- Records of join_party_time_info
-- ----------------------------
INSERT INTO `join_party_time_info` VALUES ('1711', '3245', '刘溜溜', '2020-12-01', 'rejwpqo ', null, '无问题', '沃尔夫家偶尔玩', '软件饿哦网球拍', 'jfodsajp ', null, '2021-02-20 14:46:45');
INSERT INTO `join_party_time_info` VALUES ('1712', '8397255', '周某某', '2020-12-01', 'rejwpqo ', null, '无问题', '沃尔夫家偶尔玩', '软件饿哦网球拍', 'jfodsajp ', null, '2021-02-20 14:46:45');
INSERT INTO `join_party_time_info` VALUES ('1713', '998', '老蔡', '2020-12-01', 'rejwpqo ', '2020-12-01', '无问题', '不存在任何问题', '经过调查，该同志思想觉悟很高', 'jfodsajp ', null, '2021-02-20 15:03:25');
INSERT INTO `join_party_time_info` VALUES ('1714', '955', '老王', '2020-12-01', 'rejwpqo ', '2020-12-01', '无问题', '不存在任何问题', '软件饿哦网球拍', 'jfodsajp ', null, '2021-02-20 15:03:25');
INSERT INTO `join_party_time_info` VALUES ('1715', '1999', '老方', '2020-12-01', 'rejwpqo ', '2020-12-01', '无问题', '不存在任何问题', '经过调查，该同志思想觉悟很高', 'jfodsajp ', null, '2021-02-25 21:22:19');
INSERT INTO `join_party_time_info` VALUES ('1716', '912', '小周', '2020-12-01', 'rejwpqo ', '2020-12-01', '无问题', '不存在任何问题', '软件饿哦网球拍', 'jfodsajp ', null, '2021-02-25 21:22:19');

-- ----------------------------
-- Table structure for ordinary_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `ordinary_operate_log`;
CREATE TABLE `ordinary_operate_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` varchar(20) DEFAULT NULL COMMENT '员工ID',
  `employee_name` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `check_table_name` varchar(255) DEFAULT NULL COMMENT '操作的数据表名称',
  `check_column_name` varchar(255) DEFAULT NULL COMMENT '更新的字段',
  `old_value` text COMMENT '字段旧值',
  `new_value` text COMMENT '字段新值',
  `operate_type` varchar(255) DEFAULT NULL COMMENT '操作类型（新增、修改、删除）',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='日常操作记录表，主要用于记录增加、修改、删除认定表的更新前和更新后每一个字段内容。不做太详细的记录（因为没给钱）';

-- ----------------------------
-- Records of ordinary_operate_log
-- ----------------------------
INSERT INTO `ordinary_operate_log` VALUES ('1', '2008', '张三', '测试表', '认定表字段测试', '1', '2', '修改', 'yyj', '2021-01-28 00:00:00');

-- ----------------------------
-- Table structure for process_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `process_operate_log`;
CREATE TABLE `process_operate_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作流程记录ID号',
  `employee_id` varchar(20) DEFAULT NULL COMMENT '员工ID',
  `employee_name` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `operate_state` varchar(255) DEFAULT NULL COMMENT '当前操作状态（日期认定..)',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='业务流程操作记录表，用于记录该员工哪些认定步骤已走完。';

-- ----------------------------
-- Records of process_operate_log
-- ----------------------------
INSERT INTO `process_operate_log` VALUES ('1', '2008', '张三', '日期认定', 'yyj', '2021-01-28 00:00:00');
INSERT INTO `process_operate_log` VALUES ('3', '2009', '李四', '开始工作时间认定', 'yyj', '2021-01-28 00:00:00');

-- ----------------------------
-- Table structure for starting_job_time_info
-- ----------------------------
DROP TABLE IF EXISTS `starting_job_time_info`;
CREATE TABLE `starting_job_time_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(20) DEFAULT NULL COMMENT '员工ID',
  `employee_name` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `starting_job_time_own` date DEFAULT NULL COMMENT '自填工作时间',
  `starting_job_time_archvies` date DEFAULT NULL COMMENT '档案材料中有效工作时间',
  `starting_job_time_judgment` date DEFAULT NULL COMMENT '参加工作时间认定时间',
  `starting_job_time_problem_detail` text COMMENT '参加工作问题描述',
  `starting_job_time_problem_category` varchar(255) DEFAULT NULL COMMENT '参加工作时间问题分类',
  `starting_job_time_check_result` text COMMENT '参加工作时间认定结果描述',
  `starting_job_time_check_remark` varchar(255) DEFAULT NULL COMMENT '参加工作时间小结',
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1717 DEFAULT CHARSET=utf8 COMMENT='参加工作时间基本信息认定表';

-- ----------------------------
-- Records of starting_job_time_info
-- ----------------------------
INSERT INTO `starting_job_time_info` VALUES ('1711', '3245', '刘溜溜', '1999-02-01', '1999-02-01', null, '啊发的视频', 'i4329014u', 'rl;qrjeowpqjwq ', 'ofdsh9w ', null, '2021-02-20 14:46:45');
INSERT INTO `starting_job_time_info` VALUES ('1712', '8397255', '周某某', '1999-02-01', '1999-02-01', null, '啊发的视频', 'i4329014u', 'rl;qrjeowpqjwq ', 'ofdsh9w ', null, '2021-02-20 14:46:45');
INSERT INTO `starting_job_time_info` VALUES ('1713', '998', '老蔡', '1999-02-01', '1999-02-01', null, '参加工作时间与实际不太一致', 'i4329014u', 'rl;qrjeowpqjwq ', '暂无任何问题', null, '2021-02-20 15:03:25');
INSERT INTO `starting_job_time_info` VALUES ('1714', '955', '老王', '1999-02-01', '1999-02-01', null, '参加工作时间与实际不太一致', 'i4329014u', 'rl;qrjeowpqjwq ', '暂无任何问题', null, '2021-02-20 15:03:25');
INSERT INTO `starting_job_time_info` VALUES ('1715', '1999', '老方', '1999-02-01', '1999-02-01', null, '参加工作时间与实际不太一致', 'i4329014u', 'rl;qrjeowpqjwq ', '暂无任何问题', null, '2021-02-25 21:22:19');
INSERT INTO `starting_job_time_info` VALUES ('1716', '912', '小周', '1999-02-01', '1999-02-01', null, '参加工作时间与实际不太一致', 'i4329014u', 'rl;qrjeowpqjwq ', '暂无任何问题', null, '2021-02-25 21:22:19');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `user_role` varchar(255) DEFAULT NULL COMMENT '用户角色',
  `user_flag` tinyint(1) DEFAULT NULL COMMENT '用户状态是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('5', 'yyj', 'yyj', '系统管理员', '1');
INSERT INTO `sys_user` VALUES ('6', 'fty', 'tty', '系统管理员', '1');
INSERT INTO `sys_user` VALUES ('19', '毛阿敏', '324', '录入者', '1');
INSERT INTO `sys_user` VALUES ('20', '齐秦', '2313', '管理员', '0');
INSERT INTO `sys_user` VALUES ('21', '王祖贤', '21312', '管理员', '1');

-- ----------------------------
-- Table structure for work_experience_info
-- ----------------------------
DROP TABLE IF EXISTS `work_experience_info`;
CREATE TABLE `work_experience_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` varchar(20) DEFAULT NULL COMMENT '员工ID',
  `employee_name` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `work_experience_problem_detail` text COMMENT '工作经历问题描述',
  `work_experience_problem_category` varchar(255) DEFAULT NULL COMMENT '工作经历问题分类',
  `work_experience_check_result` text COMMENT '工作经历认定结果描述',
  `work_experience_remark` varchar(255) DEFAULT NULL COMMENT '工作经历小结',
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1717 DEFAULT CHARSET=utf8 COMMENT='工作经历信息认定表';

-- ----------------------------
-- Records of work_experience_info
-- ----------------------------
INSERT INTO `work_experience_info` VALUES ('1711', '3245', '刘溜溜', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '认定结果可能影响退休工龄', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', null, '2021-02-20 14:46:45');
INSERT INTO `work_experience_info` VALUES ('1712', '8397255', '周某某', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '认定结果可能影响退休工龄', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', null, '2021-02-20 14:46:45');
INSERT INTO `work_experience_info` VALUES ('1713', '998', '老蔡', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '认定结果可能影响退休工龄', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', null, '2021-02-20 15:03:25');
INSERT INTO `work_experience_info` VALUES ('1714', '955', '老王', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '认定结果可能影响退休工龄', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', null, '2021-02-20 15:03:25');
INSERT INTO `work_experience_info` VALUES ('1715', '1999', '老方', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '认定结果可能影响退休工龄', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', null, '2021-02-25 21:22:19');
INSERT INTO `work_experience_info` VALUES ('1716', '912', '小周', '最新任免表记载1989.07-1992.08江西电机厂工作，缺少该段工作结束时间证明材料。', '认定结果可能影响退休工龄', '材料记载1990.09《转正、定级工资审核表》记录1989年8月进入江西电机厂工作，档案内未有该段工作结束时间证明材料，经组织研究该段工作结束时间暂不予以认定。', '工作结束时间待定，可能影响退休工龄，具体由社保局核定', null, '2021-02-25 21:22:19');
