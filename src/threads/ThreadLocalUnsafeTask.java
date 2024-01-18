package threads;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by KAntipin on 08.04.2016.
 */
public class ThreadLocalUnsafeTask implements Runnable{

    private Date date;

    @Override
    public void run() {
        date = new Date();
        System.out.println("Thread " + Thread.currentThread().getId() + " started: " + date);
        try {
            TimeUnit.SECONDS.sleep(Math.round(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getId() + " finished: " + date);
    }
}
