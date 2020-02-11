package by.it.academy.dao;

import by.it.academy.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDAO {

    void create(User user) throws SQLException;

    List<User> getAll() throws SQLException;

    void update(User user) throws SQLException;

    void delete(User user) throws SQLException;

    List<User> findUser(String userName, String password);


}
