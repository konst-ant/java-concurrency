package concurrentCollections;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 02.06.2016.
 */
public class Server implements Runnable {

    LinkedBlockingDeque<String> que;

    public Server(LinkedBlockingDeque<String> que) {
        this.que = que;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                String message=null;
                try {
                    message = que.takeFirst();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Server: received message %s on %s\n", message, new Date());
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
