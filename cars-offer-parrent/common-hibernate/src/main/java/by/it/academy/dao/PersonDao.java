package by.it.academy.dao;

import by.it.academy.entity.Person;
import by.it.academy.entity.PersonEntity;

import java.util.List;


public interface PersonDao {
    void create(Person pe);

    void update(Person pe);

    List<Person> read(Person pe);

    void delete(Person pe);

}
