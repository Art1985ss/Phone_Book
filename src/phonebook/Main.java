package phonebook;

import phonebook.searchers.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start searching (linear search)...");
        Searcher searcher = new LinearSearcher();
        searcher.search();
        System.out.println(searcher);
        System.out.println();
        System.out.println("Start searching (bubble sort + jump search)...");
        JumpSearch jumpSearch = new JumpSearch();
        jumpSearch.setMaxSortTime(searcher.getDuration() * 10);
        jumpSearch.search();
        System.out.println(jumpSearch);
        System.out.println();
        System.out.println("Start searching (quick sort + binary search)...");
        searcher = new BinarySearch();
        searcher.search();
        System.out.println(searcher);
        System.out.println();
        searcher = new HashSearch();
        searcher.search();
        System.out.println(searcher);
    }


}
