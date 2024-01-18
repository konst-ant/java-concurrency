package threadExecutors;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 19.05.2016.
 */
public class Task3 implements Callable<String> {
    String name;

    public Task3(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        System.out.printf("Task %s: start executing task at time %s\n", name, new
                Date());
        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
        System.out.printf("Task %s: done\n", name);
        return "Hello, world!";
    }
}
