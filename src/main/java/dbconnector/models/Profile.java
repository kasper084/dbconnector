package dbconnector.models;

import lombok.NonNull;

public class Profile implements Model {
    private @NonNull int id;
    private @NonNull String username;
    private String job_title;
    private String department;
    private String company;
    private String skill;
}