package domain.statements;

import domain.expressions.Expression;

/**
 * PrintStatement is statement composed of a expression needed to be printed.
 */
public class PrintStatement implements IStatement {

    private final Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "print(" + expression.toString() + ")";
    }

    public Expression getExpression() {
        return expression;
    }
}
