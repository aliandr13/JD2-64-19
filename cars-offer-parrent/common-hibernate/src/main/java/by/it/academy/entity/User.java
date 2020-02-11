package by.it.academy.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", unique = true)
    @javax.persistence.Access(AccessType.PROPERTY)
    private Long id;
    @Column(name = "USER_NAME")
    @NotNull
    private String userName;
    @Column(name = "PASSWORD")
    @NotNull
    private String password;
    @Column(name = "EMAIL")
    @NotNull
    private String email;
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user",
            cascade = CascadeType.ALL)
    private Access access;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
