package forkJoin;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 22.05.2016.
 */
public class Main_FolderProcessor {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor system = new FolderProcessor("c:\\home", "txt");
        FolderProcessor app = new FolderProcessor("c:\\program files", "txt");
        FolderProcessor docs = new FolderProcessor("c:\\documents and settings", "txt");

        pool.execute(system);
        pool.execute(app);
        pool.execute(docs);

        do {
            System.out.printf("Main: active thread count %s\n", pool.getActiveThreadCount());
            System.out.printf("Main: parallelism %s\n", pool.getParallelism());
            System.out.printf("Main: pool size %s\n", pool.getPoolSize());
            System.out.printf("Main: queued tasks %s\n", pool.getQueuedTaskCount());
            System.out.printf("Main: steals %s\n", pool.getStealCount());
            System.out.printf("--------------------------------------\n");

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((!system.isDone()) || (!app.isDone()) || (!docs.isDone()));

        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // join results
        List<String> results;

        results = system.join();
        System.out.printf("Main: system returned %d matches\n", results.size());
        sortAndprintResults(results);

        results = app.join();
        System.out.printf("Main: app returned %d matches\n", results.size());
        sortAndprintResults(results);

        results = docs.join();
        System.out.printf("Main: docs returned %d matches\n", results.size());
        sortAndprintResults(results);

    }

    private static void sortAndprintResults(List<String> results) {
        Collections.sort(results);
        for (String r : results) {
            System.out.printf("Main: %s\n", r);
        }
    }
}
