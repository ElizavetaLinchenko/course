public class DatabaseService implements Runnable {
    private String message;
    private ClientService clientService;

    public DatabaseService(String message) {
        this.message = message;
    }

    @Override
    public void run() {
    }
}