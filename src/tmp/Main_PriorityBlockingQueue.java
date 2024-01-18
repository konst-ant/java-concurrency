package tmp;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by kantipin on 24.05.2016.
 */
public class Main_PriorityBlockingQueue {
    public static void main(String[] args) {
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue();
        Thread threads[] = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            Task task = new Task("Thread" +i, queue);
            threads[i] = new Thread(task);
            threads[i].setName("Thread" +i);
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

        // print out queue in priority order
        for (int i = 0; i < 5000; i++) {
            Event e = queue.poll();
            // Note: alternatively take() the same as poll() but blocking on empty queue
            //queue.take()
            System.out.printf("Thread: %s, Event priority: %d\n", e.getThreadName(), e.getPriority());
        }
        System.out.printf("Queue size: %d\n", queue.size());
        System.out.printf("Main: finished.\n");
    }
}
