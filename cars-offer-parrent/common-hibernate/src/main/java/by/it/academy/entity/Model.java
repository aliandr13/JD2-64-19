package by.it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MODEL")
@Data
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_ID", unique = true)
    @Access(AccessType.PROPERTY)
    private Long modelId;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MARK_ID")
    private Mark mark;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MODEL_ENGINE", joinColumns = {@JoinColumn(name = "MODEL_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ENGINE_ID")})
    private List<Engine> engines = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @javax.persistence.Access(AccessType.PROPERTY)
    private Car car;


}
