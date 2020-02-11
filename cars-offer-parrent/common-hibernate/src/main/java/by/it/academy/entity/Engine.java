package by.it.academy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENGINE_ID")
    private Long id;
    @Column(name = "ENGINE")
    private double engine;

    @ManyToMany(mappedBy = "engines")
    private Set<Model> models = new HashSet<>();



}
