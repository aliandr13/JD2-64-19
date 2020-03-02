package by.it.academy.offer.Homework4.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ToString.Exclude
    @OneToOne(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private EmployeeDetail employeeDetail;
    @ManyToOne @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Meeting> meetings = new ArrayList<>();


}
