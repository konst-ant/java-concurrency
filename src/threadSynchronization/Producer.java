package threadSynchronization;

import util.Utils;

import java.util.Date;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Producer implements Runnable{
    EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Date date = new Date();
            storage.set(date);
            System.out.printf("Producer: produced new event %s, storage size %d\n", date, storage.size());
            Utils.randomSleep();
        }

    }
}
