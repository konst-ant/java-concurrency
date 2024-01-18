package threadSyncUtils;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 21.04.2016.
 */
public class PrintQueue {

    Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    public void printJob(Object document, int number) {
        try {
            semaphore.acquire();
            Random random = new Random();
            int seconds = random.nextInt(10);
            System.out.printf("PrintQueue: printing job number %d (%d seconds)\n", number, seconds);
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

}
