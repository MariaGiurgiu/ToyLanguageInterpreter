package domain.execution;

import domain.statements.IStatement;

import java.util.Arrays;

/**
 * Created by alex on 10/17/15.
 */
public class Stack implements IStack {

    private IStatement[] array;
    private int size;

    public Stack(int capacity) {
        array = new IStatement[capacity];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public IStatement pop() {
        --size;
        IStatement top = array[size];
        array[size] = null;
        return top;
    }

    @Override
    public void push(IStatement statement) {
        array[size++] = statement;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
