package tmp;

import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * Created by kantipin on 25.05.2016.
 */
public class Task2 implements Runnable {

    private int id;
    private DelayQueue<Event2> q;

    public Task2(int id, DelayQueue<Event2> q) {
        this.id = id;
        this.q = q;
    }

    @Override
    public void run() {
        Date now = new Date();
        Date startDate = new Date();
        startDate.setTime(now.getTime() + (1000)*id);
        System.out.printf("Thread %s: delay events till %s\n", id, startDate);
        for (int i = 0; i < 100; i++) {
            Event2 event = new Event2(startDate);
            q.add(event);
        }
    }
}
