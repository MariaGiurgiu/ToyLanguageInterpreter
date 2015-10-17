package domain.statements;

/**
 * Created by alex on 10/11/15.
 * Holds two references to other statements, making them part of a whole.
 * Acts as a parent node in a tree of statements.
 */
public class CompoundStatement implements IStatement {

    private final IStatement first;
    private final IStatement second;

    public CompoundStatement(IStatement first, IStatement second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toStr() {
        return "(" + first.toStr() + "; " + second.toStr() + ")";
    }

    public IStatement getFirst() {
        return first;
    }

    public IStatement getSecond() {
        return second;
    }
}
