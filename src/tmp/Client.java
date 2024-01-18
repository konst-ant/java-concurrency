package tmp;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 23.05.2016.
 */
public class Client implements Runnable {
    LinkedBlockingDeque<String> deck;

    public Client(LinkedBlockingDeque<String> deck) {
        this.deck = deck;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuilder s= new StringBuilder();
                s.append(i);
                s.append(":");
                s.append(j);
                try {
                    deck.put(s.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Client: put successful %s at %s\n", s, new Date());
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Client: finished.\n");
    }
}
