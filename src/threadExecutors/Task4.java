package threadExecutors;

import java.util.Date;

/**
 * Created by kantipin on 19.05.2016.
 */
public class Task4 implements Runnable {

    String name;

    public Task4(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("Task %s: start execution at %s\n", name, new Date());
    }
}
