package phonebook.searchers;

import phonebook.service.FileService;
import phonebook.entities.Contact;
import phonebook.entities.User;
import phonebook.service.Timer;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Searcher {
    protected User[] users;
    protected Contact[] contacts;
    protected int peopleCount;
    protected int foundNumbers = 0;

    protected Timer timer;

    protected Searcher() {
        timer = new Timer();
        List<User> userList = FileService.getUsers();
        users = new User[userList.size()];
        userList.toArray(users);
        List<Contact> contactList = FileService.getContacts("sortedContacts.txt");
        contacts = new Contact[contactList.size()];
        contactList.toArray(contacts);
        peopleCount = users.length;
    }

    public abstract void search();


    @Override
    public String toString() {
        return String.format("Found %d / %d entities. %s",
                foundNumbers, peopleCount, timer);
    }
}
