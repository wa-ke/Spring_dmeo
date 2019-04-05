package Demo05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "book")//创建对象
//@Scope(value = "prototype") //多实例创建
public class Book {
    @Value("cat")  //注入属性，可以不写set方法
    private String name;
    @Value("me")
    private String author;

    //@Autowired  //自动装载对象，注入对象 根据类名查找
   @Resource(name = "lib")  //注入对象，根据对象名查找
    private Lib lib;

    public void test(){
        System.out.println("asd");
        lib.out();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
