package by.it.academy.entity.Homework;

import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestEmployee {
    public static void main(String[] args) {
        Session session = null;
        try {


            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Department department = new Department("IT");
            Department department1 = new Department("HR");

            Meeting first_meeting = new Meeting("Java advantages");
            Meeting second_meeting = new Meeting("Hibernate relation grooming");
            Meeting third_meeting = new Meeting("SQL/HQL/Criteria");

            EmployeeDetail detail = new EmployeeDetail(null, "Nemiga", "Minsk", "state", "Belarus", null);
            Employee employee = new Employee(null, "Ivan", "Ivanov", 450, null, department, new ArrayList<>());

            Employee employee1 = new Employee(null, "Petya", "Petrov", 1090, null, department1, new ArrayList<>());
            EmployeeDetail detail1 = new EmployeeDetail(null, "Nemiga", "Grodno", "state", "Belarus", employee1);

            Employee employee2 = new Employee(null, "Misha", "Alekseevich", 657, null, department, new ArrayList<>());
            EmployeeDetail detail2 = new EmployeeDetail(null, "Kazinca", "Minsk", "state", "Belarus", employee2);


            employee.setEmployeeDetail(detail);
            detail.setEmployee(employee);
            session.save(department);
            session.save(employee);
            first_meeting.getEmployees().add(employee);
            session.save(first_meeting);
            employee.getMeetings().add(first_meeting);
            session.saveOrUpdate(employee);
            /* Для второй записи */
            employee1.setEmployeeDetail(detail1);
            session.save(department1);
            session.save(employee1);
            second_meeting.getEmployees().add(employee1);
            session.save(second_meeting);
            employee1.getMeetings().add(second_meeting);
            session.saveOrUpdate(employee1);
            /* для третьей записи */
            employee2.setEmployeeDetail(detail2);
            session.save(employee2);
            third_meeting.getEmployees().add(employee2);
            session.save(third_meeting);
            employee2.getMeetings().add(third_meeting);
            session.saveOrUpdate(employee2);

            session.getTransaction().commit();


            List list;
            Query query = session.createQuery("select e from Employee e join e.meetings m where  m.subject = 'SQL/HQL/Criteria'  ", Employee.class);
            list = query.list();


            List list2;
            Query query2 = session.createQuery("select max(e.salary), e.FirstName from Employee e group by e.FirstName");
            list2 = query2.list();


            List FIRST;
            Query query1 = session.createQuery("select e.salary,e.FirstName, m.subject from Employee e join e.meetings m where e.salary > 500  ");
            FIRST = query1.list();

            List SECOND;
            Query query3 = session.createQuery("select e.departmentName from Department as e ");
            SECOND = query3.list();

            List THIRD;
            Query query4 = session.createQuery("select e.meetings,e.department.departmentName from Employee as e join e.department m");
            THIRD = query.list();

            log.info("==========================");
            list.stream().forEach(empl -> log.info(empl.toString()));
            log.info("------------");
            FIRST.stream().forEach(emplSalary -> {
                Object[] emp1 = (Object[]) emplSalary;
                log.info("Something " + emp1[2] + " Зарплата: " + emp1[0] + " Имя:" + emp1[1]);
            });
            log.info("-------------");
            list2.stream().forEach(emplConstructure -> {
                Object[] emp = (Object[]) emplConstructure;
                log.info("Имя: " + emp[1] + " зарплата:" + emp[0]);
            });
            log.info("-----------");
            SECOND.stream().forEach(name -> log.info(name.toString()));
            log.info("-----------");
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
