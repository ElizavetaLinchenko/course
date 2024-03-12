import java.util.concurrent.Exchanger;

public class DatabaseService implements Runnable {
    Exchanger<String> exchanger;
    String message;

    DatabaseService(Exchanger exchanger) {
        this.exchanger = exchanger;
        message = "World";
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.println(message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}