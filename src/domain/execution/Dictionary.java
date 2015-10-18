package domain.execution;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by alex on 10/17/15.
 */
public class Dictionary implements IDictionary {

    private Entry[] entries;
    private int size;

    public Dictionary(int capacity) {
        entries = new Entry[capacity];
        size = 0;
    }

    @Override
    public int get(String key) throws InvalidKeyException {
        for (Entry e : entries) {
            if (Objects.equals(e.key, key))
                return e.value;
        }
        throw new InvalidKeyException("No entry for key: " + key);
    }

    @Override
    public void put(String key, int value) {
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(entries[i].key, key)) {
                entries[i] = new Entry(key, value);
                return;
            }
        }
        entries[size++] = new Entry(key, value);
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }

    private class Entry {
        public final String key;
        public final int value;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " => " + value + "}";
        }
    }


}
