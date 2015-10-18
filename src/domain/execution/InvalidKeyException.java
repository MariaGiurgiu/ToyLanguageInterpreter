package domain.execution;

/**
 * Created by alex on 10/17/15.
 */
public class InvalidKeyException extends Throwable {
    public InvalidKeyException(String message) {
        super(message);
    }
}
