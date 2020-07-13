package phonebook;

import phonebook.searchers.LinearSearcher;
import phonebook.searchers.Searcher;

public class Main {
    public static void main(String[] args) {
        Searcher searcher = new LinearSearcher();
        System.out.println("Start searching...");
        searcher.search();
        System.out.println(searcher);
    }

}
