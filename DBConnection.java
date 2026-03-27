package gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static final String URL  = "jdbc:mysql://localhost:3306/travel_gym_db";
    static final String USER = "root";
    static final String PASS = "Darshu@1203!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}