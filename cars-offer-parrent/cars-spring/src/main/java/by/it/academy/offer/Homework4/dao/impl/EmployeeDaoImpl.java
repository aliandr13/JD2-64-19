package by.it.academy.offer.Homework4.dao.impl;

import by.it.academy.offer.Homework4.dao.BaseDao;
import by.it.academy.offer.Homework4.dao.EmployeeDao;
import by.it.academy.offer.Homework4.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

    protected EmployeeDaoImpl() {
        super(Employee.class);
    }
}
