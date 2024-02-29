package Dao;

import Controller.HibernateUtil;
import bean.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {

    public User saveUser(User userObj) {
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(userObj);
        tr.commit();

        session.close();
        return userObj;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}



    public User UpdateUser(User userObj) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.beginTransaction();
            session.update(userObj);
            tr.commit();
            session.close();
            return userObj;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public User DeleteUser(User userObj) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.beginTransaction();
            session.delete(userObj);
            tr.commit();
            session.close();
            return userObj;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
    public List<User> allUsers() {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<User> UserList = ss.createQuery("select adm from User adm").list();
            ss.close();
            return UserList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public User Search(User userObj ) {
        try
        {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            User usr = ss.get(User.class, userObj.getId());
            ss.close();
            return usr;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();        }
        return null;
    }

}
