package by.it.academy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MARK")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MARK_ID", unique = true)
    private Long markIDd;

    @Column(name = "NAME")
    private String model;

    @OneToMany(mappedBy = "mark", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Model> modelSet = new HashSet<>() ;

}

