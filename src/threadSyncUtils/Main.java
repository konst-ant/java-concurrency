package threadSyncUtils;

import java.util.concurrent.Phaser;

/**
 * Created by kantipin on 16.05.2016.
 */
public class Main {
    private static final int NUM_STUDENTS = 5;

    public static void main(String[] args) {
        Phaser phaser = new MyPhaser();
        Student[] students = new Student[NUM_STUDENTS];
        Thread[] threads = new Thread[NUM_STUDENTS];

        // create and register 5 students
        for (int i=0; i<students.length; i++) {
            students[i] = new Student(phaser);
            phaser.register();
        }

        // start exam execution
        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(students[i]);
            threads[i].start();
        }

        // wait till exam completes
        for (int i=0; i<threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: phaser has finished, terminated: %s\n", phaser.isTerminated());
    }
}
