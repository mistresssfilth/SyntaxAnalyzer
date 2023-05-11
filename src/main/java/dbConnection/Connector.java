package dbConnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    Connection dbConnection;

    public Connection getDbConnection() {
        try {
            DriverManager.registerDriver((Driver)
            Class.forName("org.postgresql.Driver").newInstance());
            dbConnection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/syntax_analyse","postgres", "admin");
            return dbConnection;
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
