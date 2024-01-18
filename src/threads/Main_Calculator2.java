package threads;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by KAntipin on 02.03.2016.
 */
public class Main_Calculator2 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];

        // create output facilities
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("c:\\home\\myprojects\\concurrency\\calculator_output.txt"));
        } catch (IOException e ) {}

        // create thread objects
        for (int i=0; i<10; i++) {
            threads[i] = new Thread(new Calculator(i));
        }

        // set thread priorities
        for (int i=0; i<10; i++) {
            if (i%2 == 1) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }

        // init states
        for (int i=0; i<10; i++) {
            states[i] = threads[i].getState();
            pw.println("Main: state of Thread " + i + " is " + threads[i].getState());
        }

        // run threads
        for (int i=0; i<10; i++) {
            threads[i].start();
        }

        // write changed thread states until all threads complete
        boolean complete = false;
        while (!complete) {
            complete = true;
            for (int i=0; i<10; i++) {
                if (threads[i].getState() != states[i]) {
                    writeThreadInfo(pw, states[i], threads[i]);
                }
                states[i] = threads[i].getState();
                complete = complete && (threads[i].getState() == Thread.State.TERMINATED);
            }
        }

        pw.close();
    }

    private static void writeThreadInfo(PrintWriter pw, Thread.State oldState, Thread thread) {
        pw.println("Id \t\t" + thread.getId());
        pw.println("Name \t\t" + thread.getName());
        pw.println("Priority \t\t" + thread.getPriority());
        pw.println("Old state \t\t" + oldState);
        pw.println("New state \t\t" + thread.getState());
        pw.println("===================================");
    }
}
