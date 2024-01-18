package threads;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by KAntipin on 08.04.2016.
 */
public class ThreadLocalSafeTask implements Runnable{

    private ThreadLocal<Date> date;

    ThreadLocalSafeTask() {
        date = new ThreadLocal<Date>() {
            @Override
            protected Date initialValue() {
                return new Date();
            }
        };
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " started: " + date.get());
        try {
            TimeUnit.SECONDS.sleep(Math.round(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getId() + " finished: " + date.get());
    }
}
