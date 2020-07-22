package phonebook.searchers;

import phonebook.entities.Contact;
import phonebook.entities.User;

public class LinearSearcher extends Searcher {

    public LinearSearcher() {
        super();
    }

    @Override
    public void search() {
        timer.start();
        for (User user : users) {
            for (Contact contact : contacts) {
                if (contact.getName().equals(user.getName())) {
                    foundNumbers++;
                }
            }
        }
        timer.stop();
    }
}
