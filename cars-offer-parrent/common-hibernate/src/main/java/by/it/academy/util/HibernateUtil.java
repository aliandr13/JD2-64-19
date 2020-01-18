package by.it.academy.util;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Slf4j
public class HibernateUtil {
    private static final EntityManagerFactory MN_FACTORY;

    static {
        MN_FACTORY = Persistence.createEntityManagerFactory("by.it.academy");
    }


    public static EntityManager getEntityManager() {
        return MN_FACTORY.createEntityManager();
    }

    public static void close() {
        MN_FACTORY.close();
    }
}

