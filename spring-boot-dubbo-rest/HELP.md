## spring-boot-dubbo-rest

**使用http方式访问dubbo服务**


### 服务提供者(boot-dubbo-rest-provider)

#### 引入依赖

除了增加dubbo的基础依赖之外，还需要加入:  

```pom
<!-- REST support dependencies -->
<dependency>
    <groupId>io.netty</groupId>
    <artifactId>netty-all</artifactId>
</dependency>

<dependency>
    <groupId>org.jboss.resteasy</groupId>
    <artifactId>resteasy-jaxrs</artifactId>
</dependency>

<dependency>
    <groupId>org.jboss.resteasy</groupId>
    <artifactId>resteasy-client</artifactId>
</dependency>

<dependency>
    <groupId>org.jboss.resteasy</groupId>
    <artifactId>resteasy-netty4</artifactId>
</dependency>

<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
</dependency>

<dependency>
    <groupId>org.jboss.resteasy</groupId>
    <artifactId>resteasy-jackson-provider</artifactId>
</dependency>

<dependency>
    <groupId>org.jboss.resteasy</groupId>
    <artifactId>resteasy-jaxb-provider</artifactId>
</dependency>

<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
</dependency>

<!-- zookeeper client dependency -->
<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-framework</artifactId>
</dependency>
```


#### 配置文件application.yml


在配置文件`application.yml`中加入`rest`协议: 

```yml
dubbo:
  application:
    name: dubbo-rest-provider
  registry:
    address: zookeeper://localhost:2181
  protocols:
    dubbo:
      name: dubbo
      port: -1
      server: netty
    rest:
      name: rest
      port: 8888 [http访问端口]
      server: netty
```

***协议中server使用tomcat会报错....***


#### 接口定义

```java
@Path("hello")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface IHelloService {


    @GET
    @Path("sayHi")
    public String sayHi(@QueryParam("to") String to);

}
```


### 访问

使用`postman`访问`http://localhost:8888/hello/sayHi?to=Qiao`,**注意:指定 `content-type`为`application/json`或者`application/xml`**,
返回:  

```text
Hi: Qiao
```




