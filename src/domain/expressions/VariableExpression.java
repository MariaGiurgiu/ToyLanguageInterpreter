package domain.expressions;

import domain.execution.IDictionary;
import domain.execution.InvalidKeyException;
import domain.execution.ToyExecutionException;

/**
 * Created by alex on 10/11/15.
 */
public class VariableExpression extends Expression {

    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public int eval(IDictionary symbols) throws ToyExecutionException {
        try {
            return symbols.get(name);
        } catch (InvalidKeyException e) {
            String variable = e.getMessage().split("\\w$")[0];
            throw new ToyExecutionException("Undefined variable" + variable);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
