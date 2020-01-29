package by.it.academy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE_DETAILS")
public class EmployeeDetail {
    @Id
    @Column(name = "IMPLOYEE_ID")
    @GenericGenerator(name = "one-one", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "employee"))
    @GeneratedValue(generator = "one-one")
    @Access(AccessType.PROPERTY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @Access(AccessType.PROPERTY)
    @ToString.Exclude
    private Employee employee;


}
