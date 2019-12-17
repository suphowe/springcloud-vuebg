# zipkin使用

## 开启服务
追踪服务间数据的相互调用
```
java -jar zipkin-server-2.12.9-exec.jar
```
查看网址: http://localhost:9411

## 使用zipkin
- 引入依赖
```aidl
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-zipkin</artifactId>
		</dependency>
```

- 指定位置
在 application.yml 文件中指定zipkin server的地址,通过配置"spring.zipkin.base-url"指定
```aidl
spring.zipkin.base-url=http://localhost:9411
```

- 暴露接口  
在需要跟踪的服务 controller 中添加
```aidl
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
```