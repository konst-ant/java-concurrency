package threadSyncUtils;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 16.05.2016.
 */
public class Student implements Runnable{
    private Phaser phaser;

    public Student(Phaser phaser) {
        this.phaser = phaser;
    }


    @Override
    public void run() {
        System.out.printf("%s: arrived and going to pass exam\n", Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();

        for (int i=1; i<4; i++) {
            makeExercise(i);
            System.out.printf("%s: done with exercise %d\n", Thread.currentThread().getName(), i);
            if (i==3)
                System.out.printf("%s: finished the exam\n", Thread.currentThread().getName());
            phaser.arriveAndAwaitAdvance();
        }
    }

    private void makeExercise(int exercise) {
        long duration = (long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
