package forkJoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 22.05.2016.
 */
public class Task2 extends RecursiveTask<Integer> {

    private int array[];
    int start;
    int end;

    public Task2(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start < 10) {
            if (end>3 && start <3) {
                throw new RuntimeException("This task has thrown exception from " + start + " to " + end);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            int middle = (start + end)/2;
            Task2 task1 = new Task2(array, start, middle+1);
            Task2 task2 = new Task2(array, middle+1, end);
            invokeAll(task1, task2);
        }
        System.out.printf("Task end from %d to %d\n", start, end);
        return 0;
    }
}
