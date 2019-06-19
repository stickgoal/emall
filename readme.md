# 综合分布式电商

教学用项目

## 目标

搭建基于SOA的分布式架构，理解分布式架构概念

## 技术栈

### [开发]

- spring-boot :  快速开发框架
  - spring
  - spring-webmvc

- mybatis-plus  持久化框架

- spring-security 安全框架
  - oAuth2  实现SSO

- dubbo 	RPC框架

### [中间件]

- zookeeper       分布式协调，支持dubbo
- elasticsearch   搜索引擎
- redis                 session及缓存支持
- fastdfs              分布式文件系统
- nginx                 静态资源服务器
- rabbitmq          消息队列

### [运维]

- mysql         数据库
- docker        集群部署
- maven        依赖及构建工具
- git                代码管理

[端口]

passport：9999

user:9990

mall:9900