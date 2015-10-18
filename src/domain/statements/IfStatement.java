package domain.statements;

import domain.expressions.Expression;

/**
 * IfStatement is a statement composed of a expression that represents the condition and two statements.
 * One for each branch.
 */
public class IfStatement implements IStatement {

    private final Expression expression;
    private final IStatement thenStatement;
    private final IStatement elseStatement;

    public IfStatement(Expression expression, IStatement thenStatement, IStatement elseStatement) {
        this.expression = expression;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public String toString() {
        return "if " + expression.toString() +
                " then " + thenStatement.toString() +
                " else " + elseStatement.toString();
    }

    public Expression getExpression() {
        return expression;
    }

    public IStatement getThenStatement() {
        return thenStatement;
    }

    public IStatement getElseStatement() {
        return elseStatement;
    }
}
