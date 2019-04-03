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
* Demo04 : 对象注入 p名称空间

            <!--对象注入-->
                <bean id="userDao" class="Demo04.UserDAO"></bean>
                <bean id="userService" class="Demo04.UserService">
                    <!--name : service里的属性名称 -->
                    <property name="userDAO" ref="userDao"></property>
                </bean>
            <!--p名称空间-->
                 <bean id="user" class="Demo03.User" p:username="lucy"></bean>