package by.it.academy.entity.Homework_Criteria;

import by.it.academy.dao.Homework.EmployeeDao;

import java.util.List;

import by.it.academy.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.*;

@Slf4j
public class EmployeeDaoImpl implements EmployeeDao {

    private static final EmployeeDaoImpl INSTANCE = new EmployeeDaoImpl();

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();

    public static EmployeeDaoImpl getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void createDepartment(Department department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("error while creating department: " + e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void create(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("error while creating person: " + e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Employee> getAll() {
        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        criteria.from(Employee.class);
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getByName(String name) {
        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee).where(criteriaBuilder.equal(employee.get("name"), name));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getAllWithNameNotNull() {
        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee).where(criteriaBuilder.isNotNull(employee.get("name")));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getSalaryLessOrEqual(Long salary) {
        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee).where(criteriaBuilder.lessThanOrEqualTo(employee.get("salary"), salary));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getByAgeBetween(Integer from, Integer to) {
        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee).where(criteriaBuilder.between(employee.get("age"), from, to));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public long getEmployeeCount() {
        CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
        criteria.select(criteriaBuilder.count(criteria.from(Employee.class)));
        Session session = sessionFactory.openSession();
        long count = session.createQuery(criteria).getSingleResult();
        session.close();
        return count;
    }

    @Override
    public Double getAverageSalary() {
        CriteriaQuery<Double> criteria = criteriaBuilder.createQuery(Double.class);
        criteria.select(criteriaBuilder.avg(criteria.from(Employee.class).get("salary")));
        Session session = sessionFactory.openSession();
        Double result = session.createQuery(criteria).getSingleResult();
        session.close();
        return result;
    }

    @Override
    public Double getMaxSalary() {
        CriteriaQuery<Double> criteria = criteriaBuilder.createQuery(Double.class);
        criteria.select(criteriaBuilder.max(criteria.from(Employee.class).get("salary")));
        Session session = sessionFactory.openSession();
        Double result = session.createQuery(criteria).getSingleResult();
        session.close();
        return result;
    }

    @Override
    public long getMinAge() {
        CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
        criteria.select(criteriaBuilder.min(criteria.from(Employee.class).get("age")));
        Session session = sessionFactory.openSession();
        long result = session.createQuery(criteria).getSingleResult();
        session.close();
        return result;
    }


}
