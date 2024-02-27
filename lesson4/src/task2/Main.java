package task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
        Создайте обобщенный класс Database, который будет иметь обобщённый конструктор класса и сможет принимать массив классов Moderator и Administrator.
        В классе Database должен быть метод, который выводит все логина в консоль через запятую в строчку.
         */
    public static void main(String[] args) {
        List<Moderator> moderators = new ArrayList<>();
        moderators.add(new Moderator("Daria_moderator"));
        moderators.add(new Moderator("Andrey_moderator"));

        List<Administrator> administrators = new ArrayList<>();
        administrators.add(new Administrator("Sergey_Admin"));
        administrators.add(new Administrator("Lena_Admin"));

        Database<Moderator> moderatorDatabase = new Database<>(moderators);
        Database<Administrator> administratorDatabase = new Database<>(administrators);

        moderatorDatabase.logins();
        administratorDatabase.logins();
    }
}