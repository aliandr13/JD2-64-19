package by.it.academy.offer.dao.impl;

import by.it.academy.offer.dao.ClientDao;
import by.it.academy.offer.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDaoImpl extends AbstractDao implements ClientDao {

    private static final ClientDaoImpl INSTANCE = new ClientDaoImpl();

    public static final String INSERT_CLIENT = "INSERT INTO client (first_name, middle_name, last_name, phone) VALUE (?,?,?,?)";
    public static final String SELECT_CLIENT_BY_ID = "SELECT * FROM client WHERE id = ?";
    public static final String SELECT_ALL_CLIENT = "SELECT * FROM client";
    public static final String UPDATE_CLIENT = "UPDATE client  SET first_name = ? , middle_name = ?, last_name = ?, phone = ? WHERE id = ?";
    public static final String DELETE_CLIENT_BY_ID = "DELETE FROM client WHERE id = ?";

    private ClientDaoImpl() {
        super(LoggerFactory.getLogger(ClientDaoImpl.class));
    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Long create(Client client) throws SQLException {
        ResultSet resultSet = null;
        Long result = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CLIENT, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getMiddleName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getPhone());

            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                result = resultSet.getLong(1);
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }


    @Override
    public Optional<Client> read(Long id) throws SQLException {
        ResultSet resultSet = null;
        Optional<Client> result = Optional.empty();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CLIENT_BY_ID)) {

            statement.setLong(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = Optional.of(mapClient(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }


    @Override
    public int update(Client client) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT)) {

            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getMiddleName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getPhone());
            statement.setLong(5, client.getId());

            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(Long id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate();
        }
    }

    @Override
    public List<Client> getAll() throws SQLException {
        ResultSet resultSet = null;
        List<Client> result = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CLIENT)) {

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(mapClient(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    private Client mapClient(ResultSet resultSet) throws SQLException {
        long userId = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String middleName = resultSet.getString("middle_name");
        String lastName = resultSet.getString("last_name");
        String phone = resultSet.getString("phone");
        return new Client(userId, firstName, middleName, lastName, phone);
    }
}