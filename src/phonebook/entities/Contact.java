package phonebook.entities;

import org.jetbrains.annotations.NotNull;

public class Contact implements Comparable<Contact> {
    private String number;
    private String name;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return number + " " + name;
    }

    @Override
    public int compareTo(@NotNull Contact contact) {
        return name.compareTo(contact.getName());
    }
}
