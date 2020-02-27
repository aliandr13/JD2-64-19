package by.it.academy.offer.Homework4.repository;

import by.it.academy.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findCarByIdLessThan10(Long id);


}
