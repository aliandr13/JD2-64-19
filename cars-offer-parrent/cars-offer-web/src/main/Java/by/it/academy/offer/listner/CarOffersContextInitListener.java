package by.it.academy.offer.listner;

import by.it.academy.offer.db.connection.pool.ODataSource;
import by.it.academy.offer.migration.DbMigration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@WebListener()
public class CarOffersContextInitListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(CarOffersContextInitListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Context initialized");
        try {
            URL resource = this.getClass().getClassLoader().getResource("hikari.properties");
            ODataSource.init(new File(resource.getFile()));
            DataSource dataSource = ODataSource.getDataSource();
            DbMigration.migrate(dataSource);
        } catch (IOException e) {
            logger.error("error", e);
            throw new RuntimeException("Datasource initialisation error");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Context destroyed");
    }
}
