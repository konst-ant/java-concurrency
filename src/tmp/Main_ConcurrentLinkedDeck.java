package tmp;

import concurrentCollections.AddTask;
import concurrentCollections.PollTask;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by kantipin on 23.05.2016.
 */
public class Main_ConcurrentLinkedDeck {
    public static void main(String[] args) {
        ConcurrentLinkedDeque deck = new ConcurrentLinkedDeque();
        Thread threads[] = new Thread[100];
        for (int i = 0; i < 100; i++) {
            concurrentCollections.AddTask task = new AddTask(deck);
            Thread thread= new Thread(task);
            threads[i]= thread;
            thread.start();
        }
        System.out.printf("Main: Started %d AddTask threads. Size of deck %d\n", threads.length, deck.size());

        for (int i = 0; i <threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: size of deck after end of AddTasks %d\n", deck.size());

        for (int i = 0; i < 100; i++) {
            concurrentCollections.PollTask task = new PollTask(deck);
            Thread thread= new Thread(task);
            threads[i]= thread;
            thread.start();
        }
        System.out.printf("Main: Started %d PollTask threads. Size of deck %d\n", threads.length, deck.size());

        for (int i = 0; i <threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: size of deck after end of PollTasks %d\n", deck.size());
        System.out.printf("Main: finished.\n");
    }
}
