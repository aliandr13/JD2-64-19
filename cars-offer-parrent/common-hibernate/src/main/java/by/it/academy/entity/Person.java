package by.it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity @EqualsAndHashCode @AllArgsConstructor @NoArgsConstructor @Data
public class Person {

    @Id
    private Long id;

    private Integer age;

    private String name;

    private String surname;

}



