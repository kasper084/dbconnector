package dbconnector.utils;

import dbconnector.models.Model;

import java.sql.*;

public class DBUtil {
    private static final String USER = "postgres";
    private static final String PASSWORD = "YWxhYmFtYQ==";
    private static final String URL = "jdbc:postgresql://localhost:5432/dev_profiles_db";

    private static Connection connection;

    private Connection connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, Decoder.decode(PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Model create(String table, Model model) {
        try (Connection connection = connect()) {
            String sql = "insert into"
                    + table + " " + model.getFields()
                    + " values " + model.getValues() + ";";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("successful");
        return model;
    }

    public Model delete(String table, Model model) {
        return model;
    }
}