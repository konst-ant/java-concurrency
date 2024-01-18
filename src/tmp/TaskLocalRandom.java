package tmp;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by kantipin on 27.05.2016.
 */
public class TaskLocalRandom implements Runnable {

    public TaskLocalRandom() {
        ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s next random number %d\n", Thread.currentThread().getName(), ThreadLocalRandom.current().nextInt(10));
        }
    }
}
