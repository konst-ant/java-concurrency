package threads;

import java.util.Random;

/**
 * Created by kantipin on 11.04.2016.
 */
public class UncaughtExceptionThreadGroupTask implements Runnable{
    @Override
    public void run() {
        Random rand = new Random(Thread.currentThread().getId());
        int v=0;
        int count=0;
        while (true) {
            int denominator = (int)(rand.nextDouble()*1000);
            if (count++ > 1000) {
                denominator = 0;
            }
            v = (int)(1000/denominator);
            System.out.printf("Thread %s generated %d\n", Thread.currentThread().getId(), v);
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("Thread %s was interrupted. Finishing\n", Thread.currentThread().getId());
                break;
            }
        }

    }
}
