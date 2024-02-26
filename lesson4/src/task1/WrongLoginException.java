package task1;

public class WrongLoginException extends Exception {
    WrongLoginException(String message) {
        super(message);
    }
}