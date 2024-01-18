package concurrentCollections;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by kantipin on 02.06.2016.
 */
public class Main_LinkedBlockingDeque {
    public static void main(String[] args) {
        LinkedBlockingDeque q = new LinkedBlockingDeque();
        Client client = new Client(q);
        Thread clientThread = new Thread(client);
        Server server = new Server(q);
        Thread serverThread = new Thread(server);

        clientThread.start();
        serverThread.start();

        try {
            clientThread.join();
            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: finished, LinkedBlockingDeque size: %d\n", q.size());
    }
}
