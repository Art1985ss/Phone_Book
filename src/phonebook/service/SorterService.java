package phonebook.service;

import phonebook.entities.Contact;

import java.util.Arrays;


public class SorterService {
    private static String message = "";
    private static Timer timer;

    public static Contact[] bubbleSortContacts(Contact[] contacts, long maxDuration) {
        timer = new Timer();
        timer.start();
        Contact[] contacts1 = contacts.clone();
        int size = contacts1.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (maxDuration < timer.getDuration()) {
                    timer.stop();
                    message = "Sorting time: " + timer + " - STOPPED, moved to linear search";
                    return null;
                }
                if (contacts1[j].compareTo(contacts1[j + 1]) > 0) {
                    Contact contact = contacts1[j];
                    contacts1[j] = contacts1[j + 1];
                    contacts1[j + 1] = contact;
                }
            }
        }
        timer.stop();
        message = "Sorting time: " + timer;
        return contacts1;
    }

    public static Timer getTimer() {
        return timer;
    }

    public static String quickSort(Contact[] contacts) {
        timer = new Timer();
        timer.start();
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quickSort(contacts, 0, contacts.length - 1);
        timer.stop();
        return "Sorting time: " + timer;
    }

    private static void quickSort(Contact[] contacts, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(contacts, left, right);
            quickSort(contacts, left, pivotIndex - 1);
            quickSort(contacts, pivotIndex + 1, right);
        }
    }

    private static int partition(Contact[] arr, int left, int right) {
        Contact pivot = arr[right];
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i].compareTo(pivot) < 0) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, right);
        return partitionIndex;
    }

    private static void swap(Contact[] array, int i, int j) {
        Contact temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static String getMessage() {
        return message;
    }
}
