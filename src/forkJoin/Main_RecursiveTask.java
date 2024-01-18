package forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 22.05.2016.
 */
public class Main_RecursiveTask {
    public static void main(String[] args) {
        String[][] mockMatrix = Document.generateDocument(100, 1000, "three");
        DocumentTask highTask = new DocumentTask(mockMatrix, 0, 100, "three");
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(highTask);

        while (!highTask.isDone()) {
            System.out.printf("Main: Active threads : %s\n", pool.getActiveThreadCount());
            System.out.printf("Main: Steal : %s\n", pool.getStealCount());
            System.out.printf("Main: Queued tasks : %s\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Pool size : %s\n", pool.getPoolSize());
            System.out.printf("Main: Parallelism: %s\n", pool.getParallelism());
            System.out.printf("Main: Threads : %s\n", pool.getRunningThreadCount());
            System.out.printf("---------------------------------------------------\n");

            try {
                Thread.currentThread().sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("Search word (three) appears in matrix %d times\n", highTask.get());
        } catch (InterruptedException| ExecutionException e) {
            e.printStackTrace();
        }
    }
}
