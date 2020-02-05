package app;

import java.io.Serializable;

public class VolunteerSheet implements Serializable {
    String firstName;
    String lastName;
    String phone;
    String email;
    String team;

    public VolunteerSheet(String firstName, String lastName, String phone, String email, String team) {
        this.firstName = firstName;
        this.lastName = lastName;
        his.phone = phone;
        this.email = email;
        this.team = team;
    }

}