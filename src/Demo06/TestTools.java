package Demo06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTools {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean/bean2.xml");
       Car car= (Car) context.getBean("car");
       car.add();
    }
}
