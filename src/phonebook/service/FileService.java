package phonebook.service;

import phonebook.entities.Contact;
import phonebook.entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {
    private static final String FIRST_PATH_PART = "E:\\Google Chrome Downloads\\data\\";

    public static String readFile(String filepath) {
        String text = null;
        try {
            text = Files.readString(Paths.get(FIRST_PATH_PART + filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static List<Contact> getContacts(String filePath) {
        List<Contact> contacts = new ArrayList<>();
        try (Scanner scanner = new Scanner(
                new File(FIRST_PATH_PART + filePath))) {
            while (scanner.hasNext()) {
                Contact contact = new Contact();
                String[] params = scanner.nextLine().split("\\s");
                contact.setNumber(params[0]);
                if (params.length == 3) {
                    contact.setName(params[1] + " " + params[2]);
                } else {
                    contact.setName(params[1]);
                }
                contacts.add(contact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (Scanner scanner = new Scanner(
                new File(FIRST_PATH_PART + "find.txt"))) {
            while (scanner.hasNext()) {
                User user = new User();
                String[] params = scanner.nextLine().split("\\s");
                if (params.length == 2) {
                    user.setName(params[0] + " " + params[1]);
                } else {
                    user.setName(params[0]);
                }
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void writeToFile(String filePath, List<Contact> contacts) {
        try (FileWriter writer = new FileWriter(new File(FIRST_PATH_PART + filePath), false)) {
            for (Contact contact : contacts) {
                writer.write(contact.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
