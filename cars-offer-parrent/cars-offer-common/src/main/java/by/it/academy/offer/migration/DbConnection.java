package by.it.academy.offer.migration;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DbConnection {

    private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);


    public Connection getConnection() throws SQLException, ClassNotFoundException {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        Class.forName(bundle.getString("db.driver"));
        return DriverManager.getConnection(
                bundle.getString("db.url"),
                bundle.getString("db.user"),
                bundle.getString("db.password")
        );
    }

    public static final void main(String[] args) throws SQLException, ClassNotFoundException {

        prepared();
    }

    private static void prepared() {
        DbConnection db = new DbConnection();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = db.getConnection();
            statement = connection.prepareStatement("INSERT INTO car (price, date,engine,VIN) VALUE (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, "tesla");
            statement.setLong(2, 1L);

            int i = statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            int anInt = generatedKeys.getInt(1);

            System.out.println("Rows affected: " + i);
            System.out.println("Generated id: " + anInt);

        } catch (SQLException | ClassNotFoundException e) {
            logger.error("error in insert", e);
        } finally {
            closeQuite(resultSet);
            closeQuite(statement);
            closeQuite(connection);
        }
    }

    private static void insert() {
        DbConnection db = new DbConnection();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from car");
            while ((resultSet.next())) {
                System.out.print("Id: ");
                System.out.print(resultSet.getInt(1));
                System.out.print("model_id: ");
                System.out.print(resultSet.getInt(2));
                System.out.print("price: ");
                System.out.print(resultSet.getInt(3));
                System.out.print("date: ");
                System.out.print(resultSet.getDate(4));
                System.out.print("engine: ");
                System.out.println(resultSet.getInt(5));
                System.out.print("VIN: ");
                System.out.println(resultSet.getString(6));
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("error in insert", e);
        } finally {
            closeQuite(resultSet);
            closeQuite(statement);
            closeQuite(connection);
        }
    }

    private static void closeQuite(AutoCloseable cl) {
        if (cl != null) {
            try {
                cl.close();
            } catch (Exception e) {
                logger.error("Error while closing", e);
            }
        }
    }

    private static void query1() throws Exception {
        DbConnection db = new DbConnection();
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from car");
            while ((resultSet.next())) {
                System.out.print("Id: ");
                System.out.print(resultSet.getInt(1));
                System.out.print("model_id: ");
                System.out.print(resultSet.getInt(2));
                System.out.print("price: ");
                System.out.print(resultSet.getInt(3));
                System.out.print("date: ");
                System.out.print(resultSet.getDate(4));
                System.out.print("engine: ");
                System.out.println(resultSet.getInt(5));
                System.out.print("VIN: ");
                System.out.println(resultSet.getString(6));
            }
        }
    }

    private static void getTableNames() throws Exception {
        DbConnection db = new DbConnection();
        try (Connection connection = db.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();

            List<String> tables = getTablesMetadata(metaData);
            getColumnsMetadata(metaData, tables);
        }
    }

    private static List<String> getTablesMetadata(DatabaseMetaData metadata) throws SQLException {
        String[] table = {"TABLE"};
        ResultSet rs = metadata.getTables(null, null, null, table);
        List<String> tables = new ArrayList<>();
        while (rs.next()) {
            tables.add(rs.getString("TABLE_NAME"));
        }
        return tables;
    }

    private static void getColumnsMetadata(DatabaseMetaData metadata, List<String> tables) throws SQLException {
        ResultSet rs = null;
        for (String actualTable : tables) {
            rs = metadata.getColumns(null, null, actualTable, null);
            System.out.println("Table: " + actualTable.toUpperCase());
            while (rs.next()) {
                System.out.println("\tColumn: " + rs.getString("COLUMN_NAME") + " "
                        + rs.getString("TYPE_NAME") + " "
                        + rs.getString("COLUMN_SIZE"));
            }
        }
    }

}
