package domain.execution;

import domain.statements.IStatement;

/**
 * Represents the state of a Toy Language program.
 * It holds an execution stack, a dictionary of symbols (variables), and a list that accumulates the output.
 */
public class ProgramState {

    private IStack executionStack;
    private IDictionary symbols;
    private IList output;

    /**
     * Creates a ProgramState for a new program.
     *
     * @param originalProgram IStatement that holds the entire program. It will be pushed in the execution stack.
     */
    public ProgramState(IStatement originalProgram) {
        this.executionStack = new Stack(100);
        this.symbols = new Dictionary(100);
        this.output = new List(100);
        executionStack.push(originalProgram);
    }


    /**
     * @return reference to the execution stack.
     */
    public IStack getExecutionStack() {
        return executionStack;
    }

    /**
     * @return referecnce to the dictionary of symbols (variables).
     */
    public IDictionary getSymbols() {
        return symbols;
    }

    /**
     * @return reference to the list that accumulates the output of the program.
     */
    public IList getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return "ProgramState{\n" +
                "executionStack=" + executionStack +
                ",\nsymbols=" + symbols +
                ",\noutput=" + output +
                "\n}\n";
    }
}
