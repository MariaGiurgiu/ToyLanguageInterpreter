package domain.execution;

import domain.statements.IStatement;

/**
 * Created by alex on 10/11/15.
 */
public class ProgramState {

    private IStack executionStack;
    private IDictionary symbols;
    private IList output;

    public ProgramState(IStatement originalProgram) {
        this.executionStack = new Stack(100);
        this.symbols = new Dictionary(100);
        this.output = new List(100);
        executionStack.push(originalProgram);
    }


    public IStack getExecutionStack() {
        return executionStack;
    }

    public IDictionary getSymbols() {
        return symbols;
    }

    public IList getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return "ProgramState{\n" +
                "executionStack=" + executionStack +
                ",\nsymbols=" + symbols +
                ",\noutput=" + output +
                '}';
    }
}
