package dbconnector.models;

import lombok.NonNull;

public class Account implements Model{
    private @NonNull int id;
    private String firs_name;
    private String last_name;
    private String city;
    private String gender;
    private @NonNull String username;
}