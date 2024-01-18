package threadExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kantipin on 20.05.2016.
 */
public class Main_Rejected {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        RejectedTaskController controller = new RejectedTaskController();
        executor.setRejectedExecutionHandler(controller);

        for (int i = 0; i < 5; i++) {
            Task6 task = new Task6("Task" + i);
            executor.submit(task);
        }

        System.out.printf("Main: Shutting down executor\n");
        executor.shutdown();

        System.out.printf("Main: Sending another task\n");
        Task6 task = new Task6("RejectedTask");
        executor.submit(task);
        System.out.printf("Main end.\n");
    }
}
