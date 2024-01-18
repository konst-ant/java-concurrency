package threadSynchronization;

import util.Utils;

import java.util.Date;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Consumer implements Runnable {
    EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            Date date = storage.get();
            System.out.printf("Consumer: retrieved date event %s, storage size %d\n", date, storage.size());
            Utils.randomSleep();
        }
    }
}
