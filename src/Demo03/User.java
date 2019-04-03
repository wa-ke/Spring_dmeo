package Demo03;

public class User {
    private String username;
    //1.有参构造注入
//    public User(String username) {
//        this.username = username;
//    }
    //set方法注入（常用）
    public void setUsername(String username) {
        this.username = username;
    }

    public void  test(){
        System.out.println(username);
    }

}
