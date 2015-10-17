package domain.statements;

import domain.expressions.Expression;

/**
 * Created by alex on 10/11/15.
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
