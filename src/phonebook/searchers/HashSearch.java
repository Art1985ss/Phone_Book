package phonebook.searchers;

import phonebook.entities.Contact;
import phonebook.entities.HashTable;
import phonebook.entities.User;
import phonebook.service.Timer;

public class HashSearch extends Searcher {
    private String text = "Start searching (hash table)...";
    private Timer creatingTimer;
    private Timer searchingTimer;

    @Override
    public void search() {
        HashTable<Contact> table = new HashTable<>(contacts.length);
        creatingTimer = new Timer();
        creatingTimer.start();
        for (Contact contact : contacts) {
            table.put(contact.getName(), contact);
        }
        creatingTimer.stop();
        searchingTimer = new Timer();
        searchingTimer.start();
        for (User user : users) {
            Contact contact = table.get(user.getName());
            if (contact != null) {
                foundNumbers++;
            }
        }
        searchingTimer.stop();
        timer.setDuration(creatingTimer.getDuration() + searchingTimer.getDuration());
    }

    @Override
    public String toString() {
        return text + "\n" +
                super.toString() + "\n" +
                "Creating time: " + creatingTimer + "\n" +
                "Searching time: " + searchingTimer;
    }
}
