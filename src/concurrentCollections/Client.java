package concurrentCollections;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by kantipin on 02.06.2016.
 */
public class Client implements Runnable {

    LinkedBlockingDeque<String> que;

    public Client(LinkedBlockingDeque<String> que) {
        this.que = que;
    }

    public void run()  {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                String message = i + ":" +j;
                try {
                    que.put(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Client: have put message %s on %s\n", message, new Date());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
