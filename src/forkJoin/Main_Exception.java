package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 22.05.2016.
 */
public class Main_Exception {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int array[] = new int[100];
        Task2 task = new Task2(array, 0, 100);
        pool.execute(task);
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (task.isCompletedAbnormally()) {
            System.out.printf("Main: exception while executing high level task: %s\n",  task.getException());
        }
        System.out.printf("Main: result %d\n", task.join());
    }
}
