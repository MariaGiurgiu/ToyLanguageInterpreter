package domain.expressions;

import domain.execution.IDictionary;
import domain.execution.ToyExecutionException;

/**
 * Created by alex on 10/11/15.
 */
public abstract class Expression {

    public abstract int eval(IDictionary symbols) throws ToyExecutionException;

    @Override
    public abstract String toString();
}
