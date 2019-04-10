package Demo04;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//Bean的三种实例化
public class TestTools {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean/bean.xml");
        UserService userService= (UserService) context.getBean("userService");
        userService.add();
    }
}
