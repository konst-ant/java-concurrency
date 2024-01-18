package threadExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 19.05.2016.
 * Chapter4: Controlling a task finishing in an executor
 */
public class Main_FutureTask {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        MyFutureTask[] futures = new MyFutureTask[10];

        for (int i = 0; i < futures.length; i++) {
            CallableTask task = new CallableTask("Task" + i);
            MyFutureTask future = new MyFutureTask(task);
            futures[i] = future;
            executor.submit(future);
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // cancel all tasks through futures
        for (int i = 0; i < futures.length; i++) {
            futures[i].cancel(true);
        }

        for (int i = 0; i < futures.length; i++) {
            try {
                if (!futures[i].isCancelled()) {
                    System.out.printf("%s\n", futures[i].get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e. printStackTrace();
            }
        }
        executor.shutdown();
    }
}

