package forkJoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 23.05.2016.
 */
public class SearchNumberTask extends RecursiveTask<Integer>{

    private int numbers[];
    private int searchNumber;
    private int start;
    private int end;
    private TaskManager manager;
    private final static int NOT_FOUND = -1;

    public SearchNumberTask(int[] numbers, int searchNumber, int start, int end, TaskManager manager) {
        this.numbers = numbers;
        this.searchNumber = searchNumber;
        this.start = start;
        this.end = end;
        this.manager = manager;
    }

    @Override
    protected Integer compute() {
        int result=0;
        if (end - start < 10) {
            result = doSearchNumber();
        } else {
            result = forkTasks();
        }
        return result;
    }

    private int doSearchNumber() {
        for (int i = start; i < end; i++) {
            if (numbers[i] == searchNumber) {
                System.out.printf("SearchNumberTask: number(%s) found in position %d. Cancelling all other tasks.\n",
                        searchNumber, i);
                manager.cancelTasks(this);
                return numbers[i];
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return NOT_FOUND;
    }

    private int forkTasks() {
        int result=0;
        int middle = (start + end)/2;
        SearchNumberTask task1 = new SearchNumberTask(numbers, searchNumber, start, middle+1, manager);
        SearchNumberTask task2 = new SearchNumberTask(numbers, searchNumber, middle+1, end, manager);

        manager.addTask(task1);
        manager.addTask(task2);

        task1.fork();
        task2.fork();

        result = task1.join();
        if (result != NOT_FOUND) {
            return result;
        }

        result = task2.join();
        return result;
    }

    public void writeCancelMessage() {
        System.out.printf("SearchNumberTask: canceled task from %d to %d\n", start, end);
    }
}
