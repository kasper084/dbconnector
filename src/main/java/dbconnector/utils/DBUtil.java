package dbconnector.utils;

import dbconnector.models.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
    private static final String USER = "postgres";
    private static final String PASSWORD = "YWxhYmFtYQ==";
    private static final String URL = "jdbc:postgresql://localhost:5432/dev_profiles_db";

    private static Connection connection;

    private Connection connect() {
        try {
           connection = DriverManager.getConnection(URL,USER, Decoder.decode(PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void create(Model model) {
        try (Connection connection = connect()){
            String sql = "ins";
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}