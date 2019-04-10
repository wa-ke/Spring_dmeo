package Demo01;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTools {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean/bean.xml");
        User user= (User) context.getBean("user");
        user.add();
    }
}
