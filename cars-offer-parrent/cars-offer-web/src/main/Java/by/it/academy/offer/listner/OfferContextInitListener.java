package by.it.academy.offer.listner;

import by.it.academy.offer.db.connection.pool.ODataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OfferContextInitListener {
    @WebListener()
    public class ELearningContextInitListener implements ServletContextListener {
        public void contextInitialized(ServletContextEvent sce) {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle("mysql_hikari");
                ODataSource.configure(bundle);
                DataSource dataSource = ODataSource.getDataSource();
                //     DbMigration.migrate(dataSource);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Datasource initialisation error", e);
            }

        }
    }
}