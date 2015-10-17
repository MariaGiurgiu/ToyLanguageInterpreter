package domain.execution;

/**
 * Created by alex on 10/11/15.
 */
public class ProgramState {

    private IStack executionStack;
    private IDictionary symbols;
    private IList output;

    public ProgramState(IStack executionStack, IDictionary symbols, IList output) {
        this.executionStack = executionStack;
        this.symbols = symbols;
        this.output = output;
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
