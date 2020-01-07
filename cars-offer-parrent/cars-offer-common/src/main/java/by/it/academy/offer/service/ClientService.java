package by.it.academy.offer.service;

import by.it.academy.offer.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {


    List<Client> getAllClients();

    Optional<Client> getById(Long id);

    Client add(Client client);

    void delete(Long id);

    Client update(Client client);

}
