package phonebook.searchers;

import phonebook.entities.Contact;
import phonebook.entities.User;

public class LinearSearcher extends Searcher {
    private int peopleCount;
    private int foundNumbers = 0;

    public LinearSearcher() {
        super();
    }

    @Override
    public void search() {
        initiateBeginTime();
        peopleCount = users.size();
        for (User user : users) {
            for (Contact contact : contacts) {
                if (contact.getName().equals(user.getName())) {
                    foundNumbers++;
                }
            }
        }
        updateDuration();
    }

    @Override
    public String toString() {
        return String.format("Found %d / %d entities. %s",
                foundNumbers,
                peopleCount,
                super.toString());
    }
}
