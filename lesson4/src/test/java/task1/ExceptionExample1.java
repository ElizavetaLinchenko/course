package task1;

import java.util.Scanner;

public class ExceptionExample1 {
    public static boolean validation(String login, String password, String confirmPassword) {
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException(UserCredentialsStatus.ENTERED_BY_USER + " Необходимо ввести верные значения " +
                        "для логина, пароля и подтверждение пароля");
            }

            if (password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException(UserCredentialsStatus.INCORRECT + " Длина логина должна быть меньше 20 " +
                        "знаков");
            }

            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            if (e instanceof WrongLoginException) {
                return false;
            } else {
                return true;
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

        boolean isValid = validation(login, password, confirmPassword);
        System.out.println("Статус: " + isValid);
    }
}