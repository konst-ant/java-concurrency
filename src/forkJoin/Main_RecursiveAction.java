package forkJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 21.05.2016.
 */
public class Main_RecursiveAction {
    public static void main(String[] args) {
        List<Product> products = ProductListGenerator.generate(10000);
        Task task = new Task(products, 0, products.size(), 0.20);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        // control execution
        do {
            System.out.printf("Main : thread count: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main : thread steal: %d\n", pool.getStealCount());
            System.out.printf("Main : parallelism: %d\n", pool.getParallelism());
            try {
                TimeUnit.MICROSECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();

        // check all product prices updated correctly
        if (task.isCompletedNormally()) {
            System.out.printf("The task has completed normally\n");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.printf("product %s has no price updated\n", product.getName());
            }
        }

        System.out.printf("Main finish.\n");
    }
}
