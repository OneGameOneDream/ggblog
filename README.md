# ggblog 博客系统

## 平台简介

ggblog是高效率，低封装，Java EE开发框架。

ggblog是在SpringBoot基础上搭建的一个Java基础开发平台，MyBatis为数据访问层，ApacheShiro为权限授权层。

后台包括：系统权限组件、数据权限组件、数据字典组件、博客管理等。
前端界面风格采用了结构简单、性能优良、页面美观大气的Layui页面展示框架。
采用分层设计、双重验证、提交数据安全编码、密码加密、访问验证、数据权限验证。
使用Maven做项目管理，提高项目的易开发性、扩展性。

ggblog目前包括以下两大大模块，系统管理（SYS）模块、
博客管理（BLOG）模块。 **系统管理模块** ，用户管理、机构管理、菜单管理、角色权限管理、字典管理等功能； **博客管理模块** ，包括内容管理（文章、链接），版本信息管理、博主信息管理、技能管理、前端网站展示等功能。



## 内置功能

1.	用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.	菜单管理：配置系统菜单，操作权限，按钮权限标识等。
3.	角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
4.	字典管理：对系统中经常使用的一些较为固定的数据进行维护，如：是否、男女、类别、级别等。
5.	操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。


## 技术选型

1、后端

* 核心框架：Spring Boot
* 安全框架：Apache Shiro 
* 模板引擎：Thymeleaf
* 持久层框架：MyBatis
* 缓存框架：Redis
* 日志管理：SLF4J 
* 工具类：Apache Commons、hutool

2、前端

* JS框架：jQuery
* 富文本在线编辑：layeEdit
* 数据表格：layeTable
* 弹出层：layer
* 树结构控件：jsTree

4、平台

* 服务器中间件：SpringBoot内置
* 数据库支持：目前仅提供MySql数据库的支持，但不限于数据库
* 开发环境：Java、Eclipse Java EE 、Maven 、Git

## 安全考虑

1. 开发语言：系统采用Java 语言开发，具有卓越的通用性、高效性、平台移植性和安全性。
2. 分层设计：（数据库层，数据访问层，业务逻辑层，展示层）层次清楚，低耦合，各层必须通过接口才能接入并进行参数校验（如：在展示层不可直接操作数据库），保证数据操作的安全。
3. 双重验证：用户表单提交双验证：包括服务器端验证及客户端验证，防止用户通过浏览器恶意修改（如不可写文本域、隐藏变量篡改、上传非法文件等），跳过客户端验证操作数据库。
4. 安全编码：用户表单提交所有数据，在服务器端都进行安全编码，防止用户提交非法脚本及SQL注入获取敏感数据等，确保数据安全。
5. 密码加密：登录用户密码进行SHA1散列加密，此加密方法是不可逆的。保证密文泄露后的安全问题。
6. 强制访问：系统对所有管理端链接都进行用户身份权限验证，防止用户直接填写url进行访问。
