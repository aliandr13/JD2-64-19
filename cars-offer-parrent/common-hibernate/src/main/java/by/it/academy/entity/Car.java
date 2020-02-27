package by.it.academy.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PRICE")
    @NotNull
    private int price;
    @Column(name = "DATE")
    private int date;
    @Column(name = "VIN")
    @NotNull
    private String VIN;

    @ToString.Exclude
    @JoinColumn(name = "MODEL_ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Model model;
}
