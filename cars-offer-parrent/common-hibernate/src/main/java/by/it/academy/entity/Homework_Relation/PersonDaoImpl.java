package by.it.academy.entity.Homework_Relation;

import by.it.academy.dao.Homework.PersonDao;
import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

@Slf4j
public class PersonDaoImpl implements PersonDao {

    public static void main(String[] args) {
        try {
            PersonDaoImpl first = new PersonDaoImpl();
            PersonDaoImpl second = new PersonDaoImpl();
            Person person = new Person(null, 19, "Леша", "Васильевич");
            Person person1 = new Person(null, 19, "Иван", "Иванов");
            Person person2 = new Person(null, 10, "MY", "S");
            Person person3 = new Person(null, 0, "0", "0");
            first.create(person);
            first.create(person3);
            person.setName("Саша");
            first.update(person);
            first.read();
        } finally {
            HibernateUtil.shutdown();
        }

    }


    public void create(Person pe) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pe);
            log.info("Successfully saved");
            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.info("Exception from create" + e);
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
    public  void update(Person pe) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(pe);
            log.info("Successfully update");
            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.info("Exception from update" + e);
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
    public List<Person> read() {
        List<Person> list = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createQuery("from Person as e where e.age > 10 ").list();
            for (Person person : list
            ) {
                log.info("Person list " + person);
            }

        } catch (HibernateException e) {
            log.info("Exception from read" + e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public void delete(Person pe) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(pe);
            log.info("Successfully deleted");
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.info("Exception from delete" + e);
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
