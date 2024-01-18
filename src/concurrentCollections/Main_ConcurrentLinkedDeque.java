package concurrentCollections;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by kantipin on 02.06.2016.
 */
public class Main_ConcurrentLinkedDeque {
    public static void main(String[] args) {
        ConcurrentLinkedDeque list = new ConcurrentLinkedDeque();
        Thread[] threads = new Thread[100];
        PollTask pollTask = new PollTask(list);

        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Filled ConcurrentLinkedDeque concurrently with %d threads, size: %d\n", threads.length, list.size());

        for (int i = 0; i < threads.length; i++) {
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Polled concurrently with %d threads ConcurrentLinkedDeque, size: %d\n", threads.length, list.size());
        System.out.printf("Finally trying to poll() and remove() on empty deque \n");
        System.out.printf("poll() result: ");
        System.out.printf("%s\n", list.poll());
        System.out.printf("remove() result: ");
        System.out.printf("%s\n", list.remove());
    }
}
