package Demo03;

import java.util.List;
import java.util.Map;
import java.util.Properties;

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
    //复杂属性注入
    private String[] arr;
    private List<String> list;
    private Map<String,String> map;
    private Properties properties;

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getUsername() {
        return username;
    }

    public String[] getArr() {
        return arr;
    }

    public List<String> getList() {
        return list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void  test(){
        System.out.println(username);
        System.out.println(arr);
        System.out.println(map);
        System.out.println(list);
        System.out.println(properties);
    }

}
