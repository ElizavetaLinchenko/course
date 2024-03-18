import java.util.concurrent.Exchanger;

public class ClientService implements Runnable {
    Exchanger<String> exchanger;
    String message;

    ClientService(Exchanger exchanger) {
        this.exchanger = exchanger;
        message = "Hello";
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