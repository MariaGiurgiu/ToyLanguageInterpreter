package domain.execution;

import java.util.Arrays;

/**
 * Created by alex on 10/17/15.
 */
public class List implements IList {

    private String[] array;
    private int size;

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
        return Arrays.toString(array);
    }
}
