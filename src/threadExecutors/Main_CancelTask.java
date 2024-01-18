package threadExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kantipin on 19.05.2016.
 */
public class Main_CancelTask {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        Task5 task = new Task5();
        Future<String> result = executor.submit(task);

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: cancelling task\n");
        result.cancel(true);
        System.out.printf("Main: task canceled: %s\n", result.isCancelled());
        System.out.printf("Main: task done %s\n", result.isDone());

        System.out.printf("Main: executor shutting down\n");
        executor.shutdown();


    }
}
