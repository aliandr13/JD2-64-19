package by.it.academy.offer.Homework4.dao;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class BaseDao<E> implements DAO<E> {

    private final Class<E> clazz;
    @Getter
    @Autowired
    @PersistenceContext
    private EntityManager em;

    protected BaseDao(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E add(E e) {
        em.persist(e);
        return e;
    }

    @Override
    public E get(Serializable id) {
        return getEm().find(clazz, id);
    }

    @Override
    public E update(E e) {
        em.merge(e);
        return e;
    }

    @Override
    public void delete(Serializable id) {
        em.remove(em.find(clazz, id));
    }
}
