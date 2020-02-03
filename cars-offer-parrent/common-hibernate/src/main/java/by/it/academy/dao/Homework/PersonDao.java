package by.it.academy.dao.Homework;

import by.it.academy.entity.Homework.Person;


import java.util.List;


public interface PersonDao {
    void create(Person pe);

    void update(Person pe);

    List<Person> read();

    void delete(Person pe);

}
