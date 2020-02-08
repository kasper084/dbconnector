package dbconnector.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class Account implements Model {
    private @NonNull int id;
    private String firs_name;
    private String last_name;
    private String city;
    private String gender;
    private @NonNull String username;

    @Override
    public String getFields() {
        return "(id, first_name, last_name, city, gender, username)";
    }

    @Override
    public String getValues() {
        return "('" + id + "', "
                + "'" + firs_name + "', "
                + "'" + last_name + "', "
                +"'" + city + "', "
                + "'" + gender + "', "
                + "'" + username + "')";
    }
}