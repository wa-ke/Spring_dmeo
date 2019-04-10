package SSHDemo01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionTools {
    public static Configuration configuration=null;
    private static SessionFactory sessionFactory=null;
    static{
        configuration=new Configuration().configure();
        sessionFactory=configuration.buildSessionFactory();
    }
    public static Session getSession(){
        return sessionFactory.openSession();
    }

}
