package domain.execution;

import java.util.Arrays;

/**
 * List that accumulates strings.
 */
public class List implements IList {

    private String[] array;
    private int size;

    /**
     * Creates a list of a capacity given as argument.
     *
     * @param capacity number of strings the list can hold.
     */
    public List(int capacity) {
        array = new String[capacity];
        size = 0;
    }

    @Override
    public void add(String s) {
        array[size++] = s;
    }

    @Override
    public String toString() {
        return Arrays.toString(array).replaceAll(", null", "");
    }
}
