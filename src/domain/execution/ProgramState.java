package domain.execution;

/**
 * Created by alex on 10/11/15.
 */
public class ProgramState {

    IStack executionStack;
    IDictionary symbols;
    IList output;

    public ProgramState(IStack executionStack, IDictionary symbols, IList output) {
        this.executionStack = executionStack;
        this.symbols = symbols;
        this.output = output;
    }
}
