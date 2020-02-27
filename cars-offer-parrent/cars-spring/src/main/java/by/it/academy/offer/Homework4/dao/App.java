package by.it.academy.offer.Homework4.dao;

import by.it.academy.entity.Car;
import by.it.academy.offer.Homework4.dao.impl.CarServiceImpl;


public class App {


    public static void main(String[] args) {

        CarServiceImpl carService = new CarServiceImpl();
        Car car = new Car(null, 56, 2099, "jgjgjgj", null);
        carService.testSaveMethod(car);


    }
}
