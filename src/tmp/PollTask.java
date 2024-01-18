package tmp;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by kantipin on 23.05.2016.
 */
public class PollTask implements Runnable {
    ConcurrentLinkedDeque<String> deck;

    public PollTask(ConcurrentLinkedDeque<String> deck) {
        this.deck = deck;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            deck.pollFirst();
            deck.pollLast();
        }
    }
}
