package domain.expressions;

import domain.execution.IDictionary;
import domain.execution.ToyExecutionException;

/**
 * ArithmeticExpression is an Expression composed by a binary operator and two expression for it.
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
