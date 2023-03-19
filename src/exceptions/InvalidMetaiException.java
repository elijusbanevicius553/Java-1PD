package exceptions;

public class InvalidMetaiException extends RuntimeException {
    public InvalidMetaiException(String message) {
        super(message);
    }
}