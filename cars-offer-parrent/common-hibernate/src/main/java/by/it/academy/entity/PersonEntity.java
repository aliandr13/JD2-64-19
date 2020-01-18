package by.it.academy.entity;

import by.it.academy.util.HibernateUtil;

import javax.persistence.EntityManager;

public class PersonEntity {

    public static void main(String[] args) {
        Person person = new Person((long) 1, 19, "Лиза", "Лезовская");
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        HibernateUtil.close();
    }
}
