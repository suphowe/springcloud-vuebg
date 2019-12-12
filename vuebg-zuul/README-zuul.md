# zuul
- 路由配置
- 负载均衡配置

## 负载均衡配置
```aidl
server:
  port: 8720

spring:
  application:
    name: service-zuul
zuul:
  routes:
    api-a:
      path: /api-a/**
      serviceId: vuebg-client

    api-b:
      path: /api-b/**
      serviceId: vuebg-admin
```
通过配置zuul,将/api-a/* 指向vuebg-client  
通过http://127.0.0.1:8720/api-a/* 访问vuebg-client中的接口  
通过http://127.0.0.1:8720/api-b/* 访问vuebg-admin中的接口  
启用8081和8082端口的vuebg-client服务,访问会在两个端口中进行自动轮循