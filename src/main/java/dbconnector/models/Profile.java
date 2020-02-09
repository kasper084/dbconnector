package dbconnector.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Profile implements Model {
    private Integer id;
    private String username;
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
                + "'" + getUsername() + "', "
                + "'" + getJob_title() + "', "
                + "'" + getDepartment() + "', "
                + "'" + getCompany() + "', "
                + "'" + getSkill() + "')";

    }
}