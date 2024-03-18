package task2;

import java.util.List;

public class Database<T> {
    private List<T> users;

    Database(List<T> users) {
        this.users = users;
    }

    public void logins() {
        for (T user : users) {
            if (user instanceof Moderator) {
                Moderator moderator = (Moderator) user;
                System.out.print(moderator.getLogin() + ", ");
            } else if (user instanceof Administrator) {
                Administrator administrator = (Administrator) user;
                System.out.print(administrator.getLogin() + ", ");
            }
        }
    }
}