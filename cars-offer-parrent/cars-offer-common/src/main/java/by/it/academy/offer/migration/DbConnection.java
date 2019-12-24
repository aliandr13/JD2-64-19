 package by.it.academy.offer.migration;

import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.logging.Logger;

public class DbConnection {
    //   private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);
    public Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mariadb.jdbc.Driver");
        Connection connection = new DbConnection().getConnection();
        DriverManager.getConnection("jdbc:mysql://localhost:3306/MyTest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
                "root",
                "r20Porsche2022");

        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection;
        connection = new DbConnection().getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO departament (id,name) VALUES (1, 'AAAA') ");
//     System.out.println("Affected rows ="+i);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM departament;");
        while (resultSet.next()){
          int id =   resultSet.getInt("id");
            System.out.println("New Id ="+ id);
          String name = resultSet.getString("name");
            System.out.println("Id = "+ id+" name= "+name);
        }

    }

}
