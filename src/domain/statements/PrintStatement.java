package domain.statements;

import domain.expressions.Expression;

/**
 * Created by alex on 10/11/15.
 */
public class PrintStatement implements IStatement {

    private final Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toStr() {
        return "print(" + expression.toStr() + ")";
    }

    public Expression getExpression() {
        return expression;
    }
}
