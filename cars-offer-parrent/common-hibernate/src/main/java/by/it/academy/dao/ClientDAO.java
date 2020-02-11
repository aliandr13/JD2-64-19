package by.it.academy.dao;

import by.it.academy.entity.Client;
import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {

    void create(Client client) throws SQLException;

    List<Client> getAll() throws SQLException;

    void update(Client client) throws SQLException;

    void delete(Client client) throws SQLException;

}
