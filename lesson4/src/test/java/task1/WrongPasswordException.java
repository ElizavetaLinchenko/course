package task1;

public class WrongPasswordException extends Exception {
    WrongPasswordException() {
        super();
    }

    WrongPasswordException(String message) {
        super(message);
    }
}