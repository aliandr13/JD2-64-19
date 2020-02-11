package by.it.academy.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "CITY")
    @NotNull
    private String city;
    @Column(name = "STREET")
    @NotNull
    private String street;
    @Column(name = "POSTAC_CODE")
    private String postalCode;

}
