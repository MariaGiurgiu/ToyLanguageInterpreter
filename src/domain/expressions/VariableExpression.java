package domain.expressions;

import domain.execution.IDictionary;

/**
 * Created by alex on 10/11/15.
 */
public class VariableExpression extends Expression {

    String id;

    @Override
    public int eval(IDictionary symbols) {
        return symbols.get(id);
    }

    @Override
    public String toStr() {
        return id;
    }
}
