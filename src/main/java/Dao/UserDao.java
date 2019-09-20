package Dao;

import Model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class UserDao implements StorageDao {

    public int removeAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User");
            int count = query.executeUpdate();
            transaction.commit();
            return count;
        }

    }

    public int removeUser(int userID) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id = :id");
            query.setParameter("id", userID);
            int count = query.executeUpdate();
            transaction.commit();
            return count;
        }

    }

    public int removeUserByName(String name) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE name = :name");
            query.setParameter("name", name);
            int count = query.executeUpdate();
            transaction.commit();
            return count;

        }
    }

    public void insertUser(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    public int updateUser(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE User SET age =:age WHERE name =:name");
            query.setParameter("age", user.getAge());
            query.setParameter("name", user.getName());
            int count = query.executeUpdate();
            transaction.commit();
            return count;
        }

    }

    public User getUser(int userID) {
        User user = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            user = session
                    .createQuery("FROM User WHERE id = :id", User.class)
                    .setParameter("id", userID)
                    .getSingleResult();

        } catch (NoResultException e) {
            System.out.println("This user is not in the base");
        }

        return user;
    }

    public List<User> getAllUsers() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From User").list();
        }
    }
}
