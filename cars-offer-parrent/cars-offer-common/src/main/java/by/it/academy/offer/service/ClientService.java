package by.it.academy.offer.service;

import by.it.academy.offer.model.Client;

import java.util.List;

public interface ClientService {


    List<Client> getAllClients();

    Client add(Client client);

    void delete(Long id);

    Client update(Client client);

}
