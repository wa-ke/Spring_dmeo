package SSHDemo01;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class TestTools {
    public static void main(String[] args) {
        SessionFactory sessionFactory=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session= SessionTools.getSession();
            transaction=session.beginTransaction();


            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally {

        }
    }
}
