package phonebook.searchers;

import phonebook.entities.User;
import phonebook.service.SorterService;
import phonebook.service.Timer;

public class BinarySearch extends Searcher {
    private Timer binarySearchTimer;
    private String text = "";

    @Override
    public void search() {
        text = SorterService.quickSort(contacts);
        binarySearchTimer = new Timer();
        binarySearchTimer.start();
        for (User user : users) {
            if (search(user)) {
                foundNumbers++;
            }
        }
        binarySearchTimer.stop();
        timer.setDuration(binarySearchTimer.getDuration() + SorterService.getTimer().getDuration());
    }

    private boolean search(User user) {
        int left = 0;
        int right = contacts.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (contacts[mid].getName().equals(user.getName())) {
                return true;
            }
            if (contacts[mid].getName().compareTo(user.getName()) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                text + "\n" +
                "Search time: " + binarySearchTimer;
    }
}
