package by.it.academy.offer.Homework4.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;

public abstract class BaseDao<T> implements DAO<T> {

    private final Class<T> clazz;

    ThreadLocal<EntityManager> em = new ThreadLocal<>();

    @Autowired
    private EntityManagerFactory factory;

    protected BaseDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T add(T t) {
        begin();
        getEm().persist(t);
        commit();
        return t;
    }

    public EntityManager getEm() {
        if (em.get() == null) {
            em.set(factory.createEntityManager());
        }
        return em.get();
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public T get(Serializable id) {
        return getEm().find(clazz, id);
    }

    @Override
    public void delete(Serializable id) {

    }

    public void begin() {
        getEm().getTransaction().begin();
    }

    public void commit() {
        getEm().getTransaction().commit();
    }

}
