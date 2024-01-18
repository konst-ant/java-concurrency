package threads;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by KAntipin on 06.04.2016.
 */

public class ThreadSleepTask implements Runnable {

    int secondsToSleep;

    public ThreadSleepTask(int secondsToSleep) {
        this.secondsToSleep = secondsToSleep;
    }

    @Override
    public void run() {
        String myName = Thread.currentThread().getName();
        for (int i = 0; i < secondsToSleep; i++) {
            System.out.printf("%s - Current date %s\n", myName, new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                return;
            }
        }
        System.out.printf("%s - I'm done\n", myName);
    }
}
