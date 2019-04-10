package SSHDemo01;


import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void add() {
//        User user=new User();
//        user.setUsername("mary");
//        user.setPassword("123");
//        hibernateTemplate.save(user);


        //get方法
        User user= hibernateTemplate.get(User.class,1);
        System.out.println(user.getUsername());

        //find方法
        List<User> list= (List<User>) hibernateTemplate.find("from User");
        for (User user1 : list) {
            System.out.println(user.getUsername());
        }

        //find条件查询
        List<User> list1= (List<User>) hibernateTemplate.find("from User where username=?","mary");
        for (User user1 : list1) {
            System.out.println(user1.getPassword());
        }


    }

}
