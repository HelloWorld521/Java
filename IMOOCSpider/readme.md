# java 简易实现网络爬虫

### 什么是网络爬虫？
#### 维基百科
>**[网络爬虫](https://zh.wikipedia.org/wiki/%E7%B6%B2%E8%B7%AF%E7%88%AC%E8%9F%B2)**（英语：**web crawler**），也叫网络蜘蛛（spider），是一种用来自动浏览万维网的网络机器人。其目的一般为编纂网络索引。

#### 百度百科
>**网络爬虫**（又被称为网页蜘蛛，网络机器人，在FOAF社区中间，更经常的称为网页追逐者），是一种按照一定的规则，自动地抓取万维网信息的程序或者脚本。另外一些不常使用的名字还有蚂蚁、自动索引、模拟程序或者蠕虫。

### java网络爬虫练习项目
一个比较简单的java练习项目。
#### 需要知识
* 什么是网络爬虫
* Java基础
* 正则表达式

#### 项目思路
在[慕课网](http://www.imooc.com/wenda)的猿问页面，寻找一个你喜欢的问题页面，利用http请求获取问题页面的源码，然后通过正则表达式，不断爬取相关问题页面。

#### 项目介绍
该项目存在三个类
`Imooc.java :` `imooc问题bean类`
`Spider.java:` `封装用来爬取页面的方法类`
`Main.java:` `运行起始页面`

* Imooc.java类是要爬取内容的对象类，属性成员有问题，问题链接，问题描述，答案列表和下一个问题链接。
* Spider.java类封装了2个可能用到的方法，getSource方法获取网页源代码和getImoocPage获取页面Url列表。

#### 项目源码
IMOOCSpider项目已上传到我的github上----[传送门](https://github.com/HelloWorld521/Java.git)
欢迎Star

下载下来后导入eclipse即可运行。

#### 项目运行结果

![结果.png](./images/result.png)
