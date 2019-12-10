# 高可用注册中心
application-peer1.yml
```aidl
server:
  port: 8761

spring:
  profiles: peer1
eureka:
  instance:
    hostname: peer1
  client:
    serviceUrl:
      defaultZone: http://peer2:8769/eureka/
```
application-peer2.yml
```aidl
server:
  port: 8769

spring:
  profiles: peer2
eureka:
  instance:
    hostname: peer2
  client:
    serviceUrl:
      defaultZone: http://peer1:8761/eureka/
```
修改文件  
windows:c:/windows/systems/drivers/etc/hosts  
linux:/etc/hosts  
```aidl
127.0.0.1 peer1
127.0.0.1 peer2
```
启动工程
```aidl
java -jar vuebg-eureka.jar - -spring.profiles.active=peer1
java -jar vuebg-eureka.jar - -spring.profiles.active=peer2
```