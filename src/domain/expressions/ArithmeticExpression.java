package domain.expressions;

import domain.execution.IDictionary;

/**
 * Created by alex on 10/11/15.
 */
public class ArithmeticExpression extends Expression {

    private Expression exp1;
    private Expression exp2;
    private char operator;

    public ArithmeticExpression(Expression exp1, Expression exp2, char operator) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operator = operator;
    }

    @Override
    public int eval(IDictionary symbols) {
        int result1 = exp1.eval(symbols);
        int result2 = exp2.eval(symbols);
        switch (operator) {
            case '+':
                return result1 + result2;
            case '-':
                return result1 - result2;
            case '*':
                return result1 * result2;
        }
        return 0;
    }

    @Override
    public String toStr() {
        return exp1.toStr() + " " + operator + " " + exp2.toStr();
    }
}
