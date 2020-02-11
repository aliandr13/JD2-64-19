package by.it.academy.offer.service;

import by.it.academy.dao.CarDAO;
import by.it.academy.entity.Car;
import by.it.academy.service.CarService;


import java.sql.SQLException;
import java.util.List;

public class ModelService {

    private CarDAO carDao = new CarService();

    public List<Car> getAvaliableCars() throws SQLException {
        return carDao.getAvaliableCars();
    }

}
