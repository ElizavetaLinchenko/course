package task1;

import java.util.Scanner;

public class ExceptionExample1 {
    public static UserCredentialsStatus validation(String login, String password, String confirmPassword) {
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException("Длина логина должна быть меньше 20 знаков");
            }

            if (password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Длина пароля должна быть меньше 20 знаков, пароли должны совпадать");
            }

            return UserCredentialsStatus.CORRECT;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            if (e instanceof WrongLoginException) {
                return UserCredentialsStatus.INCORRECT;
            } else {
                return UserCredentialsStatus.ENTERED_BY_USER;
            }
        } finally {
            System.out.println("Проверка данных завершена");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        System.out.print("Подтвердите пароль: ");
        String confirmPassword = scanner.nextLine();

        UserCredentialsStatus status = validation(login, password, confirmPassword);
        boolean isValid = status == UserCredentialsStatus.CORRECT;
        System.out.println("Статус: " + isValid);
    }
}