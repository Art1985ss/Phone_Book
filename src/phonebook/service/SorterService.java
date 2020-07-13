package phonebook.service;

import phonebook.entities.Contact;

import java.util.Arrays;
import java.util.List;

public class SorterService {
    //TODO correct method to work faster
    public static List<Contact> bubbleSortContacts(List<Contact> contacts) {
        Timer timer = new Timer();
        timer.start();
        Contact[] contacts1 = new Contact[contacts.size()];
        contacts.toArray(contacts1);
        int size = contacts1.length;
        for (int i = 0; i < size - 1; i++) {
            if (i % 10000 == 0){
                timer.getDuration();
                System.out.println(timer.toString());
                System.out.println("i = " + i + "/" + size);
            }
            for (int j = 0; j < size - i - 1; j++) {
                if (contacts1[j].compareTo(contacts1[j + 1]) > 0) {
                    Contact contact = contacts1[j];
                    contacts1[j] = contacts1[j + 1];
                    contacts1[j + 1] = contact;
                }
            }
        }
        return Arrays.asList(contacts1);
        //Arrays.sort(contacts1);
        //return Arrays.asList(contacts1);
    }
}
