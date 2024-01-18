package threadExecutors;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 17.05.2016.
 */
public class Task implements Runnable {

    String name;
    Date initDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task (String name) {
        this.name = name;
        this.initDate = new Date();
    }

    @Override
    public void run() {
        System.out.printf("%s : Task %s : created on %s\n", Thread.currentThread().getId(), getName(), initDate);
        System.out.printf("%s : Task %s : started on %s\n", Thread.currentThread().getId(), getName(), new Date());

        long duration = (long)(Math.random()*10);
        try {
            System.out.printf("%s : Task %s : doing a taks with duration %d\n", Thread.currentThread().getId(),
                    getName(), duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s : Task %s : finished on %s\n", Thread.currentThread().getId(), getName(), new Date());
    }
}
