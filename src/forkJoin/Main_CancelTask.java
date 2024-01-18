package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 23.05.2016.
 */
public class Main_CancelTask {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int data[] = ArrayGenerator.generateArray(100);
        TaskManager manager = new TaskManager();

        SearchNumberTask task = new SearchNumberTask(data, 3, 0, 100, manager);
        System.out.printf("Main: starting task execution for array size 1000, searching number 3.\n");
        pool.execute(task);

        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: finished.\n");
    }
}
