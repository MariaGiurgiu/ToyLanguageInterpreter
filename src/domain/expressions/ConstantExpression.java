package domain.expressions;

import domain.execution.IDictionary;

/**
 * Created by alex on 10/11/15.
 */
public class ConstantExpression extends Expression {

    int number;

    public ConstantExpression(int number) {
        this.number = number;
    }

    @Override
    public int eval(IDictionary symbols) {
        return number;
    }

    @Override
    public String toStr() {
        return Integer.toString(number);
    }
}
