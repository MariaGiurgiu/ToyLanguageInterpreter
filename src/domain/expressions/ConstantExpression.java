package domain.expressions;

import domain.execution.IDictionary;

/**
 * Expression that is composed of a single integer.
 */
public class ConstantExpression extends Expression {

    private final int number;

    /**
     * Creates a ConstantExpression that holds an integer.
     *
     * @param number which will be held.
     */
    public ConstantExpression(int number) {
        this.number = number;
    }

    /**
     * {@inheritDoc}
     *
     * @return the integer it holds.
     */
    @Override
    public int eval(IDictionary symbols) {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
