package task1;

public class WrongPasswordException extends Exception {
    WrongPasswordException(String message) {
        super(message);
    }
}