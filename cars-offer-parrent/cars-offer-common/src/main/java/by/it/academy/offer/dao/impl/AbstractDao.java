package by.it.academy.offer.dao.impl;

import by.it.academy.offer.db.connection.pool.ODataSource;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDao {

    protected final Logger logger;

    protected AbstractDao(Logger logger) {
        this.logger = logger;
    }


    protected Connection getConnection() throws SQLException {
        return ODataSource.getConnection();
    }

    protected void closeQuietly(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            logger.error("Error while closing closable: " + closeable, e);
        }
    }

}
