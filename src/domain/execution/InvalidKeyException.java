package domain.execution;

/**
 * Signals that a key is not present in a collection of (key, value) pairs.
 */
public class InvalidKeyException extends Throwable {
    public InvalidKeyException(String message) {
        super(message);
    }
}
