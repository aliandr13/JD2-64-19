package by.it.academy.entity;

import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class TestEmployee {
    public static void main(String[] args) {
        try {
            Employee employee = new Employee(null, "Ivan", "Ivanov", LocalDateTime.now(), null);
            EmployeeDetail detail = new EmployeeDetail(null, "Nemiga", "Minsk", "state", "Belarus", null);
            Employee employee1 = new Employee(null, "Petya", "Petrov", LocalDateTime.now(), null);
            EmployeeDetail detail1 = new EmployeeDetail(null, "Nemiga", "Grodno", "state", "Belarus", null);
            Employee employee2 = new Employee(null, "Misha", "Alekseevich", LocalDateTime.now(), null);
            EmployeeDetail detail2 = new EmployeeDetail(null, "Kazinca", "Minsk", "state", "Belarus", null);

            safeInDateBase(employee, detail);
            safeInDateBase(employee1, detail1);
            safeInDateBase(employee2, detail2);

            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            List<EmployeeDetail> list;
            Query<EmployeeDetail> query = session.createQuery(" from EmployeeDetail as e where e.city = 'Minsk'");
            list = query.list();
            session.close();


            log.info("=============");
            list.stream().forEach(md -> log.info(md.toString()));

        } finally {
            HibernateUtil.shutdown();
        }

    }

    static void safeInDateBase(Employee first, EmployeeDetail second) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            first.setEmployeeDetail(second);
            second.setEmployee(first);
            session.save(first);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            log.error("Exception from safeInDateBase", e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            assert session != null;
            session.close();
        }

    }
}
