package threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by KAntipin on 06.04.2016.
 */
public class LongThreadSleepTask implements Runnable{

    @Override
    public void run() {
        String myName = Thread.currentThread().getName();
        System.out.println(myName + " - I'm going to sleep for 6 seconds");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println(myName + "I'm interrupted");
        }
        System.out.printf("%s - I'm done\n", myName);
    }
}
