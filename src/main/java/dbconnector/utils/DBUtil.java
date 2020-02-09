package dbconnector.utils;

import dbconnector.models.Account;
import dbconnector.models.Model;
import dbconnector.models.Profile;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class DBUtil {
    private static final String USER = "postgres";
    private static final String PASSWORD = "YWxhYmFtYQ==";
    private static final String ACCOUNTS = "dev_profiles_db.public.accounts";
    private static final String PROFILES = "dev_profiles_db.public.profiles";
    private static final String URL = "jdbc:postgresql://localhost:5432/dev_profiles_db";

    @SneakyThrows
    private Connection connect() {
        return DriverManager.getConnection(URL, USER, this.decode(PASSWORD));
    }

    public void create(String table, Model model) {
        String query = String.format("insert into %s %s values %s;",
                table, model.getFieldsNames(), model.getValues());
        queryExecutor(query);
    }

    @SneakyThrows
    public List<Model> read(String table) {
        List<Model> models = new ArrayList<>();
        Model model = null;
        String query = String.format("select * from %s;", table);
        ResultSet rs = getResultSet(query);
        while (rs.next()) {
            if (query.contains(ACCOUNTS)) {
                model = new Account(rs.getInt("id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("city"),
                        rs.getString("gender"), rs.getString("username"));
            } else if (query.contains(PROFILES)) {
                model = new Profile(rs.getInt("id"), rs.getString("username"),
                        rs.getString("job_title"), rs.getString("department"),
                        rs.getString("company"), rs.getString("skill"));
            }
            models.add(model);
        }
        return models;
    }

    public void update(String table, String column, String newData, Integer id) {
        String query = String.format("update %s set %s = '%s' where id = %d;",
                table, column, newData, id);
        queryExecutor(query);
    }

    public void delete(String table, Integer id) {
        String query = String.format("delete from %s where id = %d;", table, id);
        queryExecutor(query);
    }

    @SneakyThrows
    private ResultSet getResultSet(String query) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try (Connection connection = connect()) {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        }
        System.out.printf("SUCCESS: %s%n", query);
        return resultSet;
    }

    @SneakyThrows
    private void queryExecutor(String query) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        }
        System.out.printf("SUCCESS: %s%n", query);
    }

    private String decode(String word) {
        return new String(Base64.getDecoder().decode(word));
    }
}