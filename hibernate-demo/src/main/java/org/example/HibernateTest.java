package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.example.pojo.User;

import java.util.List;

public class HibernateTest {
    private static SessionFactory factory;

    public static void main(String[] argv) {
        User user1 = new User("bob", "wwwwww");
        User user2 = new User("admin", "admin");

        HibernateTest hibernateTest = new HibernateTest();
        hibernateTest.addUser(user1);
        hibernateTest.addUser(user2);

        hibernateTest.listUser();

    }

    public void addUser(User user) {
        System.out.println("addUser");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void listUser() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("listUser");
            List<User> list = session.createQuery("from User", User.class).list();
            list.forEach(user -> {
                System.out.println(user);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
