package by.it.academy.dao;

import by.it.academy.entity.PersonEntity;

public interface PersonDao {
    PersonEntity create(PersonEntity pe);

    PersonEntity update(PersonEntity pe);

    PersonEntity read(PersonEntity pe);

    void delete(PersonEntity pe);

}
