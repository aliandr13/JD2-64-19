package by.it.academy.offer.service;

import by.it.academy.offer.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ClientServiceImpl implements ClientService {

    private static final ClientService INSTANCE = new ClientServiceImpl();
    private final Map<Long, Client> clientRepository = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(10);

    private ClientServiceImpl() {
        clientRepository.put(1L, new Client(1L, "Pasha", "Sergeevich", "Cichkar", "+375(29)-784-90-30"));
        clientRepository.put(2L, new Client(2L, "Andrei", "Vitalevich", "Golombevski", "+375(33)-784-09-03"));
    }

    public static ClientService getService() {
        return INSTANCE;
    }

    @Override
    public List<Client> getAllClients() {
        return new ArrayList<>(clientRepository.values());
    }

    @Override
    public Client add(Client client) {
        client.setId(sequence.incrementAndGet());
        clientRepository.put(client.getId(), client);
        return client;
    }

    @Override
    public void delete(Long id) {
        clientRepository.remove(id);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.put(client.getId(), client);
    }
}
