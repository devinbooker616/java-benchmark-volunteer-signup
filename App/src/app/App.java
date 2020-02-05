package app;

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<VolunteerSheet> volunteers = loadVolunteers();
        System.out.println("Hello Java");
    }

    private static void saveVolunteers(ArrayList<VolunteerSheet> volunteers) {
        try {
            FileOutputStream fileStream = new FileOutputStream("orders.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(volunteers);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save volunteers.");
        }
    }

    public static ArrayList<VolunteerSheet> loadVolunteers() {
        try {
            FileInputStream fileStream = new FileInputStream("orders.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<VolunteerSheet> volunteers = (ArrayList<VolunteerSheet>) os.readObject();
            os.close();
            return volunteers;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<VolunteerSheet>();
        }
    }
}
