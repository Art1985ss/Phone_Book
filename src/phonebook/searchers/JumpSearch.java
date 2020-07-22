package phonebook.searchers;

import phonebook.entities.Contact;
import phonebook.entities.User;
import phonebook.service.SorterService;
import phonebook.service.Timer;

public class JumpSearch extends Searcher {
    private long maxSortTime = Long.MAX_VALUE;
    private Timer jumpSearchTime = new Timer();

    @Override
    public void search() {
        Contact[] sortedContacts = SorterService.bubbleSortContacts(contacts, maxSortTime);
        if (sortedContacts == null) {
            LinearSearcher linearSearcher = new LinearSearcher();
            linearSearcher.search();
            foundNumbers = linearSearcher.foundNumbers;
            jumpSearchTime.setDuration(linearSearcher.timer.getDuration());
        } else {
            contacts = sortedContacts;
            for (User user : users) {
                final int i = searchIn(user);
                foundNumbers += i != -1 ? 1 : 0;
            }
        }
        timer.setDuration(jumpSearchTime.getDuration() + SorterService.getTimer().getDuration());
    }


    private int searchIn(User user) {
        jumpSearchTime = new Timer();
        jumpSearchTime.start();
        int currentRight = 0;
        int previousRight = 0;
        int step = (int) Math.sqrt(peopleCount);
        if (contacts[0].getName().equals(user.getName())) {
            return 0;
        }
        int index = -1;
        if (contacts[contacts.length - 1].getName().compareTo(user.getName()) < 0) {
            return index;
        }

        for (int i = 0; i < contacts.length; i += step) {
            currentRight = i;
            if (contacts[currentRight].getName().compareTo(user.getName()) >= 0) {
                if (contacts[currentRight].getName().equals(user.getName())) {
                    return currentRight;
                }
                break;
            }
            previousRight = currentRight;
        }

        for (int i = currentRight; i > previousRight; i--) {
            if (contacts[i].getName().equals(user.getName())) {
                return i;
            }
        }
        jumpSearchTime.stop();
        return index;
    }

    public void setMaxSortTime(long maxSortTime) {
        this.maxSortTime = maxSortTime;
    }

    @Override
    public String toString() {
        String searchTime = "Searching time : " + jumpSearchTime;
        return super.toString() + '\n' +
                SorterService.getMessage() + '\n' +
                searchTime;
    }
}
