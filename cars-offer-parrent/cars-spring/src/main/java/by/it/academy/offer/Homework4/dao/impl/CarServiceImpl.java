package by.it.academy.offer.Homework4.dao.impl;

import by.it.academy.entity.Car;
import by.it.academy.offer.Homework4.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl {
    @Autowired
    private CarRepository carRepository;

    public void testSaveMethod(Car car) {
        carRepository.save(car);

    }
}
