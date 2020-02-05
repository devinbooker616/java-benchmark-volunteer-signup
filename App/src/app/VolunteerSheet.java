package app;

import java.io.Serializable;

public class VolunteerSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    String firstName;
    String lastName;
    String phone;
    String email;
    String team;

    public VolunteerSheet(String firstName, String lastName, String phone, String email, String team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.team = team;
    }

}