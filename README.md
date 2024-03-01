---
title: Grape-API接口开放平台
---

# GrapeAPI

## 项目简介
### 项目地址
https://github.com/kanggama857/Grape-API

基于React + Spring Boot + Dubbo + Gateway的API接口开放调用平台。项目共分为Web系统、模拟接口、公共模块、客户端SDK、API网关这5个子项目。管理员可以接入并发布接口，可视化各接口的调用情况。用户可以开通接口调用权限、浏览接口及在线调试，并通过客户端SDK轻松调用接口。

- 根据业务流程，将整个项目后端划分为Web系统、模拟接口、公共模块、客户端SDK、API网关这5个子项目，并使用Maven进行多模块依赖管理和打包。
- 使用 Swagger + Knife.4j **自动生成OpenAPI规范的接口文档**，前端在此基础上使用插件自动生成接口请求代码，**降低前后端协作成本**。
- 为防止接口被恶意调用，设计 **API 签名认证算法**，为用户分配唯一 ak / sk 以鉴权，保障调用的安全性。
- 基于 Spring Boot Starter 开发了**客户端 SDK**，一行代码 即可调用接口，提高开发体验。
- 选用 **Spring Cloud Gateway** 作为 API 网关，实现了路由转发、访问控制，并集中处理**签名校验、请求参数校验、接口调用统计**等业务逻辑，
- LogBack+Dubbo Filter**全链路日志处理**。


## 项目架构图

### 业务架构图

![api业务架构.jpg](https://kanggama857.github.io/img/api%E4%B8%9A%E5%8A%A1%E6%9E%B6%E6%9E%84.jpg)

### 技术架构图

![api系统架构.png](https://kanggama857.github.io/img/api%E7%B3%BB%E7%BB%9F%E6%9E%B6%E6%9E%84.png)

## 项目用到的技术
| **item**         | **version**    |
| ---------------- |----------------|
| **JDK**          | **1.8**        |
| **SpringBoot**   | **2.7.9**      |
| **SpringCloud**  | **2021.0.7.0** |
| **Apache Dubbo** | **3.1.6**      |
| **OpenAPI**      | **3**          |
| **MySQL**        | **5.7**        |
| **Redis**        | **6.2**        |
| **Mybatis-Plus** | **3.5.2**      |
| **Nacos**        | **2.2.1**      |
## 项目模块说明
- `api-backend`：管理员可以发布接口、设定是否下线接口等功能，以及查看用户使用接口的情况，例如使用次数，错误调用等。
- `api-client-sdk`：提供一个简化的工具包，使得开发者可以更方便地调用接口，例如提供预封装的HTTP请清求方法、接口调用示例等。
- `api-common`：提供实体类对象，Repository，mapper，自定义异常，常量，自定义注解
- `api-gateway`：负责接口的流量控制，安全防护等功能，提供一致的接口服务质量，和简化API的管理工作。
- `api-interface`：提供模拟接口供开发者使用和测试

## 如何使用本项目
在使用本项目前，执行sql文件夹下的sql文件，**生成对应的表**
- **方法一：**

下载源码，导入Idea，依次配置运行`api-interface`、`api-backend`、`api-gateway`模块

> 注意：因为隐藏了配置文件，所以需要修改各个模块下的application.yml配置文件才可以正常启动