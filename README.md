## Spring_dmeo

* Demo01 : 简单测试，入门

* Demo02 : 对象创建的三种方法及属性标签

                1.默认无参构造创建：
                    <!--默认调用无参构造创建对象-->
                    <!--<bean id="user" class="Demo01.User"></bean>-->
                2.静态工厂创建：
                    <!--静态工厂创建对象-->
                    <!--<bean id="user" class="Demo02.UserFactory" factory-method="getUser"></bean>-->
                3.实例工厂创建：
                    <!--实例工厂创建对象-->
                <bean id="userFactory" class="Demo02.UserFactory"></bean>
                    <bean id="user" factory-bean="userFactory" factory-method="getUser"></bean>
                4.  <!--属性标签
                    id :
                    name :可以包含特殊符号
                    class:类路径
                    scope : Bean的作用范围
                    -->
                        <!--scope：singleton/prototype/request/session/globalSession
                                   默认，单实例/多实例/将对象存入request域/存入session域/存入globalSession域/
                        -->
* Demo03 : 属性注入(DI)

            一、传统java方式：
            1.set方法注入
            2.有参构造注入
            3.接口注入
            
            二、Spring方式：
            1.set方法注入
              <!--set方法注入-->
                <!--<bean id="user" class="Demo03.User">-->
                    <!--<property name="username" value="set方法">-->
                    <!--</property>-->
                <!--</bean>-->
                <!---->
            2.有参构造注入
            <!--<bean id="user" class="Demo03.User" >-->
                    <!--<constructor-arg name="username" value="有参构造"/>-->
                <!--</bean>-->
            3.<!--复杂属性注入-->
            array ; list ; map ; properties
* Demo04 : 对象注入 p 名称空间

            <!--对象注入-->
                <bean id="userDao" class="Demo04.UserDAO"></bean>
                <bean id="userService" class="Demo04.UserService">
                    <!--name : service里的属性名称 -->
                    <property name="userDAO" ref="userDao"></property>
                </bean>
            <!--p名称空间-->
                 <bean id="user" class="Demo03.User" p:username="lucy"></bean>
* Demo05 :注解使用

            1.@Conponment :创建对象
            衍生注解（功能一样，利于标明）：
            1.@Controller :web层
            2.@Service :业务层
            3.@Repository :持久层
            混合使用：
            1.创建对象用配置文件
            2.注入属性用注解
* Demo06 :AOP操作 Aspectj

                    术语:
                    joinpoint(连接点)：类里面哪些方法可以被增强，这些方法称为连接点 
                    pointcut（切入点）：在类里面可以有很多的方法被增强，比如实际操作中，
                    只是增强了类里面add方法和update方法，实际增强的方法称为切入点
                    Advice(通知/增强)：增强的逻辑，称为增强，比如扩展日志功能，这个日志功能称为增强 
                    通知分为前置通知，后置通知，异常通知，最终通知，环绕通知。  
                    前置通知：在方法之前执行
                    后置通知：在方法之后执行 
                    异常通知：方法出现异常
                    最终通知：在后置之执行
                    环绕通知：在方法之前和之后执行 
                    aspect（切面）：把增强应用到具体方法上面，过程称为切面
                    把增强用到切入点过程
                    Introduction（引介）：要增强的类
                    weaving(织入)是把增强应用到目标的过程，把advice应用到target的过程。
                    proxy（代理）：一个类被aop织入增强后，就产生一个结果代理类。
                    
                    AspectJ配置:
                    <!--使用表达式配置切入点-->
                        <!--execution(* Demo.*(..))-->
                        <aop:config>
                            <!--配置切入点  被增强方法-->
                            <aop:pointcut id="pointcat" expression="execution(* Demo06.*.*(..))"></aop:pointcut>
                            <!--配置切面 增强方法-->
                            <aop:aspect id="" ref="carFactory">
                                <aop:before method="before" pointcut-ref="pointcat"></aop:before>
                                <aop:after-returning method="after" pointcut-ref="pointcat"></aop:after-returning>
                                <aop:around method="around" pointcut-ref="pointcat"></aop:around>
                            </aop:aspect>
                        </aop:config>
             
* Demo07 : JDBCTemplate操作

                //设置数据库信息
                        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
                        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
                        driverManagerDataSource.setUrl("jdbc:mysql:///spring");
                        driverManagerDataSource.setUsername("root");
                        driverManagerDataSource.setPassword("root");
                //创建模板对象
                        JdbcTemplate jdbcTemplate =new JdbcTemplate(driverManagerDataSource);
                //常用操作方法
                update() , query(),queryForObject();
* Demo08 : c3p0连接池及事务管理

             //c3p0配置数据库，代码操作
                    ComboPooledDataSource dataSource=new ComboPooledDataSource();
                    dataSource.setDriverClass("com.mysql.jdbc.Driver");
                    dataSource.setUser("root");
                    dataSource.setJdbcUrl("jdbc:mysql:///spring");
                    dataSource.setPassword("root");
             <!--配置c3p0连接池 spring配置操作（常用）-->
             <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
                 <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
                 <property name="jdbcUrl" value="jdbc:mysql:///spring"></property>
                 <property name="user" value="root"></property>
                 <property name="password" value="root"></property>
             </bean>
             
             事务配置：
                 <!-- 第一步 配置事务管理器 -->
                 <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                     <!--注入dataSource-->
                     <property name="dataSource" ref="dataSource"></property>
                 </bean>
             
                 <!--&lt;!&ndash; 第二步 配置事务增强 &ndash;&gt;-->
                 <!--<tx:advice id="tx" transaction-manager="transactionManager">-->
                     <!--&lt;!&ndash; 做事务操作 &ndash;&gt;-->
                     <!--<tx:attributes>-->
                         <!--&lt;!&ndash; 设置进行事务操作的方法匹配规则  &ndash;&gt;-->
                         <!--<tx:method name="accountMoney" propagation="REQUIRED"/>-->
                     <!--</tx:attributes>-->
                 <!--</tx:advice>-->
                 <!--&lt;!&ndash; 第三步 配置切面 &ndash;&gt;-->
                 <!--<aop:config>-->
                     <!--<aop:pointcut id="pointcut1" expression="execution(* Demo08.UserService.*(..))"></aop:pointcut>-->
                     <!--<aop:advisor advice-ref="tx" pointcut-ref="pointcut1"></aop:advisor>-->
                 <!--</aop:config>-->
             
                 <!--事务注解开启-->
             <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
             
             注意！！！ ：spring的事务管理数据库表的引擎要求不能是myisam，该引擎不支持事务管理，使用innodb
             
* SSHDemo01 :  spring4+hibernate5+struts2整合开发

            spring配置hibernate：
             <bean class="org.springframework.orm.hibernate5.LocalSessionFactoryBean" id="sessionFactory">
                    <!--引用c3p0连接池-->
                    <property name="dataSource" ref="dataSource"></property>
                    <!--指定hibernate核心文件-->
                    <!--<property name="configLocation" value="classpath:hibernate.cfg.xml"></property>-->
            
                    <!--不使用hibernate核心配置文件-->
                    <property name="hibernateProperties">
                        <props>
                            <prop key="hibernate.show_sql">true</prop>
                            <prop key="hibernate.format_sql">true</prop>
                            <prop key="hibernate.hbm2ddl.auto">update</prop>
                            <prop key="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</prop>
                        </props>
                    </property>
            <property name="mappingResources">
                <list>
                    <value>SSHDemo01/User.hbm.xml</value>
                </list>
            </property>
                </bean>

           

                                 