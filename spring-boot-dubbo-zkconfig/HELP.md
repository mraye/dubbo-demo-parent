

## spring-boot-dubbo-zkconfig

spring boot dubbo 整合 zookeeper作为分布式服务配置中心，使用ZKUI作为可视化


### boot-dubbo-zkconfig-provider


#### 引入依赖

复制`boot-dubbo-rest-provider`工程中的Pom文件，额外添加依赖:  

```pom
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-config</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

```

#### 增加 bootstrap.yml

在`bootstrap.yml`中指定配置文件要到zookeeper配置中心取


#### ZKUI导入配置文件

可以通过导入txt文件，而文件内容格式为:  

> {config.root}/{spring.application.name},{profile}={key}={value}

本项目中`config.root`为`/config/dev`

***如果是使用一种协议的，如只有 `dubbo` 协议***

`provider-dev.txt`文件内容为:  

```txt
/config/dev/boot-dubbo-zkconfig-provider,dev=server.port=8080
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.application=dubbo-provider
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.registry.address=zookeeper://127.0.0.1:2181
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.protocol.name=dubbo
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.protocol.port=-1

```

***如果是使用多种协议的，如有 `dubbo` 或者 `rest` 协议***

`provider-dev.txt` 文件内容为:  

```txt
/config/dev/boot-dubbo-zkconfig-provider,dev=server.port=8080
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.application.name=dubbo-provider
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.registry.address=zookeeper://127.0.0.1:2181
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.protocols.dubbo.name=dubbo
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.protocols.dubbo.port=-1
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.protocols.dubbo.server=netty
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.protocols.rest.name=rest
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.protocols.rest.port=8888
/config/dev/boot-dubbo-zkconfig-provider,dev=dubbo.protocols.rest.server=netty
/config/dev/boot-dubbo-zkconfig-provider,dev=wechat.oauth2.appId=appId
/config/dev/boot-dubbo-zkconfig-provider,dev=wechat.oauth2.appSecret=1234
```


而 `consumer-dev.txt` 可以:  

```txt
/config/dev/boot-dubbo-zkconfig-consumer,dev=server.port=8081
/config/dev/boot-dubbo-zkconfig-consumer,dev=dubbo.application.name=dubbo-consumer
/config/dev/boot-dubbo-zkconfig-consumer,dev=dubbo.registry.address=zookeeper://127.0.0.1:2181
/config/dev/boot-dubbo-zkconfig-consumer,dev=dubbo.protocols.dubbo.name=dubbo
/config/dev/boot-dubbo-zkconfig-consumer,dev=dubbo.protocols.dubbo.port=-1
/config/dev/boot-dubbo-zkconfig-consumer,dev=dubbo.protocols.dubbo.server=netty
/config/dev/boot-dubbo-zkconfig-consumer,dev=dubbo.protocols.rest.name=rest
/config/dev/boot-dubbo-zkconfig-consumer,dev=dubbo.protocols.rest.port=8889
/config/dev/boot-dubbo-zkconfig-consumer,dev=dubbo.protocols.rest.server=netty
```



### 热更新配置文件


需要额外引入依赖:  

```pom
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```



***注意，使用`@Value("${wechat.oauth2.appId}")`占位符形式是不能实现热更新的，只有使用以下方式才可以:***  

```java
@ConfigurationProperties(prefix = "wechat.oauth2")
@Configuration
@Data
public class WxConfig {

    private String appId;

    private String appSecret;

}
```
















