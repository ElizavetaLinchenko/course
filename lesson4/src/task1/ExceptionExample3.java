package task1;

import java.util.Scanner;

public class ExceptionExample3 {
    public static UserCredentialsStatus validation(String login, String password, String confirmPassword) {
        try {
            if (login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                System.out.println("Ошибка: Необходимо ввести верные значения для логина, пароля и подтверждение пароля");
                return UserCredentialsStatus.ENTERED_BY_USER;
            }

            if (login.length() >= 20) {
                throw new WrongLoginException("Длина логина должна быть меньше 20 знаков");
            }

            if (password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Длина пароля должна быть меньше 20 знаков, пароли должны совпадать");
            }

            return UserCredentialsStatus.CORRECT;
        } catch (WrongLoginException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return UserCredentialsStatus.INCORRECT;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return UserCredentialsStatus.INCORRECT;
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