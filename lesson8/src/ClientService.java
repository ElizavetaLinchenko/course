public class ClientService implements Runnable {
    private String message;
    private DatabaseService databaseService;

    public ClientService(String message, DatabaseService databaseService) {
        this.message = message;
        this.databaseService = databaseService;
    }

    @Override
    public void run() {

    }
}