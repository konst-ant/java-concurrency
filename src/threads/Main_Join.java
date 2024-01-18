package threads;

/**
 * Created by KAntipin on 06.04.2016.
 */
public class Main_Join {
    public static void main(String[] args) {
        Thread task1 = new Thread(new ThreadSleepTask(10));
        Thread task2 = new Thread(new LongThreadSleepTask());

        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            System.out.println("Main was interrupted");
        }

    }
}
