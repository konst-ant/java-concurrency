package threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 09.04.2016.
 */
public class Main_ThreadGroup {
    private static int numberOfThreads = 5;

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroupTasks");
        Result result = new Result();
        ThreadGroupTask task = new ThreadGroupTask(result);
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(threadGroup, task);
            thread.start();
        }

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        System.out.println("Currently in thread group:");
        // prints out thread info to stdout
        threadGroup.list();
        waitThreadFinish(threadGroup);
        System.out.println("One thread left the group: " + result.getName());
        threadGroup.interrupt();
    }

    private static void waitThreadFinish(ThreadGroup group) {
        while (group.activeCount() == numberOfThreads) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
