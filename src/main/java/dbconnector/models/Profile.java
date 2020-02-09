package dbconnector.models;


import lombok.Data;
import lombok.NonNull;

@Data
public class Profile implements Model {
    private @NonNull Integer id;
    private @NonNull String username;
    private String job_title;
    private String department;
    private String company;
    private String skill;

    @Override
    public String getFieldsNames() {
        return "(id, username, job_title, department, company, skill)";
    }

    @Override
    public String getValues() {
         return "('" + getId() + "', "
                + "'" + getJob_title() + "', "
                + "'" + getDepartment() + "', "
                + "'" + getCompany() + "', "
                + "'" + getSkill() + "', "
                + "'" + getUsername() + "')";
    }
}