package tmp;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by kantipin on 23.05.2016.
 */
public class AddTask implements Runnable {
    ConcurrentLinkedDeque<String> deck;


    public AddTask(ConcurrentLinkedDeque<String> deck) {
        this.deck = deck;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            String name = Thread.currentThread().getName();
            deck.addFirst(name + "element" + i);
        }
    }
}
