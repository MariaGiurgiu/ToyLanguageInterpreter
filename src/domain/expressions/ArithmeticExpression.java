package domain.expressions;

import domain.execution.IDictionary;
import domain.execution.ToyExecutionException;

/**
 * Created by alex on 10/11/15.
 */
public class ArithmeticExpression extends Expression {

    private final Expression exp1;
    private final Expression exp2;
    private final String operator;

    public ArithmeticExpression(Expression exp1, Expression exp2, String operator) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operator = operator;
    }

    @Override
    public int eval(IDictionary symbols) throws ToyExecutionException {

        int result1 = exp1.eval(symbols);
        int result2 = exp2.eval(symbols);
        switch (operator) {
            case "+":
                return result1 + result2;
            case "-":
                return result1 - result2;
            case "*":
                return result1 * result2;
        }
        return 0;
    }

    @Override
    public String toString() {
        return exp1.toString() + " " + operator + " " + exp2.toString();
    }
}
