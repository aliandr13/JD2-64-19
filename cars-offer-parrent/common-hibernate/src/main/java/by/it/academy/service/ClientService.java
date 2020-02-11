package by.it.academy.service;

import by.it.academy.dao.ClientDAO;
import by.it.academy.entity.Client;
import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class ClientService implements ClientDAO {
    @Override
    public void create(Client client) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(client);
            log.info("Successful saved");
            session.getTransaction().commit();

        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            log.info("Transaction was rollbacked " + e);
        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public List<Client> getAll() throws SQLException {
        List<Client> clientList = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Client> query = session.createQuery("from Client ", Client.class);
            clientList = query.list();
            log.info("clientList FROM CLIENT: ");
            clientList.stream().forEach(clients -> log.info(clients.toString()));
            session.getTransaction().commit();
        } catch (HeadlessException e) {
            assert session != null;
            session.getTransaction().rollback();
            log.info("Transaction was rollbacked " + e);
        } finally {
            assert session != null;
            session.close();
        }
        return clientList;
    }

    @Override
    public void update(Client client) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(client);
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
    public void delete(Client client) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(client);
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
}
