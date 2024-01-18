package threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by KAntipin on 06.04.2016.
 */
public class Main_ThreadSleep {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadSleepTask(10));
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        thread.interrupt();
    }
}
