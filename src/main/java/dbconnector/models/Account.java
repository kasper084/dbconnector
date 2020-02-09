package dbconnector.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account implements Model {
    private Integer id;
    private String first_name;
    private String last_name;
    private String city;
    private String gender;
    private String username;

    @Override
    public String getFieldsNames() {
        return "(id, first_name, last_name, city, gender, username)";
    }

    @Override
    public String getValues() {
        return "('" + getId() + "', "
                + "'" + getFirst_name() + "', "
                + "'" + getLast_name() + "', "
                + "'" + getCity() + "', "
                + "'" + getGender() + "', "
                + "'" + getUsername() + "')";
    }
}