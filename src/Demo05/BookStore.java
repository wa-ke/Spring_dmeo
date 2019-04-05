package Demo05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookStore {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Book book= (Book) context.getBean("book");
        book.test();
        System.out.println(book.getName());
    }
}
