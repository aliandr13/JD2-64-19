package by.it.academy.dao.Homework;

import by.it.academy.entity.Homework_Criteria.Department;
import by.it.academy.entity.Homework_Criteria.Employee;

import java.util.List;

public interface EmployeeDao {

    void createDepartment(Department department);

    void create(Employee employee);

    List<Employee> getAll();

    List<Employee> getByName(String name);

    List<Employee> getAllWithNameNotNull();

    List<Employee> getSalaryLessOrEqual(Long salary);

    List<Employee> getByAgeBetween(Integer from, Integer to);

    long getEmployeeCount();

    Double getAverageSalary();

    Double getMaxSalary();

    long getMinAge();


}
