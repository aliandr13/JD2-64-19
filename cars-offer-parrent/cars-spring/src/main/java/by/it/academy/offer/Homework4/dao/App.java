package by.it.academy.offer.Homework4.dao;

import by.it.academy.offer.Homework4.dao.impl.EmployeeRepositoryImpl;
import by.it.academy.offer.Homework4.entity.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        EmployeeRepositoryImpl employeeRepository = context.getBean(EmployeeRepositoryImpl.class);
        Employee employee = new Employee(null, "fgf", "fgfg", null, null, null);

        employeeRepository.testEmployeeCrudRepository(employee);

//        employeeRepository.lessThan2();
//        employeeRepository.testMethodFromEmployeeRepository();
        employeeRepository.getEmployeeByFirstName("Andrei");

        context.close();
    }
}
