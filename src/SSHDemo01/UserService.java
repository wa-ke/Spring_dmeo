package SSHDemo01;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
   public void  add(){
       System.out.println("service....");
        userDao.add();
    }
}
