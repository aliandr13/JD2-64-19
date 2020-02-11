package by.it.academy.service;

import by.it.academy.dao.UserDAO;
import by.it.academy.entity.User;
import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.awt.*;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class UserService implements UserDAO {
    @Override
    public void create(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            log.info("Object added to session");
            session.getTransaction().commit();
        } catch (HibernateException e) {
            assert session != null;
            session.getTransaction().rollback();
            log.info("Session was rollbacked: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query<User> query = session.createQuery("from User  ", User.class);
            userList = query.list();
            log.info("clientList FROM CLIENT: ");
            userList.stream().forEach(clients -> log.info(clients.toString()));
            session.getTransaction().commit();
        } catch (HeadlessException e) {
            assert session != null;
            session.getTransaction().rollback();
            log.info("Transaction was rollbacked " + e);
        } finally {
            assert session != null;
            session.close();
        }
        return userList;
    }

    @Override
    public void update(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            log.info("Successful updated");
            session.getTransaction().commit();
        } catch (HibernateException e) {
            assert session != null;
            session.getTransaction().rollback();
            log.info("Transaction was rollbacked " + e);
        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public void delete(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            log.info("Object deleted in session");
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.info("Session was rollbacked: " + e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> findUser(String userName, String password) {
        Session session = null;
        List list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
//            Iterator<User> userIterator =
            Query<User> query = session.createQuery("from User as u where u.userName =: userName and u.password =: password",User.class);
            list = query.list();
            if (userName.equals(query) && password.equals(query)) {
                log.info("===========================");
                list.stream().forEach(user -> log.info(user.toString()));
            } else {
                log.info("===== ТАКОГО ПОЛЬЗОВАТЕЛЯ НЕТ=========");
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {

            session.getTransaction().rollback();
            log.info("User not found "+e);
        } finally {
            session.close();
        }

        return list;
    }
}
