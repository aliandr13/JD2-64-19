package by.it.academy.offer.Homework4.service;

import java.io.Serializable;

public interface Service<E> {
    E add(E e);

    E update(E e);

    E get(Serializable id);

    void delete(Serializable id);

}
