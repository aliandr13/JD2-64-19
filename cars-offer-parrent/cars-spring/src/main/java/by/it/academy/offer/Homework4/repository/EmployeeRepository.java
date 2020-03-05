package by.it.academy.offer.Homework4.repository;

import by.it.academy.offer.Homework4.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    //    @Query("from  ")

//    List<Employee> findEmployeeByEmployeeDetailIsLessThan( );

//    List<Employee> findEmployeeByDepartmentBetween1And5();

    @Query("select d from Department d join d.employees e where e.lastName = :lastName ")
    List<Employee> getEmployeeByFirstName(@Param("lastName") String FirstName);


}
