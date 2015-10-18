package domain.expressions;

import domain.execution.IDictionary;
import domain.execution.ToyExecutionException;

/**
 * Expression is a class that can be evaluated to an int.
 */
public abstract class Expression {

    /**
     * Method that evaluates it's object to an int.
     *
     * @param symbols reference to a dictionary of symbols (variables).
     * @return integer resulted from the evaluation of the expression.
     * @throws ToyExecutionException when the expression can't be evaluated.
     */
    public abstract int eval(IDictionary symbols) throws ToyExecutionException;

    @Override
    public abstract String toString();
}
