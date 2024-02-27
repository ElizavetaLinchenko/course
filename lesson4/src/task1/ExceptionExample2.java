package task1;

import java.util.Scanner;

public class ExceptionExample2 {
    public static boolean validation(String login, String password, String confirmPassword) {
        try {
            if (login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                System.out.println(UserCredentialsStatus.ENTERED_BY_USER);
                return false;
            }

            if (login.length() >= 20) {
                throw new WrongLoginException(UserCredentialsStatus.INCORRECT + " Длина логина должна быть меньше 20 знаков");
            }

            if (password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException(UserCredentialsStatus.INCORRECT + " Длина пароля должна быть меньше 20 " +
                        "знаков, пароли должны совпадать");
            }

            return true;
        } catch (WrongLoginException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false;
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