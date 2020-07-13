package phonebook.searchers;

import phonebook.entities.User;

public class JumpSearch extends Searcher {
    @Override
    public void search() {
        System.out.println("Start searching (bubble sort + jump search)...");
        timer.start();
        for (User user : users) {
            final int i = searchIn(user);
            foundNumbers += i != -1 ? 1 : 0;
            //System.out.println(user);
            //System.out.println("foundNumbers = " + foundNumbers);
            //System.out.println("i = " + i);
        }
        timer.stop();
    }


    private int searchIn(User user) {
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
            //System.out.println("contacts[currentRight].getName() = " + contacts[currentRight].getName());
            //System.out.println("user.getName() = " + user.getName());
            //System.out.println(contacts[currentRight].getName().compareTo(user.getName()));
            if (contacts[currentRight].getName().compareTo(user.getName()) >= 0) {
                //System.out.println("Found block");
                if (contacts[currentRight].getName().equals(user.getName())) {
                    return currentRight;
                }
                break;
            }
            previousRight = currentRight;
        }
        //System.out.println("currentRight = " + currentRight);
        //System.out.println("previousRight = " + previousRight);

        for (int i = currentRight; i > previousRight; i--) {
            if (contacts[i].getName().equals(user.getName())) {
                return i;
            }
        }
        return index;
    }
}
