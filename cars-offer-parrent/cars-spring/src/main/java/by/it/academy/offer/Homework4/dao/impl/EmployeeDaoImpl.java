package by.it.academy.offer.Homework4.dao.impl;

import by.it.academy.offer.Homework4.dao.BaseDao;
import by.it.academy.offer.Homework4.dao.EmployeeDao;
import by.it.academy.offer.Homework4.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {

    protected EmployeeDaoImpl(Class<Employee> clazz) {
        super(clazz);
    }

    @Override
    public List<Employee> getEmployee() {
        return getEm().createQuery("from Employee ", Employee.class).getResultList();
    }

//    @Override
//    public List<Employee> getEmployees() {
//        return getEm().createQuery("from Employee", Employee.class).getResultList();
//    }
}
