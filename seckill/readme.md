## 介绍
本项目提取自电商的秒杀场景，将秒杀业务独立出一个练习项目。适合刚工作和准备工作的程序员。  

## 技术
- 总体架构： Maven + SSM
- 日志： slf4j + logback
- 数据库相关：Mysql + c3p0

## 源码
[seckill](https://github.com/HelloWorld521/Java)

## Maven + SSM 整合

1. 在 idea 上创建一个 Java 项目，新建 pom.xml 文件，填写相关依赖。（具体见源码 pom.xml 文件）右键项目找到Maven Reimport 导入Maven依赖。
2. 修改目录结构  
![](https://note.youdao.com/yws/public/resource/5d22772be74b170a1bd59446d336eb9a/xmlnote/7F96B1AD1BE54374B687D33D81C192EB/4891)  
完整目录展示：  
![](https://note.youdao.com/yws/public/resource/5d22772be74b170a1bd59446d336eb9a/xmlnote/F5C2CFEDFAC74433926D9D36B3F66270/4897)  
main.java 存放源码  
resources 存放相关配置文件  
sql       存放相关sql  
webapp    存放前台页面

> DAO(Data Access Object) 数据访问对象，提供访问数据库的抽象接口，或者持久化机制，而不暴露数据库的内部详细信息。DAO提供从程序调用到持久层的匹配。面向Model。  

> DTO：数据传输对象(Data Transfer Object)，是一种设计模式之间传输数据的软件应用系统。数据传输目标往往是数据访问对象从数据库中检索数据。数据传输对象与数据交互对象或数据访问对象之间的差异是一个以不具有任何行为除了存储和检索的数据（访问和存取器）。简单来说，当我们需要一个对象10个字段的内容，但这个对象总共有20个字段，我们不需要把整个PO对象全部字段传输到客户端，而是可以用DTO重新封装，传递到客户端。此时，如果这个对象用来对应界面的展现，就叫VO。


3. 创建 jdbc.properties， spring-dao.xml 文件和 mybaties-config.xml 文件  
jdbc.properties 连接数据库  
spring-dao.xml 文件是 Spring 与 Mybatis 的整合，主要配置自动扫描，自动注入和连接c3p0。（内容见源码）  
mybaties-config.xml 是 mybaties 的一些属性配置

```
spring-dao.xml 文件
1. 连接数据库的相关参数
2. 使用的连接池
3. 配置 sqlSessionfactory 对象
4. 配置扫描 DAO 接口包
```
4. 创建 spring-service.xml 文件
```
spring-service.xml   
1. 自动扫描
2. 事务管理器
```
5. 创建 spring-web.xml 文件
```
spring-web.xml
1. 对 SpringMVC 的整合，开启注解模式
2. 静态资源的 servlet 配置
3. 配置 jsp 显示 ViewResolver
4. 自动扫描 web 的 bean
```

6. 配置 web.xml，配置拦截器，初始化spring-*.xml。  

完成这6步，项目架构就搭建完成。剩下的就是不同业务的开发。

## 业务需求
[视频介绍](http://www.imooc.com/u/2145618/courses?sort=publish)
