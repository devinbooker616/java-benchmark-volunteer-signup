package app;

import java.util.*;
import java.io.*;

public class ChurchAdmin {
    public static void main(String[] args) throws Exception {
        ArrayList<VolunteerSheet> volunteers = loadVolunteers();
        System.out.println("Hello");
        System.out.println(volunteers.size() + " people are interested in volunteering");
        for (VolunteerSheet volunteer : volunteers) {
            System.out.println(volunteer.firstName + " " + volunteer.lastName + " - " + volunteer.phone + " - " + " "
                    + volunteer.email + " is interested in: " + volunteer.team);
        }
    }

    public static ArrayList<VolunteerSheet> loadVolunteers() {
        try {
            FileInputStream fileStream = new FileInputStream("volunteers.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<VolunteerSheet> volunteers = (ArrayList<VolunteerSheet>) os.readObject();
            os.close();
            return volunteers;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<VolunteerSheet>();
        }
    }
}