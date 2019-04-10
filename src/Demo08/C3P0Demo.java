package Demo08;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;

public class C3P0Demo {
    public static void main(String[] args) throws PropertyVetoException {
       //c3p0配置数据库
//        ComboPooledDataSource dataSource=new ComboPooledDataSource();
//        dataSource.setDriverClass("com.mysql.jdbc.Driver");
//        dataSource.setUser("root");
//        dataSource.setJdbcUrl("jdbc:mysql:///spring");
//        dataSource.setPassword("root");

        ApplicationContext context=new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService= (UserService) context.getBean("userService");
        userService.accountMoney();
    }
}
