package concurrentCollections;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by kantipin on 02.06.2016.
 */
public class PollTask implements Runnable {
    ConcurrentLinkedDeque list;

    public PollTask(ConcurrentLinkedDeque list) {
        this.list = list;
    }
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollLast();
            list.pollFirst();
        }
    }
}
