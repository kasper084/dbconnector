package dbconnector.utils;

import dbconnector.models.Model;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBUtil {
    private static final String USER = "postgres";
    private static final String PASSWORD = "YWxhYmFtYQ==";
    private static final String URL = "jdbc:postgresql://localhost:5432/dev_profiles_db";

    private static Integer id;

    private static Scanner scanner = new Scanner(System.in);
    private static Connection connection;

    private Connection connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, Decoder.decode(PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void create(String table, Model model) {
        String query = String.format("insert into %s %s values %s;",
                table, model.getFieldsNames(), model.getValues());
        executeQuery(query);
    }

    @SneakyThrows
    public Model read(String table, Model model) {
        String query = String.format("select * from %s where id = %d;"
                , table, enterId());
        ResultSet resultSet = getStatement(query).executeQuery();
        model = (Model) resultSet.getObject(id);
        return model;
    }

    public void update(String table, Model model) {
    }

    public void delete(String table) {
        String query = String.format("delete from %s where id = %d;",
                table, enterId());
        executeQuery(query);
    }

    private int enterId() {
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Enter number");
            scanner.nextInt();
        }
        return id;
    }

    @SneakyThrows
    private PreparedStatement getStatement(String query) {
        PreparedStatement preparedStatement;
        try (Connection connection = connect()) {
            preparedStatement = connection.prepareStatement(query);
        }
        return preparedStatement;
    }

    @SneakyThrows
    private void executeQuery(String query) {
        getStatement(query).executeUpdate();
    }
}