package by.it.academy.offer.Homework4.service;

import by.it.academy.offer.Homework4.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;

@Transactional
public abstract class BaseService<E> implements Service<E> {
    @Autowired
    protected BaseDao<E> baseDao;


    @Override
    public E add(E e) {
        return baseDao.add(e);
    }

    @Override
    public E update(E e) {
        return null;
    }

    @Override
    public E get(Serializable id) {
        return baseDao.get(id);
    }

    @Override
    public void delete(Serializable id) {
        baseDao.delete(id);
    }
}
