package by.it.academy.dao;

import by.it.academy.entity.Car;
import by.it.academy.entity.Model;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO {

    void create(Car car) throws SQLException;

    List<Car> getAll() throws SQLException;


    List<Car> getAvaliableCars() throws SQLException;

    void update(Car car) throws SQLException;

    void delete(Car car) throws SQLException;

    List<Model> getAvaliableModel();


}
