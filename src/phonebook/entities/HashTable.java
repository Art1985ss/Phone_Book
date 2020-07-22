package phonebook.entities;

public class HashTable<T> {

    private int size;
    private TableEntry[] table;

    public HashTable(int size) {
        this.size = size;
        table = new TableEntry[size];
    }

    public HashTable() {
        this(5);
    }



    private int findKey(String key) {
        int hashedKey = Math.abs(key.hashCode());
        int hash = hashedKey % size;
        while (!(table[hash] == null || table[hash].getKey().equals(key))) {
            hash = (hash + 1) % size;
            if (hash == hashedKey % size) {
                return -1;
            }
        }
        return hash;
    }

    public boolean put(String key, T value) {
        int index = findKey(key);
        while (index == -1) {
            rehash();
            index = findKey(key);
        }
        table[index] = new TableEntry(key, value);
        return true;
    }

    public T get(String key) {
        int index = findKey(key);
        if (index == -1) {
            return null;
        }
        return (T) table[index].getValue();
    }

    private void rehash() {
        size = table.length * 5;
        TableEntry[] temp = table.clone();
        table = new TableEntry[size];
        for (TableEntry entry : temp) {
            if (entry != null) {
                put(entry.getKey(), (T) entry.getValue());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (TableEntry entry : table) {
            if (entry != null) {
                text.append(entry.getKey())
                        .append(" ")
                        .append(entry.value)
                        .append("\n");
            }
        }
        text.append("Size : ").append(size);
        return text.toString();
    }

    public class TableEntry<T> {
        private final String key;
        private final T value;

        public TableEntry(String key, T value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }
}
