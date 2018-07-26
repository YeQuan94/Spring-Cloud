# Spring-Cloud
Spring-Cloud MicroServices相关学习



基于SpringBoot<version>2.0.3.RELEASE</version>，JDK <java.version>1.8</java.version>，SpringCloud<spring-cloud.version>Finchley.RELEASE</spring-cloud.version>



工程简介：

| 工程名称                   | 端口       | 描述                                 |
| -------------------------- | ---------- | ------------------------------------ |
| spring-boot-initializr     |            | 使用IDEA+Spring.io创建SpringBoot工程 |
| eureka-client              | 6002       | eureka客户端                         |
| eureka-server              | 6001       | eureka服务端-单机                    |
| eureka-server-cluster      | 6003、6004 | eureka服务端-集群                    |
| eureka-server-authenticate | 6005       | eureka服务端-安全验证                |
| consumer-ribbon            | 6006       | 消费者-负载均衡                      |
| provider-cluster           | 6007、6008 | 提供者-集群                          |
| consumer-feign             | 6009       | 消费者-负载均衡-RESTful              |
| consumer-hystrix           | 6010       | 消费者-负载均衡-RESTful-容错处理     |
| hystrix-dashboard          | 6011       | 容错监控中心                         |
| consumer-hystrix-cluster   | 6012、6013 | 消费者-容错处理-集群                 |
| hystrix-turbine            | 6014       | 容错集群监控                         |
| api-gateway-zuul           | 6015       | API路由网关                          |
| cloud-config-server        | 6016       | 集中配置-服务端                      |
| cloud-config-client        | 6017       | 集中配置-客户端                      |

消费者和提供者是可以相互替换位置的，有时候该工程被调用，就是提供者，有时候该工程调用别的，就是消费者。因此，Ribbon，Feign，Hystrix可以用于任何工程。



