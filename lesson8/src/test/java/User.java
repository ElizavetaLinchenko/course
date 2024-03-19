public class User extends Thread {
    int userID;

    public User(int userID) {
        this.userID = userID;
    }

    @Override
    public void run() {
        System.out.println(
                String.format("current thread name %s have clientId %s",
                        new StringBuilder(Thread.currentThread().getName()).reverse(),
                        userID
                )
        );
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}