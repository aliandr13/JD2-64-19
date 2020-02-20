package by.it.academy.offer.Homework;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component("privateAddress")
public class PrivateAddress implements Address {

    @Value("Belarus")
    private String country;
    @Value("Dzerjinskogo")
    private String street;
    @Value("25")
    private Integer house;
    @Value("76")
    private Integer flat;
}
