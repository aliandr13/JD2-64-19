package by.it.academy.offer.Homework4.dao.impl;

import by.it.academy.offer.Homework4.entity.Employee;
import by.it.academy.offer.Homework4.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeRepositoryImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void testEmployeeCrudRepository(Employee empl) {
        employeeRepository.save(empl);
    }

//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public void testMethodFromEmployeeRepository() {
//        employeeRepository.findEmployeeByDepartmentBetween1And5();
//    }

//    public void lessThan2() {
//        employeeRepository.findEmployeeByEmployeeDetailIsLessThan2();
//    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public void getEmployeeByFirstName(String FirstName) {
        employeeRepository.getEmployeeByFirstName(FirstName);
    }

}
