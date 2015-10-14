package domain.expressions;

import domain.execution.IDictionary;

/**
 * Created by alex on 10/11/15.
 */
public abstract class Expression {

    public abstract int eval(IDictionary symbols);
    public abstract String toStr();
}
