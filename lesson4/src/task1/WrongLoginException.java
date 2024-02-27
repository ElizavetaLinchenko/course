package task1;

public class WrongLoginException extends Exception {
    WrongLoginException() {
        super();
    }

    WrongLoginException(String message) {
        super(message);
    }
}