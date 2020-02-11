package by.it.academy.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FIRST_NAME")
    @NotNull
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    @NotNull
    private String middleName;
    @Column(name = "LAST_NAME")
    @NotNull
    private String lastName;
    @Column(name = "PHONE")
    @NotNull
    private String phone;
    @Embedded
    private Address address;
}
