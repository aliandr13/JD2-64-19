package by.it.academy.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ACCESS")

public class Access {
    @Id
    @GenericGenerator(name = "one-one", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user"))
    @GeneratedValue(generator = "one-one")

    @javax.persistence.Access(AccessType.PROPERTY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "ROLE")
    @NotNull
    private String role;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @javax.persistence.Access(AccessType.PROPERTY)
    private User user;
}
