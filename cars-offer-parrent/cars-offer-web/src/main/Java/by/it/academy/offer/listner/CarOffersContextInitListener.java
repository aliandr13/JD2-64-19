//package by.it.academy.offer.listner;
//
//import by.it.academy.offer.db.connection.pool.ODataSource;
//import by.it.academy.offer.migration.DbMigration;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import javax.sql.DataSource;
//import java.util.ResourceBundle;
//
//import static by.it.academy.offer.service.ClientServiceImpl.logger;
//
//@WebListener()
//public class CarOffersContextInitListener implements ServletContextListener {
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        logger.info("Context initialized");
//        try {
//            ResourceBundle bundle = ResourceBundle.getBundle("hikari");
//            ODataSource.configure(bundle);
//            DataSource dataSource = ODataSource.getDataSource();
//            DbMigration.migrate(dataSource);
//        } catch (Throwable e) {
//            logger.error("error", e);
//            throw new RuntimeException("Datasource initialisation error", e);
//        }
//    }
//
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        logger.info("Context destroyed");
//    }
//}
