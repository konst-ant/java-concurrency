package tmp;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 25.05.2016.
 */
public class Main_DelayQueue {
    public static void main(String[] args) {
        DelayQueue<Event2> queue = new DelayQueue();
        Thread threads[] =  new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            Task2 task = new Task2(i+1, queue);
            threads[i] = new Thread(task);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        do {
            int counter =0;
            Event2 event;
            do {
                event = queue.poll();
                if (event != null) {
                    counter++;
                }
            } while (event != null);
            System.out.printf("Main: at time %s was read from queue %d events\n", new Date(), counter);
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (queue.size() > 0);
        System.out.printf("Main: finished.\n");
    }
}
