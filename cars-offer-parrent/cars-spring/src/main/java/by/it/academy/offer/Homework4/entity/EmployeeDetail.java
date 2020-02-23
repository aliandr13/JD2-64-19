package by.it.academy.offer.Homework4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeDetail {

    @Id
    @GenericGenerator(name = "one-one", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "employee"))
    @GeneratedValue(generator = "one-one")
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    @ToString.Exclude
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Employee employee;

}
