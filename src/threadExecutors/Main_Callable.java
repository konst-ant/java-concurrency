package threadExecutors;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by kantipin on 18.05.2016.
 */
public class Main_Callable {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            FactorialCalculator calculator = new FactorialCalculator((int)(Math.random()*10));
            Future<Integer> result;
            result = executor.submit(calculator);
            results.add(result);
        }

        System.out.printf("Main: %d tasks complete\n", executor.getCompletedTaskCount());

        do {
            System.out.printf("Main: waiting till all results are complete\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < results.size(); i++) {
                Future<Integer> result = results.get(i);
                System.out.printf("Main: result %d is complete: %s\n", i, result.isDone());
            }
        } while (executor.getCompletedTaskCount() < results.size());

        for (int i = 0; i < results.size(); i++) {
            Future<Integer> result = results.get(i);
            try {
                System.out.printf("Main: result %d : %d\n", i, result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
