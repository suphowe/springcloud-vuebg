# 应用
同service-hi


# Mybatis集成
1.pom.xml中引入
```aidl
<!-- Mybatis -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.0</version>
        </dependency>

        <!-- mysql -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.29</version>
        </dependency>
```
2.application.yml中引入
```aidl
spring:
  datasource:
    url: jdbc:mysql://192.168.200.112:3306/suphowe?useUnicode=true&characterEncoding=utf8
    username: root
    password: root
    driver-class-name: com.mysql.jdbc.Driver

mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.application.entity
```
3.启动类中添加
```aidl
@EnableTransactionManagement            //开启事务
@MapperScan("com.application.dao")      //扫描Mapper类
```
4.编写实体类,实现toString方法  

5.Dao数据层添加@Mapper注解  

6.classpath:mapper/ 目录下编写xml文件
```aidl
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace必须指向Dao接口 -->
<mapper namespace="com.application.dao.UserDao">

    <!-- 告诉mybatis,实体类的属性名和表的字段名之间的对应关系 -->
    <resultMap id="UserMap" type="com.application.entity.User">
        <result column="id" jdbcType="INTEGER" property="id"/>
        <result column="user" jdbcType="VARCHAR" property="user"/>
        <result column="name" jdbcType="VARCHAR" property="name"/>
        <result column="tel" jdbcType="VARCHAR" property="tel"/>
        <result column="addr" jdbcType="VARCHAR" property="addr"/>
        <result column="duty" jdbcType="VARCHAR" property="duty"/>
    </resultMap>

    <select id="findUser" resultType="com.application.entity.User" resultMap="UserMap">
        select * from sys_user_tab where 1=1
        <if test=" id != null ">
            and id = #{id}
        </if>
    </select>

    <select id="findUserByName" resultType="com.application.entity.User" resultMap="UserMap">
        select * from sys_user_tab where 1=1
        <if test=" name != null ">
            and name like CONCAT('%', #{name}, '%')
        </if>
        limit #{beginRow}, 10
    </select>

    <insert id="insertUser" parameterType="com.application.entity.User">
        insert into sys_user_tab (id, user, name, tel, addr, duty)
                values (#{id},#{user},#{name},#{tel},#{addr},#{duty})
    </insert>

    <update id="updateUser" parameterType="com.application.entity.User">
        <if test="id!=null">
            UPDATE sys_user_tab
            <set>
                <if test="user!=null and user!=''">
                    user=#{user},
                </if>
                <if test="name!=null and name!=''">
                    name=#{name},
                </if>
                <if test="tel!=null and tel!=''">
                    tel=#{tel},
                </if>
                <if test="addr!=null and addr!=''">
                    addr=#{addr},
                </if>
                <if test="duty!=null and duty!=''">
                    duty=#{duty},
                </if>
            </set>
            WHERE id=#{id}
        </if>
    </update>

    <delete id="deleteUser" parameterType="int">
        DELETE FROM sys_user_tab WHERE id=#{id}
    </delete>

</mapper>
```
7.自动开启事务  
service层方法添加@Transactional注解  
  
8.手动使用事务  
service引入
```aidl
@Autowired
private DataSourceTransactionManager dataSourceTransactionManager;

@Autowired
private TransactionDefinition transactionDefinition;
```
开启事务
```aidl
// 开启事务
TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
```
提交事务
```aidl
// 提交事务
dataSourceTransactionManager.commit(transactionStatus);
```
回滚事务
```aidl
// 回滚事务
dataSourceTransactionManager.rollback(transactionStatus);
```

# 开启健康检查
配置文件加入
```aidl
eureka:
  client:
    healthcheck:        #开启健康检查
      enabled: true
```