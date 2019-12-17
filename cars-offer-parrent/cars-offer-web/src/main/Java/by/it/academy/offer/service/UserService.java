package by.it.academy.offer.service;

import by.it.academy.offer.model.User;

import java.util.Optional;

public interface UserService {

        Optional<User> findUser(String login, String password);
}
