package app;

import java.io.Serializable;

public class VolunteerSheet implements Serializable {
    String firstName;
    String lastName;
    String phone;
    String email;
    String worship;
    String welcome;
    String production;
    String communityGroups;
    String childrenMinistry;
    String studentMinistry;

    public VolunteerSheet(String firstName, String lastName, String phone, String email, String worship, String welcome,
            String production, String communityGroups, String childrenMinistry, String studentMinistry) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.worship = worship;
        this.welcome = welcome;
        this.production = production;
        this.communityGroups = communityGroups;
        this.childrenMinistry = childrenMinistry;
        this.studentMinistry = studentMinistry;
    }

}