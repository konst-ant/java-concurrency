package threadExecutors;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kantipin on 18.05.2016.
 */
public class Main_Callable2 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        List<Task2> tasks = new ArrayList<>();
        List<Future<Result>> resultList = null;

        for (int i = 0; i < 3; i++) {
            Task2 task = new Task2("Task"+i);
            tasks.add(task);
        }

        try {
            // Note: Executor's invokeAll is blocking (synch) method - it blocks until all tasks get done
            resultList = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < resultList.size(); i++) {
            try {
                Result result= resultList.get(i).get();
                System.out.printf("Task %s result : %d\n", result.getName(), result.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Finished processing.\n");
        executor.shutdown();
    }
}
