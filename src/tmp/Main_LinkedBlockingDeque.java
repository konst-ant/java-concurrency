package tmp;

import concurrentCollections.Client;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 23.05.2016.
 */
public class Main_LinkedBlockingDeque {
    public static void main(String[] args) throws Exception {
        LinkedBlockingDeque<String> deck = new LinkedBlockingDeque(2);
        concurrentCollections.Client task = new Client(deck);
        Thread taskThread = new Thread(task);
        taskThread.start();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                String r= "";
                try {
                    r = deck.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.printf("Main: received %s at %s. Deck size %d\n", r, new Date(), deck.size());
            }
        }
        System.out.printf("Main: finished.\n");
    }
}
