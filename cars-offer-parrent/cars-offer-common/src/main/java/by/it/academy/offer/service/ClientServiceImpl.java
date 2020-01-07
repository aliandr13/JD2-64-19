package by.it.academy.offer.service;

import by.it.academy.offer.dao.ClientDao;
import by.it.academy.offer.dao.impl.ClientDaoImpl;
import by.it.academy.offer.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.*;

public class ClientServiceImpl implements ClientService {

    private static final ClientService INSTANCE = new ClientServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientDao clientDao = ClientDaoImpl.getInstance();

    private ClientServiceImpl() {
    }

    public static ClientService getService() {
        return INSTANCE;
    }


    @Override
    public List<Client> getAllClients() {

        logger.debug("Get all clients");
        try {
            return clientDao.getAll();
        } catch (SQLException e) {
            logger.error("Error while getting all clients", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Client> getById(Long id) {
        logger.debug("Get client by id {}", id);
        try {
            Optional<Client> client = clientDao.read(id);
            logger.debug("result {}", client);
            return client;
        } catch (SQLException e) {
            logger.error("Error while getting client by id " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public Client add(Client client) {
        logger.debug("add new client {}", client);
        try {
            Long id = clientDao.create(client);
            client.setId(id);
            logger.debug("result {}", id);
        } catch (SQLException e) {
            logger.error("Error while creating client " + client, e);
        }
        return client;
    }

    @Override
    public void delete(Long id) {
        logger.debug("deleting client id = {}", id);
        try {
            int delete = clientDao.delete(id);
            logger.debug("result {}", delete);
        } catch (SQLException e) {
            logger.error("Error while deleting client id=" + id, e);
        }
    }

    @Override
    public Client update(Client client) {
        logger.debug("updating client {}", client);
        try {
            int update = clientDao.update(client);
            logger.debug("result {}", update);
        } catch (SQLException e) {
            logger.error("Error while updating client " + client, e);
        }
        return client;

    }
}
