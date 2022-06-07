# x-cloud
一个基于Spring Cloud Alibaba的Java微服务示例项目

# 关于
之前尝试搭建一个微服务项目,搜索了一些开源项目,感觉对新手不是那么友好,于是决定自己搭建一个示例项目,以供后续参考

本项目使用`Nacos(服务注册发现/配置管理/服务管理)` + `Dubbo(服务调用/负载均衡)` + `Sentinel(流量控制/熔断降级/系统负载保护)` + `RocketMQ(消息队列)` + `Seata(分布式事务,暂时没有使用)`

# 准备工作
## 1.数据库
使用`Mysql5.7`,随便新建一个名为x_cloud的数据库,后续会使用

## 2.Nacos
进入[官网](https://nacos.io/zh-cn/),下载并启动Nacos,配置略
- 进入`bin`目录
- 以单机模式启动Nacos
  - (Linux) `sh ./startup.sh -p embedded`
  - (Windows) `startup.cmd -p embedded`
- 启动完成后可以访问Nacos控制台
  - 控制台地址 `http://127.0.0.1:8848/nacos`
  - 用户名密码 `nacos/nacos`
  - 默认会使用`8848(Nacos)`和`7848(Raft)`端口
- 遇到异常情况建议先看`/logs`中对应的日志文件
- 具体配置请参考官方文档
- 每次修改配置后,建议删除以下文件后再启动
  - `./bin/logs` 
  - `./bin/work` 
  - `./bin/derby.log` 
  - `./data` 
  - `./logs` 
  - `./status`

## 3.RocketMQ
进入[官网](https://rocketmq.apache.org/),下载并启动RocketMQ,配置略
- 进入`bin`目录
- 运行mqnamesrv
  - (Linux) `nohup ./mqnamesrv /dev/null 2>&1 &`
  - (Windows) `mqnamesrv.cmd`
- 运行broker(需要在conf中配置`namesrvAddr`和`autoCreateTopicEnable`)
  - (Linux) `nohup ./mqbroker /dev/null 2>&1 &`
  - (Windows) `mqbroker.cmd`
- 默认会使用`9876(Namesrv)`和`10911(Broker)`端口

## 4.Sentinel控制台(可选)
进入[发布页](https://github.com/alibaba/Sentinel),下载`sentinel-dashboard-xxx.jar`
- 运行Sentinel控制台
  - (Linux) `nohup java -jar sentinel-dashboard-xxx.jar >log.txt &`
  - (Windows) `java -jar sentinel-dashboard-xxx.jar`
  - 控制台地址 `http://127.0.0.1:8080/`
  - 用户名密码 `sentinel/sentinel`
- 默认会使用`8080`端口

# 项目模块介绍
```
x-cloud
┣━ x-common                     公共模块
┃  ┗━ x-common-util               公共工具类
┣━ x-helloworld                 示例服务
┃  ┣━ x-helloworld-common         示例服务公共模块
┃  ┣━ x-helloworld-consumer       示例服务消费者
┃  ┗━ x-helloworld-provider       示例服务生产者
┗━ x-monitor                    SpringBootAdmin监控
```