package domain.expressions;

import domain.execution.IDictionary;
import domain.execution.InvalidKeyException;
import domain.execution.ToyExecutionException;

/**
 * VariableExpression is an Expression that is composed of a single variable name.
 */
public class VariableExpression extends Expression {

    private final String name;

    /**
     * Creates a VariableExpression for the variable name given as argument.
     *
     * @param name of the variable which will be represented.
     */
    public VariableExpression(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     *
     * @throws ToyExecutionException when the name represented does not have an associated value.
     */
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
