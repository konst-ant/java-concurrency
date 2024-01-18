package threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 09.04.2016.
 */
public class ThreadGroupTask implements Runnable {
    private Result result;

    public ThreadGroupTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String myName = Thread.currentThread().getName();
        System.out.println("Thread " + myName + " started");
        doTask();
        result.setName(myName);
        System.out.println("Thread " + myName + " finished");
    }

    void doTask() {
        long t = Math.round(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(t);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s was interrupted in state %s\n", Thread.currentThread().getName(), Thread
                    .currentThread().getState().toString());
        }
    }
}
