package domain.execution;

import domain.statements.IStatement;

/**
 * Interface for a stack of IStatement.
 */
public interface IStack {

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty and false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns and removes the element from the top of the stack.
     *
     * @return the element at the top of the stack
     */
    IStatement pop();

    /**
     * Adds a statement at the top of the stack.
     * @param statement which will be added.
     */
    void push(IStatement statement);
}
