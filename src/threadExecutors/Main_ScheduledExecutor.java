package threadExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 19.05.2016.
 */
public class Main_ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 3; i++) {
            Task3 task = new Task3("Task" + i);
            System.out.printf("Main : scheduling task Task%d for execution\n", i);
            executor.schedule(task, i, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main : finished\n");
    }
}
