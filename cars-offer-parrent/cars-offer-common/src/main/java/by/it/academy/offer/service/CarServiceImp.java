package by.it.academy.offer.service;

import by.it.academy.offer.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImp {

    private static final CarServiceImp INSTANCE = new CarServiceImp();

    private final List<Car> cars;

    private CarServiceImp() {
        cars = new ArrayList<>();
        cars.add(new Car(1L, "Porsche", 350, "black", "V8", 2015));
        cars.add(new Car(2L, "BMW ", 150, "white", "V6", 2012));
        cars.add(new Car(2L, "Subaru", 100, "red", "V6", 2013));
    }

    public static CarServiceImp getService() {
        return INSTANCE;
    }

    public List<Car> getAll() {
        return new ArrayList<>(cars);
    }

}
