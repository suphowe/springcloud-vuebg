# 项目构成

# 87XX 段,用于内部服务

## eureka注册中心

- 8700 vuebg-eureka 注册中心

### 高可用eureka注册中心
- 8701 eureka注册中心1
- 8702 eureka注册中心2

## vuebg-zuul
- 8720 vuebg-zuul 负载均衡|路由 API服务网关

## vuebg-turbine Hystrix Turbine
- 8730 vuebg-turbine 熔断监控集群

## 数据备份

- 8710 vuebg-backup 数据备份

# 808X 段,应用程序

## 8081 8082
- vuebg-client 后台客户端

## 8085
- vuebg-admin 后台管理

## vuebg-zipkin
分布式链路追踪
