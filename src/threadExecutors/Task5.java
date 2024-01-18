package threadExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 19.05.2016.
 */
public class Task5 implements Callable<String> {
    @Override
    public String call() throws Exception {
        while (true) {
            System.out.printf("Task: Hi there, the task is executring\n");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
