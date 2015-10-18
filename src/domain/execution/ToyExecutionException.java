package domain.execution;

/**
 * Signals that an exception occurs during the execution of a toy language program.
 */
public class ToyExecutionException extends Exception {
    public ToyExecutionException(String message) {
        super(message);
    }
}
