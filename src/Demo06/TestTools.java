package Demo06;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTools {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
       Car car= (Car) context.getBean("car");
       car.add();
    }
}
