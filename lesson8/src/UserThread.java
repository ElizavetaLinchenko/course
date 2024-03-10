public class UserThread implements Runnable {
    Client client;

    UserThread(Client client) {
        this.client = client;
    }

    public void run() {
        client.clientId = 0;
        for (int i = 0; i < 5; i++) {
            synchronized (client) {
                System.out.println(String.format("current thread name %s have clientId %s", Thread.currentThread().
                        getName(), client.clientId));
                client.clientId++;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}