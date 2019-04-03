package Demo04;

public class UserService {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(){
        System.out.println("service...");
        userDAO.add();
    }
}
