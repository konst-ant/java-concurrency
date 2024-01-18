package tmp;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by kantipin on 24.05.2016.
 */
public class Task implements Runnable {

    private String threadName;
    PriorityBlockingQueue<Event> queue;

    public Task(String threadName, PriorityBlockingQueue queue) {
        this.threadName = threadName;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Event e = new Event(i,threadName);
            // Note : PriorityBlockingQueue is unbounded, so no blocking on put() ever happens
            queue.put(e);
        }
    }
}
