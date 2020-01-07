package by.it.academy.offer.dao.impl;

import by.it.academy.offer.model.User;
import by.it.academy.offer.service.UserService;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserServiceImpl implements UserService {

    private static final UserService INSTANCE = new UserServiceImpl();
    private final Map<String, User> users = new ConcurrentHashMap<>();

    private UserServiceImpl() {
        users.put("abra", new User("Den", "13579", "admin"));
        users.put("kadabra", new User("Ren", "2468", "user"));
    }

    public static UserService getInstance() {
        return INSTANCE;
    }


    @Override
    public Optional<User> findUser(String login, String password) {
        User user = users.get(login);
        if (user != null && password.equals(user.getPassword())) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
