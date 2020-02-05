package app;

import java.util.*;
import java.io.*;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ArrayList<VolunteerSheet> volunteers = loadVolunteers();
        System.out.println(
                "One does make a difference, your involvement matters, so fill out the information and select your areas of interest");

        VolunteerSheet filledForm = getVolunteer();
        System.out.println("Thank your for your participation");
        volunteers.add(filledForm);

        saveVolunteers(volunteers);
    }

    public static VolunteerSheet getVolunteer() {
        System.out.print("Give us your first name: ");
        String firstName = sc.nextLine();
        System.out.print("Give us your last name: ");
        String lastName = sc.nextLine();
        System.out.print("Give us your phone number: ");
        String phone = sc.nextLine();
        System.out.print("Give us your email: ");
        String email = sc.nextLine();
        ArrayList<String> team = getTeam();
        return new VolunteerSheet(firstName, lastName, phone, email, team);

    }

    public static ArrayList<String> getTeam() {
        String[] possibleTeams = { "Worship", "Welcome", "Production", "Community Groups", "Children Ministry",
                "Student Ministry", "Q", "More Info" };
        ArrayList<String> choices = new ArrayList<String>();
        while (true) {
            System.out.println("Which team would you like to be in");
            for (String team : possibleTeams) {
                System.out.println(team);
            }
            String choice = sc.nextLine();
            boolean result = Arrays.stream(possibleTeams).anyMatch(choice::equals);
            if (choice.equals("Q") && result) {
                return choices;
            }
            if (result) {
                System.out.println("If you want to stop adding teams press Q");
                choices.add(choice);
            } else {
                System.out.println("Sorry that team isn't available");
            }
        }
    }

    private static void saveVolunteers(ArrayList<VolunteerSheet> volunteers) {
        try {
            FileOutputStream fileStream = new FileOutputStream("volunteers.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(volunteers);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save volunteers.");
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
