package by.it.academy.entity;

import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class TestEmployee {
    public static void main(String[] args) {
        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Department department = new Department("IT");
            Department department1 = new Department("HR");

            EmployeeDetail detail = new EmployeeDetail(null, "Nemiga", "Minsk", "state", "Belarus", null);
            Employee employee = new Employee(null, "Ivan", "Ivanov", LocalDateTime.now(), null, department);

            Employee employee1 = new Employee(null, "Petya", "Petrov", LocalDateTime.now(), null, department1);
            EmployeeDetail detail1 = new EmployeeDetail(null, "Nemiga", "Grodno", "state", "Belarus", employee1);

            Employee employee2 = new Employee(null, "Misha", "Alekseevich", LocalDateTime.now(), null, department);
            EmployeeDetail detail2 = new EmployeeDetail(null, "Kazinca", "Minsk", "state", "Belarus", employee2);

            employee.setEmployeeDetail(detail);
            detail.setEmployee(employee);
            session.save(department);
            session.save(employee);


            employee1.setEmployeeDetail(detail1);
            session.save(department1);
            session.save(employee1);

            employee2.setEmployeeDetail(detail2);
            session.save(employee2);

            session.getTransaction().commit();


            List<Employee> list;
            Query query = session.createQuery("from Employee ");
            list = query.list();
            log.info("=====");
            list.stream().forEach(md -> log.info(md.toString()));

            session.close();

        } catch (HibernateException e) {
            log.error("Exception from hibernate", e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            HibernateUtil.shutdown();
        }

    }


}
