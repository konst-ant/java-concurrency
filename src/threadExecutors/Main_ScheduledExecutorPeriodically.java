package threadExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 19.05.2016.
 */
public class Main_ScheduledExecutorPeriodically {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        Task4 task = new Task4("Task");

        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 3, 2, TimeUnit.SECONDS);

        for (int i = 0; i < 20; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.printf("Main: time to next start %s\n", result.getDelay(TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.printf("Main executor shutdown\n");

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main finished\n");

    }
}
