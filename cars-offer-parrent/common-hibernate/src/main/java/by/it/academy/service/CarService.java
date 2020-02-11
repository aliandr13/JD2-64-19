package by.it.academy.service;

import by.it.academy.dao.CarDAO;
import by.it.academy.entity.Car;

import by.it.academy.entity.Model;
import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

@Slf4j
public class CarService implements CarDAO {
    @Override
    public void create(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
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
    public List<Car> getAll() throws SQLException {
        List<Car> carList = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Car ", Car.class);
            carList = query.list();
            log.info("carList FROM CAR: ");
            carList.stream().forEach(cars -> log.info(cars.toString()));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                log.info("Session was rollacked " + e);
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return carList;
    }

    @Override
    public List<Car> getAvaliableCars() throws SQLException {

        List<Car> carList = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Car ", Car.class);
            carList = query.list();
            log.info("carList FROM CAR: ");
            carList.stream().forEach(cars -> log.info(cars.toString()));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                log.info("Session was rollacked " + e);
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return carList;
    }

    @Override
    public void update(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(car);
            log.info("Object updated in session");
            session.getTransaction().commit();

        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            log.info("Session was rollbacked: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
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
    public List<Model> getAvaliableModel() {
        return null;
    }


}
