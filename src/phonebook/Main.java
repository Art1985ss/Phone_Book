package phonebook;

import phonebook.entities.Contact;
import phonebook.searchers.JumpSearch;
import phonebook.searchers.Searcher;
import phonebook.service.FileService;
import phonebook.service.SorterService;
import phonebook.service.Timer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();
        Searcher searcher = new JumpSearch();
        searcher.search();
        System.out.println(searcher);
//        List<Contact> contacts = FileService.getContacts("directory.txt");
//        contacts = SorterService.bubbleSortContacts(contacts);
//        FileService.writeToFile("sortedContacts.txt", contacts);
        timer.stop();
        System.out.println(timer);
    }

}
