package domain.expressions;

import domain.execution.IDictionary;

/**
 * Created by alex on 10/11/15.
 */
public class ConstantExpression extends Expression {

    private final int number;

    public ConstantExpression(int number) {
        this.number = number;
    }

    @Override
    public int eval(IDictionary symbols) {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
