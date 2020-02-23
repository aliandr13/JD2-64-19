package by.it.academy.offer.Homework4.dao;

import java.io.Serializable;

public interface DAO<E> {

    E add(E e);

    E update(E e);

    E get(Serializable id);

    void delete(Serializable id);

}
