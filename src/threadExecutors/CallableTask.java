package threadExecutors;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by kantipin on 19.05.2016.
 */
public class CallableTask implements Callable<String> {

    String name;

    public String getName() {
        return name;
    }

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        long duration = (new Random()).nextInt(10);

        try {
            Thread.currentThread().sleep(duration*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, world! I am task" + name;
    }
}
