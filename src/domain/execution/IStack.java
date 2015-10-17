package domain.execution;

import domain.statements.IStatement;

/**
 * Created by alex on 10/11/15.
 */
public interface IStack {

    boolean isEmpty();

    IStatement pop();

    void push(IStatement statement);
}
