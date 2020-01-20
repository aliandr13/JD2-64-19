package by.it.academy.entity;

import by.it.academy.dao.PersonDao;
import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import java.util.List;

@Slf4j
public class PersonEntity implements PersonDao {

    public static void main(String[] args) {
        PersonEntity first = new PersonEntity();

        Person person = new Person((long) 3, 19, "Алексей", "Васильевич");
        Person person1 = new Person((long) 1, 19, "Иван", "Иванов");
        first.delete(person);
        HibernateUtil.shutdown();

    }


    public void create(Person pe) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction();
        session.persist(pe);
        log.info("Successfully saved");
        session.getTransaction().commit();
    }



    @Override
    public void update(Person pe) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.update(pe);
        log.info("Successfully update");
        session.getTransaction().commit();
    }

    @Override
    public List<Person> read(Person pe) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Person> list = session.createQuery("from Person").list();
        for (Person person : list
        ) {
            log.info("Person list " + person);
        }

        return list;

    }

    @Override
    public void delete(Person pe) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(pe);
        log.info("Successfully deleted");
        session.getTransaction().commit();
    }
}
