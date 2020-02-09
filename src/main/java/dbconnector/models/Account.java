package dbconnector.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Account implements Model {
    private @NonNull Integer id;
    private String firs_name;
    private String last_name;
    private String city;
    private String gender;
    private @NonNull String username;

    @Override
    public String getFieldsNames() {
        return "(id, first_name, last_name, city, gender, username)";
    }

    @Override
    public String getValues() {
        return "('" + getId() + "', "
                + "'" + getFirs_name() + "', "
                + "'" + getLast_name() + "', "
                +"'" + getCity() + "', "
                + "'" + getGender() + "', "
                + "'" + getUsername() + "')";
    }
}