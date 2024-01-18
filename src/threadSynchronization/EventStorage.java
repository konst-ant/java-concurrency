package threadSynchronization;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by kantipin on 11.04.2016.
 */
public class EventStorage {
    private static int maxSize =3;

    private LinkedList<Date> storage;

    public EventStorage() {
        storage = new LinkedList<>();
    }

    public synchronized void set(Date date) {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.offer(date);
        notifyAll();
    }

    public synchronized Date get() {
        Date result;
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = storage.poll();
        notifyAll();
        return result;
    }

    public int size() {
        return storage.size();
    }
}
