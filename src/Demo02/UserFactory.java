package Demo02;


public class UserFactory {

    //静态工厂实例化
//   public static User getUser(){
//       System.out.println("静态工厂");
//       return new User();
//   }

    //实例工厂创建对象
    public User getUser(){
        System.out.println("实例工厂");
        return new User();
    }

}
