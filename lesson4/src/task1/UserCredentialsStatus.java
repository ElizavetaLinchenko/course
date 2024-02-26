package task1;

public enum UserCredentialsStatus {
    CORRECT("Correct Password/Login"),
    INCORRECT("Incorrect password/login"),
    ENTERED_BY_USER("Password/login is entered by User");

    private final String description;

    UserCredentialsStatus(String description) {
        this.description = description;
    }
}