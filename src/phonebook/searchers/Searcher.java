package phonebook.searchers;

import phonebook.FileService;
import phonebook.entities.Contact;
import phonebook.entities.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Searcher {
    private long startMillis;
    private long durationMillis;
    protected List<User> users;
    protected List<Contact> contacts;

    protected Searcher() {
        users = FileService.getUsers();
        contacts = FileService.getContacts();
    }

    public abstract void search();

    protected void initiateBeginTime() {
        startMillis = System.currentTimeMillis();
    }

    protected void updateDuration() {
        durationMillis = System.currentTimeMillis() - startMillis;
    }

    private String getFormattedDuration() {
        long millis = durationMillis;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        millis -= TimeUnit.SECONDS.toMillis(seconds);
        return String.format("%d min. %d sec. %d ms.", minutes, seconds, millis);
    }


    @Override
    public String toString() {
        return String.format("Time taken : %s", getFormattedDuration());
    }
}
