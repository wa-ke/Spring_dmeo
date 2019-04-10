package Demo08;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void accountMoney(){


        userDao.lessMoney();
        //事务异常处理，异常回滚
//        int i=10/0;

        userDao.moreMoney();

    }
}
