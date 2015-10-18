package domain.statements;

import domain.expressions.Expression;

/**
 * AssignStatement is a statement composed of a variable name (left hand side) and an expression (right hand side).
 */
public class AssignStatement implements IStatement {

    private final String name;
    private final Expression expression;

    public AssignStatement(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return name + " = " + expression.toString();
    }

    public Expression getExpression() {
        return expression;
    }

    public String getName() {
        return name;
    }
}
